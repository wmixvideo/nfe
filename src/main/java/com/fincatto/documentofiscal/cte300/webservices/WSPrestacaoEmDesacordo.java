package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte300.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte300.classes.evento.desacordo.CTeEnviaEventoPrestacaoEmDesacordo;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WSPrestacaoEmDesacordo extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Prestacao do Servico em Desacordo";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("3.00");
    private static final String EVENTO_SERVICO_EM_DESACORDO = "610110";
    private static final List<DFModelo> modelosPermitidos = Arrays.asList(DFModelo.CTE, DFModelo.CTeOS);

    WSPrestacaoEmDesacordo(final CTeConfig config) {
        super(config, modelosPermitidos);
    }

    CTeEventoRetorno prestacaoEmDesacordoAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final OMElement omElementResult = super.efetuaEvento(eventoAssinadoXml, chaveAcesso, WSPrestacaoEmDesacordo.VERSAO_LEIAUTE);
        return this.config.getPersister().read(CTeEventoRetorno.class, omElementResult.toString());
    }

    CTeEventoRetorno prestacaoEmDesacordo(final String chaveAcesso, final String motivo, final String cpfOuCnpj, final int sequencialEvento) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, motivo, cpfOuCnpj, sequencialEvento);
        return prestacaoEmDesacordoAssinada(chaveAcesso, xmlAssinado);
    }

    String getXmlAssinado(final String chave, final String observacao, final String cpfOuCnpj, final int sequencialEvento) throws Exception {
        final String xml = this.gerarDadosPrestacaoEmDesacordo(chave, observacao, cpfOuCnpj, sequencialEvento).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    private CTeEvento gerarDadosPrestacaoEmDesacordo(final String chaveAcesso, final String motivo, final String cpfOuCnpj, final int sequencialEvento) throws Exception {
        final CTeEnviaEventoPrestacaoEmDesacordo desacordo = new CTeEnviaEventoPrestacaoEmDesacordo();
        desacordo.setDescricaoEvento(WSPrestacaoEmDesacordo.DESCRICAO_EVENTO);
        desacordo.setIndicadorPrestacaoEmDesacordo(1);
        desacordo.setObservacao(motivo.trim());

        DFXMLValidador.validaEventoPrestacaoEmDesacordoCTe300(desacordo.toString());

        return super.gerarEvento(chaveAcesso, WSPrestacaoEmDesacordo.VERSAO_LEIAUTE, desacordo, WSPrestacaoEmDesacordo.EVENTO_SERVICO_EM_DESACORDO, cpfOuCnpj, sequencialEvento);
    }
}
