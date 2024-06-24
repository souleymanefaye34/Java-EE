package sn.isi.jeeexamen2024.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.jeeexamen2024.dao.ImmeubleDAO;
import sn.isi.jeeexamen2024.entities.Immeuble;

import java.io.IOException;

@WebServlet(name = "SupprimerImmeubleServlet", urlPatterns = "/supprimer-immeuble")

public class SupprimerImmeubleServlet extends HttpServlet {

    private final ImmeubleDAO immeubleDao = new ImmeubleDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));

        Immeuble immeuble = new Immeuble();
        immeuble.setId(id);

        immeubleDao.supprimer(immeuble);

        response.sendRedirect("listeImmeubles.jsp"); // Redirection vers la liste des immeubles

    }

}
