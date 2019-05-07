package com.fincatto.documentofiscal.dpec;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


/**
 * 
 * Created by Eldevan Nery Junior on 15/01/19.
 * 
 * Tipo Retorno da Consulta da Declaração Prévia de Emissão em Contignência - DPEC
 *
 */
@Root(name = "TRetConsDPEC")
public class TipoRetornoConsultaDPEC  extends DFBase {

    @Attribute(name = "versao")
    private String versao = TipoDPEC.VERSAO_DPEC;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "verAplic")
    private String versaoAplicativo;

    @Element(name = "cStat")
    private String codigoStatusReposta;

    @Element(name = "xMotivo")
    private String motivo;

    @Element(name = "retDPEC")
    private TipoRetornoDPEC tipoRetornoDPEC;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public DFAmbiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicativo() {
        return versaoAplicativo;
    }

    public void setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public String getCodigoStatusReposta() {
        return codigoStatusReposta;
    }

    public void setCodigoStatusReposta(String codigoStatusReposta) {
        this.codigoStatusReposta = codigoStatusReposta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public TipoRetornoDPEC getTipoRetornoDPEC() {
        return tipoRetornoDPEC;
    }

    public void setTipoRetornoDPEC(TipoRetornoDPEC tipoRetornoDPEC) {
        this.tipoRetornoDPEC = tipoRetornoDPEC;
    }
}
