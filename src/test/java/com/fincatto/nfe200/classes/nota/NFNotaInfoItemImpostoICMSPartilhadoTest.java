package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe200.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;
import com.fincatto.nfe200.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.nfe200.classes.NFOrigem;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoICMSPartilhado;

public class NFNotaInfoItemImpostoICMSPartilhadoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setPercentualAliquotaImposto(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setPercentualAliquotaImpostoICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualBCOperacaoPropriaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setPercentualBCOperacaoPropria(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualMargemValorAdicionadoICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setPercentualMargemValorAdicionadoICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualReducaoBCComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setPercentualReducaoBC(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualReducaoBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setPercentualReducaoBCICMSST(new BigDecimal("100"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setValorBCICMS(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setValorBCICMSST(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setValorICMS(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSPartilhado().setValorICMSST(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModalidadeDeterminacaoBCICMSNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaImpostoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualBCOperacaoPropriaNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test
    public void devePermitirPercentualMargemValorAdicionadoICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test
    public void devePermitirPercentualReducaoBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUfICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBCICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorICMSSTNulo() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSPartilhado icmsPartilhado = new NFNotaInfoItemImpostoICMSPartilhado();
        icmsPartilhado.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.OUTROS);
        icmsPartilhado.setModalidadeBCICMSST(NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA);
        icmsPartilhado.setModalidadeDeterminacaoBCICMS(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icmsPartilhado.setOrigem(NFOrigem.NACIONAL);
        icmsPartilhado.setPercentualAliquotaImposto(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualAliquotaImpostoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualBCOperacaoPropria(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualMargemValorAdicionadoICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBC(new BigDecimal("99.99"));
        icmsPartilhado.setPercentualReducaoBCICMSST(new BigDecimal("99.99"));
        icmsPartilhado.setUfICMSST(NFUnidadeFederativa.TO);
        icmsPartilhado.setValorBCICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorBCICMSST(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMS(new BigDecimal("999999999999.99"));
        icmsPartilhado.setValorICMSST(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSPartilhado><orig>0</orig><CST>90</CST><modBC>1</modBC><vBC>999999999999.99</vBC><pRedBC>99.99</pRedBC><pICMS>99.99</pICMS><vICMS>999999999999.99</vICMS><modBCST>3</modBCST><pMVAST>99.99</pMVAST><pRedBCST>99.99</pRedBCST><vBCST>999999999999.99</vBCST><pICMSST>99.99</pICMSST><vICMSST>999999999999.99</vICMSST><pBCOp>99.99</pBCOp><UFST>17</UFST></NFNotaInfoItemImpostoICMSPartilhado>";
        Assert.assertEquals(xmlEsperado, icmsPartilhado.toString());
    }
}