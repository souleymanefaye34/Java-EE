package sn.isi.jeeexamen2024.servlet;


import sn.isi.jeeexamen2024.entities.Utilisateur;
import sn.isi.jeeexamen2024.dao.UtilisateurDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet(name = "ModifierProfilServlet", urlPatterns = "/modifierProfil")
public class ModifierProfilServlet extends HttpServlet {

    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    private EntityManagerFactory emFactory;

    @Override
    public void init() throws ServletException {
        emFactory = Persistence.createEntityManagerFactory("GestionImmeublesPU");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        if (utilisateur != null) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            int roleId = Integer.parseInt(request.getParameter("role_id"));
            String email = request.getParameter("email");
            String motDePasse = request.getParameter("motDePasse");

            // Ajoutez d'autres champs si nécessaire

            utilisateur.setNom(nom);
            utilisateur.setPrenom(prenom);
            utilisateur.setRoleId(roleId);
            utilisateur.setEmail(email);
            utilisateur.setMotDePasse(motDePasse);


            EntityManager entityManager = emFactory.createEntityManager();
            entityManager.getTransaction().begin();
            utilisateurDAO.modifierUtilisateurs(entityManager, utilisateur);
            entityManager.getTransaction().commit();
            entityManager.close();

            // Mettre à jour l'utilisateur dans la session
            session.setAttribute("utilisateur", utilisateur);

            response.sendRedirect("profil");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {
        if (emFactory != null && emFactory.isOpen()) {
            emFactory.close();
        }
    }
}
