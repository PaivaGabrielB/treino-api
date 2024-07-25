package br.com.treino.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class LoanInput {
    private Long book;

    private Long member;

    private LocalDate loanDate;

    private LocalDate returnDate;

    private String status;

//    public Long getMemberId() {
//        return memberId;
//    }
//
//    public Long getBookId() {
//        return getBookId();
//    }
}
