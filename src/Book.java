import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

public class Book extends Library{
    private final String title;
    private final List<String> writers;
    private final String publishingYear;
    private final Genre genre;
    private int howManyTimesABookHasBeenBorrowedCounter;

    public Book(String title, List<String> writers, String publishingYear, Genre genre) {
        this.title = title;
        this.writers = new ArrayList<>(writers);
        this.publishingYear = publishingYear;
        this.genre = genre;
        addBookToLibrary(this);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getWriters() {
        return writers;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", writers=" + writers +
                ", publishingYear='" + publishingYear + '\'' +
                ", genre=" + genre +
                '}';
    }
}
