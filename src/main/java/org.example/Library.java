///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Library
// Course:          CS 200, Summer 2024
//
// Author:          Teresa Campbell
// Email:           tjcampbe@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//No help given or received
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
package org.example;
import java.util.ArrayList;


/**
 * This class has methods to filter books by year, sort by genre, and
 * find the largest genre.
 * @author Teresa Campbell
 */
public class Library {
    /**
     * This method prints the contents of bookList, with each Book printed
     * on a new
     * line, and the entire list in braces.
     *
     * @param bookList An ArrayList of Books to be printed
     */
    public static void printBooks(ArrayList<Book> bookList) {
        String formattedBooks = "{\n";
        for (Book book : bookList) {
            // toString() is an instance method defined in Book.java
            formattedBooks += "\t" + book.toString() + ",\n";
        }
        formattedBooks += "}\n";
        System.out.println(formattedBooks);
    }

    /**
     * This method removes all books from the given ArrayList that were
     * published
     * before the minYear.
     *
     * @param bookList The ArrayList of books to filter
     * @param minYear  The minimum year of publication allowed
     */

    // starts at the end of the bookList array and loops through to the
    // beginning so that it always has the correct size after removing a book.
    public static void filterByYear(ArrayList<Book> bookList, int minYear) {
        for (int i = bookList.size() - 1; i >= 0; i--) {
            Book currentBook = bookList.get(i);
            int currYear = currentBook.getYear();

            if (currYear < minYear) {
                bookList.remove(i);
            }
        }
    }


    /**
     * This method sorts the Books in bookList into four other ArrayLists
     * based on the four
     * possible genres of each Book: Cookbook, HistoricalFiction, Memoir,
     * and Thriller. Those
     * four ArrayLists will be elements of the ArrayList this method returns.
     * The parameter
     * bookList will not be modified.
     *
     * @param bookList The ArrayList of books to group by genre
     * @return An ArrayList of ArrayLists of Books, with each sub-ArrayList
     * containing
     * all the books of a single genre.
     */
    public static ArrayList<ArrayList<Book>> groupByGenre
    (ArrayList<Book> bookList) {
        ArrayList<Book> cookbooks = new ArrayList<>();
        ArrayList<Book> historicalFictions = new ArrayList<>();
        ArrayList<Book> memoirs = new ArrayList<>();
        ArrayList<Book> thrillers = new ArrayList<>();

        for (Book currentBook : bookList) {
            String genre = currentBook.getGenre();
            if (genre.equalsIgnoreCase("Cookbook")) {
                cookbooks.add(currentBook);
            }
            else if (genre.equalsIgnoreCase("Historical Fiction")) {
                historicalFictions.add(currentBook);
            }
            else if (genre.equalsIgnoreCase("Memoir")) {
                memoirs.add(currentBook);
            }
            else if (genre.equalsIgnoreCase("Thriller")) {
                thrillers.add(currentBook);
            }
        }

        // Creating an ArrayList of ArrayLists of Books
        ArrayList<ArrayList<Book>> listOfLists = new ArrayList<>();
        listOfLists.add(cookbooks);
        listOfLists.add(historicalFictions);
        listOfLists.add(memoirs);
        listOfLists.add(thrillers);

//        System.out.println(listOfLists);

        return listOfLists;
    }


    /**
     * This method finds the longest list of books stored in the given
     * list of lists.
     *
     * @param listOfLists The list of lists to search. It is non-empty,
     *                    but may otherwise contain any number of sub-lists.
     * @return The longest list of books
     */
    public static ArrayList<Book> getLongestBookList
    (ArrayList<ArrayList<Book>> listOfLists) {

        ArrayList<Book> longestList = new ArrayList<Book>();

        for (ArrayList<Book> currentList : listOfLists) {
            if (currentList.size() > longestList.size()) {
                longestList = currentList;
            }
        }

        return longestList;
    }

    /**
     * This method creates an ArrayList of Book objects.
     * It prints out the ArrayList's contents
     * before and after removing books published before 1980.
     * It then prints the largest genre
     * among those books remaining.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<Book>();

        // Creating instances of the Book class to add to library
        library.add(new Book("Educated", "Tara Westover",
                2018, "Memoir"));
        library.add(new Book("I Know Why the Caged Bird Sings",
                "Maya Angelou",
                1977, "Memoir"));
        library.add(new Book("In Order To Live", "Yeonmi Park",
                2015,
                "Memoir"));
        library.add(new Book("Mi Cocina", "Rick Martinez",
                2022,
                "Cookbook"));
        library.add(new Book("Night", "Elie Wiesel", 1960,
                "Memoir"));
        library.add(new Book("The Poisonwood Bible",
                "Barbara Kingsolver", 1998,
                "Historical Fiction"));
        library.add(new Book("Salt Fat Acid Heat",
                "Samin Nosrat", 2017,
                "Cookbook"));
        library.add(new Book("The Shining",
                "Stephen King", 1977,
                "Thriller"));
        library.add(new Book("The Silent Patient",
                "Alex Michaelides", 2019,
                "Thriller"));
        library.add(new Book("A Tale of Two Cities",
                "Charles Dickens", 1859,
                "Historical Fiction"));
        library.add(new Book("Things Fall Apart",
                "Chinua Achebe", 1958,
                "Historical Fiction"));
        library.add(new Book("Verity", "Colleen Hoover",
                2018, "Thriller"));
        library.add(new Book("A Woman First: First Woman",
                "Selina Meyer", 2029,
                "Memoir"));

        System.out.println("Original library:");
        printBooks(library);

        // This should remove books from the library.
        filterByYear(library, 1980);

        System.out.println("Library once all pre-1980 books are stolen:");
        printBooks(library);

        // These lines should find the largest genre among the remaining books.
        ArrayList<ArrayList<Book>> libraryGroupedByGenre =
                groupByGenre(library);
        ArrayList<Book> longestGenreList = getLongestBookList
                (libraryGroupedByGenre);

        if (!longestGenreList.isEmpty()) {
            String genreName = longestGenreList.get(0).getGenre();
            System.out.println("Largest genre: " + genreName);
            printBooks(longestGenreList);
        } else {
            System.out.println("No books in the largest genre!");
        }
    }
}
