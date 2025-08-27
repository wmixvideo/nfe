package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Preenchido quando for transporte de produtos classificados pela ONU como perigosos.<br>
 *       O preenchimento desses campos não desobriga a empresa aérea de emitir os demais documentos que constam na legislação vigente.
 */

@Root(name = "peri")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalAereoTransportePerigoso extends DFBase {
    private static final long serialVersionUID = -9152807452137411455L;

    @Element(name = "nONU")
    private String onu;
    
    @Element(name = "qTotEmb")
    private String quantidadeTotal;
    
    @Element(name = "infTotAP")
    private CTeNotaInfoCTeNormalInfoModalAereoTransportePerigosoInfo info;

    public String getOnu() {
        return this.onu;
    }

    /**
     * Número ONU/UN<br>
     * Ver a legislação de transporte de produtos perigosos aplicadas ao modal
     */
    public void setOnu(final String onu) {
        DFStringValidador.exatamente4(onu, "Número ONU/UN");
        this.onu = onu;
    }

    public String getQuantidadeTotal() {
        return this.quantidadeTotal;
    }

    /**
     * Quantidade total de volumes contendo artigos perigosos<br>
     * Preencher com o número de volumes (unidades) de artigos perigosos, ou seja, cada embalagem devidamente marcada e etiquetada (por ex.: número de caixas, de tambores, de bombonas, dentre outros). Não deve ser preenchido com o número de ULD, pallets ou containers.
     */
    public void setQuantidadeTotal(final String quantidadeTotal) {
        DFStringValidador.tamanho20(quantidadeTotal, "Quantidade total de volumes contendo artigos perigosos");
        this.quantidadeTotal = quantidadeTotal;
    }

    public CTeNotaInfoCTeNormalInfoModalAereoTransportePerigosoInfo getInfo() {
        return this.info;
    }

    /**
     * Grupo de informações das quantidades totais de artigos perigosos<br>
     * Preencher conforme a legislação de transporte de produtos perigosos aplicada ao modal
     */
    public void setInfo(final CTeNotaInfoCTeNormalInfoModalAereoTransportePerigosoInfo info) {
        this.info = info;
    }
}
