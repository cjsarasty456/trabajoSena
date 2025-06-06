import java.time.LocalDate;

public class Book {

    public String isbn;
    public String title;
    public String author;
    public String genere;
    public LocalDate publicationDate;

    public Book() {
    }

    public Book(String isbn, String title, String author, String genere, LocalDate publicationDate) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", genere=" + genere
                + ", publicationDate=" + publicationDate + "]";
    }

}
