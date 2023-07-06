package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;

@Root(name = "refNF")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoCTeSubstituicaoTomadorICMSReferenciaNF extends DFBase {
    private static final long serialVersionUID = -7563695523675903335L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;
    
    @Element(name = "mod")
    private String modelo;
    
    @Element(name = "serie")
    private String serie;

    @Element(name = "subserie", required = false)
    private String subserie;
    
    @Element(name = "nro")
    private String numeroDocumento;
    
    @Element(name = "valor")
    private String valor;
    
    @Element(name = "dEmi")
    private LocalDate dataEmissao;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * CNPJ do Emitente<br>
     * Informar o CNPJ do emitente do Documento Fiscal
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
     * Informar o CPF do emitente do documento fiscal
     */
    public void setCpf(final String cpf) {
        DFStringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getModelo() {
        return this.modelo;
    }

    /**
     * Modelo do Documento Fiscal
     */
    public void setModelo(final String modelo) {
        DFStringValidador.exatamente2(modelo, "Modelo do Documento Fiscal");
        this.modelo = modelo;
    }

    public String getSerie() {
        return this.serie;
    }

    /**
     * Serie do documento fiscal
     */
    public void setSerie(final String serie) {
        DFStringValidador.tamanho3N(serie, "Serie do documento fiscal");
        this.serie = serie;
    }

    public String getSubserie() {
        return this.subserie;
    }

    /**
     * Subserie do documento fiscal
     */
    public void setSubserie(final String subserie) {
        DFStringValidador.tamanho3N(this.serie, "Subserie do documento fiscal");
        this.subserie = subserie;
    }

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    /**
     * Número do documento fiscal
     */
    public void setNumeroDocumento(final String numeroDocumento) {
        DFStringValidador.tamanho6N(numeroDocumento, "Número do documento fiscal");
        this.numeroDocumento = numeroDocumento;
    }

    public String getValor() {
        return this.valor;
    }

    /**
     * Valor do documento fiscal.
     */
    public void setValor(final BigDecimal valor) {
        this.valor = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valor, "Valor do documento fiscal");
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    /**
     * Data de emissão do documento fiscal.
     */
    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
