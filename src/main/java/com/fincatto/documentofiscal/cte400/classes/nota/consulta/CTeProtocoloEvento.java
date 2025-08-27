package com.fincatto.documentofiscal.cte400.classes.nota.consulta;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Root(name = "procEventoCTe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeProtocoloEvento extends DFBase {
    private static final long serialVersionUID = -5921322695285609605L;
    
    @Attribute(name = "versao")
    private String versao;

    @Attribute(name = "ipTransmissor", required = false)
    private String ipTransmissor;

    @Attribute(name = "nPortaCon", required = false)
    private String portaConexao;

    @Attribute(name = "dhConexao", required = false)
    private ZonedDateTime dataHoraConexao;
    
    @Element(name = "eventoCTe")
    private CTeEvento evento;

    @Element(name = "retEventoCTe", required = false)
    private CTeEventoRetorno eventoRetorno;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho4Com2CasasDecimais(versao, "Versao");
    }

    public String getIpTransmissor() {
        return ipTransmissor;
    }

    public void setIpTransmissor(String ipTransmissor) {
        this.ipTransmissor = ipTransmissor;
    }

    public String getPortaConexao() {
        return portaConexao;
    }

    public void setPortaConexao(String portaConexao) {
        this.portaConexao = portaConexao;
    }

    public ZonedDateTime getDataHoraConexao() {
        return dataHoraConexao;
    }

    public void setDataHoraConexao(ZonedDateTime dataHoraConexao) {
        this.dataHoraConexao = dataHoraConexao;
    }

    public CTeEvento getEvento() {
        return this.evento;
    }

    public void setEvento(final CTeEvento evento) {
        this.evento = evento;
    }

    public void setEventoRetorno(final CTeEventoRetorno infoEventoRetorno) {
        this.eventoRetorno = infoEventoRetorno;
    }

    public CTeEventoRetorno getEventoRetorno() {
        return this.eventoRetorno;
    }
}
