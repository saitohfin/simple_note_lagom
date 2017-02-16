package com.javi.note.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.javi.lagom.test.note.api.Note;
import com.lightbend.lagom.serialization.CompressedJsonable;

import javax.annotation.concurrent.Immutable;

@SuppressWarnings("serial")
@Immutable
@JsonDeserialize
public final class NoteState implements CompressedJsonable{

    public final Note note;

    public NoteState(Note note){
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteState noteState = (NoteState) o;

        return note != null ? note.equals(noteState.note) : noteState.note == null;
    }

    @Override
    public int hashCode() {
        return note != null ? note.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NoteState{" +
                "note=" + note +
                '}';
    }
}
