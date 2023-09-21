package br.com.rui.efficient.jpa.model;

import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(orphanRemoval = true, cascade = {PERSIST})
    private SubItem subItem;

    @Deprecated
    public Menu() {
    }

    public Menu(SubItem subItem) {
        this.subItem = subItem;
    }
}
