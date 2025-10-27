
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "CServ")
public class NFSeSefinNacionalCServ {

    @Element(name = "cTribNac")
    protected String codigoNacionalTributacaoISSQN;
    @Element(name = "cTribMun", required = false)
    protected String codigoMunicipalTributacaoISSQN;
    @Element(name = "xDescServ")
    protected String descricaoServico;
    @Element(name = "cNBS", required = false)
    protected String codigoNBS;
    @Element(name = "cIntContrib", required = false)
    protected String codigoInternoContribuinte;

    /**
     * @return Código de tributação nacional do ISSQN
     */
    public String getCodigoNacionalTributacaoISSQN() {
        return codigoNacionalTributacaoISSQN;
    }

    /**
     * Código de tributação nacional do ISSQN:
     * Regra de formação - 6 dígitos numéricos sendo: 2 para Item (LC 116/2003), 2 para Subitem (LC 116/2003) e 2 para Desdobro Nacional
     *
     * @param value Código de tributação nacional do ISSQN
     */
    public NFSeSefinNacionalCServ setCodigoNacionalTributacaoISSQN(String value) {
        this.codigoNacionalTributacaoISSQN = value;
        return this;
    }

    /**
     * @return Código de tributação municipal do ISSQN
     */
    public String getCodigoMunicipalTributacaoISSQN() {
        return codigoMunicipalTributacaoISSQN;
    }

    /**
     * Código de tributação municipal do ISSQN:
     *
     * @param value Código de tributação municipal do ISSQN
     */
    public void setCodigoMunicipalTributacaoISSQN(String value) {
        this.codigoMunicipalTributacaoISSQN = value;
    }

    /**
     * @return Descrição completa do serviço prestado
     */
    public String getDescricaoServico() {
        return descricaoServico;
    }

    /**
     * @param descricaoServico Descrição completa do serviço prestado
     */
    public NFSeSefinNacionalCServ setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
        return this;
    }

    /**
     * Código NBS (Nomenclatura Brasileira de Serviços, Intangíveis e outras Operações que produzam Variações no Patrimônio) correspondente ao serviço prestado
     * @return Código NBS
     */
    public String getCodigoNBS() {
        return codigoNBS;
    }

    /**
     * Código NBS (Nomenclatura Brasileira de Serviços, Intangíveis e outras Operações que produzam Variações no Patrimônio) correspondente ao serviço prestado
     * @param codigoNBS Código NBS
     */
    public NFSeSefinNacionalCServ setCodigoNBS(String codigoNBS) {
        this.codigoNBS = codigoNBS;
        return this;
    }

    /**
     * @return Código interno do contribuinte
     */
    public String getCodigoInternoContribuinte() {
        return codigoInternoContribuinte;
    }

    /**
     * @param codigoInternoContribuinte Código interno do contribuinte
     */
    public void setCodigoInternoContribuinte(String codigoInternoContribuinte) {
        this.codigoInternoContribuinte = codigoInternoContribuinte;
    }

}
