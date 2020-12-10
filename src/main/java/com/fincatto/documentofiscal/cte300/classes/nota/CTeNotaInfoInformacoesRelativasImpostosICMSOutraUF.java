package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTCodigoSituacaoTributariaICMS;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * @author Caio
 * @info ICMS devido à UF de origem da prestação, quando diferente da UF do emitente
 */

@Root(name = "ICMSOutraUF")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF extends DFBase {
    private static final long serialVersionUID = 1380053710331255889L;
    
    @Element(name = "CST")
    private CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria;

    @Element(name = "pRedBCOutraUF", required = false)
    private String aliquotaReducaoBaseCalculoICMSOutraUF;
    
    @Element(name = "vBCOutraUF")
    private String baseCalculoICMSOutraUF;
    
    @Element(name = "pICMSOutraUF")
    private String aliquotaICMSOutraUF;
    
    @Element(name = "vICMSOutraUF")
    private String valorICMSOutraUF;

    public CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF() {
        this.codigoSituacaoTributaria = null;
        this.aliquotaReducaoBaseCalculoICMSOutraUF = null;
        this.baseCalculoICMSOutraUF = null;
        this.aliquotaICMSOutraUF = null;
        this.valorICMSOutraUF = null;
    }

    public CTCodigoSituacaoTributariaICMS getCodigoSituacaoTributaria() {
        return this.codigoSituacaoTributaria;
    }

    /**
     * Classificação Tributária do Serviço<br>
     * 90 - ICMS Outra UF
     */
    public void setCodigoSituacaoTributaria(final CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }

    public String getAliquotaReducaoBaseCalculoICMSOutraUF() {
        return this.aliquotaReducaoBaseCalculoICMSOutraUF;
    }

    /**
     * Percentual de redução da BC
     */
    public void setAliquotaReducaoBaseCalculoICMSOutraUF(final BigDecimal aliquotaReducaoBaseCalculoICMSOutraUF) {
        this.aliquotaReducaoBaseCalculoICMSOutraUF = DFBigDecimalValidador.tamanho5Com2CasasDecimais(aliquotaReducaoBaseCalculoICMSOutraUF, "Percentual de redução da BC");
    }

    public String getBaseCalculoICMSOutraUF() {
        return this.baseCalculoICMSOutraUF;
    }

    /**
     * Valor da BC do ICMS
     */
    public void setBaseCalculoICMSOutraUF(final BigDecimal baseCalculoICMSOutraUF) {
        this.baseCalculoICMSOutraUF = DFBigDecimalValidador.tamanho15Com2CasasDecimais(baseCalculoICMSOutraUF, "Valor da BC do ICMS");
    }

    public String getAliquotaICMSOutraUF() {
        return this.aliquotaICMSOutraUF;
    }

    /**
     * Alíquota do ICMS
     */
    public void setAliquotaICMSOutraUF(final BigDecimal aliquotaICMSOutraUF) {
        this.aliquotaICMSOutraUF = DFBigDecimalValidador.tamanho5Com2CasasDecimais(aliquotaICMSOutraUF, "Alíquota do ICMS");
    }

    public String getValorICMSOutraUF() {
        return this.valorICMSOutraUF;
    }

    /**
     * Valor do ICMS devido outra UF
     */
    public void setValorICMSOutraUF(final BigDecimal valorICMSOutraUF) {
        this.valorICMSOutraUF = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSOutraUF, "Valor do ICMS devido outra UF");
    }
}
