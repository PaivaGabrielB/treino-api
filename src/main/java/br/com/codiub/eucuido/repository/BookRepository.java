package br.com.codiub.eucuido.repository;

import br.com.codiub.eucuido.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
