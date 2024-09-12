package br.com.treino.model.defaults;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class DefaultEntity {

    @NotNull
    @Column(name = "activated")
    private Boolean activated;
    @NotNull
    @Column(name = "created")
    private LocalDateTime created;
    @NotNull
    @Column(name = "updated")
    private LocalDateTime updated;

    @PrePersist
    public void onCreate() {
        this.activated = Boolean.TRUE;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updated = LocalDateTime.now();
    }
}
