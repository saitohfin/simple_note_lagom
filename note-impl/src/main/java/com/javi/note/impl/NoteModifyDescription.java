package com.javi.note.impl;


import akka.Done;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;

import javax.annotation.concurrent.Immutable;

@SuppressWarnings("serial")
@Immutable
@JsonDeserialize
public class NoteModifyDescription implements NoteCommand, PersistentEntity.ReplyType<Done> {

    public final String text;

    @JsonCreator
    public NoteModifyDescription(String description) {
        this.text = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteModifyDescription that = (NoteModifyDescription) o;

        return text != null ? text.equals(that.text) : that.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NoteModifyDescription{" +
                "text='" + text + '\'' +
                '}';
    }
}
