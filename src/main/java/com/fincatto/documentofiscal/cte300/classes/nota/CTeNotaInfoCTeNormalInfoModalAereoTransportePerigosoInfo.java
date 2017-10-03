package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTUnidadeMedidaProdPerigosos;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class CTeNotaInfoCTeNormalInfoModalAereoTransportePerigosoInfo extends DFBase {
    private static final long serialVersionUID = 1399533868716793539L;

    @Element(name = "qTotProd", required = true)
    private String quantidadeTotal;

    @Element(name = "uniAP", required = true)
    private CTUnidadeMedidaProdPerigosos unidade;

    public CTeNotaInfoCTeNormalInfoModalAereoTransportePerigosoInfo() {
        this.quantidadeTotal = null;
        this.unidade = null;
    }

    public String getQuantidadeTotal() {
        return this.quantidadeTotal;
    }

    /**
     * Quantidade total de artigos perigosos<br>
     * 15 posições, sendo 11 inteiras e 4 decimais. Deve indicar a quantidade total do artigo perigoso, tendo como base a unidade referenciada na Tabela 3-1 do Doc 9284, por exemplo: litros; quilogramas; quilograma bruto etc. O preenchimento não deve, entretanto, incluir a unidade de medida. No caso de transporte de material radioativo, deve-se indicar o somatório dos Índices de Transporte (TI). Não indicar a quantidade do artigo perigoso por embalagem.
     */
    public void setQuantidadeTotal(final BigDecimal quantidadeTotal) {
        this.quantidadeTotal = BigDecimalParser.tamanho15Com4CasasDecimais(quantidadeTotal, "Quantidade total de artigos perigosos");
    }

    public CTUnidadeMedidaProdPerigosos getUnidade() {
        return this.unidade;
    }

    /**
     * Unidade de medida<br>
     * 1 – KG;<br>
     * 2 – KG G (quilograma bruto);<br>
     * 3 – LITROS;<br>
     * 4 – TI (índice de transporte para radioativos);<br>
     * 5- Unidades (apenas para artigos perigosos medidos em unidades que não se enquadram nos itens acima. Exemplo: baterias, celulares, equipamentos, veículos, dentre outros)
     */
    public void setUnidade(final CTUnidadeMedidaProdPerigosos unidade) {
        this.unidade = unidade;
    }
}
