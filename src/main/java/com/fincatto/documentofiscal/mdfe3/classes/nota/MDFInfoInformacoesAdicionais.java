package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 06/11/17. Informações do Percurso do MDF-e
 */
public class MDFInfoInformacoesAdicionais extends DFBase {
    private static final long serialVersionUID = -222776103663565452L;

    /**
     * Informações adicionais de interesse do Fisco. Norma referenciada, informações complementares, etc
     */
    @Element(name = "infAdFisco", required = false)
    private String informacoesAdicionaisInteresseFisco;

    @Element(name = "infCpl", required = false)
    private String informacoesComplementaresInteresseContribuinte;

    public void setInformacoesAdicionaisInteresseFisco(final String informacoesAdicionaisInteresseFisco) {
        StringValidador.tamanho2000(informacoesAdicionaisInteresseFisco, "Informacoes Adicionais Interesse Fisco");
        this.informacoesAdicionaisInteresseFisco = informacoesAdicionaisInteresseFisco;
    }

    public void setInformacoesComplementaresInteresseContribuinte(final String informacoesComplementaresInteresseContribuinte) {
        StringValidador.tamanho5000(informacoesComplementaresInteresseContribuinte, "Informacoes Adicionais Interesse Contribuinte");
        this.informacoesComplementaresInteresseContribuinte = informacoesComplementaresInteresseContribuinte;
    }

    public String getInformacoesAdicionaisInteresseFisco() {
        return this.informacoesAdicionaisInteresseFisco;
    }

    public String getInformacoesComplementaresInteresseContribuinte() {
        return this.informacoesComplementaresInteresseContribuinte;
    }

}