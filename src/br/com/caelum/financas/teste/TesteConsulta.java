package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Faqtt0 on 28/06/2016.
 */
public class TesteConsulta {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(1);
        Query query = manager.createQuery("SELECT m FROM Movimentacao m WHERE m.conta.id =:pConta " +
                "AND m.tipoMovimentacao = :pTipo " +
                "ORDER BY m.valor DESC");

        query.setParameter("pConta", conta.getId());
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        List<Movimentacao> movimentacaos = query.getResultList();

        for (Movimentacao m: movimentacaos) {
            System.out.println("\nDescrição...: " + m.getDescricao());
            System.out.println("Valor.........: R$ " + m.getValor());
        }
    }
}
