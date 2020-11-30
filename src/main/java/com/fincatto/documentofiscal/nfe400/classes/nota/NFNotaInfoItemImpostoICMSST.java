package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSST extends DFBase {
	private static final long serialVersionUID = -2354449482492846488L;

    @Element(name = "orig")
	private NFOrigem origem;

    @Element(name = "CST")
	private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "vBCSTRet")
	private String valorBCICMSSTRetidoUFRemetente;

	@Element(name = "pST", required = false)
	private String aliqSuportadaConsFinal;
	
	@Element(name = "vICMSSubstituto", required = false)
    private String valorICMSSubstituto;

    @Element(name = "vICMSSTRet")
	private String valorICMSSTRetidoUFRemetente;

	@Element(name = "vBCFCPSTRet", required = false)
    private String valorBCFundoCombatePobrezaRetidoST;

    @Element(name = "pFCPSTRet", required = false)
    private String percentualFundoCombatePobrezaRetidoST;

    @Element(name = "vFCPSTRet", required = false)
    private String valorFundoCombatePobrezaRetidoST;

    @Element(name = "vBCSTDest")
	private String valorBCICMSSTUFDestino;

    @Element(name = "vICMSSTDest")
	private String valorICMSSTUFDestino;
	
	@Element(name = "pRedBCEfet", required = false)
    private String percentualReducaoBCEfetiva;
	
	@Element(name = "vBCEfet", required = false)
    private String valorBCEfetiva;

    @Element(name = "pICMSEfet", required = false)
    private String percentualAliquotaICMSEfetiva;

    @Element(name = "vICMSEfet", required = false)
    private String valorICMSEfetivo;

	public void setOrigem(final NFOrigem origem) {
		this.origem = origem;
	}

	public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
		this.situacaoTributaria = situacaoTributaria;
	}

	public void setValorBCICMSSTRetidoUFRemetente(final BigDecimal valorBCICMSSTRetidoUFRemetente) {
        this.valorBCICMSSTRetidoUFRemetente = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCICMSSTRetidoUFRemetente, "Valor BC ICMS ST Retido UF Remetente");
	}

	public void setAliqSuportadaConsFinal(final BigDecimal aliqSuportadaConsFinal) {
        this.aliqSuportadaConsFinal = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(aliqSuportadaConsFinal, "Al\u00edquota suportada pelo Consumidor Final");
    }

	public void setValorICMSSubstituto(final BigDecimal valorICMSSubstituto) {
        this.valorICMSSubstituto = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSSubstituto, "Valor do ICMS pr\u00f3prio do Substituto");
	}

	public void setValorICMSSTRetidoUFRemetente(final BigDecimal valorICMSSTRetidoUFRemetente) {
        this.valorICMSSTRetidoUFRemetente = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSSTRetidoUFRemetente, "Valor ICMS ST Retido UF Remetente");
	}

	public void setValorBCFundoCombatePobrezaRetidoST(final BigDecimal valorBCFundoCombatePobrezaRetidoST) {
        this.valorBCFundoCombatePobrezaRetidoST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCFundoCombatePobrezaRetidoST, "Valor da Base de C\u00e1lculo do FCP retido anteriormente");
    }

	public void setPercentualFundoCombatePobrezaRetidoST(final BigDecimal percentualFundoCombatePobrezaRetidoST) {
        if (percentualFundoCombatePobrezaRetidoST.signum() < 0) {
            throw new IllegalStateException("Percentual fundo de combate a pobreza precisa ser maior que zero!");
        }
        this.percentualFundoCombatePobrezaRetidoST = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualFundoCombatePobrezaRetidoST, "Percentual fundo combate pobreza retido ST");
    }

	public void setValorFundoCombatePobrezaRetidoST(final BigDecimal valorFundoCombatePobrezaRetidoST) {
        this.valorFundoCombatePobrezaRetidoST = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorFundoCombatePobrezaRetidoST, "Valor fundo combate pobreza retido ST");
    }

    public void setValorBCICMSSTUFDestino(final BigDecimal valorBCICMSSTUFDestino) {
        this.valorBCICMSSTUFDestino = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCICMSSTUFDestino, "Valor BC ICMS ST UF Destino");
	}

	public void setValorICMSSTUFDestino(final BigDecimal valorICMSSTUFDestino) {
        this.valorICMSSTUFDestino = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSSTUFDestino, "Valor ICMS ST UF Destino");
	}

	public void setPercentualReducaoBCEfetiva(final BigDecimal percentualReducaoBCEfetiva) {
        this.percentualReducaoBCEfetiva = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualReducaoBCEfetiva, "Percentual de redu\u00e7\u00e3o da base de c\u00e1lculo efetiva");
    }

    public void setValorBCEfetiva(final BigDecimal valorBCEfetiva) {
        this.valorBCEfetiva = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCEfetiva, "Valor da base de c\u00e1lculo efetiva");
    }
	
	public void setPercentualAliquotaICMSEfetiva(final BigDecimal percentualAliquotaICMSEfetiva) {
        this.percentualAliquotaICMSEfetiva = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualAliquotaICMSEfetiva, "Percentual aliquota ICMS efetiva");
    }
	
	public void setValorICMSEfetivo(final BigDecimal valorICMSEfetivo) {
        this.valorICMSEfetivo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSEfetivo, "Valor ICMS efetivo");
    }

	public NFOrigem getOrigem() {
		return origem;
	}

	public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
		return situacaoTributaria;
	}

	public String getValorBCICMSSTRetidoUFRemetente() {
		return valorBCICMSSTRetidoUFRemetente;
	}

	public String getAliqSuportadaConsFinal() {
		return aliqSuportadaConsFinal;
	}

	public String getValorICMSSubstituto() {
		return valorICMSSubstituto;
	}

	public String getValorICMSSTRetidoUFRemetente() {
		return valorICMSSTRetidoUFRemetente;
	}

	public String getValorBCFundoCombatePobrezaRetidoST() {
		return valorBCFundoCombatePobrezaRetidoST;
	}

	public String getPercentualFundoCombatePobrezaRetidoST() {
		return percentualFundoCombatePobrezaRetidoST;
	}

	public String getValorFundoCombatePobrezaRetidoST() {
		return valorFundoCombatePobrezaRetidoST;
	}

	public String getValorBCICMSSTUFDestino() {
		return valorBCICMSSTUFDestino;
	}

	public String getValorICMSSTUFDestino() {
		return valorICMSSTUFDestino;
	}

	public String getPercentualReducaoBCEfetiva() {
		return percentualReducaoBCEfetiva;
	}
	
	public String getValorBCEfetiva() {
		return valorBCEfetiva;
	}

	public String getPercentualAliquotaICMSEfetiva() {
		return percentualAliquotaICMSEfetiva;
	}

	public String getValorICMSEfetivo() {
		return valorICMSEfetivo;
	}
	
}