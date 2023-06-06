package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Informações do Destinatário do CT-e<br>
 *       Só pode ser omitido em caso de redespacho intermediário
 */

@Root(name = "dest")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoDestinatario extends DFBase {
    private static final long serialVersionUID = -8388208444958300851L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;
    
    @Element(name = "xNome")
    private String razaoSocial;

    @Element(name = "fone", required = false)
    private String telefone;

    @Element(name = "ISUF", required = false)
    private String inscricaoSuframa;
    
    @Element(name = "enderDest")
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
     * Informar a IE do destinatário ou ISENTO se destinatário é contribuinte do ICMS isento de inscrição no cadastro de contribuintes do ICMS. Caso o destinatário não seja contribuinte do ICMS não informar o conteúdo.
     */
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        DFStringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Razão Social ou Nome do destinatário
     */
    public void setRazaoSocial(final String razaoSocial) {
        DFStringValidador.tamanho2ate60(razaoSocial, "Razão Social ou Nome do destinatário");
        this.razaoSocial = razaoSocial;
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

    public String getInscricaoSuframa() {
        return this.inscricaoSuframa;
    }

    /**
     * Inscrição na SUFRAMA<br>
     * (Obrigatório nas operações com as áreas com benefícios de incentivos fiscais sob controle da SUFRAMA)
     */
    public void setInscricaoSuframa(final String inscricaoSuframa) {
        DFStringValidador.tamanho8a9N(inscricaoSuframa, "Inscrição na SUFRAMA");
        this.inscricaoSuframa = inscricaoSuframa;
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
