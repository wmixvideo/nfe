
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "end")
public class NFSeSefinNacionalEndereco {

    @Element(name = "endNac", required = false)
    protected NFSeSefinNacionalEnderNac enderecoNacional;
    @Element(name = "endExt", required = false)
    protected NFSeSefinNacionalEnderExt enderecoExterior;
    @Element(name = "xLgr")
    protected String logradouro;
    @Element(name = "nro")
    protected String numero;
    @Element(name = "xCpl", required = false)
    protected String complemento;
    @Element(name = "xBairro")
    protected String bairro;

    /**
     * @return Endereço Nacional do Prestador de Serviço
     */
    public NFSeSefinNacionalEnderNac getEnderecoNacional() {
        return enderecoNacional;
    }

    /**
     * @param enderecoNacional Endereço Nacional do Prestador de Serviço
     */
    public void setEnderecoNacional(NFSeSefinNacionalEnderNac enderecoNacional) {
        this.enderecoNacional = enderecoNacional;
    }

    /**
     * @return Endereço no Exterior do Prestador de Serviço
     */
    public NFSeSefinNacionalEnderExt getEnderecoExterior() {
        return enderecoExterior;
    }

    /**
     * @param enderecoExterior Endereço no Exterior do Prestador de Serviço
     */
    public void setEnderecoExterior(NFSeSefinNacionalEnderExt enderecoExterior) {
        this.enderecoExterior = enderecoExterior;
    }

    /**
     * @return Logradouro do endereço
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro Logradouro do endereço
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return Número do endereço
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero Número do endereço
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return Complemento do endereço
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento Complemento do endereço
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return Bairro do endereço
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro Bairro do endereço
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

}
