package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTomadorServico;
import com.fincatto.documentofiscal.cte300.validadores.StringValidador;

/**
 * @author Caio
 * @info Indicador do "papel" do tomador do serviço no CT-e
 * */

@Root(name = "toma4")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoIdentificacaoTomadorServico4 extends DFBase {

	@Element(name = "toma", required = true)
    private CTTomadorServico tomadorServico;
    
	@Element(name = "CNPJ", required = false)
	private String cnpj;
    
	@Element(name = "CPF", required = false)
    private String cpf;
    
	@Element(name = "IE", required = false)
    private String inscricaoEstadual;
    
	@Element(name = "xNome", required = true)
    private String razaoSocial;
    
	@Element(name = "xFant", required = false)
    private String nomeFantasia;
    
	@Element(name = "fone", required = false)
    private String telefone;
    
	@Element(name = "enderToma", required = true)
    private CTNotaEndereco enderTomadorServico;
    
	@Element(name = "email", required = false)
    private String email;

	public CTeNotaInfoIdentificacaoTomadorServico4() {
		this.tomadorServico = null;
		this.cnpj = null;
		this.cpf = null;
		this.inscricaoEstadual = null;
		this.razaoSocial = null;
		this.nomeFantasia = null;
		this.telefone = null;
		this.enderTomadorServico = null;
		this.email = null;
	}

	public CTTomadorServico getTomadorServico() {
		return tomadorServico;
	}

	/**
	 * Tomador do Serviço<br>
	 * Preencher com:<br>
	 * 4 - Outros<br>
	 * Obs: Informar os dados cadastrais do tomador do serviço
	 * */
	public void setTomadorServico(CTTomadorServico tomadorServico) {
		this.tomadorServico = tomadorServico;
	}

	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Número do CNPJ<br>
	 * Em caso de empresa não estabelecida no Brasil, será informado o CNPJ com zeros. Informar os zeros não significativos.
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
	 * Inscrição Estadual<br>
	 * Informar a IE do tomador ou ISENTO se tomador é contribuinte do ICMS isento de inscrição no cadastro de contribuintes do ICMS. 
	 * Caso o tomador não seja contribuinte do ICMS não informar o conteúdo.
	 * */
	public void setInscricaoEstadual(String inscricaoEstadual) {
		StringValidador.inscricaoEstadual(inscricaoEstadual);
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Razão Social ou Nome
	 * */
	public void setRazaoSocial(String razaoSocial) {
		StringValidador.tamanho2ate60(razaoSocial, "Razão Social ou Nome");
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * Nome Fantasia
	 * */
	public void setNomeFantasia(String nomeFantasia) {
		StringValidador.tamanho2ate60(nomeFantasia, "Nome Fantasia");
		this.nomeFantasia = nomeFantasia;
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

	public CTNotaEndereco getEnderTomadorServico() {
		return enderTomadorServico;
	}

	/**
	 * Dados do endereço
	 * */
	public void setEnderTomadorServico(CTNotaEndereco enderTomadorServico) {
		this.enderTomadorServico = enderTomadorServico;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * Endereço de email
	 * */
	public void setEmail(String email) {
		StringValidador.tamanho60(email, "Endereço de email");
		this.email = email;
	}
}
