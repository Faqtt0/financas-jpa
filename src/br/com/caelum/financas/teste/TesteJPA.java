package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Faqtt0 on 24/06/2016.
 */
public class TesteJPA {
    public static void main(String[] args) {
        /*
        Conta conta = new Conta();
        conta.setTitular("Joao Ferreira");
        conta.setBanco("HSBC");
        conta.setNumero("123456");
        conta.setAgencia("321"); */

        Conta conta = new Conta();
        conta.setId(4);
        conta.setTitular("Mario Santos");
        conta.setBanco("Itau");
        conta.setNumero("54321");
        conta.setAgencia("3344");

        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("financas");
        EntityManager manager = new JPAUtil().getEntityManager();
        /*
        double inicio = System.currentTimeMillis();
        manager.getTransaction().begin();
        manager.persist(conta);
        manager.getTransaction().commit();
        manager.close();
        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");*/

        manager.getTransaction().begin();
        Conta contaRemover = manager.find(Conta.class, 4);
        manager.remove(contaRemover);

        /*
        manager.getTransaction().begin();
        //carregar conta = classe + valor chave
        Conta conta = manager.find(Conta.class, 8);
        System.out.println(conta.getTitular());
        //update conta
        conta.setTitular("Pedro Ferreira"); */

        manager.getTransaction().commit();
        manager.close();


    }
}
