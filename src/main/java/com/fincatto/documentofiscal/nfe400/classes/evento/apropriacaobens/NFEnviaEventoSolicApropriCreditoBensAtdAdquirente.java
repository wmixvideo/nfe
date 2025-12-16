package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaobens;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

@Root(name = "envEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEnviaEventoSolicApropriCreditoBensAtdAdquirente extends DFBase {
    private static final long serialVersionUID = 2370103749912669480L;
    
    @Attribute(name = "versao")
    private String versao;
    
    @Element(name = "idLote")
    private String idLote;
    
    @ElementList(entry = "evento", inline = true)
    private List<NFEventoSolicApropriCreditoBensAtdAdquirente> evento;

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public String getVersao() {
        return this.versao;
    }

    public String getIdLote() {
        return this.idLote;
    }

    public void setIdLote(final String idLote) {
        DFStringValidador.tamanho15N(idLote, "ID do Lote");
        this.idLote = idLote;
    }

    public List<NFEventoSolicApropriCreditoBensAtdAdquirente> getEvento() {
        return this.evento;
    }

    public void setEvento(final List<NFEventoSolicApropriCreditoBensAtdAdquirente> evento) {
        DFListValidador.tamanho20(evento, "Evento de Informação Efetivo Pagamento Integral para liberar crédito presumido do adquirente");
        this.evento = evento;
    }
}