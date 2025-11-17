package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

/**
 * UB12
 *
 * @author Edivaldo Mero Stens
 */
public class NFNotaInfoItemImpostoIBSCBS extends DFBase {

    private static final long serialVersionUID = -366528394939416671L;

	@Element(name = "CST", required = true)
	private NFNotaInfoImpostoTributacaoIBSCBS cst; // UB13

	@Element(required = true)
	private String cClassTrib; // UB14

    /**
     * UB14a - Indica a natureza da operação de doação, orientando a apuração e a geração de débitos ou estornos
     * conforme o cenário
     */
    @Element(name = "indDoacao", required = false)
    private String indicadorNaturezaOperacaoDoacao;

    // UB14a -x- Sequencia XML
    @Element(required = false)
    private NFNotaInfoItemImpostoIBSCBSTIBS gIBSCBS; // UB15

    @Element(required = false)
    private NFNotaInfoItemImpostoIBSCBSMonofasia gIBSCBSMono; // UB84

    @Element(required = false)
    private NFNotaInfoItemImpostoIBSCBSTransfCred gTransfCred; // UB106

    /**
     * UB131 - Grupo para apropriação de crédito presumido de IBS sobre o saldo devedor na ZFM (art. 450, § 1º, LC 214/25)
     */
    @Element(required = false)
    private NFNotaInfoItemImpostoIBSCBSCredPresIBSZFM gCredPresIBSZFM;

    /**
     * UB116 - Estorno de crédito
     */
    @Element(name = "gEstornoCred", required = false)
    private NFNotaInfoIBSCBSGrupoEstornoCredito grupoEstornoCredito;

    /**
     * UB120 - Crédito Presumido da Operação
     */
    @Element(name = "gCredPresOper", required = false)
    private NFNotaInfoItemImpostoIBSCBSGCredPresOper grupoCreditoPresumidoOperacao;

    public NFNotaInfoImpostoTributacaoIBSCBS getCst() {
        return cst;
    }

    public void setCst(NFNotaInfoImpostoTributacaoIBSCBS cst) {
        this.cst = cst;
    }

    public String getcClassTrib() {
        return cClassTrib;
    }

    public void setcClassTrib(String cClassTrib) {
        this.cClassTrib = cClassTrib;
    }

    public NFNotaInfoItemImpostoIBSCBSTIBS getGIBSCBS() {
        return gIBSCBS;
    }

    public void setGIBSCBS(NFNotaInfoItemImpostoIBSCBSTIBS gIBSCBS) {
        this.gIBSCBS = gIBSCBS;
    }

    public NFNotaInfoItemImpostoIBSCBSMonofasia getGIBSCBSMono() {
        return gIBSCBSMono;
    }

    public void setGIBSCBSMono(NFNotaInfoItemImpostoIBSCBSMonofasia gIBSCBSMono) {
        this.gIBSCBSMono = gIBSCBSMono;
    }

    public NFNotaInfoItemImpostoIBSCBSTransfCred getGTransfCred() {
        return gTransfCred;
    }

    public void setGTransfCred(NFNotaInfoItemImpostoIBSCBSTransfCred gTransfCred) {
        this.gTransfCred = gTransfCred;
    }

    public NFNotaInfoItemImpostoIBSCBSCredPresIBSZFM getGCredPresIBSZFM() {
        return gCredPresIBSZFM;
    }

    public void setGCredPresIBSZFM(NFNotaInfoItemImpostoIBSCBSCredPresIBSZFM gCredPresIBSZFM) {
        this.gCredPresIBSZFM = gCredPresIBSZFM;
    }

    public String getIndicadorNaturezaOperacaoDoacao() {
        return indicadorNaturezaOperacaoDoacao;
    }

    public void setIndicadorNaturezaOperacaoDoacao(String indicadorNaturezaOperacaoDoacao) {
        DFStringValidador.tamanho1N(indicadorNaturezaOperacaoDoacao, "Indicador Natureza Operação Doação");
        this.indicadorNaturezaOperacaoDoacao = indicadorNaturezaOperacaoDoacao;
    }

    public NFNotaInfoItemImpostoIBSCBSGCredPresOper getGrupoCreditoPresumidoOperacao() {
        return grupoCreditoPresumidoOperacao;
    }

    public void setGrupoCreditoPresumidoOperacao(NFNotaInfoItemImpostoIBSCBSGCredPresOper grupoCreditoPresumidoOperacao) {
        this.grupoCreditoPresumidoOperacao = grupoCreditoPresumidoOperacao;
    }

    public NFNotaInfoIBSCBSGrupoEstornoCredito getGrupoEstornoCredito() {
        return grupoEstornoCredito;
    }

    public void setGrupoEstornoCredito(NFNotaInfoIBSCBSGrupoEstornoCredito grupoEstornoCredito) {
        this.grupoEstornoCredito = grupoEstornoCredito;
    }
}