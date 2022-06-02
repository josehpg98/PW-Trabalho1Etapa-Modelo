/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.modelo.testes;

import br.edu.ifsul.modelo.Corretor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author joseh
 */
public class TestePersistirCorretor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeguradoraModelPU");
        EntityManager em = emf.createEntityManager();
        Corretor c = new Corretor();
        c.setNome("Jose Henrique");
        c.setCpf("999.888.333-11");
        c.setRg("1234567890");
        c.setEmail("josecorretor@gmail.com");
        c.setTelefone("(54)99234-2233");
        c.setPercentualComissao(15.0);
        c.setNomeUsuario("jose98");
        c.setSenha("123456");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit(); 
        em.close();
        emf.close();
    }
    
}
