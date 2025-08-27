package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.*;

import java.util.List;

@Root(name = "infCte")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfo extends DFBase {
    public static final String IDENT = "CTe";
    private static final long serialVersionUID = 1970550899293677744L;

    @Attribute(name = "Id")
    private String identificador;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "ide")
    private CTeOSInfoIdentificacao identificacao;

    @Element(name = "compl", required = false)
    private CTeOSInfoDadosComplementares dadosComplementares;

    @Element(name = "emit")
    private CTeOSInfoEmitente emitente;

    @Element(name = "toma", required = false)
    private CTeOSInfoIdentificacaoTomador tomador;

    @Element(name = "vPrest")
    private CTeOSInfoValorPrestacaoServico valorPrestacaoServico;

    @Element(name = "imp")
    private CTeOSInfoInformacoesRelativasImpostos informacoesRelativasImpostos;

    @Element(name = "infCTeNorm", required = false)
    private CTeOSInfoCTeNormal cteNormal;

    @ElementList(name = "infCteComp", inline = true, required = false)
    private List<CTeOSInfoCTeComplementar> cteComplementar;

    @ElementList(name = "autXML", inline = true, required = false)
    private List<CTeOSInfoAutorizacaoDownload> autorizacaoDownload;

    @Element(name="infRespTec", required = false)
    private CTeOSInfoResponsavelTecnico informacaoResposavelTecnico;

    public String getIdentificador() {
        return this.identificador;
    }

    /**
     * Identificador da tag a ser assinada<br>
     * Informar a chave de acesso do CT-e e precedida do literal "CTe"
     */
    public void setIdentificador(final String identificador) {
        DFStringValidador.exatamente44N(identificador, "Identificador");
        this.identificador = CTeOSInfo.IDENT + identificador;
    }

    /**
     * Pega a chave de acesso a partir do identificador.
     * @return Chave de acesso.
     */
    public String getChaveAcesso() {
        return this.identificador.replace(CTeOSInfo.IDENT, "");
    }

    public CTeOSInfoIdentificacao getIdentificacao() {
        return this.identificacao;
    }

    /**
     * Identificação do CT-e
     */
    public void setIdentificacao(final CTeOSInfoIdentificacao identificacao) {
        this.identificacao = identificacao;
    }

    public CTeOSInfoDadosComplementares getDadosComplementares() {
        return this.dadosComplementares;
    }

    /**
     * Dados complementares do CT-e para fins operacionais ou comerciais
     */
    public void setDadosComplementares(final CTeOSInfoDadosComplementares dadosComplementares) {
        this.dadosComplementares = dadosComplementares;
    }

    public CTeOSInfoEmitente getEmitente() {
        return this.emitente;
    }

    /**
     * Identificação do Emitente do CT-e
     */
    public void setEmitente(final CTeOSInfoEmitente emitente) {
        this.emitente = emitente;
    }

    public CTeOSInfoIdentificacaoTomador getTomador() {
        return tomador;
    }

    public void setTomador(final CTeOSInfoIdentificacaoTomador tomador) {
        this.tomador = tomador;
    }

    public CTeOSInfoValorPrestacaoServico getValorPrestacaoServico() {
        return this.valorPrestacaoServico;
    }

    /**
     * Valores da Prestação de Serviço
     */
    public void setValorPrestacaoServico(final CTeOSInfoValorPrestacaoServico valorPrestacaoServico) {
        this.valorPrestacaoServico = valorPrestacaoServico;
    }

    public CTeOSInfoInformacoesRelativasImpostos getInformacoesRelativasImpostos() {
        return this.informacoesRelativasImpostos;
    }

    /**
     * Informações relativas aos Impostos
     */
    public void setInformacoesRelativasImpostos(final CTeOSInfoInformacoesRelativasImpostos informacoesRelativasImpostos) {
        this.informacoesRelativasImpostos = informacoesRelativasImpostos;
    }

    public CTeOSInfoCTeNormal getCteNormal() {
        return this.cteNormal;
    }

    /**
     * Grupo de informações do CT-e Normal e Substituto
     */
    public void setCteNormal(final CTeOSInfoCTeNormal cteNormal) {
        this.cteNormal = cteNormal;
    }

    public List<CTeOSInfoCTeComplementar> getCteComplementar() {
        return this.cteComplementar;
    }

    /**
     * Detalhamento do CT-e complementado
     */
    public void setCteComplementar(final List<CTeOSInfoCTeComplementar> cteComplementar) {
        this.cteComplementar = cteComplementar;
    }

    public List<CTeOSInfoAutorizacaoDownload> getAutorizacaoDownload() {
        return this.autorizacaoDownload;
    }

    /**
     * Autorizados para download do XML do DF-e<br>
     * Informar CNPJ ou CPF. Preencher os zeros não significativos.
     */
    public void setAutorizacaoDownload(final List<CTeOSInfoAutorizacaoDownload> autorizacaoDownload) {
        DFListValidador.tamanho10(autorizacaoDownload, "Autorizados para download do XML do DF-e");
        this.autorizacaoDownload = autorizacaoDownload;
    }

    public String getVersao() {
        return this.versao;
    }

    /**
     * Versão do leiaute
     */
    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public CTeOSInfoResponsavelTecnico getInformacaoResposavelTecnico() {
        return informacaoResposavelTecnico;
    }

    public CTeOSInfo setInformacaoResposavelTecnico(final CTeOSInfoResponsavelTecnico informacaoResposavelTecnico) {
        this.informacaoResposavelTecnico = informacaoResposavelTecnico;
        return this;
    }
}
