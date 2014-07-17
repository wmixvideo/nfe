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

    @Element(name = "dest", required = true)
    private NFNotaInfoDestinatario destinatario;

    @ElementList(entry = "det", inline = true, required = true)
    private List<NFNotaInfoItem> itens;

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
}