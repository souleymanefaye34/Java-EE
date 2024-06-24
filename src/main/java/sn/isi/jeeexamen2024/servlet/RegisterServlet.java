package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.UtilisateurDAO;
import sn.isi.jeeexamen2024.entities.Utilisateur;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("GestionImmeublesPU");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EntityManager entityManager = emFactory.createEntityManager();

        // Récupérer les données du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        int roleId = Integer.parseInt(request.getParameter("role_id"));
        String motDePasse = request.getParameter("motDePasse");


        // Création de l'objet Utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setRoleId(roleId);
        utilisateur.setMotDePasse(motDePasse);

        // Appel à la méthode de sauvegarde de l'utilisateur dans la couche DAO
        utilisateurDAO.sauvegarder(entityManager, utilisateur);

        // Fermer l'EntityManager
        entityManager.close();
        // Redirection vers la page de connexion après l'inscription réussie
        response.sendRedirect("login.jsp");

    }
}