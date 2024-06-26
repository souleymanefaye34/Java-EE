package sn.isi.jeeexamen2024.dao;

import sn.isi.jeeexamen2024.entities.Utilisateur;
import javax.persistence.*;
import java.util.List;

public class UtilisateurDAO {
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("GestionImmeublesPU");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void sauvegarder(EntityManager entityManager, Utilisateur utilisateur) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(utilisateur);
            System.out.println(utilisateur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void mettreAJour(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(utilisateur);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void modifierUtilisateurs(EntityManager entityManager, Utilisateur utilisateur) {
        entityManager.merge(utilisateur);
    }

    public void supprimer(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Utilisateur utilisateur = em.find(Utilisateur.class, id);
            if (utilisateur != null) {
                em.remove(utilisateur);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Utilisateur> listerTous() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Utilisateur trouverParId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Utilisateur.class, id);
        } finally {
            em.close();
        }
    }

    // Méthode pour trouver un utilisateur par email et mot de passe
    public Utilisateur trouverParEmailEtMotDePasse(EntityManager entityManager, String email, String motDePasse) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Utilisateur> query = em.createQuery(
                    "SELECT u FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :motDePasse",
                    Utilisateur.class
            );
            query.setParameter("email", email);
            query.setParameter("motDePasse", motDePasse);

            List<Utilisateur> results = query.getResultList();
            if (results.isEmpty()) {
                return null; // Aucun utilisateur trouvé
            } else if (results.size() == 1) {
                return results.get(0); // Un seul utilisateur trouvé
            } else {
                throw new NonUniqueResultException("Plusieurs utilisateurs trouvés pour l'email et le mot de passe fournis.");
            }
        } finally {
            em.close();
        }
    }
}
