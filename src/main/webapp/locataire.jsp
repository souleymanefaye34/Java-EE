<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ma Page</title>
  <style>
    /* Styles pour la navigation */
    nav {
      display: flex;
      align-items: center;
      width: 100%;
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
      color: black;
      text-decoration: none;
      font-size: 18px;
    }
    nav ul li a:hover {
      color: black;
    }
    .active {
      color: black;
    }

    /* Styles pour la bannière */
    .banner {
      position: relative;
      background-image: url('assets/locataire.jpg');
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
    .banner h1 {
      font-size: 36px;
      margin-bottom: 20px;
    }
    .banner p {
      font-size: 18px;
      margin-bottom: 30px;
    }
    .view-button {
      background-color: #ff6600;
      color: #fff;
      padding: 10px 20px;
      border: none;
      cursor: pointer;
    }

    /* Styles pour les indicateurs de page */
    .page-indicators {
      text-align: center;
      margin-top: 30px;
    }
    .page-indicators span {
      display: inline-block;
      margin-right: 10px;
      font-size: 18px;
      color: #999;
    }
    .login-button{
      background-color: blue;
    }
    .login-button:hover{
      background-color: darkblue;
    }
  </style>
</head>
<body>
<nav>
  <ul>
    <li><a href="#">Accueil</a></li>
    <li><a href="offre.jsp">Voir offre</a></li>
    <li><a href="#">Demande location</a></li>
    <li><a href="Profil.jsp">Profil</a></li>
  </ul>
  <div>
    <a href="login.jsp" class="login-button">Deconnexion</a>
  </div>
</nav>
<div class="banner">
  <h1>LOUER FACILEMENT</h1>
  <p>Avec l'aide de nos services et solutions de gestion immobilière, vous pouvez louer quelle maison ou appartement.</p>
  <button class="view-button">VOIR LES PROPRIÉTÉS</button>
</div>
<div class="page-indicators">
  <span>1</span>
  <span>2</span>
  <span>3</span>
</div>
</body>
</html>


