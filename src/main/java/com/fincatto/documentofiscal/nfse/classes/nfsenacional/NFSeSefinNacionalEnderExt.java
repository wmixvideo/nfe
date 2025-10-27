
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações específicas de endereço no exterior
 */

@Root(name = "EnderExt")
public class NFSeSefinNacionalEnderExt {

    @Element(name = "cPais")
    protected String pais;
    @Element(name = "cEndPost")
    protected String codigoPostal;
    @Element(name = "xCidade")
    protected String cidade;
    @Element(name = "xEstProvReg")
    protected String estadoProvinciaRegiao;

    /**
     * @return Código do país (Tabela de Países ISO)
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define o código do país (Tabela de Países ISO)
     *
     * @param pais Código do país
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return Código alfanumérico do Endereçamento Postal no exterior do prestador do serviço.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal código alfanumérico do Endereçamento Postal no exterior do prestador do serviço.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return Nome da cidade no exterior do prestador do serviço.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade Nome da cidade no exterior do prestador do serviço.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return Nome do estado, província ou região no exterior do prestador do serviço.
     */
    public String getEstadoProvinciaRegiao() {
        return estadoProvinciaRegiao;
    }

    /**
     * @param estadoProvinciaRegiao Nome do estado, província ou região no exterior do prestador do serviço.
     */
    public void setEstadoProvinciaRegiao(String estadoProvinciaRegiao) {
        this.estadoProvinciaRegiao = estadoProvinciaRegiao;
    }

}
