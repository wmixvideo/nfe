package com.fincatto.documentofiscal.cte200.classes.cte;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte200.classes.CTFormaPagamento;
import com.fincatto.documentofiscal.cte200.classes.CTIdentificadorEmissor;
import com.fincatto.documentofiscal.cte200.classes.CTModal;
import com.fincatto.documentofiscal.cte200.classes.CTRetiraMercadoria;
import com.fincatto.documentofiscal.cte200.classes.CTTipoCte;
import com.fincatto.documentofiscal.cte200.classes.CTTipoEmissao;
import com.fincatto.documentofiscal.cte200.classes.CTTipoImpressao;
import com.fincatto.documentofiscal.cte200.classes.CTTipoServico;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.LocalDateTime;

@Root(name = "ide")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTInfoIdentificador extends DFBase {
    private static final long serialVersionUID = -5863776725486518892L;

    @Element(name = "cUF")
    private DFUnidadeFederativa unidadeFederativaEmitente;

    @Element(name = "cCT")
    private String codigoChaveAcesso;

    @Element(name = "CFOP")
    private String cfop;

    @Element(name = "natOp")
    private String naturezaOperacao;

    @Element(name = "forPag", required = false)
    private CTFormaPagamento formaPagamento;

    @Element(name = "mod")
    private DFModelo modeloDocumentoFiscal;

    @Element(name = "serie")
    private String serie;

    @Element(name = "nCT")
    private String numero;

    @Element(name = "dhEmi")
    private LocalDateTime dataHoraEmissao;

    @Element(name = "tpImp")
    private CTTipoImpressao tipoImpressao;

    @Element(name = "tpEmis")
    private CTTipoEmissao tipoEmissao;

    @Element(name = "cDV")
    private String digitoVerificador;

    @Element(name = "tpAmb")
    private DFAmbiente tipoAmbiente;

    @Element(name = "tpCTe")
    private CTTipoCte tipoCte;

    @Element(name = "procEmi")
    private CTIdentificadorEmissor identProcessoEmissao;

    @Element(name = "verProc")
    private String versaoProcessoEmissao;

    @Element(name = "refCTE", required = false)
    private String chaveAcessoCteReferenciado;

    @Element(name = "cMunEnv")
    private String codigoMunicipioEnvio;

    @Element(name = "xMunEnv")
    private String descricaoMunicipioEnvio;

    @Element(name = "UFEnv")
    private DFUnidadeFederativa unidadeFederativaEnvio;

    @Element(name = "modal")
    private CTModal modal;

    @Element(name = "tpServ")
    private CTTipoServico tipoServico;

    @Element(name = "cMunIni")
    private String codigoMunicipioInicio;

    @Element(name = "xMunIni")
    private String descricaoMunicipioInicio;

    @Element(name = "UFIni")
    private DFUnidadeFederativa unidadeFederativaInicio;

    @Element(name = "cMunFim")
    private String codigoMunicipioFim;

    @Element(name = "xMunFim")
    private String descricaoMunicipioFim;

    @Element(name = "UFFim")
    private DFUnidadeFederativa unidadeFederativaFim;

    @Element(name = "retira")
    private CTRetiraMercadoria retira;

    @Element(name = "xDetRetira", required = false)
    private String detalhesRetira;

    @Element(name = "toma03", required = false)
    private CTInfoTomadorServico3 indicadorTomadorServico3;

    @Element(name = "toma4", required = false)
    private CTInfoTomadorServico4 indicadorTomadorServico4;

    @Element(name = "dhCont", required = false)
    private LocalDateTime dataHoraEntradaContingencia;

    @Element(name = "xJust", required = false)
    private String descricaoJustificativaContingencia;

    public DFUnidadeFederativa getUnidadeFederativaEmitente() {
        return this.unidadeFederativaEmitente;
    }

    public void setUnidadeFederativaEmitente(final DFUnidadeFederativa unidadeFederativaEmitente) {
        this.unidadeFederativaEmitente = unidadeFederativaEmitente;
    }

    public String getCodigoChaveAcesso() {
        return this.codigoChaveAcesso;
    }

    public void setCodigoChaveAcesso(final String codigoChaveAcesso) {
        this.codigoChaveAcesso = codigoChaveAcesso;
    }

    public String getCfop() {
        return this.cfop;
    }

    public void setCfop(final String cfop) {
        this.cfop = cfop;
    }

    public String getNaturezaOperacao() {
        return this.naturezaOperacao;
    }

    public void setNaturezaOperacao(final String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public CTFormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(final CTFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public DFModelo getModeloDocumentoFiscal() {
        return this.modeloDocumentoFiscal;
    }

    public void setModeloDocumentoFiscal(final DFModelo modeloDocumentoFiscal) {
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(final String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public LocalDateTime getDataHoraEmissao() {
        return this.dataHoraEmissao;
    }

    public void setDataHoraEmissao(final LocalDateTime dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public CTTipoImpressao getTipoImpressao() {
        return this.tipoImpressao;
    }

    public void setTipoImpressao(final CTTipoImpressao tipoImpressao) {
        this.tipoImpressao = tipoImpressao;
    }

    public CTTipoEmissao getTipoEmissao() {
        return this.tipoEmissao;
    }

    public void setTipoEmissao(final CTTipoEmissao tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
    }

    public String getDigitoVerificador() {
        return this.digitoVerificador;
    }

    public void setDigitoVerificador(final String digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    public DFAmbiente getTipoAmbiente() {
        return this.tipoAmbiente;
    }

    public void setTipoAmbiente(final DFAmbiente tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public CTTipoCte getTipoCte() {
        return this.tipoCte;
    }

    public void setTipoCte(final CTTipoCte tipoCte) {
        this.tipoCte = tipoCte;
    }

    public CTIdentificadorEmissor getIdentProcessoEmissao() {
        return this.identProcessoEmissao;
    }

    public void setIdentProcessoEmissao(final CTIdentificadorEmissor identProcessoEmissao) {
        this.identProcessoEmissao = identProcessoEmissao;
    }

    public String getVersaoProcessoEmissao() {
        return this.versaoProcessoEmissao;
    }

    public void setVersaoProcessoEmissao(final String versaoProcessoEmissao) {
        this.versaoProcessoEmissao = versaoProcessoEmissao;
    }

    public String getChaveAcessoCteReferenciado() {
        return this.chaveAcessoCteReferenciado;
    }

    public void setChaveAcessoCteReferenciado(final String chaveAcessoCteReferenciado) {
        this.chaveAcessoCteReferenciado = chaveAcessoCteReferenciado;
    }

    public String getCodigoMunicipioEnvio() {
        return this.codigoMunicipioEnvio;
    }

    public void setCodigoMunicipioEnvio(final String codigoMunicipioEnvio) {
        this.codigoMunicipioEnvio = codigoMunicipioEnvio;
    }

    public String getDescricaoMunicipioEnvio() {
        return this.descricaoMunicipioEnvio;
    }

    public void setDescricaoMunicipioEnvio(final String descricaoMunicipioEnvio) {
        this.descricaoMunicipioEnvio = descricaoMunicipioEnvio;
    }

    public DFUnidadeFederativa getUnidadeFederativaEnvio() {
        return this.unidadeFederativaEnvio;
    }

    public void setUnidadeFederativaEnvio(final DFUnidadeFederativa unidadeFederativaEnvio) {
        this.unidadeFederativaEnvio = unidadeFederativaEnvio;
    }

    public CTModal getModal() {
        return this.modal;
    }

    public void setModal(final CTModal modal) {
        this.modal = modal;
    }

    public CTTipoServico getTipoServico() {
        return this.tipoServico;
    }

    public void setTipoServico(final CTTipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getCodigoMunicipioInicio() {
        return this.codigoMunicipioInicio;
    }

    public void setCodigoMunicipioInicio(final String codigoMunicipioInicio) {
        this.codigoMunicipioInicio = codigoMunicipioInicio;
    }

    public String getDescricaoMunicipioInicio() {
        return this.descricaoMunicipioInicio;
    }

    public void setDescricaoMunicipioInicio(final String descricaoMunicipioInicio) {
        this.descricaoMunicipioInicio = descricaoMunicipioInicio;
    }

    public DFUnidadeFederativa getUnidadeFederativaInicio() {
        return this.unidadeFederativaInicio;
    }

    public void setUnidadeFederativaInicio(final DFUnidadeFederativa unidadeFederativaInicio) {
        this.unidadeFederativaInicio = unidadeFederativaInicio;
    }

    public String getCodigoMunicipioFim() {
        return this.codigoMunicipioFim;
    }

    public void setCodigoMunicipioFim(final String codigoMunicipioFim) {
        this.codigoMunicipioFim = codigoMunicipioFim;
    }

    public String getDescricaoMunicipioFim() {
        return this.descricaoMunicipioFim;
    }

    public void setDescricaoMunicipioFim(final String descricaoMunicipioFim) {
        this.descricaoMunicipioFim = descricaoMunicipioFim;
    }

    public DFUnidadeFederativa getUnidadeFederativaFim() {
        return this.unidadeFederativaFim;
    }

    public void setUnidadeFederativaFim(final DFUnidadeFederativa unidadeFederativaFim) {
        this.unidadeFederativaFim = unidadeFederativaFim;
    }

    public CTRetiraMercadoria getRetira() {
        return this.retira;
    }

    public void setRetira(final CTRetiraMercadoria retira) {
        this.retira = retira;
    }

    public String getDetalhesRetira() {
        return this.detalhesRetira;
    }

    public void setDetalhesRetira(final String detalhesRetira) {
        this.detalhesRetira = detalhesRetira;
    }

    public CTInfoTomadorServico3 getIndicadorTomadorServico3() {
        return this.indicadorTomadorServico3;
    }

    public void setIndicadorTomadorServico3(final CTInfoTomadorServico3 indicadorTomadorServico3) {
        this.indicadorTomadorServico3 = indicadorTomadorServico3;
    }

    public CTInfoTomadorServico4 getIndicadorTomadorServico4() {
        return this.indicadorTomadorServico4;
    }

    public void setIndicadorTomadorServico4(final CTInfoTomadorServico4 indicadorTomadorServico4) {
        this.indicadorTomadorServico4 = indicadorTomadorServico4;
    }

    public LocalDateTime getDataHoraEntradaContingencia() {
        return this.dataHoraEntradaContingencia;
    }

    public void setDataHoraEntradaContingencia(final LocalDateTime dataHoraEntradaContingencia) {
        this.dataHoraEntradaContingencia = dataHoraEntradaContingencia;
    }

    public String getDescricaoJustificativaContingencia() {
        return this.descricaoJustificativaContingencia;
    }

    public void setDescricaoJustificativaContingencia(final String descricaoJustificativaContingencia) {
        this.descricaoJustificativaContingencia = descricaoJustificativaContingencia;
    }

}
