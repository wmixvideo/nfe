package com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "retCancNFe")
public class NFRetornoCancelamento extends DFBase {
    private static final long serialVersionUID = 93128697872980852L;

    @Attribute(name = "versao", required = false)
    private String versao;

    @Element(name = "infCanc")
    private NFRetornoInfoCancelamento infoCancelamento;

    public NFRetornoInfoCancelamento getInfoCancelamento() {
        return this.infoCancelamento;
    }

    public void setInfoCancelamento(final NFRetornoInfoCancelamento infoCancelamento) {
        this.infoCancelamento = infoCancelamento;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }
}