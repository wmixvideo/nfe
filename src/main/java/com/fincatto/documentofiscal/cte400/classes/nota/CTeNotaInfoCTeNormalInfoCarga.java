package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

/**
 * Informações da Carga do CT-e
 */

@Root(name = "infCarga")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoCarga extends DFBase {
    private static final long serialVersionUID = 5318959138449799285L;

    @Element(name = "vCarga")
    private String valorTotalCarga;
    
    @Element(name = "proPred")
    private String descricaoProdutoPredominante;

    @Element(name = "xOutCat", required = false)
    private String descricaoOutrasCaracteristicas;
    
    @ElementList(name = "infQ", inline = true)
    private List<CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga> informacoesQuantidadeCarga;

    @Element(name = "vCargaAverb", required = false)
    private String valorAverbacao;

    public String getValorTotalCarga() {
        return this.valorTotalCarga;
    }

    /**
     * Valor total da carga<br>
     * Dever ser informado para todos os modais, com exceção para o Dutoviário.
     */
    public void setValorTotalCarga(final BigDecimal valorTotalCarga) {
        this.valorTotalCarga = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalCarga, "Valor total da carga");
    }

    public String getDescricaoProdutoPredominante() {
        return this.descricaoProdutoPredominante;
    }

    /**
     * Produto predominante<br>
     * Informar a descrição do produto predominante
     */
    public void setDescricaoProdutoPredominante(final String descricaoProdutoPredominante) {
        DFStringValidador.tamanho60(descricaoProdutoPredominante, "Produto predominante");
        this.descricaoProdutoPredominante = descricaoProdutoPredominante;
    }

    public String getDescricaoOutrasCaracteristicas() {
        return this.descricaoOutrasCaracteristicas;
    }

    /**
     * Outras características da carga<br>
     * "FRIA", "GRANEL", "REFRIGERADA", "Medidas: 12X12X12"
     */
    public void setDescricaoOutrasCaracteristicas(final String descricaoOutrasCaracteristicas) {
        DFStringValidador.tamanho30(descricaoOutrasCaracteristicas, "Outras características da carga");
        this.descricaoOutrasCaracteristicas = descricaoOutrasCaracteristicas;
    }

    public List<CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga> getInformacoesQuantidadeCarga() {
        return this.informacoesQuantidadeCarga;
    }

    /**
     * Informações de quantidades da Carga do CT-e<br>
     * Para o Aéreo é obrigatório o preenchimento desse campo da seguinte forma.<br>
     * 1 - Peso Bruto, sempre em quilogramas (obrigatório);<br>
     * 2 - Peso Cubado; sempre em quilogramas;<br>
     * 3 - Quantidade de volumes, sempre em unidades (obrigatório);<br>
     * 4 - Cubagem, sempre em metros cúbicos (obrigatório apenas quando for impossível preencher as dimensões da(s) embalagem(ens) na tag xDime do leiaute do Aéreo).
     */
    public void setInformacoesQuantidadeCarga(final List<CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga> informacoesQuantidadeCarga) {
        this.informacoesQuantidadeCarga = informacoesQuantidadeCarga;
    }

    public String getValorAverbacao() {
        return this.valorAverbacao;
    }

    /**
     * Valor da Carga para efeito de averbação<br>
     * Normalmente igual ao valor declarado da mercadoria, diferente por exemplo, quando a mercadoria transportada é isenta de tributos nacionais para exportação, onde é preciso averbar um valor maior, pois no caso de indenização, o valor a ser pago será maior
     */
    public void setValorAverbacao(final BigDecimal valorAverbacao) {
        this.valorAverbacao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorAverbacao, "Valor da Carga para efeito de averbação");
    }
}
