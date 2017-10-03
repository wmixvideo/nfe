package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * @author Caio
 * @info Informações relativas ao ICMS
 * */

@Root(name = "ICMS")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoInformacoesRelativasImpostosICMS extends DFBase {

	@Element(name = "ICMS00", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS00 icms00;
	
	@Element(name = "ICMS20", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS20 icms20;
	
	@Element(name = "ICMS45", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS45 icms45;
	
	@Element(name = "ICMS60", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS60 icms60;
	
	@Element(name = "ICMS90", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMS90 icms90;
	
	@Element(name = "ICMSOutraUF", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF icmsOutraUF;
	
	@Element(name = "ICMSSN", required = false)
    private CTeNotaInfoInformacoesRelativasImpostosICMSSN icmssn;

	public CTeNotaInfoInformacoesRelativasImpostosICMS() {
		this.icms00 = null;
		this.icms20 = null;
		this.icms45 = null;
		this.icms60 = null;
		this.icms90 = null;
		this.icmsOutraUF = null;
		this.icmssn = null;
	}

	public CTeNotaInfoInformacoesRelativasImpostosICMS00 getIcms00() {
		return icms00;
	}

	/**
	 * Prestação sujeito à tributação normal do ICMS
	 * */
	public void setIcms00(CTeNotaInfoInformacoesRelativasImpostosICMS00 icms00) {
		this.icms00 = icms00;
	}

	public CTeNotaInfoInformacoesRelativasImpostosICMS20 getIcms20() {
		return icms20;
	}

	/**
	 * Prestação sujeito à tributação com redução de BC do ICMS<
	 * */
	public void setIcms20(CTeNotaInfoInformacoesRelativasImpostosICMS20 icms20) {
		this.icms20 = icms20;
	}

	public CTeNotaInfoInformacoesRelativasImpostosICMS45 getIcms45() {
		return icms45;
	}

	/**
	 * ICMS  Isento, não Tributado ou diferido
	 * */
	public void setIcms45(CTeNotaInfoInformacoesRelativasImpostosICMS45 icms45) {
		this.icms45 = icms45;
	}

	public CTeNotaInfoInformacoesRelativasImpostosICMS60 getIcms60() {
		return icms60;
	}

	/**
	 * Tributação pelo ICMS60 - ICMS cobrado por substituição tributária.Responsabilidade do recolhimento do ICMS atribuído ao tomador ou 3º por ST
	 * */
	public void setIcms60(CTeNotaInfoInformacoesRelativasImpostosICMS60 icms60) {
		this.icms60 = icms60;
	}

	public CTeNotaInfoInformacoesRelativasImpostosICMS90 getIcms90() {
		return icms90;
	}

	/**
	 * ICMS Outros
	 * */
	public void setIcms90(CTeNotaInfoInformacoesRelativasImpostosICMS90 icms90) {
		this.icms90 = icms90;
	}

	public CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF getIcmsOutraUF() {
		return icmsOutraUF;
	}

	/**
	 * ICMS devido à UF de origem da prestação, quando  diferente da UF do emitente
	 * */
	public void setIcmsOutraUF(CTeNotaInfoInformacoesRelativasImpostosICMSOutraUF icmsOutraUF) {
		this.icmsOutraUF = icmsOutraUF;
	}

	public CTeNotaInfoInformacoesRelativasImpostosICMSSN getIcmssn() {
		return icmssn;
	}

	/**
	 * Simples Nacional
	 * */
	public void setIcmssn(CTeNotaInfoInformacoesRelativasImpostosICMSSN icmssn) {
		this.icmssn = icmssn;
	}
}
