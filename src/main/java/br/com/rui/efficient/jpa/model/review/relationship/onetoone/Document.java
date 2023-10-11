package br.com.rui.efficient.jpa.model.review.relationship.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    private String number;
    @OneToOne(mappedBy = "document")
    private PersonOTO person;

    @Deprecated
    public Document() {
    }

    public Document(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public PersonOTO getPerson() {
        return person;
    }
}
