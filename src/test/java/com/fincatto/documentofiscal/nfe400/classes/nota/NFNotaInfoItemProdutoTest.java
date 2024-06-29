package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFProdutoCompoeValorNota;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NFNotaInfoItemProdutoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNomeclaturaForaDoPadrao() {
        new NFNotaInfoItemProduto().setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("ABC0123"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorUnitarioTributavelComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorUnitarioTributavel(new BigDecimal("100000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCESTComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setCodigoEspecificadorSituacaoTributaria("999999");
            Assert.fail();
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProduto().setCodigoEspecificadorSituacaoTributaria("10000000");
            Assert.fail();
        }
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorUnitarioComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorUnitario(new BigDecimal("100000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTotalBrutoComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorTotalBruto(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorSeguroComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorSeguro(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorOutrasDespesasAcessoriasComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorOutrasDespesasAcessorias(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorFreteComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorFrete(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorDescontoComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorDesconto(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUnidadeTributavelComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setUnidadeTributavel("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProduto().setUnidadeTributavel("7wqG4h1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUnidadeComercialComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setUnidadeComercial("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProduto().setUnidadeComercial("7wqG4h1");
        }
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeTributavelComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setQuantidadeTributavel(new BigDecimal("100000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeComercialComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setQuantidadeComercial(new BigDecimal("100000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirNumeroPedidoItemClienteComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setNumeroPedidoItemCliente(1000000);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroPedidoClienteComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setNumeroPedidoCliente("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProduto().setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc1");
        }
    }

    @Test
    public void naoDevePermitirNcmComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setNcm("999999991");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setNcm("U0sDjya");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setNcm("U0s");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setNcm("U");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtipiComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setExtipi("1000");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDescricaoComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setDescricao("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProduto().setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP1");
        }
    }

    @Test
    public void naoDeveCodigoDeBarrasTributavelComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtinTributavel("368119635325051");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtinTributavel("EyiQt2RGqEJ");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtinTributavel("EyiQt2RGq");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtinTributavel("EyiQt2R");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtinTributavel("E");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDeveCodigoDeBarrasComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtin("356472100398615");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtin("EyiQt2RGqEJ");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtin("EyiQt2RGq");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtin("EyiQt2R");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasGtin("E");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setCodigo("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProduto().setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCfopComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setCfop("13021");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroControleComFormatoInvalido() {
        new NFNotaInfoItemProduto().setNumeroControleFCI("B01F70AFA-10BF-4B1F-848C-65FF57F616F6");
    }

    @Test
    public void devePermitirsetNomeclaturaValorAduaneiroEstatisticaNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.toString();
    }

    @Test
    public void devePermitirArmamentosNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCfopNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoDeBarrasNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoDeBarrasTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test
    public void devePermitirCombustivelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCompoeValotNotaNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test
    public void devePermitirDeclaracoesImportacaoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void devePermitirDescricaoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.toString();
    }

    @Test
    public void devePermitirExtipiNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.toString();
    }

    @Test
    public void devePermitirMedicamentosNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNcmNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.toString();
    }

    @Test
    public void devePermitirNumeroPedidoClienteNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test
    public void devePermitirNumeroPedidoItemClienteNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeComercialNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUnidadeComercialNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUnidadeTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test
    public void devePermitirValorDescontoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test
    public void devePermitirValorFreteNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test
    public void devePermitirValorOutrasDespesasAcessoriasNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test
    public void devePermitirValorSeguroNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalBrutoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorUnitarioNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorUnitarioTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test
    public void naoDevePermitirSetarVeiculoCasoArmamentoOuCombustivelOuRECOPISetado() {
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setNumeroRECOPI("13245678901234567890");
            produto.setVeiculo(new NFNotaInfoItemProdutoVeiculo());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setArmamentos(new ArrayList<>());
            produto.setVeiculo(new NFNotaInfoItemProdutoVeiculo());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setCombustivel(new NFNotaInfoItemProdutoCombustivel());
            produto.setVeiculo(new NFNotaInfoItemProdutoVeiculo());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setMedicamento(new NFNotaInfoItemProdutoMedicamento());
            produto.setVeiculo(new NFNotaInfoItemProdutoVeiculo());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarArmamentoCasoVeiculoMedicamentoCombustivelOuRECOPISetado() {
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setArmamentos(new ArrayList<>());
            produto.setVeiculo(new NFNotaInfoItemProdutoVeiculo());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setArmamentos(new ArrayList<>());
            produto.setMedicamento(new NFNotaInfoItemProdutoMedicamento());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setArmamentos(new ArrayList<>());
            produto.setCombustivel(new NFNotaInfoItemProdutoCombustivel());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setArmamentos(new ArrayList<>());
            produto.setNumeroRECOPI("12346578901234567890");
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarRECOPICasoVeiculoMedicamentoCombustivelSetadoOuArmamento() {
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setNumeroRECOPI("12346578901234567890");
            produto.setVeiculo(new NFNotaInfoItemProdutoVeiculo());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setNumeroRECOPI("12346578901234567890");
            produto.setMedicamento(new NFNotaInfoItemProdutoMedicamento());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setNumeroRECOPI("12346578901234567890");
            produto.setCombustivel(new NFNotaInfoItemProdutoCombustivel());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setNumeroRECOPI("12346578901234567890");
            produto.setArmamentos(new ArrayList<>());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarMedicamentoCasoVeiculoArmamentoCombustivelOuRECOPISetado() {
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setVeiculo(new NFNotaInfoItemProdutoVeiculo());
            produto.setMedicamento(new NFNotaInfoItemProdutoMedicamento());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setArmamentos(new ArrayList<>());
            produto.setMedicamento(new NFNotaInfoItemProdutoMedicamento());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setNumeroRECOPI("013246578901234657890");
            produto.setMedicamento(new NFNotaInfoItemProdutoMedicamento());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
        try {
            final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
            produto.setCombustivel(new NFNotaInfoItemProdutoCombustivel());
            produto.setMedicamento(new NFNotaInfoItemProdutoMedicamento());
            Assert.fail();
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void devePermitirVeiculoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setDetalhesExportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao()));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.toString();
    }

    @Test
    public void devePermitirDetalhesExportacaoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasGtin("36811963532505");
        produto.setCodigoDeBarrasGtinTributavel("36811963532505");
        produto.setCompoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi("999");
        produto.setCodigoEspecificadorSituacaoTributaria("9999999");
        produto.setMedicamento(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento());
        produto.setRastros(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoRastreabilidade()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
        produto.setValorDesconto(new BigDecimal("999999999999.99"));
        produto.setValorFrete(new BigDecimal("999999999999.99"));
        produto.setValorOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        produto.setValorSeguro(new BigDecimal("999999999999.99"));
        produto.setValorTotalBruto(new BigDecimal("999999999999.99"));
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setNomeclaturaValorAduaneiroEstatistica(Collections.singletonList("AZ0123"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDetalhesImportacaoTamanhoInvalido() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();

        final List<NFNotaInfoItemDetalheExportacao> detalhes = new ArrayList<>();
        for (int i = 0; i < 501; i++) {
            detalhes.add(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao());
        }
        produto.setDetalhesExportacao(detalhes);
    }

    @Test
    public void deveObterCfopComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String cfop = "1302";
        produto.setCfop(cfop);
        Assert.assertEquals(cfop, produto.getCfop());
    }

    @Test
    public void deveObterCodigoComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String codigo = "ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq";
        produto.setCodigo(codigo);
        Assert.assertEquals(codigo, produto.getCodigo());
    }

    @Test
    public void deveObterCodigoDeBarrasComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String codigoDeBarras = "36811963532505";
        produto.setCodigoDeBarrasGtin(codigoDeBarras);
        Assert.assertEquals(codigoDeBarras, produto.getCodigoDeBarrasGtin());
    }

    @Test
    public void deveObterCodigoDeBarrasTributavelComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String codigoDeBarrasTributavel = "36811963532505";
        produto.setCodigoDeBarrasGtinTributavel(codigoDeBarrasTributavel);
        Assert.assertEquals(codigoDeBarrasTributavel, produto.getCodigoDeBarrasGtinTributavel());
    }

    @Test
    public void deveObterCompoeValorNotaComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final NFProdutoCompoeValorNota compoeValorNota = NFProdutoCompoeValorNota.SIM;
        produto.setCompoeValorNota(compoeValorNota);
        Assert.assertEquals(compoeValorNota, produto.getCompoeValorNota());
    }

    @Test
    public void deveObterDeclaracoesImportacaoComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final List<NFNotaInfoItemProdutoDeclaracaoImportacao> declaracoesImportacao = Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao());
        produto.setDeclaracoesImportacao(declaracoesImportacao);
        Assert.assertEquals(declaracoesImportacao, produto.getDeclaracoesImportacao());
    }

    @Test
    public void deveObterDescricaoComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String descricao = "OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP";
        produto.setDescricao(descricao);
        Assert.assertEquals(descricao, produto.getDescricao());
    }

    @Test
    public void deveObterExtipiComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String extipi = "999";
        produto.setExtipi(extipi);
        Assert.assertEquals(extipi, produto.getExtipi());
    }

    @Test
    public void deveObterCodigoEspecificadorSituacaoTributariaComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String codigoEspecificadorSituacaoTributaria = "9999999";
        produto.setCodigoEspecificadorSituacaoTributaria(codigoEspecificadorSituacaoTributaria);
        Assert.assertEquals(codigoEspecificadorSituacaoTributaria, produto.getCodigoEspecificadorSituacaoTributaria());
    }

    @Test
    public void deveObterMedicamentosComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        NFNotaInfoItemProdutoMedicamento nfNotaInfoItemProdutoMedicamento = FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento();
        produto.setMedicamento(nfNotaInfoItemProdutoMedicamento);
        Assert.assertEquals(nfNotaInfoItemProdutoMedicamento, produto.getMedicamento());
    }

    @Test
    public void deveObterNcmComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String ncm = "99999999";
        produto.setNcm(ncm);
        Assert.assertEquals(ncm, produto.getNcm());
    }

    @Test
    public void deveObterNumeroPedidoClienteComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String numeroPedidoCliente = "NNxQ9nrQ3HCe5Mc";
        produto.setNumeroPedidoCliente(numeroPedidoCliente);
        Assert.assertEquals(numeroPedidoCliente, produto.getNumeroPedidoCliente());
    }

    @Test
    public void deveObterNumeroPedidoItemClienteComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final Integer numeroPedidoItemCliente = 999999;
        produto.setNumeroPedidoItemCliente(numeroPedidoItemCliente);
        Assert.assertEquals(numeroPedidoItemCliente, produto.getNumeroPedidoItemCliente());
    }

    @Test
    public void deveObterQuantidadeComercialComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final BigDecimal quantidadeComercial = new BigDecimal("9999999999.9999");
        produto.setQuantidadeComercial(quantidadeComercial);
        Assert.assertEquals("9999999999.9999", produto.getQuantidadeComercial());
    }

    @Test
    public void deveObterQuantidadeTributavelComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final BigDecimal quantidadeTributavel = new BigDecimal("9999999999.9999");
        produto.setQuantidadeTributavel(quantidadeTributavel);
        Assert.assertEquals("9999999999.9999", produto.getQuantidadeTributavel());
    }

    @Test
    public void deveObterNnidadeComercialComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String unidadeComercial = "Bta64y";
        produto.setUnidadeComercial(unidadeComercial);
        Assert.assertEquals(unidadeComercial, produto.getUnidadeComercial());
    }

    @Test
    public void deveObterNnidadeTributavelComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String unidadeTributavel = "7wqG4h";
        produto.setUnidadeTributavel(unidadeTributavel);
        Assert.assertEquals(unidadeTributavel, produto.getUnidadeTributavel());
    }

    @Test
    public void deveObterValorDescontoComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final BigDecimal valorDesconto = new BigDecimal("999999999999.99");
        produto.setValorDesconto(valorDesconto);
        Assert.assertEquals("999999999999.99", produto.getValorDesconto());
    }

    @Test
    public void deveObterValorFreteComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final BigDecimal valorFrete = new BigDecimal("999999999999.99");
        produto.setValorFrete(valorFrete);
        Assert.assertEquals("999999999999.99", produto.getValorFrete());
    }

    @Test
    public void deveObterValorOutrasDespesasAcessoriasComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final BigDecimal valorOutrasDespesasAcessorias = new BigDecimal("999999999999.99");
        produto.setValorOutrasDespesasAcessorias(valorOutrasDespesasAcessorias);
        Assert.assertEquals("999999999999.99", produto.getValorOutrasDespesasAcessorias());
    }

    @Test
    public void deveObterValorSeguroComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final BigDecimal valorSeguro = new BigDecimal("999999999999.99");
        produto.setValorSeguro(valorSeguro);
        Assert.assertEquals("999999999999.99", produto.getValorSeguro());
    }

    @Test
    public void deveObterValorTotalBrutoComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final BigDecimal valorTotalBruto = new BigDecimal("999999999999.99");
        produto.setValorTotalBruto(valorTotalBruto);
        Assert.assertEquals("999999999999.99", produto.getValorTotalBruto());
    }

    @Test
    public void deveObterValorUnitarioComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final BigDecimal valorUnitario = new BigDecimal("9999999999.9999999999");
        produto.setValorUnitario(valorUnitario);
        Assert.assertEquals("9999999999.9999999999", produto.getValorUnitario());
    }

    @Test
    public void deveObterNomeclaturaValorAduaneiroEstatisticaComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final List<String> nomeclaturaValorAduaneiroEstatistica = Collections.singletonList("AZ0123");
        produto.setNomeclaturaValorAduaneiroEstatistica(nomeclaturaValorAduaneiroEstatistica);
        Assert.assertEquals(nomeclaturaValorAduaneiroEstatistica, produto.getNomeclaturaValorAduaneiroEstatistica());
    }

    @Test
    public void deveObterValorUnitarioTributavelComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final BigDecimal valorUnitarioTributavel = new BigDecimal("9999999999.9999999999");
        produto.setValorUnitarioTributavel(valorUnitarioTributavel);
        Assert.assertEquals("9999999999.9999999999", produto.getValorUnitarioTributavel());
    }

    @Test
    public void deveObterDetalhesExportacaoComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final List<NFNotaInfoItemDetalheExportacao> detalhesExportacao = Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemDetalheExportacao());
        produto.setDetalhesExportacao(detalhesExportacao);
        Assert.assertEquals(detalhesExportacao, produto.getDetalhesExportacao());
    }

    @Test
    public void deveObterNumeroControleFCIComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String numeroControleFCI = "B01F70AF-10BF-4B1F-848C-65FF57F616FE";
        produto.setNumeroControleFCI(numeroControleFCI);
        Assert.assertEquals(numeroControleFCI, produto.getNumeroControleFCI());
    }

    @Test
    public void deveObterArmamentosComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final List<NFNotaInfoItemProdutoArmamento> armamentos = Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento());
        produto.setArmamentos(armamentos);
        Assert.assertEquals(armamentos, produto.getArmamentos());
    }

    @Test
    public void deveObterVeiculoComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final NFNotaInfoItemProdutoVeiculo veiculo = FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo();
        produto.setVeiculo(veiculo);
        Assert.assertEquals(veiculo, produto.getVeiculo());
    }

    @Test
    public void deveObterCombustivelComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final NFNotaInfoItemProdutoCombustivel combustivel = FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel();
        produto.setCombustivel(combustivel);
        Assert.assertEquals(combustivel, produto.getCombustivel());
    }

    @Test
    public void deveObterNumeroRECOPIComoFoiSetado() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        final String numeroRECOPI = "13245678901234567890";
        produto.setNumeroRECOPI(numeroRECOPI);
        Assert.assertEquals(numeroRECOPI, produto.getNumeroRECOPI());
    }

    @Test
    public void deveRetornarSEMGTINCasoNaoPossuaCodigoDeBarras() {
        Assert.assertEquals("SEM GTIN", new NFNotaInfoItemProduto().getCodigoDeBarrasGtin());
    }

    @Test
    public void deveGerarTagsCeansVaziasQuandoProdutoNaoPossuiCodigoDeBarras() {
        final NFNotaInfoItemProduto notaInfoItemProduto = FabricaDeObjetosFake.getNFNotaInfoItemProduto();
        notaInfoItemProduto.setCodigoDeBarrasGtinTributavel("");
        notaInfoItemProduto.setCodigoDeBarrasGtin("");

        final String xmlEsperado = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN></cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib></cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></NFNotaInfoItemProduto>";
        Assert.assertEquals(xmlEsperado, notaInfoItemProduto.toString());
    }

    @Test
    public void deveGerarXMLComCeanECeanTribVaziosCasoSejaNuloAoSerParseado() throws Exception {
        final String xml = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN></cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib></cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></NFNotaInfoItemProduto>";
        final NFNotaInfoItemProduto notaInfoItemProduto = new DFPersister().read(NFNotaInfoItemProduto.class, xml);
        Assert.assertEquals(xml, notaInfoItemProduto.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoCodigoBarrasDiferenteGtin() {
        NFNotaInfoItemProduto nfNotaInfoItemProdutoSemCodigoBarras = FabricaDeObjetosFake.getNFNotaInfoItemProduto();
        nfNotaInfoItemProdutoSemCodigoBarras.setCodigoDeBarrasDiferenteGtin(null);
        nfNotaInfoItemProdutoSemCodigoBarras.setCodigoDeBarrasDiferenteGtinTributavel(null);
        final String xmlEsperado = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></NFNotaInfoItemProduto>";
        Assert.assertEquals(xmlEsperado, nfNotaInfoItemProdutoSemCodigoBarras.toString());

        NFNotaInfoItemProduto nfNotaInfoItemProdutoComCodigoBarras = FabricaDeObjetosFake.getNFNotaInfoItemProduto();
        nfNotaInfoItemProdutoComCodigoBarras.setCodigoDeBarrasDiferenteGtin("100000");
        nfNotaInfoItemProdutoComCodigoBarras.setCodigoDeBarrasDiferenteGtinTributavel("100000");
        final String xmlEsperadoII = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><cBarra>100000</cBarra><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><cBarraTrib>100000</cBarraTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></NFNotaInfoItemProduto>";
        Assert.assertEquals(xmlEsperadoII, nfNotaInfoItemProdutoComCodigoBarras.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoCodigoBarrasGtin() {
        NFNotaInfoItemProduto nfNotaInfoItemProdutoSemCodigoBarras = FabricaDeObjetosFake.getNFNotaInfoItemProduto();
        nfNotaInfoItemProdutoSemCodigoBarras.setCodigoDeBarrasGtin(null);
        nfNotaInfoItemProdutoSemCodigoBarras.setCodigoDeBarrasGtinTributavel(null);
        final String xmlEsperado = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></NFNotaInfoItemProduto>";
        Assert.assertEquals(xmlEsperado, nfNotaInfoItemProdutoSemCodigoBarras.toString());

        NFNotaInfoItemProduto nfNotaInfoItemProdutoComCodigoBarras = FabricaDeObjetosFake.getNFNotaInfoItemProduto();
        nfNotaInfoItemProdutoComCodigoBarras.setCodigoDeBarrasGtin("36811963532505");
        nfNotaInfoItemProdutoComCodigoBarras.setCodigoDeBarrasGtinTributavel("36811963532505");
        final String xmlEsperadoII = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></NFNotaInfoItemProduto>";
        Assert.assertEquals(xmlEsperadoII, nfNotaInfoItemProdutoComCodigoBarras.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoGrupoCreditoPresumido() {
        final NFNotaInfoItemProdutoGrupoCreditoPresumido grupoCreditoPresumido = new NFNotaInfoItemProdutoGrupoCreditoPresumido();
        grupoCreditoPresumido.setCodigoBeneficioFiscalCreditoPresumido("DF020111");
        grupoCreditoPresumido.setPercentualCreditoPresumido(new BigDecimal("65.12"));
        grupoCreditoPresumido.setValorCreditoPresumido(new BigDecimal("12.73"));

        final NFNotaInfoItemProduto nfNotaInfoItemProdutoGrupoCreditoPresumido = FabricaDeObjetosFake.getNFNotaInfoItemProduto();
        nfNotaInfoItemProdutoGrupoCreditoPresumido.setGrupoCreditoPresumido(grupoCreditoPresumido);

        final String xmlEsperado = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><gCred><cCredPresumido>DF020111</cCredPresumido><pCredPresumido>65.12</pCredPresumido><vCredPresumido>12.73</vCredPresumido></gCred><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></NFNotaInfoItemProduto>";
        Assert.assertEquals(xmlEsperado, nfNotaInfoItemProdutoGrupoCreditoPresumido.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></NFNotaInfoItemProduto>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProduto().toString());
    }
}