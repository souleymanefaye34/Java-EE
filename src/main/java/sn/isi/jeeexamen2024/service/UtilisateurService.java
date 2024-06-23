package sn.isi.jeeexamen2024.service;

import sn.isi.jeeexamen2024.dao.UtilisateurDAO;
import entities.Utilisateur;

public class UtilisateurService {
    private UtilisateurDAO utilisateurDAO;

    public UtilisateurService() {
        utilisateurDAO = new UtilisateurDAO();
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.ajouterUtilisateur(utilisateur);
    }
}
