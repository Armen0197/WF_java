package oop.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryAPI {

    public static ArrayList<Author> getAllAuthors(ArrayList<Book> books) {
        ArrayList<Author> authors = new ArrayList<>();
        for (Book book : books) {
            authors.add(book.author);
        }
        return authors;
    }

    public static ArrayList<Book> getBookOfGivenAuthor(ArrayList<Book> books, Author author) {
        ArrayList<Book> booksOfGivenAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equals(author.getName())) {
                booksOfGivenAuthor.add(book);
            }
        }
        return booksOfGivenAuthor;
    }

    public static ArrayList<Book> getTopBooksOfGivenAuthor(ArrayList<Book> books, Author author) {
        ArrayList<Book> booksOfGivenAuthor = getBookOfGivenAuthor(books, author);
        ArrayList<Book> topBooks = new ArrayList<>();
        for (Book book : booksOfGivenAuthor) {
            if (book.getRating() > 3) {
                topBooks.add(book);
            }
        }
        return topBooks;
    }

    public static ArrayList<Author> searchAllAuthorsMatchingGivenString(String givenString) {
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<Author> allAuthors = DataProvider.getAuthors();
        for (Author author : allAuthors) {
            if ((author.getName().equals(givenString) || author.getSurname().equals(givenString))
                    || (author.getName().contains(givenString) || author.getSurname().contains(givenString))) {
                authors.add(author);
            }
        }
        return authors;
    }

    public static ArrayList<Book> searchAllBooksMatchingGivenString(String givenString) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Book> allBooks = DataProvider.getAllBooks();
        for (Book book : allBooks) {
            if (book.getName().equals(givenString) || book.getAuthor().getName().equals(givenString) || book.getAuthor().getSurname().equals(givenString)
                    || book.getName().contains(givenString) || book.getAuthor().getName().contains(givenString) || book.getAuthor().getSurname().contains(givenString)) {
                books.add(book);
            }
        }
        return books;
    }

    public static List<Book> searchAllBooksWithReleaseDatePeriod(String startDate, String endDate) {
        List<LocalDate> dates = getDatesBetweenGivenDates(startDate, endDate);
        List<Book> books = DataProvider.getAllBooks();
        List<Book> booksInDate = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            for (Book book : books) {
                if (dates.get(i).toString().equals(book.getPublishDate())) {
                    booksInDate.add(book);
                }
            }
        }
        return booksInDate;
    }

    private static List<LocalDate> getDatesBetweenGivenDates(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }
        return totalDates;
    }
}