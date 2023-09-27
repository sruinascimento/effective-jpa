package br.com.rui.efficient.jpa.model;

import jakarta.persistence.Entity;

@Entity
public class PessoaFisicaTPC extends PessoaTPC{
    private String cpf;

    @Deprecated
    public PessoaFisicaTPC() {
    }

    public PessoaFisicaTPC(String nome, String cpf) {
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
