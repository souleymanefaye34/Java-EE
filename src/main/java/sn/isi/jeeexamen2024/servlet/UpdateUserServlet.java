package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.entities.Utilisateur;
import sn.isi.jeeexamen2024.dao.UtilisateurDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/UpdateUser")
public class UpdateUserServlet extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        emf = Persistence.createEntityManagerFactory("GestionImmeublesPU");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        if (utilisateur == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Récupération des données du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Mise à jour des données de l'utilisateur
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);

        if (password != null && !password.isEmpty()) {
            utilisateur.setMotDePasse(password);
        }

        // Utilisation de UtilisateurDAO pour mettre à jour l'utilisateur dans la base de données
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        EntityManager em = emf.createEntityManager();

        try {
            utilisateurDAO.mettreAJour(utilisateur);
            session.setAttribute("utilisateur", utilisateur); // Mettre à jour l'utilisateur en session
            response.sendRedirect("Profil.jsp"); // Redirection vers la page de profil mise à jour
        } catch (Exception e) {
            e.printStackTrace();
            // Gestion de l'erreur, par exemple afficher un message d'erreur ou rediriger vers une page d'erreur
            response.sendRedirect("error.jsp");
        } finally {
            em.close();
        }
    }

    @Override
    public void destroy() {
        emf.close(); // Fermer l'EntityManagerFactory à la fin
    }
}
