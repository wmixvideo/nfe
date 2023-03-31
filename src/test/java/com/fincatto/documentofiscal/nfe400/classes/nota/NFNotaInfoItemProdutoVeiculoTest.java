package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoCombustivelTipo;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoEspecieVeiculo;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoVeiculoCondicao;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoVeiculoCondicaoChassi;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoVeiculoRestricao;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoVeiculoTipoOperacao;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoTipoVeiculo;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoVeiculoCor;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoVeiculoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPotenciaComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setPotencia("ABC");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoVeiculo().setTipoPintura("ABCDE");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoPenturaComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setTipoPintura("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoVeiculo().setTipoPintura("A1");
        }
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPesoLiquidoComTamanhoInvalido() {
        new NFNotaInfoItemProdutoVeiculo().setPesoLiquido(new BigDecimal("100000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPesoBrutoComTamanhoInvalido() {
        new NFNotaInfoItemProdutoVeiculo().setPesoBruto(new BigDecimal("100000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroSerieComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setNumeroSerie("XBxVyiVV");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoVeiculo().setNumeroSerie("XBxVyiVVD1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroMotorComTamanhoInvalido() {
            new NFNotaInfoItemProdutoVeiculo().setNumeroMotor("1234567891011121314151617181920");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirLotacaoComTamanhoInvalido() {
        new NFNotaInfoItemProdutoVeiculo().setLotacao(1000);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDistanciaEntreEixosComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setDistanciaEntreEixos("ABC");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoVeiculo().setDistanciaEntreEixos("ABCDE");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDescricaoCorComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setDescricaoCor("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoVeiculo().setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p91");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMarcaModeloComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setCodigoMarcaModelo("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoVeiculo().setCodigoMarcaModelo("5425621");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoCorComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setCodigoCor("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoVeiculo().setCodigoCor("123A1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCilindradaComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setCilindrada("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoVeiculo().setCilindrada("ohNx1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChassiComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setChassi("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoVeiculo().setChassi("B31YTE9INXEYDMO4C1");
        }
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirCapacidadeMaximaTracaoComTamanhoInvalido() {
        new NFNotaInfoItemProdutoVeiculo().setCapacidadeMaximaTracao(new BigDecimal("100000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirAnoModeloFabricacaoComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setAnoModeloFabricacao(999);
        } catch (final NumberFormatException e) {
            new NFNotaInfoItemProdutoVeiculo().setAnoModeloFabricacao(10000);
        }
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirAnoFabricacaoComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoVeiculo().setAnoFabricacao(999);
        } catch (final NumberFormatException e) {
            new NFNotaInfoItemProdutoVeiculo().setAnoFabricacao(10000);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAnoFabricacaoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAnoModeloFabricacaoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCapacidadeMaximaTracaoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChassiNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCilindradaNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoCorNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoCorDENATRANNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMarcaModeloNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCondicaoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCondicaoChassiNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDescricaoCorNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDistanciaEntreEixosNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirEspecieVeiculoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLotacaoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroMotorNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroSerieNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPesoBrutoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPesoLiquidoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPotenciaNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirRestricaoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoCombustivelNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoOperacaoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoPinturaNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoVeiculo(NFNotaInfoTipoVeiculo.AUTOMOVEL);
        produtoVeiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoVeiculoNulo() {
        final NFNotaInfoItemProdutoVeiculo produtoVeiculo = new NFNotaInfoItemProdutoVeiculo();
        produtoVeiculo.setAnoFabricacao(2014);
        produtoVeiculo.setAnoModeloFabricacao(2014);
        produtoVeiculo.setCapacidadeMaximaTracao(new BigDecimal("9999.9999"));
        produtoVeiculo.setChassi("B31YTE9INXEYDMO4C");
        produtoVeiculo.setCilindrada("ohNx");
        produtoVeiculo.setCodigoCor("123A");
        produtoVeiculo.setCodigoCorDENATRAN(NFNotaInfoVeiculoCor.FANTASIA);
        produtoVeiculo.setCodigoMarcaModelo("542562");
        produtoVeiculo.setCondicao(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO);
        produtoVeiculo.setCondicaoChassi(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL);
        produtoVeiculo.setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9");
        produtoVeiculo.setDistanciaEntreEixos("9999");
        produtoVeiculo.setEspecieVeiculo(NFNotaInfoEspecieVeiculo.CORRIDA);
        produtoVeiculo.setLotacao(999);
        produtoVeiculo.setNumeroMotor("u1DU8GZRzJZzevuY49IB9");
        produtoVeiculo.setNumeroSerie("XBxVyiVVD");
        produtoVeiculo.setPesoBruto(new BigDecimal("9999.9999"));
        produtoVeiculo.setPesoLiquido(new BigDecimal("9999.9999"));
        produtoVeiculo.setPotencia("GZRz");
        produtoVeiculo.setRestricao(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR);
        produtoVeiculo.setTipoCombustivel(NFNotaInfoCombustivelTipo.GASOLINA);
        produtoVeiculo.setTipoOperacao(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS);
        produtoVeiculo.setTipoPintura("A");
        produtoVeiculo.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoVeiculo><tpOp>0</tpOp><chassi>B31YTE9INXEYDMO4C</chassi><cCor>123A</cCor><xCor>tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9</xCor><pot>GZRz</pot><cilin>ohNx</cilin><pesoL>9999.9999</pesoL><pesoB>9999.9999</pesoB><nSerie>XBxVyiVVD</nSerie><tpComb>02</tpComb><nMotor>u1DU8GZRzJZzevuY49IB9</nMotor><CMT>9999.9999</CMT><dist>9999</dist><anoMod>2014</anoMod><anoFab>2014</anoFab><tpPint>A</tpPint><tpVeic>6</tpVeic><espVeic>4</espVeic><VIN>N</VIN><condVeic>1</condVeic><cMod>542562</cMod><cCorDENATRAN>16</cCorDENATRAN><lota>999</lota><tpRest>4</tpRest></NFNotaInfoItemProdutoVeiculo>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo().toString());
    }
}