package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações do Remetente das mercadorias transportadas pelo CT-e<br>
 *       Poderá não ser informado para os CT-e de redespacho intermediário e serviço vinculado a multimodal. Nos demais casos deverá sempre ser informado.
 */

@Root(name = "rem")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoRemetente extends DFBase {
    private static final long serialVersionUID = -6678523041232814382L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "IE", required = false)
    private String inscriacoEstadual;

    @Element(name = "xNome", required = true)
    private String razaosocial;

    @Element(name = "xFant", required = false)
    private String nomeFantasia;

    @Element(name = "fone", required = false)
    private String telefone;

    @Element(name = "enderReme", required = true)
    private CTNotaEndereco endereco;

    @Element(name = "email", required = false)
    private String email;

    public CTeNotaInfoRemetente() {
        this.cnpj = null;
        this.cpf = null;
        this.inscriacoEstadual = null;
        this.razaosocial = null;
        this.nomeFantasia = null;
        this.telefone = null;
        this.endereco = null;
        this.email = null;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * Número do CNPJ<br>
     * Em caso de empresa não estabelecida no Brasil, será informado o CNPJ com zeros. Informar os zeros não significativos.
     */
    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    /**
     * Número do CPF<br>
     * Informar os zeros não significativos.
     */
    public void setCpf(final String cpf) {
        StringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getInscriacoEstadual() {
        return this.inscriacoEstadual;
    }

    /**
     * Inscrição Estadual<br>
     * Informar a IE do remetente ou ISENTO se remetente é contribuinte do ICMS isento de inscrição no cadastro de contribuintes do ICMS. Caso o remetente não seja contribuinte do ICMS não informar a tag.
     */
    public void setInscriacoEstadual(final String inscriacoEstadual) {
        StringValidador.inscricaoEstadual(inscriacoEstadual);
        this.inscriacoEstadual = inscriacoEstadual;
    }

    public String getRazaosocial() {
        return this.razaosocial;
    }

    /**
     * Razão social ou nome do remetente
     */
    public void setRazaosocial(final String razaosocial) {
        StringValidador.tamanho2ate60(razaosocial, "Razão social ou nome do remetente");
        this.razaosocial = razaosocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    /**
     * Nome fantasia
     */
    public void setNomeFantasia(final String nomeFantasia) {
        StringValidador.tamanho2ate60(nomeFantasia, "Nome fantasia");
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Telefone
     */
    public void setTelefone(final String telefone) {
        StringValidador.telefone(telefone);
        this.telefone = telefone;
    }

    public CTNotaEndereco getEndereco() {
        return this.endereco;
    }

    /**
     * Dados do endereço
     */
    public void setEndereco(final CTNotaEndereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     * Endereço de email
     */
    public void setEmail(final String email) {
        StringValidador.tamanho60(email, "Endereço de email");
        this.email = email;
    }
}
