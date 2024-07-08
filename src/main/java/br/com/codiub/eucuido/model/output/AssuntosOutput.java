package br.com.codiub.eucuido.model.output;

import br.com.codiub.eucuido.model.entity.Assuntos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssuntosOutput {

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

    public AssuntosOutput(Assuntos assuntos) {
        this.assunto = assuntos.getAssunto();
        this.descricaoSimples = assuntos.getDescricaoSimples();
        this.penalidadeInicio = assuntos.getPenalidadeInicio();
        this.penalidadeFinal = assuntos.getPenalidadeFinal();
        this.descricaoCompleta = assuntos.getDescricaoCompleta();
        this.dispositivoInfringido = assuntos.getDispositivoInfringido();
        this.informacoesCompl = assuntos.getInformacoesCompl();
        this.prazoRecurso = assuntos.getPrazoRecurso();
        this.prazoCumprimento = assuntos.getPrazoCumprimento();
        this.status = assuntos.getStatus();
        this.fatoGerador = assuntos.getFatoGerador();
        this.composicao = assuntos.getComposicao();
        this.assuntoAtual = assuntos.getAssuntoAtual();
    }
}
