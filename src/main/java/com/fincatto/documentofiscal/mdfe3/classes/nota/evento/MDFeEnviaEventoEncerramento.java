package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import java.time.LocalDate;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 17/11/17.
 */
@Root(name = "evEncMDFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeEnviaEventoEncerramento extends DFBase {
    private static final long serialVersionUID = -6894944230355205786L;

    @Element(name = "descEvento")
    private String descricaoEvento = "Encerramento";

    @Element(name = "nProt")
    private String protocoloAutorizacao;

    /**
     * Data que o Manifesto foi encerrado
     */
    @Element(name = "dtEnc")
    private LocalDate dataEncerramento;

    /**
     * UF de encerramento do Manifesto
     */
    @Element(name = "cUF")
    private DFUnidadeFederativa uf;

    /**
     * Código do Município de Encerramento do manifesto
     */
    @Element(name = "cMun")
    private String codigoMunicipio;

    public void setProtocoloAutorizacao(final String protocoloAutorizacao) {
        StringValidador.exatamente15N(protocoloAutorizacao, "Protocolo de Autorizacao");
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public String getProtocoloAutorizacao() {
        return this.protocoloAutorizacao;
    }

    public void setDescricaoEvento(final String descricaoEvento) {
        final String defaultValue = "Encerramento";
        StringValidador.equals(defaultValue, descricaoEvento);
        this.descricaoEvento = descricaoEvento;
    }

    public String getDescricaoEvento() {
        return this.descricaoEvento;
    }

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public void setCodigoMunicipio(final String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public LocalDate getDataEncerramento() {
        return this.dataEncerramento;
    }

    public void setDataEncerramento(final LocalDate dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
}