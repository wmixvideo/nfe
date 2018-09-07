package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTUnidadeMedida;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * @author Caio
 * @info Informações de quantidades da Carga do CT-e<br>
 *       Para o Aéreo é obrigatório o preenchimento desse campo da seguinte forma.<br>
 *       1 - Peso Bruto, sempre em quilogramas (obrigatório);<br>
 *       2 - Peso Cubado; sempre em quilogramas;<br>
 *       3 - Quantidade de volumes, sempre em unidades (obrigatório);<br>
 *       4 - Cubagem, sempre em metros cúbicos (obrigatório apenas quando for impossível preencher as dimensões da(s) embalagem(ens) na tag xDime do leiaute do Aéreo).
 */

@Root(name = "infQ")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga extends DFBase {
    private static final long serialVersionUID = 4270955186707660004L;

    @Element(name = "cUnid", required = true)
    private CTUnidadeMedida unidadeMedida;

    @Element(name = "tpMed", required = true)
    private String tipoMedia;

    @Element(name = "qCarga", required = true)
    private String quantidade;

    public CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga() {
        this.unidadeMedida = null;
        this.tipoMedia = null;
        this.quantidade = null;
    }

    public CTUnidadeMedida getUnidadeMedida() {
        return this.unidadeMedida;
    }

    /**
     * Código da Unidade de Medida<br>
     * Preencher com:<br>
     * 00-M3;<br>
     * 01-KG;<br>
     * 02-TON;<br>
     * 03-UNIDADE;<br>
     * 04-LITROS;<br>
     * 05-MMBTU
     */
    public void setUnidadeMedida(final CTUnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getTipoMedia() {
        return this.tipoMedia;
    }

    /**
     * Tipo da Medida<br>
     * Exemplos:PESO BRUTO, PESO DECLARADO, PESO CUBADO, PESO AFORADO, PESO AFERIDO, PESO BASE DE CÁLCULO, LITRAGEM, CAIXAS e etc
     */
    public void setTipoMedia(final String tipoMedia) {
        StringValidador.tamanho20(tipoMedia, "Tipo da Medida");
        this.tipoMedia = tipoMedia;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    /**
     * Quantidade
     */
    public void setQuantidade(final BigDecimal quantidade) {
        this.quantidade = BigDecimalParser.validaTamanho(quantidade, "Quantidade Carga CT-e", 11, 4, true);
    }
}
