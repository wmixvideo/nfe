package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "proc")
@Namespace(reference = NFeConfig.NAMESPACE)
public class NFCeDownloadXMLRetornoProc extends DFBase {
    private static final long serialVersionUID = 1L;

    @Element(name = "nfeProc", required = false)
    private NFCeDownloadXMLRetornoNfeProc nfeProc;

    @ElementList(entry = "procEventoNFe", inline = true, required = false)
    private List<NFCeDownloadXMLRetornoProcEventoNFe> procEventoNFe;

    public NFCeDownloadXMLRetornoNfeProc getNfeProc() {
        return this.nfeProc;
    }

    public void setNfeProc(final NFCeDownloadXMLRetornoNfeProc nfeProc) {
        this.nfeProc = nfeProc;
    }

    public List<NFCeDownloadXMLRetornoProcEventoNFe> getProcEventoNFe() {
        return this.procEventoNFe;
    }

    public void setProcEventoNFe(final List<NFCeDownloadXMLRetornoProcEventoNFe> procEventoNFe) {
        this.procEventoNFe = procEventoNFe;
    }
}
