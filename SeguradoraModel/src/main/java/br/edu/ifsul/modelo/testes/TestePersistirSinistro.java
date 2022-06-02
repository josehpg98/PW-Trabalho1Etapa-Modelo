/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.modelo.testes;


import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.modelo.Sinistro;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author joseh
 */
public class TestePersistirSinistro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeguradoraModelPU");
        EntityManager em = emf.createEntityManager();
        Seguro s = em.find(Seguro.class, 1);
        Sinistro si = new Sinistro();
        si.setDescricao("Roubo/Furto");
        ///Formato da data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataI = Calendar.getInstance();
        dataI.set(Calendar.YEAR, 2022);
        dataI.set(Calendar.MONTH, 6);
        dataI.set(Calendar.DAY_OF_MONTH, 20);
        si.setData(dataI);
        si.setCidade("Soledade");
        si.setEstado("RS");
        s.adicionarSinistro(si);
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
