package com.fincatto.nfe;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import com.fincatto.nfe.classes.nota.NFNotaInfoCana;
import com.fincatto.nfe.classes.nota.NFNotaInfoCanaDeducao;
import com.fincatto.nfe.classes.nota.NFNotaInfoCanaFornecimentoDiario;
import com.fincatto.nfe.classes.nota.NFNotaInfoObservacao;
import com.fincatto.nfe.classes.nota.NFNotaInfoProcessoReferenciado;
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
        canaFornecimentoDiario.setQuantidade(new BigInteger("3"));
        canaFornecimentoDiario.setQuantidadeTotalAnterior(new BigInteger("10"));
        canaFornecimentoDiario.setQuantidadeTotalGeral(new BigInteger("80"));
        canaFornecimentoDiario.setQuantidadeTotalMes(new BigInteger("30"));
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
}