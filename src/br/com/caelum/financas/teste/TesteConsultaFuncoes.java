package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Faqtt0 on 28/06/2016.
 */
public class TesteConsultaFuncoes {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(3);
        TypedQuery<BigDecimal> query = manager.createQuery("SELECT SUM (m.valor) FROM Movimentacao m WHERE m.conta.id =:pConta " +
                "AND m.tipoMovimentacao = :pTipo " +
                "ORDER BY m.valor DESC", BigDecimal.class);

        query.setParameter("pConta", conta.getId());
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        BigDecimal soma =  query.getSingleResult();
        System.out.println(soma);
    }
}
