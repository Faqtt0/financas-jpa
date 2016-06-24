package br.com.caelum.financas.teste;

import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by Faqtt0 on 24/06/2016.
 */
public class TesteEstadosJPA {
    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        // Testes do capitulo

        manager.getTransaction().commit();

        manager.close();

    }
}
