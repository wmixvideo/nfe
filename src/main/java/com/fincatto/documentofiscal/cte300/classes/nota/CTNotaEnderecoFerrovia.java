package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Dados do endereço
 * */

@Root(name = "enderFerro")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTNotaEnderecoFerrovia extends DFBase {

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
	
	public CTNotaEnderecoFerrovia() {
		this.logradouro = null;
		this.numero = null;
		this.complemento = null;
		this.bairro = null;
		this.codigoMunicipio = null;
		this.descricaoMunicipio = null;
		this.cep = null;
		this.siglaUF = null;
	}

	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Logradouro
	 * */
	public void setLogradouro(String logradouro) {
		StringValidador.tamanho2ate60(logradouro, "Logradouro no endereço do Emitente");
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	/**
	 * Número
	 * */
	public void setNumero(String numero) {
		StringValidador.tamanho60(numero, "Número no endereço do Emitente");
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	/**
	 * Complemento
	 * */
	public void setComplemento(String complemento) {
		StringValidador.tamanho60(complemento, "Complemento no endereço do Emitente");
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	/**
	 * Bairro
	 * */
	public void setBairro(String bairro) {
		StringValidador.tamanho2ate60(bairro, "Bairro no endereço do Emitente");
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
		StringValidador.exatamente7N(codigoMunicipio, "Código do município no endereço do Emitente");
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
		StringValidador.tamanho2ate60(descricaoMunicipio, "Nome do município no endereço do Emitente");
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
		StringValidador.exatamente8N(cep, "CEP no endereço do Emitente");
		this.cep = cep;
	}

	public String getSiglaUF() {
		return siglaUF;
	}

	/**
	 * Sigla da UF<br>
	 * Informar EX para operações com o exterior.
	 * */
	public void setSiglaUF(String siglaUF) {
		StringValidador.exatamente2(siglaUF, "Sigla da UF no endereço do Emitente");
		this.siglaUF = siglaUF;
	}
}
