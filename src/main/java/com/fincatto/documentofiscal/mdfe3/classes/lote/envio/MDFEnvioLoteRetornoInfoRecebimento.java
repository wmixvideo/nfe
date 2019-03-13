package com.fincatto.documentofiscal.mdfe3.classes.lote.envio;

import java.math.BigInteger;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import java.time.LocalDateTime;

/**
 * Created by Eldevan Nery Junior on 14/11/17.
 * @info Dados do Recibo do Lote.
 */

@Root(name = "infRec")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFEnvioLoteRetornoInfoRecebimento extends DFBase {
    private static final long serialVersionUID = 3335333639059116239L;

    @Element(name = "nRec", required = false)
    private String numeroRecibo;

    @Element(name = "dhRecbto", required = false)
    private LocalDateTime dataRecibo;

    @Element(name = "tMed", required = false)
    private BigInteger tempoMedio;

    public String getNumeroRecibo() {
        return this.numeroRecibo;
    }

    /**
     * Número do Recibo
     */
    public void setNumeroRecibo(final String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public LocalDateTime getDataRecibo() {
        return this.dataRecibo;
    }

    /**
     * Data e hora do recebimento, no formato AAAA-MM-DDTHH:MM:SS TZD
     */
    public void setDataRecibo(final LocalDateTime dataRecibo) {
        this.dataRecibo = dataRecibo;
    }

    public BigInteger getTempoMedio() {
        return this.tempoMedio;
    }

    /**
     * Tempo médio de resposta do serviço (em segundos) dos últimos 5 minutos
     */
    public void setTempoMedio(final BigInteger tempoMedio) {
        this.tempoMedio = tempoMedio;
    }
}
