/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.modelo.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Seguro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author joseh
 */
public class TestePersistirSeguro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeguradoraModelPU");
        EntityManager em = emf.createEntityManager();
        Seguro s = new Seguro();
        s.setData(Calendar.getInstance());
        ///formata a data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar datainicio = Calendar.getInstance();
        datainicio.set(Calendar.YEAR, 2022);
        datainicio.set(Calendar.MONTH, 6);
        datainicio.set(Calendar.DAY_OF_MONTH, 16);
        s.setInicioVigencia(datainicio);
        Calendar datafim = Calendar.getInstance();
        datafim.set(Calendar.YEAR, 2022);
        datafim.set(Calendar.MONTH, 6);
        datafim.set(Calendar.DAY_OF_MONTH, 18);
        s.setFimVigencia(datafim);
        s.setValorTotal(1200.0);
        s.setValorFipe(1500.0);
        s.setCorretor(em.find(Corretor.class, 1));
        s.setCarro(em.find(Carro.class, 1));
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
       
    }
    
}
