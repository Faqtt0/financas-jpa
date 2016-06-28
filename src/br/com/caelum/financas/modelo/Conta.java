package br.com.caelum.financas.modelo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Faqtt0 on 24/06/2016.
 */
@Entity
public  class Conta {
    //Id identifica primaky key @G..V.. Indica como será a geração do código da chave.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titular;
    private String numero;
    private String banco;
    private String agencia;
    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
