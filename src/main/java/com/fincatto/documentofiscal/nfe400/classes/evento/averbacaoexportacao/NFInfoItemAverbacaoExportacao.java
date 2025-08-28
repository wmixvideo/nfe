package com.fincatto.documentofiscal.nfe400.classes.evento.averbacaoexportacao;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;

public class NFInfoItemAverbacaoExportacao extends DFBase {

    private static final long serialVersionUID = 8935624336087331066L;

    @Element(name = "dhEmbarque")
    private ZonedDateTime dataHoraEmbarque;

    @Element(name = "dhAverbacao")
    private ZonedDateTime dataHoraAverbacao;

    @Element(name = "nDue")
    private String numeroDue;

    @Element(name = "nItem")
    private Integer numeroItemNFe;

    @Element(name = "nItemDue")
    private Integer numeroItemDue;

    @Element(name = "qItem")
    private String quantidadeAverbada;

    @Element(name = "motAlteracao")
    private Integer motivoAlteracao;

	@Element(name = "enquad", required = false)
	private NFGrupoInfoEnquadramentoItemAverbacaoExportacao grupoInformacaoEnquadramentoItem;
    
    public ZonedDateTime getDataHoraEmbarque() {
        return dataHoraEmbarque;
    }

    public void setDataHoraEmbarque(ZonedDateTime dataHoraEmbarque) {
        this.dataHoraEmbarque = dataHoraEmbarque;
    }

    public ZonedDateTime getDataHoraAverbacao() {
        return dataHoraAverbacao;
    }

    public void setDataHoraAverbacao(ZonedDateTime dataHoraAverbacao) {
        this.dataHoraAverbacao = dataHoraAverbacao;
    }

    public String getNumeroDue() {
        return numeroDue;
    }

    public void setNumeroDue(String numeroDue) {
        this.numeroDue = numeroDue;
    }

    public Integer getNumeroItemNFe() {
        return numeroItemNFe;
    }

    public void setNumeroItemNFe(Integer numeroItemNFe) {
        this.numeroItemNFe = numeroItemNFe;
    }

    public Integer getNumeroItemDue() {
        return numeroItemDue;
    }

    public void setNumeroItemDue(Integer numeroItemDue) {
        this.numeroItemDue = numeroItemDue;
    }

    public String getQuantidadeAverbada() {
        return quantidadeAverbada;
    }

    public void setQuantidadeAverbada(BigDecimal quantidadeAverbada) {
        this.quantidadeAverbada = DFBigDecimalValidador.tamanho15Com4CasasDecimais(quantidadeAverbada, "Quantidade Averbada");
    }

    public Integer getMotivoAlteracao() {
        return motivoAlteracao;
    }

    public void setMotivoAlteracao(Integer motivoAlteracao) {
        this.motivoAlteracao = motivoAlteracao;
    }

	public NFGrupoInfoEnquadramentoItemAverbacaoExportacao getGrupoInformacaoEnquadramentoItem() {
		return grupoInformacaoEnquadramentoItem;
	}

	public void setGrupoInformacaoEnquadramentoItem(
			NFGrupoInfoEnquadramentoItemAverbacaoExportacao grupoInformacaoEnquadramentoItem) {
		this.grupoInformacaoEnquadramentoItem = grupoInformacaoEnquadramentoItem;
	}

}
