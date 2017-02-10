package com.fincatto.cte300.classes.statusservico.consulta;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.cte300.classes.CTBase;
import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.statusservico.consulta.IStatusServicoConsultaRetorno;
import com.fincatto.dfe.transformers.DFDateFormatTransformer;

@Root(name = "retConsStatServCte")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTStatusServicoConsultaRetorno extends CTBase implements IStatusServicoConsultaRetorno {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "cStat", required = true)
    private String status;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "cUF", required = true)
    private DFUnidadeFederativa uf;

    @Element(name = "dhRecbto", required = true)
    private Date dataRecebimento;

    @Element(name = "dhRetorno", required = false)
    private Date dataRetorno;

    @Element(name = "xObs", required = false)
    private String observacao;

    @Element(name = "tMed", required = true)
    private String tempoMedio;

    public CTStatusServicoConsultaRetorno() {
        this.versao = null;
        this.ambiente = null;
        this.versaoAplicacao = null;
        this.status = null;
        this.motivo = null;
        this.uf = null;
        this.dataRecebimento = null;
        this.dataRetorno = null;
        this.observacao = null;
        this.tempoMedio = null;
    }

    @Override
    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    @Override
    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    @Override
    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    @Override
    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public Date getDataRecebimento() {
        return this.dataRecebimento;
    }

    public void setDataRecebimento(final Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataRetorno() {
        return this.dataRetorno;
    }

    public void setDataRetorno(final Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    @Override
    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(final String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String getTempoMedio() {
        return this.tempoMedio;
    }

    public void setTempoMedio(final String tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

	@Override
	public String getDataRecebimentoString() {
		try {
			return new DFDateFormatTransformer().write(getDataRecebimento());
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public String getDataRetornoString() {
		try {
			return new DFDateFormatTransformer().write(getDataRetorno());
		} catch (Exception e) {
		}
		return null;
	}
}