package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Informações do Remetente das mercadorias transportadas pelo CT-e<br>
 *       Poderá não ser informado para os CT-e de redespacho intermediário e serviço vinculado a multimodal. Nos demais casos deverá sempre ser informado.
 */

@Root(name = "rem")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoRemetente extends DFBase {
    private static final long serialVersionUID = -1424864026893852000L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;
    
    @Element(name = "xNome")
    private String razaoSocial;

    @Element(name = "xFant", required = false)
    private String nomeFantasia;

    @Element(name = "fone", required = false)
    private String telefone;
    
    @Element(name = "enderReme")
    private CTeNotaEndereco endereco;

    @Element(name = "email", required = false)
    private String email;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * Número do CNPJ<br>
     * Em caso de empresa não estabelecida no Brasil, será informado o CNPJ com zeros. Informar os zeros não significativos.
     */
    public void setCnpj(final String cnpj) {
        DFStringValidador.cnpj(cnpj);
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
        DFStringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    /**
     * Inscrição Estadual<br>
     * Informar a IE do remetente ou ISENTO se remetente é contribuinte do ICMS isento de inscrição no cadastro de contribuintes do ICMS. Caso o remetente não seja contribuinte do ICMS não informar a tag.
     */
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        DFStringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Razão social ou nome do remetente
     */
    public void setRazaoSocial(final String razaoSocial) {
        DFStringValidador.tamanho2ate60(razaoSocial, "Razão social ou nome do remetente");
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    /**
     * Nome fantasia
     */
    public void setNomeFantasia(final String nomeFantasia) {
        DFStringValidador.tamanho2ate60(nomeFantasia, "Nome fantasia");
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Telefone
     */
    public void setTelefone(final String telefone) {
        DFStringValidador.telefone(telefone);
        this.telefone = telefone;
    }

    public CTeNotaEndereco getEndereco() {
        return this.endereco;
    }

    /**
     * Dados do endereço
     */
    public void setEndereco(final CTeNotaEndereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     * Endereço de email
     */
    public void setEmail(final String email) {
        DFStringValidador.tamanho60(email, "Endereço de email");
        DFStringValidador.email(email);
        this.email = email;
    }
}
