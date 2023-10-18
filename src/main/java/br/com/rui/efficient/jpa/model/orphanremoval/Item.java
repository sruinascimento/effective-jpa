package br.com.rui.efficient.jpa.model.orphanremoval;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Deprecated
    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
