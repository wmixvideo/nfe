
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações relativas à exportação/importação de serviço prestado
 */

@Root(name = "ComExterior")
public class NFSeSefinNacionalComercioExterior {

    @Element(name = "mdPrestacao")
    protected NFSeSefinNacionalComercioExteriorModoPrestacao modoPrestacao;
    @Element(name = "vincPrest")
    protected NFSeSefinNacionalComercioExteriorVinculoEntrePartes vinculoEntrePartes;
    @Element(name = "tpMoeda")
    protected String moeda;
    @Element(name = "vServMoeda")
    protected String valorServicoMoedaEstrangeira;
    @Element(name = "mecAFComexP")
    protected NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador mecanismoApoioComercioExteriorPrestador;
    @Element(name = "mecAFComexT")
    protected NFSeSefinNacionalComercioExteriorMecanismoApoioTomador mecanismoApoioComercioExteriorTomador;
    @Element(name = "movTempBens")
    protected NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens movimentacaoTemporariaBens;
    @Element(name = "nDI", required = false)
    protected String ndi;
    @Element(name = "nRE", required = false)
    protected String nre;
    @Element(name = "mdic")
    protected NFSeSefinNacionalComercioExteriorCompartilharComMDIC compartilharComMDIC;

    /**
     * @return Modo de prestação do serviço
     */
    public NFSeSefinNacionalComercioExteriorModoPrestacao getModoPrestacao() {
        return modoPrestacao;
    }

    /**
     * Define o modo de prestação do serviço
     *
     * @param modoPrestacao Modo de prestação do serviço
     */
    public void setModoPrestacao(NFSeSefinNacionalComercioExteriorModoPrestacao modoPrestacao) {
        this.modoPrestacao = modoPrestacao;
    }

    /**
     * @return Vínculo entre as partes no negócio
     */
    public NFSeSefinNacionalComercioExteriorVinculoEntrePartes getVinculoEntrePartes() {
        return vinculoEntrePartes;
    }

    /**
     * Define o vínculo entre as partes no negócio
     *
     * @param vinculoEntrePartes Vínculo entre as partes
     */
    public void setVinculoEntrePartes(NFSeSefinNacionalComercioExteriorVinculoEntrePartes vinculoEntrePartes) {
        this.vinculoEntrePartes = vinculoEntrePartes;
    }

    /**
     * @return Moeda utilizada na transação
     */
    public String getMoeda() {
        return moeda;
    }

    /**
     * Define a moeda da transação comercial
     *
     * @param moeda Moeda
     */
    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    /**
     * @return Valor do serviço na moeda estrangeira
     */
    public String getVServMoeda() {
        return valorServicoMoedaEstrangeira;
    }

    /**
     * Define o valor do serviço na moeda estrangeira
     *
     * @param value Valor do serviço na moeda estrangeira
     */
    public void setVServMoeda(String value) {
        this.valorServicoMoedaEstrangeira = value;
    }

    /**
     * @return Mecanismo de apoio ao comércio exterior do utilizado pelo prestador
     */
    public NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador getMecanismoApoioComercioExteriorPrestador() {
        return mecanismoApoioComercioExteriorPrestador;
    }

    /**
     * @param mecanismoApoioComercioExteriorPrestador Define o mecanismo de apoio ao comércio exterior utilizado pelo prestador
     */
    public void setMecanismoApoioComercioExteriorPrestador(NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador mecanismoApoioComercioExteriorPrestador) {
        this.mecanismoApoioComercioExteriorPrestador = mecanismoApoioComercioExteriorPrestador;
    }

    /**
     * @return Mecanismo de apoio ao comércio exterior do utilizado pelo tomador
     */
    public NFSeSefinNacionalComercioExteriorMecanismoApoioTomador getMecanismoApoioComercioExteriorTomador() {
        return mecanismoApoioComercioExteriorTomador;
    }

    /**
     * @param mecanismoApoioComercioExteriorTomador Define o mecanismo de apoio ao comércio exterior utilizado pelo tomador
     */
    public void setMecanismoApoioComercioExteriorTomador(NFSeSefinNacionalComercioExteriorMecanismoApoioTomador mecanismoApoioComercioExteriorTomador) {
        this.mecanismoApoioComercioExteriorTomador = mecanismoApoioComercioExteriorTomador;
    }

    /**
     * @return Indica se operação está vinculada a movimentação temporária de bens
     */
    public NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens getMovimentacaoTemporariaBens() {
        return movimentacaoTemporariaBens;
    }

    /**
     * @param movimentacaoTemporariaBens Define se operação está vinculada a movimentação temporária de bens
     */
    public void setMovimentacaoTemporariaBens(NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens movimentacaoTemporariaBens) {
        this.movimentacaoTemporariaBens = movimentacaoTemporariaBens;
    }

    /**
     * @return Número da Declaração de Importação (DI/DSI/DA/DRI-E) averbado
     */
    public String getNDI() {
        return ndi;
    }

    /**
     * Define o número da Declaração de Importação (DI/DSI/DA/DRI-E) averbado
     * @param ndi Número da declaração de importação averbado
     */
    public void setNDI(String ndi) {
        this.ndi = ndi;
    }

    /**
     * @return Número do Registro de Exportação (RE) averbado
     */
    public String getNRE() {
        return nre;
    }

    /**
     * Define o número do Registro de Exportação (RE) averbado
     * @param nre Número do registro de exportação averbado
     */
    public void setNRE(String nre) {
        this.nre = nre;
    }

    /**
     * @return Compartilhamento de informações com o MDIC
     */
    public NFSeSefinNacionalComercioExteriorCompartilharComMDIC getCompartilharComMDIC() {
        return compartilharComMDIC;
    }

    /**
     * Define o compartilhamento de informações com o MDIC
     *
     * @param compartilharComMDIC Compartilhamento de informações com o MDIC
     */
    public void setCompartilharComMDIC(NFSeSefinNacionalComercioExteriorCompartilharComMDIC compartilharComMDIC) {
        this.compartilharComMDIC = compartilharComMDIC;
    }

}
