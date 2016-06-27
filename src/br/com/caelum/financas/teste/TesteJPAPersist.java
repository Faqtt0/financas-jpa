package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by Faqtt0 on 27/06/2016.
 */
public class TesteJPAPersist {
    public static void main(String[] args) {
        //Utilizado para controle manual de transação de banco
        Conta conta = new Conta();
        conta.setTitular("Fabio Almeida");
        conta.setBanco("HSBC");
        conta.setNumero("123456");
        conta.setAgencia("324");

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        //Indica a inserção  no banco
        manager.persist(conta);
        //Após o persist qualquer transação feita antes de finalizar
        //Ficará da mesma forma que a Classe SelecaoUpdate
        //Ou seja, de forma automática
        //No caso abaixo após o insert no persist irá gerar um update
        conta.setTitular("Mario Santos");
        System.out.println(conta.getId());

        manager.getTransaction().commit();
        manager.close();
    }
}
