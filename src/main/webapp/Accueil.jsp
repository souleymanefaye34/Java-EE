<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Properties Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            color: white;
        }
        header {
            background-color: #333;
            padding: 1em 0;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        nav {
            display: flex;
            align-items: center;
            width: 100%;
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
            justify-content: center;
            flex-grow: 1;
        }
        nav ul li {
            margin: 0 20px;
        }
        nav ul li a {
            color: #ccc;
            text-decoration: none;
            font-size: 18px;
        }
        nav ul li a:hover {
            color: white;
        }
        .active {
            color: white;
        }
        .hero {
            position: relative;
            background-image: url('assets/image1.jpg');
            background-size: cover;
            background-position: center;
            height: 700px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
            color: white;
        }
        .hero h1 {
            margin: 0;
            font-size: 3em;
        }
        .hero h2 {
            margin: 0;
            font-size: 2em;
        }
        .hero p {
            font-size: 1.2em;
            margin: 20px 0;
        }
        .hero .button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 10px;
            font-size: 1em;
        }
        .hero .button:hover {
            background-color: #0056b3;
        }
        .pagination {
            position: absolute;
            bottom: 20px;
            display: flex;
            justify-content: center;
            width: 100%;
        }
        .pagination div {
            width: 20px;
            height: 20px;
            background-color: rgba(0, 0, 0, 0.5);
            margin: 0 5px;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            font-size: 14px;
        }
        .banner {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            flex-grow: 1;
            padding-right: 20px;
        }
        .buttons {
            display: flex;
        }
        .buttons a {
            padding: 10px 20px;
            margin-left: 10px;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
        .inscription-button {
            background-color: #f90;
        }
        .inscription-button:hover {
            background-color: #e80;
        }
        .login-button {
            background-color: blue;
        }
        .login-button:hover {
            background-color: darkblue;
        }
    </style>
</head>
<body>
<header>
    <nav>
        <div class="logo">
            <i class="fas fa-home"></i> <span>FAYE IMMOBILIER</span>
        </div>
        <div class="banner">
            <div class="buttons">
                <a href="login.jsp" class="login-button">Connexion</a>
                <a href="register.jsp" class="inscription-button">Inscription</a>
            </div>
        </div>
    </nav>
</header>
<div class="hero">
    <h2>FAYE IMMOBILIER</h2>
    <h1>PROPRIETE</h1>
    <p>FAYE IMMOBILIER est une agence immobilière de premier plan spécialisée dans l'acquisition,
        <br> vente et la location de propriétés ou d'appartement résidentielles au SENEGAL.<br>
        Notre mission est de fournir à nos clients un service exceptionnel</p>
</div>
</body>
</html>
