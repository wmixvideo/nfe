package com.fincatto.documentofiscal.cte300.classes.evento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.evento.cancelamento.CTeEnviaEventoCancelamento;
import com.fincatto.documentofiscal.cte300.classes.evento.cartacorrecao.CTeEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.cte300.classes.evento.comprovanteentrega.CTeEnviaEventoCancelamentoComprovanteEntrega;
import com.fincatto.documentofiscal.cte300.classes.evento.comprovanteentrega.CTeEnviaEventoComprovanteEntrega;
import com.fincatto.documentofiscal.cte300.classes.evento.desacordo.CTeEnviaEventoPrestacaoEmDesacordo;
import com.fincatto.documentofiscal.cte300.classes.evento.multimodal.CTeEnviaEventoRegistroMultimodal;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;

import java.math.BigDecimal;

public class CTeDetalhamentoEvento extends DFBase {
    private static final long serialVersionUID = 7006866358832001912L;

    @Attribute(name = "versaoEvento")
    private String versaoEvento;

    @ElementUnion({
            @Element(name = "evCancCECTe", type = CTeEnviaEventoCancelamentoComprovanteEntrega.class),
            @Element(name = "evCancCTe", type = CTeEnviaEventoCancelamento.class),
            @Element(name = "evCCeCTe", type = CTeEnviaEventoCartaCorrecao.class),
            @Element(name = "evCECTe", type = CTeEnviaEventoComprovanteEntrega.class),
            @Element(name = "evPrestDesacordo", type = CTeEnviaEventoPrestacaoEmDesacordo.class),
            @Element(name = "evRegMultimodal", type = CTeEnviaEventoRegistroMultimodal.class),
    })
    private CTeTipoEvento evento;

    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
    }

    public String getVersaoEvento() {
        return this.versaoEvento;
    }

    public CTeTipoEvento getEvento() {
        return this.evento;
    }

    public void setEvento(final CTeTipoEvento evento) {
        this.evento = evento;
    }
}