package br.com.rui.efficient.jpa.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MusicId implements Serializable {
    private String name;
    private int coastSeconds;

    @Deprecated
    public MusicId() {
    }

    public MusicId(String name, int coastSeconds) {
        this.name = name;
        this.coastSeconds = coastSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicId musicId = (MusicId) o;
        return coastSeconds == musicId.coastSeconds && Objects.equals(name, musicId.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coastSeconds);
    }
}
