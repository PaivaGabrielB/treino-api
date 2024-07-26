package br.com.treino.model.output;

import br.com.treino.model.entity.Book;
import br.com.treino.model.entity.Member;
import br.com.treino.model.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationOutput {

    private Long id;
    private Long book;
    private Long member;
    private LocalDate reservationDate;
    private String status;

    public ReservationOutput(Reservation reservation) {

        this.id = reservation.getId();
        this.book = reservation.getBook().getId();
        this.member = reservation.getMember().getId();
        this.reservationDate = reservation.getReservationDate();
        this.status = reservation.getStatus();
    }
}
