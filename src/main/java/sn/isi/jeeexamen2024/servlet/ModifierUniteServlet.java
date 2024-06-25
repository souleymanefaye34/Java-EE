package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.UnitedelocationDAO;
import sn.isi.jeeexamen2024.entities.Unitedelocation;
import sn.isi.jeeexamen2024.entities.Immeuble;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "ModifierUniteServlet", urlPatterns = "/modifier-unitelocation")
public class ModifierUniteServlet extends HttpServlet {

    private final UnitedelocationDAO unitedelocationDAO = new UnitedelocationDAO();
    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("GestionImmeublesPU");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Unitedelocation unite = unitedelocationDAO.trouverUnite(id);
        request.setAttribute("unite", unite);
        request.getRequestDispatcher("modifierUnite.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = emFactory.createEntityManager();

        // Récupérer les données du formulaire
        int id = Integer.parseInt(request.getParameter("id"));
        int nombreUnite = Integer.parseInt(request.getParameter("nombreUnite"));
        int nombrePieces = Integer.parseInt(request.getParameter("nombrePieces"));
        double superficie = Double.parseDouble(request.getParameter("superficie"));
        BigDecimal loyer = new BigDecimal(request.getParameter("loyer"));
        int immeubleId = Integer.parseInt(request.getParameter("immeuble"));

        // Trouver l'immeuble
        Immeuble immeuble = entityManager.find(Immeuble.class, immeubleId);

        // Trouver l'unité de location existante
        Unitedelocation unite = unitedelocationDAO.trouverUnite(id);
        unite.setNombreUnite(nombreUnite);
        unite.setNombrePieces(nombrePieces);
        unite.setSuperficie(superficie);
        unite.setLoyer(loyer);
        unite.setImmeuble(immeuble);

        // Mettre à jour l'unité de location
        unitedelocationDAO.mettreAJourUnite(unite);

        // Rediriger vers la liste des unités de location
        response.sendRedirect("listeUnites.jsp");
    }
}
