package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeInfoEventoRetorno;

@Root(name = "retCancCTe")
public class CTeRetornoCancelamento extends DFBase {
    private static final long serialVersionUID = -578023299108955542L;

    @Attribute(name = "versao", required = false)
    private String versao;

    @Element(name = "infEvento")
    private CTeInfoEventoRetorno infoCancelamento;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public CTeInfoEventoRetorno getInfoCancelamento() {
        return this.infoCancelamento;
    }

    public void setInfoCancelamento(final CTeInfoEventoRetorno infoCancelamento) {
        this.infoCancelamento = infoCancelamento;
    }
}