package oop.library;

import java.util.ArrayList;

import static oop.library.Genre.*;

public class DataProvider {

    private static final Author author1 = new Author("Margaret", "Atwood");
    private static final Author author2 = new Author("Jokha", "Alharthi");
    private static final Author author3 = new Author("Richard", "Powers");
    private static final Author author4 = new Author("Peter", "Baker");
    private static final Author author5 = new Author("Baba", "Ramdev");
    private static final Author author6 = new Author("Sangeeta", "Ghosh");

    private static final Book book1 = new Book("The Testaments", author1, NOVEL, "2019-02-14", 4);
    private static final Book book2 = new Book("Celestial Bodies", author2, POEM, "2020-01-15", 5);
    private static final Book book3 = new Book("The Over story", author3, DRAMA, "2001-04-25", 2);
    private static final Book book4 = new Book("Obama: The Call of History", author4, STORY, "2000-05-19", 1);
    private static final Book book5 = new Book("'My Life, My Mission'", author5, COMEDY, "2000-03-10", 4);
    private static final Book book6 = new Book("President’s Lady", author6, PARABLE, "1999-12-13", 5);
    private static final Book book7 = new Book("Status Single", author1, DRAMA, "1978-10-04", 5);
    private static final Book book8 = new Book("How May I Help You", author1, TRAGEDY, "1989-02-04", 3);
    private static final Book book9 = new Book("Indian Instinct", author1, STORY, "2020-01-29", 4);
    private static final Book book10 = new Book("Hit Refresh", author2, COMEDY, "2004-12-31", 3);

    public static ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);
        return books;
    }

    public static ArrayList<Author> getAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);
        authors.add(author6);
        return authors;
    }
}