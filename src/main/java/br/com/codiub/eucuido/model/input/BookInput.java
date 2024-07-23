package br.com.codiub.eucuido.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class BookInput {
    private String title;
    private String author;
    private Long isbn;
    private LocalDate publishedDate;
    private String genre;
    private Long quantity;
}
