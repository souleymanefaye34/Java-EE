<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sn.isi.jeeexamen2024.entities.Utilisateur" %>
<%@ page import="sn.isi.jeeexamen2024.dao.UtilisateurDAO" %>
<%@ page import="java.util.stream.Collectors" %>

<%
  UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
  List<Utilisateur> utilisateurs = utilisateurDAO.listerTous();

%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>liste utilisateurs</title>
  <style>
    body {
      font-family: sans-serif;
      margin: 0;
      background-color: #f8f9fa;
    }
    .sidebar {
      background-color: #343a40;
      color: #fff;
      width: 200px;
      height: 100vh;
      position: fixed;
      top: 0;
      left: 0;
      padding: 20px;
    }
    .sidebar h3 {
      margin-bottom: 20px;
    }
    .sidebar ul {
      list-style: none;
      padding: 0;
    }
    .sidebar li {
      margin-bottom: 10px;
    }
    .sidebar li a {
      color: #fff;
      text-decoration: none;
      display: block;
      padding: 10px;
      border-radius: 5px;
      transition: background-color 0.3s ease;
    }
    .sidebar li a:hover {
      background-color: #495057;
    }
    .content {
      margin-left: 220px;
      padding: 20px;
    }
    .header {
      background-color: #fff;
      padding: 20px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      border-bottom: 1px solid #ddd;
    }
    .header h1 {
      margin: 0;
    }
    .header .nav {
      display: flex;
    }
    .header .nav li {
      margin-left: 20px;
    }
    .header .nav a {
      color: #343a40;
      text-decoration: none;
      transition: color 0.3s ease;
    }
    .header .nav a:hover {
      color: #007bff;
    }
    .dashboard {
      display: grid;
      grid-template-columns: repeat(4, 1fr);
      gap: 20px;
    }
    .card {
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    .card h2 {
      margin-bottom: 10px;
    }
    .card .stat {
      font-size: 24px;
      font-weight: bold;
    }
    .card .progress {
      margin-top: 10px;
      height: 8px;
      background-color: #e9ecef;
      border-radius: 10px;
      overflow: hidden;
    }
    .card .progress-bar {
      height: 100%;
      background-color: #007bff;
      border-radius: 10px;
    }
    .card .info {
      font-size: 14px;
      color: #6c757d;
      margin-top: 10px;
    }
    .card .chart {
      margin-top: 20px;
      height: 200px;
    }
    .card .chart canvas {
      width: 100%;
      height: 100%;
    }
    .table-utilisateurs {
      margin-top: 20px;
      width: 100%;
      border-collapse: collapse;
    }
    .table-utilisateurs th, .table-utilisateurs td {
      border: 1px solid #ddd;
      padding: 8px;
    }
    .table-utilisateurs th {
      background-color: #343a40;
      color: #fff;
    }
  </style>
</head>
<body>
<div class="sidebar">
  <h3>Faye Immobilier</h3>
  <ul>
    <li><a href="#">Tableau de bord</a></li>
    <li><a href="listeUtilisateurs.jsp">Lister les locataire</a></li>
    <li><a href="#">Journal d'activité</a></li>
    <li><a href="#">Composants</a></li>
    <li><a href="#">Paramètres</a></li>
  </ul>
</div>
<div class="content">
  <div class="header">
    <h1>Tableau de bord</h1>
    <nav class="nav">
      <ul>
        <li><a href="#">Utilisateurs</a></li>
        <li><a href="#">Paramètres</a></li>
      </ul>
    </nav>
  </div>

  <div class="table-utilisateurs">
    <h2>Liste des Utilisateurs</h2>
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Email</th>
        <th>Role ID</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <% if (utilisateurs != null && !utilisateurs.isEmpty()) { %>
      <% for (Utilisateur utilisateur : utilisateurs) { %>
      <tr>
        <td><%= utilisateur.getId() %></td>
        <td><%= utilisateur.getNom() %></td>
        <td><%= utilisateur.getPrenom() %></td>
        <td><%= utilisateur.getEmail() %></td>
        <td><%= utilisateur.getRoleId() %></td>
        <td>
          <a href="mettreAJourUtilisateur.jsp?id=<%= utilisateur.getId() %>">Modifier</a>
          <a href="supprimerUtilisateur?id=<%= utilisateur.getId() %>" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?');">Supprimer</a>
        </td>
      </tr>
      <% } %>
      <% } else { %>
      <tr>
        <td colspan="6">Aucun utilisateur trouvé.</td>
      </tr>
      <% } %>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
