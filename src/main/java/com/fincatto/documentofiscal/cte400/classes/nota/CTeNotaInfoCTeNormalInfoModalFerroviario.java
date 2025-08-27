package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTTipoTrafego;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Informações do modal Ferroviário
 */

@Root(name = "ferrov")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalFerroviario extends DFBase {
    private static final long serialVersionUID = -2808507148819018428L;

    @Element(name = "tpTraf")
    private CTTipoTrafego tipoTrafego;

    @Element(name = "trafMut", required = false)
    private CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuo trafegoMutuo;

    @Element(name = "fluxo", required = false)
    private String fluxo;

    public CTTipoTrafego getTipoTrafego() {
        return this.tipoTrafego;
    }

    /**
     * Tipo de Tráfego
     */
    public void setTipoTrafego(final CTTipoTrafego tipoTrafego) {
        this.tipoTrafego = tipoTrafego;
    }

    public CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuo getTrafegoMutuo() {
        return this.trafegoMutuo;
    }

    /**
     * Detalhamento de informações para o tráfego mútuo
     */
    public void setTrafegoMutuo(final CTeNotaInfoCTeNormalInfoModalFerroviarioTrafegoMutuo trafegoMutuo) {
        this.trafegoMutuo = trafegoMutuo;
    }

    public String getFluxo() {
        return this.fluxo;
    }

    /**
     * Fluxo Ferroviário<br>
     * Trata-se de um número identificador do contrato firmado com o cliente
     */
    public void setFluxo(final String fluxo) {
        this.fluxo = fluxo;
    }
}
