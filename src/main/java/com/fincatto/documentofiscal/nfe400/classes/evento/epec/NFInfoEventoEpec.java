package com.fincatto.documentofiscal.nfe400.classes.evento.epec;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;


public class NFInfoEventoEpec extends DFBase {

    @Attribute(name = "Id", required = true)
    private String identificador;

    @Element(name = "cOrgao", required = true)
    private DFUnidadeFederativa orgao;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "chNFe", required = true)
    private String chave;

    @Element(name = "dhEvento", required = true)
    private ZonedDateTime dataHoraEvento;

    @Element(name = "tpEvento", required = true)
    private String codigoEvento;

    @Element(name = "nSeqEvento", required = true)
    private Integer numeroSequencialEvento;

    @Element(name = "verEvento", required = true)
    private String versaoEvento;

    @Element(name = "detEvento", required = true)
    private NFInfoEpec epec;

    public void setOrgao(final DFUnidadeFederativa orgao) {
        this.orgao = orgao;
    }

    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(final String identificador) {
        DFStringValidador.exatamente54(identificador, "Info Evento Conting\u00eancia EPEC ID");
        this.identificador = identificador;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("CPF ja foi setado");
        }
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("CNPJ ja foi setado");
        }
        DFStringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getChave() {
        return this.chave;
    }

    public void setChave(final String chave) {
        DFStringValidador.exatamente44N(chave, "Info Evento Conting\u00eancia EPEC Chave");
        this.chave = chave;
    }

    public ZonedDateTime getDataHoraEvento() {
        return this.dataHoraEvento;
    }

    public void setDataHoraEvento(final ZonedDateTime dataHoraEvento) {
        this.dataHoraEvento = dataHoraEvento;
    }

    public String getCodigoEvento() {
        return this.codigoEvento;
    }

    public void setCodigoEvento(final String codigoEvento) {
        DFStringValidador.exatamente6N(codigoEvento, "Info Evento Conting\u00eancia EPEC Codigo");
        this.codigoEvento = codigoEvento;
    }

    public int getNumeroSequencialEvento() {
        return this.numeroSequencialEvento;
    }

    public void setNumeroSequencialEvento(final Integer numeroSequencialEvento) {
        DFIntegerValidador.tamanho1a2(numeroSequencialEvento, "Numero Sequencial Evento");
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

	public String getVersaoEvento() {
        return this.versaoEvento;
    }

    public void setVersaoEvento(String versaoEvento) {
		this.versaoEvento = versaoEvento;
	}

	public NFInfoEpec getEpec() {
		return epec;
	}

	public void setEpec(final NFInfoEpec epec) {
		this.epec = epec;
	}

    public DFUnidadeFederativa getOrgao() {
        return this.orgao;
    }
}