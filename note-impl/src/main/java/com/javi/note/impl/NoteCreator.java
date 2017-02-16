package com.javi.note.impl;

import akka.Done;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.javi.lagom.test.note.api.Note;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;

import javax.annotation.concurrent.Immutable;

@SuppressWarnings("serial")
@Immutable
@JsonDeserialize
public class NoteCreator implements NoteCommand, PersistentEntity.ReplyType<Done> {

    public final Note note;

    @JsonCreator
    public NoteCreator(Note note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteCreator that = (NoteCreator) o;

        return note != null ? note.equals(that.note) : that.note == null;
    }

    @Override
    public int hashCode() {
        return note != null ? note.hashCode() : 0;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("NoteCreator").add("note", note.toString()).toString();
    }
}
