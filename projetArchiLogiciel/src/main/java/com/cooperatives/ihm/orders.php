<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Coopérative Agricole - Commandes</title>
    <link rel="stylesheet" href="styles.css">
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
        <h2>Vos commandes</h2>
        <!-- Récupérer et afficher les commandes à partir de l'API -->

        <h3>Passer une commande</h3>
        <form action="submit_order.php" method="post">
            <!-- Formulaire pour passer une commande -->
            <label for="user">Utilisateur :</label>
            <input type="text" id="user" name="user" required>

            <label for="product">Produit :</label>
            <select id="product" name="product" required>
                <!-- Récupérer et afficher les produits disponibles à partir de l'API -->
            </select>

            <label for="quantity">Quantité :</label>
            <input type="number" id="quantity" name="quantity" min="1" required>

            <input type="submit" value="Commander">
        </form>
    </main>
    <footer>
        <p>&copy; Coopérative Agricole - 2023</p>
    </footer>
</body>
</html>
