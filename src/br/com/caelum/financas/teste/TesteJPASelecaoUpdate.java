package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by Faqtt0 on 27/06/2016.
 */
public class TesteJPASelecaoUpdate {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        //Classe mapeada a ser procurada + o número do índice(pk)
        Conta conta = manager.find(Conta.class, 1);

        System.out.println(conta.getTitular());
        //Enquanto não for realizado o close é permitido alterar valores
        //Esses valores são atualizado como formar de update no banco
        //Desde que os valores informados sejam diferentes.
        //Este estado se chama managed
        conta.setTitular("Pedro Ferreira");

        manager.getTransaction().commit();
        manager.close();
    }

}
