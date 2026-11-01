package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoRetorno;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.ZonedDateTime;

@Root(name = "procEventoNFe", strict = false)
@Namespace(reference = NFeConfig.NAMESPACE)
public class NFCeDownloadXMLRetornoProcEventoNFe extends DFBase {
    private static final long serialVersionUID = 8045407122247843645L;

    @Attribute(name = "versao", required = false)
    private String versao;

    @Element(name = "dhInc")
    private ZonedDateTime dataHoraInclusao;

    @Element(name = "nProt")
    private String numeroProtocolo;

    @Element(name = "evento", required = false)
    private NFEvento evento;

    @Element(name = "retEvento", required = false)
    private NFEventoRetorno eventoRetorno;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public ZonedDateTime getDataHoraInclusao() {
        return this.dataHoraInclusao;
    }

    public void setDataHoraInclusao(final ZonedDateTime dataHoraInclusao) {
        this.dataHoraInclusao = dataHoraInclusao;
    }

    public String getNumeroProtocolo() {
        return this.numeroProtocolo;
    }

    public void setNumeroProtocolo(final String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public NFEvento getEvento() {
        return this.evento;
    }

    public void setEvento(final NFEvento evento) {
        this.evento = evento;
    }

    public NFEventoRetorno getEventoRetorno() {
        return this.eventoRetorno;
    }

    public void setEventoRetorno(final NFEventoRetorno eventoRetorno) {
        this.eventoRetorno = eventoRetorno;
    }
}
