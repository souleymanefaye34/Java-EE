<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Immeubles</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100%;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: none; /* Replace with your image path */
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
        }
        .container {
            display: flex;
            width: 800px;
            height: 500px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .left {
            background-color: #333;
            color: white;
            width: 50%;
            padding: 20px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .left img {
            margin-bottom: 20px;
            width: 200px; /* Adjust size if necessary */
            height: auto;
        }
        .left h1 {
            margin-bottom: 10px;
            font-size: 24px;
        }
        .left p {
            margin-bottom: 20px;
        }
        .left .social-icons i {
            margin: 0 10px;
            font-size: 24px;
        }
        .right {
            background-color: white;
            width: 50%;
            padding: 40px;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        .right input, .right textarea {
            margin-bottom: 15px;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
        }
        .right button {
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            background-color: #333;
            color: white;
            cursor: pointer;
        }
        .right button:hover {
            background-color: #555;
        }
        .right a {
            margin-top: 10px;
            text-align: center;
            color: #333;
            text-decoration: none;
        }
        .right a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Liste des Immeubles</h1>
<a href="ajouterImmeuble.jsp">Ajouter un nouvel immeuble</a>
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
    <c:forEach var="immeuble" items="${immeubles}">
        <tr>
            <td>${immeuble.id}</td>
            <td>${immeuble.nom}</td>
            <td>${immeuble.adresse}</td>
            <td>${immeuble.description}</td>
            <td>${immeuble.équipements}</td>
            <td>
                <a href="modifierImmeuble?id=${immeuble.id}">Modifier</a>
                <a href="supprimerImmeuble?id=${immeuble.id}" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet immeuble ?');">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
