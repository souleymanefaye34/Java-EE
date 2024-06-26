<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 24/06/2024
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoreUI Dashboard</title>
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
    </style>
</head>
<body>
<div class="sidebar">
    <h3>Faye Immobilier</h3>
    <ul>
        <li><a href="#">Tableau de bord</a></li>

        <li><a href="listeUtilisateurs.jsp">Lister les locataire</a></li>
        <li><a href="#">Journal d'activité </a></li>
        <li><a href="#">Composants</a></li>
        <li><a href="#">Paramétre</a></li>

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
    <div class="dashboard">
        <div class="card">
            <h2>Utilisateurs</h2>
            <div class="stat">26K</div>
            <div class="info">(-12,4%) ↓</div>
            <div class="chart">
                <canvas id="chart-users"></canvas>
            </div>
        </div>
        <div class="card">
            <h2>Revenu</h2>
            <div class="stat">6 200 $</div>
            <div class="info">(40,9%) ↑</div>
            <div class="chart">
                <canvas id="chart-revenue"></canvas>
            </div>
        </div>
        <div class="card">
            <h2>Taux de conversion</h2>
            <div class="stat">2,49%</div>
            <div class="info">(84,7%) ↑</div>
            <div class="chart">
                <canvas id="chart-conversion"></canvas>
            </div>
        </div>
        <div class="card">
            <h2>Trafic</h2>
            <div class="info">Janvier - juillet 2023</div>
            <div class="chart">
                <canvas id="chart-traffic"></canvas>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    // Chart.js configuration for each chart
    const ctxUsers = document.getElementById('chart-users').getContext('2d');
    const chartUsers = new Chart(ctxUsers, {
        type: 'line',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
            datasets: [{
                label: 'Utilisateurs',
                data: [24, 28, 21, 32, 26, 30, 29],
                borderColor: 'rgba(0, 123, 255, 1)',
                borderWidth: 2,
                fill: false,
                pointRadius: 5,
                pointBackgroundColor: 'rgba(0, 123, 255, 1)'
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    const ctxRevenue = document.getElementById('chart-revenue').getContext('2d');
    const chartRevenue = new Chart(ctxRevenue, {
        type: 'line',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
            datasets: [{
                label: 'Revenu',
                data: [5000, 5500, 6000, 6500, 7000, 7500, 8000],
                borderColor: 'rgba(0, 123, 255, 1)',
                borderWidth: 2,
                fill: false,
                pointRadius: 5,
                pointBackgroundColor: 'rgba(0, 123, 255, 1)'
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    const ctxConversion = document.getElementById('chart-conversion').getContext('2d');
    const chartConversion = new Chart(ctxConversion, {
        type: 'line',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
            datasets: [{
                label: 'Taux de conversion',
                data: [1.5, 2.0, 2.5, 2.2, 2.8, 3.0, 3.2],
                borderColor: 'rgba(255, 159, 64, 1)',
                borderWidth: 2,
                fill: false,
                pointRadius: 5,
                pointBackgroundColor: 'rgba(255, 159, 64, 1)'
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    const ctxTraffic = document.getElementById('chart-traffic').getContext('2d');
    const chartTraffic = new Chart(ctxTraffic, {
        type: 'line',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
            datasets: [{
                label: 'Trafic',
                data: [150, 170, 190, 210, 230, 250, 270],
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 2,
                fill: false,
                pointRadius: 5,
                pointBackgroundColor: 'rgba(54, 162, 235, 1)'
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>
</body>
</html>