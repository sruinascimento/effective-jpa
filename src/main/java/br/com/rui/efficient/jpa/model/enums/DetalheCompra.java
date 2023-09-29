package br.com.rui.efficient.jpa.model.enums;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class DetalheCompra {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PapelUsuario papelUsuario;
    @Enumerated(EnumType.STRING)
    private StatusCompra statusCompra;

    @Deprecated
    public DetalheCompra() {
    }

    public DetalheCompra(PapelUsuario papelUsuario, StatusCompra statusCompra) {
        this.papelUsuario = papelUsuario;
        this.statusCompra = statusCompra;
    }

    public Long getId() {
        return id;
    }

    public PapelUsuario getPapelUsuario() {
        return papelUsuario;
    }

    public StatusCompra getStatusCompra() {
        return statusCompra;
    }

    @Override
    public String toString() {
        return "DetalheCompra{" +
                "id=" + id +
                ", papelUsuario=" + papelUsuario +
                ", statusCompra=" + statusCompra +
                '}';
    }
}
