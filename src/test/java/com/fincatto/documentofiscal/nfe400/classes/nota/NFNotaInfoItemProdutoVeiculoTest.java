package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoVeiculoTest {

    @Test
    public void naoDevePermitirPotenciaComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setPotencia("ABC");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoVeiculo().setTipoPintura("ABCDE");
            }
        });
    }

    @Test
    public void naoDevePermitirTipoPenturaComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setTipoPintura("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoVeiculo().setTipoPintura("A1");
            }
        });
    }

    @Test
    public void naoDevePermitirPesoLiquidoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoVeiculo().setPesoLiquido(new BigDecimal("100000")));
    }

    @Test
    public void naoDevePermitirPesoBrutoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoVeiculo().setPesoBruto(new BigDecimal("100000")));
    }

    @Test
    public void naoDevePermitirNumeroSerieComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setNumeroSerie("XBxVyiVV");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoVeiculo().setNumeroSerie("XBxVyiVVD1");
            }
        });
    }

    @Test
    public void naoDevePermitirNumeroMotorComTamanhoInvalido() {
            Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemProdutoVeiculo().setNumeroMotor("1234567891011121314151617181920"));
    }

    @Test
    public void naoDevePermitirLotacaoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoVeiculo().setLotacao(1000));
    }

    @Test
    public void naoDevePermitirDistanciaEntreEixosComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setDistanciaEntreEixos("ABC");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoVeiculo().setDistanciaEntreEixos("ABCDE");
            }
        });
    }

    @Test
    public void naoDevePermitirDescricaoCorComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setDescricaoCor("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoVeiculo().setDescricaoCor("tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p91");
            }
        });
    }

    @Test
    public void naoDevePermitirCodigoMarcaModeloComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setCodigoMarcaModelo("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoVeiculo().setCodigoMarcaModelo("5425621");
            }
        });
    }

    @Test
    public void naoDevePermitirCodigoCorComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setCodigoCor("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoVeiculo().setCodigoCor("123A1");
            }
        });
    }

    @Test
    public void naoDevePermitirCilindradaComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setCilindrada("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoVeiculo().setCilindrada("ohNx1");
            }
        });
    }

    @Test
    public void naoDevePermitirChassiComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setChassi("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoVeiculo().setChassi("B31YTE9INXEYDMO4C1");
            }
        });
    }

    @Test
    public void naoDevePermitirCapacidadeMaximaTracaoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoVeiculo().setCapacidadeMaximaTracao(new BigDecimal("100000")));
    }

    @Test
    public void naoDevePermitirAnoModeloFabricacaoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setAnoModeloFabricacao(999);
            } catch (final NumberFormatException e) {
                new NFNotaInfoItemProdutoVeiculo().setAnoModeloFabricacao(10000);
            }
        });
    }

    @Test
    public void naoDevePermitirAnoFabricacaoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            try {
                new NFNotaInfoItemProdutoVeiculo().setAnoFabricacao(999);
            } catch (final NumberFormatException e) {
                new NFNotaInfoItemProdutoVeiculo().setAnoFabricacao(10000);
            }
        });
    }

    @Test
    public void naoDevePermitirAnoFabricacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirAnoModeloFabricacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirCapacidadeMaximaTracaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirChassiNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirCilindradaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirCodigoCorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirCodigoCorDENATRANNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirCodigoMarcaModeloNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirCondicaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirCondicaoChassiNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirDescricaoCorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirDistanciaEntreEixosNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirEspecieVeiculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirLotacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirNumeroMotorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirNumeroSerieNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirPesoBrutoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirPesoLiquidoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirPotenciaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirRestricaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirTipoCombustivelNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirTipoOperacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirTipoPinturaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirTipoVeiculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoVeiculo><tpOp>0</tpOp><chassi>B31YTE9INXEYDMO4C</chassi><cCor>123A</cCor><xCor>tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9</xCor><pot>GZRz</pot><cilin>ohNx</cilin><pesoL>9999.9999</pesoL><pesoB>9999.9999</pesoB><nSerie>XBxVyiVVD</nSerie><tpComb>02</tpComb><nMotor>u1DU8GZRzJZzevuY49IB9</nMotor><CMT>9999.9999</CMT><dist>9999</dist><anoMod>2014</anoMod><anoFab>2014</anoFab><tpPint>A</tpPint><tpVeic>6</tpVeic><espVeic>4</espVeic><VIN>N</VIN><condVeic>1</condVeic><cMod>542562</cMod><cCorDENATRAN>16</cCorDENATRAN><lota>999</lota><tpRest>4</tpRest></NFNotaInfoItemProdutoVeiculo>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo().toString());
    }
}