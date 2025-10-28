
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.time.LocalDate;

@Root(name = "DocDedRed")
public class NFSeSefinNacionalDocDedRed {

    @Element(name = "chNFSe", required = false)
    protected String chaveNFSe;
    @Element(name = "chNFe", required = false)
    protected String chaveNFe;
    @Element(name = "NFSeMun", required = false)
    protected NFSeSefinNacionalDocOutNFSe nfseMunicipal;
    @Element(name = "NFNFS", required = false)
    protected NFSeSefinNacionalDocNFNFS nfNfsNaoEletronico;
    @Element(name = "nDocFisc", required = false)
    protected String numeroDocumentoFiscal;
    @Element(name = "nDoc", required = false)
    protected String numeroDocumentoNaoFiscal;
    @Element(name = "tpDedRed")
    protected NFSeSefinNacionalDocDedRedTipoDeducaoReducao tipoDeducaoReducao;
    @Element(name = "xDescOutDed", required = false)
    protected String descricaoOutrasDeducoes;
    @Element(name = "dtEmiDoc")
    protected LocalDate dataEmissao;
    @Element(name = "vDedutivelRedutivel")
    protected String valorTotalDedutivel;
    @Element(name = "vDeducaoReducao")
    protected String valorDeducao;
    @Element(name = "fornec", required = false)
    protected NFSeSefinNacionalInfoPessoa fornecedor;

    /**
     * @return Chave de Acesso da NFS-e (Padrão Nacional)
     */
    public String getChaveNFSe() {
        return chaveNFSe;
    }

    /**
     * @param chaveNFSe Chave de Acesso da NFS-e (Padrão Nacional)
     */
    public void setChaveNFSe(String chaveNFSe) {
        this.chaveNFSe = chaveNFSe;
    }

    /**
     * @return Chave de Acesso da NF-e
     */
    public String getChaveNFe() {
        return chaveNFe;
    }

    /**
     * @param chaveNFe Chave de Acesso da NF-e
     */
    public void setChaveNFe(String chaveNFe) {
        this.chaveNFe = chaveNFe;
    }

    /**
     * @return Grupo de informações de Outras NFS-e (Padrão anterior de NFS-e)
     */
    public NFSeSefinNacionalDocOutNFSe getNFSeMunicipal() {
        return nfseMunicipal;
    }

    /**
     * @param nfseMunicipal Grupo de informações de Outras NFS-e (Padrão anterior de NFS-e)
     */
    public void setNFSeMunicipal(NFSeSefinNacionalDocOutNFSe nfseMunicipal) {
        this.nfseMunicipal = nfseMunicipal;
    }

    /**
     * @return Grupo de informações de NF ou NFS (Modelo não eletrônico)
     */
    public NFSeSefinNacionalDocNFNFS getNfNfsNaoEletronico() {
        return nfNfsNaoEletronico;
    }

    /**
     * @param nfNfsNaoEletronico Grupo de informações de NF ou NFS (Modelo não eletrônico)
     */
    public void setNfNfsNaoEletronico(NFSeSefinNacionalDocNFNFS nfNfsNaoEletronico) {
        this.nfNfsNaoEletronico = nfNfsNaoEletronico;
    }

    /**
     * @return Número de documento fiscal
     */
    public String getNumeroDocumentoFiscal() {
        return numeroDocumentoFiscal;
    }

    /**
     * @param numeroDocumentoFiscal Número de documento fiscal
     */
    public void setNumeroDocumentoFiscal(String numeroDocumentoFiscal) {
        this.numeroDocumentoFiscal = numeroDocumentoFiscal;
    }

    /**
     * @return Número de documento não fiscal
     */
    public String getNumeroDocumentoNaoFiscal() {
        return numeroDocumentoNaoFiscal;
    }

    /**
     * @param numeroDocumentoNaoFiscal Número de documento não fiscal
     */
    public void setNumeroDocumentoNaoFiscal(String numeroDocumentoNaoFiscal) {
        this.numeroDocumentoNaoFiscal = numeroDocumentoNaoFiscal;
    }

    /**
     * @return Identificação da Dedução/Redução
     */
    public NFSeSefinNacionalDocDedRedTipoDeducaoReducao getTipoDeducaoReducao() {
        return tipoDeducaoReducao;
    }

    /**
     * @param tipoDeducaoReducao Identificação da Dedução/Redução
     */
    public void setTipoDeducaoReducao(NFSeSefinNacionalDocDedRedTipoDeducaoReducao tipoDeducaoReducao) {
        this.tipoDeducaoReducao = tipoDeducaoReducao;
    }

    /**
     * @return Descrição da Dedução/Redução quando a opção é "99 – Outras Deduções"
     */
    public String getDescricaoOutrasDeducoes() {
        return descricaoOutrasDeducoes;
    }

    /**
     * @param descricaoOutrasDeducoes Descrição da Dedução/Redução quando a opção é "99 – Outras Deduções"
     */
    public void setDescricaoOutrasDeducoes(String descricaoOutrasDeducoes) {
        this.descricaoOutrasDeducoes = descricaoOutrasDeducoes;
    }

    /**
     * @return Data da emissão do documento dedutível
     */
    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao Data da emissão do documento dedutível
     */
    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * Valor monetário total dedutível/redutível no documento informado (R$).
     * Este é o valor total no documento informado que é passível de dedução/redução.
     *
     * @return Valor total dedutível
     */
    public String getValorTotalDedutivel() {
        return valorTotalDedutivel;
    }

    /**
     * Valor monetário total dedutível/redutível no documento informado (R$).
     * Este é o valor total no documento informado que é passível de dedução/redução.
     *
     * @param valorTotalDedutivel Valor total dedutível
     */
    public void setValorTotalDedutivel(String valorTotalDedutivel) {
        this.valorTotalDedutivel = valorTotalDedutivel;
    }

    /**
     * Valor monetário utilizado para dedução/redução do valor do serviço da NFS-e que está sendo emitida (R$).
     * Deve ser menor ou igual ao valor deduzível/redutível (vDedutivelRedutivel).
     *
     * @return Valor dedução
     */
    public String getValorDeducao() {
        return valorDeducao;
    }

    /**
     * Valor monetário utilizado para dedução/redução do valor do serviço da NFS-e que está sendo emitida (R$).
     * Deve ser menor ou igual ao valor deduzível/redutível (vDedutivelRedutivel).
     *
     * @param valorDeducao Valor dedução
     */
    public void setValorDeducao(String valorDeducao) {
        this.valorDeducao = valorDeducao;
    }

    /**
     * @return fornecedor
     */
    public NFSeSefinNacionalInfoPessoa getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor fornecedor
     */
    public void setFornecedor(NFSeSefinNacionalInfoPessoa fornecedor) {
        this.fornecedor = fornecedor;
    }

}
