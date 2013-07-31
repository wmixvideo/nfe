package com.fincatto.nfe.v200.classes.lote.recibo;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.v200.classes.NFe;

@Root
public class TRetEnviNFe extends NFe {

	@Attribute(name = "versao", required = true)
	private String versao;

	@Element(name = "tpAmb", required = true)
	private String ambiente;

	@Element(name = "verAplic", required = true)
	private String versaoAplicacao;

	@Element(name = "cStat", required = true)
	private String status;

	@Element(name = "xMotivo", required = true)
	private String motivo;

	@Element(name = "cUF", required = true)
	private String uf;

	@Element(name = "dhRecbto", required = true)
	private Date dataHoraRecebimento;

	@Element(name = "infRec", required = true)
	private TRetEnviNFeInfRec infoRecebimento;

	public TRetEnviNFe() {
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String getVersaoAplicacao() {
		return versaoAplicacao;
	}

	public void setVersaoAplicacao(String versaoAplicacao) {
		this.versaoAplicacao = versaoAplicacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Date getDataHoraRecebimento() {
		return dataHoraRecebimento;
	}

	public void setDataHoraRecebimento(Date dataHoraRecebimento) {
		this.dataHoraRecebimento = dataHoraRecebimento;
	}

	public TRetEnviNFeInfRec getInfoRecebimento() {
		return infoRecebimento;
	}

	public void setInfoRecebimento(TRetEnviNFeInfRec infoRecebimento) {
		this.infoRecebimento = infoRecebimento;
	}
}