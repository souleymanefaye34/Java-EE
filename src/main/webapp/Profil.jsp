<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="sn.isi.jeeexamen2024.entities.Utilisateur" %>

<%
    // Utilisateur est récupéré depuis la session
    Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profil de l'utilisateur</title>
    <style>
        /* Styles pour la navigation */
        nav {
            display: flex;
            align-items: center;
            width: 100%;
            background-color: black;
            padding: 10px;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
            flex-grow: 1;
        }
        nav ul li {
            margin: 0 20px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            font-size: 18px;
        }
        nav ul li a:hover {
            color: #ff6600;
        }
        .active {
            color: #ff6600;
        }

        /* Styles pour les détails de l'utilisateur */
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
        .details {
            text-align: left;
        }
        .details p {
            margin: 10px 0;
            font-size: 18px;
        }
        .details label {
            font-weight: bold;
            display: block;
        }
        .edit-icon {
            float: right;
            cursor: pointer;
        }
    </style>
</head>
<body>
<nav>
    <ul>
        <li><a href="locataire.jsp">Accueil</a></li>
        <li><a href="offre.jsp">Voir offre</a></li>
        <li><a href="#">Demande location</a></li>
        <li><a href="Profil.jsp">Profil</a></li>
    </ul>
    <div>
        <a href="login.jsp" class="login-button">Deconnexion</a>
    </div>
</nav>
<div class="container">
    <h2>Profil de l'utilisateur</h2>
    <div class="details">
        <p>
            <label>Nom:</label>
            <span>${utilisateur.nom}</span>
        </p>
        <p>
            <label>Prénom:</label>
            <span>${utilisateur.prenom}</span>
        </p>
        <p>
            <label>Email:</label>
            <span>${utilisateur.email}</span>
        </p>
        <p>
            <label>Mot De Passe:</label>
            <span>********</span> <!-- Masquer le mot de passe -->
        </p>

        <br>
        <a href="modifUser.jsp?id=<%= utilisateur.getId() %>">Modifier</a>
    </div>
</div>
</body>
</html>
