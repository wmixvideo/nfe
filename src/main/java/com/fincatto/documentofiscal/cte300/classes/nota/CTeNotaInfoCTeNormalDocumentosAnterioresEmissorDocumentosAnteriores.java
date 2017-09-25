package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.ListValidador;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Emissor do documento anterior
 * */

@Root(name = "emiDocAnt")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnteriores extends DFBase {

	@Element(name = "CNPJ", required = false)
    private String cnpj;
	
	@Element(name = "CPF", required = false)
    private String cpf;
	
	@Element(name = "IE", required = true)
    private String inscricaoEstadual;
	
	@Element(name = "UF", required = true)
    private String siglaUF;
	
	@Element(name = "xNome", required = true)
    private String razaoSocial;
	
	@Element(name = "idDocAnt", required = false)
    private List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao> identificacaoDocumentosAnteriores;

	public CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnteriores() {
		this.cnpj = null;
		this.cpf = null;
		this.inscricaoEstadual = null;
		this.siglaUF = null;
		this.razaoSocial = null;
		this.identificacaoDocumentosAnteriores = null;
	}

	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Número do CNPJ<br>
	 * Em caso de empresa não estabelecida no Brasil, será informado o CNPJ com zeros.Informar os zeros não significativos.
	 * */
	public void setCnpj(String cnpj) {
		StringValidador.cnpj(cnpj);
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	/**
	 * Número do CPF<br>
	 * Informar os zeros não significativos.
	 * */
	public void setCpf(String cpf) {
		StringValidador.cpf(cpf);
		this.cpf = cpf;
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Razão Social ou Nome do expedidor
	 * */
	public void setRazaoSocial(String razaoSocial) {
		StringValidador.tamanho60(razaoSocial, "Razão Social ou Nome do expedidor");
		this.razaoSocial = razaoSocial;
	}

	public List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao> getIdentificacaoDocumentosAnteriores() {
		return identificacaoDocumentosAnteriores;
	}

	/**
	 * Informações de identificação dos documentos de Transporte Anterior
	 * */
	public void setIdentificacaoDocumentosAnteriores(List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao> identificacaoDocumentosAnteriores) {
		ListValidador.tamanho2(identificacaoDocumentosAnteriores, "Informações de identificação dos documentos de Transporte Anterior");
		this.identificacaoDocumentosAnteriores = identificacaoDocumentosAnteriores;
	}
}
