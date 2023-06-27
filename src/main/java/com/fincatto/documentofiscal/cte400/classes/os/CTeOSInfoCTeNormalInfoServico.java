package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "infServico")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoServico extends DFBase {
    private static final long serialVersionUID = -6918550471184804059L;

    @Element(name = "xDescServ")
    private String descricaoServico;

    @ElementList(name = "infQ", inline = true, required = false)
    private List<CTeOSInfoCTeNormalInfoCargaInformacoesQuantidadeCarga> informacoesQuantidadeCarga;

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(final String descricaoServico) {
        DFStringValidador.tamanho30(descricaoServico, "Descricao Servico");
        this.descricaoServico = descricaoServico;
    }

    public List<CTeOSInfoCTeNormalInfoCargaInformacoesQuantidadeCarga> getInformacoesQuantidadeCarga() {
        return informacoesQuantidadeCarga;
    }

    public void setInformacoesQuantidadeCarga(List<CTeOSInfoCTeNormalInfoCargaInformacoesQuantidadeCarga> informacoesQuantidadeCarga) {
        this.informacoesQuantidadeCarga = informacoesQuantidadeCarga;
    }
}
