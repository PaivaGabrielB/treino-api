package br.com.treino.api.controller;

import br.com.treino.api.service.ReservationService;
import br.com.treino.model.entity.Reservation;
import br.com.treino.model.input.ReservationInput;
import br.com.treino.model.output.ReservationOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> reserveBook(@RequestParam Long bookId, @RequestParam Long memberId) {
        Reservation reservation = reservationService.reserveBook(bookId, memberId);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/book/{book}")
    public ResponseEntity<List<ReservationOutput>> getActiveReservationsForBook(@PathVariable Long book) {
        List<ReservationOutput> reservations = reservationService.getActiveReservationForBook(book);
        return ResponseEntity.ok(reservations);
    }

    @PostMapping("/complete/{reservation}")
    public ResponseEntity<Void> completeReservation(@PathVariable Long reservation) {
        reservationService.completeReservation(reservation);
        return ResponseEntity.noContent().build();
    }

}
