/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.modelo.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author joseh
 */
public class TestePersistirCarro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeguradoraModelPU");
        EntityManager em = emf.createEntityManager();
        Carro c = new Carro();
        c.setPlaca("dal7044");
        c.setRenavam("98424535255");
        c.setModelo("SUV");
        c.setFabricante("Jeep");
        c.setAnoFabricacao(2015);
        c.setAnoModelo(2016);
        c.setPessoa(em.find(Pessoa.class, 3));
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
