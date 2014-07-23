package com.fincatto.nfe;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import org.joda.time.LocalDate;

import com.fincatto.nfe.classes.nota.NFNotaInfoCana;
import com.fincatto.nfe.classes.nota.NFNotaInfoCanaDeducao;
import com.fincatto.nfe.classes.nota.NFNotaInfoCanaFornecimentoDiario;
import com.fincatto.nfe.classes.nota.NFNotaInfoDuplicata;
import com.fincatto.nfe.classes.nota.NFNotaInfoFatura;
import com.fincatto.nfe.classes.nota.NFNotaInfoLacre;
import com.fincatto.nfe.classes.nota.NFNotaInfoObservacao;
import com.fincatto.nfe.classes.nota.NFNotaInfoProcessoReferenciado;
import com.fincatto.nfe.classes.nota.NFNotaInfoVolume;
import com.fincatto.nfe.classes.nota.NFOrigemProcesso;

public class FabricaDeObjetosFake {

    public static NFNotaInfoCanaDeducao getNFNotaInfoCanaDeducao() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = new NFNotaInfoCanaDeducao();
        infoCanaDeducao.setDescricaoDeducao("67TgthEHf2gowJBy4PZ3ulgaDDAi80s27pIzYK6DJORNAPqL7vJ5ZbQShDcA");
        infoCanaDeducao.setValorDeducao(new BigDecimal("1000"));
        infoCanaDeducao.setValorFornecimento(new BigDecimal("900"));
        infoCanaDeducao.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCanaDeducao.setValorTotalDeducao(new BigDecimal("2000.70"));
        return infoCanaDeducao;
    }

    public static NFNotaInfoCanaFornecimentoDiario getNFNotaInfoCanaFornecimentoDiario() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = new NFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setDia(15);
        canaFornecimentoDiario.setQuantidade(new BigDecimal("3"));
        canaFornecimentoDiario.setQuantidadeTotalAnterior(new BigDecimal("10"));
        canaFornecimentoDiario.setQuantidadeTotalGeral(new BigDecimal("80"));
        canaFornecimentoDiario.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        return canaFornecimentoDiario;
    }

    public static NFNotaInfoCana getNFNotaInfoCana() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<NFNotaInfoCanaDeducao>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setReferencia("06/2013");
        infoCana.setSafra("2013/2014");
        return infoCana;
    }

    public static NFNotaInfoObservacao getNFNotaInfoObservacao() {
        final NFNotaInfoObservacao observacao = new NFNotaInfoObservacao();
        observacao.setIdentificacaoCampo("kRkrK4FGWOn27RSjYjMB");
        observacao.setConteudoCampo("ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo");
        return observacao;
    }

    public static NFNotaInfoProcessoReferenciado getNFNotaInfoProcessoReferenciado() {
        final NFNotaInfoProcessoReferenciado processoReferenciado = new NFNotaInfoProcessoReferenciado();
        processoReferenciado.setIdentificadorProcessoOuAtoConcessorio("SziSRSIRZvYWlxcbmmJfRZsLgVHaHTurUL9ea1kwFe7fssrxTVSK6uaFwGO5");
        processoReferenciado.setIndicadorOrigemProcesso(NFOrigemProcesso.JUSTICA_FEDERAL);
        return processoReferenciado;
    }

    public static NFNotaInfoFatura getNFNotaInfoFatura() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        fatura.setNumeroFatura("KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF");
        fatura.setValorDesconto(new BigDecimal("0.15"));
        fatura.setValorLiquidoFatura(new BigDecimal("3000"));
        fatura.setValorOriginalFatura(new BigDecimal("3001.15"));
        return fatura;
    }

    public static NFNotaInfoDuplicata getNFNotaInfoDuplicata() {
        final NFNotaInfoDuplicata duplicata = new NFNotaInfoDuplicata();
        duplicata.setDataVencimento(new LocalDate(2014, 07, 10));
        duplicata.setNumeroDuplicata("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z");
        duplicata.setValorDuplicata(new BigDecimal("999999.99"));
        return duplicata;
    }

    public static NFNotaInfoVolume getNFNotaInfoVolume() {
        final NFNotaInfoVolume volume = new NFNotaInfoVolume();
        volume.setEspecieVolumesTransportados("3Qf46HFs7FcWlhuQqLJ96vsrgJHu6B5ZXmmwMZ1RtvQVOV4Yp6M9VNqn5Ecb");
        final NFNotaInfoLacre notaInfoLacre = new NFNotaInfoLacre();
        notaInfoLacre.setNumeroLacre("gvmjb9BB2cmwsLbzeR3Bsk8QbA7b1XEgXUhKeS9QZGiwhFnqDtEzS3377MP2");
        volume.setLacres(Arrays.asList(notaInfoLacre));
        volume.setMarca("lc0w13Xw2PxsSD4u4q3N6Qix9ZuCFm0HXo6BxBmKnjVbh9Xwy3k9UwBNfuYo");
        volume.setNumeracaoVolumesTransportados("mcBUtZwnI5DKj2YZNAcLP7W9h6j1xKmF5SX1BTKmsvyg0H5xSrfVw8HGn8eb");
        volume.setPesoBruto(new BigDecimal("1.358"));
        volume.setPesoLiquido(new BigDecimal("1"));
        volume.setQuantidadeVolumesTransportados(new BigInteger("99999999999"));
        return volume;
    }
}