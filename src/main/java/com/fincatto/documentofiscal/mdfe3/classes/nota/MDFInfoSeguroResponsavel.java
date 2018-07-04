package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoResponsavelSeguro;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 07/12/17.
 * <h1>Informações do responsável pelo seguro da carga</h1>
 */
@Root(name = "infResp")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoSeguroResponsavel extends DFBase {
    private static final long serialVersionUID = -7502457926490945458L;

    private static final String INFO = "Responsável pelo seguro da carga";

    @Element(name = "respSeg")
    private MDFTipoResponsavelSeguro responsavelSeguro;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * Número do CNPJ do responsável pelo seguro<br>
     * Obrigatório apenas se responsável pelo seguro for (2) responsável pela contratação do transporte - pessoa jurídica
     */
    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao deve setar CNPJ se CPF esteja setado em " + MDFInfoSeguroResponsavel.INFO);
        }
        this.cnpj = StringValidador.cnpj(cnpj, MDFInfoSeguroResponsavel.INFO);
    }

    public String getCpf() {
        return this.cpf;
    }

    /**
     * Número do CPF do responsável pelo seguro<br>
     * Obrigatório apenas se responsável pelo seguro for (2) responsável pela contratação do transporte - pessoa física
     */
    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao deve setar CPF se CNPJ esteja setado em " + MDFInfoSeguroResponsavel.INFO);
        }
        this.cpf = StringValidador.cpf(cpf, MDFInfoSeguroResponsavel.INFO);
    }

    public MDFTipoResponsavelSeguro getResponsavelSeguro() {
        return this.responsavelSeguro;
    }

    public void setResponsavelSeguro(final MDFTipoResponsavelSeguro responsavelSeguro) {
        this.responsavelSeguro = responsavelSeguro;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        // Valida regra : Obrigatório apenas se responsável pelo seguro for (2) responsável pela contratação do transporte.
        if (StringUtils.isBlank(this.getCnpj()) && StringUtils.isBlank(this.getCpf()) && this.getResponsavelSeguro().equals(MDFTipoResponsavelSeguro.CONTRATANTE_MDFE)) {
            throw new IllegalStateException("Obrigatório CPF ou CNPJ do responsável pelo seguro para (2) responsável pela contratação do transporte.");
        }
        return super.toString();
    }
}
