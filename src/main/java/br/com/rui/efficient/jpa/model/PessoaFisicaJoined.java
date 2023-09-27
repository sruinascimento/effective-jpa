package br.com.rui.efficient.jpa.model;

import jakarta.persistence.Entity;

@Entity
public class PessoaFisicaJoined extends PessoaJoined{
    private String cpf;

    @Deprecated
    public PessoaFisicaJoined() {
    }

    public PessoaFisicaJoined(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisicaJoined{" +
                "cpf='" + cpf + '\'' +
                ", id=" + super.getId()+
                ", nome='" + super.getNome() + '\'' +
                '}';
    }
}
