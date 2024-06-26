<%@ page import="sn.isi.jeeexamen2024.dao.UtilisateurDAO" %>
<%@ page import="sn.isi.jeeexamen2024.entities.Utilisateur" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    Utilisateur utilisateur = utilisateurDAO.trouverParId(id);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Mettre à Jour Utilisateur</title>
    <!-- Liens vers les fichiers Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Mettre à Jour Utilisateur</h1>
    <form action="mettreAJourUtilisateur" method="post">
        <input type="hidden" name="id" value="<%= utilisateur.getId() %>">
        <div class="form-group">
            <label for="nom">Nom:</label>
            <input type="text" class="form-control" id="nom" name="nom" value="<%= utilisateur.getNom() %>">
        </div>
        <div class="form-group">
            <label for="prenom">Prénom:</label>
            <input type="text" class="form-control" id="prenom" name="prenom" value="<%= utilisateur.getPrenom() %>">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="<%= utilisateur.getEmail() %>">
        </div>
        <div class="form-group">
            <label for="motDePasse">Mot de Passe:</label>
            <input type="password" class="form-control" id="motDePasse" name="motDePasse" value="<%= utilisateur.getMotDePasse() %>">
        </div>
        <div class="form-group">
            <label for="roleId">Role ID:</label>
            <input type="number" class="form-control" id="roleId" name="roleId" value="<%= utilisateur.getRoleId() %>">
        </div>
        <button type="submit" class="btn btn-primary">Mettre à Jour</button>
    </form>
</div>

<!-- Scripts Bootstrap (optionnel si vous utilisez des fonctionnalités avancées de Bootstrap) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
