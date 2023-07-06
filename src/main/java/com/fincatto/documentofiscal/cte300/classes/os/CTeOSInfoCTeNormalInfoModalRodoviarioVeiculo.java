package com.fincatto.documentofiscal.cte300.classes.os;


import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "veic")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoModalRodoviarioVeiculo extends DFBase {
    private static final long serialVersionUID = 5278574973196952726L;

    @Element(name = "placa")
    private String placa;

    @Element(name = "RENAVAM", required = false)
    private String renavam;

    @Element(name = "prop", required = false)
    private CTeOSInfoCTeNormalInfoModalRodoviarioVeiculoProprietario proprietario;

    @Element(name = "UF")
    private String uf;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(final String placa) {
        DFStringValidador.placaDeVeiculo(placa, "Placa do veículo");
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(final String renavam) {
        this.renavam = DFStringValidador.validaIntervalo(renavam, 9, 11, "Renavam do reboque");
    }

    public CTeOSInfoCTeNormalInfoModalRodoviarioVeiculoProprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(final CTeOSInfoCTeNormalInfoModalRodoviarioVeiculoProprietario proprietario) {
        this.proprietario = proprietario;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(final String uf) {
        DFStringValidador.exatamente2(uf, "UF");
        this.uf = uf;
    }
}
