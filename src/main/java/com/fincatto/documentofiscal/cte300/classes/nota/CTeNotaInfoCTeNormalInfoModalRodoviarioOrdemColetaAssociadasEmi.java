package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info 
 * */

@Root(name = "emiOcc")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi extends DFBase{

	@Element(name = "CNPJ", required = true)
    private String cnpj;
	
	@Element(name = "cInt", required = false)
    private String codigoInterno;
	
	@Element(name = "IE", required = true)
    private String inscricaoEstadual;
	
	@Element(name = "UF", required = true)
    private String siglaUF;
	
	@Element(name = "fone", required = false)
    private String telefone;

	public CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi() {
		this.cnpj = null;
		this.codigoInterno = null;
		this.inscricaoEstadual = null;
		this.siglaUF = null;
		this.telefone = null;
	}

	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Número do CNPJ<br>
	 * Informar os zeros não significativos.
	 * */
	public void setCnpj(String cnpj) {
		StringValidador.cnpj(cnpj);
		this.cnpj = cnpj;
	}

	public String getCodigoInterno() {
		return codigoInterno;
	}

	/**
	 * Código interno de uso da transportadora<br>
	 * Uso intermo das transportadoras.
	 * */
	public void setCodigoInterno(String codigoInterno) {
		StringValidador.tamanho10(codigoInterno, "Código interno de uso da transportadora");
		this.codigoInterno = codigoInterno;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	/**
	 * Inscrição Estadual
	 * */
	public void setInscricaoEstadual(String inscricaoEstadual) {
		StringValidador.inscricaoEstadual(inscricaoEstadual);
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getSiglaUF() {
		return siglaUF;
	}

	/**
	 * Sigla da UF<br>
	 * Informar EX para operações com o exterior.
	 * */
	public void setSiglaUF(String siglaUF) {
		StringValidador.exatamente2(siglaUF, "Sigla da UF");
		this.siglaUF = siglaUF;
	}

	public String getTelefone() {
		return telefone;
	}

	/**
	 * Telefone
	 * */
	public void setTelefone(String telefone) {
		StringValidador.telefone(telefone);
		this.telefone = telefone;
	}
}
