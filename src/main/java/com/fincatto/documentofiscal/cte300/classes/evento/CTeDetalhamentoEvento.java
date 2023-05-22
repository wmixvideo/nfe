package com.fincatto.documentofiscal.cte300.classes.evento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.evento.cancelamento.CTeEnviaEventoCancelamento;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class CTeDetalhamentoEvento extends DFBase {
    private static final long serialVersionUID = 7006866358832001912L;

    @Attribute(name = "versaoEvento")
    private String versaoEvento;

    @Element(name = "evCancCTe")
    private CTeEnviaEventoCancelamento eventoCancelamento;

    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
    }

    public String getVersaoEvento() {
        return this.versaoEvento;
    }

    public CTeEnviaEventoCancelamento getEventoCancelamento() {
        return this.eventoCancelamento;
    }

    public void setEventoCancelamento(final CTeEnviaEventoCancelamento eventoCancelamento) {
        this.eventoCancelamento = eventoCancelamento;
    }
}