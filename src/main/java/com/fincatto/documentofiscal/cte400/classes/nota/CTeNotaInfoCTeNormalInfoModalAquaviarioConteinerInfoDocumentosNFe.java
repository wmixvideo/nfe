package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Informações das NFe
 */

@Root(name = "infNFe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe extends DFBase {
    private static final long serialVersionUID = -4509113589279181638L;

    @Element(name = "chave")
    private String chave;

    @Element(name = "unidRat", required = false)
    private String unidadeRateada;

    public String getChave() {
        return this.chave;
    }

    /**
     * Chave de acesso da NF-e
     */
    public void setChave(final String chave) {
        DFStringValidador.exatamente44N(chave, "Chave de acesso da NF-e");
        this.chave = chave;
    }

    public String getUnidadeRateada() {
        return this.unidadeRateada;
    }

    /**
     * Unidade de medida rateada (Peso,Volume)
     */
    public void setUnidadeRateada(final BigDecimal unidadeRateada) {
        this.unidadeRateada = DFBigDecimalValidador.tamanho5Com2CasasDecimais(unidadeRateada, "Unidade de medida rateada (Peso,Volume)");
    }
}
