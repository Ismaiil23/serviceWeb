<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Coopérative Agricole - Commandes</title>
    <link rel="stylesheet" href="styles.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="scripts.js"></script>
</head>
<body>
<header>
    <h1>Coopérative Agricole</h1>
</header>
<nav>
    <a href="index.php">Accueil</a>
    <a href="products.php">Produits</a>
    <a href="orders.php">Commandes</a>
</nav>
<main>
    <h2>Mes commandes</h2>
    <div id="orders-list"></div>
</main>
<footer>
    <p>&copy; Coopérative Agricole - 2023</p>
</footer>
<script>
    $(document).ready(function() {
        loadOrders();
    });

    function loadOrders() {
        $.get("http://localhost:8080/api/commandes", function(data) {
            var ordersHtml = "";
            data.forEach(function(order) {
                ordersHtml += `
                        <div class="order">
                            <h3>Commande n°${order.id}</h3>
                            <p>Date : ${order.date}</p>
                            <p>Statut : ${order.status}</p>
                            <p>Total : ${order.total} €</p>
                            <p>Détails :</p>
                            <ul>`
                order.items.forEach(function(item) {
                    ordersHtml += `
                                <li>${item.quantity} ${item.unit} ${item.productName} - ${item.price} €/unité</li>
                            `;
                });
                ordersHtml += `
                            </ul>
                        </div>
                    `;
            });
            $("#orders-list").html(ordersHtml);
        });
    }
</script>
</body>
</html>

