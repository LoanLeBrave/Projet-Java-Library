# Projet-Java-Library
Lors de ce projet il a été demandé de créer un application en java pour gérer une bibliothèque. Cette application devrat répôndre à différentes exigences tel que : 
- Avoir une gestion des utilisateurs via une connexion par identifiant
- Gérer une collection de livre qui possède différents attributs : Un identifiant unique, un titre, une description, un auteur et un prix
-  Cette application sera aussi en mesure de gérer l'emprunt et la rétribution des livres à la bibliotèque.
-  Le catalogue de livre se fera sous forme de fichier JSON
-  L'utilisateur sera en mesure de faire différentes actions tels que : Connaitre la listes des livres disponible, avoir le détails de chaque livre, louer et rendre un livre et il pourra exporter le catalogue des livres disponible actuellement.

  # Réalisation 
  Pour accomplir toutes ces exigences, le groupe à commencer par créer 3 classes : 
  - User
  - Library
  - Book
et le main pour appeler les fonctions.
# User 
La classe User est utilisé pour déclarer toutes les variables et fonctions liés aux utlisateurs.
Un utilisateur est définin seulement par son identifiant, un nom lui a été ajouté ainsi qu'une liste de livre qu'il a emprunté.
Dans les variables le nombre maximum de livre empruntable par un utilisateur est définie, dans le cadre de ce projet c'est 3.
Dans cette classe utilisateur il y a donc 4 méthode en plus du constructeur. Une méthode GetIdentifiant et GetNom.
Les 2 autres méthode sont c'elle pour emprunter un livre et de le rendre ainsi que c'elle de voir quel livre un utilisateur à emprunter.
La méthode d'emprunter un livre vérifie 2 condition, la première si l'utilisateur n'a pas emprunter + de 3 livres, la deuxième condition est s'il n'a pas emprunter le même livre. Si ces 2 conditions ont été passé avec succès le livre qu'il veut emprunter sera ajouter dans sa liste et retirer du catalogue de la bibliothèque.
