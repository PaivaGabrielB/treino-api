package br.com.treino.model.output;

import br.com.treino.model.entity.Book;
import br.com.treino.model.entity.Loan;
import br.com.treino.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanOutput {

    private Long id;

    private Book bookId;

    private Member memberId;

    private LocalDate loanDate;

    private LocalDate returnDate;

    private String status;

    public LoanOutput(Loan loan) {
        this.id = loan.getId();
        this.bookId = loan.getBookId();
        this.memberId = loan.getMemberId();
        this.loanDate = loan.getLoanDate();
        this.returnDate = loan.getReturnDate();
        this.status = loan.getStatus();
    }

}
