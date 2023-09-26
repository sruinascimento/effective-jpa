package br.com.rui.efficient.jpa.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa{
    private String cnpj;

    @Deprecated
    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}
