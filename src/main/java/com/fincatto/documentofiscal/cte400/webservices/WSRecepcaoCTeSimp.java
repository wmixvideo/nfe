package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeSimpEnvioRetorno;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeSimpEnvioRetornoDados;
import com.fincatto.documentofiscal.cte400.classes.simp.CTeNotaSimp;
import com.fincatto.documentofiscal.cte400.webservices.gerado.CTeRecepcaoSimpV4Stub;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

class WSRecepcaoCTeSimp implements DFLog {
    private final CTeConfig config;

    WSRecepcaoCTeSimp(final CTeConfig config) {
        this.config = config;
    }

    public CTeSimpEnvioRetornoDados enviaCTe(CTeNotaSimp cteSimp) throws Exception {
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cteSimp.toString(), "infCte");
        final CTeNotaSimp cteAssinado = this.config.getPersister().read(CTeNotaSimp.class, documentoAssinado);

        final CTeSimpEnvioRetorno retorno = comunicaLote(documentoAssinado);
        return new CTeSimpEnvioRetornoDados(retorno, cteAssinado);
    }

    private CTeSimpEnvioRetorno comunicaLote(final String cteAssinadoXml) throws Exception {
        DFXMLValidador.validaNotaCteSimp400(cteAssinadoXml);

        String conteudoCompactado;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
             try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
                 gzipOutputStream.write(cteAssinadoXml.getBytes(StandardCharsets.UTF_8));
             }
            conteudoCompactado = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }

        final CTeRecepcaoSimpV4Stub.CteDadosMsg dados = new CTeRecepcaoSimpV4Stub.CteDadosMsg();
        dados.setCteDadosMsg(conteudoCompactado);

        final CTAutorizador400 autorizador = CTAutorizador400.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = autorizador.getCteRecepcaoSimp(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao Simp, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        final CTeRecepcaoSimpV4Stub.CteRecepcaoSimpResult autorizacaoLoteResult = new CTeRecepcaoSimpV4Stub(endpoint, config).cteRecepcaoSimp(dados);
        final CTeSimpEnvioRetorno retorno = this.config.getPersister().read(CTeSimpEnvioRetorno.class, autorizacaoLoteResult.getExtraElement().toString());
        this.getLogger().debug(retorno.toString());
        return retorno;
    }

}
