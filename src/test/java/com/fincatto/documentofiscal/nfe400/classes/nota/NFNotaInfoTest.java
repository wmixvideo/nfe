package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFTipo;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class NFNotaInfoTest {

    @Test
    public void deveObterIdentificadorComPrefixo() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final String identificador = "89172658591754401086218048846976493475937081";
        notaInfo.setIdentificador(identificador);
        Assert.assertEquals("NFe" + identificador, notaInfo.getIdentificador());
    }

    @Test
    public void deveObterIdentificacaoComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoIdentificacao identificacao = FabricaDeObjetosFake.getInfoIdentificacaoDeTeste();
        notaInfo.setIdentificacao(identificacao);
        Assert.assertEquals(identificacao, notaInfo.getIdentificacao());
    }

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        notaInfo.setVersao(new BigDecimal("3.1"));
        Assert.assertEquals("3.10", notaInfo.getVersao());
    }

    @Test
    public void deveObterEmitenteComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoEmitente emitente = FabricaDeObjetosFake.getNFNotaInfoEmitente();
        notaInfo.setEmitente(emitente);
        Assert.assertEquals(emitente, notaInfo.getEmitente());
    }

    @Test
    public void deveObterAvulsaComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoAvulsa avulsa = FabricaDeObjetosFake.getNFNotaInfoAvulsa();
        notaInfo.setAvulsa(avulsa);
        Assert.assertEquals(avulsa, notaInfo.getAvulsa());
    }

    @Test
    public void deveObterDestinatarioComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoDestinatario destinatario = FabricaDeObjetosFake.getNFNotaInfoDestinatario();
        notaInfo.setDestinatario(destinatario);
        Assert.assertEquals(destinatario, notaInfo.getDestinatario());
    }

    @Test
    public void deveObterRetiradaComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoLocal retirada = FabricaDeObjetosFake.getNFNotaInfoLocal();
        notaInfo.setRetirada(retirada);
        Assert.assertEquals(retirada, notaInfo.getRetirada());
    }

    @Test
    public void deveObterEntregaComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoLocal entrega = FabricaDeObjetosFake.getNFNotaInfoLocal();
        notaInfo.setEntrega(entrega);
        Assert.assertEquals(entrega, notaInfo.getEntrega());
    }

    @Test
    public void deveObterPessoasAutorizadasDownloadNFeComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final List<NFPessoaAutorizadaDownloadNFe> pessoasAutorizadasDownloadNFe = Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe());
        notaInfo.setPessoasAutorizadasDownloadNFe(pessoasAutorizadasDownloadNFe);
        Assert.assertEquals(pessoasAutorizadasDownloadNFe, notaInfo.getPessoasAutorizadasDownloadNFe());
    }

    @Test
    public void deveObterItensComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final List<NFNotaInfoItem> itens = Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem());
        notaInfo.setItens(itens);
        Assert.assertEquals(itens, notaInfo.getItens());
    }

    @Test
    public void deveObterTotalComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoTotal total = FabricaDeObjetosFake.getNFNotaInfoTotal();
        notaInfo.setTotal(total);
        Assert.assertEquals(total, notaInfo.getTotal());
    }

    @Test
    public void deveObterTransporteComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoTransporte transporte = FabricaDeObjetosFake.getNFNotaInfoTransporte();
        notaInfo.setTransporte(transporte);
        Assert.assertEquals(transporte, notaInfo.getTransporte());
    }

    @Test
    public void deveObterCobrancaComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoCobranca cobranca = FabricaDeObjetosFake.getNFNotaInfoCobranca();
        notaInfo.setCobranca(cobranca);
        Assert.assertEquals(cobranca, notaInfo.getCobranca());
    }

    @Test
    public void deveObterPagamentosComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoPagamento pagamento = FabricaDeObjetosFake.getNFNotaInfoPagamento();
        notaInfo.setPagamento(pagamento);
        Assert.assertEquals(pagamento, notaInfo.getPagamento());
    }

    @Test
    public void deveObterInformacoesAdicionaisComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoInformacoesAdicionais informacoesAdicionais = FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais();
        notaInfo.setInformacoesAdicionais(informacoesAdicionais);
        Assert.assertEquals(informacoesAdicionais, notaInfo.getInformacoesAdicionais());
    }

    @Test
    public void deveObterExportacaoComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoExportacao exportacao = FabricaDeObjetosFake.getNFNotaInfoExportacao();
        notaInfo.setExportacao(exportacao);
        Assert.assertEquals(exportacao, notaInfo.getExportacao());
    }

    @Test
    public void deveObterCompraComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoCompra compra = FabricaDeObjetosFake.getNFNotaInfoCompra();
        notaInfo.setCompra(compra);
        Assert.assertEquals(compra, notaInfo.getCompra());
    }

    @Test
    public void deveObterCanaComoFoiSetado() {
        final NFNotaInfo notaInfo = new NFNotaInfo();
        final NFNotaInfoCana cana = FabricaDeObjetosFake.getNFNotaInfoCana();
        notaInfo.setCana(cana);
        Assert.assertEquals(cana, notaInfo.getCana());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificadorComTamanhoInvalido() {
        try {
            new NFNotaInfo().setIdentificador("ChZ9G0aubajFyQkslfhicTyzggacyZlAtWJrlrvS4JIskg");
        } catch (final IllegalStateException e) {
            new NFNotaInfo().setIdentificador("891726585917544010862180488469764934759370811");
        }
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirVersaoComTamanhoInvalido() {
        new NFNotaInfo().setVersao(new BigDecimal("100"));
    }

    @Test
    public void devePermitirPessoasAutorizadasDownloadNFeNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test
    public void devePermitirAvulsaNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test
    public void devePermitirCanaNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test
    public void devePermitirCobrancaNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test
    public void devePermitirCompraNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test
    public void devePermitirDestinatarioNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirEmitenteNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test
    public void devePermitirEntregaNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test
    public void devePermitirExportacaoNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificacaoNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificadorNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test
    public void devePermitirInformacoesAdicionaisNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirItensNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test
    public void devePermitirRetiradaNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTotalNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTransporteNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());

        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setVersao(new BigDecimal("9.99"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setPagamento(FabricaDeObjetosFake.getNFNotaInfoPagamento());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPagamentosNulo() {
        final NFNotaInfo info = new NFNotaInfo();
        info.setAvulsa(FabricaDeObjetosFake.getNFNotaInfoAvulsa());
        info.setCana(FabricaDeObjetosFake.getNFNotaInfoCana());
        info.setCobranca(FabricaDeObjetosFake.getNFNotaInfoCobranca());
        info.setCompra(FabricaDeObjetosFake.getNFNotaInfoCompra());
        info.setDestinatario(FabricaDeObjetosFake.getNFNotaInfoDestinatario());
        info.setEmitente(FabricaDeObjetosFake.getNFNotaInfoEmitente());
        info.setEntrega(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setExportacao(FabricaDeObjetosFake.getNFNotaInfoExportacao());
        info.setIdentificacao(FabricaDeObjetosFake.getNFNotaInfoIdentificacao());
        info.setIdentificador("89172658591754401086218048846976493475937081");
        info.setInformacoesAdicionais(FabricaDeObjetosFake.getNFNotaInfoInformacoesAdicionais());
        info.setItens(Collections.singletonList(FabricaDeObjetosFake.getNFNotaInfoItem()));
        info.setRetirada(FabricaDeObjetosFake.getNFNotaInfoLocal());
        info.setTotal(FabricaDeObjetosFake.getNFNotaInfoTotal());
        info.setTransporte(FabricaDeObjetosFake.getNFNotaInfoTransporte());
        info.setVersao(new BigDecimal("3.10"));
        info.setPessoasAutorizadasDownloadNFe(Collections.singletonList(FabricaDeObjetosFake.getPessoaAutorizadaDownloadNFe()));
        info.toString();
    }
    
    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNaoContribuinteENaoConsumidorFinal() {
        final NFNotaInfo notaInfo = FabricaDeObjetosFake.getNFNotaInfo();
        notaInfo.getIdentificacao().setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.NAO);
        notaInfo.getIdentificacao().setTipo(NFTipo.SAIDA);
        notaInfo.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<infNFe Id=\"NFe89172658591754401086218048846976493475937081\" versao=\"4.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><ide><cUF>43</cUF><cNF>99999998</cNF><natOp>qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ</natOp><mod>55</mod><serie>999</serie><nNF>999999999</nNF><dhEmi>2010-10-27T10:10:10-02:00</dhEmi><dhSaiEnt>2013-09-24T10:10:10-03:00</dhSaiEnt><tpNF>0</tpNF><idDest>1</idDest><cMunFG>1612675</cMunFG><tpImp>2</tpImp><tpEmis>1</tpEmis><cDV>8</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>0</indPres><indIntermed>1</indIntermed><procEmi>0</procEmi><verProc>532ng7VURPgovC5BYaZy</verProc><dhCont>2014-10-10T10:10:10-03:00</dhCont><xJust>b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV</xJust><NFref><refCTe>19506188293993666630760813709064781438945816</refCTe></NFref></ide><emit><CPF>12345678901</CPF><xNome>Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3</xNome><xFant>TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn</xFant><enderEmit><xLgr>NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV</xLgr><nro>11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y</nro><xCpl>Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw</xCpl><xBairro>67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU</xBairro><cMun>9999999</cMun><xMun>s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG</xMun><UF>RS</UF><CEP>88095550</CEP><cPais>1058</cPais><fone>12345678901324</fone></enderEmit><IE>12345678901234</IE><IEST>84371964648860</IEST><IM>zjfBnFVG8TBq8iW</IM><CNAE>0111111</CNAE><CRT>3</CRT></emit><avulsa><CNPJ>12345678901234</CNPJ><xOrgao>qNre0x2eJthUYIoKBuBbbGSeA4R2wrDLxNwCuDFkYD54flBLbBBMakGDgQUV</xOrgao><matr>Nn5PPREBbkfmmk4lBFwgvkuKg8prnY5CPqHIzqGiD1lTnZJ37nAZ4NBc8XwM</matr><xAgente>lkLip3hIYSAIzH3Tf1LWQsaybqB76V66lMgWBcHVwcOKInuJ8mGUyY8DT4NL</xAgente><fone>81579357</fone><UF>RS</UF><nDAR>qqDt1f1ulcahrBnUH0otPFkjYqD2tH4ktYsR71WSYZLFW1zZObAqajHHkyxi</nDAR><dEmi>2014-01-13</dEmi><vDAR>999999999999.99</vDAR><repEmi>YQFmDI2HBjjfZpRjR2ghwmSo1oWk5QgUEYf2oG46uEHwY4zsXyH1ORSr8oq3</repEmi><dPag>2014-03-21</dPag></avulsa><dest><CNPJ>12345678901234</CNPJ><xNome>F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR</xNome><enderDest><xLgr>NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV</xLgr><nro>11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y</nro><xCpl>Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw</xCpl><xBairro>67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU</xBairro><cMun>9999999</cMun><xMun>s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG</xMun><UF>RS</UF><CEP>88095550</CEP><cPais>1058</cPais><fone>12345678901324</fone></enderDest><indIEDest>9</indIEDest><IE>13245678901234</IE><ISUF>999999999</ISUF><IM>5ow5E1mZQPe1VUR</IM><email>ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K</email></dest><retirada><CNPJ>12345678901234</CNPJ><xNome>mRtbdiwDaVQzVhCVSZtnmXjPJVeOdejeYdnaYPVyHTZnBdkQXGYLBKGLCX</xNome><xLgr>t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG</xLgr><nro>YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa</nro><xCpl>ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe</xCpl><xBairro>JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil</xBairro><cMun>9999999</cMun><xMun>OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI</xMun><UF>RS</UF><cPais>1058</cPais><xPais>BRASIL</xPais><fone>12345678901324</fone><email>email@empresaficticia.com.br</email><IE>12345678901234</IE></retirada><entrega><CNPJ>12345678901234</CNPJ><xNome>mRtbdiwDaVQzVhCVSZtnmXjPJVeOdejeYdnaYPVyHTZnBdkQXGYLBKGLCX</xNome><xLgr>t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG</xLgr><nro>YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa</nro><xCpl>ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe</xCpl><xBairro>JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil</xBairro><cMun>9999999</cMun><xMun>OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI</xMun><UF>RS</UF><cPais>1058</cPais><xPais>BRASIL</xPais><fone>12345678901324</fone><email>email@empresaficticia.com.br</email><IE>12345678901234</IE></entrega><autXML><CNPJ>12345678901234</CNPJ></autXML><det nItem=\"990\"><prod><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></prod><imposto><vTotTrib>999999999999.99</vTotTrib><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><pFCP>99.99</pFCP><vFCP>999999999999.99</vFCP></ICMS00></ICMS><IPI><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib></IPI><II><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></II><PIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></PIS><PISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISST><COFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq></COFINS><COFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></COFINSST><ICMSUFDest><vBCUFDest>9999999999999.99</vBCUFDest><vBCFCPUFDest>9999999999999.99</vBCFCPUFDest><pFCPUFDest>999.9999</pFCPUFDest><pICMSUFDest>999.9999</pICMSUFDest><pICMSInter>7.00</pICMSInter><pICMSInterPart>999.9999</pICMSInterPart><vFCPUFDest>9999999999999.99</vFCPUFDest><vICMSUFDest>9999999999999.99</vICMSUFDest><vICMSUFRemet>9999999999999.99</vICMSUFRemet></ICMSUFDest></imposto><impostoDevol><pDevol>100.00</pDevol><IPI><vIPIDevol>9999999999999.99</vIPIDevol></IPI></impostoDevol><infAdProd>R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li</infAdProd></det><total><ICMSTot><vBC>999999999999.99</vBC><vICMS>999999999999.99</vICMS><vICMSDeson>999999999999.99</vICMSDeson><vFCPUFDest>999999999999.99</vFCPUFDest><vICMSUFDest>999999999999.99</vICMSUFDest><vICMSUFRemet>999999999999.99</vICMSUFRemet><vFCP>999999999999.99</vFCP><vBCST>999999999999.99</vBCST><vST>999999999999.99</vST><vFCPST>999999999999.99</vFCPST><vFCPSTRet>999999999999.99</vFCPSTRet><vProd>999999999999.99</vProd><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vII>999999999999.99</vII><vIPI>999999999999.99</vIPI><vIPIDevol>999999999999.99</vIPIDevol><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS><vOutro>999999999999.99</vOutro><vNF>999999999999.99</vNF></ICMSTot><ISSQNtot><vServ>999999999999.99</vServ><vBC>999999999999.99</vBC><vISS>999999999999.99</vISS><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS><dCompet>2014-01-01</dCompet><vDeducao>999999999999.99</vDeducao><vOutro>999999999999.99</vOutro><vDescIncond>999999999999.99</vDescIncond><vDescCond>999999999999.99</vDescCond><vISSRet>999999999999.99</vISSRet><cRegTrib>3</cRegTrib></ISSQNtot><retTrib><vRetPIS>999999999999.99</vRetPIS><vRetCOFINS>999999999999.99</vRetCOFINS><vRetCSLL>999999999999.99</vRetCSLL><vBCIRRF>999999999999.99</vBCIRRF><vIRRF>999999999999.99</vIRRF><vBCRetPrev>999999999999.99</vBCRetPrev><vRetPrev>999999999999.99</vRetPrev></retTrib></total><transp><modFrete>9</modFrete><transporta><CNPJ>34843274000164</CNPJ><xNome>4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn</xNome><IE>ISENTO</IE><xEnder>D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY</xEnder><xMun>4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn</xMun><UF>SP</UF></transporta><retTransp><vServ>999999999999.99</vServ><vBCRet>999999999999.99</vBCRet><pICMSRet>99.99</pICMSRet><vICMSRet>999999999999.99</vICMSRet><CFOP>5351</CFOP><cMunFG>9999999</cMunFG></retTransp><reboque><placa>MKZ4891</placa><UF>SC</UF></reboque><vol><qVol>99999999999</qVol><esp>3Qf46HFs7FcWlhuQqLJ96vsrgJHu6B5ZXmmwMZ1RtvQVOV4Yp6M9VNqn5Ecb</esp><marca>lc0w13Xw2PxsSD4u4q3N6Qix9ZuCFm0HXo6BxBmKnjVbh9Xwy3k9UwBNfuYo</marca><nVol>mcBUtZwnI5DKj2YZNAcLP7W9h6j1xKmF5SX1BTKmsvyg0H5xSrfVw8HGn8eb</nVol><pesoL>1.000</pesoL><pesoB>1.358</pesoB><lacres><nLacre>gvmjb9BB2cmwsLbzeR3Bsk8QbA7b1XEgXUhKeS9QZGiwhFnqDtEzS3377MP2</nLacre></lacres></vol></transp><cobr><fat><nFat>KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF</nFat><vOrig>3001.15</vOrig><vDesc>0.15</vDesc><vLiq>3000.00</vLiq></fat><dup><nDup>TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z</nDup><dVenc>2014-07-10</dVenc><vDup>999999.99</vDup></dup></cobr><pag><detPag><indPag>1</indPag><tPag>03</tPag><vPag>999999999999.99</vPag><card><tpIntegra>1</tpIntegra><CNPJ>12345678901234</CNPJ><tBand>02</tBand><cAut>9ItpS1hBk3TyhjUB3I90</cAut></card></detPag></pag><infIntermed><CNPJ>12345678901234</CNPJ><idCadIntTran>123456789012345678901234567890123456789012345678901234567890</idCadIntTran></infIntermed><infAdic><infAdFisco>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</infAdFisco><infCpl>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</infCpl><obsCont xCampo=\"kRkrK4FGWOn27RSjYjMB\"><xTexto>ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo</xTexto></obsCont><obsFisco xCampo=\"kRkrK4FGWOn27RSjYjMB\"><xTexto>ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo</xTexto></obsFisco><procRef><nProc>SziSRSIRZvYWlxcbmmJfRZsLgVHaHTurUL9ea1kwFe7fssrxTVSK6uaFwGO5</nProc><indProc>1</indProc><tpAto>10</tpAto></procRef></infAdic><exporta><UFSaidaPais>RS</UFSaidaPais><xLocExporta>xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm</xLocExporta><xLocDespacho>xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm</xLocDespacho></exporta><compra><xNEmp>abcefghijklmnopqrstuvx</xNEmp><xPed>1kG8gghJ0YTrUZnt00BJlOsFCtj43eV5mEHHXUzp3rD6QwwUwX4GPavXkMB1</xPed><xCont>9tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzc</xCont></compra><cana><safra>2013/2014</safra><ref>06/2013</ref><forDia dia=\"15\"><qtde>3</qtde></forDia><qTotMes>30.0000001</qTotMes><qTotAnt>10</qTotAnt><qTotGer>80</qTotGer><vFor>900.00</vFor><vTotDed>2000.70</vTotDed><vLiqFor>980.00</vLiqFor></cana></infNFe>";
		Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoIntermediador().toString());

        NFNotaInfo nfNotaInfoIntermediador = FabricaDeObjetosFake.getNFNotaInfoIntermediador();
        nfNotaInfoIntermediador.getInformacoesAdicionais().getProcessosRefenciado().stream().findFirst().ifPresent(procRef -> procRef.setTipoAtoConcessorio(NFTipoAtoConcessorio.TERMO_DE_ACORDO));
        final String xmlEsperadoII = "<infNFe Id=\"NFe89172658591754401086218048846976493475937081\" versao=\"4.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><ide><cUF>43</cUF><cNF>99999998</cNF><natOp>qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ</natOp><mod>55</mod><serie>999</serie><nNF>999999999</nNF><dhEmi>2010-10-27T10:10:10-02:00</dhEmi><dhSaiEnt>2013-09-24T10:10:10-03:00</dhSaiEnt><tpNF>0</tpNF><idDest>1</idDest><cMunFG>1612675</cMunFG><tpImp>2</tpImp><tpEmis>1</tpEmis><cDV>8</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>0</indPres><indIntermed>1</indIntermed><procEmi>0</procEmi><verProc>532ng7VURPgovC5BYaZy</verProc><dhCont>2014-10-10T10:10:10-03:00</dhCont><xJust>b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV</xJust><NFref><refCTe>19506188293993666630760813709064781438945816</refCTe></NFref></ide><emit><CPF>12345678901</CPF><xNome>Rhass3yMarv7W26gljGNMGXXyPZfSFDEiN472mTU7UWxokviyHMfeD7vCVg3</xNome><xFant>TKuTABBqcwEOeMwQepTIAvhOPx8qDf8Q5C8fbGgjonxl1ML9NErg9yVk2bGn</xFant><enderEmit><xLgr>NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV</xLgr><nro>11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y</nro><xCpl>Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw</xCpl><xBairro>67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU</xBairro><cMun>9999999</cMun><xMun>s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG</xMun><UF>RS</UF><CEP>88095550</CEP><cPais>1058</cPais><fone>12345678901324</fone></enderEmit><IE>12345678901234</IE><IEST>84371964648860</IEST><IM>zjfBnFVG8TBq8iW</IM><CNAE>0111111</CNAE><CRT>3</CRT></emit><avulsa><CNPJ>12345678901234</CNPJ><xOrgao>qNre0x2eJthUYIoKBuBbbGSeA4R2wrDLxNwCuDFkYD54flBLbBBMakGDgQUV</xOrgao><matr>Nn5PPREBbkfmmk4lBFwgvkuKg8prnY5CPqHIzqGiD1lTnZJ37nAZ4NBc8XwM</matr><xAgente>lkLip3hIYSAIzH3Tf1LWQsaybqB76V66lMgWBcHVwcOKInuJ8mGUyY8DT4NL</xAgente><fone>81579357</fone><UF>RS</UF><nDAR>qqDt1f1ulcahrBnUH0otPFkjYqD2tH4ktYsR71WSYZLFW1zZObAqajHHkyxi</nDAR><dEmi>2014-01-13</dEmi><vDAR>999999999999.99</vDAR><repEmi>YQFmDI2HBjjfZpRjR2ghwmSo1oWk5QgUEYf2oG46uEHwY4zsXyH1ORSr8oq3</repEmi><dPag>2014-03-21</dPag></avulsa><dest><CNPJ>12345678901234</CNPJ><xNome>F7HL85M9v7jW5lX4Z9V7sF3kshuj967gj4uACEmpmVQgM9yYeQAgaY5EcSfR</xNome><enderDest><xLgr>NKwaAJ5ZJ49aQYmqBvxMhBzkGUqvtXnqusGEtjDzKCXPGwrEZCS8LGKHyBbV</xLgr><nro>11mzXHR8rZTgfE35EqfGhiShiIwQfLCAziFDXVgs3EjLSPkZkCvfGNLMEf5y</nro><xCpl>Fr3gSvoAeKbGpQD3r98KFeB50P3Gq14XBVsv5fpiaBvJ3HTOpREiwYGs20Xw</xCpl><xBairro>67LQFlXOBK0JqAE1rFi2CEyUGW5Z8QmmHhzmZ9GABVLKa9AbV0uFR0onl7nU</xBairro><cMun>9999999</cMun><xMun>s1Cr2hWP6bptQ80A9vWBuTaODR1U82LtKQi1DEm3LsAXu9AbkSeCtfXJVTKG</xMun><UF>RS</UF><CEP>88095550</CEP><cPais>1058</cPais><fone>12345678901324</fone></enderDest><indIEDest>9</indIEDest><IE>13245678901234</IE><ISUF>999999999</ISUF><IM>5ow5E1mZQPe1VUR</IM><email>ivU3ctXKzImStrYzRpDTXRyCfSzxlEe5GTbeyVZ1OlIvgKGLJJMJlaKtYj8K</email></dest><retirada><CNPJ>12345678901234</CNPJ><xNome>mRtbdiwDaVQzVhCVSZtnmXjPJVeOdejeYdnaYPVyHTZnBdkQXGYLBKGLCX</xNome><xLgr>t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG</xLgr><nro>YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa</nro><xCpl>ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe</xCpl><xBairro>JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil</xBairro><cMun>9999999</cMun><xMun>OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI</xMun><UF>RS</UF><cPais>1058</cPais><xPais>BRASIL</xPais><fone>12345678901324</fone><email>email@empresaficticia.com.br</email><IE>12345678901234</IE></retirada><entrega><CNPJ>12345678901234</CNPJ><xNome>mRtbdiwDaVQzVhCVSZtnmXjPJVeOdejeYdnaYPVyHTZnBdkQXGYLBKGLCX</xNome><xLgr>t59le7pl2eVn390y026Ebgh3HXtvEBzsMp4BzZJEwIazezToxeeKJCvm1GoG</xLgr><nro>YHTewrLNvzYaBmSbwxkDYcEZTCMORFVPAc6t6C5p0Bfu1globey70KWnaHHa</nro><xCpl>ifyKIg3j3eZtlNVAj3XJYZiJCrul6VLL85E7x6Kx6DVeChwlRLEkCQn7k5pe</xCpl><xBairro>JE17uXBNBnYTSTSQgqXcGLOR6f22SnahtFHr5MoHQZtZhTowVe3SVwl57kil</xBairro><cMun>9999999</cMun><xMun>OpXKhaHINo7OwLkVGvRq43HNwyBAgXTKcarl6Jsq8NzOBs70eZM4zL6fELOI</xMun><UF>RS</UF><cPais>1058</cPais><xPais>BRASIL</xPais><fone>12345678901324</fone><email>email@empresaficticia.com.br</email><IE>12345678901234</IE></entrega><autXML><CNPJ>12345678901234</CNPJ></autXML><det nItem=\"990\"><prod><cProd>ohVRInAS7jw8LNDP4WWjssSjBHK8nJRERnAeRMcsUokF3YItT93fBto3zZcq</cProd><cEAN>36811963532505</cEAN><xProd>OBS0ztekCoG0DSSVcQwPKRV2fV842Pye7mED13P4zoDczcXi4AMNvQ7BKBLnHtLc2Z9fuIY1pcKmXSK1IJQSLEs5QWvVGyC74DyJuIM0X7L0cqWPZQii5JtP</xProd><NCM>99999999</NCM><NVE>AZ0123</NVE><CEST>9999999</CEST><EXTIPI>999</EXTIPI><CFOP>1302</CFOP><uCom>Bta64y</uCom><qCom>9999999999.9999</qCom><vUnCom>9999999999.9999999999</vUnCom><vProd>999999999999.99</vProd><cEANTrib>36811963532505</cEANTrib><uTrib>7wqG4h</uTrib><qTrib>9999999999.9999</qTrib><vUnTrib>9999999999.9999999999</vUnTrib><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vOutro>999999999999.99</vOutro><indTot>1</indTot><DI><nDI>ZRJihqWLyHnb</nDI><dDI>2014-02-02</dDI><xLocDesemb>kiVfWKB94ggsrWND0XBXwEjJkoiTXhkmX9qKGKzjpnEHHp852bDkYeEUkzpU</xLocDesemb><UFDesemb>RS</UFDesemb><dDesemb>2014-01-01</dDesemb><tpViaTransp>4</tpViaTransp><vAFRMM>999999999999.99</vAFRMM><tpIntermedio>3</tpIntermedio><CNPJ>12345678901234</CNPJ><UFTerceiro>RS</UFTerceiro><cExportador>E9jBqM65b0MiCiRnYil203iNGJOSZs8iU1KGmQsj2N0kw6QMuvhbsQosFGcU</cExportador><adi><nAdicao>999</nAdicao><nSeqAdic>999</nSeqAdic><cFabricante>sA2FBRFMMNgF1AKRDDXYOlc3zGvzEc69l6zQ5O5uAUe82XZ3szQfw01DW0Ki</cFabricante><vDescDI>999999999999.99</vDescDI><nDraw>99999999999</nDraw></adi></DI><xPed>NNxQ9nrQ3HCe5Mc</xPed><nItemPed>999999</nItemPed><rastro><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal></rastro><med><cProdANVISA>1234567890123</cProdANVISA><vPMC>999999999999.99</vPMC></med></prod><imposto><vTotTrib>999999999999.99</vTotTrib><ICMS><ICMS00><orig>0</orig><CST>00</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><pFCP>99.99</pFCP><vFCP>999999999999.99</vFCP></ICMS00></ICMS><IPI><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib></IPI><II><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></II><PIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></PIS><PISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></PISST><COFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq></COFINS><COFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></COFINSST><ICMSUFDest><vBCUFDest>9999999999999.99</vBCUFDest><vBCFCPUFDest>9999999999999.99</vBCFCPUFDest><pFCPUFDest>999.9999</pFCPUFDest><pICMSUFDest>999.9999</pICMSUFDest><pICMSInter>7.00</pICMSInter><pICMSInterPart>999.9999</pICMSInterPart><vFCPUFDest>9999999999999.99</vFCPUFDest><vICMSUFDest>9999999999999.99</vICMSUFDest><vICMSUFRemet>9999999999999.99</vICMSUFRemet></ICMSUFDest></imposto><impostoDevol><pDevol>100.00</pDevol><IPI><vIPIDevol>9999999999999.99</vIPIDevol></IPI></impostoDevol><infAdProd>R3s36BVI9k15xOe3hnlEpZRpPHEom9inv4hE1oo8hzHYG8X6D9sQjt6oLYiH6yToSFM95zueMhE4s270GB7iLUKcQTRHWLcHb1TU2fSYx2NAz5ZflI3hoTnN8zmqJtGzneaNpDRA5gJW7wxMg9IXIuUCxg25MlIQ46AbDQNc3HLl82g3awWKigBMli0bUEWIMf8C2GG2sB2Y9w1GnsfiDvw7RUuU5vATfWWvYFRCehm2UpDhBlrBjjXcWKYzXsT3x2PNtCC82JqY1nkKrgt2AHCPUjM0tCQk5EHFcssb8I0Rkc4s8aNcARXtFrBzmWqXDQPmCpLIGaAo7LlypOKKaqUNqkRkf8c930p8HaRDvQJealZsVnpwJn3Ev7yEaBZ9INe5PXFwkTQEfpNE3B8IokFMh0aUbu8mfzjKLBazSKW2qA4faIo2Wp5FmOmTzCMiPqznOq3Bl0zM4wmuo0rOXbswjaCUzPB0KpM8Yaze9TArOEDrV6Li</infAdProd></det><total><ICMSTot><vBC>999999999999.99</vBC><vICMS>999999999999.99</vICMS><vICMSDeson>999999999999.99</vICMSDeson><vFCPUFDest>999999999999.99</vFCPUFDest><vICMSUFDest>999999999999.99</vICMSUFDest><vICMSUFRemet>999999999999.99</vICMSUFRemet><vFCP>999999999999.99</vFCP><vBCST>999999999999.99</vBCST><vST>999999999999.99</vST><vFCPST>999999999999.99</vFCPST><vFCPSTRet>999999999999.99</vFCPSTRet><vProd>999999999999.99</vProd><vFrete>999999999999.99</vFrete><vSeg>999999999999.99</vSeg><vDesc>999999999999.99</vDesc><vII>999999999999.99</vII><vIPI>999999999999.99</vIPI><vIPIDevol>999999999999.99</vIPIDevol><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS><vOutro>999999999999.99</vOutro><vNF>999999999999.99</vNF></ICMSTot><ISSQNtot><vServ>999999999999.99</vServ><vBC>999999999999.99</vBC><vISS>999999999999.99</vISS><vPIS>999999999999.99</vPIS><vCOFINS>999999999999.99</vCOFINS><dCompet>2014-01-01</dCompet><vDeducao>999999999999.99</vDeducao><vOutro>999999999999.99</vOutro><vDescIncond>999999999999.99</vDescIncond><vDescCond>999999999999.99</vDescCond><vISSRet>999999999999.99</vISSRet><cRegTrib>3</cRegTrib></ISSQNtot><retTrib><vRetPIS>999999999999.99</vRetPIS><vRetCOFINS>999999999999.99</vRetCOFINS><vRetCSLL>999999999999.99</vRetCSLL><vBCIRRF>999999999999.99</vBCIRRF><vIRRF>999999999999.99</vIRRF><vBCRetPrev>999999999999.99</vBCRetPrev><vRetPrev>999999999999.99</vRetPrev></retTrib></total><transp><modFrete>9</modFrete><transporta><CNPJ>34843274000164</CNPJ><xNome>4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn</xNome><IE>ISENTO</IE><xEnder>D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY</xEnder><xMun>4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn</xMun><UF>SP</UF></transporta><retTransp><vServ>999999999999.99</vServ><vBCRet>999999999999.99</vBCRet><pICMSRet>99.99</pICMSRet><vICMSRet>999999999999.99</vICMSRet><CFOP>5351</CFOP><cMunFG>9999999</cMunFG></retTransp><reboque><placa>MKZ4891</placa><UF>SC</UF></reboque><vol><qVol>99999999999</qVol><esp>3Qf46HFs7FcWlhuQqLJ96vsrgJHu6B5ZXmmwMZ1RtvQVOV4Yp6M9VNqn5Ecb</esp><marca>lc0w13Xw2PxsSD4u4q3N6Qix9ZuCFm0HXo6BxBmKnjVbh9Xwy3k9UwBNfuYo</marca><nVol>mcBUtZwnI5DKj2YZNAcLP7W9h6j1xKmF5SX1BTKmsvyg0H5xSrfVw8HGn8eb</nVol><pesoL>1.000</pesoL><pesoB>1.358</pesoB><lacres><nLacre>gvmjb9BB2cmwsLbzeR3Bsk8QbA7b1XEgXUhKeS9QZGiwhFnqDtEzS3377MP2</nLacre></lacres></vol></transp><cobr><fat><nFat>KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF</nFat><vOrig>3001.15</vOrig><vDesc>0.15</vDesc><vLiq>3000.00</vLiq></fat><dup><nDup>TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z</nDup><dVenc>2014-07-10</dVenc><vDup>999999.99</vDup></dup></cobr><pag><detPag><indPag>1</indPag><tPag>03</tPag><vPag>999999999999.99</vPag><card><tpIntegra>1</tpIntegra><CNPJ>12345678901234</CNPJ><tBand>02</tBand><cAut>9ItpS1hBk3TyhjUB3I90</cAut></card></detPag></pag><infIntermed><CNPJ>12345678901234</CNPJ><idCadIntTran>123456789012345678901234567890123456789012345678901234567890</idCadIntTran></infIntermed><infAdic><infAdFisco>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</infAdFisco><infCpl>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</infCpl><obsCont xCampo=\"kRkrK4FGWOn27RSjYjMB\"><xTexto>ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo</xTexto></obsCont><obsFisco xCampo=\"kRkrK4FGWOn27RSjYjMB\"><xTexto>ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo</xTexto></obsFisco><procRef><nProc>SziSRSIRZvYWlxcbmmJfRZsLgVHaHTurUL9ea1kwFe7fssrxTVSK6uaFwGO5</nProc><indProc>1</indProc><tpAto>08</tpAto></procRef></infAdic><exporta><UFSaidaPais>RS</UFSaidaPais><xLocExporta>xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm</xLocExporta><xLocDespacho>xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm</xLocDespacho></exporta><compra><xNEmp>abcefghijklmnopqrstuvx</xNEmp><xPed>1kG8gghJ0YTrUZnt00BJlOsFCtj43eV5mEHHXUzp3rD6QwwUwX4GPavXkMB1</xPed><xCont>9tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzc</xCont></compra><cana><safra>2013/2014</safra><ref>06/2013</ref><forDia dia=\"15\"><qtde>3</qtde></forDia><qTotMes>30.0000001</qTotMes><qTotAnt>10</qTotAnt><qTotGer>80</qTotGer><vFor>900.00</vFor><vTotDed>2000.70</vTotDed><vLiqFor>980.00</vLiqFor></cana></infNFe>";
        Assert.assertEquals(xmlEsperadoII, nfNotaInfoIntermediador.toString());

    }
}