package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.UnitedelocationDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;

@WebServlet(name = "SupprimerUniteServlet", urlPatterns = "/supprimer-unitelocation")
public class SupprimerUniteServlet extends HttpServlet {

    private final UnitedelocationDAO unitedelocationDAO = new UnitedelocationDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        unitedelocationDAO.supprimerUnite(id);
        response.sendRedirect("listeUnites.jsp");
    }
}
