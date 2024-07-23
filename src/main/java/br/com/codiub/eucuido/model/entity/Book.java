package br.com.codiub.eucuido.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
