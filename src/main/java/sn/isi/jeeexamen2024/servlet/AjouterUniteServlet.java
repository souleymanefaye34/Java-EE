package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.ImmeubleDAO;
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
import java.util.List;

@WebServlet(name = "AjouterUniteServlet", urlPatterns = "/ajouter-unitelocation")
public class AjouterUniteServlet extends HttpServlet {

    private final UnitedelocationDAO unitedelocationDAO = new UnitedelocationDAO();
    private final ImmeubleDAO immeubleDAO = new ImmeubleDAO();
    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("GestionImmeublesPU");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la liste des immeubles
        List<Immeuble> immeubles = immeubleDAO.listeImmeubles();

        // Ajouter la liste des immeubles à la requête
        request.setAttribute("immeubles", immeubles);

        // Rediriger vers la page JSP
        request.getRequestDispatcher("ajouterUnite.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = emFactory.createEntityManager();

        // Récupérer les données du formulaire
        int nombreUnite = Integer.parseInt(request.getParameter("nombreUnite"));
        int nombrePieces = Integer.parseInt(request.getParameter("nombrePieces"));
        double superficie = Double.parseDouble(request.getParameter("superficie"));
        BigDecimal loyer = new BigDecimal(request.getParameter("loyer"));
        int immeubleId = Integer.parseInt(request.getParameter("immeuble"));

        // Trouver l'immeuble
        Immeuble immeuble = entityManager.find(Immeuble.class, immeubleId);

        // Créer une nouvelle unité de location
        Unitedelocation unite = new Unitedelocation();
        unite.setNombreUnite(nombreUnite);
        unite.setNombrePieces(nombrePieces);
        unite.setSuperficie(superficie);
        unite.setLoyer(loyer);
        unite.setImmeuble(immeuble);

        // Ajouter l'unité de location
        entityManager.getTransaction().begin();
        entityManager.persist(unite);
        entityManager.getTransaction().commit();

        entityManager.close();

        // Rediriger vers la liste des unités de location
        response.sendRedirect("listeUnites.jsp");
    }
}
