package org.example;

import java.util.Scanner;

public class Main {

    public static int displayInterface(Scanner scanner, Library library) {
        int user_input;

        do {
            if (library.IsUserLoggedIn()) {
                System.out.println("Utilisateur actuellement connecté : " + library.GetCurrentUser().getIdentifiant());
            }

            System.out.println("\n******************* Bienvenue dans la bibliotheque *******************");
            System.out.println("*** Que voulez-vous faire ?");
            System.out.println(
                    "* 1- Se connecter \n" +
                            "* 2- Se déconnecter \n" +
                            "* 3- Lister les livres disponibles \n" +
                            "* 4- Voir les détails d'un livre \n" +
                            "* 5- Louer un livre \n" +
                            "* 6- Rendre un livre \n" +
                            "* 7- Exporter le catalogue \n"
            );

            System.out.print("-- : ");
            user_input = scanner.nextInt();

        } while (user_input < 1 || user_input > 7);

        return user_input;
    }

    public static void main(String[] args) {
        Library library = new Library("Library of Liberty");
        String filePath = "book_catalogue.json";

        library.AddUser(new User(232, "Loan"));
        library.AddUser(new User(564, "Jean-Michel"));

        Scanner scanner = new Scanner(System.in);

        User current_user;



        displayInterface(scanner,library);

        switch (user_input) {
            case 1:
                System.out.println("\nConnexion en cours...\n");
                System.out.println("Quel est votre identifiant utilisateur ?");
                int user_id = scanner.nextInt();
                current_user = Library.Login(user_id);
            case 2:
                System.out.println("\nDeconnexion en cours...\n");
                Library.Logout();
                break;
            case 3:
                System.out.println("Ent");
                break;
            case 4:
                System.out.println("Fonctionnalité de location d'un livre non implémentée");
                break;
            case 5:
                System.out.println("Fonctionnalité de rendu d'un livre non implémentée");
                break;
            case 6:
                System.out.println("Fonctionnalité d'export du catalogue non implémentée");
                break;
            case 7:
                System.out.println("Fonctionnalité d'export du catalogue non implémentée");
                break;
            default:
                System.out.println("Choix invalide.");

        System.out.println(user_input);

        library.displayCatalogue();


        /*
        Book book1 = new Book(10,"Les fleurs du mal","Les Fleurs du mal est un recueil de poèmes ","Charles Baudelaire",20);
        Book book2_1 = new Book(20,"Inazuma Eleven","C EST UN LIVRE DE FOOTBALL","Marc Evans auteur",50);
        Book book2_2 = new Book(21,"Inazuma Eleven","C EST UN LIVRE DE FOOTBALL","Marc Evans auteur",50);
        Book book3 = new Book(30,"Bienvenue a zombiland","Un film de zombie","Zombi Auteur",30);

        User Loan = new User(1, "Loan");

        System.out.println("Loan sans book");
        System.out.println("");
        Loan.ShowRentedBook();
        System.out.println("");
        System.out.println("Loan avec les 2 premiers book");
        System.out.println("");
        Loan.RentABook(book1);
        Loan.RentABook(book2_1);
        Loan.RentABook(book2_2);
        System.out.println("");
        Loan.ShowRentedBook();
         */
    }
}}