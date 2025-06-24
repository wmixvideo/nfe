package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTModalAquavTpNav;
import com.fincatto.documentofiscal.cte400.classes.CTTipoDirecao;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

/**
 * Informações do modal Aquaviário
 */

@Root(name = "aquav")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalAquaviario extends DFBase {
    private static final long serialVersionUID = 8840293884140190481L;

    @Element(name = "vPrest")
    private String valorPrestacao;
    
    @Element(name = "vAFRMM")
    private String valorAdicionalFrete;
    
    @Element(name = "xNavio")
    private String identificacaoNavio;

    @ElementList(name = "balsa", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoModalAquaviarioBalsa> balsa;

    @Element(name = "nViag", required = false)
    private String numeroViagem;
    
    @Element(name = "direc")
    private CTTipoDirecao direcao;
    
    @Element(name = "irin")
    private String irin;
    
    @Element(name = "tpNav", required = false)
    private CTModalAquavTpNav tpNav;

    @ElementList(name = "detCont", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteiner> container;

    public String getValorPrestacao() {
        return this.valorPrestacao;
    }

    /**
     * Valor da Prestação Base de Cálculo do AFRMM
     */
    public void setValorPrestacao(final BigDecimal valorPrestacao) {
        this.valorPrestacao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorPrestacao, "Valor da Prestação Base de Cálculo do AFRMM");
    }

    public String getValorAdicionalFrete() {
        return this.valorAdicionalFrete;
    }

    /**
     * AFRMM (Adicional de Frete para Renovação da Marinha Mercante)
     */
    public void setValorAdicionalFrete(final BigDecimal valorAdicionalFrete) {
        this.valorAdicionalFrete = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorAdicionalFrete, "AFRMM (Adicional de Frete para Renovação da Marinha Mercante)");
    }

    public String getIdentificacaoNavio() {
        return this.identificacaoNavio;
    }

    /**
     * Identificação do Navio
     */
    public void setIdentificacaoNavio(final String identificacaoNavio) {
        DFStringValidador.tamanho60(identificacaoNavio, "Identificação do Navio");
        this.identificacaoNavio = identificacaoNavio;
    }

    public List<CTeNotaInfoCTeNormalInfoModalAquaviarioBalsa> getBalsa() {
        return this.balsa;
    }

    /**
     * Grupo de informações das balsas
     */
    public void setBalsa(final List<CTeNotaInfoCTeNormalInfoModalAquaviarioBalsa> balsa) {
        DFListValidador.tamanho3(balsa, "");
        this.balsa = balsa;
    }

    public String getNumeroViagem() {
        return this.numeroViagem;
    }

    /**
     * Número da Viagem
     */
    public void setNumeroViagem(final String numeroViagem) {
        DFStringValidador.tamanho10(numeroViagem, "Número da Viagem");
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

    public CTModalAquavTpNav getTpNav() {
        return tpNav;
    }

    public void setTpNav(CTModalAquavTpNav tpNav) {
       this.tpNav = tpNav;
    }

    /**
     * Irin do navio sempre deverá ser informado
     */
    public void setIrin(final String irin) {
        DFStringValidador.tamanho10(irin, "Irin do navio");
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
