package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.UtilisateurDAO;
import sn.isi.jeeexamen2024.entities.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListerUtilisateursServlet", urlPatterns = "/utilisateurs")
public class ListerUtilisateursServlet extends HttpServlet {
    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Utilisateur> utilisateurs = utilisateurDAO.listerTous();
        request.setAttribute("utilisateurs", utilisateurs);
        request.getRequestDispatcher("/listeUtilisateurs.jsp").forward(request, response);
    }
}
