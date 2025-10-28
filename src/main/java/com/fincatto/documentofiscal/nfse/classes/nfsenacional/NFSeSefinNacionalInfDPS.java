
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Root(name = "infDPS")
public class NFSeSefinNacionalInfDPS {

    @Element(name = "tpAmb")
    protected NFSeSefinNacionalInfDPSTipoAmbiente tipoAmbiente;
    @Element(name = "dhEmi")
    protected ZonedDateTime dataHoraEmissao;
    @Element(name = "verAplic")
    protected String versaoApp;
    @Element(name = "serie")
    protected String serie;
    @Element(name = "nDPS")
    protected String numeroDPS;
    @Element(name = "dCompet")
    protected LocalDate dataInicioPrestacaoServico;
    @Element(name = "tpEmit")
    protected NFSeSefinNacionalInfDPSTipoEmitente tipoEmitente;
    @Element(name = "cLocEmi")
    protected String codigoMunicipioEmissao;
    @Element(name = "subst", required = false)
    protected NFSeSefinNacionalSubstituicao substituicaoNfse;
    @Element(name = "prest")
    protected NFSeSefinNacionalInfoPrestador prestador;
    @Element(name = "toma", required = false)
    protected NFSeSefinNacionalInfoPessoa tomador;
    @Element(name = "interm", required = false)
    protected NFSeSefinNacionalInfoPessoa intermediario;
    @Element(name = "serv")
    protected NFSeSefinNacionalServ servicoPrestado;
    @Element(name = "valores")
    protected NFSeSefinNacionalInfoValores valores;
    @Attribute(name = "Id") //todo: implementar a validação da regra (método + teste unitário)
    protected String id;

    /**
     * Tipo de ambiente que está sendo transmitido a DPS
     *
     * @return tipo de ambiente
     */
    public NFSeSefinNacionalInfDPSTipoAmbiente getTipoAmbiente() {
        return tipoAmbiente;
    }

    /**
     * Define o tipo de ambiente que está sendo transmitido a DPS.
     * todo: Verificar a relação entre o ambiente definido no xml, e a url da api usada para envio (se houver)
     *
     * @param tipoAmbiente tipo de ambiente
     */
    public NFSeSefinNacionalInfDPS setTipoAmbiente(NFSeSefinNacionalInfDPSTipoAmbiente tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
        return this;
    }

    /**
     * @return data e hora com fuso da emissão do DPS
     */
    public ZonedDateTime getDataHoraEmissao() {
        return dataHoraEmissao;
    }

    /**
     * @param dataHoraEmissao data e hora da emissão do DPS
     */
    public NFSeSefinNacionalInfDPS setDataHoraEmissao(ZonedDateTime dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
        return this;
    }

    /**
     * @return Versão do aplicativo que gerou o DPS.
     */
    public String getVersaoApp() {
        return versaoApp;
    }

    /**
     * @param versaoApp Versão do aplicativo que gerou o DPS.
     */
    public NFSeSefinNacionalInfDPS setVersaoApp(String versaoApp) {
        //todo: Validar se pode ser qualquer coisa definida pelo emissor/sistema gerador
        this.versaoApp = versaoApp;
        return this;
    }

    /**
     * Número do equipamento emissor do DPS ou série do DPS
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie Número do equipamento emissor do DPS ou série do DPS
     */
    public NFSeSefinNacionalInfDPS setSerie(String serie) {
        this.serie = serie;
        return this;
    }

    /**
     * @return Número do DPS
     */
    public String getNumeroDPS() {
        return numeroDPS;
    }

    /**
     * @param numeroDPS Número do Documento de Prestação de Serviço - DPS
     */
    public NFSeSefinNacionalInfDPS setNumeroDPS(String numeroDPS) {
        this.numeroDPS = numeroDPS;
        return this;
    }

    public LocalDate getDataInicioPrestacaoServico() {
        return dataInicioPrestacaoServico;
    }

    /**
     * Data descrita como a data de inicio da prestação do serviço
     *
     * @param dataInicioPrestacaoServico Data de competência do DPS
     */
    public NFSeSefinNacionalInfDPS setDataInicioPrestacaoServico(LocalDate dataInicioPrestacaoServico) {
        this.dataInicioPrestacaoServico = dataInicioPrestacaoServico;
        return this;
    }

    /**
     * @return Tipo de emitente do DPS
     */
    public NFSeSefinNacionalInfDPSTipoEmitente getTipoEmitente() {
        return tipoEmitente;
    }

    /**
     * @param tipoEmitente Tipo de emitente do DPS
     */
    public NFSeSefinNacionalInfDPS setTipoEmitente(NFSeSefinNacionalInfDPSTipoEmitente tipoEmitente) {
        this.tipoEmitente = tipoEmitente;
        return this;
    }

    /**
     * <a href="https://www.gov.br/nfse/pt-br/biblioteca/documentacao-tecnica/documentacao-atual">Documentações e anexos</a>
     *
     * @return código do município de emissão na tabela do IBGE
     */
    public String getCodigoMunicipioEmissao() {
        return codigoMunicipioEmissao;
    }

    /**
     * <p> O código de município utilizado pelo Sistema Nacional NFS-e é o código definido para cada município pertencente ao
     * "Anexo V – Tabela de Código de Municípios do IBGE"", que consta ao final do Manual de Orientação ao Contribuinte do ISSQN para a Sefin Nacional NFS-e.</p>
     *
     * <p>O município emissor da NFS-e é aquele município em que o emitente da DPS está cadastrado e autorizado a "emitir uma NFS-e",
     * ou seja, emitir uma DPS para que o sistema nacional valide as informações nela prestadas e gere a NFS-e correspondente para o emitente. </p>
     *
     * <p>Para que o sistema nacional emita a NFS-e o município emissor deve ser conveniado e estar ativo no sistema nacional.
     * Além disso o convênio do município deve permitir que os contribuintes do município utilizem os emissores públicos do Sistema Nacional NFS-e.</p>
     *
     * <a href="https://www.gov.br/nfse/pt-br/biblioteca/documentacao-tecnica/documentacao-atual">Documentações e anexos</a>
     *
     * @param codigoMunicipioEmissao código do município de emissão na tabela do IBGE
     */
    public NFSeSefinNacionalInfDPS setCodigoMunicipioEmissao(String codigoMunicipioEmissao) {
        this.codigoMunicipioEmissao = codigoMunicipioEmissao;
        return this;
    }

    /**
     * @return dados da NFS-e a ser substituída
     */
    public NFSeSefinNacionalSubstituicao getSubstituicaoNfse() {
        return substituicaoNfse;
    }

    /**
     * @param substituicaoNfse dados da NFS-e a ser substituída
     */
    public void setSubstituicao(NFSeSefinNacionalSubstituicao substituicaoNfse) {
        this.substituicaoNfse = substituicaoNfse;
    }

    public NFSeSefinNacionalInfoPrestador getPrestador() {
        return prestador;
    }

    /**
     * @param prestador informações do prestador de serviço
     */
    public NFSeSefinNacionalInfDPS setPrestador(NFSeSefinNacionalInfoPrestador prestador) {
        this.prestador = prestador;
        return this;
    }

    /**
     * @return informações do tomador de serviço
     */
    public NFSeSefinNacionalInfoPessoa getTomador() {
        return tomador;
    }

    /**
     * @param tomador informações do tomador de serviço
     */
    public NFSeSefinNacionalInfDPS setTomador(NFSeSefinNacionalInfoPessoa tomador) {
        this.tomador = tomador;
        return this;
    }

    /**
     * @return informações do intermediário de serviço
     */
    public NFSeSefinNacionalInfoPessoa getIntermediario() {
        return intermediario;
    }

    /**
     * @param intermediario informações do intermediário de serviço
     */
    public void setIntermediario(NFSeSefinNacionalInfoPessoa intermediario) {
        this.intermediario = intermediario;
    }

    /**
     * @return informações do serviço prestado
     */
    public NFSeSefinNacionalServ getServicoPrestado() {
        return servicoPrestado;
    }

    /**
     * @param servicoPrestado informações do serviço prestado
     */
    public NFSeSefinNacionalInfDPS setServicoPrestado(NFSeSefinNacionalServ servicoPrestado) {
        this.servicoPrestado = servicoPrestado;
        return this;
    }

    /**
     * @return informações dos valores do serviço prestado
     */
    public NFSeSefinNacionalInfoValores getValores() {
        return valores;
    }

    /**
     * @param value informações dos valores do serviço prestado
     */
    public NFSeSefinNacionalInfDPS setValores(NFSeSefinNacionalInfoValores value) {
        this.valores = value;
        return this;
    }

    /**
     * @return ID da DPS no formato:
     * "DPS" + Cód.Mun (7) + Tipo de Inscrição Federal (1) + Inscrição Federal (14 - CPF completar com 000 à esquerda) + Série DPS (5)+ Núm. DPS (15)
     */
    public String getId() {
        return id;
    }

    /**
     * Define o ID da DPS no formato:
     * "DPS" + Cód.Mun (7) + Tipo de Inscrição Federal (1) + Inscrição Federal (14 - CPF completar com 000 à esquerda) + Série DPS (5)+ Núm. DPS (15)
     *
     * @param id ID da DPS
     */
    public NFSeSefinNacionalInfDPS setId(String id) {
        this.id = id;
        return this;
    }

}
