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

# Library 
La classe Library est quant à elle en charge de faire le lien entre la classe utilisateur (User) et la classe livre (Book), dans cette classe sont implémanté des méthode qui vont intérogé le catalogue de livre en JSON, permettre à l'utilisateur de se connecter. Dans cette classe il y a 8 méthodes, les 2 premières sont c'elle pour se connecter et se déconnecter. La méthode se connecter vérifie simplement que l'utilisateur utilise en vérifiant sont identifiant. Si l'utilisateur n'existe pas, la méthode addUser peut être utilisé. La méthode Logout vérifie si un utilisateur était connecté, si c'était le cas il le deconnecte. 
Il y a ensuite la méthode qui charge le catalogue depuis son fichier. Pour cela il va faire appelle à une exeption pour être sûr que les données sont bien acquise. Ces données qui ont été aquise dans le JSON vont être mis dans une liste. La méthode display catalogue montrera quels sont les références présente dans le catalogue. BookDetail sera quant à elle beaucoup plus précise, en indiquants tous les éléments en référence au livre demandée. 
Enfin il y a une méthode qui permet de chercher les livres par leur identifiant et une autre qui permet de supprimer les livres du catlogue. 

# Book
La méthode book est assez simple car c'est elle qui réference toutes les infomrmations liés aux livres. Elle possèdes des méthode pour retourner individuellement chaque information lié à un livre. Cette classe fait appelle à l'héritage equals pour vérifier qu'aucun livre n'est le même. Les livres doivent être unique dans notre bibliothèque c'est donc pour cela que nous faisont appelle à cette méthode equals. 

