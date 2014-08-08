package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.ListValidador;
import com.fincatto.nfe.validadores.StringValidador;

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
    private NFNotaInfoLocal retirada;

    @Element(name = "entrega", required = false)
    private NFNotaInfoLocal entrega;

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

    public void setIdentificador(final String identificador) {
        StringValidador.exatamente44N(identificador);
        this.identificador = MessageFormat.format("NFe{0}", identificador);
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho4Com2CasasDecimais(versao);
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

    public void setDestinatario(final NFNotaInfoDestinatario destinatario) {
        this.destinatario = destinatario;
    }

    public void setItens(final List<NFNotaInfoItem> itens) {
        ListValidador.tamanho990(itens);
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

    public void setSignature(final String signature) {
        this.signature = signature;
    }
}