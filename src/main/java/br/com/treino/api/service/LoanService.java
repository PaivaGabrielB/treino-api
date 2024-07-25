package br.com.treino.api.service;

import br.com.treino.model.entity.Book;
import br.com.treino.model.entity.Loan;
import br.com.treino.model.entity.Member;
import br.com.treino.model.input.LoanInput;
import br.com.treino.repository.BookRepository;
import br.com.treino.repository.LoanRepository;
import br.com.treino.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    @Autowired
    private final LoanRepository loanRepository;

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Loan findById(Long id) {
        return loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found!"));
    }

    public List<Loan> listAllLoans() {
        return loanRepository.findAll();
    }

    public Loan save(LoanInput loanInput) {
        Loan loan = modelMapper.map(loanInput, Loan.class);
        loan.setMember(memberRepository.findById(loanInput.getMember()).orElseThrow(() -> new RuntimeException("Member not found!")));
        loan.setBook(bookRepository.findById(loanInput.getBook()).orElseThrow(() -> new RuntimeException("Book not found!")));

        return loanRepository.save(loan);
    }

    public  Loan updateById(Long id, LoanInput loanInput) {
        Loan loan = findById(id);
        modelMapper.map(loanInput, loan);
        return loanRepository.save(loan);
    }

    public void deleteById(Long id) {
        Loan loan = findById(id);
        loanRepository.delete(loan);
    }
}
