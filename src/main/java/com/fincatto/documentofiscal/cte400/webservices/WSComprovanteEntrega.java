package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.comprovanteentrega.CTeEnviaEventoComprovanteEntrega;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WSComprovanteEntrega extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Comprovante de Entrega do CT-e";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
    private static final String EVENTO_COMPROVANTE_DE_ENTREGA = "110180";
    private static final List<DFModelo> modelosPermitidos = Arrays.asList(DFModelo.CTE);

    WSComprovanteEntrega(final CTeConfig config, final DFHttpClient httpClient) {
        super(config, httpClient, modelosPermitidos);
    }

    CTeEventoRetorno comprovanteEntregaAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = this.efetuaComprovanteEntrega(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, xmlResultado);
    }

    CTeEventoRetorno comprovanteEntrega(final String chaveAcesso, final CTeEnviaEventoComprovanteEntrega comprovanteEntrega, final int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, comprovanteEntrega, sequencialEvento);
        final String xmlResultado = this.efetuaComprovanteEntrega(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, xmlResultado);
    }

    String getXmlAssinado(final String chave, final CTeEnviaEventoComprovanteEntrega comprovanteEntrega, final int sequencialEvento) throws Exception {
        final String xml = this.gerarDadosComprovanteEntrega(chave, comprovanteEntrega, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private String efetuaComprovanteEntrega(final String xmlAssinado, final String chaveAcesso) throws Exception {
        return super.efetuaEvento(xmlAssinado, chaveAcesso, VERSAO_LEIAUTE);
    }

    private CTeEvento gerarDadosComprovanteEntrega(final String chaveAcesso, final CTeEnviaEventoComprovanteEntrega comprovanteEntrega, final int sequencialEvento) throws Exception {
        comprovanteEntrega.setDescricaoEvento(DESCRICAO_EVENTO);

        DFXMLValidador.validaEventoComprovanteEntregaCTe400(comprovanteEntrega.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, comprovanteEntrega, EVENTO_COMPROVANTE_DE_ENTREGA, null, sequencialEvento);
    }
}
