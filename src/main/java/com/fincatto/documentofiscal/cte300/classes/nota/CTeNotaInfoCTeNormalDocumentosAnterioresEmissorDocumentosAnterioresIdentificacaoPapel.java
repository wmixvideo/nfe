package com.fincatto.documentofiscal.cte300.classes.nota;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoDocumentoTransporteAnterior;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Documentos de transporte anterior em papel
 * */

@Root(name = "idDocAntPap")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoPapel extends DFBase {

	@Element(name = "tpDoc", required = true)
    private CTTipoDocumentoTransporteAnterior tipoDocumentoAnterior;
	
	@Element(name = "serie", required = true)
    private String serie;
	
	@Element(name = "subser", required = false)
    private String subSerie;
	
	@Element(name = "nDoc", required = true)
    private String numeroDocumento;
	
	@Element(name = "dEmi", required = true)
    private LocalDate dataEmissao;

	public CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoPapel() {
		this.tipoDocumentoAnterior = null;
		this.serie = null;
		this.subSerie = null;
		this.numeroDocumento = null;
		this.dataEmissao = null;
	}

	public CTTipoDocumentoTransporteAnterior getTipoDocumentoAnterior() {
		return tipoDocumentoAnterior;
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
	 * */
	public void setTipoDocumentoAnterior(CTTipoDocumentoTransporteAnterior tipoDocumentoAnterior) {
		this.tipoDocumentoAnterior = tipoDocumentoAnterior;
	}

	public String getSerie() {
		return serie;
	}

	/**
	 * Série do Documento Fiscal
	 * */
	public void setSerie(String serie) {
		StringValidador.tamanho3N(serie, "Série do Documento Fiscal");
		this.serie = serie;
	}

	public String getSubSerie() {
		return subSerie;
	}

	/**
	 * Série do Documento Fiscal
	 * */
	public void setSubSerie(String subSerie) {
		StringValidador.tamanho2N(subSerie, "Série do Documento Fiscal");
		this.subSerie = subSerie;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * Número do Documento Fiscal
	 * */
	public void setNumeroDocumento(String numeroDocumento) {
		StringValidador.tamanho30(numeroDocumento, "Número do Documento Fiscal");
		this.numeroDocumento = numeroDocumento;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * Data de emissão (AAAA-MM-DD)
	 * */
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
}
