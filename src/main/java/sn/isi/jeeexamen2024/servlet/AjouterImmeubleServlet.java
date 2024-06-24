package sn.isi.jeeexamen2024.servlet;


import sn.isi.jeeexamen2024.dao.ImmeubleDAO;
import sn.isi.jeeexamen2024.entities.Immeuble;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjouterImmeubleServlet", urlPatterns = "/ajouter-immeuble")

public class AjouterImmeubleServlet extends HttpServlet {

    private final ImmeubleDAO immeubleDao = new ImmeubleDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String equipement = request.getParameter("equipement");
        int nbrUnite = Integer.parseInt(request.getParameter("nbrUnite"));

        Immeuble immeuble = new Immeuble();
        immeuble.setNom(nom);
        immeuble.setAdresse(adresse);
        immeuble.setEquipement(equipement);
        immeuble.setNbrUnite(nbrUnite);

        immeubleDao.sauvegarder(immeuble);

        response.sendRedirect("listeImmeubles.jsp"); // Redirection vers la liste des immeubles
    }
}