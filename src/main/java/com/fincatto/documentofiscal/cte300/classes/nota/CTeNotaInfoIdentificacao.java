package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.Date;

import org.joda.time.LocalDateTime;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte300.classes.CTFinalidade;
import com.fincatto.documentofiscal.cte300.classes.CTIndicadorTomador;
import com.fincatto.documentofiscal.cte300.classes.CTModal;
import com.fincatto.documentofiscal.cte300.classes.CTProcessoEmissao;
import com.fincatto.documentofiscal.cte300.classes.CTRetirada;
import com.fincatto.documentofiscal.cte300.classes.CTTipoEmissao;
import com.fincatto.documentofiscal.cte300.classes.CTTipoImpressao;
import com.fincatto.documentofiscal.cte300.classes.CTTipoServico;
import com.fincatto.documentofiscal.validadores.IntegerValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Identificação do CT-e
 * */

@Root(name = "ide")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoIdentificacao extends DFBase {

	@Element(name = "cUF", required = true)
    private DFUnidadeFederativa codigoUF;
	
	@Element(name = "cCT", required = true)
    private String codigoNumerico;
	
	@Element(name = "CFOP", required = true)
    private String cfop;
	
	@Element(name = "natOp", required = true)
    private String naturezaOperacao;
	
	@Element(name = "mod", required = true)
    private DFModelo modelo;
	
	@Element(name = "serie", required = true)
    private Integer serie;
	
	@Element(name = "nCT", required = true)
    private Integer numero;
	
	@Element(name = "dhEmi", required = true)
    private LocalDateTime dataEmissao;
	
	@Element(name = "tpImp", required = true)
    private CTTipoImpressao tipoImpressao;
	
	@Element(name = "tpEmis", required = true)
    private CTTipoEmissao tipoEmissao;
	
	@Element(name = "cDV", required = true)
    private Integer digitoVerificador;
	
	@Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;
	
	@Element(name = "tpCTe", required = true)
    private CTFinalidade finalidade;
	
	@Element(name = "procEmi", required = true)
    private CTProcessoEmissao processoEmissao;
	
	@Element(name = "verProc", required = true)
    private String versaoProcessoEmissao;
	
	@Element(name = "indGlobalizado", required = false)
    private Integer indicadorGlobalizado;
	
	@Element(name = "cMunEnv", required = true)
    private String codigoMunicipioEnvio;
	
	@Element(name = "xMunEnv", required = true)
    private String descricaoMunicipioEnvio;
	
	@Element(name = "UFEnv", required = true)
    private String siglaUFEnvio;
	
	@Element(name = "modal", required = true)
    private CTModal modalidadeFrete;
	
	@Element(name = "tpServ", required = true)
    private CTTipoServico tipoServico;
	
	@Element(name = "cMunIni", required = true)
    private String codigoMunicipioInicio;
	
	@Element(name = "xMunIni", required = true)
    private String descricaoMunicipioInicio;
	
	@Element(name = "UFIni", required = true)
    private String siglaUfInicio;
	
	@Element(name = "cMunFim", required = true)
    private String codigoMunicipioFim;
	
	@Element(name = "xMunFim", required = true)
    private String descricaoMunicipioFim;
	
	@Element(name = "UFFim", required = true)
    private String siglaUfFim;
	
	@Element(name = "retira", required = true)
    private CTRetirada retira;
	
	@Element(name = "xDetRetira", required = false)
    private String detalheRetira;
	
	@Element(name = "indIEToma", required = true)
    private CTIndicadorTomador indIEToma;
	
	@Element(name = "toma3", required = false)
    private CTeNotaInfoIdentificacaoTomadorServico3 tomadorServico3;
	
	@Element(name = "toma4", required = false)
    private CTeNotaInfoIdentificacaoTomadorServico4 tomadorServico4;
	
	@Element(name = "dhCont", required = false)
    private Date dataContingencia;
	
	@Element(name = "xJust", required = false)
    private String justificativa;

	public CTeNotaInfoIdentificacao() {
		this.codigoUF = null;
		this.codigoNumerico = null;
		this.cfop = null;
		this.naturezaOperacao = null;
		this.modelo = null;
		this.serie = null;
		this.numero = null;
		this.dataEmissao = null;
		this.tipoImpressao = null;
		this.tipoEmissao = null;
		this.digitoVerificador = null;
		this.ambiente = null;
		this.finalidade = null;
		this.processoEmissao = null;
		this.versaoProcessoEmissao = null;
		this.indicadorGlobalizado = null;
		this.codigoMunicipioEnvio = null;
		this.descricaoMunicipioEnvio = null;
		this.siglaUFEnvio = null;
		this.modalidadeFrete = null;
		this.tipoServico = null;
		this.codigoMunicipioInicio = null;
		this.descricaoMunicipioInicio = null;
		this.siglaUfInicio = null;
		this.codigoMunicipioFim = null;
		this.descricaoMunicipioFim = null;
		this.siglaUfFim = null;
		this.retira = null;
		this.detalheRetira = null;
		this.indIEToma = null;
		this.tomadorServico3 = null;
		this.tomadorServico4 = null;
		this.dataContingencia = null;
		this.justificativa = null;
	}

	public DFUnidadeFederativa getCodigoUF() {
		return codigoUF;
	}

	/**
	 * Código da UF do emitente do CT-e.
	 * */
	public void setCodigoUF(DFUnidadeFederativa codigoUF) {
		this.codigoUF = codigoUF;
	}

	public String getCodigoNumerico() {
		return codigoNumerico;
	}

	/**
	 * Código numérico que compõe a Chave de Acesso.<br>
	 * Número aleatório gerado pelo emitente para cada CT-e, com o objetivo de evitar acessos indevidos ao documento.
	 * */
	public void setCodigoNumerico(String codigoNumerico) {
		StringValidador.exatamente8N(codigoNumerico, "Código Numérico");
		this.codigoNumerico = codigoNumerico;
	}

	public String getCfop() {
		return cfop;
	}

	/**
	 * Código Fiscal de Operações e Prestações
	 * */
	public void setCfop(String cfop) {
		StringValidador.exatamente4N(cfop, "CFOP");
		this.cfop = cfop;
	}

	public String getNaturezaOperacao() {
		return naturezaOperacao;
	}

	/**
	 * Natureza da Operação
	 * */
	public void setNaturezaOperacao(String naturezaOperacao) {
		StringValidador.tamanho2ate60(naturezaOperacao, "Natureza da Operação");
		this.naturezaOperacao = naturezaOperacao;
	}

	public DFModelo getModelo() {
		return modelo;
	}

	/**
	 * Modelo do documento fiscal<br>
	 * Utilizar o código 57 para identificação do CT-e, emitido em substituição aos modelos de conhecimentos em papel.
	 * */
	public void setModelo(DFModelo modelo) {
		this.modelo = modelo;
	}

	public Integer getSerie() {
		return serie;
	}

	/**
	 * Série do CT-e<br>
	 * Preencher com "0" no caso de série única
	 * */
	public void setSerie(Integer serie) {
		IntegerValidador.tamanho3(serie, "Série");
		this.serie = serie;
	}

	public Integer getNumero() {
		return numero;
	}

	/**
	 * Número do CT-e
	 * */
	public void setNumero(Integer numero) {
		IntegerValidador.tamanho9(numero, "Número");
		this.numero = numero;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * Data e hora de emissão do CT-e<br>
	 * Formato AAAA-MM-DDTHH:MM:DD TZD
	 * */
	public void setDataEmissao(LocalDateTime dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public CTTipoImpressao getTipoImpressao() {
		return tipoImpressao;
	}

	/**
	 * Formato de impressão do DACTE<br>
	 * Preencher com: 1 - Retrato; 2 - Paisagem.
	 * */
	public void setTipoImpressao(CTTipoImpressao tipoImpressao) {
		this.tipoImpressao = tipoImpressao;
	}

	public CTTipoEmissao getTipoEmissao() {
		return tipoEmissao;
	}

	/**
	 * Forma de emissão do CT-e<br>
	 * Preencher com:<br>
	 * 1 - Normal;<br>
	 * 4 - EPEC pela SVC; 5 - Contingência FSDA;<br>
	 * 7 - Autorização pela SVC-RS;<br>
	 * 8 - Autorização pela SVC-SP;<br>
	 * */
	public void setTipoEmissao(CTTipoEmissao tipoEmissao) {
		this.tipoEmissao = tipoEmissao;
	}

	public Integer getDigitoVerificador() {
		return digitoVerificador;
	}

	/**
	 * Digito Verificador da chave de acesso do CT-e<br>
	 * Informar o dígito  de controle da chave de acesso do CT-e, 
	 * que deve ser calculado com a aplicação do algoritmo módulo 11 (base 2,9) da chave de acesso.
	 * */
	public void setDigitoVerificador(Integer digitoVerificador) {
		IntegerValidador.exatamente1(digitoVerificador, "DV");
		this.digitoVerificador = digitoVerificador;
	}

	public DFAmbiente getAmbiente() {
		return ambiente;
	}

	/**
	 * Tipo do Ambiente<br>
	 * Preencher com:<br>
	 * 1 - Produção;<br>
	 * 2 - Homologação
	 * */
	public void setAmbiente(DFAmbiente ambiente) {
		this.ambiente = ambiente;
	}

	public CTFinalidade getFinalidade() {
		return finalidade;
	}

	/**
	 * Tipo do CT-e<br>
	 * Preencher com:<br>
	 * 0 - CT-e Normal;<br>
	 * 1 - CT-e de Complemento de Valores;<br>
	 * 2 - CT-e de Anulação;<br>
	 * 3 - CT-e Substituto
	 * */
	public void setFinalidade(CTFinalidade finalidade) {
		this.finalidade = finalidade;
	}

	public CTProcessoEmissao getProcessoEmissao() {
		return processoEmissao;
	}

	/**
	 * Identificador do processo de emissão do CT-e<br>
	 * Preencher com:<br>
	 * 0 - emissão de CT-e com aplicativo do contribuinte;<br>
	 * 3- emissão CT-e pelo contribuinte com aplicativo fornecido pelo Fisco.
	 * */
	public void setProcessoEmissao(CTProcessoEmissao processoEmissao) {
		this.processoEmissao = processoEmissao;
	}

	public String getVersaoProcessoEmissao() {
		return versaoProcessoEmissao;
	}

	/**
	 * Versão do processo de emissão<br>
	 * Iinformar a versão do aplicativo emissor de CT-e.
	 * */
	public void setVersaoProcessoEmissao(String versaoProcessoEmissao) {
		StringValidador.tamanho20(versaoProcessoEmissao, "Versão Aplicativo Emissor");
		this.versaoProcessoEmissao = versaoProcessoEmissao;
	}

	public Integer getIndicadorGlobalizado() {
		return indicadorGlobalizado;
	}

	/**
	 * Indicador de CT-e Globalizado<br>
	 * Informar valor 1 quando for Globalizado e não informar a tag quando não tratar de CT-e Globalizado
	 * */
	public void setIndicadorGlobalizado(Integer indicadorGlobalizado) {
		IntegerValidador.exatamente1(indicadorGlobalizado, "Indicador de CT-e Globalizado");
		this.indicadorGlobalizado = indicadorGlobalizado;
	}

	public String getCodigoMunicipioEnvio() {
		return codigoMunicipioEnvio;
	}
	
	/**
	 * Código do Município de envio do CT-e (de onde o documento foi transmitido)<br>
	 * Utilizar a tabela do IBGE. Informar 9999999 para as operações com o exterior.
	 * */
	public void setCodigoMunicipioEnvio(String codigoMunicipioEnvio) {
		StringValidador.exatamente7N(codigoMunicipioEnvio, "Código do Município de envio do CT-e");
		this.codigoMunicipioEnvio = codigoMunicipioEnvio;
	}

	public String getDescricaoMunicipioEnvio() {
		return descricaoMunicipioEnvio;
	}

	/**
	 * Nome do Município de envio do CT-e (de onde o documento foi transmitido)<br>
	 * Informar PAIS/Municipio para as operações com o exterior.
	 * */
	public void setDescricaoMunicipioEnvio(String descricaoMunicipioEnvio) {
		StringValidador.tamanho2ate60(descricaoMunicipioEnvio, "Nome do Município de envio do CT-e");
		this.descricaoMunicipioEnvio = descricaoMunicipioEnvio;
	}

	public String getSiglaUFEnvio() {
		return siglaUFEnvio;
	}

	/**
	 * Sigla da UF de envio do CT-e (de onde o documento foi transmitido)<br>
	 * Informar 'EX' para operações com o exterior.
	 * */
	public void setSiglaUFEnvio(String siglaUFEnvio) {
		StringValidador.exatamente2(siglaUFEnvio, "Sigla da UF de envio do CT-e");
		this.siglaUFEnvio = siglaUFEnvio;
	}

	public CTModal getModalidadeFrete() {
		return modalidadeFrete;
	}

	/**
	 * Modal<br>
	 * Preencher com:<br>
	 * 01 - Rodoviário;<br>
	 * 02 - Aéreo;<br>
	 * 03 - Aquaviário;<br>
	 * 04 - Ferroviário;<br>
	 * 05 - Dutoviário;<br>
	 * 06 - Multimodal;
	 * */
	public void setModalidadeFrete(CTModal modalidadeFrete) {
		this.modalidadeFrete = modalidadeFrete;
	}

	public CTTipoServico getTipoServico() {
		return tipoServico;
	}

	/**
	 * Tipo do Serviço<br>
	 * Preencher com:<br>
	 * 0 - Normal;<br>
	 * 1 - Subcontratação;<br>
	 * 2 - Redespacho;<br>
	 * 3 - Redespacho Intermediário;<br>
	 * 4 - Serviço Vinculado a Multimodal
	 * */
	public void setTipoServico(CTTipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getCodigoMunicipioInicio() {
		return codigoMunicipioInicio;
	}

	/**
	 * Código do Município de início da prestação<br>
	 * Utilizar a tabela do IBGE. Informar 9999999 para operações com o exterior.
	 * */
	public void setCodigoMunicipioInicio(String codigoMunicipioInicio) {
		StringValidador.exatamente7N(codigoMunicipioInicio, "Código do Município de início da prestação");
		this.codigoMunicipioInicio = codigoMunicipioInicio;
	}

	public String getDescricaoMunicipioInicio() {
		return descricaoMunicipioInicio;
	}

	/**
	 * Nome do Município do início da prestação<br>
	 * Informar 'EXTERIOR' para operações com o exterior.
	 * */
	public void setDescricaoMunicipioInicio(String descricaoMunicipioInicio) {
		StringValidador.tamanho2ate60(descricaoMunicipioInicio, "Nome do Município do início da prestação");
		this.descricaoMunicipioInicio = descricaoMunicipioInicio;
	}

	public String getSiglaUfInicio() {
		return siglaUfInicio;
	}

	/**
	 * UF do início da prestação<br>
	 * Informar 'EX' para operações com o exterior.
	 * */
	public void setSiglaUfInicio(String siglaUfInicio) {
		StringValidador.exatamente2(siglaUfInicio, "UF do início da prestação");
		this.siglaUfInicio = siglaUfInicio;
	}

	public String getCodigoMunicipioFim() {
		return codigoMunicipioFim;
	}

	/**
	 * Código do Município de término da prestação<br>
	 * Utilizar a tabela do IBGE. Informar 9999999 para operações com o exterior.
	 * */
	public void setCodigoMunicipioFim(String codigoMunicipioFim) {
		StringValidador.exatamente7N(codigoMunicipioFim, "Código do Município de término da prestação");
		this.codigoMunicipioFim = codigoMunicipioFim;
	}

	public String getDescricaoMunicipioFim() {
		return descricaoMunicipioFim;
	}

	/**
	 * Nome do Município do término da prestação<br>
	 * Informar 'EXTERIOR' para operações com o exterior.
	 * */
	public void setDescricaoMunicipioFim(String descricaoMunicipioFim) {
		StringValidador.tamanho2ate60(descricaoMunicipioFim, "Nome do Município do término da prestação");
		this.descricaoMunicipioFim = descricaoMunicipioFim;
	}

	public String getSiglaUfFim() {
		return siglaUfFim;
	}

	/**
	 * UF do término da prestação<br>
	 * Informar 'EX' para operações com o exterior.
	 * */
	public void setSiglaUfFim(String siglaUfFim) {
		StringValidador.exatamente2(siglaUfFim, "UF do término da prestação");
		this.siglaUfFim = siglaUfFim;
	}

	public CTRetirada getRetira() {
		return retira;
	}

	/**
	 * Indicador se o Recebedor retira no Aeroporto, Filial, Porto ou Estação de Destino?<br>
	 * Preencher com:<br>
	 * 0 - sim;<br>
	 * 1 - não
	 * */
	public void setRetira(CTRetirada retira) {
		this.retira = retira;
	}

	public String getDetalheRetira() {
		return detalheRetira;
	}

	/**
	 * Detalhes da retirada
	 * */
	public void setDetalheRetira(String detalheRetira) {
		StringValidador.tamanho160(detalheRetira, "Detalhes da retirada");
		this.detalheRetira = detalheRetira;
	}

	public CTIndicadorTomador getIndIEToma() {
		return indIEToma;
	}

	/**
	 * Indicador do papel do tomador na prestação do serviço:<br>
	 * 1 – Contribuinte ICMS;<br>
	 * 2 – Contribuinte isento de inscrição;<br>
	 * 9 – Não Contribuinte<br>
	 * Aplica-se ao tomador que for indicado no toma3 ou toma4
	 * */
	public void setIndIEToma(CTIndicadorTomador indIEToma) {
		this.indIEToma = indIEToma;
	}

	public CTeNotaInfoIdentificacaoTomadorServico3 getTomadorServico3() {
		return tomadorServico3;
	}

	/**
	 * Indicador do "papel" do tomador do serviço no CT-e
	 * */
	public void setTomadorServico3(CTeNotaInfoIdentificacaoTomadorServico3 toma3) {
		this.tomadorServico3 = toma3;
	}

	public CTeNotaInfoIdentificacaoTomadorServico4 getTomadorServico4() {
		return tomadorServico4;
	}

	/**
	 * Indicador do "papel" do tomador do serviço no CT-e
	 * */
	public void setTomadorServico4(CTeNotaInfoIdentificacaoTomadorServico4 toma4) {
		this.tomadorServico4 = toma4;
	}

	public Date getDataContingencia() {
		return dataContingencia;
	}

	/**
	 * Data e Hora da entrada em contingência<br>
	 * Informar a data e hora no formato AAAA-MM-DDTHH:MM:SS
	 * */
	public void setDataContingencia(Date dataContingencia) {
		this.dataContingencia = dataContingencia;
	}

	public String getJustificativa() {
		return justificativa;
	}

	/**
	 * Justificativa da entrada em contingência
	 * */
	public void setJustificativa(String justificativa) {
		StringValidador.tamanho15a256(justificativa, "Justificativa da entrada em contingência");
		this.justificativa = justificativa;
	}
	
}
