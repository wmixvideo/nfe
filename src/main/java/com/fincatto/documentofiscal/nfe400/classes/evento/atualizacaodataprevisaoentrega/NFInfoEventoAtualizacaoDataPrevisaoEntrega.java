package com.fincatto.documentofiscal.nfe400.classes.evento.atualizacaodataprevisaoentrega;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class NFInfoEventoAtualizacaoDataPrevisaoEntrega extends DFBase {

    private static final long serialVersionUID = 2460706933290434169L;

    //@Attribute(name = "Id")
    //private String id;

    @Element(name = "cOrgao")
    private DFUnidadeFederativa orgao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "chNFe")
    private String chave;

    @Element(name = "dhEvento")
    private ZonedDateTime dataHoraEvento;

    @Element(name = "tpEvento")
    private String codigoEvento;

    @Element(name = "nSeqEvento")
    private Integer numeroSequencialEvento;

    @Element(name = "verEvento")
    private String versaoEvento;

    @Element(name = "detEvento")
    private NFInfoAtualizacaoDataPrevisaoEntrega alteracaoDataPrevisaoEntrega;

    /*public String getId() {
        return this.id;
    }*/

    /*public void setId(final String id) {
        DFStringValidador.exatamente54(id, "Info Evento Alteração Data Previsão Entrega ID");
        this.id = id;
    }*/

    public DFUnidadeFederativa getOrgao() {
        return this.orgao;
    }

    public void setOrgao(final DFUnidadeFederativa orgao) {
        this.orgao = orgao;
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
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getChave() {
        return this.chave;
    }

    public void setChave(final String chave) {
        DFStringValidador.exatamente44N(chave, "Info Evento Alteração Data Previsão Entrega Chave");
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
        DFStringValidador.exatamente6N(codigoEvento, "Info Evento Alteração Data Previsão Entrega Codigo");
        this.codigoEvento = codigoEvento;
    }

    public int getNumeroSequencialEvento() {
        return this.numeroSequencialEvento;
    }

    public void setNumeroSequencialEvento(final int numeroSequencialEvento) {
        DFIntegerValidador.tamanho1a2(numeroSequencialEvento, "Numero Sequencial Evento");
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

    public String getVersaoEvento() {
        return this.versaoEvento;
    }

    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
    }

    public NFInfoAtualizacaoDataPrevisaoEntrega getAlteracaoDataPrevisaoEntrega () {
        return this.alteracaoDataPrevisaoEntrega;
    }

    public void setAlteracaoDataPrevisaoEntrega(final NFInfoAtualizacaoDataPrevisaoEntrega alteracaoDataPrevisaoEntrega) {
        this.alteracaoDataPrevisaoEntrega = alteracaoDataPrevisaoEntrega;
    }

}
