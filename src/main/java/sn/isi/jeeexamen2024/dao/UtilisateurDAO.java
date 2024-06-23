package sn.isi.jeeexamen2024.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import entities.Utilisateur;

public class UtilisateurDAO {

    private SessionFactory factory;

    public UtilisateurDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(utilisateur);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}