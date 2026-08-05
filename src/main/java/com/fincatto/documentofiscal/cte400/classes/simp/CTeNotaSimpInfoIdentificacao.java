package com.fincatto.documentofiscal.cte400.classes.simp;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTModal;
import com.fincatto.documentofiscal.cte400.classes.CTProcessoEmissao;
import com.fincatto.documentofiscal.cte400.classes.CTRetirada;
import com.fincatto.documentofiscal.cte400.classes.CTTipoImpressao;
import com.fincatto.documentofiscal.cte400.classes.CTTipoServico;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Identificação do CT-e Simplificado (grupo ide).
 * Diferente do CT-e normal: tpCTe assume 5 (Simplificado) ou 6 (Substituição do
 * Simplificado); modal restrito a 01/02/03; município de início/fim da prestação
 * é informado por item no grupo det, não aqui.
 */
@Root(name = "ide")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaSimpInfoIdentificacao extends DFBase {
    private static final long serialVersionUID = 1L;

    @Element(name = "cUF")
    private DFUnidadeFederativa cUF;

    @Element(name = "cCT")
    private String cCT;

    @Element(name = "CFOP")
    private String CFOP;

    @Element(name = "natOp")
    private String natOp;

    @Element(name = "mod")
    private DFModelo mod;

    @Element(name = "serie")
    private Integer serie;

    @Element(name = "nCT")
    private Integer nCT;

    @Element(name = "dhEmi")
    private ZonedDateTime dhEmi;

    @Element(name = "tpImp")
    private CTTipoImpressao tpImp;

    @Element(name = "tpEmis")
    private CTTipoEmissao tpEmis;

    @Element(name = "cDV")
    private Integer cDV;

    @Element(name = "tpAmb")
    private DFAmbiente tpAmb;

    @Element(name = "tpCTe")
    private String tpCTe;

    @Element(name = "procEmi")
    private CTProcessoEmissao procEmi;

    @Element(name = "verProc")
    private String verProc;

    @Element(name = "cMunEnv")
    private String cMunEnv;

    @Element(name = "xMunEnv")
    private String xMunEnv;

    @Element(name = "UFEnv")
    private String UFEnv;

    @Element(name = "modal")
    private CTModal modal;

    @Element(name = "tpServ")
    private CTTipoServico tpServ;

    @Element(name = "UFIni")
    private String UFIni;

    @Element(name = "UFFim")
    private String UFFim;

    @Element(name = "retira")
    private CTRetirada retira;

    @Element(name = "xDetRetira", required = false)
    private String xDetRetira;

    @Element(name = "dhCont", required = false)
    private LocalDateTime dhCont;

    @Element(name = "xJust", required = false)
    private String xJust;

    public DFUnidadeFederativa getCUF() {
        return this.cUF;
    }

    /**
     * Código da UF do emitente do CT-e.
     */
    public void setCUF(final DFUnidadeFederativa cUF) {
        this.cUF = cUF;
    }

    public String getCCT() {
        return this.cCT;
    }

    /**
     * Código numérico que compõe a Chave de Acesso.
     */
    public void setCCT(final String cCT) {
        DFStringValidador.exatamente8N(cCT, "Codigo Numerico");
        this.cCT = cCT;
    }

    public String getCFOP() {
        return this.CFOP;
    }

    /**
     * Código Fiscal de Operações e Prestações
     */
    public void setCFOP(final String CFOP) {
        DFStringValidador.exatamente4N(CFOP, "CFOP");
        this.CFOP = CFOP;
    }

    public String getNatOp() {
        return this.natOp;
    }

    /**
     * Natureza da Operação
     */
    public void setNatOp(final String natOp) {
        DFStringValidador.tamanho2ate60(natOp, "Natureza da Operacao");
        this.natOp = natOp;
    }

    public DFModelo getMod() {
        return this.mod;
    }

    /**
     * Modelo do documento fiscal (código 57 para o CT-e).
     */
    public void setMod(final DFModelo mod) {
        this.mod = mod;
    }

    public Integer getSerie() {
        return this.serie;
    }

    /**
     * Série do CT-e
     */
    public void setSerie(final Integer serie) {
        DFIntegerValidador.tamanho3(serie, "Serie");
        this.serie = serie;
    }

    public Integer getNCT() {
        return this.nCT;
    }

    /**
     * Número do CT-e
     */
    public void setNCT(final Integer nCT) {
        DFIntegerValidador.tamanho9(nCT, "Numero");
        this.nCT = nCT;
    }

    public ZonedDateTime getDhEmi() {
        return this.dhEmi;
    }

    /**
     * Data e hora de emissão do CT-e (AAAA-MM-DDTHH:MM:DD TZD)
     */
    public void setDhEmi(final ZonedDateTime dhEmi) {
        this.dhEmi = dhEmi;
    }

    public CTTipoImpressao getTpImp() {
        return this.tpImp;
    }

    /**
     * Formato de impressão do DACTE (1 - Retrato; 2 - Paisagem).
     */
    public void setTpImp(final CTTipoImpressao tpImp) {
        this.tpImp = tpImp;
    }

    public CTTipoEmissao getTpEmis() {
        return this.tpEmis;
    }

    /**
     * Forma de emissão do CT-e (1 - Normal; 3 - Regime Especial NFF; 4 - EPEC SVC;
     * 7 - SVC-RS; 8 - SVC-SP).
     */
    public void setTpEmis(final CTTipoEmissao tpEmis) {
        this.tpEmis = tpEmis;
    }

    public Integer getCDV() {
        return this.cDV;
    }

    /**
     * Dígito Verificador da chave de acesso do CT-e
     */
    public void setCDV(final Integer cDV) {
        DFIntegerValidador.exatamente1(cDV, "DV");
        this.cDV = cDV;
    }

    public DFAmbiente getTpAmb() {
        return this.tpAmb;
    }

    /**
     * Tipo do Ambiente (1 - Produção; 2 - Homologação).
     */
    public void setTpAmb(final DFAmbiente tpAmb) {
        this.tpAmb = tpAmb;
    }

    public String getTpCTe() {
        return this.tpCTe;
    }

    /**
     * Tipo do CT-e Simplificado. Preencher com: 5 - CT-e Simplificado;
     * 6 - Substituição do CT-e Simplificado.
     */
    public void setTpCTe(final String tpCTe) {
        DFStringValidador.exatamente1(tpCTe, "Tipo do CT-e Simplificado");
        if (!"5".equals(tpCTe) && !"6".equals(tpCTe)) {
            throw new IllegalStateException("Tipo do CT-e Simplificado deve ser 5 (Simplificado) ou 6 (Substituicao)");
        }
        this.tpCTe = tpCTe;
    }

    public CTProcessoEmissao getProcEmi() {
        return this.procEmi;
    }

    /**
     * Identificador do processo de emissão do CT-e
     */
    public void setProcEmi(final CTProcessoEmissao procEmi) {
        this.procEmi = procEmi;
    }

    public String getVerProc() {
        return this.verProc;
    }

    /**
     * Versão do processo de emissão
     */
    public void setVerProc(final String verProc) {
        DFStringValidador.tamanho20(verProc, "Versao Aplicativo Emissor");
        this.verProc = verProc;
    }

    public String getCMunEnv() {
        return this.cMunEnv;
    }

    /**
     * Código do Município de envio do CT-e (tabela IBGE; 9999999 para o exterior).
     */
    public void setCMunEnv(final String cMunEnv) {
        DFStringValidador.exatamente7N(cMunEnv, "Codigo do Municipio de envio do CT-e");
        this.cMunEnv = cMunEnv;
    }

    public String getXMunEnv() {
        return this.xMunEnv;
    }

    /**
     * Nome do Município de envio do CT-e.
     */
    public void setXMunEnv(final String xMunEnv) {
        DFStringValidador.tamanho2ate60(xMunEnv, "Nome do Municipio de envio do CT-e");
        this.xMunEnv = xMunEnv;
    }

    public String getUFEnv() {
        return this.UFEnv;
    }

    /**
     * Sigla da UF de envio do CT-e ('EX' para operações com o exterior).
     */
    public void setUFEnv(final String UFEnv) {
        DFStringValidador.exatamente2(UFEnv, "Sigla da UF de envio do CT-e");
        this.UFEnv = UFEnv;
    }

    public CTModal getModal() {
        return this.modal;
    }

    /**
     * Modal (01 - Rodoviário; 02 - Aéreo; 03 - Aquaviário).
     */
    public void setModal(final CTModal modal) {
        this.modal = modal;
    }

    public CTTipoServico getTpServ() {
        return this.tpServ;
    }

    /**
     * Tipo do Serviço (0 - Normal; 1 - Subcontratação; 2 - Redespacho).
     */
    public void setTpServ(final CTTipoServico tpServ) {
        this.tpServ = tpServ;
    }

    public String getUFIni() {
        return this.UFIni;
    }

    /**
     * UF do início da prestação ('EX' para operações com o exterior).
     */
    public void setUFIni(final String UFIni) {
        DFStringValidador.exatamente2(UFIni, "UF do inicio da prestacao");
        this.UFIni = UFIni;
    }

    public String getUFFim() {
        return this.UFFim;
    }

    /**
     * UF do término da prestação ('EX' para operações com o exterior).
     */
    public void setUFFim(final String UFFim) {
        DFStringValidador.exatamente2(UFFim, "UF do termino da prestacao");
        this.UFFim = UFFim;
    }

    public CTRetirada getRetira() {
        return this.retira;
    }

    /**
     * Indicador se o Recebedor retira no Aeroporto/Filial/Porto/Estação de Destino
     * (0 - sim; 1 - não).
     */
    public void setRetira(final CTRetirada retira) {
        this.retira = retira;
    }

    public String getXDetRetira() {
        return this.xDetRetira;
    }

    /**
     * Detalhes da retirada
     */
    public void setXDetRetira(final String xDetRetira) {
        DFStringValidador.tamanho160(xDetRetira, "Detalhes da retirada");
        this.xDetRetira = xDetRetira;
    }

    public LocalDateTime getDhCont() {
        return this.dhCont;
    }

    /**
     * Data e Hora da entrada em contingência (AAAA-MM-DDTHH:MM:SS).
     */
    public void setDhCont(final LocalDateTime dhCont) {
        this.dhCont = dhCont;
    }

    public String getXJust() {
        return this.xJust;
    }

    /**
     * Justificativa da entrada em contingência
     */
    public void setXJust(final String xJust) {
        DFStringValidador.tamanho15a256(xJust, "Justificativa da entrada em contingencia");
        this.xJust = xJust;
    }
}
