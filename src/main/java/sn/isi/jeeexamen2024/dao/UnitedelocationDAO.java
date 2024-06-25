package sn.isi.jeeexamen2024.dao;

import sn.isi.jeeexamen2024.entities.Unitedelocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UnitedelocationDAO {

    private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("GestionImmeublesPU");

    public void ajouterUnite(Unitedelocation unite) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(unite);
        em.getTransaction().commit();
        em.close();
    }

    public Unitedelocation trouverUnite(int id) {
        EntityManager em = emFactory.createEntityManager();
        Unitedelocation unite = em.find(Unitedelocation.class, id);
        em.close();
        return unite;
    }

    public void mettreAJourUnite(Unitedelocation unite) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(unite);
        em.getTransaction().commit();
        em.close();
    }

    public void supprimerUnite(int id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Unitedelocation unite = em.find(Unitedelocation.class, id);
        if (unite != null) {
            em.remove(unite);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Unitedelocation> listerUnites() {
        EntityManager em = emFactory.createEntityManager();
        TypedQuery<Unitedelocation> query = em.createQuery("SELECT u FROM Unitedelocation u", Unitedelocation.class);
        List<Unitedelocation> unites = query.getResultList();
        em.close();
        return unites;
    }
}
