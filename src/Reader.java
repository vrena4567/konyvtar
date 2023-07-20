import java.util.*;

public class Reader extends Library {
    private final String name;
    private final String readerIdentityNumber;
    private Set<Genre> preferredGenre = new HashSet<>();
    private Set<Book> booksBorrowed = new HashSet<>();
    protected int booksBorrowedCounter;


    public Reader(String name, String readerIdentityNumber) {
        this.name = name;
        this.readerIdentityNumber = readerIdentityNumber;
        addReaderToReadersList(this);
    }

    public void borrowBook(String title) {
        for (Map.Entry<Book, Integer> actualEntry : getBookListWithQuantity().entrySet()) {
            if (actualEntry.getKey().getTitle().equals(title) && actualEntry.getValue() > 0) {
                System.out.println("The book " + actualEntry.getKey().getTitle() + " is available: " + actualEntry.getValue() + " piece");
                booksBorrowed.add(actualEntry.getKey());
                int actualBorrowCounter = howManyTimesBooksBorrowedCounter.getOrDefault(actualEntry.getKey(), 0);
                howManyTimesBooksBorrowedCounter.put(actualEntry.getKey(), actualBorrowCounter + 1);
                int actualNumber = getBookListWithQuantity().getOrDefault(actualEntry.getKey(), 0);
                getBookListWithQuantity().put(actualEntry.getKey(), actualNumber - 1);
                System.out.println("Remaining quantity after your are borrowing this book: " + actualEntry.getValue());
                return;
            } else if (actualEntry.getKey().getTitle().equals(title) && actualEntry.getValue() == 0) {
                System.out.println("The book is not available currently");
                return;
            }
        }
        System.out.println("There is no such book.");
    }

    public void returnBook(Book book) {
        booksBorrowed.remove(book);
        int actualNumber = getBookListWithQuantity().getOrDefault(book, 0);
        getBookListWithQuantity().put(book, actualNumber + 1);
        System.out.println(book.getTitle() + "is returned");
        System.out.print("Rest of ");
        getListOfBooksBorrowed();
    }

    public void getListOfBooksBorrowed() {
        System.out.println(name + "'s borrowed books:");
        for (Book actual : booksBorrowed) {
            System.out.println(actual);
            booksBorrowedCounter++;
        }
    }

    public void addPreferedGenre(Genre genre) {
        this.preferredGenre.add(genre);
    }

    public void addPreferedGenre(Genre genre, Genre genre1, Genre genre2) {
        this.preferredGenre.add(genre);
        this.preferredGenre.add(genre1);
        this.preferredGenre.add(genre2);
    }

    public String getPreferedGenres() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Genre actual : preferredGenre) {
            stringBuilder.append(actual).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return this.name + "'s prefered genres: " + stringBuilder;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", readerIdentityNumber='" + readerIdentityNumber + '\'' +
                ", prefferedGenre=" + preferredGenre +
                ", booksBorrowed=" + booksBorrowed +
                '}';
    }
}
