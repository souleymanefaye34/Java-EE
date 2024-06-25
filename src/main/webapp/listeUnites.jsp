<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sn.isi.jeeexamen2024.entities.Unitedelocation" %>
<%@ page import="sn.isi.jeeexamen2024.dao.UnitedelocationDAO" %>

<%
    UnitedelocationDAO unitedelocationDAO = new UnitedelocationDAO();
    List<Unitedelocation> unites = unitedelocationDAO.listerUnites();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Unités de Location</title>
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
            background-color: #f0f0f0;
        }
        header {
            width: 100%;
            background-color: #333;
            color: white;
            padding: 1em 0;
            text-align: center;
        }
        h1 {
            margin-top: 20px;
            font-size: 2em;
            color: #333;
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
    <h1>Liste des Unités de Location</h1>
</header>
<a href="ajouterUnite.jsp" class="add-immeuble">Ajouter une nouvelle unité de location</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre d'Unité</th>
        <th>Nombre de Pièces</th>
        <th>Superficie</th>
        <th>Loyer</th>
        <th>Immeuble</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <% if (unites != null && !unites.isEmpty()) { %>
    <% for (Unitedelocation unite : unites) { %>
    <tr>
        <td><%= unite.getId() %></td>
        <td><%= unite.getNombreUnite() %></td>
        <td><%= unite.getNombrePieces() %></td>
        <td><%= unite.getSuperficie() %></td>
        <td><%= unite.getLoyer() %></td>
        <td><%= unite.getImmeuble().getNom() %></td>
        <td>
            <a href="modifier-unitelocation?id=<%= unite.getId() %>">Modifier</a>
            <a href="supprimer-unitelocation?id=<%= unite.getId() %>" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette unité de location ?');">Supprimer</a>
        </td>
    </tr>
    <% } %>
    <% } else { %>
    <tr>
        <td colspan="7">Aucune unité de location trouvée.</td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
