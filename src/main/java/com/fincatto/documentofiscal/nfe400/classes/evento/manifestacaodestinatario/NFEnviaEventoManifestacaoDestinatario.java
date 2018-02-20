package com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario;

import java.math.BigDecimal;
import java.util.List;

import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

@Root(name = "envEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEnviaEventoManifestacaoDestinatario extends DFBase {
    private static final long serialVersionUID = 8496530539655487485L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "idLote", required = true)
    private String idLote;

    @ElementList(entry = "evento", inline = true, required = true)
    private List<NFEventoManifestacaoDestinatario> evento;

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public String getVersao() {
        return this.versao;
    }

    public String getIdLote() {
        return this.idLote;
    }

    public void setIdLote(final String idLote) {
        StringValidador.tamanho15N(idLote, "ID do Lote");
        this.idLote = idLote;
    }

    public List<NFEventoManifestacaoDestinatario> getEvento() {
        return this.evento;
    }

    public void setEvento(final List<NFEventoManifestacaoDestinatario> evento) {
        ListValidador.tamanho20(evento, "Evento de Manifesta\u00e7\u00e3o do Destinat\u00e1rio");
        this.evento = evento;
    }
}