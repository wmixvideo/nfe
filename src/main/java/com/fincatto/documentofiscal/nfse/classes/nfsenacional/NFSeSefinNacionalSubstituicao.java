
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "Substituicao")
public class NFSeSefinNacionalSubstituicao {

    @Element(name="chSubstda")
    protected String chaveNFSe;
    @Element(name="cMotivo")
    protected NFSeSefinNacionalSubstituicaoMotivo motivo;
    @Element(name="xMotivo", required = false)
    protected String observacao;

    /**
     * @return Chave de acesso da NFS-e a ser substituída
     */
    public String getChaveNFSe() {
        return chaveNFSe;
    }

    /**
     * @param chaveNFSe Chave de acesso da NFS-e a ser substituída
     */
    public void setChaveNFSe(String chaveNFSe) {
        this.chaveNFSe = chaveNFSe;
    }

    /**
     * @return Código do motivo da substituição
     * @see NFSeSefinNacionalSubstituicaoMotivo
     */
    public NFSeSefinNacionalSubstituicaoMotivo getMotivo() {
        return motivo;
    }

    /**
     * @param motivo motivo da substituição
     * @see NFSeSefinNacionalSubstituicaoMotivo
     */
    public void setMotivo(NFSeSefinNacionalSubstituicaoMotivo motivo) {
        this.motivo = motivo;
    }

    /**
     * @return Descrição do motivo da substituição
     */
    public String getMotivoObservacao() {
        return observacao;
    }

    /**
     * @param observacao Descrição do motivo da substituição
     */
    public void setMotivoObservacao(String observacao) {
        // Todo
        //  - Verificar se este campo é obrigatório para algum motivo específico, ou se é sempre opcional -
        //  - Layout do enum de motivos não deixa claro se é só a descrição replicada de lá, ou se é algo customizável
        this.observacao = observacao;
    }

}
