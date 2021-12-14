package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import org.simpleframework.xml.Root;

/**
 * Tipo Evento
 */
@Root(name = "infEvento")
public class MDFeInfoEvento extends DFBase {
    private static final long serialVersionUID = -9002694768514200146L;

    @Attribute(name = "Id", required = false)
    private String id;

    @Element(name = "cOrgao", required = false)
    private String orgao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "chMDFe")
    private String chave;

    @Element(name = "dhEvento")
    private ZonedDateTime dataHoraEvento;

    @Element(name = "tpEvento")
    private String codigoEvento;

    @Element(name = "nSeqEvento")
    private Integer numeroSequencialEvento;

    @Element(name = "verEvento", required = false)
    private String versaoEvento;

    /**
     * Detalhamento do evento específico (cancelamento, encerramento, registro de passagem).
     */
    @Element(name = "detEvento")
    private MDFeDetalhamentoEvento detEvento;

    public void setOrgao(final String orgao) {
        this.orgao = orgao;
    }

    public void setVersaoEvento(final BigDecimal versaoEvento) {
        this.versaoEvento = DFBigDecimalValidador.tamanho5Com2CasasDecimais(versaoEvento, "Versao do Evento");
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        DFStringValidador.exatamente54(id, "Info Evento  ID");
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
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getChave() {
        return this.chave;
    }

    public void setChave(final String chave) {
        DFStringValidador.exatamente44N(chave, "Info Evento Cancelamento Chave");
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
        DFStringValidador.exatamente6N(codigoEvento, "Info Evento Cancelamento Codigo");
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

    public String getOrgao() {
        return this.orgao;
    }

    public void setNumeroSequencialEvento(final Integer numeroSequencialEvento) {
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

    public void setVersaoEvento(final String versaoEvento) {
        this.versaoEvento = versaoEvento;
    }

    public MDFeDetalhamentoEvento getDetEvento() {
        return this.detEvento;
    }

    public void setDetEvento(final MDFeDetalhamentoEvento detEvento) {
        this.detEvento = detEvento;
    }
}