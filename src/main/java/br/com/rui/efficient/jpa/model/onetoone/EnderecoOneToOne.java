package br.com.rui.efficient.jpa.model.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class EnderecoOneToOne {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    @OneToOne(mappedBy = "endereco")
    private PessoaOneToOne pessoa;

    @Deprecated
    public EnderecoOneToOne() {
    }

    public EnderecoOneToOne(String rua,
                            String numero,
                            String complemento,
                            String bairro,
                            String cidade,
                            String estado) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public PessoaOneToOne getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "EnderecoOneToOne{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
