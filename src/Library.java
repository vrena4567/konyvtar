import java.util.*;

public class Library {
    private static Map<Book, Integer> bookListWithQuantity = new HashMap<>();
    private static Set<Reader> readersList = new HashSet<>();
    protected static Map<Book, Integer> howManyTimesBooksBorrowedCounter = new HashMap<>();
    public void addBookToLibrary(Book book) {
        int currentQuantity = bookListWithQuantity.getOrDefault(book, 0);
        bookListWithQuantity.put(book, currentQuantity + 1);
    }
    public void addBookWithQuantity(Book book, int quantity) {
        int currentQuantity = bookListWithQuantity.getOrDefault(book, 0);
        bookListWithQuantity.put(book, currentQuantity + quantity);
    }

    public void listAllLibrary() {
        System.out.println("The library's whole bookset: ");
        for (Map.Entry<Book, Integer> actualEntry : bookListWithQuantity.entrySet()) {
            System.out.println("Book: " + actualEntry.getKey().getTitle() + ", quantity: " + actualEntry.getValue());
        }
    }
    public void addReaderToReadersList(Reader reader) {
        readersList.add(reader);
    }

    public static Map<Book, Integer> getBookListWithQuantity() {
        return bookListWithQuantity;
    }

    public void findBookByTitle(String title) {
        for (Map.Entry<Book, Integer> actualEntry : getBookListWithQuantity().entrySet()) {
            if (actualEntry.getKey().getTitle().equals(title) && actualEntry.getValue() > 0) {
                System.out.println("The book " + actualEntry.getKey().getTitle() + " is available: " + actualEntry.getValue() + " piece");
                return;
            } else if (actualEntry.getKey().getTitle().equals(title) && actualEntry.getValue() == 0) {
                System.out.println("The book is currently not available");
                return;
            }
        }
        System.out.println("There is no such book.");
    }

    public void findBookByWriter(String writer) {
        System.out.println("Books under this writer '" + writer + "':");
        for (Map.Entry<Book, Integer> actualEntry : getBookListWithQuantity().entrySet()) {
            for (String actualWriter : actualEntry.getKey().getWriters()) {
                if(actualWriter.equals(writer)) {
                    System.out.println(actualEntry.getKey());
                }
            }
        }
    }

    public void findBookByGenre(Genre genre) {
        for (Map.Entry<Book, Integer> actualEnrty : getBookListWithQuantity().entrySet()) {
            if(actualEnrty.getKey().getGenre().equals(genre)) {
                System.out.println(actualEnrty.getKey());
            }
        }
    }
    public void whoBorrowedTheMostBooks() {
        int maximum = 0;
        Reader whoHasTheMostBooks = null;
        for ( Reader actual : readersList) {
            if(actual.booksBorrowedCounter > maximum) {
                maximum = actual.booksBorrowedCounter;
                whoHasTheMostBooks = actual;
            }
        }
        System.out.println("The reader who borrowed the most books: " + whoHasTheMostBooks.getName() + " with " + maximum + " books");
    }
    
    public void mostBorrowedBook() {
        int maximum = 0;
        Book mostBorrowed = null;
        for (Map.Entry<Book, Integer> actualEntry : howManyTimesBooksBorrowedCounter.entrySet()) {
            if(actualEntry.getValue() > maximum) {
                maximum = actualEntry.getValue();
                mostBorrowed = actualEntry.getKey();
            }
        }
        System.out.println("The most borrowed book is: " + mostBorrowed.getTitle() + " with " + maximum + " times");
    }
}


