package br.com.treino.model.defaults;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DefaultEntityDTO {

    private Boolean activated;
    private LocalDateTime updated;
    private LocalDateTime created;
}
