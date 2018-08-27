package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

@Root(name = "infNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaInfo extends DFBase {
    private static final long serialVersionUID = 4569152242139670228L;

    public static final String IDENT = "NFe";

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

    @Element(name = "dest", required = false)
    private NFNotaInfoDestinatario destinatario;

    @Element(name = "retirada", required = false)
    private NFNotaInfoLocal retirada;

    @Element(name = "entrega", required = false)
    private NFNotaInfoLocal entrega;

    @ElementList(entry = "autXML", inline = true, required = false)
    private List<NFPessoaAutorizadaDownloadNFe> pessoasAutorizadasDownloadNFe;

    @ElementList(entry = "det", inline = true, required = true)
    private List<NFNotaInfoItem> itens;

    @Element(name = "total", required = true)
    private NFNotaInfoTotal total;

    @Element(name = "transp", required = true)
    private NFNotaInfoTransporte transporte;

    @Element(name = "cobr", required = false)
    private NFNotaInfoCobranca cobranca;

    @ElementList(entry = "pag", inline = true)
    private List<NFNotaInfoPagamento> pagamentos;

    @Element(name = "infAdic", required = false)
    private NFNotaInfoInformacoesAdicionais informacoesAdicionais;

    @Element(name = "exporta", required = false)
    private NFNotaInfoExportacao exportacao;

    @Element(name = "compra", required = false)
    private NFNotaInfoCompra compra;

    @Element(name = "cana", required = false)
    private NFNotaInfoCana cana;

    /**
     * Pega a chave de acesso a partir do identificador.
     * @return Chave de acesso.
     */
    public String getChaveAcesso() {
        return this.identificador.replace(NFNotaInfo.IDENT, "");
    }

    public void setIdentificador(final String identificador) {
        StringValidador.exatamente44N(identificador, "Identificador");
        this.identificador = NFNotaInfo.IDENT + identificador;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho4Com2CasasDecimais(versao, "Versao");
    }

    public NFNotaInfoIdentificacao getIdentificacao() {
        return this.identificacao;
    }

    public void setIdentificacao(final NFNotaInfoIdentificacao identificacao) {
        this.identificacao = identificacao;
    }

    public void setEmitente(final NFNotaInfoEmitente emitente) {
        this.emitente = emitente;
    }

    public void setAvulsa(final NFNotaInfoAvulsa avulsa) {
        this.avulsa = avulsa;
    }

    public NFNotaInfoDestinatario getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(final NFNotaInfoDestinatario destinatario) {
        this.destinatario = destinatario;
    }

    public void setItens(final List<NFNotaInfoItem> itens) {
        ListValidador.tamanho990(itens, "Itens da Nota");
        this.itens = itens;
    }

    public void setRetirada(final NFNotaInfoLocal retirada) {
        this.retirada = retirada;
    }

    public void setEntrega(final NFNotaInfoLocal entrega) {
        this.entrega = entrega;
    }

    public void setCobranca(final NFNotaInfoCobranca cobranca) {
        this.cobranca = cobranca;
    }

    public void setTotal(final NFNotaInfoTotal total) {
        this.total = total;
    }

    public void setTransporte(final NFNotaInfoTransporte transporte) {
        this.transporte = transporte;
    }

    public void setInformacoesAdicionais(final NFNotaInfoInformacoesAdicionais informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public void setExportacao(final NFNotaInfoExportacao exportacao) {
        this.exportacao = exportacao;
    }

    public void setCompra(final NFNotaInfoCompra compra) {
        this.compra = compra;
    }

    public void setCana(final NFNotaInfoCana cana) {
        this.cana = cana;
    }

    public void setPessoasAutorizadasDownloadNFe(final List<NFPessoaAutorizadaDownloadNFe> pessoasAutorizadasDownloadNFe) {
        ListValidador.tamanho10(pessoasAutorizadasDownloadNFe, "Pessoas Autorizadas Download NFe");
        this.pessoasAutorizadasDownloadNFe = pessoasAutorizadasDownloadNFe;
    }

    public void setPagamentos(final List<NFNotaInfoPagamento> pagamentos) {
        ListValidador.tamanho100(pagamentos, "Pagamentos");
        this.pagamentos = pagamentos;
    }

    public String getVersao() {
        return this.versao;
    }

    public NFNotaInfoEmitente getEmitente() {
        return this.emitente;
    }

    public NFNotaInfoAvulsa getAvulsa() {
        return this.avulsa;
    }

    public NFNotaInfoLocal getRetirada() {
        return this.retirada;
    }

    public NFNotaInfoLocal getEntrega() {
        return this.entrega;
    }

    public List<NFPessoaAutorizadaDownloadNFe> getPessoasAutorizadasDownloadNFe() {
        return this.pessoasAutorizadasDownloadNFe;
    }

    public List<NFNotaInfoItem> getItens() {
        return this.itens;
    }

    public NFNotaInfoTotal getTotal() {
        return this.total;
    }

    public NFNotaInfoTransporte getTransporte() {
        return this.transporte;
    }

    public NFNotaInfoCobranca getCobranca() {
        return this.cobranca;
    }

    public List<NFNotaInfoPagamento> getPagamentos() {
        return this.pagamentos;
    }

    public NFNotaInfoInformacoesAdicionais getInformacoesAdicionais() {
        return this.informacoesAdicionais;
    }

    public NFNotaInfoExportacao getExportacao() {
        return this.exportacao;
    }

    public NFNotaInfoCompra getCompra() {
        return this.compra;
    }

    public NFNotaInfoCana getCana() {
        return this.cana;
    }
}