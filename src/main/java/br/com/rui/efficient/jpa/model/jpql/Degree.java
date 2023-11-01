package br.com.rui.efficient.jpa.model.jpql;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "degrees")
public class Degree {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String code;
    @OneToMany(mappedBy = "degree",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true)
    private List<Content> content = new ArrayList<>();

    @Deprecated
    public Degree() {
    }

    public Degree(String name, String code) {
        this.name = name;
        this.code = code;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<Content> getContent() {
        return Collections.unmodifiableList(content);
    }

    public void addContent(Content content) {
        this.content.add(content);
        content.setDegree(this);
    }

    @Override
    public String toString() {
        return "Degree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", content=" + content +
                '}';
    }
}
