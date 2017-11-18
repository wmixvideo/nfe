package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
public class MDFeDetalhamentoEventoRegistroPassagem extends DFBase {

    @Attribute(name = "versaoEvento", required = false)
    private String versaoEvento;

    @Element(name = "evMDFeRegPassagem")
    private MDFeEnviaEventoRegistroPassagem eventoRegistroPassagem;


    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = BigDecimalParser.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
    }

    public String getVersaoEvento() {
        return versaoEvento;
    }

    public MDFeEnviaEventoRegistroPassagem getEventoRegistroPassagem() {
        return eventoRegistroPassagem;
    }

    public void setEventoRegistroPassagem(MDFeEnviaEventoRegistroPassagem eventoRegistroPassagem) {
        this.eventoRegistroPassagem = eventoRegistroPassagem;
    }
}