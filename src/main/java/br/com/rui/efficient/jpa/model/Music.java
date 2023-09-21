package br.com.rui.efficient.jpa.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;


@Entity

public class Music {
    @EmbeddedId
    private MusicId id;
    private String album;

    public Music() {
    }

    public Music(MusicId id, String album) {
        this.id = id;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", album='" + album + '\'' +
                '}';
    }
}
