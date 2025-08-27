package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTTipoDocumentoTransporteAnterior;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.LocalDate;

/**
 * Documentos de transporte anterior em papel
 */

@Root(name = "idDocAntPap")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoPapel extends DFBase {
    private static final long serialVersionUID = 7009143608463603051L;

    @Element(name = "tpDoc")
    private CTTipoDocumentoTransporteAnterior tipoDocumentoAnterior;
    
    @Element(name = "serie")
    private String serie;

    @Element(name = "subser", required = false)
    private String subSerie;
    
    @Element(name = "nDoc")
    private String numeroDocumento;
    
    @Element(name = "dEmi")
    private LocalDate dataEmissao;

    public CTTipoDocumentoTransporteAnterior getTipoDocumentoAnterior() {
        return this.tipoDocumentoAnterior;
    }

    /**
     * Tipo do Documento de Transporte Anterior<br>
     * 07-ATRE;<br>
     * 08-DTA (Despacho de Transito Aduaneiro);<br>
     * 09-Conhecimento Aéreo Internacional;<br>
     * 10 – Conhecimento - Carta de Porte Internacional;<br>
     * 11 – Conhecimento Avulso;<br>
     * 12-TIF (Transporte Internacional Ferroviário);<br>
     * 13-BL (Bill of Lading)
     */
    public void setTipoDocumentoAnterior(final CTTipoDocumentoTransporteAnterior tipoDocumentoAnterior) {
        this.tipoDocumentoAnterior = tipoDocumentoAnterior;
    }

    public String getSerie() {
        return this.serie;
    }

    /**
     * Série do Documento Fiscal
     */
    public void setSerie(final String serie) {
        DFStringValidador.tamanho3N(serie, "Série do Documento Fiscal");
        this.serie = serie;
    }

    public String getSubSerie() {
        return this.subSerie;
    }

    /**
     * Série do Documento Fiscal
     */
    public void setSubSerie(final String subSerie) {
        DFStringValidador.tamanho2N(subSerie, "Série do Documento Fiscal");
        this.subSerie = subSerie;
    }

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    /**
     * Número do Documento Fiscal
     */
    public void setNumeroDocumento(final String numeroDocumento) {
        DFStringValidador.tamanho30(numeroDocumento, "Número do Documento Fiscal");
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    /**
     * Data de emissão (AAAA-MM-DD)
     */
    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
