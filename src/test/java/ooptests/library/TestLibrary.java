package ooptests.library;

import oop.library.Author;
import oop.library.Book;
import oop.library.DataProvider;
import oop.library.LibraryAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestLibrary {

    @Test
    void testGetAllAuthors() {
        Assert.assertEquals(LibraryAPI.getAllAuthors(DataProvider.getAllBooks()).size(), 10);
    }

    @Test
    void testGetAllBooksOfGivenAuthor() {
        ArrayList<Book> books = LibraryAPI.getBookOfGivenAuthor(DataProvider.getAllBooks(), DataProvider.getAuthors().get(0));
        Assert.assertEquals(books.get(0).getName(), "The Testaments");
        Assert.assertEquals(books.get(1).getName(), "Status Single");
        Assert.assertEquals(books.get(2).getName(), "How May I Help You");
        Assert.assertEquals(books.get(3).getName(), "Indian Instinct");
    }

    @Test
    void testGetTopBooksOfGivenAuthor() {
        ArrayList<Book> books = LibraryAPI.getTopBooksOfGivenAuthor(DataProvider.getAllBooks(), DataProvider.getAuthors().get(0));
        Assert.assertEquals(books.get(0).getName(), "The Testaments");
        Assert.assertEquals(books.get(1).getName(), "Status Single");
        Assert.assertEquals(books.get(2).getName(), "Indian Instinct");
    }

    @Test
    void testSearchAllAuthorsMatchingGivenString() {
        ArrayList<Author> authors = LibraryAPI.searchAllAuthorsMatchingGivenString("Pet");
        Assert.assertEquals(authors.get(0).getSurname(), "Baker");
    }

    @Test
    void testSearchAllBooksMatchingGivenString() {
        ArrayList<Book> books = LibraryAPI.searchAllBooksMatchingGivenString("Obama:");
        Assert.assertEquals(books.get(0).getPublishDate(), "2000-05-19");
    }

    @Test
    void searchAllBooksWithReleaseDatePeriod() {
        List<Book> books = LibraryAPI.searchAllBooksWithReleaseDatePeriod("1999-12-10", "1999-12-19");
        Assert.assertEquals(books.get(0).getName(), "President’s Lady");
    }
}