package br.com.codiub.eucuido.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    private Long id;
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "loan_date")
    private Long memberId;
    @Column(name = "member_id")
    private LocalDate loanDate;
    @Column(name = "return_date")
    private LocalDate returnDate;
    @Column(name = "status")
    private String status;
}
