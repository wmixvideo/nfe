package com.fincatto.documentofiscal.mdfe3.classes.nota.evento.cancelamento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeInfoEventoRetorno;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "retCancMDFe")
public class MDFeRetornoCancelamento extends DFBase {

    @Attribute(name = "versao", required = false)
    private String versao;

    @Element(name = "infEvento")
    private MDFeInfoEventoRetorno infoCancelamento;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public MDFeInfoEventoRetorno getInfoCancelamento() {
        return infoCancelamento;
    }

    public void setInfoCancelamento(MDFeInfoEventoRetorno infoCancelamento) {
        this.infoCancelamento = infoCancelamento;
    }
}