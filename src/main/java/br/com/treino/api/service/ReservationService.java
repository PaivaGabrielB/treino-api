package br.com.treino.api.service;

import br.com.treino.model.entity.Book;
import br.com.treino.model.entity.Member;
import br.com.treino.model.entity.Reservation;
import br.com.treino.model.input.ReservationInput;
import br.com.treino.model.output.ReservationOutput;
import br.com.treino.repository.BookRepository;
import br.com.treino.repository.MemberRepository;
import br.com.treino.repository.ReservationRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Reservation reserveBook(Long book, Long member) {
        Book bookId = bookRepository.findById(book)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found!"));
        Member memberId = memberRepository.findById(member)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found!"));

        Reservation reservation = new Reservation();
        reservation.setBook(bookId);
        reservation.setMember(memberId);
        reservation.setReservationDate(LocalDate.now());
        reservation.setStatus("Active");

        return reservationRepository.save(reservation);
    }

    public List<ReservationOutput> getActiveReservationForBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found!"));

        List<Reservation> reservations = reservationRepository.findByBookAndStatus(book, "Active");

        return reservations.stream()
                .map(reservation -> new ReservationOutput(
                        reservation.getId(),
                        reservation.getBook().getId(),
                        reservation.getMember().getId(),
                        reservation.getReservationDate(),
                        reservation.getStatus()
                ))
                .collect(Collectors.toList());
    }

    public void completeReservation(Long reservation) {
        Reservation reservationId = reservationRepository.findById(reservation)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found!"));
        reservationId.setStatus("Completed");
        reservationRepository.save(reservationId);

    }

}
