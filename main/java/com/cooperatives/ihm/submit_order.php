<?php
// Récupérer les données du formulaire
$user = $_POST['user'];
$product = $_POST['product'];
$quantity = $_POST['quantity'];

// Créer une nouvelle commande à partir de l'API

// Rediriger vers la page des commandes avec un message de confirmation
header('Location: orders.php?order_submitted=1');
