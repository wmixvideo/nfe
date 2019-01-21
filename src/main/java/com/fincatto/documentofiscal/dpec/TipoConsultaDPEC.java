package com.fincatto.documentofiscal.dpec;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


/**
 *
 * Created by Eldevan Nery Junior on 15/01/19.
 *
 * Tipo Consulta Declaração prévia de Emissão em Contingência - DPEC.
 *
 */
@Root(name = "TConsDPEC")
public class TipoConsultaDPEC extends DFBase {

    @Attribute(name = "versao")
    private String versao = TipoDPEC.VERSAO_DPEC;

    @Element(name = "chNFe")
    private String chaveDeAcesso;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "verAplic", required = false)
    private String versaoAplicacao;

    /**
     * Número do registro do DPEC
     */
    @Element(name = "nRegDPEC")
    private String numeroRegistroDPEC;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getChaveDeAcesso() {
        return chaveDeAcesso;
    }

    public void setChaveDeAcesso(String chaveDeAcesso) {
        StringValidador.exatamente44N(chaveDeAcesso, "Chave de Acesso NFe em Tipo consulta DPEC");
        this.chaveDeAcesso = chaveDeAcesso;
    }

    public DFAmbiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicacao() {
        return versaoAplicacao;
    }

    public void setVersaoAplicacao(String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getNumeroRegistroDPEC() {
        return numeroRegistroDPEC;
    }

    public void setNumeroRegistroDPEC(String numeroRegistroDPEC) {
        this.numeroRegistroDPEC = numeroRegistroDPEC;
    }
}
