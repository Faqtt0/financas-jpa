package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Faqtt0 on 28/06/2016.
 */
public class TesteMovimentacaoConta {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();
        //Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
        //System.out.println("Titular da Conta: " + movimentacao.getConta().getTitular());
       // Conta conta = manager.find(Conta.class, 1);
        //System.out.println(conta.getMovimentacoes().size());
        Query query = manager.createQuery("SELECT c FROM Conta c JOIN fetch c.movimentacoes");
        List<Conta> contas = query.getResultList();
        for (Conta c: contas) {
            System.out.println("\nNumero de movimentações: " + c.getMovimentacoes().size());
        }
    }
}
