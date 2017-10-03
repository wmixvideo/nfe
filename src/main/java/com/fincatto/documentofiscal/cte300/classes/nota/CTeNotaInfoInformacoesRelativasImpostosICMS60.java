package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTCodigoSituacaoTributariaICMS;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

/**
 * @author Caio
 * @info Tributação pelo ICMS60 - ICMS cobrado por substituição tributária. Responsabilidade do recolhimento do ICMS atribuído ao tomador ou 3º por ST
 */

@Root(name = "ICMS60")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoInformacoesRelativasImpostosICMS60 extends DFBase {
    private static final long serialVersionUID = 2536989879361188288L;

    @Element(name = "CST", required = true)
    private CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria;

    @Element(name = "vBCSTRet", required = true)
    private String baseCalculoICMSSTRetido;

    @Element(name = "vICMSSTRet", required = true)
    private String valorICMSSTRetido;

    @Element(name = "pICMSSTRet", required = true)
    private String aliquotaICMSSTRetido;

    @Element(name = "vCred", required = false)
    private String valorCredito;

    public CTeNotaInfoInformacoesRelativasImpostosICMS60() {
        this.codigoSituacaoTributaria = null;
        this.baseCalculoICMSSTRetido = null;
        this.valorICMSSTRetido = null;
        this.aliquotaICMSSTRetido = null;
        this.valorCredito = null;
    }

    public CTCodigoSituacaoTributariaICMS getCodigoSituacaoTributaria() {
        return this.codigoSituacaoTributaria;
    }

    /**
     * Classificação Tributária do Serviço<br>
     * 60 - ICMS cobrado por substituição tributária
     */
    public void setCodigoSituacaoTributaria(final CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }

    public String getBaseCalculoICMSSTRetido() {
        return this.baseCalculoICMSSTRetido;
    }

    /**
     * Valor da BC do ICMS ST retido<br>
     * Valor do frete sobre o qual será calculado o ICMS a ser substituído na Prestação.
     */
    public void setBaseCalculoICMSSTRetido(final BigDecimal baseCalculoICMSSTRetido) {
        this.baseCalculoICMSSTRetido = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoICMSSTRetido, "Valor da BC do ICMS ST retido");
    }

    public String getValorICMSSTRetido() {
        return this.valorICMSSTRetido;
    }

    /**
     * Valor do ICMS ST retido<br>
     * Resultado da multiplicação do “vBCSTRet” x “pICMSSTRet” – que será valor do ICMS a ser retido pelo Substituto. Podendo o valor do ICMS a ser retido efetivamente, sofrer ajustes conforme a opção tributaria do transportador substituído.
     */
    public void setValorICMSSTRetido(final BigDecimal valorICMSSTRetido) {
        this.valorICMSSTRetido = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSSTRetido, "Valor do ICMS ST retido");
    }

    public String getAliquotaICMSSTRetido() {
        return this.aliquotaICMSSTRetido;
    }

    /**
     * Alíquota do ICMS<br>
     * Percentual de Alíquota incidente na prestação de serviço de transporte.
     */
    public void setAliquotaICMSSTRetido(final BigDecimal aliquotaICMSSTRetido) {
        this.aliquotaICMSSTRetido = BigDecimalParser.tamanho5Com2CasasDecimais(aliquotaICMSSTRetido, "Alíquota do ICMS");
    }

    public String getValorCredito() {
        return this.valorCredito;
    }

    /**
     * Valor do Crédito outorgado/Presumido<br>
     * Preencher somente quando o transportador substituído, for optante pelo crédito outorgado previsto no Convênio 106/96 e corresponde ao percentual de 20% do valor do ICMS ST retido.
     */
    public void setValorCredito(final BigDecimal valorCredito) {
        this.valorCredito = BigDecimalParser.tamanho15Com2CasasDecimais(valorCredito, "Valor do Crédito outorgado/Presumido");
    }
}
