package org.example;

/**
 * Each instance of this class represents a library Book, which can have four properties:
 * title, author, year, and genre. Do not edit this class.
 */
public class Book {
    // Declaring instance variables
    private String title;
    private String author;
    private int year;
    private String genre;

    /**
     * This is the constructor for the Book class. It creates a new Book instance, and sets
     * the Book's instance variables to the given parameters.
     *
     * @param title The title of the book
     * @param name The author's name
     * @param year The year the book was published
     * @param genre The genre of the book: "Cookbook", "Historical Fiction", "Memoir", or "Thriller"
     */
    public Book(String title, String name, int year, String genre) {
        this.title = title;
        this.author = name;
        this.year = year;
        this.genre = genre;
    }

    // These are instance methods that can be called on a Book object in Library.java.
    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getYear() {
        return this.year;
    }

    public String toString() {
        return this.title + " - " + this.author + " (" + this.year + " " + this.genre + ")";
    }
}
