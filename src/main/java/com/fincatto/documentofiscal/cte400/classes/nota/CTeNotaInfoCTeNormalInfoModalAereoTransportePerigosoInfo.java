package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte400.classes.CTUnidadeMedidaProdPerigosos;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class CTeNotaInfoCTeNormalInfoModalAereoTransportePerigosoInfo extends DFBase {
    private static final long serialVersionUID = -6881685933547033533L;

    @Element(name = "qTotProd")
    private String quantidadeTotal;
    
    @Element(name = "uniAP")
    private CTUnidadeMedidaProdPerigosos unidade;

    public String getQuantidadeTotal() {
        return this.quantidadeTotal;
    }

    /**
     * Quantidade total de artigos perigosos<br>
     * 15 posições, sendo 11 inteiras e 4 decimais. Deve indicar a quantidade total do artigo perigoso, tendo como base a unidade referenciada na Tabela 3-1 do Doc 9284, por exemplo: litros; quilogramas; quilograma bruto etc. O preenchimento não deve, entretanto, incluir a unidade de medida. No caso de transporte de material radioativo, deve-se indicar o somatório dos Índices de Transporte (TI). Não indicar a quantidade do artigo perigoso por embalagem.
     */
    public void setQuantidadeTotal(final BigDecimal quantidadeTotal) {
        this.quantidadeTotal = DFBigDecimalValidador.tamanho15Com4CasasDecimais(quantidadeTotal, "Quantidade total de artigos perigosos");
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
