package com.fincatto.documentofiscal.cte300.classes.nota;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Ordens de Coleta associados
 */

@Root(name = "occ")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas extends DFBase {
    private static final long serialVersionUID = -7966707206547281783L;

    @Element(name = "serie", required = false)
    private String serie;

    @Element(name = "nOcc", required = true)
    private String numeroOrdemColeta;

    @Element(name = "dEmi", required = true)
    private LocalDate dataEmissao;

    @Element(name = "emiOcc", required = true)
    private CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi ordemColetaAssociadasEmi;

    public CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas() {
        this.serie = null;
        this.numeroOrdemColeta = null;
        this.dataEmissao = null;
        this.ordemColetaAssociadasEmi = null;
    }

    public String getSerie() {
        return this.serie;
    }

    /**
     * Série da OCC
     */
    public void setSerie(final String serie) {
        StringValidador.tamanho3(serie, "Série da OCC");
        this.serie = serie;
    }

    public String getNumeroOrdemColeta() {
        return this.numeroOrdemColeta;
    }

    /**
     * Número da Ordem de coleta
     */
    public void setNumeroOrdemColeta(final String numeroOrdemColeta) {
        StringValidador.tamanho6N(numeroOrdemColeta, "Número da Ordem de coleta");
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
