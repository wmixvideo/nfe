package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "nfeProc")
@Namespace(reference = NFeConfig.NAMESPACE)
public class NFCeDownloadXMLRetornoNfeProc extends DFBase {
    private static final long serialVersionUID = 1L;

    @Attribute(name = "versao", required = false)
    private String versao;

    @Element(name = "dhInc")
    private String dataHoraInclusao;

    @Element(name = "nProt")
    private String numeroProtocolo;

    @Element(name = "NFe", required = false)
    private NFNota nota;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public String getDataHoraInclusao() {
        return this.dataHoraInclusao;
    }

    public void setDataHoraInclusao(final String dataHoraInclusao) {
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
}
