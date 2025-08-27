package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeEnvioRetornoDados;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeEnvioRetorno;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNota;
import com.fincatto.documentofiscal.cte400.webservices.gerado.CTeRecepcaoSincV4Stub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

class WSRecepcaoCTe implements DFLog {
    private final CTeConfig config;

    WSRecepcaoCTe(final CTeConfig config) {
        this.config = config;
    }
    
    public CTeEnvioRetornoDados enviaCTe(CTeNota cte) throws Exception {
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cte.toString(), "infCte");
        final CTeNota cteAssinado = this.config.getPersister().read(CTeNota.class, documentoAssinado);

        final CTeEnvioRetorno retorno = comunicaLote(documentoAssinado);
        return new CTeEnvioRetornoDados(retorno, cteAssinado);
    }
    
    private CTeEnvioRetorno comunicaLote(final String cteAssinadoXml) throws Exception {
        DFXMLValidador.validaNotaCte400(cteAssinadoXml);

        String conteudoCompactado;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
             try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
                 gzipOutputStream.write(cteAssinadoXml.getBytes(StandardCharsets.UTF_8));
             }
            conteudoCompactado = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }

        final CTeRecepcaoSincV4Stub.CteDadosMsg dados = new CTeRecepcaoSincV4Stub.CteDadosMsg();
        dados.setCteDadosMsg(conteudoCompactado);

        final CTAutorizador400 autorizador = CTAutorizador400.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = autorizador.getCteRecepcaoSinc(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        final CTeRecepcaoSincV4Stub.CteRecepcaoResult autorizacaoLoteResult = new CTeRecepcaoSincV4Stub(endpoint, config).cteRecepcao(dados);
        final CTeEnvioRetorno retorno = this.config.getPersister().read(CTeEnvioRetorno.class, autorizacaoLoteResult.getExtraElement().toString());
        this.getLogger().debug(retorno.toString());
        return retorno;
    }

}
