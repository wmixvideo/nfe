package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Emissor do documento anterior
 */

@Root(name = "emiDocAnt")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnteriores extends DFBase {
    private static final long serialVersionUID = 3034493410870217655L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;
    
    @Element(name = "IE", required = false)
    private String inscricaoEstadual;
    
    @Element(name = "UF", required = false)
    private String siglaUF;
    
    @Element(name = "xNome")
    private String razaoSocial;

    @ElementList(name = "idDocAnt", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao> identificacaoDocumentosAnteriores;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * Número do CNPJ<br>
     * Em caso de empresa não estabelecida no Brasil, será informado o CNPJ com zeros.Informar os zeros não significativos.
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
     * Inscrição Estadual
     */
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        DFStringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getSiglaUF() {
        return this.siglaUF;
    }

    /**
     * Sigla da UF<br>
     * Informar EX para operações com o exterior.
     */
    public void setSiglaUF(final String siglaUF) {
        DFStringValidador.exatamente2(siglaUF, "Sigla da UF");
        this.siglaUF = siglaUF;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Razão Social ou Nome do expedidor
     */
    public void setRazaoSocial(final String razaoSocial) {
        DFStringValidador.tamanho60(razaoSocial, "Razão Social ou Nome do expedidor");
        this.razaoSocial = razaoSocial;
    }

    public List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao> getIdentificacaoDocumentosAnteriores() {
        return this.identificacaoDocumentosAnteriores;
    }

    /**
     * Informações de identificação dos documentos de Transporte Anterior
     */
    public void setIdentificacaoDocumentosAnteriores(final List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacao> identificacaoDocumentosAnteriores) {
        DFListValidador.tamanho2(identificacaoDocumentosAnteriores, "Informações de identificação dos documentos de Transporte Anterior");
        this.identificacaoDocumentosAnteriores = identificacaoDocumentosAnteriores;
    }
}
