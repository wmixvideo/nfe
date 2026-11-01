package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoISSQNTest {

    @Test
    public void naoDevePermitirItemListaServicosComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemImpostoISSQN().setItemListaServicos("12.A3");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemImpostoISSQN().setItemListaServicos("AA.AA");
            }
        });
    }

    @Test
    public void naoDevePermitirCodigoMunicipioComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            try {
                new NFNotaInfoItemImpostoISSQN().setCodigoMunicipio(999999);
            } catch (final NumberFormatException e) {
                new NFNotaInfoItemImpostoISSQN().setCodigoMunicipio(10000000);
            }
        });
    }

    @Test
    public void naoDevePermitirAliquotaISSQNComTamanhoNulo() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoISSQN().setValorAliquota(new BigDecimal("100000")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoISSQN().setValorBaseCalculo(new BigDecimal("1000000000000000")));
    }

    @Test
    public void naoDevePermitirValorComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoISSQN().setValor(new BigDecimal("1000000000000000")));
    }

    @Test
    public void devePermitirCodigoMunicipioIncidenciaImpostoNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos("12.34");
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.setCodigoPais("8486");
        impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
        impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
        impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
        impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
        impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
        impostoISSQN.toString();
    }

    @Test
    public void devePermitirCodigoPaisNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos("12.34");
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
        impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
        impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
        impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
        impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
        impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
        impostoISSQN.toString();
    }

    @Test
    public void devePermitirCodigoServicoNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos("12.34");
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
        impostoISSQN.setCodigoPais("8486");
        impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
        impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
        impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
        impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
        impostoISSQN.toString();
    }

    @Test
    public void naoDevePermitirIndicadorExigibilidadeISSNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
            impostoISSQN.setCodigoMunicipio(9999999);
            impostoISSQN.setItemListaServicos("12.34");
            impostoISSQN.setValor(new BigDecimal("999999999999.99"));
            impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
            impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
            impostoISSQN.setCodigoPais("8486");
            impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
            impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
            impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
            impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
            impostoISSQN.toString();
        });
    }

    @Test
    public void naoDevePermitirIncentivoFiscalNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
            impostoISSQN.setCodigoMunicipio(9999999);
            impostoISSQN.setItemListaServicos("12.34");
            impostoISSQN.setValor(new BigDecimal("999999999999.99"));
            impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
            impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
            impostoISSQN.setCodigoPais("8486");
            impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
            impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
            impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
            impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
            impostoISSQN.toString();
        });
    }

    @Test
    public void devePermitirNumeroProcessoNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos("12.34");
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
        impostoISSQN.setCodigoPais("8486");
        impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
        impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
        impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
        impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
        impostoISSQN.toString();
    }

    @Test
    public void devePermitirValorDeducaoNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos("12.34");
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
        impostoISSQN.setCodigoPais("8486");
        impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
        impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
        impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
        impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
        impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
        impostoISSQN.toString();
    }

    @Test
    public void devePermitirValorDescontoCondicionadoISSNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos("12.34");
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
        impostoISSQN.setCodigoPais("8486");
        impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
        impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
        impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
        impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
        impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
        impostoISSQN.toString();
    }

    @Test
    public void devePermitirValorDescontoIncondicionadoISSNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos("12.34");
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
        impostoISSQN.setCodigoPais("8486");
        impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
        impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
        impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
        impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
        impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
        impostoISSQN.toString();
    }

    @Test
    public void devePermitirValorOutroISSNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos("12.34");
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
        impostoISSQN.setCodigoPais("8486");
        impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
        impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
        impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
        impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
        impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
        impostoISSQN.toString();
    }

    @Test
    public void devePermitirValorRetencaoISSNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos("12.34");
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
        impostoISSQN.setCodigoPais("8486");
        impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
        impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
        impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
        impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
        impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
        impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
        impostoISSQN.toString();
    }

    @Test
    public void naoDevePermitirCodigoMunicipioNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
            impostoISSQN.setItemListaServicos("12.34");
            impostoISSQN.setValor(new BigDecimal("999999999999.99"));
            impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
            impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
            impostoISSQN.setCodigoPais("8486");
            impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
            impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
            impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
            impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
            impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
            impostoISSQN.toString();
        });
    }

    @Test
    public void naoDevePermitirItemListaServicosNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
            impostoISSQN.setCodigoMunicipio(9999999);
            impostoISSQN.setValor(new BigDecimal("999999999999.99"));
            impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
            impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
            impostoISSQN.setCodigoPais("8486");
            impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
            impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
            impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
            impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
            impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
            impostoISSQN.toString();
        });
    }

    @Test
    public void naoDevePermitirValorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
            impostoISSQN.setCodigoMunicipio(9999999);
            impostoISSQN.setItemListaServicos("12.34");
            impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
            impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
            impostoISSQN.setCodigoPais("8486");
            impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
            impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
            impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
            impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
            impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
            impostoISSQN.toString();
        });
    }

    @Test
    public void naoDevePermitirValorAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
            impostoISSQN.setCodigoMunicipio(9999999);
            impostoISSQN.setItemListaServicos("12.34");
            impostoISSQN.setValor(new BigDecimal("999999999999.99"));
            impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
            impostoISSQN.setCodigoPais("8486");
            impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
            impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
            impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
            impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
            impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
            impostoISSQN.toString();
        });
    }

    @Test
    public void naoDevePermitirValorBaseCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
            impostoISSQN.setCodigoMunicipio(9999999);
            impostoISSQN.setItemListaServicos("12.34");
            impostoISSQN.setValor(new BigDecimal("999999999999.99"));
            impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
            impostoISSQN.setCodigoMunicipioIncidenciaImposto("3813816");
            impostoISSQN.setCodigoPais("8486");
            impostoISSQN.setCodigoServico("VfsQTgAm60yAqyOMUOIp");
            impostoISSQN.setIndicadorExigibilidadeISS(NFNotaInfoItemIndicadorExigibilidadeISS.EXIGIVEL);
            impostoISSQN.setIndicadorIncentivoFiscal(NFNotaInfoItemIndicadorIncentivoFiscal.SIM);
            impostoISSQN.setNumeroProcesso("Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO");
            impostoISSQN.setValorDeducao(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoCondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorDescontoIncondicionado(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorOutro(new BigDecimal("99999999999.99"));
            impostoISSQN.setValorRetencaoISS(new BigDecimal("99999999999.99"));
            impostoISSQN.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoISSQN><vBC>999999999999.99</vBC><vAliq>99.99</vAliq><vISSQN>999999999999.99</vISSQN><cMunFG>9999999</cMunFG><cListServ>25.01</cListServ><vDeducao>99999999999.99</vDeducao><vOutro>99999999999.99</vOutro><vDescIncond>99999999999.99</vDescIncond><vDescCond>99999999999.99</vDescCond><vISSRet>99999999999.99</vISSRet><indISS>1</indISS><cServico>VfsQTgAm60yAqyOMUOIp</cServico><cMun>3813816</cMun><cPais>8486</cPais><nProcesso>Sw4CSjke5lhAzlBrzFgKuNjtrRSVfO</nProcesso><indIncentivo>1</indIncentivo></NFNotaInfoItemImpostoISSQN>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN().toString());
    }
}