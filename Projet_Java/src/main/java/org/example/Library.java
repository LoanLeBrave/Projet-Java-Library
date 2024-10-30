package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Library {
    private String Nom;
    private Set<Book> Book;
    private static List<Book> catalogue;
    private static Set<User> User;
    private static User currentUser = null;

    public Library (String nom){
        this.Nom = nom;
        this.catalogue = new ArrayList<>();
        this.Book = new HashSet<>();
        this.User = new HashSet<>();
    }

    public void AddUser(User user) {
        User.add(user);
        System.out.println("Utilisateur " + user.getIdentifiant() + " ajouté avec succès.");
    }

    public static User Login(int UserId) {
        for (User user : User) {
            if (user.getIdentifiant() == UserId) {
                currentUser = user;
                System.out.println("Connexion réussie. Bienvenue, " + user.getName() + " !");
                return currentUser;
            }
        }
        System.out.println("Identifiant invalide. Utilisateur non trouvé.");
        return null;
    }

    public static void Logout() {
        if (currentUser != null) {
            System.out.println("Déconnexion réussie. A bientot " + currentUser.getName() + " !");
            currentUser = null; // Déconnexion : remettre currentUser à null
        } else {
            System.out.println("Aucun utilisateur n'est connecté.");
        }
    }


    public void loadCatalogueFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            catalogue = objectMapper.readValue(new File(filePath), new TypeReference<List<Book>>() {});
            System.out.println("Catalogue chargé avec succès depuis " + filePath);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement du fichier JSON: " + e.getMessage());
        }
    }

    public void displayCatalogue() {
        if (catalogue.isEmpty()) {
            System.out.println("Le catalogue est vide.");
        } else {
            System.out.println("Catalogue des livres disponibles :");
            for (Book book : catalogue) {
                System.out.println(book);
            }
        }
    }

    public void ViewBookDetails(int isbn) {
        Book book = FindBookByISBN(isbn);
        if (book != null) {
            System.out.println("Détails du livre :");
            System.out.println("ISBN : " + book.GetISBN());
            System.out.println("Titre : " + book.GetTitle());
            System.out.println("Auteur : " + book.GetAuthor_name());
            System.out.println("Description : " + book.GetDescription());
            System.out.println("Prix : " + book.GetPrix() + "€");
        } else {
            System.out.println("Aucun livre trouvé avec l'ISBN " + isbn);
        }
    };

    public static Book FindBookByISBN(int isbn) {
        for (Book book : catalogue) {
            if (book.GetISBN() == isbn) {
                return book;
            }
        }
        System.out.println("Aucun livre trouvé avec l'ISBN " + isbn);
        return null;
    }

    public static void removeBookFromCatalogue(int isbn) {
        Book book = FindBookByISBN(isbn);
        if (book != null) {
            catalogue.remove(book);
            System.out.println("Le livre " + book.GetTitle() + " a été retiré du catalogue.");
        } else {
            System.out.println("Aucun livre avec l'ISBN " + isbn + " trouvé dans le catalogue.");
        }
    }

    public static boolean IsUserLoggedIn() {
        return currentUser != null;
    }

    public static User GetCurrentUser() {
        return currentUser;
    }

    public void AddBook (Book book){
        this.Book.add(book);
    }
}
