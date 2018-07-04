package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import java.math.BigDecimal;

import java.time.ZonedDateTime;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.IntegerValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

public class CTeInfoEventoCancelamento extends DFBase {
    private static final long serialVersionUID = -9071000192790378973L;

    @Attribute(name = "Id", required = false)
    private String id;

    @Element(name = "cOrgao", required = false)
    private DFUnidadeFederativa orgao;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "chCTe", required = true)
    private String chave;

    @Element(name = "dhEvento", required = true)
    private ZonedDateTime dataHoraEvento;

    @Element(name = "tpEvento", required = true)
    private String codigoEvento;

    @Element(name = "nSeqEvento", required = true)
    private Integer numeroSequencialEvento;

    @Element(name = "verEvento", required = false)
    private String versaoEvento;

    @Element(name = "detEvento")
    private CTeDetalhamentoEventoCancelamento cancelamento;

    public void setOrgao(final DFUnidadeFederativa orgao) {
        this.orgao = orgao;
    }

    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = BigDecimalParser.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        StringValidador.exatamente54(id, "Info Evento Cancelamento ID");
        this.id = id;
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
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("CNPJ ja foi setado");
        }
        StringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public String getChave() {
        return this.chave;
    }

    public void setChave(final String chave) {
        StringValidador.exatamente44N(chave, "Info Evento Cancelamento Chave");
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
        StringValidador.exatamente6N(codigoEvento, "Info Evento Cancelamento Codigo");
        this.codigoEvento = codigoEvento;
    }

    public int getNumeroSequencialEvento() {
        return this.numeroSequencialEvento;
    }

    public void setNumeroSequencialEvento(final int numeroSequencialEvento) {
        IntegerValidador.tamanho1a2(numeroSequencialEvento, "Numero Sequencial Evento");
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

    public String getVersaoEvento() {
        return this.versaoEvento;
    }

    public DFUnidadeFederativa getOrgao() {
        return this.orgao;
    }

    public void setNumeroSequencialEvento(final Integer numeroSequencialEvento) {
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

    public void setVersaoEvento(final String versaoEvento) {
        this.versaoEvento = versaoEvento;
    }

    public CTeDetalhamentoEventoCancelamento getCancelamento() {
        return this.cancelamento;
    }

    public void setCancelamento(final CTeDetalhamentoEventoCancelamento cancelamento) {
        this.cancelamento = cancelamento;
    }
}