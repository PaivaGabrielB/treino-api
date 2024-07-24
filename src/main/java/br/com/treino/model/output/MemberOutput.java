package br.com.treino.model.output;

import br.com.treino.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberOutput {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate memberShip;

    public MemberOutput(Member member) {
        this.id = member.getId();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.email = member.getEmail();
        this.memberShip = member.getMemberShip();
    }
}
