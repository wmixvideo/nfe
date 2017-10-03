package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoDirecao;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Informações do modal Aquaviário
 */

@Root(name = "aquav")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalAquaviario extends DFBase {
    private static final long serialVersionUID = 7558858837552378617L;

    @Element(name = "vPrest", required = true)
    private String valorPrestacao;

    @Element(name = "vAFRMM", required = true)
    private String valorAdicionalFrete;

    @Element(name = "xNavio", required = true)
    private String identificacaoNavio;

    @ElementList(name = "balsa", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoModalAquaviarioBalsa> balsa;

    @Element(name = "nViag", required = false)
    private String numeroViagem;

    @Element(name = "direc", required = true)
    private CTTipoDirecao direcao;

    @Element(name = "irin", required = true)
    private String irin;

    @ElementList(name = "detCont", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteiner> container;

    public CTeNotaInfoCTeNormalInfoModalAquaviario() {
        this.valorPrestacao = null;
        this.valorAdicionalFrete = null;
        this.identificacaoNavio = null;
        this.balsa = null;
        this.numeroViagem = null;
        this.direcao = null;
        this.irin = null;
        this.container = null;
    }

    public String getValorPrestacao() {
        return this.valorPrestacao;
    }

    /**
     * Valor da Prestação Base de Cálculo do AFRMM
     */
    public void setValorPrestacao(final BigDecimal valorPrestacao) {
        this.valorPrestacao = BigDecimalParser.tamanho15Com2CasasDecimais(valorPrestacao, "Valor da Prestação Base de Cálculo do AFRMM");
    }

    public String getValorAdicionalFrete() {
        return this.valorAdicionalFrete;
    }

    /**
     * AFRMM (Adicional de Frete para Renovação da Marinha Mercante)
     */
    public void setValorAdicionalFrete(final BigDecimal valorAdicionalFrete) {
        this.valorAdicionalFrete = BigDecimalParser.tamanho15Com2CasasDecimais(valorAdicionalFrete, "AFRMM (Adicional de Frete para Renovação da Marinha Mercante)");
    }

    public String getIdentificacaoNavio() {
        return this.identificacaoNavio;
    }

    /**
     * Identificação do Navio
     */
    public void setIdentificacaoNavio(final String identificacaoNavio) {
        StringValidador.tamanho60(identificacaoNavio, "Identificação do Navio");
        this.identificacaoNavio = identificacaoNavio;
    }

    public List<CTeNotaInfoCTeNormalInfoModalAquaviarioBalsa> getBalsa() {
        return this.balsa;
    }

    /**
     * Grupo de informações das balsas
     */
    public void setBalsa(final List<CTeNotaInfoCTeNormalInfoModalAquaviarioBalsa> balsa) {
        ListValidador.tamanho3(balsa, "");
        this.balsa = balsa;
    }

    public String getNumeroViagem() {
        return this.numeroViagem;
    }

    /**
     * Número da Viagem
     */
    public void setNumeroViagem(final String numeroViagem) {
        StringValidador.tamanho10(numeroViagem, "Número da Viagem");
        this.numeroViagem = numeroViagem;
    }

    public CTTipoDirecao getDirecao() {
        return this.direcao;
    }

    /**
     * Direção<br>
     * Preencher com: N-Norte, L-Leste, S-Sul, O-Oeste
     */
    public void setDirecao(final CTTipoDirecao direcao) {
        this.direcao = direcao;
    }

    public String getIrin() {
        return this.irin;
    }

    /**
     * Irin do navio sempre deverá ser informado
     */
    public void setIrin(final String irin) {
        StringValidador.tamanho10(irin, "Irin do navio");
        this.irin = irin;
    }

    public List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteiner> getContainer() {
        return this.container;
    }

    /**
     * Grupo de informações de detalhamento dos conteiners (Somente para Redespacho Intermediario e serviço vinculado)
     */
    public void setContainer(final List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteiner> container) {
        this.container = container;
    }
}
