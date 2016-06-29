package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

/**
 * Created by Faqtt0 on 29/06/2016.
 */
public class TesteConsultaFuncaoMax {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();
        Conta conta = manager.find(Conta.class, 2);
        TypedQuery<BigDecimal> query = manager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);
        query.setParameter("pConta", conta);
        BigDecimal valMax = query.getSingleResult();
        System.out.println(valMax);
    }
}
