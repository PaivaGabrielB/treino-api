package br.com.treino.model.input;

import br.com.treino.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String endereco;
    private String cpf;
    private String telefone;

}
