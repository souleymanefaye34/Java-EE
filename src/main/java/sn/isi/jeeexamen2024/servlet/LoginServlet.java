package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.UtilisateurDAO;
import sn.isi.jeeexamen2024.entities.Utilisateur;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("GestionImmeublesPU");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = emFactory.createEntityManager();

        // Récupérer les données du formulaire
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("password");

        // Vérifier l'utilisateur par email et mot de passe
        Utilisateur utilisateur = utilisateurDAO.trouverParEmailEtMotDePasse(entityManager, email, motDePasse);

        // Fermer l'EntityManager
        entityManager.close();

        if (utilisateur != null) {
            // Connexion réussie, rediriger selon le rôle de l'utilisateur
            int roleId = utilisateur.getRoleId();
            if (roleId == 1) {
                // Rediriger vers la page client
                response.sendRedirect("proprietaire.jsp");
            } else if (roleId == 2) {
                // Rediriger vers la page propriétaire
                response.sendRedirect("locataire.jsp");
            }
            else if (roleId == 0) {
                // Rediriger vers la page propriétaire
                response.sendRedirect("admin.jsp");
            }else {
                // Rôle non reconnu, rediriger vers une page d'erreur
                response.sendRedirect("error.jsp");
            }
        } else {
            // Connexion échouée, afficher un message d'erreur
            request.setAttribute("errorMessage", "Email ou mot de passe incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
