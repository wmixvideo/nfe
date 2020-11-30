package com.fincatto.documentofiscal.nfe400.classes.evento.epec;

import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;


public class NFDestinatarioEpec {

	@Element(name = "UF", required = true)
	protected String ufDestinatario;

	@Element(name = "CNPJ", required = false)
	protected String cnpj;

	@Element(name = "CPF", required = false)
	protected String cpf;

	@Element(name = "idEstrangeiro", required = false)
	protected String idEstrangeiro;

	@Element(name = "IE", required = false)
	protected String inscricaoEstadualDestinatario;

	@Element(name = "vNF", required = true)
	protected String valorTotalNFe;

	@Element(name = "vICMS", required = true)
	protected String valorTotalIcms;

	@Element(name = "vST", required = true)
	protected String valorTotalIcmsSubstituicaoTributaria;

	public String getUfDestinatario() {
		return ufDestinatario;
	}

	public void setUfDestinatario(String ufDestinatario) {
		this.ufDestinatario = ufDestinatario;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if (this.cpf != null) {
            throw new IllegalStateException("CPF ja foi setado");
        }
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (this.cnpj != null) {
            throw new IllegalStateException("CNPJ ja foi setado");
        }
        DFStringValidador.cpf(cpf);
        this.cpf = cpf;
	}

	public String getIdEstrangeiro() {
		return idEstrangeiro;
	}

	public void setIdEstrangeiro(String idEstrangeiro) {
		this.idEstrangeiro = idEstrangeiro;
	}

	public String getInscricaoEstadualDestinatario() {
		return inscricaoEstadualDestinatario;
	}

	public void setInscricaoEstadualDestinatario(String inscricaoEstadualDestinatario) {
		this.inscricaoEstadualDestinatario = inscricaoEstadualDestinatario;
	}

	public String getValorTotalNFe() {
		return valorTotalNFe;
	}

	public void setValorTotalNFe(String valorTotalNFe) {
		this.valorTotalNFe = valorTotalNFe;
	}

	public String getValorTotalIcms() {
		return valorTotalIcms;
	}

	public void setValorTotalIcms(String valorTotalIcms) {
		this.valorTotalIcms = valorTotalIcms;
	}

	public String getValorTotalIcmsSubstituicaoTributaria() {
		return valorTotalIcmsSubstituicaoTributaria;
	}

	public void setValorTotalIcmsSubstituicaoTributaria(String valorTotalIcmsSubstituicaoTributaria) {
		this.valorTotalIcmsSubstituicaoTributaria = valorTotalIcmsSubstituicaoTributaria;
	}

}
