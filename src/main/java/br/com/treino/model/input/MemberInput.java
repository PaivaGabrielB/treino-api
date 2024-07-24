package br.com.treino.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberInput {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate memberShip;
}
