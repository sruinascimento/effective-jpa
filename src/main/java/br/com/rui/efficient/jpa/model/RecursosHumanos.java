package br.com.rui.efficient.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class RecursosHumanos extends Departamento{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    public RecursosHumanos(String nome) {
        super(nome);
    }

    @Deprecated
    public RecursosHumanos() {

    }

    @Override
    public void calcularDespesasDoMes() {
        System.out.println("Calculando despesas do mês de RH");
    }

}
