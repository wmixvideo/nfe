package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

/**
 * Detalhamento das entregas / prestações do CT-e Simplificado (grupo det, 1-999).
 */
@Root(name = "det")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoDet extends DFBase {
    private static final long serialVersionUID = 1L;

    @Attribute(name = "nItem")
    private String nItem;

    @Element(name = "cMunIni")
    private String cMunIni;

    @Element(name = "xMunIni")
    private String xMunIni;

    @Element(name = "cMunFim")
    private String cMunFim;

    @Element(name = "xMunFim")
    private String xMunFim;

    @Element(name = "vPrest")
    private String vPrest;

    @Element(name = "vRec")
    private String vRec;

    @ElementList(name = "Comp", inline = true, required = false)
    private List<CTeNotaSimpInfoDetComp> comp;

    @ElementList(name = "infNFe", inline = true, required = false)
    private List<CTeNotaSimpInfoDetInfNFe> infNFe;

    @ElementList(name = "infDocAnt", inline = true, required = false)
    private List<CTeNotaSimpInfoDetInfDocAnt> infDocAnt;

    public String getNItem() {
        return this.nItem;
    }

    /**
     * Número identificador do item agrupador da prestação (1 a 990)
     */
    public void setNItem(final String nItem) {
        this.nItem = nItem;
    }

    public String getCMunIni() {
        return this.cMunIni;
    }

    /**
     * Código do Município de início da prestação (tabela IBGE; 9999999 para o exterior)
     */
    public void setCMunIni(final String cMunIni) {
        DFStringValidador.exatamente7N(cMunIni, "Codigo do Municipio de inicio da prestacao");
        this.cMunIni = cMunIni;
    }

    public String getXMunIni() {
        return this.xMunIni;
    }

    /**
     * Nome do Município do início da prestação ('EXTERIOR' para o exterior)
     */
    public void setXMunIni(final String xMunIni) {
        DFStringValidador.tamanho2ate60(xMunIni, "Nome do Municipio de inicio da prestacao");
        this.xMunIni = xMunIni;
    }

    public String getCMunFim() {
        return this.cMunFim;
    }

    /**
     * Código do Município de término da prestação (tabela IBGE; 9999999 para o exterior)
     */
    public void setCMunFim(final String cMunFim) {
        DFStringValidador.exatamente7N(cMunFim, "Codigo do Municipio de termino da prestacao");
        this.cMunFim = cMunFim;
    }

    public String getXMunFim() {
        return this.xMunFim;
    }

    /**
     * Nome do Município do término da prestação ('EXTERIOR' para o exterior)
     */
    public void setXMunFim(final String xMunFim) {
        DFStringValidador.tamanho2ate60(xMunFim, "Nome do Municipio de termino da prestacao");
        this.xMunFim = xMunFim;
    }

    public String getVPrest() {
        return this.vPrest;
    }

    /**
     * Valor da Prestação do Serviço
     */
    public void setVPrest(final BigDecimal vPrest) {
        this.vPrest = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vPrest, "Valor da Prestacao do Servico");
    }

    public String getVRec() {
        return this.vRec;
    }

    /**
     * Valor a Receber
     */
    public void setVRec(final BigDecimal vRec) {
        this.vRec = DFBigDecimalValidador.tamanho15Com2CasasDecimais(vRec, "Valor a Receber");
    }

    public List<CTeNotaSimpInfoDetComp> getComp() {
        return this.comp;
    }

    public void setComp(final List<CTeNotaSimpInfoDetComp> comp) {
        this.comp = comp;
    }

    public List<CTeNotaSimpInfoDetInfNFe> getInfNFe() {
        return this.infNFe;
    }

    /**
     * Informações das NF-e. Exclusivo com infDocAnt (choice do XSD).
     */
    public void setInfNFe(final List<CTeNotaSimpInfoDetInfNFe> infNFe) {
        this.infNFe = infNFe;
    }

    public List<CTeNotaSimpInfoDetInfDocAnt> getInfDocAnt() {
        return this.infDocAnt;
    }

    /**
     * Documentos anteriores. Exclusivo com infNFe (choice do XSD).
     */
    public void setInfDocAnt(final List<CTeNotaSimpInfoDetInfDocAnt> infDocAnt) {
        this.infDocAnt = infDocAnt;
    }
}
