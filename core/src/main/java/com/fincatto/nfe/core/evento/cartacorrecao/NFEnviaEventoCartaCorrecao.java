package com.fincatto.nfe.core.evento.cartacorrecao;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.evento.NFEvento;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import com.fincatto.nfe.core.validadores.ListValidador;
import com.fincatto.nfe.core.validadores.StringValidador;
import org.simpleframework.xml.*;

import java.math.BigDecimal;
import java.util.List;

@Root(name = "envEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEnviaEventoCartaCorrecao extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "idLote", required = true)
    private String idLote;

    @ElementList(entry = "evento", inline = true, required = true)
    private List<NFEvento> evento;

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

    public List<NFEvento> getEvento() {
        return this.evento;
    }

    public void setEvento(final List<NFEvento> evento) {
        ListValidador.tamanho20(evento, "Eventos");
        this.evento = evento;
    }
}