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
        Conta conta = new Conta();
        conta.setTitular("Joao Ferreira");
        conta.setBanco("HSBC");
        conta.setNumero("123456");
        conta.setAgencia("321");

        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("financas");
        EntityManager manager = new JPAUtil().getEntityManager();

        double inicio = System.currentTimeMillis();
        manager.getTransaction().begin();
        manager.persist(conta);
        manager.getTransaction().commit();
        manager.close();
        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");

    }
}
