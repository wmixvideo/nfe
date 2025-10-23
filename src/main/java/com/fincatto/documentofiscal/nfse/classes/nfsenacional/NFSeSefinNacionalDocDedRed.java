
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

import javax.xml.datatype.XMLGregorianCalendar;

@Root(name = "DocDedRed")
public class NFSeSefinNacionalDocDedRed {

    protected String chNFSe;
    protected String chNFe;
    @Element(name = "NFSeMun", required = false)
    protected NFSeSefinNacionalDocOutNFSe nfSeMun;
    @Element(name = "NFNFS", required = false)
    protected NFSeSefinNacionalDocNFNFS nfnfs;
    protected String nDocFisc;
    protected String nDoc;
    @Element(required = true)
    protected String tpDedRed;
    protected String xDescOutDed;
    @Element(required = true)
    protected XMLGregorianCalendar dtEmiDoc;
    @Element(required = true)
    protected String vDedutivelRedutivel;
    @Element(required = true)
    protected String vDeducaoReducao;
    protected NFSeSefinNacionalInfoPessoa fornec;

    public String getChNFSe() {
        return chNFSe;
    }

    public void setChNFSe(String value) {
        this.chNFSe = value;
    }

    public String getChNFe() {
        return chNFe;
    }

    public void setChNFe(String value) {
        this.chNFe = value;
    }

    public NFSeSefinNacionalDocOutNFSe getNFSeMun() {
        return nfSeMun;
    }

    public void setNFSeMun(NFSeSefinNacionalDocOutNFSe value) {
        this.nfSeMun = value;
    }

    public NFSeSefinNacionalDocNFNFS getNFNFS() {
        return nfnfs;
    }

    public void setNFNFS(NFSeSefinNacionalDocNFNFS value) {
        this.nfnfs = value;
    }

    public String getNDocFisc() {
        return nDocFisc;
    }

    public void setNDocFisc(String value) {
        this.nDocFisc = value;
    }

    public String getNDoc() {
        return nDoc;
    }

    public void setNDoc(String value) {
        this.nDoc = value;
    }

    public String getTpDedRed() {
        return tpDedRed;
    }

    public void setTpDedRed(String value) {
        this.tpDedRed = value;
    }

    public String getXDescOutDed() {
        return xDescOutDed;
    }

    public void setXDescOutDed(String value) {
        this.xDescOutDed = value;
    }

    public XMLGregorianCalendar getDtEmiDoc() {
        return dtEmiDoc;
    }

    public void setDtEmiDoc(XMLGregorianCalendar value) {
        this.dtEmiDoc = value;
    }

    public String getVDedutivelRedutivel() {
        return vDedutivelRedutivel;
    }

    public void setVDedutivelRedutivel(String value) {
        this.vDedutivelRedutivel = value;
    }

    public String getVDeducaoReducao() {
        return vDeducaoReducao;
    }

    public void setVDeducaoReducao(String value) {
        this.vDeducaoReducao = value;
    }

    public NFSeSefinNacionalInfoPessoa getFornec() {
        return fornec;
    }

    public void setFornec(NFSeSefinNacionalInfoPessoa value) {
        this.fornec = value;
    }

}
