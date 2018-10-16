package com.fincatto.documentofiscal.mdfe3;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoResponsavelSeguro;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLote;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetornoDados;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetornoInfoRecebimento;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSeguro;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSeguroInfo;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSeguroResponsavel;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

public class FabricaDeObjetosFakeMDFe {

    public static MDFe getMDFe1() {
        final MDFe a1 = new MDFe();
        return a1;
    }

    public static MDFInfoSeguro getMDFInfoSeguro() {
        final MDFInfoSeguro infSeguro = new MDFInfoSeguro();
        infSeguro.setResponsavelSeguro(FabricaDeObjetosFakeMDFe.getMDFInfoSeguroResponsavel());
        infSeguro.setInfo(FabricaDeObjetosFakeMDFe.getMDFInfoSeguroInfo());
        infSeguro.setApolice("12457898653245789865");
        infSeguro.setAverbacao(FabricaDeObjetosFakeMDFe.getMDFInfoSeguroAverbacao());
        return infSeguro;
    }

    public static MDFInfoSeguroResponsavel getMDFInfoSeguroResponsavel() {
        final MDFInfoSeguroResponsavel infSeguroResp = new MDFInfoSeguroResponsavel();
        infSeguroResp.setCnpj("12345678901234");
        infSeguroResp.setResponsavelSeguro(MDFTipoResponsavelSeguro.CONTRATANTE_MDFE);
        return infSeguroResp;
    }

    public static MDFInfoSeguroInfo getMDFInfoSeguroInfo() {
        final MDFInfoSeguroInfo infSeguroInfo = new MDFInfoSeguroInfo();
        infSeguroInfo.setCnpj("12345678901234");
        infSeguroInfo.setSeguradora("891726585917544010862180488469");
        return infSeguroInfo;
    }

    public static List<String> getMDFInfoSeguroAverbacao() {
        final List<String> infSeguroAverbacaoList = new ArrayList<>();
        String infSeguroAverbacao0 = new String("1245789865322154879865325487986532154876");
        infSeguroAverbacaoList.add(infSeguroAverbacao0);
        //
        String infSeguroAverbacao1 = new String("1245789865322154879865325487986532154877");
        infSeguroAverbacaoList.add(infSeguroAverbacao1);
        return infSeguroAverbacaoList;
    }

    public static MDFEnvioLoteRetornoInfoRecebimento getMDFEnvioLoteRetornoInfoRecebimento() {
        final MDFEnvioLoteRetornoInfoRecebimento recebimentoInfo = new MDFEnvioLoteRetornoInfoRecebimento();
        recebimentoInfo.setDataRecibo(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2018-10-06 19:18:35")));
        recebimentoInfo.setNumeroRecibo("845e40545");
        recebimentoInfo.setTempoMedio(BigInteger.valueOf(12345689));
        return recebimentoInfo;
    }

    public static MDFEnvioLoteRetorno getMDFEnvioLoteRetorno() {
        final MDFEnvioLoteRetorno s = new MDFEnvioLoteRetorno();
        s.setAmbiente(DFAmbiente.HOMOLOGACAO);
        s.setInfoRecebimento(getMDFEnvioLoteRetornoInfoRecebimento());
        s.setMotivo("ASwaRTreDFd");
        s.setStatus("OK");
        s.setUf(DFUnidadeFederativa.DF);
        s.setVersao("3.00");
        s.setVersaoAplicacao("1.00");
        return s;
    }

    public static MDFEnvioLote getMDFEnvioLote() {
        final MDFEnvioLote loteEnvio = new MDFEnvioLote();
        loteEnvio.setIdLote("333972757970401");
        loteEnvio.setVersao("3.00");
        loteEnvio.setMdfe(getMDFe1());
        return loteEnvio;
    }

    public static MDFEnvioLoteRetornoDados getMDFEnvioLoteRetornoDados() {

        return new MDFEnvioLoteRetornoDados(getMDFEnvioLoteRetorno(), getMDFEnvioLote());
    }

}
