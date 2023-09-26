package br.com.rui.efficient.jpa.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Departamento {
    private String nome;

    public Departamento() {
    }

    public Departamento(String nome) {
        this.nome = nome;
    }

    public abstract void calcularDespesasDoMes();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
