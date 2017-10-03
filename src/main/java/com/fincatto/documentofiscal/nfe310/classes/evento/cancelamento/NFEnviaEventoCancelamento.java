package com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento;

import java.math.BigDecimal;
import java.util.List;

import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

@Root(name = "envEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEnviaEventoCancelamento extends DFBase {
    private static final long serialVersionUID = 2370103749912669480L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "idLote", required = true)
    private String idLote;

    @ElementList(entry = "evento", inline = true, required = true)
    private List<NFEventoCancelamento> evento;

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

    public List<NFEventoCancelamento> getEvento() {
        return this.evento;
    }

    public void setEvento(final List<NFEventoCancelamento> evento) {
        ListValidador.tamanho20(evento, "Evento de Cancelamento");
        this.evento = evento;
    }
}