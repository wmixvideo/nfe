package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class NFNotaInfoItemImposto extends DFBase {
    private static final long serialVersionUID = 8579628067567740408L;

    @Element(name = "vTotTrib", required = false)
    private String valorTotalTributos;

    @Element(name = "ICMS", required = false)
    private NFNotaInfoItemImpostoICMS icms;

    @Element(name = "IPI", required = false)
    private NFNotaInfoItemImpostoIPI ipi;

    @Element(name = "II", required = false)
    private NFNotaInfoItemImpostoImportacao impostoImportacao;

    @Element(name = "ISSQN", required = false)
    private NFNotaInfoItemImpostoISSQN issqn;

    @Element(name = "PIS", required = false)
    private NFNotaInfoItemImpostoPIS pis;

    @Element(name = "PISST", required = false)
    private NFNotaInfoItemImpostoPISST pisst;

    @Element(name = "COFINS", required = false)
    private NFNotaInfoItemImpostoCOFINS cofins;

    @Element(name = "COFINSST", required = false)
    private NFNotaInfoItemImpostoCOFINSST cofinsst;

    @Element(name = "ICMSUFDest", required = false)
    private NFNotaInfoItemImpostoICMSUFDestino icmsUfDestino;
    
    @Element(name = "IS", required = false)
    private NFNotaInfoItemImpostoIS is; // UB01
    
    @Element(name = "IBSCBS", required = false)
    private NFNotaInfoItemImpostoIBSCBS ibsCbs; // UB12

    public void setIcms(final NFNotaInfoItemImpostoICMS icms) {
        if (this.issqn != null) {
            throw new IllegalStateException("ICMS, IPI e II sao mutuamente exclusivo com ISSQN");
        }
        try {
            DFStringValidador.validaPreenchimentoDeMargemValorAgregado(icms);
        }catch (IllegalAccessException e) {
            DFLog.getLogger(NFNotaInfoItemImposto.class)
                    .error("Erro ao validar preenchimento de Margem de Valor agregado", e);
        } catch (InvocationTargetException e) {
            DFLog.getLogger(NFNotaInfoItemImposto.class)
                    .error("Erro ao validar preenchimento de Margem de Valor agregado", e);
        }
        this.icms = icms;
    }

    public void setIpi(final NFNotaInfoItemImpostoIPI ipi) {
        if (this.issqn != null) {
            throw new IllegalStateException("ICMS, IPI e II sao mutuamente exclusivo com ISSQN");
        }
        this.ipi = ipi;
    }

    public void setImpostoImportacao(final NFNotaInfoItemImpostoImportacao impostoImportacao) {
        if (this.issqn != null) {
            throw new IllegalStateException("ICMS, IPI e II sao mutuamente exclusivo com ISSQN");
        }
        this.impostoImportacao = impostoImportacao;
    }

    public void setIssqn(final NFNotaInfoItemImpostoISSQN issqn) {
        if (this.icms != null || this.ipi != null || this.impostoImportacao != null) {
            throw new IllegalStateException("ICMS, IPI e II sao mutuamente exclusivo com ISSQN");
        }
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

    public void setValorTotalTributos(final BigDecimal valorTotalTributos) {
        this.valorTotalTributos = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTotalTributos, "Valor Total Tributos");
    }

    public String getValorTotalTributos() {
        return this.valorTotalTributos;
    }

    public NFNotaInfoItemImpostoICMS getIcms() {
        return this.icms;
    }

    public NFNotaInfoItemImpostoIPI getIpi() {
        return this.ipi;
    }

    public NFNotaInfoItemImpostoImportacao getImpostoImportacao() {
        return this.impostoImportacao;
    }

    public NFNotaInfoItemImpostoISSQN getIssqn() {
        return this.issqn;
    }

    public NFNotaInfoItemImpostoPIS getPis() {
        return this.pis;
    }

    public NFNotaInfoItemImpostoPISST getPisst() {
        return this.pisst;
    }

    public NFNotaInfoItemImpostoCOFINS getCofins() {
        return this.cofins;
    }

    public NFNotaInfoItemImpostoCOFINSST getCofinsst() {
        return this.cofinsst;
    }

    public NFNotaInfoItemImpostoICMSUFDestino getIcmsUfDestino() {
        return this.icmsUfDestino;
    }

    public void setIcmsUfDestino(final NFNotaInfoItemImpostoICMSUFDestino icmsUfDestino) {
        this.icmsUfDestino = icmsUfDestino;
    }

    public NFNotaInfoItemImpostoIS getIs() {
        return is;
    }

    public void setIs(NFNotaInfoItemImpostoIS is) {
        this.is = is;
    }

    public NFNotaInfoItemImpostoIBSCBS getIbsCbs() {
        return ibsCbs;
    }

    public void setIbsCbs(NFNotaInfoItemImpostoIBSCBS ibsCbs) {
        this.ibsCbs = ibsCbs;
    }

}