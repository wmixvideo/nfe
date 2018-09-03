package com.fincatto.documentofiscal.mdfe3.classes.nota;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.*;
import com.fincatto.documentofiscal.validadores.IntegerValidador;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 03/11/17.
 * <h1>Identificação do MDF-e</h1>
 */
@Root(name = "ide")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoIdentificacao extends DFBase {
    private static final long serialVersionUID = -106178398166932545L;

    @Element(name = "cUF")
    private DFUnidadeFederativa codigoUF;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "tpEmit")
    private MDFTipoEmitente tipoEmitente;

    @Element(name = "tpTransp", required = false)
    private MDFTipoTranportador tipoTranportador;

    /**
     * Modelo do Manifesto Eletrônico: 58
     */
    @Element(name = "mod")
    public static final DFModelo MOD = DFModelo.MDFE;

    @Element(name = "serie")
    private Integer serie;

    @Element(name = "nMDF")
    private Integer numero;

    @Element(name = "cMDF")
    private String codigoNumerico;

    @Element(name = "cDV")
    private Integer digitoVerificador;

    @Element(name = "modal")
    private MDFModalidadeTransporte modalidadeFrete;

    @Element(name = "dhEmi")
    private LocalDateTime dataEmissao;

    @Element(name = "tpEmis")
    private MDFTipoEmissao tipoEmissao;

    @Element(name = "procEmi")
    private MDFProcessoEmissao processoEmissao;

    @Element(name = "verProc")
    private String versaoProcessoEmissao;

    /**
     * Sigla da UF do Carregamento.
     */
    @Element(name = "UFIni")
    private String unidadeFederativaInicio;

    /**
     * Sigla da UF do Descarregamento.
     */
    @Element(name = "UFFim")
    private String unidadeFederativaFim;

    /**
     * Municípios onde ocorreram os carregamentos
     */
    @ElementList(entry = "infMunCarrega", inline = true)
    private List<MDFInfoIdentificacaoMunicipioCarregamento> municipioCarregamentos;

    /**
     * Sigla das Unidades da Federação do percurso do veículo. Não é necessário repetir as UF de Início e Fim
     */
    @ElementList(entry = "infPercurso", inline = true, required = false)
    private List<MDFInfoIdentificacaoUfPercurso> identificacaoUfPercursos;

    /**
     * Data e hora previstos de inicio da viagem.
     */
    @Element(name = "dhIniViagem", required = false)
    private LocalDateTime dataHoraDoInicioViagem;

    /**
     * Indicador de participação do Canal Verde.
     */
    @Element(name = "indCanalVerde", required = false)
    private String indicadorCanalVerde;

    public DFUnidadeFederativa getCodigoUF() {
        return this.codigoUF;
    }

    /**
     * Código da UF do emitente do MDF-e.
     */
    public void setCodigoUF(final DFUnidadeFederativa codigoUF) {
        this.codigoUF = codigoUF;
    }

    public String getCodigoNumerico() {
        return this.codigoNumerico;
    }

    /**
     * Código numérico que compõe a Chave de Acesso.<br>
     * Número aleatório gerado pelo emitente para cada MDF-e, com o objetivo de evitar acessos indevidos ao documento.
     */
    public void setCodigoNumerico(final String codigoNumerico) {
        StringValidador.exatamente8N(codigoNumerico, "Código Numérico");
        this.codigoNumerico = codigoNumerico;
    }

    public Integer getSerie() {
        return this.serie;
    }

    /**
     * Série do Manifesto. Informar a série do documento fiscal (informar zero se inexistente).
     */
    public void setSerie(final Integer serie) {
        IntegerValidador.tamanho3(serie, "Série");
        this.serie = serie;
    }

    public Integer getNumero() {
        return this.numero;
    }

    /**
     * Número do MDF-e
     */
    public void setNumero(final Integer numero) {
        IntegerValidador.tamanho9(numero, "Número");
        this.numero = numero;
    }

    public LocalDateTime getDataEmissao() {
        return this.dataEmissao;
    }

    /**
     * Data e hora de emissão do MDF-e<br>
     * Formato AAAA-MM-DDTHH:MM:DD TZD
     */
    public void setDataEmissao(final LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public MDFTipoEmissao getTipoEmissao() {
        return this.tipoEmissao;
    }

    /**
     * Forma de emissão do MDF-e.
     */
    public void setTipoEmissao(final MDFTipoEmissao tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
    }

    public Integer getDigitoVerificador() {
        return this.digitoVerificador;
    }

    /**
     * Digito Verificador da chave de acesso do MDF-e<br>
     * Informar o dígito de controle da chave de acesso do MDF-e, que deve ser calculado com a aplicação do algoritmo módulo 11 (base 2,9) da chave de acesso.
     */
    public void setDigitoVerificador(final Integer digitoVerificador) {
        IntegerValidador.exatamente1(digitoVerificador, "Digito verificador MDF-e");
        this.digitoVerificador = digitoVerificador;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    /**
     * Tipo do Ambiente<br>
     * Preencher com:<br>
     * 1 - Produção;<br>
     * 2 - Homologação
     */
    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public MDFProcessoEmissao getProcessoEmissao() {
        return this.processoEmissao;
    }

    /**
     * Identificador do processo de emissão do MDF-e.
     */
    public void setProcessoEmissao(final MDFProcessoEmissao processoEmissao) {
        this.processoEmissao = processoEmissao;
    }

    public String getVersaoProcessoEmissao() {
        return this.versaoProcessoEmissao;
    }

    /**
     * Versão do processo de emissão<br>
     * Iinformar a versão do aplicativo emissor de MDF-e.
     */
    public void setVersaoProcessoEmissao(final String versaoProcessoEmissao) {
        StringValidador.tamanho20(versaoProcessoEmissao, "Versão Aplicativo Emissor");
        this.versaoProcessoEmissao = versaoProcessoEmissao;
    }

    public MDFModalidadeTransporte getModalidadeFrete() {
        return this.modalidadeFrete;
    }

    public void setModalidadeFrete(final MDFModalidadeTransporte modalidadeFrete) {
        this.modalidadeFrete = modalidadeFrete;
    }

    public MDFTipoEmitente getTipoEmitente() {
        return this.tipoEmitente;
    }

    public void setTipoEmitente(final MDFTipoEmitente tipoEmitente) {
        this.tipoEmitente = tipoEmitente;
    }

    public MDFTipoTranportador getTipoTranportador() {
        return this.tipoTranportador;
    }

    public void setTipoTranportador(final MDFTipoTranportador tipoTranportador) {
        this.tipoTranportador = tipoTranportador;
    }

    public String getUnidadeFederativaInicio() {
        return this.unidadeFederativaInicio;
    }

    public void setUnidadeFederativaInicio(final DFUnidadeFederativa unidadeFederativaInicio) {
        this.unidadeFederativaInicio = unidadeFederativaInicio.getCodigo();
    }

    public String getUnidadeFederativaFim() {
        return this.unidadeFederativaFim;
    }

    public void setUnidadeFederativaFim(final DFUnidadeFederativa unidadeFederativaFim) {
        this.unidadeFederativaFim = unidadeFederativaFim.getCodigo();
    }

    public List<MDFInfoIdentificacaoMunicipioCarregamento> getMunicipioCarregamentos() {
        return this.municipioCarregamentos;
    }

    public void setMunicipioCarregamentos(final List<MDFInfoIdentificacaoMunicipioCarregamento> municipioCarregamentos) {
        this.municipioCarregamentos = ListValidador.validaListaObrigatoria(municipioCarregamentos, 50, "Municípios carregamento MDF-e");
    }

    public List<MDFInfoIdentificacaoUfPercurso> getIdentificacaoUfPercursos() {
        return this.identificacaoUfPercursos;
    }

    public void setIdentificacaoUfPercursos(final List<MDFInfoIdentificacaoUfPercurso> identificacaoUfPercursos) {
        this.identificacaoUfPercursos = ListValidador.validaListaNaoObrigatoria(identificacaoUfPercursos, 25, "UF percurso MDF-e");
    }

    public LocalDateTime getDataHoraDoInicioViagem() {
        return this.dataHoraDoInicioViagem;
    }

    public void setDataHoraDoInicioViagem(final LocalDateTime dataHoraDoInicioViagem) {
        this.dataHoraDoInicioViagem = dataHoraDoInicioViagem;
    }

    public String getIndicadorCanalVerde() {
        return this.indicadorCanalVerde;
    }

    public void setIndicadorCanalVerde(final String indicadorCanalVerde) {
        final String[] enumeration = new String[] { "1" };
        if (StringUtils.isNotBlank(indicadorCanalVerde) && !StringUtils.equalsAny(indicadorCanalVerde, enumeration)) {
            throw new IllegalStateException(String.format("Indicador canal verde \"%s\" deve possuir um dos seguintes:'%s' caracteres", indicadorCanalVerde, Arrays.toString(enumeration)));
        }
        this.indicadorCanalVerde = indicadorCanalVerde;
    }
}
