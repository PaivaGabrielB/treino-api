package br.com.treino.repository;

import br.com.treino.model.entity.Book;
import br.com.treino.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Long> {
    List<Reservation> findByBookAndStatus(Book bookId, String status);
}
