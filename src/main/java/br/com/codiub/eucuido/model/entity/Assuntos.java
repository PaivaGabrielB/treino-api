package br.com.codiub.eucuido.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "ASSUNTOS", schema = "DBO_SIF")
public class Assuntos {


    @Id
    @Column(name = "ASSUNTO")
    private Long assunto;

    @NotNull
    @Column(name = "DESCRICAO_SIMPLES")
    private String descricaoSimples;

    @NotNull
    @Column(name = "PENALIDADE_INICIO")
    private Long penalidadeInicio;
    @NotNull
    @Column(name = "PENALIDADE_FINAL")
    private Long penalidadeFinal;
    @NotNull
    @Column(name = "DESCRICAO_COMPLETA")
    private String descricaoCompleta;
    @NotNull
    @Column(name = "DISPOSITIVO_INFRINGIDO")
    private String dispositivoInfringido;
    @NotNull
    @Column(name = "INFORMACOES_COMPL")
    private String informacoesCompl;
    @NotNull
    @Column(name = "PRAZO_RECURSO")
    private Long prazoRecurso;
    @NotNull
    @Column(name = "PRAZO_CUMPRIMENTO")
    private Long prazoCumprimento;
    @NotNull
    @Column(name = "STATUS")
    private String status;
    @NotNull
    @Column(name = "FATO_GERADOR")
    private Long fatoGerador;
    @NotNull
    @Column(name = "COMPOSICAO")
    private Long composicao;
    @NotNull
    @Column(name = "ASSUNTO_ATUAL")
    private Long assuntoAtual;

}
