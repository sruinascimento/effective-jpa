package br.com.rui.efficient.jpa.model.onetoone;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class PessoaOneToOne {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id")
    private EnderecoOneToOne endereco;

    @Deprecated
    public PessoaOneToOne() {
    }

    public PessoaOneToOne(String nome) {
        this.nome = nome;
    }

    public PessoaOneToOne(String nome, EnderecoOneToOne endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public EnderecoOneToOne getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoOneToOne endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "PessoaOneToOne{" +
                "id=" + id +
                ", nome='" + nome + '\'';
    }
}