package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTipoComponenteGTVe;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "Comp")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoGTVeComp extends DFBase {
    private static final long serialVersionUID = 3107443189436692983L;

    @Element(name = "tpComp")
    private CTipoComponenteGTVe tipoComponente;

    @Element(name = "vComp")
    private String valorComponente;

    @Element(name = "xComp", required = false)
    private String nomeComponente;

    public CTipoComponenteGTVe getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(final CTipoComponenteGTVe tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public String getValorComponente() {
        return valorComponente;
    }

    public void setValorComponente(final BigDecimal valorComponente) {
        this.valorComponente = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorComponente, "Valor do componente");
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(final String nomeComponente) {
        DFStringValidador.tamanho15(nomeComponente, "Nome do componente");
        this.nomeComponente = nomeComponente;
    }
}
