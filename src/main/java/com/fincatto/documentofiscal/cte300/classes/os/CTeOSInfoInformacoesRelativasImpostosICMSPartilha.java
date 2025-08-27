package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "ICMSUFFim")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoInformacoesRelativasImpostosICMSPartilha extends DFBase {
    
    @Element(name = "vBCUFFim")
    private String bcICMS;
    
    @Element(name = "pFCPUFFim")
    private String aliquotaFCP;
    
    @Element(name = "pICMSUFFim")
    private String aliquotaInterna;
    
    @Element(name = "pICMSInter")
    private String aliquotaInterestadual;
    
    @Element(name = "pICMSInterPart", required = false)
    private String aliquotaPartilha;

    @Element(name = "vFCPUFFim")
    private String valorFCP;
    
    @Element(name = "vICMSUFFim")
    private String valorUfDestino;
    
    @Element(name = "vICMSUFIni")
    private String valorUf;

    public CTeOSInfoInformacoesRelativasImpostosICMSPartilha() {
        this.bcICMS = null;
        this.aliquotaFCP = null;
        this.aliquotaInterna = null;
        this.aliquotaInterestadual = null;
        this.aliquotaPartilha = null;
        this.valorFCP = null;
        this.valorUfDestino = null;
        this.valorUf = null;
    }

    public String getBcICMS() {
        return this.bcICMS;
    }

    /**
     * Valor da BC do ICMS na UF de término da prestação do serviço de transporte
     */
    public void setBcICMS(final BigDecimal bcICMS) {
        this.bcICMS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(bcICMS, "Valor da BC do ICMS na UF de término da prestação do serviço de transporte");
    }

    public String getAliquotaFCP() {
        return this.aliquotaFCP;
    }

    /**
     * Percentual do ICMS relativo ao Fundo de Combate à pobreza (FCP) na UF de término da prestação do serviço de transporte<br>
     * Alíquota adotada nas operações internas na UF do destinatário
     */
    public void setAliquotaFCP(final BigDecimal aliquotaFCP) {
        this.aliquotaFCP = DFBigDecimalValidador.tamanho5Com2CasasDecimais(aliquotaFCP, "Percentual do ICMS relativo ao Fundo de Combate à pobreza (FCP)");
    }

    public String getAliquotaInterna() {
        return this.aliquotaInterna;
    }

    /**
     * Alíquota interna da UF de término da prestação do serviço de transporte<br>
     * Alíquota adotada nas operações internas na UF do destinatário
     */
    public void setAliquotaInterna(final BigDecimal aliquotaInterna) {
        this.aliquotaInterna = DFBigDecimalValidador.tamanho5Com2CasasDecimais(aliquotaInterna, "Alíquota interna da UF de término da prestação do serviço de transporte");
    }

    public String getAliquotaInterestadual() {
        return this.aliquotaInterestadual;
    }

    /**
     * Alíquota interestadual das UF envolvidas
     */
    public void setAliquotaInterestadual(final BigDecimal aliquotaInterestadual) {
        this.aliquotaInterestadual = DFBigDecimalValidador.tamanho5Com2CasasDecimais(aliquotaInterestadual, "Alíquota interestadual das UF envolvidas");
    }

    public String getAliquotaPartilha() {
        return this.aliquotaPartilha;
    }

    /**
     * Percentual provisório de partilha entre os estados<br>
     * Percentual de partilha para a UF do destinatário:<br>
     * - 40% em 2016;<br>
     * - 60% em 2017;<br>
     * - 80% em 2018;<br>
     * - 100% a partir de 2019.
     */
    public void setAliquotaPartilha(final BigDecimal aliquotaPartilha) {
        this.aliquotaPartilha = DFBigDecimalValidador.tamanho5Com2CasasDecimais(aliquotaPartilha, "Percentual provisório de partilha entre os estados");
    }

    public String getValorFCP() {
        return this.valorFCP;
    }

    /**
     * Valor do ICMS relativo ao Fundo de Combate á Pobreza (FCP) da UF de término da prestação
     */
    public void setValorFCP(final BigDecimal valorFCP) {
        this.valorFCP = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorFCP, "Valor do ICMS relativo ao Fundo de Combate á Pobreza (FCP)");
    }

    public String getValorUfDestino() {
        return this.valorUfDestino;
    }

    /**
     * Valor do ICMS de partilha para a UF de término da prestação do serviço de transporte
     */
    public void setValorUfDestino(final BigDecimal valorUfDestino) {
        this.valorUfDestino = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorUfDestino, "Valor do ICMS de partilha para a UF de término da prestação do serviço de transporte");
    }

    public String getValorUf() {
        return this.valorUf;
    }

    /**
     * Valor do ICMS de partilha para a UF de início da prestação do serviço de transporte
     */
    public void setValorUf(final BigDecimal valorUf) {
        this.valorUf = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorUf, "Valor do ICMS de partilha para a UF de início da prestação do serviço de transporte");
    }
}
