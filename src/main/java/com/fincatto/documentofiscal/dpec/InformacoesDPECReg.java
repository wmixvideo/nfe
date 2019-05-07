package com.fincatto.documentofiscal.dpec;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.time.LocalDateTime;
/**
 *
 * Created by Eldevan Nery Junior on 15/01/19.
 *
 * Informações do Retorno da Consulta da Declaração Prévia de Emissão em Contignência - DPEC
 *
 */
@Root(name = "InfDPECReg")
public  class InformacoesDPECReg  extends DFBase {

    @Attribute(name = "Id")
    private String identificador;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "verAplic")
    private String versaoAplicativo;

    @Element(name = "cStat")
    private String codigoStatusReposta;

    @Element(name = "xMotivo")
    private String motivo;

    @Element(name = "dhRegDPEC")
    private LocalDateTime dataRecebimento;

    /**
     * Número do registro do DPEC
     */
    @Element(name = "nRegDPEC")
    private String numeroRegistroDPEC;

    /**
     * Declaração Prévia de Emissão em Contingência
     */
    @Element(name = "envDPEC")
    private TipoDPEC envDPEC;

    @Element(name = "chNFe")
    private String chaveDeAcesso;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

    public LocalDateTime getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDateTime dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getNumeroRegistroDPEC() {
        return numeroRegistroDPEC;
    }

    public void setNumeroRegistroDPEC(String numeroRegistroDPEC) {
        this.numeroRegistroDPEC = numeroRegistroDPEC;
    }

    public TipoDPEC getEnvDPEC() {
        return envDPEC;
    }

    public void setEnvDPEC(TipoDPEC envDPEC) {
        this.envDPEC = envDPEC;
    }

    public String getChaveDeAcesso() {
        return chaveDeAcesso;
    }

    public void setChaveDeAcesso(String chaveDeAcesso) {
        this.chaveDeAcesso = chaveDeAcesso;
    }
}