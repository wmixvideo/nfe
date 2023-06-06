package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.LocalDate;

/**
 * Ordens de Coleta associados
 */

@Root(name = "occ")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas extends DFBase {
    private static final long serialVersionUID = 2398985559538275925L;

    @Element(name = "serie", required = false)
    private String serie;
    
    @Element(name = "nOcc")
    private String numeroOrdemColeta;
    
    @Element(name = "dEmi")
    private LocalDate dataEmissao;
    
    @Element(name = "emiOcc")
    private CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi ordemColetaAssociadasEmi;

    public String getSerie() {
        return this.serie;
    }

    /**
     * Série da OCC
     */
    public void setSerie(final String serie) {
        DFStringValidador.tamanho3(serie, "Série da OCC");
        this.serie = serie;
    }

    public String getNumeroOrdemColeta() {
        return this.numeroOrdemColeta;
    }

    /**
     * Número da Ordem de coleta
     */
    public void setNumeroOrdemColeta(final String numeroOrdemColeta) {
        DFStringValidador.tamanho6N(numeroOrdemColeta, "Número da Ordem de coleta");
        this.numeroOrdemColeta = numeroOrdemColeta;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    /**
     * Data de emissão da ordem de coleta<br>
     * Formato AAAA-MM-DD
     */
    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi getOrdemColetaAssociadasEmi() {
        return this.ordemColetaAssociadasEmi;
    }

    /**
     *
     * */
    public void setOrdemColetaAssociadasEmi(final CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi ordemColetaAssociadasEmi) {
        this.ordemColetaAssociadasEmi = ordemColetaAssociadasEmi;
    }
}
