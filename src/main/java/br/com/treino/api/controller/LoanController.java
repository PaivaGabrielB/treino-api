package br.com.treino.api.controller;

import br.com.treino.api.service.LoanService;
import br.com.treino.model.entity.Loan;
import br.com.treino.model.input.LoanInput;
import br.com.treino.model.output.LoanOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody LoanInput loanInput) {
        Loan createdLoan = loanService.save(loanInput);
        LoanOutput loanOutput = new LoanOutput(createdLoan);
        return ResponseEntity.ok(loanOutput);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody @Valid LoanInput loanInput) {
        Loan updatedLoan = loanService.updateById(id, loanInput);
        LoanOutput loanOutput = new LoanOutput(updatedLoan);
        return ResponseEntity.ok(loanOutput);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deactivateById(@PathVariable Long id) {
        loanService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Loan deleted successfully\"}");
    }

    @GetMapping
    public ResponseEntity<List<LoanOutput>> listAll() {
        List<Loan> loans = loanService.listAllLoans();
        List<LoanOutput> responseDTOS = loans.stream()
                .map(LoanOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanOutput> getById(@PathVariable Long id) {
        Loan loan = loanService.findById(id);
        LoanOutput loanOutput = new LoanOutput(loan);
        return ResponseEntity.ok(loanOutput);
    }
}
