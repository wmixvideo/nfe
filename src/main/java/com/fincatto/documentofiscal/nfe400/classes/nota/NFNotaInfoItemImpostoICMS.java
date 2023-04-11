package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class NFNotaInfoItemImpostoICMS extends DFBase {
    private static final long serialVersionUID = 4231941704888569693L;

    private boolean isSelecionado = false;

    @Element(name = "ICMS00", required = false)
    private NFNotaInfoItemImpostoICMS00 icms00;

    @Element(name = "ICMS02", required = false)
    private NFNotaInfoItemImpostoICMS02 icms02;

    @Element(name = "ICMS10", required = false)
    private NFNotaInfoItemImpostoICMS10 icms10;

    @Element(name = "ICMS15", required = false)
    private NFNotaInfoItemImpostoICMS15 icms15;

    @Element(name = "ICMS20", required = false)
    private NFNotaInfoItemImpostoICMS20 icms20;

    @Element(name = "ICMS30", required = false)
    private NFNotaInfoItemImpostoICMS30 icms30;

    @Element(name = "ICMS40", required = false)
    private NFNotaInfoItemImpostoICMS40 icms40;

    @Element(name = "ICMS51", required = false)
    private NFNotaInfoItemImpostoICMS51 icms51;

    @Element(name = "ICMS53", required = false)
    private NFNotaInfoItemImpostoICMS53 icms53;

    @Element(name = "ICMS60", required = false)
    private NFNotaInfoItemImpostoICMS60 icms60;

    @Element(name = "ICMS61", required = false)
    private NFNotaInfoItemImpostoICMS61 icms61;

    @Element(name = "ICMS70", required = false)
    private NFNotaInfoItemImpostoICMS70 icms70;

    @Element(name = "ICMS90", required = false)
    private NFNotaInfoItemImpostoICMS90 icms90;

    @Element(name = "ICMSPart", required = false)
    private NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado;

    @Element(name = "ICMSST", required = false)
    private NFNotaInfoItemImpostoICMSST icmsst;

    @Element(name = "ICMSSN101", required = false)
    private NFNotaInfoItemImpostoICMSSN101 icmssn101;

    @Element(name = "ICMSSN102", required = false)
    private NFNotaInfoItemImpostoICMSSN102 icmssn102;

    @Element(name = "ICMSSN201", required = false)
    private NFNotaInfoItemImpostoICMSSN201 icmssn201;

    @Element(name = "ICMSSN202", required = false)
    private NFNotaInfoItemImpostoICMSSN202 icmssn202;

    @Element(name = "ICMSSN500", required = false)
    private NFNotaInfoItemImpostoICMSSN500 icmssn500;

    @Element(name = "ICMSSN900", required = false)
    private NFNotaInfoItemImpostoICMSSN900 icmssn900;

    public void setIcms00(final NFNotaInfoItemImpostoICMS00 icms00) {
        this.validaApenasUmSelecionado();
        this.icms00 = icms00;
    }

    public void setIcms02(final NFNotaInfoItemImpostoICMS02 icms02) {
        this.validaApenasUmSelecionado();
        this.icms02 = icms02;
    }

    public void setIcms10(final NFNotaInfoItemImpostoICMS10 icms10) {
        this.validaApenasUmSelecionado();
        this.icms10 = icms10;
    }

    public void setIcms15(final NFNotaInfoItemImpostoICMS15 icms15) {
        this.validaApenasUmSelecionado();
        this.icms15 = icms15;
    }

    public void setIcms20(final NFNotaInfoItemImpostoICMS20 icms20) {
        this.validaApenasUmSelecionado();
        this.icms20 = icms20;
    }

    public void setIcms30(final NFNotaInfoItemImpostoICMS30 icms30) {
        this.validaApenasUmSelecionado();
        this.icms30 = icms30;
    }

    public void setIcms40(final NFNotaInfoItemImpostoICMS40 icms40) {
        this.validaApenasUmSelecionado();
        this.icms40 = icms40;
    }

    public void setIcms51(final NFNotaInfoItemImpostoICMS51 icms51) {
        this.validaApenasUmSelecionado();
        this.icms51 = icms51;
    }

    public void setIcms53(final NFNotaInfoItemImpostoICMS53 icms53) {
        this.validaApenasUmSelecionado();
        this.icms53 = icms53;
    }

    public void setIcms60(final NFNotaInfoItemImpostoICMS60 icms60) {
        this.validaApenasUmSelecionado();
        this.icms60 = icms60;
    }

    public void setIcms61(final NFNotaInfoItemImpostoICMS61 icms61) {
        this.validaApenasUmSelecionado();
        this.icms61 = icms61;
    }

    public void setIcms70(final NFNotaInfoItemImpostoICMS70 icms70) {
        this.validaApenasUmSelecionado();
        this.icms70 = icms70;
    }

    public void setIcms90(final NFNotaInfoItemImpostoICMS90 icms90) {
        this.validaApenasUmSelecionado();
        this.icms90 = icms90;
    }

    public void setIcmsPartilhado(final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado) {
        this.validaApenasUmSelecionado();
        this.icmsPartilhado = icmsPartilhado;
    }

    public void setIcmsst(final NFNotaInfoItemImpostoICMSST icmsst) {
        this.validaApenasUmSelecionado();
        this.icmsst = icmsst;
    }

    public void setIcmssn101(final NFNotaInfoItemImpostoICMSSN101 icmssn101) {
        this.validaApenasUmSelecionado();
        this.icmssn101 = icmssn101;
    }

    public void setIcmssn102(final NFNotaInfoItemImpostoICMSSN102 icmssn102) {
        this.validaApenasUmSelecionado();
        this.icmssn102 = icmssn102;
    }

    public void setIcmssn201(final NFNotaInfoItemImpostoICMSSN201 icmssn201) {
        this.validaApenasUmSelecionado();
        this.icmssn201 = icmssn201;
    }

    public void setIcmssn202(final NFNotaInfoItemImpostoICMSSN202 icmssn202) {
        this.validaApenasUmSelecionado();
        this.icmssn202 = icmssn202;
    }

    public void setIcmssn500(final NFNotaInfoItemImpostoICMSSN500 icmssn500) {
        this.validaApenasUmSelecionado();
        this.icmssn500 = icmssn500;
    }

    public void setIcmssn900(final NFNotaInfoItemImpostoICMSSN900 icmssn900) {
        this.validaApenasUmSelecionado();
        this.icmssn900 = icmssn900;
    }

    private void validaApenasUmSelecionado() {
        if (this.isSelecionado) {
            throw new IllegalStateException("Ja possui ICMS selecionado");
        }
        this.isSelecionado = true;
    }

    public boolean isSelecionado() {
        return this.isSelecionado;
    }

    public NFNotaInfoItemImpostoICMS00 getIcms00() {
        return this.icms00;
    }

    public NFNotaInfoItemImpostoICMS02 getIcms02() {
        return icms02;
    }

    public NFNotaInfoItemImpostoICMS10 getIcms10() {
        return this.icms10;
    }

    public NFNotaInfoItemImpostoICMS15 getIcms15() {
        return icms15;
    }

    public NFNotaInfoItemImpostoICMS20 getIcms20() {
        return this.icms20;
    }

    public NFNotaInfoItemImpostoICMS30 getIcms30() {
        return this.icms30;
    }

    public NFNotaInfoItemImpostoICMS40 getIcms40() {
        return this.icms40;
    }

    public NFNotaInfoItemImpostoICMS51 getIcms51() {
        return this.icms51;
    }

    public NFNotaInfoItemImpostoICMS53 getIcms53() {
        return icms53;
    }

    public NFNotaInfoItemImpostoICMS60 getIcms60() {
        return this.icms60;
    }

    public NFNotaInfoItemImpostoICMS61 getIcms61() {
        return icms61;
    }

    public NFNotaInfoItemImpostoICMS70 getIcms70() {
        return this.icms70;
    }

    public NFNotaInfoItemImpostoICMS90 getIcms90() {
        return this.icms90;
    }

    public NFNotaInfoItemImpostoICMSPartilhado getIcmsPartilhado() {
        return this.icmsPartilhado;
    }

    public NFNotaInfoItemImpostoICMSST getIcmsst() {
        return this.icmsst;
    }

    public NFNotaInfoItemImpostoICMSSN101 getIcmssn101() {
        return this.icmssn101;
    }

    public NFNotaInfoItemImpostoICMSSN102 getIcmssn102() {
        return this.icmssn102;
    }

    public NFNotaInfoItemImpostoICMSSN201 getIcmssn201() {
        return this.icmssn201;
    }

    public NFNotaInfoItemImpostoICMSSN202 getIcmssn202() {
        return this.icmssn202;
    }

    public NFNotaInfoItemImpostoICMSSN500 getIcmssn500() {
        return this.icmssn500;
    }

    public NFNotaInfoItemImpostoICMSSN900 getIcmssn900() {
        return this.icmssn900;
    }
}