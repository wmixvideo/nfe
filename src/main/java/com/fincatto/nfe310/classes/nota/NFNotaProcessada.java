package com.fincatto.nfe310.classes.nota;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFProtocolo;
import com.fincatto.nfe310.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "nfeProc")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaProcessada extends NFBase {

    @Attribute(name = "versao")
    private String versao;

    @Attribute(name = "schemaLocation", required = false)
    private String schemaLocation;

    @Element(name = "NFe")
    private NFNota nota;

    @Element(name = "protNFe")
    private NFProtocolo protocolo;

    public NFNota getNota() {
        return this.nota;
    }

    public String getVersao() {
        return this.versao;
    }

    public NFProtocolo getProtocolo() {
        return this.protocolo;
    }

    public void setNota(final NFNota nota) {
        this.nota = nota;
    }

    public void setProtocolo(final NFProtocolo protocolo) {
        this.protocolo = protocolo;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho4Com2CasasDecimais(versao, "Versao Nota Processada");
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }
}