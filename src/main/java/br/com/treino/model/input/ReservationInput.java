package br.com.treino.model.input;

import br.com.treino.model.entity.Book;
import br.com.treino.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationInput {

    private Long id;
    private Long book;
    private Long member;
    private LocalDate reservationDate;
    private String status;
}
