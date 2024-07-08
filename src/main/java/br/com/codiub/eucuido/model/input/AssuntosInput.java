package br.com.codiub.eucuido.model.input;

import javax.persistence.Column;
import java.time.LocalDate;

public class AssuntosInput {

    private Long assunto;

    private String descricaoSimples;

    private Long penalidadeInicio;

    private Long penalidadeFinal;

    private String descricaoCompleta;

    private String dispositivoInfringido;

    private String informacoesCompl;

    private Long prazoRecurso;

    private Long prazoCumprimento;

    private String status;

    private Long fatoGerador;

    private Long composicao;

    private Long assuntoAtual;
}
