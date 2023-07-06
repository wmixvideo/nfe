package com.fincatto.documentofiscal.cte300.classes.os;


import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTResponsavelSeguro;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "seg")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalSeguro extends DFBase {
    private static final long serialVersionUID = -7791328283494118369L;

    @Element(name = "respSeg")
    private CTResponsavelSeguro responsavelSeguro;

    @Element(name = "xSeg", required = false)
    private String nomeSeguradora;

    @Element(name = "nApol", required = false)
    private String numeroApolice;

    public CTResponsavelSeguro getResponsavelSeguro() {
        return responsavelSeguro;
    }

    public void setResponsavelSeguro(final CTResponsavelSeguro responsavelSeguro) {
        this.responsavelSeguro = responsavelSeguro;
    }

    public String getNomeSeguradora() {
        return nomeSeguradora;
    }

    public void setNomeSeguradora(final String nomeSeguradora) {
        DFStringValidador.tamanho30(nomeSeguradora, "Nome da seguradora");
        this.nomeSeguradora = nomeSeguradora;
    }

    public String getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(final String numeroApolice) {
        DFStringValidador.tamanho20(numeroApolice, "Número da apólice");
        this.numeroApolice = numeroApolice;
    }
}
