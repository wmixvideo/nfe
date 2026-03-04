package com.fincatto.documentofiscal.nfe400.classes.evento.atualizacaodataprevisaoentrega;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.*;

import java.math.BigDecimal;
import java.util.List;

@Root(name = "envEvento")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFEnviaEventoAtualizacaoDataPrevisaoEntrega extends DFBase {

	private static final long serialVersionUID = 7960049528279343741L;

	@Attribute(name = "versao")
    private String versao;

    @Element(name = "idLote")
    private String idLote;

    @ElementList(entry = "evento", inline = true)
    private List<NFEventoAtualizacaoDataPrevisaoEntrega> evento;

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

    public List<NFEventoAtualizacaoDataPrevisaoEntrega> getEvento() {
        return this.evento;
    }

    public void setEvento(final List<NFEventoAtualizacaoDataPrevisaoEntrega> evento) {
        DFListValidador.tamanho20(evento, "Evento de Atualização da Data de Previsão de Entrega");
        this.evento = evento;
    }

}

