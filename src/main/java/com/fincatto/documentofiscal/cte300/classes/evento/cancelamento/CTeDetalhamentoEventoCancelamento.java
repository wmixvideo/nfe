package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class CTeDetalhamentoEventoCancelamento extends DFBase {
    private static final long serialVersionUID = 8502078404626629549L;

    @Attribute(name = "versaoEvento", required = true)
    private String versaoEvento;

    @Element(name = "evCancCTe", required = true)
    private CTeEnviaEventoCancelamento eventoCancelamento;

    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = BigDecimalParser.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
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