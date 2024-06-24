package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.ImmeubleDAO;
import sn.isi.jeeexamen2024.entities.Immeuble;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListeImmeublesServlet", urlPatterns = "/liste-immeubles")
public class ListeImmeublesServlet extends HttpServlet {

    private final ImmeubleDAO immeubleDao = new ImmeubleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Immeuble> listeImmeubles = immeubleDao.listeImmeubles();
        if (listeImmeubles != null) {
            for (Immeuble immeuble : listeImmeubles) {
                System.out.println(immeuble);
            }
        } else {
            System.out.println("La liste des immeubles est vide");
        }
        request.setAttribute("listeImmeubles", listeImmeubles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listeImmeubles.jsp");
        dispatcher.forward(request, response);
    }
}
