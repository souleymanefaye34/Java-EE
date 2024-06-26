package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SupprimerUtilisateurServlet", urlPatterns = "/supprimerUtilisateur")
public class SupprimerUtilisateurServlet extends HttpServlet {
    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        utilisateurDAO.supprimer(id);
        response.sendRedirect("utilisateurs");
    }
}
