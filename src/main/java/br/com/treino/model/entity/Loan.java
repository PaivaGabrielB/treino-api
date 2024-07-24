package br.com.treino.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", unique = true)
    private Loan bookId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", unique = true)
    private Loan memberId;
    @Column(name = "loan_date")
    private LocalDate loanDate;
    @Column(name = "return_date")
    private LocalDate returnDate;
    @Column(name = "status")
    private String status;

    public Book getBookId() {
        return bookId.getBookId();
    }

    public Member getMemberId() {
        return memberId.getMemberId();
    }

    public Long setBookId(Long bookId) {
        return bookId;
    }

    public Long setMemberId(Long memberId) {
        return memberId;
    }

//    public Book setBookId(Book book) {
//        return book;
//    }
//
//    public Member setMemberId(Member member) {
//        return member;
//    }
}
