package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class CTeDetalhamentoEventoCancelamento extends DFBase {

    @Attribute(name = "versaoEvento", required = true)
    private String versaoEvento;

    @Element(name = "evCancCTe", required = true)
    private CTeEnviaEventoCancelamento eventoCancelamento;


    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = BigDecimalParser.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
    }

    public String getVersaoEvento() {
        return versaoEvento;
    }

    public CTeEnviaEventoCancelamento getEventoCancelamento() {
        return eventoCancelamento;
    }

    public void setEventoCancelamento(CTeEnviaEventoCancelamento eventoCancelamento) {
        this.eventoCancelamento = eventoCancelamento;
    }
}