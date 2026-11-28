package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;
import java.util.List;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "envEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEnviaEventoEconf extends DFBase {
    private static final long serialVersionUID = 8260175394418273602L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "idLote")
    private String idLote;

    @ElementList(entry = "evento", inline = true)
    private List<NFEventoEconf> evento;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public String getIdLote() {
        return this.idLote;
    }

    public void setIdLote(final String idLote) {
        DFStringValidador.tamanho15N(idLote, "ID do Lote");
        this.idLote = idLote;
    }

    public List<NFEventoEconf> getEvento() {
        return this.evento;
    }

    public void setEvento(final List<NFEventoEconf> evento) {
        DFListValidador.tamanho20(evento, "Evento de Conciliacao Financeira (ECONF)");
        this.evento = evento;
    }
}
