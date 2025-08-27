package com.fincatto.documentofiscal.cte400.classes.evento;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeInformacoesNotaFiscalFacil;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeInformacoesPAA;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.time.ZonedDateTime;

public class CTeInfoEvento extends DFBase {
    private static final long serialVersionUID = 4495040029270775685L;

    @Attribute(name = "Id", required = false)
    private String id;

    @Element(name = "cOrgao", required = false)
    private DFUnidadeFederativa orgao;
    
    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;
    
    @Element(name = "chCTe")
    private String chave;
    
    @Element(name = "dhEvento")
    private ZonedDateTime dataHoraEvento;
    
    @Element(name = "tpEvento")
    private String codigoEvento;
    
    @Element(name = "nSeqEvento")
    private Integer numeroSequencialEvento;

    @Element(name = "detEvento")
    private CTeDetalhamentoEvento detalheEvento;

    /**
     * Informações da Nota Fiscal Facil de preenchimento exclusivo pelo app NFF
     */
    @Element(name = "infSolicNFF", required = false)
    private CTeInformacoesNotaFiscalFacil informacoesNotaFiscalFacil;

    /**
     * Informações de preenchimento exclusivo do Provedor de Assinatura e Autorização
     */
    @Element(name = "infPAA", required = false)
    private CTeInformacoesPAA informacoesPAA;

    public void setOrgao(final DFUnidadeFederativa orgao) {
        this.orgao = orgao;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        DFStringValidador.exatamente55(id, "Info Evento ID");
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
        DFStringValidador.exatamente44N(chave, "Info Evento Chave");
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
        DFStringValidador.exatamente6N(codigoEvento, "Info Evento Codigo");
        this.codigoEvento = codigoEvento;
    }

    public int getNumeroSequencialEvento() {
        return this.numeroSequencialEvento;
    }

    public void setNumeroSequencialEvento(final int numeroSequencialEvento) {
        DFIntegerValidador.tamanho1a3(numeroSequencialEvento, "Numero Sequencial Evento");
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

    public DFUnidadeFederativa getOrgao() {
        return this.orgao;
    }

    public void setNumeroSequencialEvento(final Integer numeroSequencialEvento) {
        this.numeroSequencialEvento = numeroSequencialEvento;
    }

    public CTeDetalhamentoEvento getDetalheEvento() {
        return this.detalheEvento;
    }

    public void setDetalheEvento(final CTeDetalhamentoEvento detalheEvento) {
        this.detalheEvento = detalheEvento;
    }

    public CTeInformacoesNotaFiscalFacil getInformacoesNotaFiscalFacil() {
        return informacoesNotaFiscalFacil;
    }

    public void setInformacoesNotaFiscalFacil(CTeInformacoesNotaFiscalFacil informacoesNotaFiscalFacil) {
        this.informacoesNotaFiscalFacil = informacoesNotaFiscalFacil;
    }

    public CTeInformacoesPAA getInformacoesPAA() {
        return informacoesPAA;
    }

    public void setInformacoesPAA(CTeInformacoesPAA informacoesPAA) {
        this.informacoesPAA = informacoesPAA;
    }
}