<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 21/06/2024
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter Immeuble</title>
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
            background-image: url('assets/image1.jpg'); /* Replace with your image path */
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
<div class="container">
    <div class="left">
        <img src="logo.png" alt="Logo">
        <h1>Welcome to MI6.</h1>
        <p>Are you ready to join the elite?</p>
        <div class="social-icons">
            <i class="fas fa-globe"></i>
            <i class="fab fa-behance"></i>
            <i class="fab fa-twitter"></i>
        </div>
    </div>
    <div class="right">
        <form action="${pageContext.request.contextPath}/ajouter-immeuble" method="post">
            <input type="text" id="nom" name="nom" placeholder="nom" required>
            <input type="text" id="adresse" name="adresse" placeholder="Adresse" required>

            <textarea id="nbrUnite" name="nbrUnite" placeholder="nombre Unite" required></textarea>
            <textarea id="equipement" name="equipement" placeholder="Équipements" required></textarea>
            <button type="submit">Ajouter</button>
        </form>
        <a href="listeImmeubles.jsp">Retour à la liste des immeubles</a>
    </div>
</div>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>