package com.javi.note.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.annotation.concurrent.Immutable;

@SuppressWarnings("serial")
@Immutable
@JsonDeserialize
public class TextModified implements NoteEvent {

    public final String text;

    @JsonCreator
    public TextModified(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextModified that = (TextModified) o;

        return text != null ? text.equals(that.text) : that.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TextModified{" +
                "text='" + text + '\'' +
                '}';
    }
}
