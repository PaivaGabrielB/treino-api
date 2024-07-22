package br.com.codiub.eucuido.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "isbn")
    private Long isbn;
    @Column(name = "published_date")
    private LocalDate publishedDate;
    @Column(name = "genre")
    private String genre;
    @Column(name = "quantity")
    private Long quantity;

}
