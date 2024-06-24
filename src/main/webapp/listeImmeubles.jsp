<%@ page import="sn.isi.jeeexamen2024.dao.ImmeubleDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="sn.isi.jeeexamen2024.entities.Immeuble" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ImmeubleDAO immeubleDAO = new ImmeubleDAO();
    List<Immeuble> immeubles = immeubleDAO.listeImmeubles();
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Immeubles</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body, html {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100%;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            background-image: none; /* Replace with your image path */
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
        }
        header {
            width: 100%;
            background-color: #333;
        }
        nav {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 1em 0;
            max-width: 1200px;
            margin: 0 auto;
        }
        .logo {
            display: flex;
            align-items: center;
            margin-left: 20px;
        }
        .logo i {
            margin-right: 10px;
            font-size: 24px;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
        }
        nav ul li {
            margin: 0 20px;
        }
        nav ul li a {
            color: #ccc;
            text-decoration: none;
            font-size: 18px;
        }
        nav ul li a:hover, .active {
            color: white;
        }
        h1 {
            margin-top: 20px;
            font-size: 2em;
            text-align: center;
            color: white;
        }
        a.add-immeuble {
            margin: 20px 0;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a.add-immeuble:hover {
            background-color: #0056b3;
        }
        table {
            width: 90%;
            max-width: 1200px;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #333;
            color: white;
        }
        td a {
            color: #007bff;
            text-decoration: none;
            margin-right: 10px;
        }
        td a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<header>
    <nav>
        <div class="logo">
            <i class="fas fa-home"></i> <span>FAYE IMMOBILIER</span>
        </div>
        <ul>
            <li><a href="Accueil.jsp" class="active">Accueil</a></li>
            <li><a href="ajouterImmeuble.jsp">Ajouter Immeuble</a></li>
            <li><a href="listeImmeubles.jsp">Lister Immeuble</a></li>
        </ul>
    </nav>
</header>
<h1>Liste des Immeubles</h1>
<a href="ajouterImmeuble.jsp" class="add-immeuble">Ajouter un nouvel immeuble</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Adresse</th>
        <th>Description</th>
        <th>Équipements</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <% for (Immeuble i : immeubles) { %>
    <tr>
        <td><%= i.getId() %></td>
        <td><%= i.getNom() %></td>
        <td><%= i.getAdresse() %></td>
        <td><%= i.getEquipement() %></td>
        <td><%= i.getNbrUnite() %></td>
        <td>
            <a href="modifier-immeuble?id=<%= i.getId() %>">Modifier</a>
            <a href="supprimer-immeuble?id=<%= i.getId() %>" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet immeuble ?');">Supprimer</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
