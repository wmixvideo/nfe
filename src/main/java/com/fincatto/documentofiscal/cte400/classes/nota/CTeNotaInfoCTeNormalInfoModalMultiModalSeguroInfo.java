package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Informações da seguradora
 */

@Root(name = "infSeg")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalMultiModalSeguroInfo extends DFBase {
    private static final long serialVersionUID = 1179418786084460609L;

    @Element(name = "xSeg")
    private String seguradora;
    
    @Element(name = "CNPJ")
    private String cnpj;

    public String getSeguradora() {
        return this.seguradora;
    }

    /**
     * Nome da Seguradora
     */
    public void setSeguradora(final String seguradora) {
        DFStringValidador.tamanho30(seguradora, "Nome da Seguradora");
        this.seguradora = seguradora;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * Número do CNPJ da seguradora<br>
     * Obrigatório apenas se responsável pelo seguro for (2) responsável pela contratação do transporte - pessoa jurídica
     */
    public void setCnpj(final String cnpj) {
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }
}
