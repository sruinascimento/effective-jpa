package br.com.rui.efficient.jpa.model.onetomany;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "dono_id")
    private PessoaOneToMany dono;

    @Deprecated
    public Pet() {
    }

    public Pet(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
