package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * @author Caio
 * @info Informações do modal
 */

@Root(name = "infModal")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModal extends DFBase {
    private static final long serialVersionUID = -8073539536767730257L;

    // @Element(name = "skip", required = true)
    // private Object any;

    /**
     * verificar como trabalhar com a tag any usando a libe simple-xml para liberar o elemento acima para os modal de transporte rodoviario aereo aquatico ferroviario dutoviario multimodal
     */
    @Element(name = "rodo", required = false)
    private CTeNotaInfoCTeNormalInfoModalRodoviario rodoviario;

    @Element(name = "aereo", required = false)
    private CTeNotaInfoCTeNormalInfoModalAereo aereo;

    @Element(name = "aquav", required = false)
    private CTeNotaInfoCTeNormalInfoModalAquaviario aquaviario;

    @Element(name = "ferrov", required = false)
    private CTeNotaInfoCTeNormalInfoModalFerroviario ferroviario;

    @Element(name = "duto", required = false)
    private CTeNotaInfoCTeNormalInfoModalDutoviario dutoviario;

    @Element(name = "multimodal", required = false)
    private CTeNotaInfoCTeNormalInfoModalMultiModal multiModal;

    @Attribute(name = "versaoModal", required = true)
    private String versao;

    public CTeNotaInfoCTeNormalInfoModal() {
        // this.any = null;
        this.rodoviario = null;
        this.aereo = null;
        this.aquaviario = null;
        this.ferroviario = null;
        this.dutoviario = null;
        this.multiModal = null;

        this.versao = null;
    }

    // public Object getAny() {
    // return any;
    // }

    /*
     * XML do modal Insira neste local o XML específico do modal (rodoviário, aéreo, ferroviário, aquaviário ou dutoviário).<br> O elemento do tipo -any- permite estender o documento XML com elementos não especificados pelo schema. Insira neste local - any- o XML específico do modal (rodoviário, aéreo, ferroviário, aquaviário ou dutoviário). A especificação do schema XML para cada modal pode ser encontrada nos arquivos que acompanham este pacote de liberação:<br> Rodoviário - ver arquivo CTeModalRodoviario_v9.99<br> Aéreo - ver arquivo CTeModalAereo_v9.99<br> Aquaviário - arquivo CTeModalAquaviario_v9.99<br> Ferroviário - arquivo CTeModalFerroviario_v9.99<br> Dutoviário - arquivo CTeModalDutoviario_v9.99<br> Onde v9.99 é a a designação genérica para a versão do arquivo. Por exemplo, o
     * arquivo para o schema do modal Rodoviário na versão 1.04 será denominado "CTeModalRodoviario_v1.04".
     */
    // public void setAny(Object any) {
    // this.any = any;
    // }

    public CTeNotaInfoCTeNormalInfoModalRodoviario getRodoviario() {
        return this.rodoviario;
    }

    public void setRodoviario(final CTeNotaInfoCTeNormalInfoModalRodoviario rodoviario) {
        this.rodoviario = rodoviario;
    }

    public CTeNotaInfoCTeNormalInfoModalAereo getAereo() {
        return this.aereo;
    }

    public void setAereo(final CTeNotaInfoCTeNormalInfoModalAereo aereo) {
        this.aereo = aereo;
    }

    public CTeNotaInfoCTeNormalInfoModalAquaviario getAquaviario() {
        return this.aquaviario;
    }

    public void setAquaviario(final CTeNotaInfoCTeNormalInfoModalAquaviario aquaviario) {
        this.aquaviario = aquaviario;
    }

    public CTeNotaInfoCTeNormalInfoModalFerroviario getFerroviario() {
        return this.ferroviario;
    }

    public void setFerroviario(final CTeNotaInfoCTeNormalInfoModalFerroviario ferroviario) {
        this.ferroviario = ferroviario;
    }

    public CTeNotaInfoCTeNormalInfoModalDutoviario getDutoviario() {
        return this.dutoviario;
    }

    public void setDutoviario(final CTeNotaInfoCTeNormalInfoModalDutoviario dutoviario) {
        this.dutoviario = dutoviario;
    }

    public CTeNotaInfoCTeNormalInfoModalMultiModal getMultiModal() {
        return this.multiModal;
    }

    public void setMultiModal(final CTeNotaInfoCTeNormalInfoModalMultiModal multiModal) {
        this.multiModal = multiModal;
    }

    public String getVersao() {
        return this.versao;
    }

    /**
     * Versão do leiaute específico para o Modal
     */
    public void setVersao(final String versaoModal) {
        this.versao = versaoModal;
    }
}
