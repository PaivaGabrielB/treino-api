package br.com.treino.model.entity;

import br.com.treino.model.defaults.DefaultEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name = "user")
public class User extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private Role role;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "telefone")
    private String telefone;

    public boolean isAdmin() {
        if(this.role.getRole().equals("ADMIN")) {
            return true;
        } else {
            return false;
        }
    }
}
