package com.fincatto.documentofiscal.cte400.classes.evento.epec;

import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTFinalidade;
import com.fincatto.documentofiscal.cte400.classes.CTModal;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeTipoEvento;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Root(name = "evEPECCTe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeEnviaEventoEpec extends CTeTipoEvento {
    private static final long serialVersionUID = -3353875431330243137L;

    @Element(name = "xJust")
    private String descricaoJustificativaContingencia;

    @Element(name = "vICMS")
    private String valorICMS;

    @Element(name = "vICMSSTRet")
    private String valorICMSSTRetido;

    @Element(name = "vTPrest")
    private String valorTotalPrestacaoServico;

    @Element(name = "vCarga")
    private String valorTotalCarga;

    @Element(name = "toma4")
    private CTeTomadorEpec indicadorTomadorServico4;

    @Element(name = "modal")
    private CTModal modalidadeFrete;

    @Element(name = "UFIni")
    private String siglaUfInicio;

    @Element(name = "UFFim")
    private String siglaUfFim;

    @Element(name = "tpCTe")
    private CTFinalidade finalidade;

    @Element(name = "dhEmi")
    private ZonedDateTime dataEmissao;

    public String getDescricaoJustificativaContingencia() {
        return descricaoJustificativaContingencia;
    }

    public void setDescricaoJustificativaContingencia(String descricaoJustificativaContingencia) {
        DFStringValidador.tamanho15a255(descricaoJustificativaContingencia, "Justificativa Contingencia");
        this.descricaoJustificativaContingencia = descricaoJustificativaContingencia;
    }

    public String getValorICMS() {
        return valorICMS;
    }

    public void setValorICMS(BigDecimal valorICMS) {
        this.valorICMS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMS, "Valor do ICMS");
    }

    public String getValorICMSSTRetido() {
        return valorICMSSTRetido;
    }

    public void setValorICMSSTRetido(BigDecimal valorICMSSTRetido) {
        this.valorICMSSTRetido = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSSTRetido, "Valor do ICMS ST retido");
    }

    public String getValorTotalPrestacaoServico() {
        return valorTotalPrestacaoServico;
    }

    public void setValorTotalPrestacaoServico(BigDecimal valorTotalPrestacaoServico) {
        this.valorTotalPrestacaoServico = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalPrestacaoServico, "Valor Total da Prestação de Serviço");
    }

    public String getValorTotalCarga() {
        return valorTotalCarga;
    }

    public void setValorTotalCarga(BigDecimal valorTotalCarga) {
        this.valorTotalCarga = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalCarga, "Valor Total da Carga");
    }

    public CTeTomadorEpec getIndicadorTomadorServico4() {
        return indicadorTomadorServico4;
    }

    public void setIndicadorTomadorServico4(CTeTomadorEpec indicadorTomadorServico4) {
        this.indicadorTomadorServico4 = indicadorTomadorServico4;
    }

    public CTModal getModalidadeFrete() {
        return modalidadeFrete;
    }

    public void setModalidadeFrete(CTModal modalidadeFrete) {
        this.modalidadeFrete = modalidadeFrete;
    }

    public String getSiglaUfInicio() {
        return siglaUfInicio;
    }

    public void setSiglaUfInicio(String siglaUfInicio) {
        DFStringValidador.exatamente2(siglaUfInicio, "UF do início da prestação");
        this.siglaUfInicio = siglaUfInicio;
    }

    public String getSiglaUfFim() {
        return siglaUfFim;
    }

    public void setSiglaUfFim(String siglaUfFim) {
        DFStringValidador.exatamente2(siglaUfFim, "UF do fim da prestação");
        this.siglaUfFim = siglaUfFim;
    }

    public CTFinalidade getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(CTFinalidade finalidade) {
        this.finalidade = finalidade;
    }

    public ZonedDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(ZonedDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
