package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;
import com.fincatto.nfe.classes.NFProdutoCompoeValorNota;

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
            new NFNotaInfoItemProduto().setNcm("U0sDjyan1");
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
            new NFNotaInfoItemProduto().setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR1");
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
            new NFNotaInfoItemProduto().setCodigoDeBarras("EyiQt2RGqEJBPR1");
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
        new NFNotaInfoItemProduto().setCfop("qW2d1");
    }

    @Test
    public void devePermitirArmamentosNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCfopNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoDeBarrasNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoDeBarrasTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test
    public void devePermitirCombustivelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCompoeValotNotaNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test
    public void devePermitirDeclaracoesImportacaoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void devePermitirDescricaoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test
    public void devePermitirExtipiNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test
    public void devePermitirMedicamentosNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNcmNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
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
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.toString();
    }

    @Test
    public void devePermitirNumeroPedidoClienteNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test
    public void devePermitirNumeroPedidoItemClienteNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeComercialNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUnidadeComercialNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUnidadeTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test
    public void devePermitirValorDescontoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.toString();
    }

    @Test
    public void devePermitirValorFreteNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.toString();
    }

    @Test
    public void devePermitirValorOutrasDespesasAcessoriasNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.toString();
    }

    @Test
    public void devePermitirValorSeguroNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTotalBrutoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.setVeiculo(FabricaDeObjetosFake.getNFNotaInfoItemProdutoVeiculo());
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorUnitarioNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorUnitarioTributavelNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test
    public void devePermitirVeiculoNulo() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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
        produto.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemProduto produto = new NFNotaInfoItemProduto();
        produto.setArmamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoArmamento()));
        produto.setCfop("qW2d");
        produto.setCodigo("ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq");
        produto.setCodigoDeBarras("EyiQt2RGqEJBPR");
        produto.setCodigoDeBarrasTributavel("EyiQt2RGqEJBPR");
        produto.setCombustivel(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel());
        produto.setCompoeValotNota(NFProdutoCompoeValorNota.SIM);
        produto.setDeclaracoesImportacao(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoDeclaracaoImportacao()));
        produto.setDescricao("OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP");
        produto.setExtipi(999);
        produto.setMedicamentos(Arrays.asList(FabricaDeObjetosFake.getNFNotaInfoItemProdutoMedicamento()));
        produto.setNcm("U0sDjyan");
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

        final String xmlEsperado = "<NFNotaInfoItemProduto><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>EyiQt2RGqEJBPR</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>U0sDjyan</NCM><EXTIPI>999</EXTIPI><CFOP>qW2d</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>EyiQt2RGqEJBPR</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>42</UFDesemb><dDesemb>2014-01-01</dDesemb><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdicC>999</nSeqAdicC><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><veicProd><tpOp>0</tpOp><chassi>ks4VTPGohNxYlX7CX</chassi><cCor>123A</cCor><xCor>tjRQlvBqVsFLDWUCaOeaXRbV1ipOZH3W5H7Ic2p9</xCor><pot>GZRz</pot><cilin>ohNx</cilin><pesoL>9999.9999</pesoL><pesoB>9999.9999</pesoB><nSerie>XBxVyiVVD</nSerie><tpComb>02</tpComb><nMotor>u1DU8GZRzJZzevuY49IB9</nMotor><CMT>9999.9999</CMT><dist>9999</dist><anoMod>2014</anoMod><anoFab>2014</anoFab><tpPint>A</tpPint><tpVeic>06</tpVeic><espVeic>4</espVeic><VIN>N</VIN><condVeic>1</condVeic><cMod>2TR4Fz</cMod><cCorDENATRAN>16</cCorDENATRAN><lota>999</lota><tpRest>4</tpRest></veicProd><med><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal><vPMC>999999999999.99</vPMC></med><arma><tpArma>0</tpArma><nSerie>G2LeQIr4F</nSerie><nCano>DCXuiWRlE</nCano><descr>lkVlEEeoLx8TnDSJ7ZfB0ohZacch9JMIT0lEOsXkSI1KDOWcOI3PjKe6QMAUeLitJ0aAi1LIGpKmN0sVZtp00qqzmgfySvraI98bmPN0RreMa1eDZwLQG2o46TT3vMHkZgBRZ6ofxUCLjUEgU7b2YZynsUuM3szCDup0TuUCjBULJEB8TTr4rCcLD1rCeVBljaFoclt16oQXio2UUEYXjgcCVpftSE0uamx3Ni2GCwlUQ4CCBAaVZv7VA79xWrMV</descr></arma><comb><cProdANP>999999999</cProdANP><CODIF>Cirh89sPDDbnFAzZMPpmG</CODIF><qTemp>99999999999.9999</qTemp><UFCons>12</UFCons><CIDE><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vCIDE>999999999999.99</vCIDE></CIDE></comb></NFNotaInfoItemProduto>";
        Assert.assertEquals(xmlEsperado, produto.toString());
    }
}