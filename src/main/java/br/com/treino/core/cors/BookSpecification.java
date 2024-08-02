package br.com.treino.core.cors;

import br.com.treino.model.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

public class BookSpecification {

    public static Specification<Book> getBooks(String title, String author, String genre, LocalDate loanDate, LocalDate returnDate) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(title != null && !title.isEmpty()) {
                predicates.add((criteriaBuilder.like(root.get("title"), "%" + title + "%")));
            }
            if (author != null && !author.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("author"), "%" + author + "%"));
            }
            if (genre != null && !genre.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("genre"), "%" + genre + "%"));
            }
            if (loanDate != null && returnDate != null) {
                predicates.add(criteriaBuilder.between(root.get("publishedDate"), loanDate, returnDate));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
