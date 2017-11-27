package com.fincatto.documentofiscal.mdfe3.classes.nota.evento.cancelamento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class MDFeDetalhamentoEventoCancelamento extends DFBase {

    @Attribute(name = "versaoEvento", required = false)
    private String versaoEvento;

    @Element(name = "evCancMDFe")
    private MDFeEnviaEventoCancelamento eventoCancelamento;


    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = BigDecimalParser.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
    }

    public String getVersaoEvento() {
        return versaoEvento;
    }

    public MDFeEnviaEventoCancelamento getEventoCancelamento() {
        return eventoCancelamento;
    }

    public void setEventoCancelamento(MDFeEnviaEventoCancelamento eventoCancelamento) {
        this.eventoCancelamento = eventoCancelamento;
    }
}