package com.fincatto.nfe.classes.nota;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.classes.NFBase;

@Root(name = "infNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaInfo extends NFBase {

    @Attribute(name = "Id", required = true)
    private String identificador;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "ide", required = true)
    private NFNotaInfoIdentificacao identificacao;

    @Element(name = "emit", required = true)
    private NFNotaInfoEmitente emitente;

    @Element(name = "avulsa", required = false)
    private NFNotaInfoAvulsa avulsa;

    @Element(name = "dest", required = true)
    private NFNotaInfoDestinatario destinatario;

    @ElementList(entry = "det", inline = true, required = true)
    private List<NFNotaInfoItem> itens;

    @Element(name = "retirada", required = false)
    private NFNotaInfoRetirada retirada;

    @Element(name = "entrega", required = false)
    private NFNotaInfoEntrega entrega;

    @Element(name = "cobr", required = false)
    private NFNotaInfoCobranca cobranca;

    @Element(name = "total", required = true)
    private NFNotaInfoTotal total;

    @Element(name = "transp", required = true)
    private NFNotaInfoTransporte transporte;

    @Element(name = "infAdic", required = false)
    private NFNotaInfoInformacoesAdicionais informacoesAdicionais;

    @Element(name = "exporta", required = false)
    private NFNotaInfoExportacao exportacao;

    @Element(name = "compra", required = false)
    private NFNotaInfoCompra compra;

    @Element(name = "cana", required = false)
    private NFNotaInfoCana cana;

    @Element(name = "Signature", required = true)
    private String signature;

    public NFNotaInfo() {
        this.identificador = null;
        this.versao = null;
        this.identificacao = null;
        this.setItens(null);
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(final String identificador) {
        this.identificador = identificador;
    }

    public String getVersao() {
        return this.versao;
    }

    public NFNotaInfoEmitente getEmitente() {
        return this.emitente;
    }

    public void setEmitente(final NFNotaInfoEmitente emitente) {
        this.emitente = emitente;
    }

    public NFNotaInfoDestinatario getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(final NFNotaInfoDestinatario destinatario) {
        this.destinatario = destinatario;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public NFNotaInfoIdentificacao getIdentificacao() {
        return this.identificacao;
    }

    public void setIdentificacao(final NFNotaInfoIdentificacao identificacao) {
        this.identificacao = identificacao;
    }

    public List<NFNotaInfoItem> getItens() {
        return this.itens;
    }

    public void setItens(final List<NFNotaInfoItem> itens) {
        this.itens = itens;
    }

    public NFNotaInfoAvulsa getAvulsa() {
        return this.avulsa;
    }

    public void setAvulsa(final NFNotaInfoAvulsa avulsa) {
        this.avulsa = avulsa;
    }

    public NFNotaInfoRetirada getRetirada() {
        return this.retirada;
    }

    public void setRetirada(final NFNotaInfoRetirada retirada) {
        this.retirada = retirada;
    }

    public NFNotaInfoEntrega getEntrega() {
        return this.entrega;
    }

    public void setEntrega(final NFNotaInfoEntrega entrega) {
        this.entrega = entrega;
    }

    public NFNotaInfoTotal getTotal() {
        return this.total;
    }

    public void setTotal(final NFNotaInfoTotal total) {
        this.total = total;
    }

    public NFNotaInfoTransporte getTransporte() {
        return this.transporte;
    }

    public void setTransporte(final NFNotaInfoTransporte transporte) {
        this.transporte = transporte;
    }

    public NFNotaInfoInformacoesAdicionais getInformacoesAdicionais() {
        return this.informacoesAdicionais;
    }

    public void setInformacoesAdicionais(final NFNotaInfoInformacoesAdicionais informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public NFNotaInfoExportacao getExportacao() {
        return this.exportacao;
    }

    public void setExportacao(final NFNotaInfoExportacao exportacao) {
        this.exportacao = exportacao;
    }

    public NFNotaInfoCompra getCompra() {
        return this.compra;
    }

    public void setCompra(final NFNotaInfoCompra compra) {
        this.compra = compra;
    }

    public NFNotaInfoCana getCana() {
        return this.cana;
    }

    public void setCana(final NFNotaInfoCana cana) {
        this.cana = cana;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(final String signature) {
        this.signature = signature;
    }

    public NFNotaInfoCobranca getCobranca() {
        return this.cobranca;
    }

    public void setCobranca(final NFNotaInfoCobranca cobranca) {
        this.cobranca = cobranca;
    }
}