package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTTipoUnidadeTransporte;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

/**
 * Informações das Unidades de Transporte (Carreta/Reboque/Vagão)<br>
 *       Deve ser preenchido com as informações das unidades de transporte utilizadas.
 */

@Root(name = "infUnidTransp")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte extends DFBase {
    private static final long serialVersionUID = -581075717299803877L;

    @Element(name = "tpUnidTransp")
    private CTTipoUnidadeTransporte tpUnidTransp;
    
    @Element(name = "idUnidTransp")
    private String identificacaoTransporte;

    @ElementList(name = "lacUnidTransp", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosLacre> lacre;

    @ElementList(name = "infUnidCarga", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> infoUnidadeCarga;

    @Element(name = "qtdRat", required = false)
    private String quantidadeRateada;

    public CTTipoUnidadeTransporte getTpUnidTransp() {
        return this.tpUnidTransp;
    }

    /**
     * Tipo da Unidade de Transporte<br>
     * 1 - Rodoviário Tração<br>
     * 2 - Rodoviário Reboque<br>
     * 3 - Navio<br>
     * 4 - Balsa<br>
     * 5 - Aeronave<br>
     * 6 - Vagão<br>
     * 7 - Outros
     */
    public void setTpUnidTransp(final CTTipoUnidadeTransporte tpUnidTransp) {
        this.tpUnidTransp = tpUnidTransp;
    }

    public String getIdentificacaoTransporte() {
        return this.identificacaoTransporte;
    }

    /**
     * Identificação da Unidade de Transporte<br>
     * Informar a identificação conforme o tipo de unidade de transporte. Por exemplo: para rodoviário tração ou reboque deverá preencher com a placa do veículo.
     */
    public void setIdentificacaoTransporte(final String identificacaoTransporte) {
        DFStringValidador.tamanho20(identificacaoTransporte, "Identificação da Unidade de Transporte");
        this.identificacaoTransporte = identificacaoTransporte;
    }

    public List<CTeNotaInfoCTeNormalInfoDocumentosLacre> getLacre() {
        return this.lacre;
    }

    /**
     * Lacres das Unidades de Transporte
     */
    public void setLacre(final List<CTeNotaInfoCTeNormalInfoDocumentosLacre> lacre) {
        this.lacre = lacre;
    }

    public List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> getInfoUnidadeCarga() {
        return this.infoUnidadeCarga;
    }

    /**
     * Informações das Unidades de Carga (Containeres/ULD/Outros)<br>
     * Dispositivo de carga utilizada (Unit Load Device - ULD) significa todo tipo de contêiner de carga, vagão, contêiner de avião, palete de aeronave com rede ou palete de aeronave com rede sobre um iglu.
     */
    public void setInfoUnidadeCarga(final List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> infoUnidadeCarga) {
        this.infoUnidadeCarga = infoUnidadeCarga;
    }

    public String getQuantidadeRateada() {
        return this.quantidadeRateada;
    }

    /**
     * Quantidade rateada (Peso,Volume)
     */
    public void setQuantidadeRateada(final BigDecimal quantidadeRateada) {
        this.quantidadeRateada = DFBigDecimalValidador.tamanho5Com2CasasDecimais(quantidadeRateada, "Quantidade rateada (Peso,Volume)");
    }
}
