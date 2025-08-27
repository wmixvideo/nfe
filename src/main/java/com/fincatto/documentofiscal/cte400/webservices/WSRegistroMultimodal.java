package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.multimodal.CTeEnviaEventoRegistroMultimodal;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WSRegistroMultimodal extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Registro Multimodal";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
    private static final String EVENTO_REGISTRO_MULTIMODAL = "110160";
    private static final List<DFModelo> modelosPermitidos = Arrays.asList(DFModelo.CTE);

    WSRegistroMultimodal(final CTeConfig config) {
        super(config, modelosPermitidos);
    }

    CTeEventoRetorno registroMultimodalAssinado(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = super.efetuaEvento(eventoAssinadoXml, chaveAcesso, VERSAO_LEIAUTE);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno registroMultimodal(final String chaveAcesso, final String informacoesAdicionais, final String numeroDocumento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, informacoesAdicionais, numeroDocumento);
        return registroMultimodalAssinado(chaveAcesso, xmlAssinado);
    }

    String getXmlAssinado(final String chave, final String informacoesAdicionais, final String numeroDocumento) throws Exception {
        final String xml = this.gerarDadosRegistroMultimodal(chave, informacoesAdicionais, numeroDocumento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private CTeEvento gerarDadosRegistroMultimodal(final String chaveAcesso, final String informacoesAdicionais, final String numeroDocumento) throws Exception {
        final CTeEnviaEventoRegistroMultimodal registroMultimodal = new CTeEnviaEventoRegistroMultimodal();
        registroMultimodal.setDescricaoEvento(DESCRICAO_EVENTO);
        registroMultimodal.setInformacoesAdicionais(informacoesAdicionais.trim());
        registroMultimodal.setNumero(numeroDocumento.trim());

        DFXMLValidador.validaEventoRegistroMultimodalCTe400(registroMultimodal.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, registroMultimodal, EVENTO_REGISTRO_MULTIMODAL, null, 1);
    }
}
