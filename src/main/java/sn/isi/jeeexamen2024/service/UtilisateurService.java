package sn.isi.jeeexamen2024.service;

import sn.isi.jeeexamen2024.dao.UtilisateurDAO;
import sn.isi.jeeexamen2024.entite.Utilisateurentity;

public class UtilisateurService {
    private UtilisateurDAO utilisateurDAO;

    public UtilisateurService() {
        utilisateurDAO = new UtilisateurDAO();
    }

    public void ajouterUtilisateur(Utilisateurentity utilisateur) {
        utilisateurDAO.ajouterUtilisateur(utilisateur);
    }
}
