package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.entite.Utilisateurentity;
import sn.isi.jeeexamen2024.service.UtilisateurService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private UtilisateurService utilisateurService;

    public RegisterServlet() {
        utilisateurService = new UtilisateurService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Utilisateurentity utilisateur = new Utilisateurentity();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setTelephone(telephone);
        utilisateur.setUsername(username);
        utilisateur.setPassword(password);
        utilisateur.setRole(role);

        utilisateurService.ajouterUtilisateur(utilisateur);

        response.sendRedirect("success.jsp");
    }
}
