package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFModelo;

@Root(name = "infNF")
public class CTInfoDocumentoNF extends DFBase {
    private static final long serialVersionUID = 3748244301704556471L;

    @Element(name = "nRoma", required = false)
    private String numeroRomaneio;

    @Element(name = "nPed", required = false)
    private String numeroPedido;

    @Element(name = "mod")
    private DFModelo modelo;

    @Element(name = "serie")
    private String serie;

    @Element(name = "nDoc")
    private String numero;

    @Element(name = "dEmi")
    private LocalDate dataEmissao;

    @Element(name = "vBC")
    private String valorBaseCalculoICMS;

    @Element(name = "vICMS")
    private String valorICMS;

    @Element(name = "vBCST")
    private String valorBaseCalculoST;

    @Element(name = "vST")
    private String valorIcmsST;

    @Element(name = "vProd")
    private String valorProdutos;

    @Element(name = "vNF")
    private String valorNotaFiscal;

    @Element(name = "nCFOP")
    private String cfopPredominante;

    @Element(name = "nPeso", required = false)
    private String nPeso;

    @Element(name = "PIN", required = false)
    private String pin;

    @Element(name = "dPrev", required = false)
    private String dPrev;

    @ElementList(name = "infUnidTransp", inline = true, required = false)
    private List<CTInfoDocumentoNFUnidTransp> unidadesTransporte;

    @ElementList(name = "infUnidCarga", inline = true, required = false)
    private List<CTInfoDocumentoNFUnidadeCarga> unidadesCarga;

    public void setModelo(final DFModelo modelo) {
        if (!DFModelo.MODELOS_NOTAS_NAO_ELETRONICAS.contains(modelo)) {
            throw new IllegalArgumentException("Modelo de nota fiscal n\u00e3o confere com o tipo do registro infNF");
        }
        this.modelo = modelo;
    }

    public String getNumeroRomaneio() {
        return this.numeroRomaneio;
    }

    public void setNumeroRomaneio(final String numeroRomaneio) {
        this.numeroRomaneio = numeroRomaneio;
    }

    public String getNumeroPedido() {
        return this.numeroPedido;
    }

    public void setNumeroPedido(final String numeroPedido) {
        this.numeroPedido = numeroPedido;
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

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getValorBaseCalculoICMS() {
        return this.valorBaseCalculoICMS;
    }

    public void setValorBaseCalculoICMS(final String valorBaseCalculoICMS) {
        this.valorBaseCalculoICMS = valorBaseCalculoICMS;
    }

    public String getValorICMS() {
        return this.valorICMS;
    }

    public void setValorICMS(final String valorICMS) {
        this.valorICMS = valorICMS;
    }

    public String getValorBaseCalculoST() {
        return this.valorBaseCalculoST;
    }

    public void setValorBaseCalculoST(final String valorBaseCalculoST) {
        this.valorBaseCalculoST = valorBaseCalculoST;
    }

    public String getValorIcmsST() {
        return this.valorIcmsST;
    }

    public void setValorIcmsST(final String valorIcmsST) {
        this.valorIcmsST = valorIcmsST;
    }

    public String getValorProdutos() {
        return this.valorProdutos;
    }

    public void setValorProdutos(final String valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public String getValorNotaFiscal() {
        return this.valorNotaFiscal;
    }

    public void setValorNotaFiscal(final String valorNotaFiscal) {
        this.valorNotaFiscal = valorNotaFiscal;
    }

    public String getCfopPredominante() {
        return this.cfopPredominante;
    }

    public void setCfopPredominante(final String cfopPredominante) {
        this.cfopPredominante = cfopPredominante;
    }

    public String getnPeso() {
        return this.nPeso;
    }

    public void setnPeso(final String nPeso) {
        this.nPeso = nPeso;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(final String pin) {
        this.pin = pin;
    }

    public String getdPrev() {
        return this.dPrev;
    }

    public void setdPrev(final String dPrev) {
        this.dPrev = dPrev;
    }

    public List<CTInfoDocumentoNFUnidTransp> getUnidadesTransporte() {
        return this.unidadesTransporte;
    }

    public void setUnidadesTransporte(final List<CTInfoDocumentoNFUnidTransp> unidadesTransporte) {
        this.unidadesTransporte = unidadesTransporte;
    }

    public List<CTInfoDocumentoNFUnidadeCarga> getUnidadesCarga() {
        return this.unidadesCarga;
    }

    public void setUnidadesCarga(final List<CTInfoDocumentoNFUnidadeCarga> unidadesCarga) {
        this.unidadesCarga = unidadesCarga;
    }

    public DFModelo getModelo() {
        return this.modelo;
    }

}
