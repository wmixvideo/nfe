
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "NFSeMun")
public class NFSeSefinNacionalDocOutNFSe {

    @Element(name = "cMunNFSeMun")
    protected String codigoMunicipio;
    @Element(name = "nNFSeMun")
    protected String numeroNFSe;
    @Element(name = "cVerifNFSeMun")
    protected String codigoVerificacao;

    /**
     * @return Código Município emissor da nota eletrônica municipal (Tabela do IBGE)
     */
    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    /**
     * @param codigoMunicipio Código Município emissor da nota eletrônica municipal (Tabela do IBGE)
     */
    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    /**
     * @return Número da nota eletrônica municipal
     */
    public String getNumeroNFSe() {
        return numeroNFSe;
    }

    /**
     * @param numeroNFSe Número da nota eletrônica municipal
     */
    public void setNumeroNFSe(String numeroNFSe) {
        this.numeroNFSe = numeroNFSe;
    }

    /**
     * @return Código de Verificação da nota eletrônica municipal
     */
    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    /**
     * @param codigoVerificacao Código de Verificação da nota eletrônica municipal
     */
    public void setCodigoVerificacao(String codigoVerificacao) {
        this.codigoVerificacao = codigoVerificacao;
    }

}
