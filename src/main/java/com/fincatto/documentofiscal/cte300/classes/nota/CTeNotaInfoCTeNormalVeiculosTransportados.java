package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * @author Caio
 * @info informações dos veículos transportados
 */

@Root(name = "veicNovos")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalVeiculosTransportados extends DFBase {
    private static final long serialVersionUID = 1369667859453686493L;
    
    @Element(name = "chassi")
    private String chassi;
    
    @Element(name = "cCor")
    private String codigoCor;
    
    @Element(name = "xCor")
    private String descricaoCor;
    
    @Element(name = "cMod")
    private String codigoMarcaModelo;
    
    @Element(name = "vUnit")
    private String valorUnitario;
    
    @Element(name = "vFrete")
    private String valorFrete;

    public CTeNotaInfoCTeNormalVeiculosTransportados() {
        this.chassi = null;
        this.codigoCor = null;
        this.descricaoCor = null;
        this.codigoMarcaModelo = null;
        this.valorUnitario = null;
        this.valorFrete = null;
    }

    public String getChassi() {
        return this.chassi;
    }

    /**
     * Chassi do veículo
     */
    public void setChassi(final String chassi) {
        StringValidador.exatamente17(chassi, "Chassi do veículo");
        this.chassi = chassi;
    }

    public String getCodigoCor() {
        return this.codigoCor;
    }

    /**
     * Cor do veículo<br>
     * Código de cada montadora
     */
    public void setCodigoCor(final String codigoCor) {
        StringValidador.tamanho4(codigoCor, "Cor do veículo");
        this.codigoCor = codigoCor;
    }

    public String getDescricaoCor() {
        return this.descricaoCor;
    }

    /**
     * Descrição da cor
     */
    public void setDescricaoCor(final String descricaoCor) {
        StringValidador.tamanho40(descricaoCor, "Descrição da cor");
        this.descricaoCor = descricaoCor;
    }

    public String getCodigoMarcaModelo() {
        return this.codigoMarcaModelo;
    }

    /**
     * Código Marca Modelo<br>
     * Utilizar tabela RENAVAM
     */
    public void setCodigoMarcaModelo(final String codigoMarcaModelo) {
        StringValidador.tamanho6(codigoMarcaModelo, "Código Marca Modelo");
        this.codigoMarcaModelo = codigoMarcaModelo;
    }

    public String getValorUnitario() {
        return this.valorUnitario;
    }

    /**
     * Valor Unitário do Veículo
     */
    public void setValorUnitario(final BigDecimal valorUnitario) {
        this.valorUnitario = BigDecimalValidador.tamanho15Com2CasasDecimais(valorUnitario, "Valor Unitário do Veículo");
    }

    public String getValorFrete() {
        return this.valorFrete;
    }

    /**
     * Frete Unitário
     */
    public void setValorFrete(final BigDecimal valorFrete) {
        this.valorFrete = BigDecimalValidador.tamanho15Com2CasasDecimais(valorFrete, "Frete Unitário");
    }
}
