package br.com.rui.efficient.jpa.model.orphanremoval;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "menu", orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @Deprecated
    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", item=" + items +
                '}';
    }
}
