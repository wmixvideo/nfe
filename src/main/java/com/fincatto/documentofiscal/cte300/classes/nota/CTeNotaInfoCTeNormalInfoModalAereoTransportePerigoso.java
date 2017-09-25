package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Preenchido quando for  transporte de produtos classificados pela ONU como perigosos.<br>
 * O preenchimento desses campos não desobriga a empresa aérea de emitir os demais documentos que constam na legislação vigente.
 * */

@Root(name = "peri")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalAereoTransportePerigoso extends DFBase {

	@Element(name = "nONU", required = true)
    private String onu;
	
	@Element(name = "qTotEmb", required = true)
    private String quantidadeTotal;
	
	@Element(name = "infTotAP", required = true)
    private CTeNotaInfoCTeNormalInfoModalAereoTransportePerigosoInfo info;

	public CTeNotaInfoCTeNormalInfoModalAereoTransportePerigoso() {
		this.onu = null;
		this.quantidadeTotal = null;
		this.info = null;
	}

	public String getOnu() {
		return onu;
	}

	/**
	 * Número ONU/UN<br>
	 * Ver a legislação de transporte de produtos perigosos aplicadas ao modal
	 * */
	public void setOnu(String onu) {
		StringValidador.exatamente4(onu, "Número ONU/UN");
		this.onu = onu;
	}

	public String getQuantidadeTotal() {
		return quantidadeTotal;
	}

	/**
	 * Quantidade total de volumes contendo artigos perigosos<br>
	 * Preencher com o número de volumes (unidades) de artigos perigosos, ou seja, cada embalagem devidamente marcada e etiquetada (por ex.: número de caixas, de 
	 * tambores, de bombonas, dentre outros). Não deve ser preenchido com o número de ULD, pallets ou containers.
	 * */
	public void setQuantidadeTotal(String quantidadeTotal) {
		StringValidador.tamanho20(quantidadeTotal, "Quantidade total de volumes contendo artigos perigosos");
		this.quantidadeTotal = quantidadeTotal;
	}

	public CTeNotaInfoCTeNormalInfoModalAereoTransportePerigosoInfo getInfo() {
		return info;
	}

	/**
	 * Grupo de informações das quantidades totais de artigos perigosos<br>
	 * Preencher conforme a legislação de transporte de produtos perigosos aplicada ao modal
	 * */
	public void setInfo(CTeNotaInfoCTeNormalInfoModalAereoTransportePerigosoInfo info) {
		this.info = info;
	}
}
