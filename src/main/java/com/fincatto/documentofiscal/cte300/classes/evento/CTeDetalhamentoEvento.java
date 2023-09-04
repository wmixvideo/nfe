package com.fincatto.documentofiscal.cte300.classes.evento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.evento.cancelamento.CTeEnviaEventoCancelamento;
import com.fincatto.documentofiscal.cte300.classes.evento.cartacorrecao.CTeEnviaEventoCartaCorrecao;
import com.fincatto.documentofiscal.cte300.classes.evento.comprovanteentrega.CTeEnviaEventoCancelamentoComprovanteEntrega;
import com.fincatto.documentofiscal.cte300.classes.evento.comprovanteentrega.CTeEnviaEventoComprovanteEntrega;
import com.fincatto.documentofiscal.cte300.classes.evento.desacordo.CTeEnviaEventoPrestacaoEmDesacordo;
import com.fincatto.documentofiscal.cte300.classes.evento.epec.CTeEnviaEventoEpec;
import com.fincatto.documentofiscal.cte300.classes.evento.gtv.CTeEnviaEventoGtv;
import com.fincatto.documentofiscal.cte300.classes.evento.multimodal.CTeEnviaEventoRegistroMultimodal;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(strict = false)
public class CTeDetalhamentoEvento extends DFBase {
    private static final long serialVersionUID = 7006866358832001912L;

    @Attribute(name = "versaoEvento")
    private String versaoEvento;

    @ElementUnion({
            @Element(name = "evCancCECTe", type = CTeEnviaEventoCancelamentoComprovanteEntrega.class, required = false),
            @Element(name = "evCancCTe", type = CTeEnviaEventoCancelamento.class, required = false),
            @Element(name = "evCCeCTe", type = CTeEnviaEventoCartaCorrecao.class, required = false),
            @Element(name = "evCECTe", type = CTeEnviaEventoComprovanteEntrega.class, required = false),
            @Element(name = "evEPECCTe", type = CTeEnviaEventoEpec.class, required = false),
            @Element(name = "evPrestDesacordo", type = CTeEnviaEventoPrestacaoEmDesacordo.class, required = false),
            @Element(name = "evGTV", type = CTeEnviaEventoGtv.class, required = false),
            @Element(name = "evRegMultimodal", type = CTeEnviaEventoRegistroMultimodal.class, required = false),
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

    public CTeEnviaEventoCancelamentoComprovanteEntrega getCancelamentoComprovanteEntrega() {
        if (this.evento instanceof CTeEnviaEventoCancelamentoComprovanteEntrega) {
            return (CTeEnviaEventoCancelamentoComprovanteEntrega) this.evento;
        }
        throw new IllegalStateException("Evento não é cancelamento de comprovante de entrega");
    }

    public CTeEnviaEventoCancelamento getCancelamento() {
        if (this.evento instanceof CTeEnviaEventoCancelamento) {
            return (CTeEnviaEventoCancelamento) this.evento;
        }
        throw new IllegalStateException("Evento não é cancelamento");
    }

    public CTeEnviaEventoCartaCorrecao getCartaCorrecao() {
        if (this.evento instanceof CTeEnviaEventoCartaCorrecao) {
            return (CTeEnviaEventoCartaCorrecao) this.evento;
        }
        throw new IllegalStateException("Evento não é carta de correção");
    }

    public CTeEnviaEventoComprovanteEntrega getComprovanteEntrega() {
        if (this.evento instanceof CTeEnviaEventoComprovanteEntrega) {
            return (CTeEnviaEventoComprovanteEntrega) this.evento;
        }
        throw new IllegalStateException("Evento não é comprovante de entrega");
    }

    public CTeEnviaEventoPrestacaoEmDesacordo getPrestacaoEmDesacordo() {
        if (this.evento instanceof CTeEnviaEventoPrestacaoEmDesacordo) {
            return (CTeEnviaEventoPrestacaoEmDesacordo) this.evento;
        }
        throw new IllegalStateException("Evento não é prestação de serviço em desacordo");
    }

    public CTeEnviaEventoGtv getGtv() {
        if (this.evento instanceof CTeEnviaEventoGtv) {
            return (CTeEnviaEventoGtv) this.evento;
        }
        throw new IllegalStateException("Evento não é GTV");
    }

    public CTeEnviaEventoRegistroMultimodal getRegistroMultimodal() {
        if (this.evento instanceof CTeEnviaEventoRegistroMultimodal) {
            return (CTeEnviaEventoRegistroMultimodal) this.evento;
        }
        throw new IllegalStateException("Evento não é registro multimodal");
    }
}