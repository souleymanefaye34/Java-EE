package sn.isi.jeeexamen2024.dao;

import sn.isi.jeeexamen2024.entities.Immeuble;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ImmeubleDAO {

    private static final String PERSISTENCE_UNIT_NAME = "GestionImmeublesPU";
    private static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    public List<Immeuble> listeImmeubles() {
        EntityManager entityManager = emFactory.createEntityManager();
        TypedQuery<Immeuble> query = entityManager.createQuery("SELECT i FROM Immeuble i", Immeuble.class);
        List<Immeuble> listeImmeubles = query.getResultList();
        entityManager.close();
        return listeImmeubles;
    }
    public void sauvegarder(Immeuble immeuble) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(immeuble);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void mettreAJour(Immeuble immeuble) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(immeuble);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void supprimer(Immeuble immeuble) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Immeuble toDelete = entityManager.find(Immeuble.class, immeuble.getId());
        if (toDelete != null) {
            entityManager.remove(toDelete);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Immeuble getImmeubleById(int id) {
        EntityManager entityManager = emFactory.createEntityManager();
        try {
            return entityManager.find(Immeuble.class, id);
        } finally {
            entityManager.close();
        }
    }
}