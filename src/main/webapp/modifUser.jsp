<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="sn.isi.jeeexamen2024.entities.Utilisateur" %>
<%@ page import="sn.isi.jeeexamen2024.dao.UtilisateurDAO" %>
<%@ page import="javax.persistence.EntityManagerFactory" %>
<%@ page import="javax.persistence.Persistence" %>
<%
    // Récupération de l'utilisateur depuis la session
    Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

    // Initialisation de l'EntityManagerFactory pour la gestion des transactions
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionImmeublesPU");
    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    // Si l'utilisateur n'est pas connecté, rediriger vers la page de connexion
    if (utilisateur == null) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modification de l'utilisateur</title>
    <style>
        /* Styles pour la page de modification */
        .container {
            text-align: center;
            margin: 20px auto;
            max-width: 400px;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .container h2 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        .form {
            text-align: left;
        }
        .form label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        .form input[type="text"], .form input[type="email"], .form input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }
        .form button {
            background-color: #ff6600;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .form button:hover {
            background-color: #e65100;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Modification de l'utilisateur</h2>
    <form class="form" action="UpdateUser" method="post">
        <input type="hidden" name="id" value="<%= utilisateur.getId() %>">

        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" value="<%= utilisateur.getNom() %>" required>

        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" name="prenom" value="<%= utilisateur.getPrenom() %>" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= utilisateur.getEmail() %>" required>

        <label for="password">Nouveau mot de passe:</label>
        <input type="password" id="password" name="password" placeholder="Laissez vide pour ne pas changer">

        <button type="submit">Enregistrer</button>
    </form>
</div>
</body>
</html>
