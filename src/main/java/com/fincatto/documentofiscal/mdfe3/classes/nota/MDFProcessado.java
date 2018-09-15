package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.mdfe3.classes.MDFProtocolo;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

import java.math.BigDecimal;

@Root(name = "mdfeProc")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFProcessado extends DFBase {
    private static final long serialVersionUID = 6979476565566044621L;

    @Attribute(name = "versao")
    private String versao;

    @Attribute(name = "schemaLocation", required = false)
    private String schemaLocation;

    @Element(name = "MDFe")
    private MDFe mdfe;

    @Element(name = "protMDFe")
    private MDFProtocolo protocolo;

    public MDFe getMdfe() {
        return this.mdfe;
    }

    public String getVersao() {
        return this.versao;
    }

    public MDFProtocolo getProtocolo() {
        return this.protocolo;
    }

    public void setMdfe(final MDFe mdfe) {
        this.mdfe = mdfe;
    }

    public void setProtocolo(final MDFProtocolo protocolo) {
        this.protocolo = protocolo;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho4Com2CasasDecimais(versao, "Versao MDFe Processado");
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }
}