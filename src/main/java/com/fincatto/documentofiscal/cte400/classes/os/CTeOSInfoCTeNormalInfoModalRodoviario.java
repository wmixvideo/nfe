package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "rodoOS")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoModalRodoviario extends DFBase {
    private static final long serialVersionUID = -5367579900038295412L;

    @Element(name = "TAF", required = false)
    private String termoAutorizacaoFretamento;

    @Element(name = "NroRegEstadual", required = false)
    private String numeroRegistroEstadual;

    @Element(name = "veic", required = false)
    private CTeOSInfoCTeNormalInfoModalRodoviarioVeiculo veiculo;

    @Element(name = "infFretamento", required = false)
    private CTeOSInfoCTeNormalInfoModalRodoviarioFretamento fretamento;

    public String getTermoAutorizacaoFretamento() {
        return termoAutorizacaoFretamento;
    }

    public void setTermoAutorizacaoFretamento(final String termoAutorizacaoFretamento) {
        DFStringValidador.tamanho12(termoAutorizacaoFretamento, "Termo de Autorização de Fretamento");
        this.termoAutorizacaoFretamento = termoAutorizacaoFretamento;
    }

    public String getNumeroRegistroEstadual() {
        return numeroRegistroEstadual;
    }

    public void setNumeroRegistroEstadual(final String numeroRegistroEstadual) {
        DFStringValidador.tamanho25N(numeroRegistroEstadual, "Número do Registro Estadual");
        this.numeroRegistroEstadual = numeroRegistroEstadual;
    }

    public CTeOSInfoCTeNormalInfoModalRodoviarioVeiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(final CTeOSInfoCTeNormalInfoModalRodoviarioVeiculo veiculo) {
        this.veiculo = veiculo;
    }

    public CTeOSInfoCTeNormalInfoModalRodoviarioFretamento getFretamento() {
        return fretamento;
    }

    public void setFretamento(final CTeOSInfoCTeNormalInfoModalRodoviarioFretamento fretamento) {
        this.fretamento = fretamento;
    }
}
