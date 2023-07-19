import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library konyvtar = new Library();
        Book harryPotter = new Book("Harry Potter", List.of("J.K.Rowling"),"1997", Genre.TEENAGER);
        Book harryPotter2 = new Book("Harry Potter 2", List.of("J.K.Rowling"),"1998", Genre.TEENAGER);
        Book velunkVegetEr = new Book("Velünk véget ér", List.of("Colleen Hover"), "2017", Genre.ROMANTIC);
        Book aPokolAngyala = new Book("A pokol angyala", List.of("Ralph 'Sonny' Barger","Keith Zimmerman", "Kent Zimmerman"),"2023", Genre.LIFES_WORK );
        Book lsdGyerekeknek = new Book("LSD gyerekeknek", List.of("Flea"), "2023", Genre.LIFES_WORK);
        Reader renata = new Reader("Renata", "asd123");
        Reader gina = new Reader("Gina", "abrakadabra");
        renata.borrowBook("Harry Potter");
        renata.borrowBook("Velünk véget ér");
        renata.getListOfBooksBorrowed();
        gina.addPreferedGenre(Genre.ROMANTIC, Genre.DARK, Genre.ACTION);
        System.out.println(gina.getPreferedGenres());
        gina.borrowBook(lsdGyerekeknek.getTitle());
        gina.getListOfBooksBorrowed();
        konyvtar.listAllLibrary();
        konyvtar.findBookByTitle("A pokol angyala");
        konyvtar.findBookByTitle("Harry Potter");
        renata.returnBook(harryPotter);
        konyvtar.listAllLibrary();
        konyvtar.findBookByWriter("J.K.Rowling");
        konyvtar.findBookByGenre(Genre.LIFES_WORK);
        konyvtar.whoBorrowedTheMostBooks();
    }
}