<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sn.isi.jeeexamen2024.entities.Unitedelocation" %>
<%@ page import="sn.isi.jeeexamen2024.dao.UnitedelocationDAO" %>

<%
    UnitedelocationDAO unitedelocationDAO = new UnitedelocationDAO();
    List<Unitedelocation> unites = unitedelocationDAO.listerUnites();
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ma Galerie d'Images</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
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

        .title {
            text-align: center;
            font-size: 2em;
            font-weight: bold;
            margin: 20px 0;
            text-decoration: underline;
        }
        .image-grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 10px;
            padding: 10px;
        }
        .image-item {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        .image {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
        .btn-louer{
            background-color: red;
        }
        .btn-louer:hover{
            background-color: #ff6600;
            color: white;
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
<div class="title">Nos offres de location</div>
<div class="image-grid">
    <% for (Unitedelocation unite : unites) { %>
    <div class="image-item">
        <form action="" method="post">
        <img src="assets/offre3.jpg" class="image">
        <p><%= unite.getImmeuble().getNom() %></p>
        <p>Nombre d'unités : <%= unite.getNombreUnite() %></p>
        <p>Nombre de pièces : <%= unite.getNombrePieces() %></p>
        <p>Superficie : <%= unite.getSuperficie() %> m²</p>
        <p>Loyer : <%= unite.getLoyer() %> €</p>
        <<a href="ConfirmationDemande.jsp">Louer</a>
        </form>
    </div>
    <% } %>
</div>
</body>
</html>
