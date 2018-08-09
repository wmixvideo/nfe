package com.fincatto.documentofiscal.mdfe3.classes.consultastatusservico;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

/**
 * Created by Eldevan Nery Junior on 10/11/17. Tipo Resultado da Consulta do Status do Serviço MDFe.
 */
@Root(name = "retConsStatServMdfe")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeConsStatServRet extends DFBase {
    private static final long serialVersionUID = 3641601774421019676L;

    @Element(name = "tpAmb", required = false)
    private DFAmbiente ambiente;

    @Element(name = "verAplic", required = false)
    private String versaoAplicacao;

    @Element(name = "cStat", required = false)
    private String codigoStatus;

    @Element(name = "xMotivo", required = false)
    private String motivo;

    @Element(name = "cUF", required = false)
    private DFUnidadeFederativa uf;

    @Element(name = "dhRecbto", required = false)
    private String dataRecebimento;

    @Element(name = "tMed", required = false)
    private String tempoMedio;

    @Element(name = "dhRetorno", required = false)
    private String dataRetorno;

    @Element(name = "xObs", required = false)
    private String Observacao;

    @Attribute(name = "versao", required = false)
    private String versao;

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getCodigoStatus() {
        return this.codigoStatus;
    }

    public void setCodigoStatus(final String codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public String getDataRecebimento() {
        return this.dataRecebimento;
    }

    public void setDataRecebimento(final String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getTempoMedio() {
        return this.tempoMedio;
    }

    public void setTempoMedio(final String tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public String getDataRetorno() {
        return this.dataRetorno;
    }

    public void setDataRetorno(final String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getObservacao() {
        return this.Observacao;
    }

    public void setObservacao(final String observacao) {
        this.Observacao = observacao;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

}
