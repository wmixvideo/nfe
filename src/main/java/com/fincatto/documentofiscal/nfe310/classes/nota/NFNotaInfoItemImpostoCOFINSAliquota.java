package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaCOFINS;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class NFNotaInfoItemImpostoCOFINSAliquota extends DFBase {
    private static final long serialVersionUID = -8079337130690627887L;

    private static final List<NFNotaInfoSituacaoTributariaCOFINS> SITUACOES_VALIDAS = Arrays.asList(NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO, NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA);
    
    @Element(name = "CST")
    private NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria;
    
    @Element(name = "vBC")
    private String valorBaseCalculo;
    
    @Element(name = "pCOFINS")
    private String percentualAliquota;
    
    @Element(name = "vCOFINS")
    private String valor;
    
    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        if (!NFNotaInfoItemImpostoCOFINSAliquota.SITUACOES_VALIDAS.contains(situacaoTributaria)) {
            throw new IllegalStateException("Situacao tributaria invalido no item COFINS Aliquota.");
        }
        this.situacaoTributaria = situacaoTributaria;
    }
    
    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor Base de Calculo COFINS Item");
    }
    
    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(aliquota, "Aliquota COFINS Item");
    }
    
    public void setValor(final BigDecimal valor) {
        this.valor = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valor, "Valor COFINS Item");
    }
    
    public NFNotaInfoSituacaoTributariaCOFINS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }
    
    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }
    
    public String getPercentualAliquota() {
        return this.percentualAliquota;
    }
    
    public String getValor() {
        return this.valor;
    }
}