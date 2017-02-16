package com.javi.note.impl;

import akka.Done;
import com.javi.lagom.test.note.api.Note;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;

import java.util.Optional;

public class NoteEntity extends PersistentEntity<NoteCommand, NoteEvent, NoteState> {

    @Override
    public Behavior initialBehavior(Optional<NoteState> snapshotState) {
        BehaviorBuilder behaviour = newBehaviorBuilder(snapshotState.orElse(new NoteState(new Note("Empty title", ""))));

        behaviour.setCommandHandler(NoteCreator.class, (cmd, ctx) ->{
            NoteEvent noteCreated = new NoteCreatedEvent(cmd.note);
            return ctx.thenPersist(noteCreated, evt ->{ ctx.reply(Done.getInstance());});
        });

        behaviour.setCommandHandler(NoteModifyDescription.class, (cmd, ctx) ->{
            NoteEvent descriptionModified = new TextModified(cmd.text);
            return ctx.thenPersist(descriptionModified, evt ->{ctx.reply(Done.getInstance());});
        });

        behaviour.setReadOnlyCommandHandler(getNoteCommand.class, (cmd, ctx) ->{
            ctx.reply(state().note);
        });

        behaviour.setEventHandler(NoteCreatedEvent.class, evt -> new NoteState(evt.note));
        behaviour.setEventHandler(TextModified.class, evt -> {
            Note currentNote = state().note;
            return new NoteState(new Note(currentNote.title, evt.text));
        });

        return behaviour.build();
    }
}
