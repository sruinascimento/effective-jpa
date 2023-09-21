package br.com.rui.efficient.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class SubItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @Deprecated
    public SubItem() {
    }

    public SubItem(String name) {
        this.name = name;
    }
}
