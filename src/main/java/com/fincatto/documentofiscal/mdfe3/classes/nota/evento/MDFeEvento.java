package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

@Root(name = "eventoMDFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeEvento extends DFBase {
    private static final long serialVersionUID = 6488632164801543377L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "infEvento")
    private MDFeInfoEvento infoEvento;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public MDFeInfoEvento getInfoEvento() {
        return this.infoEvento;
    }

    public void setInfoEvento(final MDFeInfoEvento infoEvento) {
        this.infoEvento = infoEvento;
    }

    public NFSignature getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(final NFSignature assinatura) {
        this.assinatura = assinatura;
    }
}