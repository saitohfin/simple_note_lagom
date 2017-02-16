package com.javi.note.impl;

import akka.Done;
import com.google.inject.Inject;
import com.javi.lagom.test.note.api.Note;
import com.javi.lagom.test.note.api.NoteService;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;

public class NoteServiceImpl implements NoteService {

    private final PersistentEntityRegistry persistentEntityRegistry;

    @Inject
    public NoteServiceImpl(PersistentEntityRegistry persistentEntityRegistry){
        this.persistentEntityRegistry = persistentEntityRegistry;
        this.persistentEntityRegistry.register(NoteEntity.class);
    }

    @Override
    public ServiceCall<Note, Done> createNote() {
        return request -> {
            PersistentEntityRef<NoteCommand> ref = persistentEntityRegistry.refFor(NoteEntity.class, request.title);
            return ref.ask(new NoteCreator(request));
        };
    }
}
