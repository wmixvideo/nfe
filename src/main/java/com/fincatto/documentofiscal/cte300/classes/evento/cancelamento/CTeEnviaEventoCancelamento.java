package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

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

@Root(name = "envEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeEnviaEventoCancelamento extends DFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "idLote", required = true)
    private String idLote;

    @ElementList(entry = "evento", inline = true, required = true)
    private List<CTeEventoCancelamento> evento;

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

    public List<CTeEventoCancelamento> getEvento() {
        return this.evento;
    }

    public void setEvento(final List<CTeEventoCancelamento> evento) {
        ListValidador.tamanho20(evento, "Evento de Cancelamento");
        this.evento = evento;
    }

}