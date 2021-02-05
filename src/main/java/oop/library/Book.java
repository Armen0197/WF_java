package oop.library;

public class Book {

    String name;
    Genre genre;
    Author author;
    String publishDate;
    int rating;

    public Book(String name, Author author, Genre genre, String publishDate, int rating) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.publishDate = publishDate;
        this.rating = rating;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Author: %s %s.", getName(), getAuthor().getName(), getAuthor().getSurname());
    }
}
