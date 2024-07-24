package br.com.treino.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInput {
    private String title;
    private String author;
    private Long isbn;
    private LocalDate publishedDate;
    private String genre;
    private Long quantity;
}
