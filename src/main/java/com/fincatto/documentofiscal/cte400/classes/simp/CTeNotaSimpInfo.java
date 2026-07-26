package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoAutorizacaoDownload;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoCTeNormalCobranca;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoCTeNormalInfoCarga;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoCTeNormalInfoModal;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoEmitente;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoInformacoesRelativasImpostos;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNotaInfoResponsavelTecnico;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Informações do CT-e Simplificado (grupo infCte). A ordem dos elementos segue o
 * XSD cteSimp_v4.00.xsd. Reaproveita os grupos comuns ao CT-e normal (emit,
 * infCarga, infModal, imp, cobr, autXML, infRespTec) e traz o próprio grupo det.
 */
@Root(name = "infCte")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfo extends DFBase {
    public static final String IDENT = "CTe";
    private static final long serialVersionUID = 1L;

    @Attribute(name = "Id")
    private String id;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "ide")
    private CTeNotaSimpInfoIdentificacao ide;

    @Element(name = "emit")
    private CTeNotaInfoEmitente emit;

    @Element(name = "toma")
    private CTeNotaSimpInfoTomador toma;

    @Element(name = "infCarga")
    private CTeNotaInfoCTeNormalInfoCarga infCarga;

    @ElementList(name = "det", inline = true)
    private List<CTeNotaSimpInfoDet> det;

    @Element(name = "infModal")
    private CTeNotaInfoCTeNormalInfoModal infModal;

    @Element(name = "cobr", required = false)
    private CTeNotaInfoCTeNormalCobranca cobr;

    @Element(name = "imp")
    private CTeNotaInfoInformacoesRelativasImpostos imp;

    @Element(name = "total")
    private CTeNotaSimpInfoTotal total;

    @ElementList(name = "autXML", inline = true, required = false)
    private List<CTeNotaInfoAutorizacaoDownload> autXML;

    @Element(name = "infRespTec", required = false)
    private CTeNotaInfoResponsavelTecnico infRespTec;

    public String getId() {
        return this.id;
    }

    /**
     * Identificador da tag a ser assinada. Informar a chave de acesso do CT-e,
     * precedida do literal "CTe".
     */
    public void setId(final String id) {
        DFStringValidador.exatamente44(id, "Identificador");
        this.id = CTeNotaSimpInfo.IDENT + id;
    }

    /**
     * Chave de acesso a partir do identificador.
     */
    public String getChaveAcesso() {
        return this.id.replace(CTeNotaSimpInfo.IDENT, "");
    }

    public String getVersao() {
        return this.versao;
    }

    /**
     * Versão do leiaute
     */
    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public CTeNotaSimpInfoIdentificacao getIde() {
        return this.ide;
    }

    public void setIde(final CTeNotaSimpInfoIdentificacao ide) {
        this.ide = ide;
    }

    public CTeNotaInfoEmitente getEmit() {
        return this.emit;
    }

    public void setEmit(final CTeNotaInfoEmitente emit) {
        this.emit = emit;
    }

    public CTeNotaSimpInfoTomador getToma() {
        return this.toma;
    }

    public void setToma(final CTeNotaSimpInfoTomador toma) {
        this.toma = toma;
    }

    public CTeNotaInfoCTeNormalInfoCarga getInfCarga() {
        return this.infCarga;
    }

    public void setInfCarga(final CTeNotaInfoCTeNormalInfoCarga infCarga) {
        this.infCarga = infCarga;
    }

    public List<CTeNotaSimpInfoDet> getDet() {
        return this.det;
    }

    /**
     * Detalhamento das entregas / prestações (1 a 999 itens).
     */
    public void setDet(final List<CTeNotaSimpInfoDet> det) {
        DFListValidador.tamanho990(det, "Detalhamento das prestacoes (det)");
        this.det = det;
    }

    public CTeNotaInfoCTeNormalInfoModal getInfModal() {
        return this.infModal;
    }

    public void setInfModal(final CTeNotaInfoCTeNormalInfoModal infModal) {
        this.infModal = infModal;
    }

    public CTeNotaInfoCTeNormalCobranca getCobr() {
        return this.cobr;
    }

    public void setCobr(final CTeNotaInfoCTeNormalCobranca cobr) {
        this.cobr = cobr;
    }

    public CTeNotaInfoInformacoesRelativasImpostos getImp() {
        return this.imp;
    }

    public void setImp(final CTeNotaInfoInformacoesRelativasImpostos imp) {
        this.imp = imp;
    }

    public CTeNotaSimpInfoTotal getTotal() {
        return this.total;
    }

    public void setTotal(final CTeNotaSimpInfoTotal total) {
        this.total = total;
    }

    public List<CTeNotaInfoAutorizacaoDownload> getAutXML() {
        return this.autXML;
    }

    public void setAutXML(final List<CTeNotaInfoAutorizacaoDownload> autXML) {
        DFListValidador.tamanho10(autXML, "Autorizados para download do XML do DF-e");
        this.autXML = autXML;
    }

    public CTeNotaInfoResponsavelTecnico getInfRespTec() {
        return this.infRespTec;
    }

    public void setInfRespTec(final CTeNotaInfoResponsavelTecnico infRespTec) {
        this.infRespTec = infRespTec;
    }
}
