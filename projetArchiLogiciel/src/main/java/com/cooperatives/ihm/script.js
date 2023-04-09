function loadProducts() {
    $.get("http://localhost:8080/api/produits", function(data) {
    });
}

function loadOrders() {
    $.get("http://localhost:8080/api/commandes", function(data) {
    });
}

$(document).ready(function() {
    loadProducts();
    loadOrders();
});
