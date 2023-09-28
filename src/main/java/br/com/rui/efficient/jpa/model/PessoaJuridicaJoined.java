package br.com.rui.efficient.jpa.model;

import jakarta.persistence.Entity;

@Entity
public class PessoaJuridicaJoined extends PessoaJoined{
    private String cnpj;

    @Deprecated
    public PessoaJuridicaJoined() {
    }

    public PessoaJuridicaJoined(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "PessoaJuridicaJoined{" +
                "cnpj='" + cnpj + '\'' +
                ", id=" + super.getId()+
                ", nome='" + super.getNome() + '\'' +
                '}';
    }
}
