package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.NFProdutoCompoeValorNota;

public class NFNotaInfoItemProdutoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorUnitarioTributavelComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorUnitarioTributavel(new BigDecimal("10000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorUnitarioComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorUnitario(new BigDecimal("10000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalBrutoComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorTotalBruto(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorSeguroComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorSeguro(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorOutrasDespesasAcessoriasComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorOutrasDespesasAcessorias(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorFreteComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorFrete(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorDescontoComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setValorDesconto(new BigDecimal("1000000000000"));
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

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeTributavelComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setQuantidadeTributavel(new BigDecimal("10000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeComercialComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setQuantidadeComercial(new BigDecimal("10000000000"));
    }

    @Test(expected = IllegalStateException.class)
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
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setNcm("U0sDjya");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setNcm("U0s");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setNcm("U");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtipiComTamanhoInvalido() {
        new NFNotaInfoItemProduto().setExtipi(1000);
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
            new NFNotaInfoItemProduto().setCodigoDeBarrasTributavel("368119635325051");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasTributavel("EyiQt2RGqEJ");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasTributavel("EyiQt2RGq");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasTributavel("EyiQt2R");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarrasTributavel("E");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void naoDeveCodigoDeBarrasComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarras("356472100398615");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarras("EyiQt2RGqEJ");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarras("EyiQt2RGq");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarras("EyiQt2R");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            new NFNotaInfoItemProduto().setCodigoDeBarras("E");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
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
    public void devePermitirArmamentosNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCfopNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirCodigoDeBarrasNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
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
        produto.toString();
    }

    @Test
    public void devePermitirCodigoDeBarrasTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
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
        produto.toString();
    }

    @Test
    public void devePermitirCombustivelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCompoeValotNotaNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirDeclaracoesImportacaoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void devePermitirDescricaoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirExtipiNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirMedicamentosNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNcmNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirNumeroPedidoClienteNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirNumeroPedidoItemClienteNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeComercialNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUnidadeComercialNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUnidadeTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirValorDescontoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("99999999");
        produto.setNumeroPedidoCliente("NNxQ9nrQ3HCe5Mc");
        produto.setNumeroPedidoItemCliente(999999);
        produto.setQuantidadeComercial(new BigDecimal("9999999999.9999"));
        produto.setQuantidadeTributavel(new BigDecimal("9999999999.9999"));
        produto.setUnidadeComercial("Bta64y");
        produto.setUnidadeTributavel("7wqG4h");
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
    public void devePermitirValorFreteNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirValorOutrasDespesasAcessoriasNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirValorSeguroNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalBrutoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.setValorUnitario(new BigDecimal("9999999999.9999999999"));
        produto.setValorUnitarioTributavel(new BigDecimal("9999999999.9999999999"));
        produto.setNumeroControleFCI("B01F70AF-10BF-4B1F-848C-65FF57F616FE");
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorUnitarioNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorUnitarioTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void devePermitirVeiculoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("1302");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("36811963532505");
        produto.setCodigoDeBarrasTributavel("36811963532505");
        produto.setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
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
        produto.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>SC</UFDesemb><dDesemb>2014-01-01</dDesemb><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><med><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal><vPMC>999999999999.99</vPMC></med></NFNotaInfoItemProduto>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProduto().toString());
    }
}