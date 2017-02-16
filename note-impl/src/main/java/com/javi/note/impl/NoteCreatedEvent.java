package com.javi.note.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.javi.lagom.test.note.api.Note;

import javax.annotation.concurrent.Immutable;

@SuppressWarnings("serial")
@Immutable
@JsonDeserialize
public class NoteCreatedEvent implements NoteEvent {

    public Note note;

    @JsonCreator
    public NoteCreatedEvent(Note note){
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteCreatedEvent that = (NoteCreatedEvent) o;

        return note != null ? note.equals(that.note) : that.note == null;
    }

    @Override
    public int hashCode() {
        return note != null ? note.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NoteCreatedEvent{" +
                "note=" + note +
                '}';
    }
}
