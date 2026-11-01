package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.insucessoentrega.CTeEnviaEventoInsucessoEntrega;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WSInsucessoEntrega extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Insucesso na Entrega do CT-e";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
    private static final String EVENTO_INSUCESSO_DE_ENTREGA = "110190";
    private static final List<DFModelo> modelosPermitidos = Arrays.asList(DFModelo.CTE);

    WSInsucessoEntrega(final CTeConfig config, final DFHttpClient httpClient) {
        super(config, httpClient, modelosPermitidos);
    }

    CTeEventoRetorno insucessoEntregaAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = super.efetuaEvento(eventoAssinadoXml, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, xmlResultado);
    }

    CTeEventoRetorno insucessoEntrega(final String chaveAcesso, final CTeEnviaEventoInsucessoEntrega insucessoEntrega, final int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, insucessoEntrega, sequencialEvento);
        final String xmlResultado = super.efetuaEvento(xmlAssinado, chaveAcesso);
        return this.config.getPersister().read(CTeEventoRetorno.class, xmlResultado);
    }

    String getXmlAssinado(final String chave, final CTeEnviaEventoInsucessoEntrega insucessoEntrega, final int sequencialEvento) throws Exception {
        final String xml = this.gerarDadosInsucessoEntrega(chave, insucessoEntrega, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private CTeEvento gerarDadosInsucessoEntrega(final String chaveAcesso, final CTeEnviaEventoInsucessoEntrega insucessoEntrega, final int sequencialEvento) throws Exception {
        insucessoEntrega.setDescricaoEvento(DESCRICAO_EVENTO);

        DFXMLValidador.validaEventoInsucessoEntregaCTe400(insucessoEntrega.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, insucessoEntrega, EVENTO_INSUCESSO_DE_ENTREGA, null, sequencialEvento);
    }
}
