package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.UtilisateurDAO;
import sn.isi.jeeexamen2024.entities.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MettreAJourUtilisateurServlet", urlPatterns = "/mettreAJourUtilisateur")
public class MettreAJourUtilisateurServlet extends HttpServlet {
    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");
        int roleId = Integer.parseInt(request.getParameter("roleId"));

        Utilisateur utilisateur = utilisateurDAO.trouverParId(id);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setMotDePasse(motDePasse);
        utilisateur.setRoleId(roleId);

        utilisateurDAO.mettreAJour(utilisateur);

        response.sendRedirect("utilisateurs");
    }
}
