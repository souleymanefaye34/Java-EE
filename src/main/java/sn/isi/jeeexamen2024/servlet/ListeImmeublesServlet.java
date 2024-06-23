package sn.isi.jeeexamen2024.servlet;

import sn.isi.jeeexamen2024.dao.ImmeubleDAO;
import entities.Immeuble;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
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
