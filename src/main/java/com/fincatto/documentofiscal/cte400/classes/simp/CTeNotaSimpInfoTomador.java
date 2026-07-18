package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTIndicadorTomador;
import com.fincatto.documentofiscal.cte400.classes.CTTomadorServico;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaEndereco;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Identificação do tomador do serviço no CT-e Simplificado (grupo toma).
 * Diferente do CT-e normal: o tomador pode ser qualquer papel (0 a 4) e o
 * indicador de inscrição estadual (indIEToma) é informado dentro deste grupo.
 */
@Root(name = "toma")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoTomador extends DFBase {
    private static final long serialVersionUID = 1L;

    @Element(name = "toma")
    private CTTomadorServico toma;

    @Element(name = "indIEToma")
    private CTIndicadorTomador indIEToma;

    @Element(name = "CNPJ", required = false)
    private String CNPJ;

    @Element(name = "CPF", required = false)
    private String CPF;

    @Element(name = "IE", required = false)
    private String IE;

    @Element(name = "xNome")
    private String xNome;

    @Element(name = "ISUF", required = false)
    private String ISUF;

    @Element(name = "fone", required = false)
    private String fone;

    @Element(name = "enderToma")
    private CTeNotaEndereco enderToma;

    @Element(name = "email", required = false)
    private String email;

    public CTTomadorServico getToma() {
        return this.toma;
    }

    /**
     * Tomador do Serviço. Preencher com: 0-Remetente; 1-Expedidor; 2-Recebedor;
     * 3-Destinatário; 4-Terceiro.
     */
    public void setToma(final CTTomadorServico toma) {
        this.toma = toma;
    }

    public CTIndicadorTomador getIndIEToma() {
        return this.indIEToma;
    }

    /**
     * Indicador do papel do tomador na prestação do serviço: 1 - Contribuinte ICMS;
     * 2 - Contribuinte isento de inscrição; 9 - Não Contribuinte.
     */
    public void setIndIEToma(final CTIndicadorTomador indIEToma) {
        this.indIEToma = indIEToma;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }

    /**
     * Número do CNPJ do tomador. Informar os zeros não significativos.
     */
    public void setCNPJ(final String CNPJ) {
        DFStringValidador.cnpj(CNPJ);
        this.CNPJ = CNPJ;
    }

    public String getCPF() {
        return this.CPF;
    }

    /**
     * Número do CPF do tomador. Informar os zeros não significativos.
     */
    public void setCPF(final String CPF) {
        DFStringValidador.cpf(CPF);
        this.CPF = CPF;
    }

    public String getIE() {
        return this.IE;
    }

    /**
     * Inscrição Estadual do tomador (ou ISENTO).
     */
    public void setIE(final String IE) {
        DFStringValidador.inscricaoEstadual(IE);
        this.IE = IE;
    }

    public String getXNome() {
        return this.xNome;
    }

    /**
     * Razão Social ou Nome do tomador
     */
    public void setXNome(final String xNome) {
        DFStringValidador.tamanho2ate60(xNome, "Razão Social ou Nome do tomador");
        this.xNome = xNome;
    }

    public String getISUF() {
        return this.ISUF;
    }

    /**
     * Inscrição na SUFRAMA (obrigatório nas operações com áreas de incentivos fiscais).
     */
    public void setISUF(final String ISUF) {
        this.ISUF = ISUF;
    }

    public String getFone() {
        return this.fone;
    }

    /**
     * Telefone do tomador
     */
    public void setFone(final String fone) {
        DFStringValidador.telefone(fone);
        this.fone = fone;
    }

    public CTeNotaEndereco getEnderToma() {
        return this.enderToma;
    }

    /**
     * Dados do endereço do tomador
     */
    public void setEnderToma(final CTeNotaEndereco enderToma) {
        this.enderToma = enderToma;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     * Endereço de email do tomador
     */
    public void setEmail(final String email) {
        DFStringValidador.tamanho60(email, "Endereço de email do tomador");
        DFStringValidador.email(email);
        this.email = email;
    }
}
