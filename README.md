# serviceWeb

CC2 - Développer et utiliser des services web en Java
• Coefficient 15
• TP sur machine en salle TP et à la maison
• Évaluation en groupe de 4 étudiants
• Compétence 6 – « collaborer »
Le contexte
L’objectif de ce projet est de développer une application web pour une coopérative agricole
vendant ses produits en vente directe. La coopérative vend différents types de produits (p.ex.
légumes, oeufs, volailles, fromages, etc.) à des personnes inscrites. Les abonnés peuvent réserver
des paniers en ligne et venir les récupérer dans un relai à une date précise. Le paiement se fait au
moment du retrait du panier au relai.
L’application
Description
L’application web devra permettre de visualiser les produits disponibles, leur quantité et leur
prix. Elle devra aussi permettre de créer/supprimer un panier et d’y ajouter/supprimer des
produits dans les quantités voulues. La date de dernière mise à jours du panier sera enregistrée.
Le panier pourra être validé ou non, et donner ainsi lieu à une commande (ou pas). Seules les
personnes enregistrées peuvent enregistrer un panier et passer commande. L’application prendra
en compte les différentes unités possibles pour quantifier les produits (p.ex. au kilo, à l’unité, à la
douzaine, etc.). Lorsqu’une personne validera une commande, l’application enregistrera le panier
associé, le prix des produits au moment de la commande, la localisation du relai pour le retrait du
panier et la date de retrait.
La validation de la commande sera faite par les gestionnaires de la coopérative, tout comme
l’enregistrement des produits en stock et des abonnés. D’ailleurs, la liste des personnes inscrites
sera uniquement visible par les gestionnaires. Pour des questions de temps, on supposera que les
fonctionnalités associées aux gestionnaires de la coopérative ne seront pas intégrées dans
l’interface graphique de l’application. Par contre, elles seront implémentées dans l’application et
prêtes à être intégrer dans l’interface graphique.
Contraintes non fonctionnelles
L’application suivra une architecture orientée services (RESTful). Elle sera constituée des 4
composants logiciels suivants: - le composant “IHM” gèrera la partie interface graphique avec
l’utilisateur; - le composant “Produits et Utilisateurs” gèrera l’accès aux données des produits et
des utilisateurs. - le composant “Paniers” gèrera les opérations sur les paniers - le composant
“Commandes” gèrera la partie commande
1
Le composant “IHM” sera codé en HTML/CSS/PHP. Les autres composants seront codés avec
Jakarata EE sous forme d’API REST implémentant les opérations CRUD. Chaque composant
sera codé indépendamment, par un étudiant différent, et utilisera une base de données dédiée.
Par ailleurs, le composant “Paniers” devra consommer l’API mise à disposition par le composant
“Produits et Utilisateurs” pour son fonctionnement (en évitant de dupliquer trop d’informations
dans sa base de données). Le composant “Commandes” consommera quant à lui l’API du
composant “Paniers” (car une commande sera associée à un numéro de panier).
