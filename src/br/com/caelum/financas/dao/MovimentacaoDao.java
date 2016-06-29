package br.com.caelum.financas.dao;

import br.com.caelum.financas.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Created by Faqtt0 on 29/06/2016.
 */
public class MovimentacaoDao {
    private EntityManager manager;

    public MovimentacaoDao(EntityManager manager) {
        this.manager = manager;
    }

    public Double mediaDaConta(Conta conta) {

        TypedQuery<Double> query = manager.createQuery(
                "select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                        + " and m.tipoMovimentacao = 'SAIDA'", Double.class);

        query.setParameter("pConta", conta);

        return query.getSingleResult();
    }

    public Long totalDeMovimentacoes(Conta conta) {

        TypedQuery<Long> query = manager.createNamedQuery("totalDeMovimentacoes", Long.class);
        query.setParameter("pConta", conta);

        return query.getSingleResult();
    }

}
