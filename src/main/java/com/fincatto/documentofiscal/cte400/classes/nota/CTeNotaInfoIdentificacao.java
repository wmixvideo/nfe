package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.*;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Identificacao do CT-e
 */

@Root(name = "ide")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoIdentificacao extends DFBase {
    private static final long serialVersionUID = 7938149076755500266L;

    @Element(name = "cUF")
    private DFUnidadeFederativa codigoUF;
    
    @Element(name = "cCT")
    private String codigoNumerico;
    
    @Element(name = "CFOP")
    private String cfop;
    
    @Element(name = "natOp")
    private String naturezaOperacao;
    
    @Element(name = "mod")
    private DFModelo modelo;
    
    @Element(name = "serie")
    private Integer serie;
    
    @Element(name = "nCT")
    private Integer numero;
    
    @Element(name = "dhEmi")
    private ZonedDateTime dataEmissao;
    
    @Element(name = "tpImp")
    private CTTipoImpressao tipoImpressao;
    
    @Element(name = "tpEmis")
    private CTTipoEmissao tipoEmissao;
    
    @Element(name = "cDV")
    private Integer digitoVerificador;
    
    @Element(name = "tpAmb")
    private DFAmbiente ambiente;
    
    @Element(name = "tpCTe")
    private CTFinalidade finalidade;
    
    @Element(name = "procEmi")
    private CTProcessoEmissao processoEmissao;
    
    @Element(name = "verProc")
    private String versaoProcessoEmissao;
    
    @Element(name = "indGlobalizado", required = false)
    private Integer indicadorGlobalizado;
    
    @Element(name = "cMunEnv")
    private String codigoMunicipioEnvio;
    
    @Element(name = "xMunEnv")
    private String descricaoMunicipioEnvio;
    
    @Element(name = "UFEnv")
    private String siglaUFEnvio;
    
    @Element(name = "modal")
    private CTModal modalidadeFrete;
    
    @Element(name = "tpServ")
    private CTTipoServico tipoServico;
    
    @Element(name = "cMunIni")
    private String codigoMunicipioInicio;
    
    @Element(name = "xMunIni")
    private String descricaoMunicipioInicio;
    
    @Element(name = "UFIni")
    private String siglaUfInicio;
    
    @Element(name = "cMunFim")
    private String codigoMunicipioFim;
    
    @Element(name = "xMunFim")
    private String descricaoMunicipioFim;
    
    @Element(name = "UFFim")
    private String siglaUfFim;
    
    @Element(name = "retira")
    private CTRetirada retira;
    
    @Element(name = "xDetRetira", required = false)
    private String detalheRetira;
    
    @Element(name = "indIEToma")
    private CTIndicadorTomador indIEToma;
    
    @Element(name = "toma3", required = false)
    private CTeNotaInfoIdentificacaoTomadorServico3 tomadorServico3;
    
    @Element(name = "toma4", required = false)
    private CTeNotaInfoIdentificacaoTomadorServico4 tomadorServico4;
    
    @Element(name = "dhCont", required = false)
    private LocalDateTime dataContingencia;
    
    @Element(name = "xJust", required = false)
    private String justificativa;
    
    public DFUnidadeFederativa getCodigoUF() {
        return this.codigoUF;
    }
    
    /**
     * Codigo da UF do emitente do CT-e.
     */
    public void setCodigoUF(final DFUnidadeFederativa codigoUF) {
        this.codigoUF = codigoUF;
    }
    
    public String getCodigoNumerico() {
        return this.codigoNumerico;
    }
    
    /**
     * Codigo numerico que compoe a Chave de Acesso.<br>
     * Numero aleatorio gerado pelo emitente para cada CT-e, com o objetivo de evitar acessos indevidos ao documento.
     */
    public void setCodigoNumerico(final String codigoNumerico) {
        DFStringValidador.exatamente8N(codigoNumerico, "Codigo Numerico");
        this.codigoNumerico = codigoNumerico;
    }
    
    public String getCfop() {
        return this.cfop;
    }
    
    /**
     * Codigo Fiscal de Operacoes e Prestacoes
     */
    public void setCfop(final String cfop) {
        DFStringValidador.exatamente4N(cfop, "CFOP");
        this.cfop = cfop;
    }
    
    public String getNaturezaOperacao() {
        return this.naturezaOperacao;
    }
    
    /**
     * Natureza da Operacao
     */
    public void setNaturezaOperacao(final String naturezaOperacao) {
        DFStringValidador.tamanho2ate60(naturezaOperacao, "Natureza da Operacao");
        this.naturezaOperacao = naturezaOperacao;
    }
    
    public DFModelo getModelo() {
        return this.modelo;
    }
    
    /**
     * Modelo do documento fiscal<br>
     * Utilizar o codigo 57 para identificacao do CT-e, emitido em substituicao aos modelos de conhecimentos em papel.
     */
    public void setModelo(final DFModelo modelo) {
        this.modelo = modelo;
    }
    
    public Integer getSerie() {
        return this.serie;
    }
    
    /**
     * Serie do CT-e<br>
     * Preencher com "0" no caso de serie unica
     */
    public void setSerie(final Integer serie) {
        DFIntegerValidador.tamanho3(serie, "Serie");
        this.serie = serie;
    }
    
    public Integer getNumero() {
        return this.numero;
    }
    
    /**
     * Numero do CT-e
     */
    public void setNumero(final Integer numero) {
        DFIntegerValidador.tamanho9(numero, "Numero");
        this.numero = numero;
    }
    
    public ZonedDateTime getDataEmissao() {
        return this.dataEmissao;
    }
    
    /**
     * Data e hora de emissao do CT-e<br>
     * Formato AAAA-MM-DDTHH:MM:DD TZD
     */
    public void setDataEmissao(final ZonedDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
    
    public CTTipoImpressao getTipoImpressao() {
        return this.tipoImpressao;
    }
    
    /**
     * Formato de impressao do DACTE<br>
     * Preencher com: 1 - Retrato; 2 - Paisagem.
     */
    public void setTipoImpressao(final CTTipoImpressao tipoImpressao) {
        this.tipoImpressao = tipoImpressao;
    }
    
    public CTTipoEmissao getTipoEmissao() {
        return this.tipoEmissao;
    }
    
    /**
     * Forma de emissao do CT-e<br>
     * Preencher com:<br>
     * 1 - Normal;<br>
     * 4 - EPEC pela SVC; 5 - Contingencia FSDA;<br>
     * 7 - Autorizacao pela SVC-RS;<br>
     * 8 - Autorizacao pela SVC-SP;<br>
     */
    public void setTipoEmissao(final CTTipoEmissao tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
    }
    
    public Integer getDigitoVerificador() {
        return this.digitoVerificador;
    }
    
    /**
     * Digito Verificador da chave de acesso do CT-e<br>
     * Informar o digito de controle da chave de acesso do CT-e, que deve ser calculado com a aplicacao do algoritmo modulo 11 (base 2,9) da chave de acesso.
     */
    public void setDigitoVerificador(final Integer digitoVerificador) {
        DFIntegerValidador.exatamente1(digitoVerificador, "DV");
        this.digitoVerificador = digitoVerificador;
    }
    
    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }
    
    /**
     * Tipo do Ambiente<br>
     * Preencher com:<br>
     * 1 - Producao;<br>
     * 2 - Homologacao
     */
    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }
    
    public CTFinalidade getFinalidade() {
        return this.finalidade;
    }
    
    /**
     * Tipo do CT-e<br>
     * Preencher com:<br>
     * 0 - CT-e Normal;<br>
     * 1 - CT-e de Complemento de Valores;<br>
     * 2 - CT-e de Anulacao;<br>
     * 3 - CT-e Substituto
     */
    public void setFinalidade(final CTFinalidade finalidade) {
        this.finalidade = finalidade;
    }
    
    public CTProcessoEmissao getProcessoEmissao() {
        return this.processoEmissao;
    }
    
    /**
     * Identificador do processo de emissao do CT-e<br>
     * Preencher com:<br>
     * 0 - emissao de CT-e com aplicativo do contribuinte;<br>
     * 3- emissao CT-e pelo contribuinte com aplicativo fornecido pelo Fisco.
     */
    public void setProcessoEmissao(final CTProcessoEmissao processoEmissao) {
        this.processoEmissao = processoEmissao;
    }
    
    public String getVersaoProcessoEmissao() {
        return this.versaoProcessoEmissao;
    }
    
    /**
     * Versao do processo de emissao<br>
     * Iinformar a versao do aplicativo emissor de CT-e.
     */
    public void setVersaoProcessoEmissao(final String versaoProcessoEmissao) {
        DFStringValidador.tamanho20(versaoProcessoEmissao, "Versao Aplicativo Emissor");
        this.versaoProcessoEmissao = versaoProcessoEmissao;
    }
    
    public Integer getIndicadorGlobalizado() {
        return this.indicadorGlobalizado;
    }
    
    /**
     * Indicador de CT-e Globalizado<br>
     * Informar valor 1 quando for Globalizado e nao informar a tag quando nao tratar de CT-e Globalizado
     */
    public void setIndicadorGlobalizado(final Integer indicadorGlobalizado) {
        DFIntegerValidador.exatamente1(indicadorGlobalizado, "Indicador de CT-e Globalizado");
        this.indicadorGlobalizado = indicadorGlobalizado;
    }
    
    public String getCodigoMunicipioEnvio() {
        return this.codigoMunicipioEnvio;
    }
    
    /**
     * Codigo do Municipio de envio do CT-e (de onde o documento foi transmitido)<br>
     * Utilizar a tabela do IBGE. Informar 9999999 para as operacoes com o exterior.
     */
    public void setCodigoMunicipioEnvio(final String codigoMunicipioEnvio) {
        DFStringValidador.exatamente7N(codigoMunicipioEnvio, "Codigo do Municipio de envio do CT-e");
        this.codigoMunicipioEnvio = codigoMunicipioEnvio;
    }
    
    public String getDescricaoMunicipioEnvio() {
        return this.descricaoMunicipioEnvio;
    }
    
    /**
     * Nome do Municipio de envio do CT-e (de onde o documento foi transmitido)<br>
     * Informar PAIS/Municipio para as operacoes com o exterior.
     */
    public void setDescricaoMunicipioEnvio(final String descricaoMunicipioEnvio) {
        DFStringValidador.tamanho2ate60(descricaoMunicipioEnvio, "Nome do Municipio de envio do CT-e");
        this.descricaoMunicipioEnvio = descricaoMunicipioEnvio;
    }
    
    public String getSiglaUFEnvio() {
        return this.siglaUFEnvio;
    }
    
    /**
     * Sigla da UF de envio do CT-e (de onde o documento foi transmitido)<br>
     * Informar 'EX' para operacoes com o exterior.
     */
    public void setSiglaUFEnvio(final String siglaUFEnvio) {
        DFStringValidador.exatamente2(siglaUFEnvio, "Sigla da UF de envio do CT-e");
        this.siglaUFEnvio = siglaUFEnvio;
    }
    
    public CTModal getModalidadeFrete() {
        return this.modalidadeFrete;
    }
    
    /**
     * Modal<br>
     * Preencher com:<br>
     * 01 - Rodoviario;<br>
     * 02 - Aereo;<br>
     * 03 - Aquaviario;<br>
     * 04 - Ferroviario;<br>
     * 05 - Dutoviario;<br>
     * 06 - Multimodal;
     */
    public void setModalidadeFrete(final CTModal modalidadeFrete) {
        this.modalidadeFrete = modalidadeFrete;
    }
    
    public CTTipoServico getTipoServico() {
        return this.tipoServico;
    }
    
    /**
     * Tipo do Servico<br>
     * Preencher com:<br>
     * 0 - Normal;<br>
     * 1 - Subcontratacao;<br>
     * 2 - Redespacho;<br>
     * 3 - Redespacho Intermediario;<br>
     * 4 - Servico Vinculado a Multimodal
     */
    public void setTipoServico(final CTTipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }
    
    public String getCodigoMunicipioInicio() {
        return this.codigoMunicipioInicio;
    }
    
    /**
     * Codigo do Municipio de inicio da prestacao<br>
     * Utilizar a tabela do IBGE. Informar 9999999 para operacoes com o exterior.
     */
    public void setCodigoMunicipioInicio(final String codigoMunicipioInicio) {
        DFStringValidador.exatamente7N(codigoMunicipioInicio, "Codigo do Municipio de inicio da prestacao");
        this.codigoMunicipioInicio = codigoMunicipioInicio;
    }
    
    public String getDescricaoMunicipioInicio() {
        return this.descricaoMunicipioInicio;
    }
    
    /**
     * Nome do Municipio do inicio da prestacao<br>
     * Informar 'EXTERIOR' para operacoes com o exterior.
     */
    public void setDescricaoMunicipioInicio(final String descricaoMunicipioInicio) {
        DFStringValidador.tamanho2ate60(descricaoMunicipioInicio, "Nome do Municipio do inicio da prestacao");
        this.descricaoMunicipioInicio = descricaoMunicipioInicio;
    }
    
    public String getSiglaUfInicio() {
        return this.siglaUfInicio;
    }
    
    /**
     * UF do inicio da prestacao<br>
     * Informar 'EX' para operacoes com o exterior.
     */
    public void setSiglaUfInicio(final String siglaUfInicio) {
        DFStringValidador.exatamente2(siglaUfInicio, "UF do inicio da prestacao");
        this.siglaUfInicio = siglaUfInicio;
    }
    
    public String getCodigoMunicipioFim() {
        return this.codigoMunicipioFim;
    }
    
    /**
     * Codigo do Municipio de termino da prestacao<br>
     * Utilizar a tabela do IBGE. Informar 9999999 para operacoes com o exterior.
     */
    public void setCodigoMunicipioFim(final String codigoMunicipioFim) {
        DFStringValidador.exatamente7N(codigoMunicipioFim, "Codigo do Municipio de termino da prestacao");
        this.codigoMunicipioFim = codigoMunicipioFim;
    }
    
    public String getDescricaoMunicipioFim() {
        return this.descricaoMunicipioFim;
    }
    
    /**
     * Nome do Municipio do termino da prestacao<br>
     * Informar 'EXTERIOR' para operacoes com o exterior.
     */
    public void setDescricaoMunicipioFim(final String descricaoMunicipioFim) {
        DFStringValidador.tamanho2ate60(descricaoMunicipioFim, "Nome do Municipio do termino da prestacao");
        this.descricaoMunicipioFim = descricaoMunicipioFim;
    }
    
    public String getSiglaUfFim() {
        return this.siglaUfFim;
    }
    
    /**
     * UF do termino da prestacao<br>
     * Informar 'EX' para operacoes com o exterior.
     */
    public void setSiglaUfFim(final String siglaUfFim) {
        DFStringValidador.exatamente2(siglaUfFim, "UF do termino da prestacao");
        this.siglaUfFim = siglaUfFim;
    }
    
    public CTRetirada getRetira() {
        return this.retira;
    }
    
    /**
     * Indicador se o Recebedor retira no Aeroporto, Filial, Porto ou Estacao de Destino?<br>
     * Preencher com:<br>
     * 0 - sim;<br>
     * 1 - nao
     */
    public void setRetira(final CTRetirada retira) {
        this.retira = retira;
    }
    
    public String getDetalheRetira() {
        return this.detalheRetira;
    }
    
    /**
     * Detalhes da retirada
     */
    public void setDetalheRetira(final String detalheRetira) {
        DFStringValidador.tamanho160(detalheRetira, "Detalhes da retirada");
        this.detalheRetira = detalheRetira;
    }
    
    public CTIndicadorTomador getIndIEToma() {
        return this.indIEToma;
    }
    
    /**
     * Indicador do papel do tomador na prestacao do servico:<br>
     * 1 – Contribuinte ICMS;<br>
     * 2 – Contribuinte isento de inscricao;<br>
     * 9 – Nao Contribuinte<br>
     * Aplica-se ao tomador que for indicado no toma3 ou toma4
     */
    public void setIndIEToma(final CTIndicadorTomador indIEToma) {
        this.indIEToma = indIEToma;
    }
    
    public CTeNotaInfoIdentificacaoTomadorServico3 getTomadorServico3() {
        return this.tomadorServico3;
    }
    
    /**
     * Indicador do "papel" do tomador do servico no CT-e
     */
    public void setTomadorServico3(final CTeNotaInfoIdentificacaoTomadorServico3 toma3) {
        this.tomadorServico3 = toma3;
    }
    
    public CTeNotaInfoIdentificacaoTomadorServico4 getTomadorServico4() {
        return this.tomadorServico4;
    }
    
    /**
     * Indicador do "papel" do tomador do servico no CT-e
     */
    public void setTomadorServico4(final CTeNotaInfoIdentificacaoTomadorServico4 toma4) {
        this.tomadorServico4 = toma4;
    }
    
    public LocalDateTime getDataContingencia() {
        return this.dataContingencia;
    }
    
    /**
     * Data e Hora da entrada em contingencia<br>
     * Informar a data e hora no formato AAAA-MM-DDTHH:MM:SS
     */
    public void setDataContingencia(final LocalDateTime dataContingencia) {
        this.dataContingencia = dataContingencia;
    }
    
    public String getJustificativa() {
        return this.justificativa;
    }
    
    /**
     * Justificativa da entrada em contingencia
     */
    public void setJustificativa(final String justificativa) {
        DFStringValidador.tamanho15a256(justificativa, "Justificativa da entrada em contingencia");
        this.justificativa = justificativa;
    }
}
