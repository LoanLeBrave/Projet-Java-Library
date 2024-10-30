package org.example;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.ArrayList;
import org.example.Library;

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

    public void RentABook(Book book, Library library) {
        if (books.size() >= maxBooksRent) {
            System.out.println("Vous avez déjà loué 3 livres. Vous ne pouvez pas en louer plus.");
            return;
        }
        for (Book rentedBook : books) {
            if (rentedBook.GetISBN() == book.GetISBN()) {
                System.out.println("Vous avez déjà loué ce livre.");
                return;
            }
        }
        if (library.FindBookByISBN(book.GetISBN()) != null) {
            books.add(book);
            library.removeBookFromCatalogue(book.GetISBN());
            System.out.println("Le livre " + book.GetTitle() + " a été loué avec succès.");
        } else {
            System.out.println("Le livre avec l'ISBN " + book.GetISBN() + " n'existe pas dans le catalogue.");
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
