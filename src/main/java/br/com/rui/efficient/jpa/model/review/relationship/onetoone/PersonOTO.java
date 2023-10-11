package br.com.rui.efficient.jpa.model.review.relationship.onetoone;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "people")
public class PersonOTO {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "document_number", unique = true)
    private Document document;

    @Deprecated
    public PersonOTO() {
    }

    public PersonOTO(String name, Document document) {
        this.name = name;
        this.document = document;
    }

    public PersonOTO(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Document getDocument() {
        return document;
    }

    public void associateDocument(Document document) {
        this.document = document;
    }
}
