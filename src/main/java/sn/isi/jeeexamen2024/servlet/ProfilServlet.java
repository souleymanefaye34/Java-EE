package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.entities.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProfilServlet", urlPatterns = "/Profil")
public class ProfilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        if (utilisateur == null) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("utilisateur", utilisateur);
            request.getRequestDispatcher("Profil.jsp").forward(request, response);
        }
    }
}