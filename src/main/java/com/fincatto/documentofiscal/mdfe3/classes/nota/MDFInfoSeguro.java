package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 07/12/17. Informações de Seguro da Carga.
 */
@Root(name = "seg")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoSeguro extends DFBase {
    private static final long serialVersionUID = 665561268515018765L;

    @Element(name = "infResp")
    private MDFInfoSeguroResponsavel responsavelSeguro;

    @Element(name = "infSeg", required = false)
    private MDFInfoSeguroInfo info;

    @Element(name = "nApol", required = false)
    private String apolice;

    @Element(name = "nAver", required = false)
    private String averbacao;

    public MDFInfoSeguroInfo getInfo() {
        return this.info;
    }

    /**
     * Informações da seguradora
     */
    public void setInfo(final MDFInfoSeguroInfo info) {
        this.info = info;
    }

    public String getApolice() {
        return this.apolice;
    }

    /**
     * Número da Apólice<br>
     * Obrigatório pela lei 11.442/07 (RCTRC)
     */
    public void setApolice(final String apolice) {
        StringValidador.tamanho20(apolice, "Número da Apólice");
        this.apolice = apolice;
    }

    public String getAverbacao() {
        return this.averbacao;
    }

    /**
     * Número da Averbação Informar as averbações do seguro.
     */
    public void setAverbacao(final String averbacao) {
        StringValidador.tamanho40(averbacao, "Número da Averbação ");
        this.averbacao = averbacao;
    }
}
