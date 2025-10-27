
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "endExt")
public class NFSeSefinNacionalEnderExtSimples {

    @Element(name="cEndPost")
    protected String codigoPostal;
    @Element(name="xCidade")
    protected String cidade;
    @Element(name="xEstProvReg")
    protected String estadoProvinciaRegiao;

    /**
     * @return Código alfanumérico do Endereçamento Postal no exterior do prestador do serviço.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Define o Código alfanumérico do Endereçamento Postal no exterior do prestador do serviço.
     * @param value Código alfanumérico do Endereçamento Postal no exterior do prestador do serviço.
     */
    public void setCodigoPostal(String value) {
        this.codigoPostal = value;
    }

    /**
     * Retorna a cidade
     * @return Cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade
     * @param value Cidade
     */
    public void setCidade(String value) {
        this.cidade = value;
    }

    /**
     * Retorna o estado, província ou região
     * @return Estado, província ou região
     */
    public String getEstadoProvinciaRegiao() {
        return estadoProvinciaRegiao;
    }

    /**
     * Define o estado, província ou região
     * @param value Estado, província ou região
     */
    public void setEstadoProvinciaRegiao(String value) {
        this.estadoProvinciaRegiao = value;
    }

}
