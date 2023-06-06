package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.LocalDate;
import java.util.List;

/**
 * Informações das NF-e
 */

@Root(name = "infNFe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoDocumentosInfoNFe extends DFBase {
    private static final long serialVersionUID = -5021595944749821835L;

    @Element(name = "chave")
    private String chave;

    @Element(name = "PIN", required = false)
    private String pinSUFRAMA;

    @Element(name = "dPrev", required = false)
    private LocalDate dataPrevistaEntrega;

    @ElementList(name = "infUnidCarga", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> infoUnidCarga;

    @ElementList(name = "infUnidTransp", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte> infoUnidTransporte;

    public String getChave() {
        return this.chave;
    }

    /**
     * Chave de acesso da NF-e
     */
    public void setChave(final String chave) {
        DFStringValidador.exatamente44N(chave, "Chave de acesso da NF-e");
        this.chave = chave;
    }

    public String getPinSUFRAMA() {
        return this.pinSUFRAMA;
    }

    /**
     * PIN SUFRAMA<br>
     * PIN atribuído pela SUFRAMA para a operação.
     */
    public void setPinSUFRAMA(final String pinSUFRAMA) {
        DFStringValidador.tamanho2a9N(pinSUFRAMA, "PIN SUFRAMA");
        this.pinSUFRAMA = pinSUFRAMA;
    }

    public LocalDate getDataPrevistaEntrega() {
        return this.dataPrevistaEntrega;
    }

    /**
     * Data prevista de entrega<br>
     * Formato AAAA-MM-DD
     */
    public void setDataPrevistaEntrega(final LocalDate dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> getInfoUnidCarga() {
        return this.infoUnidCarga;
    }

    /**
     * Informações das Unidades de Carga (Containeres/ULD/Outros)<br>
     * Dispositivo de carga utilizada (Unit Load Device - ULD) significa todo tipo de contêiner de carga, vagão, contêiner de avião, palete de aeronave com rede ou palete de aeronave com rede sobre um iglu.
     */
    public void setInfoUnidCarga(final List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga> infoUnidCarga) {
        this.infoUnidCarga = infoUnidCarga;
    }

    public List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte> getInfoUnidTransp() {
        return this.infoUnidTransporte;
    }

    /**
     * Informações das Unidades de Transporte (Carreta/Reboque/Vagão)<br>
     * Deve ser preenchido com as informações das unidades de transporte utilizadas.
     */
    public void setInfoUnidTransp(final List<CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeTransporte> infoUnidTransp) {
        this.infoUnidTransporte = infoUnidTransp;
    }
}
