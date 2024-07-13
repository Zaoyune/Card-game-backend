Enoncé :
"On souhaite développer un jeu de cartes.
Dans ce jeu, un joueur tire une main de 10 cartes de manière aléatoire.
Chaque carte possède une couleur ("Carreaux", par exemple) et une valeur ("10", par exemple).
On vous demande de:
Construire un ordre aléatoire des couleurs. L'ordre des couleurs est, par exemple, l'un des suivants :
--> Carreaux, Coeur, Pique, Trèfle
Construire un ordre aléatoire des valeurs. L'ordre des valeurs est, par exemple, l'un des suivants :
--> As, 5, 10, 8, 6, 7, 4, 2, 3, 9, Dame, Roi, Valet
Construire une main de 10 cartes de manière aléatoire.
Présenter la main "non triée" à l'écran puis la main triée selon n'importe quel ordre défini dans la 1ère et 2ème étape. C'est-à-dire que vous devez classer les cartes par couleur et valeur.
Vous présenterez une solution qui tourne sur le langage Java/Spring.
Vous pouvez utiliser un serveur d'application pour présenter la main de l'utilisateur (une interface graphique est la bienvenue), ou simplement la sortie console.

## Prérequis

- Java 17
- spring boot 3.0


### Option 1: Utilisation de Maven

mvn clean install
mvn spring-boot:run

L'application sera accessible à l'adresse : http://localhost:8080

Endpoints API
Documentation API
La documentation Swagger de l'API est accessible à : http://localhost:8080/swagger-ui/index.html

La partie front-end de cette application a été développée en Angular 17. Assurez-vous d'installer
Node.js et Angular CLI avant de démarrer le serveur de développement.

Auteurs
Hassan Benharouga
