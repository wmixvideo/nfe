package com.fincatto.documentofiscal.dpec;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Eldevan Nery Junior on 15/01/19.
 *
 * Identificação do Declarante, deve ser informado com os dados do emissor das NF-e emitidas em contingência eletrônica
 *
 */
@Root(name = "ideDec")
public class IdentificacaoDeclarante extends DFBase {

    /**
     * Código da UF do emitente do Documento Fiscal. Utilizar a Tabela do IBGE.
     */
    @Element(name = "cUF")
    private String uf;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    /**
     * Versão do aplicativo utilizado no processo de
     * emissãodo DPEC
     */
    @Element
    protected String verProc;

    /**
     * Número do CNPJ do emitente
     */
    @Element(name = "CNPJ", required = true)
    protected String cnpj;

    /**
     * Inscrição Estadual do emitente
     */
    @Element(name = "IE", required = true)
    protected String ie;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setUf(DFUnidadeFederativa uf) {
        this.uf = uf.getCodigoIbge();
    }

    public DFAmbiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVerProc() {
        return verProc;
    }

    public void setVerProc(String verProc) {
        StringValidador.tamanho20(verProc, "Versão do aplicativo");
        this.verProc = verProc;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        StringValidador.cnpj(cnpj, "Identificação do declarante");
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        StringValidador.inscricaoEstadual(ie);
        this.ie = ie;
    }
}