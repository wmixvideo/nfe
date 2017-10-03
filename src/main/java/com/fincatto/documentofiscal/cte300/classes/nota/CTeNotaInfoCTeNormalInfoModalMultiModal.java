package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTIndicadoNegociavel;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações do Multimodal
 */

@Root(name = "multimodal")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalMultiModal extends DFBase {
    private static final long serialVersionUID = 2648942154476837763L;

    @Element(name = "COTM", required = true)
    private String numeroCertificado;

    @Element(name = "indNegociavel", required = true)
    private CTIndicadoNegociavel indicadorNegociavel;

    @Element(name = "seg", required = false)
    private CTeNotaInfoCTeNormalInfoModalMultiModalSeguro seguro;

    public CTeNotaInfoCTeNormalInfoModalMultiModal() {
        this.numeroCertificado = null;
        this.indicadorNegociavel = null;
        this.seguro = null;
    }

    public String getNumeroCertificado() {
        return this.numeroCertificado;
    }

    /**
     * Número do Certificado do Operador de Transporte Multimodal
     */
    public void setNumeroCertificado(final String numeroCertificado) {
        StringValidador.tamanho20(numeroCertificado, "Número do Certificado do Operador de Transporte Multimodal");
        this.numeroCertificado = numeroCertificado;
    }

    public CTIndicadoNegociavel getIndicadorNegociavel() {
        return this.indicadorNegociavel;
    }

    /**
     * Indicador Negociável Preencher com: 0 - Não Negociável; 1 - Negociável
     */
    public void setIndicadorNegociavel(final CTIndicadoNegociavel indicadorNegociavel) {
        this.indicadorNegociavel = indicadorNegociavel;
    }

    public CTeNotaInfoCTeNormalInfoModalMultiModalSeguro getSeguro() {
        return this.seguro;
    }

    /**
     * Informações de Seguro do Multimodal
     */
    public void setSeguro(final CTeNotaInfoCTeNormalInfoModalMultiModalSeguro seguro) {
        this.seguro = seguro;
    }
}
