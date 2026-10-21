package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFProtocolo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.ZonedDateTime;

@Root(name = "nfeProc", strict = false)
@Namespace(reference = NFeConfig.NAMESPACE)
public class NFCeDownloadXMLRetornoNfeProc extends DFBase {
    private static final long serialVersionUID = 5435024053609129373L;

    @Attribute(name = "versao", required = false)
    private String versao;

    @Element(name = "dhInc")
    private ZonedDateTime dataHoraInclusao;

    @Element(name = "nProt")
    private String numeroProtocolo;

    @Element(name = "NFe", required = false)
    private NFNota nota;

    @Element(name = "protNFe", required = false)
    private NFProtocolo protocolo;

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

    public NFNota getNota() {
        return this.nota;
    }

    public void setNota(final NFNota nota) {
        this.nota = nota;
    }

    public NFProtocolo getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(final NFProtocolo protocolo) {
        this.protocolo = protocolo;
    }
}
