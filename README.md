# Projet Java - Library

Dans le cadre de ce projet, il a été demandé de créer une application en Java pour gérer une bibliothèque. Cette application doit répondre aux exigences suivantes :

- Gérer les utilisateurs avec une connexion par identifiant.
- Gérer une collection de livres possédant divers attributs : un identifiant unique, un titre, une description, un auteur, et un prix.
- Permettre la gestion des emprunts et retours des livres dans la bibliothèque.
- Le catalogue de livres est stocké sous forme de fichier JSON.
- L’utilisateur peut effectuer diverses actions, telles que : consulter la liste des livres disponibles, obtenir les détails de chaque livre, emprunter et rendre un livre, ainsi qu’exporter le catalogue actuel des livres disponibles.

## Réalisation 

Pour répondre à ces exigences, le groupe a commencé par créer trois classes principales : 
  - `User`
  - `Library`
  - `Book`
  
Ainsi qu'une classe `Main` pour appeler les différentes fonctions.

### Classe User

La classe `User` est utilisée pour déclarer toutes les variables et fonctions liées aux utilisateurs. Un utilisateur est défini par son identifiant et son nom, ainsi que par une liste de livres empruntés. La classe spécifie un nombre maximum de livres empruntables par utilisateur, fixé à 3 pour ce projet.

Elle contient quatre méthodes en plus du constructeur :
- `getIdentifiant()` et `getNom()` pour obtenir l’identifiant et le nom de l’utilisateur.
- Deux méthodes pour emprunter et rendre un livre, ainsi que pour consulter les livres empruntés.

La méthode d’emprunt vérifie deux conditions : l’utilisateur ne doit pas avoir emprunté plus de trois livres, et il ne doit pas avoir emprunté le même livre. Si ces conditions sont remplies, le livre est ajouté à sa liste d’emprunts et retiré du catalogue de la bibliothèque.

### Classe Library 

La classe `Library` sert de lien entre les classes `User` et `Book`. Elle implémente des méthodes pour interroger le catalogue de livres en JSON et pour gérer la connexion des utilisateurs. Elle contient huit méthodes principales :
- Les deux premières méthodes permettent de se connecter et de se déconnecter. La méthode de connexion vérifie l’identifiant de l’utilisateur et, si celui-ci n’existe pas, `addUser` peut être utilisée pour l’ajouter. La méthode `Logout` déconnecte l’utilisateur s’il est connecté.
- Une méthode pour charger le catalogue depuis le fichier JSON, avec gestion des exceptions pour assurer l’intégrité des données. Les données chargées sont stockées dans une liste.
- `displayCatalogue()` affiche les références présentes dans le catalogue.
- `bookDetail()` fournit des informations détaillées sur le livre demandé.
- Enfin, une méthode permet de rechercher les livres par leur identifiant et une autre de les supprimer du catalogue.

### Classe Book

La classe `Book` contient les informations liées aux livres. Elle possède des méthodes pour retourner chaque attribut du livre individuellement. Cette classe utilise la méthode `equals` pour garantir l’unicité des livres dans la bibliothèque, en évitant les doublons.

### Classe Main

Dans la classe `Main`, une interface utilisateur console a été mise en place pour permettre d'appeler toutes les méthodes décrites ci-dessus. L’interface se présente sous forme d’une liste de fonctions, chacune associée à un numéro pour interroger et utiliser les différentes méthodes de manière intuitive.
