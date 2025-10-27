
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações do DPS relativas à serviço de obra
 */

@Root(name = "obra")
public class NFSeSefinNacionalInfoObra {

    @Element(name = "cObra", required = false)
    String numeroIdentificacaoObra;
    @Element(name = "inscImobFisc", required = false)
    String inscricaoImobiliariaFiscal;
    @Element(name = "end", required = false)
    NFSeSefinNacionalEnderecoSimples endereco;

    /**
     * Número de identificação da obra
     * Cadastro Nacional de Obras (CNO) ou Cadastro Específico do INSS (CEI).
     *
     * @return Número de identificação da obra
     */
    public String getNumeroIdentificacaoObra() {
        return numeroIdentificacaoObra;
    }

    /**
     * Define o número de identificação da obra
     * Cadastro Nacional de Obras (CNO) ou Cadastro Específico do INSS (CEI).
     *
     * @param value Número de identificação da obra
     */
    public void setNumeroIdentificacaoObra(String value) {
        this.numeroIdentificacaoObra = value;
    }

    /**
     * Inscrição imobiliária fiscal (código fornecido pela Prefeitura Municipal para a identificação da obra ou para fins de recolhimento do IPTU)
     *
     * @return Inscrição imobiliária fiscal
     */
    public String getInscricaoImobiliariaFiscal() {
        return inscricaoImobiliariaFiscal;
    }

    /**
     * Define a inscrição imobiliária fiscal (código fornecido pela Prefeitura Municipal para a identificação da obra ou para fins de recolhimento do IPTU)
     *
     * @param value Inscrição imobiliária fiscal
     */
    public void setInscricaoImobiliariaFiscal(String value) {
        this.inscricaoImobiliariaFiscal = value;
    }

    /**
     * Endereço da obra
     *
     * @return Endereço da obra
     */
    public NFSeSefinNacionalEnderecoSimples getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço da obra
     *
     * @param value Endereço da obra
     */
    public void setEndereco(NFSeSefinNacionalEnderecoSimples value) {
        this.endereco = value;
    }

}
