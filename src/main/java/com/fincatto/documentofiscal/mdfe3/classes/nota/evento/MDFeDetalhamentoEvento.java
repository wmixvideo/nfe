package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.cancelamento.MDFeEnviaEventoCancelamento;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
public class MDFeDetalhamentoEvento extends DFBase {

    private static final long serialVersionUID = 4567286592593410285L;

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

    @Element(name = "evIncCondutorMDFe", required = false)
    private MDFeEnviaEventoIncluirCondutor enviaEventoIncluirCondutor;

    public String getVersaoEvento() {
        return this.versaoEvento;
    }

    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = BigDecimalParser.tamanho5Com2CasasDecimais(versaoEvento, "versao do Evento");
    }

    public MDFeEnviaEventoCancelamento getMdFeEnviaEventoCancelamento() {
        return this.mdFeEnviaEventoCancelamento;
    }

    public void setMdFeEnviaEventoCancelamento(final MDFeEnviaEventoCancelamento mdFeEnviaEventoCancelamento) {
        this.mdFeEnviaEventoCancelamento = mdFeEnviaEventoCancelamento;
    }

    public MDFeEnviaEventoRegistroPassagem getEventoRegistroPassagem() {
        return this.eventoRegistroPassagem;
    }

    public void setEventoRegistroPassagem(final MDFeEnviaEventoRegistroPassagem eventoRegistroPassagem) {
        this.eventoRegistroPassagem = eventoRegistroPassagem;
    }

    public MDFeEnviaEventoRegistroPassagemAutomatica getEventoRegistroPassagemAutomatica() {
        return this.eventoRegistroPassagemAutomatica;
    }

    public void setEventoRegistroPassagemAutomatica(final MDFeEnviaEventoRegistroPassagemAutomatica eventoRegistroPassagemAutomatica) {
        this.eventoRegistroPassagemAutomatica = eventoRegistroPassagemAutomatica;
    }

    public MDFeEnviaEventoEncerramento getEnviaEventoEncerramento() {
        return this.enviaEventoEncerramento;
    }

    public void setEnviaEventoEncerramento(final MDFeEnviaEventoEncerramento enviaEventoEncerramento) {
        this.enviaEventoEncerramento = enviaEventoEncerramento;
    }

    public MDFeEnviaEventoIncluirCondutor getEnviaEventoIncluirCondutor() {
        return enviaEventoIncluirCondutor;
    }

    public void setEnviaEventoIncluirCondutor(MDFeEnviaEventoIncluirCondutor enviaEventoIncluirCondutor) {
        this.enviaEventoIncluirCondutor = enviaEventoIncluirCondutor;
    }

}
