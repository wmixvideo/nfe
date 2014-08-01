package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImposto extends NFBase {

    @Element(name = "ICMS", required = false)
    private NFNotaInfoItemImpostoICMS icms;

    @Element(name = "IPI", required = false)
    private NFNotaInfoItemImpostoIPI ipi;

    @Element(name = "II", required = false)
    private NFNotaInfoItemImpostoImportacao impostoImportacao;

    @Element(name = "ISSQN", required = false)
    private NFNotaInfoItemImpostoISSQN issqn;

    @Element(name = "PIS", required = true)
    private NFNotaInfoItemImpostoPIS pis;

    @Element(name = "PISST", required = false)
    private NFNotaInfoItemImpostoPISST pisst;

    @Element(name = "COFINS", required = true)
    private NFNotaInfoItemImpostoCOFINS cofins;

    @Element(name = "COFINSST", required = false)
    private NFNotaInfoItemImpostoCOFINSST cofinsst;

    public NFNotaInfoItemImposto() {
        this.icms = null;
        this.ipi = null;
        this.impostoImportacao = null;
        this.issqn = null;
        this.pis = null;
        this.pisst = null;
        this.cofins = null;
        this.cofinsst = null;
    }

    public void setIcms(final NFNotaInfoItemImpostoICMS icms) {
        this.icms = icms;
    }

    public void setIpi(final NFNotaInfoItemImpostoIPI ipi) {
        this.ipi = ipi;
    }

    public void setImpostoImportacao(final NFNotaInfoItemImpostoImportacao impostoImportacao) {
        this.impostoImportacao = impostoImportacao;
    }

    public void setIssqn(final NFNotaInfoItemImpostoISSQN issqn) {
        this.issqn = issqn;
    }

    public void setPis(final NFNotaInfoItemImpostoPIS pis) {
        this.pis = pis;
    }

    public void setPisst(final NFNotaInfoItemImpostoPISST pisst) {
        this.pisst = pisst;
    }

    public void setCofins(final NFNotaInfoItemImpostoCOFINS cofins) {
        this.cofins = cofins;
    }

    public void setCofinsst(final NFNotaInfoItemImpostoCOFINSST cofinsst) {
        this.cofinsst = cofinsst;
    }
}