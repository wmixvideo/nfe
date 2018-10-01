package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoCombustivelTipo;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoEspecieVeiculo;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoVeiculoCondicao;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoVeiculoCondicaoChassi;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoVeiculoRestricao;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoVeiculoTipoOperacao;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoTipoVeiculo;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoVeiculoCor;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.IntegerValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoVeiculo extends DFBase {
    private static final long serialVersionUID = -8723829235875523827L;

    @Element(name = "tpOp")
    private NFNotaInfoItemProdutoVeiculoTipoOperacao tipoOperacao;

    @Element(name = "chassi")
    private String chassi;

    @Element(name = "cCor")
    private String codigoCor;

    @Element(name = "xCor")
    private String descricaoCor;

    @Element(name = "pot")
    private String potencia;

    @Element(name = "cilin")
    private String cilindrada;

    @Element(name = "pesoL")
    private String pesoLiquido;

    @Element(name = "pesoB")
    private String pesoBruto;

    @Element(name = "nSerie")
    private String numeroSerie;

    @Element(name = "tpComb")
    private NFNotaInfoCombustivelTipo tipoCombustivel;

    @Element(name = "nMotor")
    private String numeroMotor;

    @Element(name = "CMT")
    private String capacidadeMaximaTracao;

    @Element(name = "dist")
    private String distanciaEntreEixos;

    @Element(name = "anoMod")
    private Integer anoModeloFabricacao;

    @Element(name = "anoFab")
    private Integer anoFabricacao;

    @Element(name = "tpPint")
    private String tipoPintura;

    @Element(name = "tpVeic")
    private NFNotaInfoTipoVeiculo tipoVeiculo;

    @Element(name = "espVeic")
    private NFNotaInfoEspecieVeiculo especieVeiculo;

    @Element(name = "VIN")
    private NFNotaInfoItemProdutoVeiculoCondicaoChassi condicaoChassi;

    @Element(name = "condVeic")
    private NFNotaInfoItemProdutoVeiculoCondicao condicao;

    @Element(name = "cMod")
    private String codigoMarcaModelo;

    @Element(name = "cCorDENATRAN")
    private NFNotaInfoVeiculoCor corDENATRAN;

    @Element(name = "lota")
    private Integer lotacao;

    @Element(name = "tpRest")
    private NFNotaInfoItemProdutoVeiculoRestricao restricao;

    public void setTipoOperacao(final NFNotaInfoItemProdutoVeiculoTipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public void setChassi(final String chassi) {
        StringValidador.exatamente17(chassi, "Chassi Veiculo");
        this.chassi = chassi;
    }

    public void setCodigoCor(final String codigoCor) {
        StringValidador.exatamente4(codigoCor, "Codigo Cor Veiculo");
        this.codigoCor = codigoCor;
    }

    public void setDescricaoCor(final String descricaoCor) {
        StringValidador.tamanho40(descricaoCor, "Descricao Cor Veiculo");
        this.descricaoCor = descricaoCor;
    }

    public void setPotencia(final String potencia) {
        StringValidador.exatamente4(potencia, "Potencia Veiculo");
        this.potencia = potencia;
    }

    public void setCilindrada(final String cilindrada) {
        StringValidador.exatamente4(cilindrada, "Cilindrada Veiculo");
        this.cilindrada = cilindrada;
    }

    public void setPesoLiquido(final BigDecimal pesoLiquido) {
        this.pesoLiquido = BigDecimalParser.tamanho9Com4CasasDecimais(pesoLiquido, "Peso Liquido Veiculo");
    }

    public void setPesoBruto(final BigDecimal pesoBruto) {
        this.pesoBruto = BigDecimalParser.tamanho9Com4CasasDecimais(pesoBruto, "Peso Bruto Veiculo");
    }

    public void setNumeroSerie(final String numeroSerie) {
        StringValidador.exatamente9(numeroSerie, "Numero Serie Veiculo");
        this.numeroSerie = numeroSerie;
    }

    public void setTipoCombustivel(final NFNotaInfoCombustivelTipo tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public void setNumeroMotor(final String numeroMotor) {
        StringValidador.validaIntervalo(numeroMotor,1,21, "Numero Motor Veiculo");
        this.numeroMotor = numeroMotor;
    }

    public void setCapacidadeMaximaTracao(final BigDecimal capacidadeMaximaTracao) {
        this.capacidadeMaximaTracao = BigDecimalParser.tamanho9Com4CasasDecimais(capacidadeMaximaTracao, "Capacidade Maxima Tracao Veiculo");
    }

    public void setDistanciaEntreEixos(final String distanciaEntreEixos) {
        StringValidador.exatamente4(distanciaEntreEixos, "Distancia Entre Eixos Veiculo");
        this.distanciaEntreEixos = distanciaEntreEixos;
    }

    public void setAnoModeloFabricacao(final int anoModeloFabricacao) {
        IntegerValidador.exatamente4(anoModeloFabricacao, "Ano Modelo Fabricacao Veiculo");
        this.anoModeloFabricacao = anoModeloFabricacao;
    }

    public void setAnoFabricacao(final int anoFabricacao) {
        IntegerValidador.exatamente4(anoFabricacao, "Ano Fabricacao Veiculo");
        this.anoFabricacao = anoFabricacao;
    }

    public void setTipoPintura(final String tipoPintura) {
        StringValidador.exatamente1(tipoPintura, "Tipo Pintura Veiculo");
        this.tipoPintura = tipoPintura;
    }

    public void setTipoVeiculo(final NFNotaInfoTipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public void setEspecieVeiculo(final NFNotaInfoEspecieVeiculo especieVeiculo) {
        this.especieVeiculo = especieVeiculo;
    }

    public void setCondicaoChassi(final NFNotaInfoItemProdutoVeiculoCondicaoChassi condicaoChassi) {
        this.condicaoChassi = condicaoChassi;
    }

    public void setCondicao(final NFNotaInfoItemProdutoVeiculoCondicao condicao) {
        this.condicao = condicao;
    }

    public void setCodigoMarcaModelo(final String codigoMarcaModelo) {
        StringValidador.exatamente6N(codigoMarcaModelo, "Codigo Marca Modelo Veiculo");
        this.codigoMarcaModelo = codigoMarcaModelo;
    }

    public void setCodigoCorDENATRAN(final NFNotaInfoVeiculoCor corDENATRAN) {
        this.corDENATRAN = corDENATRAN;
    }

    public void setLotacao(final int lotacao) {
        IntegerValidador.tamanho3(lotacao, "Lotacao Veiculo");
        this.lotacao = lotacao;
    }

    public void setRestricao(final NFNotaInfoItemProdutoVeiculoRestricao restricao) {
        this.restricao = restricao;
    }

    public NFNotaInfoItemProdutoVeiculoTipoOperacao getTipoOperacao() {
        return this.tipoOperacao;
    }

    public String getChassi() {
        return this.chassi;
    }

    public String getCodigoCor() {
        return this.codigoCor;
    }

    public String getDescricaoCor() {
        return this.descricaoCor;
    }

    public String getPotencia() {
        return this.potencia;
    }

    public String getCilindrada() {
        return this.cilindrada;
    }

    public String getPesoLiquido() {
        return this.pesoLiquido;
    }

    public String getPesoBruto() {
        return this.pesoBruto;
    }

    public String getNumeroSerie() {
        return this.numeroSerie;
    }

    public NFNotaInfoCombustivelTipo getTipoCombustivel() {
        return this.tipoCombustivel;
    }

    public String getNumeroMotor() {
        return this.numeroMotor;
    }

    public String getCapacidadeMaximaTracao() {
        return this.capacidadeMaximaTracao;
    }

    public String getDistanciaEntreEixos() {
        return this.distanciaEntreEixos;
    }

    public Integer getAnoModeloFabricacao() {
        return this.anoModeloFabricacao;
    }

    public Integer getAnoFabricacao() {
        return this.anoFabricacao;
    }

    public String getTipoPintura() {
        return this.tipoPintura;
    }

    public NFNotaInfoTipoVeiculo getTipoVeiculo() {
        return this.tipoVeiculo;
    }

    public NFNotaInfoEspecieVeiculo getEspecieVeiculo() {
        return this.especieVeiculo;
    }

    public NFNotaInfoItemProdutoVeiculoCondicaoChassi getCondicaoChassi() {
        return this.condicaoChassi;
    }

    public NFNotaInfoItemProdutoVeiculoCondicao getCondicao() {
        return this.condicao;
    }

    public String getCodigoMarcaModelo() {
        return this.codigoMarcaModelo;
    }

    public NFNotaInfoVeiculoCor getCorDENATRAN() {
        return this.corDENATRAN;
    }

    public Integer getLotacao() {
        return this.lotacao;
    }

    public NFNotaInfoItemProdutoVeiculoRestricao getRestricao() {
        return this.restricao;
    }
}