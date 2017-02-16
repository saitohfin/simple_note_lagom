package com.javi.note.impl;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.javi.lagom.test.note.api.Note;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;

import javax.annotation.concurrent.Immutable;

@SuppressWarnings("serial")
@Immutable
@JsonDeserialize
public class getNoteCommand implements NoteCommand, PersistentEntity.ReplyType<Note> {

    private final String title;

    @JsonCreator
    public getNoteCommand(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        getNoteCommand that = (getNoteCommand) o;

        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "getNoteCommand{" +
                "title='" + title + '\'' +
                '}';
    }
}
