
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "ExigSuspensa")
public class NFSeSefinNacionalExigSuspensa {

    @Element(name = "tpSusp")
    protected NFSeSefinNacionalExigSuspensaTipoSuspensao tipoSuspensao;
    @Element(name = "nProcesso")
    protected String numeroProcesso;

    /**
     * @return Tipo de Suspensão da Exigibilidade do Crédito Tributário
     */
    public NFSeSefinNacionalExigSuspensaTipoSuspensao getTipoSuspensao() {
        return tipoSuspensao;
    }

    /**
     * @param tipoSuspensao Tipo de Suspensão da Exigibilidade do Crédito Tributário
     */
    public void setTipoSuspensao(NFSeSefinNacionalExigSuspensaTipoSuspensao tipoSuspensao) {
        this.tipoSuspensao = tipoSuspensao;
    }

    /**
     * @return Número do Processo Administrativo ou Judicial
     */
    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    /**
     * @param numeroProcesso Número do Processo Administrativo ou Judicial
     */
    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

}
