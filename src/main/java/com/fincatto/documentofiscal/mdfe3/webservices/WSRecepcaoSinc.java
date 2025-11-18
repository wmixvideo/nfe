package com.fincatto.documentofiscal.mdfe3.webservices;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.envio.MDFEnvioRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.nota.envio.MDFEnvioRetornoDados;
import com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

class WSRecepcaoSinc implements DFLog {
    
    private final MDFeConfig config;
    
    WSRecepcaoSinc(final MDFeConfig config) {
        this.config = config;
    }
    
    public MDFEnvioRetornoDados envioRecepcaoSinc(MDFe mdfeRecepcao) throws Exception {
        //assina o mdfe
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(mdfeRecepcao.toString(), "infMDFe");
        final MDFe mdfeAssinado = this.config.getPersister().read(MDFe.class, documentoAssinado);
        
        //comunica o mdfe
        final MDFEnvioRetorno retorno = comunicaSinc(documentoAssinado);
        return new MDFEnvioRetornoDados(retorno, mdfeAssinado);
    }

    public MDFEnvioRetornoDados envioRecepcaoSincAssinado(final String mdfeEnvioXmlAssinado) throws Exception {
        final MDFe mdfeAssinado = this.config.getPersister().read(MDFe.class, mdfeEnvioXmlAssinado);

        //comunica o mdfe
        final MDFEnvioRetorno retorno = comunicaSinc(mdfeEnvioXmlAssinado);
        return new MDFEnvioRetornoDados(retorno, mdfeAssinado);
    }
    
    private MDFEnvioRetorno comunicaSinc(final String mdfeAssinadoXml) throws Exception {
        //devido a limitacao padrao de 5000 da jdk
        //veja em https://docs.oracle.com/javase/7/docs/api/javax/xml/XMLConstants.html#FEATURE_SECURE_PROCESSING
        System.setProperty("jdk.xml.maxOccurLimit", "10000");
        //valida o mdfe assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaMDFe(mdfeAssinadoXml);
        
        String mdfeAssinadoXmlGZip = encodeXmlToGZip(mdfeAssinadoXml);
        
        //adiciona o XML do MDFe assinado e compactado ao envelope de envio do Soap
        final MDFeRecepcaoSincStub.MdfeDadosMsg dados = new MDFeRecepcaoSincStub.MdfeDadosMsg();
        dados.setExtraElement(mdfeAssinadoXmlGZip);
        
        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeRecepcaoSinc(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao do MDFe, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        
        final MDFeRecepcaoSincStub.MdfeRecepcaoSincResult autorizacaoResult = new MDFeRecepcaoSincStub(endpoint, config).mdfeRecepcaoSinc(dados);
        final MDFEnvioRetorno retorno = this.config.getPersister().read(MDFEnvioRetorno.class, autorizacaoResult.getExtraElement().toString());
        this.getLogger().debug(retorno.toString());
        return retorno;
    }
    
    
    private static String encodeXmlToGZip(final String stringXml) throws Exception {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
             try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
                 gzipOutputStream.write(stringXml.getBytes(StandardCharsets.UTF_8));
             }
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }
    }
}
