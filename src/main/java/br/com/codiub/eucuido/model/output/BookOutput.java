package br.com.codiub.eucuido.model.output;

import br.com.codiub.eucuido.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookOutput {

    private Long id;
    private String title;
    private String author;
    private Long isbn;
    private LocalDate publishedDate;
    private String genre;
    private Long quantity;

    public BookOutput(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.publishedDate = book.getPublishedDate();
        this.genre = book.getGenre();
        this.quantity = book.getQuantity();
    }
}
