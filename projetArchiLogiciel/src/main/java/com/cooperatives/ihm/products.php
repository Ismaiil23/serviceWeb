<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Coopérative Agricole - Produits</title>
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
    <h2>Produits disponibles</h2>
    <div id="products-list"></div>
</main>
<footer>
    <p>&copy; Coopérative Agricole - 2023</p>
</footer>
<script>
    $(document).ready(function() {
        loadProducts();
    });

    function loadProducts() {
        $.get("http://localhost:8080/api/produits", function(data) {
            var productsHtml = "";
            data.forEach(function(product) {
                productsHtml += `
                        <div class="product">
                            <h3>${product.name}</h3>
                            <p>Prix : ${product.price} €</p>
                            <p>Quantité : ${product.quantity} ${product.unit}</p>
                        </div>
                    `;
            });
            $("#products-list").html(productsHtml);
        });
    }
</script>
</body>
</html>
