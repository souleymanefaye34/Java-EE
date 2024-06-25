package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.UnitedelocationDAO;
import sn.isi.jeeexamen2024.entities.Unitedelocation;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet("/liste-unitelocation")
public class ListerUnitesServlet extends HttpServlet {

    private UnitedelocationDAO unitedelocationDAO = new UnitedelocationDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Unitedelocation> unites = unitedelocationDAO.listerUnites();
        request.setAttribute("unites", unites);
        request.getRequestDispatcher("listeUnites.jsp").forward(request, response);
    }
}
