package org.example;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.ArrayList;

public class User {

    private int identifiant;
    private String name;
    private ArrayList<Book> books;
    private static final int maxBooksRent = 3;

    public User(int identifiant, String name){
        this.identifiant = identifiant;
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    public int getIdentifiant() {

        return identifiant;
    }

    public String getName(){
        return this.name;
    }

    public void RentABook(Book new_book) {
        if (books.size() >= maxBooksRent) {
            System.out.println("Vous avez déjà loué 3 livres. Vous ne pouvez pas en louer plus.");
            return;
        }
        for (Book rentedBook : books) {
            if (rentedBook.GetISBN() == new_book.GetISBN()) {
                System.out.println("Vous avez déjà loué ce livre.");
                return;
            }
        }

        if (Library.FindBookByISBN(book.getISBN()) != null) {
            // Louer le livre
            books.add(new_book);
            Library.RemoveBookFromCatalogue(new_book.GetISBN());
            System.out.println("Le livre " + books.GetTitle() + " a été loué avec succès.");
        } else {
            System.out.println("Le livre avec l'ISBN " + books.GetISBN() + " n'existe pas dans le catalogue.");
        }
    }

    public void GiveBackBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Le livre " + book.GetTitle() + " a été rendu.");
        } else {
            System.out.println("Ce livre n'a pas été loué par cet utilisateur.");
        }
    }


    public String ShowRentedBook(){
        System.out.println(this.name + ", Utilisateur n°" + this.identifiant);
        for (int i = 0; i < this.books.size(); i++){
            Book current_book = books.get(i);
            System.out.println("Livres en sa possession : " + current_book.GetTitle());
        }
        return null;
    }
}
