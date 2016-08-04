package com.fincatto.nfe.core.evento.cancelamento;

import com.fincatto.nfe.core.NFBase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "retCancNFe")
public class NFRetornoCancelamento extends NFBase {

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