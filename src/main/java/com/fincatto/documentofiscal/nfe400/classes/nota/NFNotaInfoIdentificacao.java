package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe400.classes.NFCredito;
import com.fincatto.documentofiscal.nfe400.classes.NFDebito;
import com.fincatto.documentofiscal.nfe400.classes.NFFinalidade;
import com.fincatto.documentofiscal.nfe400.classes.NFProcessoEmissor;
import com.fincatto.documentofiscal.nfe400.classes.NFTipo;
import com.fincatto.documentofiscal.nfe400.classes.NFTipoImpressao;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.time.ZonedDateTime;
import java.util.List;

public class NFNotaInfoIdentificacao extends DFBase {
    private static final long serialVersionUID = -2568396066960865875L;

    @Element(name = "cUF")
    private DFUnidadeFederativa uf;

    @Element(name = "cNF")
    private String codigoRandomico;

    @Element(name = "natOp")
    private String naturezaOperacao;

    @Element(name = "mod")
    private DFModelo modelo;

    @Element(name = "serie")
    private String serie;

    @Element(name = "nNF")
    private String numeroNota;

    @Element(name = "dhEmi")
    private ZonedDateTime dataHoraEmissao;

    @Element(name = "dhSaiEnt", required = false)
    private ZonedDateTime dataHoraSaidaOuEntrada;

    @Element(name = "tpNF")
    private NFTipo tipo;

    @Element(name = "idDest")
    private NFIdentificadorLocalDestinoOperacao identificadorLocalDestinoOperacao;

    @Element(name = "cMunFG")
    private String codigoMunicipio; // B12
    
    @Element(required = false)
    private String cMunFGIBS; // B12a

    @Element(name = "tpImp")
    private NFTipoImpressao tipoImpressao;

    @Element(name = "tpEmis")
    private NFTipoEmissao tipoEmissao;

    @Element(name = "cDV")
    private Integer digitoVerificador;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "finNFe")
    private NFFinalidade finalidade; // B25
    
    @Element(required = false)
    private NFDebito tpNFDebito; // B25.1
    
    @Element(required = false)
    private NFCredito tpNFCredito; // B25.2

    @Element(name = "indFinal")
    private NFOperacaoConsumidorFinal operacaoConsumidorFinal; // B25a

    @Element(name = "indPres")
    private NFIndicadorPresencaComprador indicadorPresencaComprador; // B25b

    @Element(name = "indIntermed", required = false)
    private NFIndicadorIntermediador indIntermed; // B25c
    
    @Element(name = "procEmi")
    private NFProcessoEmissor programaEmissor;

    @Element(name = "verProc")
    private String versaoEmissor;

    @Element(name = "dhCont", required = false)
    private ZonedDateTime dataHoraContigencia;

    @Element(name = "xJust", required = false)
    private String justificativaEntradaContingencia;

    @ElementList(entry = "NFref", inline = true, required = false)
    private List<NFInfoReferenciada> referenciadas;
    
    @Element(name = "gCompraGov", required = false)
    private NFNotaInfoIdentificacaoCompraGov gCompraGov; // B31
    
    @Element(name = "gPagAntecipado", required = false)
    private NFNotaInfoIdentificacaoPagAntecipado gPagAntecipado; // BB01

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public void setCodigoRandomico(final String codigoRandomico) {
        DFStringValidador.exatamente8(codigoRandomico, "Codigo Randomico");
        DFStringValidador.validaCodigoRandomico(codigoRandomico, "Codigo Randomico");
        if(StringUtils.isNotBlank(numeroNota) && StringUtils.equals(numeroNota.substring(1), codigoRandomico)){
            throw new IllegalStateException(String.format("N\u00FAmero da nota(%s) e c\u00F3digo(%s) n\u00E3o podem ser iguais", numeroNota.substring(1), codigoRandomico));
        }
        this.codigoRandomico = codigoRandomico;
    }

    public void setNaturezaOperacao(final String naturezaOperacao) {
        DFStringValidador.tamanho60(naturezaOperacao, "Natureza da Operacao");
        this.naturezaOperacao = naturezaOperacao;
    }

    public void setModelo(final DFModelo modelo) {
        this.modelo = modelo;
    }

    public void setSerie(final String serie) {
        DFStringValidador.validador(serie, "Serie", 3, false, true);
        this.serie = serie;
    }

    public void setNumeroNota(final String numeroNota) {
        DFStringValidador.tamanho9(numeroNota, "Numero da Nota");
        if(StringUtils.isNotBlank(codigoRandomico) && StringUtils.equals(numeroNota.substring(1), codigoRandomico)){
            throw new IllegalStateException(String.format("N\u00FAmero da nota(%s) e c\u00F3digo(%s) n\u00E3o podem ser iguais", numeroNota.substring(1), codigoRandomico));
        }
        this.numeroNota = numeroNota;
    }

    public void setDataHoraEmissao(final ZonedDateTime dataEmissao) {
        this.dataHoraEmissao = dataEmissao;
    }

    public void setDataHoraSaidaOuEntrada(final ZonedDateTime dataHoraSaidaOuEntrada) {
        this.dataHoraSaidaOuEntrada = dataHoraSaidaOuEntrada;
    }

    public void setTipo(final NFTipo tipo) {
        this.tipo = tipo;
    }

    public void setCodigoMunicipio(final String codigoMunicipio) {
        DFStringValidador.exatamente7N(codigoMunicipio, "Codigo Municipio");
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setCMunFGIBS(String cMunFGIBS) {
       this.cMunFGIBS = cMunFGIBS;
    }

    public void setReferenciadas(final List<NFInfoReferenciada> referenciadas) {
        DFListValidador.tamanho500(referenciadas, "Referenciadas");
        this.referenciadas = referenciadas;
    }

    public NFNotaInfoIdentificacaoCompraGov getGCompraGov() {
        return gCompraGov;
    }

    public NFNotaInfoIdentificacaoPagAntecipado getGPagAntecipado() {
       return gPagAntecipado;
    }
    
    public void setTipoImpressao(final NFTipoImpressao tipoImpressao) {
        this.tipoImpressao = tipoImpressao;
    }

    public void setTipoEmissao(final NFTipoEmissao tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
    }

    public void setDigitoVerificador(final Integer digitoVerificador) {
        DFIntegerValidador.exatamente1(digitoVerificador, "DV");
        this.digitoVerificador = digitoVerificador;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setFinalidade(final NFFinalidade finalidade) {
        this.finalidade = finalidade;
    }

    public NFDebito getTpNFDebito() {
       return tpNFDebito;
    }

    public NFCredito getTpNFCredito() {
        return tpNFCredito;
    }

    public void setProgramaEmissor(final NFProcessoEmissor programaEmissor) {
        this.programaEmissor = programaEmissor;
    }

    public void setVersaoEmissor(final String versaoEmissor) {
        DFStringValidador.tamanho20(versaoEmissor, "Versao Emissor");
        this.versaoEmissor = versaoEmissor;
    }

    public void setDataHoraContigencia(final ZonedDateTime dataHoraContigencia) {
        this.dataHoraContigencia = dataHoraContigencia;
    }

    public void setJustificativaEntradaContingencia(final String justificativaEntradaContingencia) {
        DFStringValidador.tamanho15a256(justificativaEntradaContingencia, "Justificativa Entrada Contingencia");
        this.justificativaEntradaContingencia = justificativaEntradaContingencia;
    }

    public void setIdentificadorLocalDestinoOperacao(final NFIdentificadorLocalDestinoOperacao identificadorLocalDestinoOperacao) {
        this.identificadorLocalDestinoOperacao = identificadorLocalDestinoOperacao;
    }

    public void setOperacaoConsumidorFinal(final NFOperacaoConsumidorFinal operacaoConsumidorFinal) {
        this.operacaoConsumidorFinal = operacaoConsumidorFinal;
    }

    public void setIndicadorPresencaComprador(final NFIndicadorPresencaComprador indicadorPresencaComprador) {
        this.indicadorPresencaComprador = indicadorPresencaComprador;
    }

	public void setIndIntermed(final NFIndicadorIntermediador indIntermed) {
		this.indIntermed = indIntermed;
	}
	
    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public String getCodigoRandomico() {
        return this.codigoRandomico;
    }

    public String getNaturezaOperacao() {
        return this.naturezaOperacao;
    }

    public DFModelo getModelo() {
        return this.modelo;
    }

    public String getSerie() {
        return this.serie;
    }

    public String getNumeroNota() {
        return this.numeroNota;
    }

    public ZonedDateTime getDataHoraEmissao() {
        return this.dataHoraEmissao;
    }

    public ZonedDateTime getDataHoraSaidaOuEntrada() {
        return this.dataHoraSaidaOuEntrada;
    }

    public NFTipo getTipo() {
        return this.tipo;
    }

    public NFIdentificadorLocalDestinoOperacao getIdentificadorLocalDestinoOperacao() {
        return this.identificadorLocalDestinoOperacao;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public String getCMunFGIBS() {
        return cMunFGIBS;
    }
    
    public NFTipoImpressao getTipoImpressao() {
        return this.tipoImpressao;
    }

    public NFTipoEmissao getTipoEmissao() {
        return this.tipoEmissao;
    }

    public Integer getDigitoVerificador() {
        return this.digitoVerificador;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public NFFinalidade getFinalidade() {
        return this.finalidade;
    }

    public void setTpNFDebito(NFDebito tpNFDebito) {
        this.tpNFDebito = tpNFDebito;
    }
    
    public void setTpNFCredito(NFCredito tpNFCredito) {
        this.tpNFCredito = tpNFCredito;
    }
    
    public NFOperacaoConsumidorFinal getOperacaoConsumidorFinal() {
        return this.operacaoConsumidorFinal;
    }

    public NFIndicadorPresencaComprador getIndicadorPresencaComprador() {
        return this.indicadorPresencaComprador;
    }
    
    public NFIndicadorIntermediador getIndIntermed() {
		return indIntermed;
	}

    public NFProcessoEmissor getProgramaEmissor() {
        return this.programaEmissor;
    }

    public String getVersaoEmissor() {
        return this.versaoEmissor;
    }

    public ZonedDateTime getDataHoraContigencia() {
        return this.dataHoraContigencia;
    }

    public String getJustificativaEntradaContingencia() {
        return this.justificativaEntradaContingencia;
    }

    public List<NFInfoReferenciada> getReferenciadas() {
        return this.referenciadas;
    }
    
    public void setGCompraGov(NFNotaInfoIdentificacaoCompraGov gCompraGov) {
       this.gCompraGov = gCompraGov;
    }
    
    public void setGPagAntecipado(NFNotaInfoIdentificacaoPagAntecipado gPagAntecipado) {
        this.gPagAntecipado = gPagAntecipado;
    }
	
}