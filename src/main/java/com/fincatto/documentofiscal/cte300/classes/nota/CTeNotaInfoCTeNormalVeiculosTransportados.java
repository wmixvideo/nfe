package com.fincatto.documentofiscal.cte300.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info informações dos veículos transportados
 */

@Root(name = "veicNovos")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalVeiculosTransportados extends DFBase {
    private static final long serialVersionUID = 1369667859453686493L;

    @Element(name = "chassi", required = true)
    private String chassi;

    @Element(name = "cCor", required = true)
    private String codigoCor;

    @Element(name = "xCor", required = true)
    private String descricaoCor;

    @Element(name = "cMod", required = true)
    private String codigoMarcaModelo;

    @Element(name = "vUnit", required = true)
    private String valorUnitario;

    @Element(name = "vFrete", required = true)
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
        this.valorUnitario = BigDecimalParser.tamanho15Com2CasasDecimais(valorUnitario, "Valor Unitário do Veículo");
    }

    public String getValorFrete() {
        return this.valorFrete;
    }

    /**
     * Frete Unitário
     */
    public void setValorFrete(final BigDecimal valorFrete) {
        this.valorFrete = BigDecimalParser.tamanho15Com2CasasDecimais(valorFrete, "Frete Unitário");
    }
}
