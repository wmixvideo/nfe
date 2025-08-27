package com.fincatto.documentofiscal.mdfe3;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.MDFProtocolo;
import com.fincatto.documentofiscal.mdfe3.classes.MDFProtocoloInfo;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFModalidadeTransporte;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFProcessoEmissao;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoCargaProdutoPredominante;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoCarroceria;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmitente;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoInfPag;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoInfPagComp;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoProprietario;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoResponsavelSeguro;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoRodado;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoTranportador;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoUnidadeCarga;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoUnidadeTransporte;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFUnidadeMedidaPesoBrutoCarga;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLote;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetornoInfoRecebimento;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfSolicNFF;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfo;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoAutorizacaoDownload;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoEmitente;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoEmitenteEndereco;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoIdentificacao;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoIdentificacaoMunicipioCarregamento;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoInformacoesAdicionais;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoInformacoesCTe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoInformacoesDFeTipoUnidadeCarga;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoInformacoesDFeTipoUnidadeTransporte;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoInformacoesDocumentos;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoInformacoesMDFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoInformacoesMunicipioDescarga;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoInformacoesNFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoLacre1A20;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoLacre1A60;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModal;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviario;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioANTT;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfCIOT;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfContratante;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfPag;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfPagBanco;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfPagComp;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioInfPagPrazo;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioPedagio;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioPedagioDisp;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioVeiculoCondutor;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioVeiculoProp;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioVeiculoReboque;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoModalRodoviarioVeiculoTracao;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoPerigosos;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoProdutoPredominante;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoProdutoPredominanteInfLotacao;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoProdutoPredominanteInfLotacaoLocalCarrega;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoProdutoPredominanteInfLotacaoLocalDescarrega;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSeguro;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSeguroInfo;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSeguroResponsavel;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoSuplementar;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFInfoTotal;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFProcessado;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFRespTec;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFCanonicalizationMethod;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFDigestMethod;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFKeyInfo;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFReference;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignatureMethod;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignedInfo;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFTransform;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFX509Data;
import java.math.BigDecimal;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FabricaDeObjetosFakeMDFe {

    public static MDFProcessado getMDFProcessado() {
        MDFProcessado a = new MDFProcessado();
        a.setVersao(BigDecimal.valueOf(3.0));
        a.setSchemaLocation("");
        a.setMdfe(getMDFe1());
        a.setProtocolo(getMDFProtocolo());
        return a;
    }

    public static MDFProtocolo getMDFProtocolo() {
        MDFProtocolo a = new MDFProtocolo();
        a.setVersao(MDFe.VERSAO);
        a.setProtocoloInfo(getMDFProtocoloInfo());
        return a;
    }

    public static MDFProtocoloInfo getMDFProtocoloInfo() {
        MDFProtocoloInfo a = new MDFProtocoloInfo();
        a.setAmbiente(DFAmbiente.HOMOLOGACAO);
        a.setVersaoAplicacao("RS20200626134456");
        a.setChave("33200736293264000128580010000000301045981192");
        a.setDataRecebimento(ZonedDateTime.parse("2020-07-02T23:29:33-03:00"));
        a.setNumeroProtocolo("999999999999999");
        a.setValidador(getNFReference().getDigestValue());
        a.setStatus("100");
        a.setMotivo("Autorizado o uso do MDF-e");
        return a;
    }

    public static MDFe getMDFe1() {
        MDFe a = new MDFe();
        a.setInfo(getMDFInfo());
        a.setMdfInfoSuplementar(getMDFInfoSuplementar());
        a.setAssinatura(getNFSignature());
        return a;
    }

    public static MDFInfo getMDFInfo() {
        MDFInfo a = new MDFInfo();
        a.setIdentificador("33200736293264000128580010000000301045981192");
        a.setVersao(getMDFProtocolo().getVersao());
        a.setIdentificacao(getMDFInfoIdentificacao());
        a.setEmitente(getMDFInfoEmitente());
        a.setMdfInfoModal(getMDFInfoModal());
        a.setInformacoesDocumentos(getMDFInfoInformacoesDocumentos());
        a.setSeguro(Collections.singletonList(getMDFInfoSeguro()));
        a.setProdPred(Collections.singletonList(getMDFInfoProdutoPredominante()));
        a.setInfoTotal(getMDFInfoTotal());
        a.setLacres(Collections.singletonList(getMDFInfoLacre1A60()));
        a.setAutorizacaoDownload(Collections.singletonList(getMDFInfoAutorizacaoDownload()));
        a.setInformacoesAdicionais(getMDFInfoInformacoesAdicionais());
        //a.setInfRespTec(getMDFRespTec());
        a.setInfSolicNFF(getMDFInfSolicNFF());
        return a;
    }

    public static MDFInfoSuplementar getMDFInfoSuplementar() {
        MDFInfoSuplementar a = new MDFInfoSuplementar();
        a.setQrCodMDFe("https://dfe-portal.svrs.rs.gov.br/mdfe/qrCode?chMDFe=33200736293264000128580010000000301045981192&tpAmb=2");
        return a;
    }

    public static NFSignature getNFSignature() {
        NFSignature a = new NFSignature();
        a.setSignedInfo(getNFSignedInfo());
        a.setSignatureValue("hKdILXeEV/2xNpjDEMLR6USZYQF/z9WpHEFXVVwrvPAvuVrR9zpuuLA73zEj3cbwPIJ3x8SSrh5y E22MF2B/HyiE+iOVgljBoOdJY6Ox1N4yzR5Ybz4CyRjDjyj2cDiChWEe3xe/hDtIB5ZSmcsBTegq xoyi/fmfDanqnjIH9pbdej48N+4z4g3z87KBxUgh7cfoRX8YxTIGW8RPwZR6J7pCgtdBx0zxAAD8 X9A8LFYI/EgIBR8BxmAHKRnr2V8GqVKtbmJsY/PPWdsjBF1SAyvVekbvc2BqJOJNbV4IZSWVnsq0 FNWQO1sE9AZMsBseKj4/CYx9VcFRzbZp/M5phw==");
        a.setKeyInfo(getNFKeyInfo());
        return a;
    }

    public static NFSignedInfo getNFSignedInfo() {
        NFSignedInfo a = new NFSignedInfo();
        a.setCanonicalizationMethod(getNFCanonicalizationMethod());
        a.setSignatureMethod(getNFSignatureMethod());
        a.setReference(getNFReference());
        return a;
    }

    public static NFCanonicalizationMethod getNFCanonicalizationMethod() {
        NFCanonicalizationMethod a = new NFCanonicalizationMethod();
        a.setAlgorithm("http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
        return a;
    }

    public static NFSignatureMethod getNFSignatureMethod() {
        NFSignatureMethod a = new NFSignatureMethod();
        a.setAlgorithm("http://www.w3.org/2000/09/xmldsig#rsa-sha1");
        return a;
    }

    public static NFReference getNFReference() {
        NFReference a = new NFReference();
        a.setUri("#MDFe33200736293264000128580010000000301045981192");
        a.setTransform(getNFTransformList());
        a.setDigestMethod(getNFDigestMethod());
        a.setDigestValue("DGElW+22IC8ksSISecob4b2l5QU=");
        return a;
    }

    public static NFDigestMethod getNFDigestMethod() {
        NFDigestMethod a = new NFDigestMethod();
        a.setAlgorithm("http://www.w3.org/2000/09/xmldsig#sha1");
        return a;
    }

    public static NFKeyInfo getNFKeyInfo() {
        NFKeyInfo a = new NFKeyInfo();
        a.setData(getNFX509Data());
        return a;
    }

    public static NFX509Data getNFX509Data() {
        NFX509Data a = new NFX509Data();
        a.setX509certificate("MIIH6DCCBdCgAwIBAgIQdc1vl3hPXUCnmvgAvnw0fDANBgkqhkiG9w0BAQsFADB4MQswCQYDVQQG EwJCUjETMBEGA1UEChMKSUNQLUJyYXNpbDE2MDQGA1UECxMtU2VjcmV0YXJpYSBkYSBSZWNlaXRh IEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRwwGgYDVQQDExNBQyBDZXJ0aXNpZ24gUkZCIEc1MB4X DTIwMDUyNzEzNTQwM1oXDTIxMDUyNzEzNTQwM1owgdkxCzAJBgNVBAYTAkJSMRMwEQYDVQQKDApJ Q1AtQnJhc2lsMQswCQYDVQQIDAJSSjEOMAwGA1UEBwwFTWFjYWUxNjA0BgNVBAsMLVNlY3JldGFy aWEgZGEgUmVjZWl0YSBGZWRlcmFsIGRvIEJyYXNpbCAtIFJGQjEWMBQGA1UECwwNUkZCIGUtQ05Q SiBBMTEXMBUGA1UECwwOMTE4NzEzODgwMDAxMTIxLzAtBgNVBAMMJkdMT0JPTUFSIENPTUVSQ0lB TCBMVERBOjM2MjkzMjY0MDAwMTI4MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzX1v mnxpJZfSnKem+e7p16Bh5PiyjYtJ4hhlNQ8bq8hR96NlzrO+Ar72GJQcfUX1oWsd2K2SdnSzD8Q0 UdnTav+Zzu3TKQA8pIdC/tsGQqD7lN9yyxkgv7vcBHoyIf5LOX1BfdNuBpvPdHlqverzRkX7i0O9 Z2+1dZm11aqJqj6rlZ+LSEROOLBj6nPOsgIahwo8rlfpW3F851m6DtBfxULVHEa6m5AcVZKa4uDl 1KoF4C/UUJN/ka++ialk/TWt9GR9hmWEO7oEBbKzwSaAkgimVFkh0g6J+dCRYHSpZLX/makilirT a7ZJJGQPpJ9tbKjT/o1egtAeW0pZaVWdqwIDAQABo4IDCjCCAwYwgbkGA1UdEQSBsTCBrqA9BgVg TAEDBKA0BDIyNjEwMTk1NzQyMDU2NjE2NzM0MDAwMDAwMDAwMDAwMDAwMDAwMDA0MjAwOTJTU1BF U6AfBgVgTAEDAqAWBBRSRU5BVE8gRlJBTkNJU0NPIEdPTqAZBgVgTAEDA6AQBA4zNjI5MzI2NDAw MDEyOKAXBgVgTAEDB6AOBAwwMDAwMDAwMDAwMDCBGEdMT0JPTUFSQEdMT0JPTUFSLkNPTS5CUjAJ BgNVHRMEAjAAMB8GA1UdIwQYMBaAFFN9f52+0WHQILran+OJpxNzWM1CMH8GA1UdIAR4MHYwdAYG YEwBAgEMMGowaAYIKwYBBQUHAgEWXGh0dHA6Ly9pY3AtYnJhc2lsLmNlcnRpc2lnbi5jb20uYnIv cmVwb3NpdG9yaW8vZHBjL0FDX0NlcnRpc2lnbl9SRkIvRFBDX0FDX0NlcnRpc2lnbl9SRkIucGRm MIG8BgNVHR8EgbQwgbEwV6BVoFOGUWh0dHA6Ly9pY3AtYnJhc2lsLmNlcnRpc2lnbi5jb20uYnIv cmVwb3NpdG9yaW8vbGNyL0FDQ2VydGlzaWduUkZCRzUvTGF0ZXN0Q1JMLmNybDBWoFSgUoZQaHR0 cDovL2ljcC1icmFzaWwub3V0cmFsY3IuY29tLmJyL3JlcG9zaXRvcmlvL2xjci9BQ0NlcnRpc2ln blJGQkc1L0xhdGVzdENSTC5jcmwwDgYDVR0PAQH/BAQDAgXgMB0GA1UdJQQWMBQGCCsGAQUFBwMC BggrBgEFBQcDBDCBrAYIKwYBBQUHAQEEgZ8wgZwwXwYIKwYBBQUHMAKGU2h0dHA6Ly9pY3AtYnJh c2lsLmNlcnRpc2lnbi5jb20uYnIvcmVwb3NpdG9yaW8vY2VydGlmaWNhZG9zL0FDX0NlcnRpc2ln bl9SRkJfRzUucDdjMDkGCCsGAQUFBzABhi1odHRwOi8vb2NzcC1hYy1jZXJ0aXNpZ24tcmZiLmNl cnRpc2lnbi5jb20uYnIwDQYJKoZIhvcNAQELBQADggIBAKm3NO8lmyabocQTKdfD2/7URoLF7Jie qkKChvgPRfXTcS5vuoAbXfyAHwHIE9vinS0NegjcOAtpsWtY0dm4A4zxiPom9TKz2fQSH2qCYOxm d6DH4i0QTZS9sqjX8WMiLpAj0KgbjH1L7QUfe0y3TKTM5c37ZN0Wn6URW16vfY/SHPHGz5hWIW0K 4Dsr2H2AXikixfwGekoBTyGvRy7waqmiNU2DPNndDTyS79IoDc+wzuNG5cehljMpgPHi1DlikD3o UPW6MMrQpwjJsejj0+6lzR72zDwOcB1B7Sv8zNEjcqekkx89xaKQAVz3S1moUbLvPXE+b6i4ZYAM LQoIng8w3eyDzfucxwPevjFxePniRM5aLhEG7ArQWdKoc9SgovEg1prT2QA5JrZfeS3jHywel+tC pwz06aM7aBMXUvNVlMzia0ixgHT7S00zzs7YeRE4CxLzX/0imn9nl5G9cfOrOyUPm61x/m4fzyGO 1jc3vlv3KNRdzvAKQecpLTxAuIU1v0J0vUjSjjKpbtFmHrLrsCQHhPCqcgKAgV7UdU/FZtaIDr+G 8xho1HSuXGi+klzQXdPE7QGJw8rnVAUMo75vkfihYtZQpjLypfQGtlcuXdC9XOQdbIGjWqrZYmHh O7z7O+bKzTEIMG5C9M0wJU2KzK+2jspLWHJCw4zHUIsq");
        return a;
    }

    public static List<NFTransform> getNFTransformList() {
        List<NFTransform> a = new ArrayList<>();
        NFTransform b = new NFTransform();
        b.setAlgorithm("http://www.w3.org/2000/09/xmldsig#enveloped-signature");
        a.add(b);
        NFTransform c = new NFTransform();
        c.setAlgorithm("http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
        a.add(c);
        return a;
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
        String infSeguroAverbacao0 = "1245789865322154879865325487986532154876";
        infSeguroAverbacaoList.add(infSeguroAverbacao0);
        //
        String infSeguroAverbacao1 = "1245789865322154879865325487986532154877";
        infSeguroAverbacaoList.add(infSeguroAverbacao1);
        return infSeguroAverbacaoList;
    }

    public static MDFEnvioLoteRetornoInfoRecebimento getMDFEnvioLoteRetornoInfoRecebimento() {
        final MDFEnvioLoteRetornoInfoRecebimento recebimentoInfo = new MDFEnvioLoteRetornoInfoRecebimento();
        recebimentoInfo.setDataRecibo(ZonedDateTime.of(2018, 10, 06, 19, 18, 35, 0, DFConfig.TIMEZONE_SP.toZoneId()));
        //recebimentoInfo.setDataRecibo(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2018-10-06 19:18:35")));
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

    public static MDFInfoIdentificacao getMDFInfoIdentificacao() {
        final MDFInfoIdentificacao infoIdentificacao = new MDFInfoIdentificacao();
        infoIdentificacao.setCodigoUF(DFUnidadeFederativa.ES);
        infoIdentificacao.setAmbiente(DFAmbiente.HOMOLOGACAO);
        infoIdentificacao.setTipoEmitente(MDFTipoEmitente.TRANSPORTADOR_CARGA_PROPRIA);
        infoIdentificacao.setTipoTranportador(MDFTipoTranportador.TAC);
        infoIdentificacao.setSerie(1);
        infoIdentificacao.setNumero(123654);
        infoIdentificacao.setCodigoNumerico("12345689");
        infoIdentificacao.setDigitoVerificador(1);
        infoIdentificacao.setModalidadeFrete(MDFModalidadeTransporte.RODOVIARIO);
        infoIdentificacao.setDataEmissao(ZonedDateTime.of(2019, 05, 28, 11, 07, 55, 0, DFConfig.TIMEZONE_SP.toZoneId()));
        //infoIdentificacao.setDataEmissao(LocalDateTime.of(2019, 05, 28, 11, 07, 55));
        infoIdentificacao.setTipoEmissao(MDFTipoEmissao.NORMAL);
        infoIdentificacao.setProcessoEmissao(MDFProcessoEmissao.EMISSOR_CONTRIBUINTE);
        infoIdentificacao.setVersaoProcessoEmissao("3.0");
        infoIdentificacao.setUnidadeFederativaInicio(DFUnidadeFederativa.RJ);
        infoIdentificacao.setUnidadeFederativaFim(DFUnidadeFederativa.ES);
        infoIdentificacao.setMunicipioCarregamentos(Collections.singletonList(FabricaDeObjetosFakeMDFe.getMunicipioCarregamentos()));
        infoIdentificacao.setIdentificacaoUfPercursos(null);
        infoIdentificacao.setDataHoraDoInicioViagem(ZonedDateTime.of(2019, 05, 28, 11, 07, 55, 0, DFConfig.TIMEZONE_SP.toZoneId()));
        infoIdentificacao.setIndicadorCanalVerde(null);
        infoIdentificacao.setIndicadorCarregaPosterior(null);
        return infoIdentificacao;
    }

    public static MDFInfoIdentificacaoMunicipioCarregamento getMunicipioCarregamentos() {
        MDFInfoIdentificacaoMunicipioCarregamento s = new MDFInfoIdentificacaoMunicipioCarregamento();
        s.setCodigoMunicipioCarregamento("3304557");
        s.setNomeMunicipioCarregamento("Rio de Janeiro");
        return s;
    }

    public static MDFInfoEmitente getMDFInfoEmitente() {
        final MDFInfoEmitente a = new MDFInfoEmitente();
        a.setCnpj("99999999999999");
        //a.setCpf(null);
        a.setInscricaoEstadual("9999999999");
        a.setRazaoSocial("XXXXXXXXXXXXXXXXXXXX");
        a.setNomeFantasia("XXXXXXXXXXXXXXXX");
        a.setEndereco(getMDFInfoEmitenteEndereco());
        return a;
    }

    public static MDFInfoEmitenteEndereco getMDFInfoEmitenteEndereco() {
        final MDFInfoEmitenteEndereco a = new MDFInfoEmitenteEndereco();
        a.setLogradouro("VVVVVVVVVVVVV");
        a.setNumero("1234");
        a.setComplemento("ASDFG");
        a.setBairro("BBBBBBBBBB");
        a.setCodigoMunicipio("3300100");
        a.setDescricaoMunicipio("Angra dos Reis");
        a.setCep("99999999");
        a.setSiglaUF("RJ");
        a.setTelefone("9999999999");
        a.setEmail("nonono@nono.non.no");
        return a;
    }

    public static MDFInfoModal getMDFInfoModal() {
        final MDFInfoModal a = new MDFInfoModal();
        a.setVersao("3.00");
        a.setRodoviario(getMDFInfoModalRodoviario());
        return a;
    }

    public static MDFInfoModalRodoviario getMDFInfoModalRodoviario() {
        final MDFInfoModalRodoviario a = new MDFInfoModalRodoviario();
        a.setMdfInfoModalRodoviarioANTT(getMdfInfoModalRodoviarioANTT());
        a.setVeiculoTracao(getMDFInfoModalRodoviarioVeiculoTracao());
        a.setVeiculoReboques(Collections.singletonList(getMDFInfoModalRodoviarioVeiculoReboque()));
        a.setCodAgPorto(null);
        a.setLacres(null);
        return a;
    }

    public static MDFInfoModalRodoviarioANTT getMdfInfoModalRodoviarioANTT() {
        final MDFInfoModalRodoviarioANTT a = new MDFInfoModalRodoviarioANTT();
        a.setRntrc("87654321");
        a.setInfCIOT(Collections.singletonList(getMDFInfoModalRodoviarioInfCIOT()));
        a.setValePedagio(getMDFInfoModalRodoviarioPedagio());
        a.setInfContratante(Collections.singletonList(getMDFInfoModalRodoviarioInfContratante()));
        a.setInfPag(Collections.singletonList(getMDFInfoModalRodoviarioInfPag()));
        return a;
    }

    public static MDFInfoModalRodoviarioInfCIOT getMDFInfoModalRodoviarioInfCIOT() {
        final MDFInfoModalRodoviarioInfCIOT a = new MDFInfoModalRodoviarioInfCIOT();
        a.setCiot("123456789123");
        a.setCnpj("99999999999999");
        //a.setCpf(null);
        return a;
    }

    public static MDFInfoModalRodoviarioPedagio getMDFInfoModalRodoviarioPedagio() {
        final MDFInfoModalRodoviarioPedagio a = new MDFInfoModalRodoviarioPedagio();
        a.setDispositivos(Collections.singletonList(getMDFInfoModalRodoviarioPedagioDisp()));
        return a;
    }

    public static MDFInfoModalRodoviarioPedagioDisp getMDFInfoModalRodoviarioPedagioDisp() {
        final MDFInfoModalRodoviarioPedagioDisp a = new MDFInfoModalRodoviarioPedagioDisp();
        a.setCnpjFornecedora("99999999999999");
        //a.setCnpjPagadora("99999999999999");
        a.setCpfPagadora("99999999999");
        a.setNumeroComprovante("999999");
        a.setValor(new BigDecimal("999999.99"));
        return a;
    }

    public static MDFInfoModalRodoviarioInfContratante getMDFInfoModalRodoviarioInfContratante() {
        final MDFInfoModalRodoviarioInfContratante a = new MDFInfoModalRodoviarioInfContratante();
        a.setCnpj("99999999999999");
        //a.setCpf(null);
        //a.setIdEstrangeiro(null);
        return a;
    }

    public static MDFInfoModalRodoviarioInfPag getMDFInfoModalRodoviarioInfPag() {
        final MDFInfoModalRodoviarioInfPag a = new MDFInfoModalRodoviarioInfPag();
        a.setXNome("NONONONONO NONONO");
        a.setCnpj("99999999999999");
        //a.setCpf(null);
        //a.setIdEstrangeiro(null);
        a.setComp(Collections.singletonList(getMDFInfoModalRodoviarioInfPagComp()));
        a.setVContrato(new BigDecimal("9999.99"));
        a.setIndPag(MDFTipoInfPag.A_PRAZO);
        a.setInfPrazo(Collections.singletonList(getMDFInfoModalRodoviarioInfPagPrazo()));
        a.setInfBanc(getMDFInfoModalRodoviarioInfPagBanco());
        return a;
    }

    public static MDFInfoModalRodoviarioInfPagComp getMDFInfoModalRodoviarioInfPagComp() {
        final MDFInfoModalRodoviarioInfPagComp a = new MDFInfoModalRodoviarioInfPagComp();
        a.setTpComp(MDFTipoInfPagComp.OUTROS);
        a.setVComp(new BigDecimal("88888.88"));
        a.setXComp("COMPCOMPCOMP");
        return a;
    }

    public static MDFInfoModalRodoviarioInfPagPrazo getMDFInfoModalRodoviarioInfPagPrazo() {
        final MDFInfoModalRodoviarioInfPagPrazo a = new MDFInfoModalRodoviarioInfPagPrazo();
        a.setNParcela("001");
        a.setDVenc(LocalDate.of(2020, Month.MARCH, 3));
        a.setVParcela(new BigDecimal("88888.88"));
        return a;
    }

    public static MDFInfoModalRodoviarioInfPagBanco getMDFInfoModalRodoviarioInfPagBanco() {
        final MDFInfoModalRodoviarioInfPagBanco a = new MDFInfoModalRodoviarioInfPagBanco();
        a.setCodBanco("001");
        a.setCodAgencia("1525");
        a.setCNPJIPEF(null);
        return a;
    }

    public static MDFInfoModalRodoviarioVeiculoTracao getMDFInfoModalRodoviarioVeiculoTracao() {
        final MDFInfoModalRodoviarioVeiculoTracao a = new MDFInfoModalRodoviarioVeiculoTracao();
        a.setCodigoInterno("1");
        a.setPlaca("MTX5K56");
        a.setRenavam("99999999999");
        a.setTara("888888");
        a.setCapacidadeM3("23");
        a.setProprietario(getMDFInfoModalRodoviarioVeiculoProp());
        a.setTipoCarroceria(MDFTipoCarroceria.ABERTA);
        a.setUnidadeFederativa(DFUnidadeFederativa.ES);
        a.setCondutor(Collections.singletonList(getMDFInfoModalRodoviarioVeiculoCondutor()));
        a.setTipoRodado(MDFTipoRodado.TOCO);
        a.setCapacidadeKG("13");
        return a;
    }

    public static MDFInfoModalRodoviarioVeiculoProp getMDFInfoModalRodoviarioVeiculoProp() {
        final MDFInfoModalRodoviarioVeiculoProp a = new MDFInfoModalRodoviarioVeiculoProp();
        //a.setCnpj(null);
        a.setCpf("99999999999");
        a.setRegistroNacionalTransportes("55555555");
        a.setRazaoSocial("NONONONO NONONONO");
        a.setInscricaoEstadual("77777777");
        a.setUnidadeFederativa(DFUnidadeFederativa.ES);
        a.setTipoProprietario(MDFTipoProprietario.TAC_INDEPENDENTE);
        return a;
    }

    public static MDFInfoModalRodoviarioVeiculoCondutor getMDFInfoModalRodoviarioVeiculoCondutor() {
        final MDFInfoModalRodoviarioVeiculoCondutor a = new MDFInfoModalRodoviarioVeiculoCondutor();
        a.setCpf("99999999999");
        a.setNomeCondutor("NONONONO NONONONO");
        return a;
    }

    public static MDFInfoModalRodoviarioVeiculoReboque getMDFInfoModalRodoviarioVeiculoReboque() {
        final MDFInfoModalRodoviarioVeiculoReboque a = new MDFInfoModalRodoviarioVeiculoReboque();
        a.setCodigoInterno("1");
        a.setPlaca("MTX5K56");
        a.setRenavam("9999999999");
        a.setTara("888888");
        a.setCapacidadeM3("230");
        a.setProprietario(getMDFInfoModalRodoviarioVeiculoProp());
        a.setTipoCarroceria(MDFTipoCarroceria.FECHADA_BAU);
        a.setUnidadeFederativa(DFUnidadeFederativa.ES);
        a.setCapacidadeKG("130");
        return a;
    }

    public static MDFInfoInformacoesDocumentos getMDFInfoInformacoesDocumentos() {
        final MDFInfoInformacoesDocumentos a = new MDFInfoInformacoesDocumentos();
        a.setInformacoesMunicipioDescargas(Collections.singletonList(getMDFInfoInformacoesMunicipioDescarga()));
        return a;
    }

    public static MDFInfoInformacoesMunicipioDescarga getMDFInfoInformacoesMunicipioDescarga() {
        MDFInfoInformacoesMunicipioDescarga a = new MDFInfoInformacoesMunicipioDescarga();
        a.setMunicipioDescarga("3300100");
        a.setxMunDescarga("Angra dos Reis");
        a.setInfCTe(Collections.singletonList(getMDFInfoInformacoesCTe()));
        a.setInfNFe(Collections.singletonList(getMDFInfoInformacoesNFe()));
        a.setInfMDFeTransp(Collections.singletonList(getMDFInfoInformacoesMDFe()));
        return a;
    }

    public static MDFInfoInformacoesCTe getMDFInfoInformacoesCTe() {
        MDFInfoInformacoesCTe a = new MDFInfoInformacoesCTe();
        a.setChaveCTe("33333333333333333333333333333333333333333333");
        a.setSegCodBarra("123456789123512345678912351234567891");
        a.setIndicadorReentrega("1");
        a.setInformacoesUnidadeTransporte(Collections.singletonList(getMDFInfoInformacoesDFeTipoUnidadeTransporte()));
        a.setPerigosos(Collections.singletonList(getMDFInfoPerigosos()));
        return a;
    }

    public static MDFInfoInformacoesDFeTipoUnidadeTransporte getMDFInfoInformacoesDFeTipoUnidadeTransporte() {
        MDFInfoInformacoesDFeTipoUnidadeTransporte a = new MDFInfoInformacoesDFeTipoUnidadeTransporte();
        a.setTipoUnidadeTransporte(MDFTipoUnidadeTransporte.RODOVIARIO_TRACAO);
        a.setIdUnidTransp("258");
        a.setLacUnidTransp(Collections.singletonList(getMDFInfoLacre1A20()));
        a.setInfUnidCarga(Collections.singletonList(getMDFInfoInformacoesDFeTipoUnidadeCarga()));
        a.setQtdRateada("56");
        return a;
    }

    public static MDFInfoLacre1A20 getMDFInfoLacre1A20() {
        MDFInfoLacre1A20 a = new MDFInfoLacre1A20();
        a.setNumeroDoLacre("1236547890");
        return a;
    }

    public static MDFInfoLacre1A60 getMDFInfoLacre1A60() {
        MDFInfoLacre1A60 a = new MDFInfoLacre1A60();
        a.setNumeroDoLacre("0987654321");
        return a;
    }

    public static MDFInfoInformacoesDFeTipoUnidadeCarga getMDFInfoInformacoesDFeTipoUnidadeCarga() {
        MDFInfoInformacoesDFeTipoUnidadeCarga a = new MDFInfoInformacoesDFeTipoUnidadeCarga();
        a.setTipoUnidadeCarga(MDFTipoUnidadeCarga.CONTAINER);
        a.setIdUnidCarga("5698");
        a.setLacUnidCarga(Collections.singletonList(getMDFInfoLacre1A20()));
        a.setQtdRateada("65");
        return a;
    }

    public static MDFInfoPerigosos getMDFInfoPerigosos() {
        MDFInfoPerigosos a = new MDFInfoPerigosos();
        a.setNumeroONU("4567");
        a.setNomeEmbarque("AAAAAA");
        a.setClasseRisco("88");
        a.setGrupoEmbalagem("79");
        a.setqTotProd("44");
        a.setQtdeTipoVolume("33");
        return a;
    }

    public static MDFInfoInformacoesNFe getMDFInfoInformacoesNFe() {
        MDFInfoInformacoesNFe a = new MDFInfoInformacoesNFe();
        a.setChaveNFe("33333333333333333333333333333333333333333333");
        a.setSegCodBarra("123456789123512345678912351234567892");
        a.setIndicadorReentrega("1");
        a.setInformacoesUnidadeTransporte(Collections.singletonList(getMDFInfoInformacoesDFeTipoUnidadeTransporte()));
        a.setPerigosos(Collections.singletonList(getMDFInfoPerigosos()));
        return a;
    }

    public static MDFInfoInformacoesMDFe getMDFInfoInformacoesMDFe() {
        MDFInfoInformacoesMDFe a = new MDFInfoInformacoesMDFe();
        a.setChaveMDFe("33333333333333333333333333333333333333333333");
        a.setIndicadorReentrega("1");
        a.setInformacoesUnidadeTransporte(Collections.singletonList(getMDFInfoInformacoesDFeTipoUnidadeTransporte()));
        a.setPerigosos(Collections.singletonList(getMDFInfoPerigosos()));
        return a;
    }

    public static MDFInfoProdutoPredominante getMDFInfoProdutoPredominante() {
        MDFInfoProdutoPredominante a = new MDFInfoProdutoPredominante();
        a.setTpCarga(MDFTipoCargaProdutoPredominante.CARGA_GERAL);
        a.setXProd("PRODUTO PRODUTO PRODUTO PRODUTO");
        a.setCEAN("SEM GTIN");
        a.setNCM("12345678");
        a.setInfLotacao(getMDFInfoProdutoPredominanteInfLotacao());
        return a;
    }

    public static MDFInfoProdutoPredominanteInfLotacao getMDFInfoProdutoPredominanteInfLotacao() {
        MDFInfoProdutoPredominanteInfLotacao a = new MDFInfoProdutoPredominanteInfLotacao();
        a.setInfLocalCarrega(getMDFInfoProdutoPredominanteInfLotacaoLocalCarrega());
        a.setInfLocalDescarrega(getMDFInfoProdutoPredominanteInfLotacaoLocalDescarrega());
        return a;
    }

    public static MDFInfoProdutoPredominanteInfLotacaoLocalCarrega getMDFInfoProdutoPredominanteInfLotacaoLocalCarrega() {
        MDFInfoProdutoPredominanteInfLotacaoLocalCarrega a = new MDFInfoProdutoPredominanteInfLotacaoLocalCarrega();
        a.setCEP(null);
        a.setLatitude(Float.valueOf("-11.235689"));
        a.setLongitude(Float.valueOf("-32.986574"));
        return a;
    }

    public static MDFInfoProdutoPredominanteInfLotacaoLocalDescarrega getMDFInfoProdutoPredominanteInfLotacaoLocalDescarrega() {
        MDFInfoProdutoPredominanteInfLotacaoLocalDescarrega a = new MDFInfoProdutoPredominanteInfLotacaoLocalDescarrega();
        a.setCEP(null);
        a.setLatitude(Float.valueOf("-11.235689"));
        a.setLongitude(Float.valueOf("-32.986574"));
        return a;
    }

    public static MDFInfoTotal getMDFInfoTotal() {
        MDFInfoTotal a = new MDFInfoTotal();
        a.setQtdeCTe("1");
        a.setQtdeNFe("1");
        a.setQtdeMDFe("1");
        a.setValorTotalCarga(new BigDecimal("5689.69"));
        a.setUnidadeMedidaPesoBrutoCarga(MDFUnidadeMedidaPesoBrutoCarga.TON);
        a.setPesoCarga(new BigDecimal("456589.58"));
        return a;
    }

    public static MDFInfoAutorizacaoDownload getMDFInfoAutorizacaoDownload() {
        MDFInfoAutorizacaoDownload a = new MDFInfoAutorizacaoDownload();
        a.setCnpj("99999999999999");
        //a.setCpf(null);
        return a;
    }

    public static MDFInfoInformacoesAdicionais getMDFInfoInformacoesAdicionais() {
        MDFInfoInformacoesAdicionais a = new MDFInfoInformacoesAdicionais();
        a.setInformacoesAdicionaisInteresseFisco("XSSWERTYUIPPASDSDSAFHG");
        a.setInformacoesComplementaresInteresseContribuinte("PIUYTRDFBJKLMNHYUIKJNBVFCVG");
        return a;
    }

    public static MDFRespTec getMDFRespTec() {
        MDFRespTec a = new MDFRespTec();
        a.setCNPJ("99999999999999");
        a.setXContato("NONONONO NONONONONO");
        a.setEmail("NONONONO@NONONONONO.NOO.NO");
        a.setFone("99999999999");
        a.setIdCSRT("2222222222");
        //a.setHashCSRT(null);
        return a;
    }

    public static MDFInfSolicNFF getMDFInfSolicNFF() {
        MDFInfSolicNFF a = new MDFInfSolicNFF();
        a.setXSolic("{\"id\":\"1\",\"nome\":\"NONONO\"}");
        return a;
    }
}
