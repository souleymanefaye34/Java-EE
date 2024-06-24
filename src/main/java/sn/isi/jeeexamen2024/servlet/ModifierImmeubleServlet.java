package sn.isi.jeeexamen2024.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.jeeexamen2024.dao.ImmeubleDAO;
import sn.isi.jeeexamen2024.entities.Immeuble;

import java.io.IOException;

@WebServlet(name = "ModifierImmeubleServlet", urlPatterns = "/modifier-immeuble")

public class ModifierImmeubleServlet extends HttpServlet {

    private final ImmeubleDAO immeubleDao = new ImmeubleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        Immeuble immeuble = immeubleDao.getImmeubleById(id);

        request.setAttribute("immeuble", immeuble);
        RequestDispatcher dispatcher = request.getRequestDispatcher("modifImmeuble.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String equipement = request.getParameter("equipement");
        int nbrUnite = Integer.parseInt(request.getParameter("nbrUnite"));

        Immeuble immeuble = new Immeuble();
        immeuble.setId(id);
        immeuble.setNom(nom);
        immeuble.setAdresse(adresse);
        immeuble.setEquipement(equipement);
        immeuble.setNbrUnite(nbrUnite);

        immeubleDao.mettreAJour(immeuble);

        response.sendRedirect("listeImmeubles.jsp"); // Redirection vers la liste des immeubles    }
    }
}