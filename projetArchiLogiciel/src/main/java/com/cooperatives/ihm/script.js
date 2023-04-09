function loadProducts() {
    // Remplacez l'URL par l'URL de votre API REST pour les produits.
    $.get("http://localhost:8080/api/produits", function(data) {
        // Ici, vous pouvez gérer les données de produits reçues de votre API et mettre à jour l'interface utilisateur.
    });
}

function loadOrders() {
    // Remplacez l'URL par l'URL de votre API REST pour les commandes.
    $.get("http://localhost:8080/api/commandes", function(data) {
        // Ici, vous pouvez gérer les données de commandes reçues de votre API et mettre à jour l'interface utilisateur.
    });
}

$(document).ready(function() {
    loadProducts();
    loadOrders();
});
