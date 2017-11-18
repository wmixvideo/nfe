package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.cancelamento.MDFeEnviaEventoCancelamento;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
public class MDFeDetalhamentoEvento extends DFBase {

    @Attribute(name = "versaoEvento")
    private String versaoEvento;

    @Element(name = "evCancMDFe", required = false)
    private MDFeEnviaEventoCancelamento mdFeEnviaEventoCancelamento;

    @Element(name = "evMDFeRegPassagem", required = false)
    private MDFeEnviaEventoRegistroPassagem eventoRegistroPassagem;

    @Element(name = "evMDFeRegPassagemAuto", required = false)
    private MDFeEnviaEventoRegistroPassagemAutomatica eventoRegistroPassagemAutomatica;

    @Element(name = "evEncMDFe", required = false)
    private MDFeEnviaEventoEncerramento enviaEventoEncerramento;

    public String getVersaoEvento() {
        return versaoEvento;
    }

    public void setVersaoEvento(BigDecimal versaoEvento) {
        this.versaoEvento = BigDecimalParser.tamanho5Com2CasasDecimais(versaoEvento, "versao do Evento");
    }

    public MDFeEnviaEventoCancelamento getMdFeEnviaEventoCancelamento() {
        return mdFeEnviaEventoCancelamento;
    }

    public void setMdFeEnviaEventoCancelamento(MDFeEnviaEventoCancelamento mdFeEnviaEventoCancelamento) {
        this.mdFeEnviaEventoCancelamento = mdFeEnviaEventoCancelamento;
    }

    public MDFeEnviaEventoRegistroPassagem getEventoRegistroPassagem() {
        return eventoRegistroPassagem;
    }

    public void setEventoRegistroPassagem(MDFeEnviaEventoRegistroPassagem eventoRegistroPassagem) {
        this.eventoRegistroPassagem = eventoRegistroPassagem;
    }

    public MDFeEnviaEventoRegistroPassagemAutomatica getEventoRegistroPassagemAutomatica() {
        return eventoRegistroPassagemAutomatica;
    }

    public void setEventoRegistroPassagemAutomatica(MDFeEnviaEventoRegistroPassagemAutomatica eventoRegistroPassagemAutomatica) {
        this.eventoRegistroPassagemAutomatica = eventoRegistroPassagemAutomatica;
    }

    public MDFeEnviaEventoEncerramento getEnviaEventoEncerramento() {
        return enviaEventoEncerramento;
    }

    public void setEnviaEventoEncerramento(MDFeEnviaEventoEncerramento enviaEventoEncerramento) {
        this.enviaEventoEncerramento = enviaEventoEncerramento;
    }
}