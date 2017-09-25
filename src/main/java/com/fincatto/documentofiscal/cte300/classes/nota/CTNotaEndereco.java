package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Dados do endereço
 * */

public class CTNotaEndereco extends DFBase {

	@Element(name = "xLgr", required = true)
    private String logradouro;
	
	@Element(name = "nro", required = true)
    private String numero;
	
	@Element(name = "xCpl", required = false)
    private String complemento;
	
	@Element(name = "xBairro", required = true)
    private String bairro;
	
	@Element(name = "cMun", required = true)
    private String codigoMunicipio;
	
	@Element(name = "xMun", required = true)
    private String descricaoMunicipio;
	
	@Element(name = "CEP", required = false)
    private String cep;
	
	@Element(name = "UF", required = true)
    private String siglaUF;
	
	@Element(name = "cPais", required = false)
    private String codigoPais;
	
	@Element(name = "xPais", required = false)
    private String descricaoPais;
	
	public CTNotaEndereco() {
		this.logradouro = null;
		this.numero = null;
		this.complemento = null;
		this.bairro = null;
		this.codigoMunicipio = null;
		this.descricaoMunicipio = null;
		this.cep = null;
		this.siglaUF = null;
		this.codigoPais = null;
		this.descricaoPais = null;
	}

	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Logradouro
	 * */
	public void setLogradouro(String logradouro) {
		StringValidador.tamanho2ate60(logradouro, "Logradouro");
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	/**
	 * Número
	 * */
	public void setNumero(String numero) {
		StringValidador.tamanho60(numero, "Número");
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	/**
	 * Complemento
	 * */
	public void setComplemento(String complemento) {
		StringValidador.tamanho60(complemento, "Complemento");
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	/**
	 * Bairro
	 * */
	public void setBairro(String bairro) {
		StringValidador.tamanho2ate60(bairro, "Bairro");
		this.bairro = bairro;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	/**
	 * Código do município (utilizar a tabela do IBGE)<br>
	 * Informar 9999999 para operações com o exterior.
	 * */
	public void setCodigoMunicipio(String codigoMunicipio) {
		StringValidador.exatamente7N(codigoMunicipio, "Código do município");
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getDescricaoMunicipio() {
		return descricaoMunicipio;
	}

	/**
	 * Nome do município<br>
	 * Informar EXTERIOR para operações com o exterior.
	 * */
	public void setDescricaoMunicipio(String descricaoMunicipio) {
		StringValidador.tamanho2ate60(descricaoMunicipio, "Nome do município");
		this.descricaoMunicipio = descricaoMunicipio;
	}

	public String getCep() {
		return cep;
	}

	/**
	 * CEP<br>
	 * Informar os zeros não significativos
	 * */
	public void setCep(String cep) {
		StringValidador.exatamente8N(cep, "CEP");
		this.cep = cep;
	}

	public String getSiglaUF() {
		return siglaUF;
	}

	/**
	 * Sigla da UF<br>
	 * Informar EX para operações com o exterior.
	 * */
	public void setSiglaUF(String siglaUf) {
		StringValidador.exatamente2(siglaUf, "Sigla da UF");
		this.siglaUF = siglaUf;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	/**
	 * Código do país<br>
	 * Utilizar a tabela do BACEN
	 * */
	public void setCodigoPais(String codigoPais) {
		StringValidador.tamanho4N(codigoPais, "Código do país");
		this.codigoPais = codigoPais;
	}

	public String getDescricaoPais() {
		return descricaoPais;
	}

	/**
	 * Nome do país
	 * */
	public void setDescricaoPais(String descricaoPais) {
		StringValidador.tamanho2ate60(descricaoPais, "Nome do país");
		this.descricaoPais = descricaoPais;
	}
}
