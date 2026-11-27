package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEventoRetorno;
import com.fincatto.documentofiscal.cte400.classes.evento.creditopresumido.CTeEnviaEventoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * Evento de Apropriação de Crédito Presumido (211110), NT 2026.004.<br>
 * Autorizado exclusivamente na SVRS, apenas para CT-e modelo 57 e com sequencial 1.
 */
class WSApropriacaoCreditoPresumido extends WSRecepcaoEvento {
    private static final String DESCRICAO_EVENTO = "Apropriacao Credito Presumido";
    private static final BigDecimal VERSAO_LEIAUTE = new BigDecimal("4.00");
    private static final String EVENTO_APROPRIACAO_CREDITO_PRESUMIDO = "211110";
    private static final int SEQUENCIAL_EVENTO = 1;
    private static final List<DFModelo> modelosPermitidos = Collections.singletonList(DFModelo.CTE);

    WSApropriacaoCreditoPresumido(final CTeConfig config, final DFHttpClient httpClient) {
        super(config, httpClient, modelosPermitidos);
    }

    CTeEventoRetorno apropriacaoCreditoPresumidoAssinada(final String chaveAcesso, final String eventoAssinadoXml) throws Exception {
        final String xmlResultado = super.efetuaEvento(eventoAssinadoXml, chaveAcesso, CTAutorizador400.SVRS);
        return this.config.getPersister().read(CTeEventoRetorno.class, xmlResultado);
    }

    CTeEventoRetorno apropriacaoCreditoPresumido(final String chaveAcesso, final CTeEnviaEventoApropriacaoCreditoPresumido apropriacao, final String cpfOuCnpjTomador) throws Exception {
        final String xmlAssinado = this.getXmlAssinado(chaveAcesso, apropriacao, cpfOuCnpjTomador);
        return this.apropriacaoCreditoPresumidoAssinada(chaveAcesso, xmlAssinado);
    }

    String getXmlAssinado(final String chaveAcesso, final CTeEnviaEventoApropriacaoCreditoPresumido apropriacao, final String cpfOuCnpjTomador) throws Exception {
        final String xml = this.gerarDadosApropriacaoCreditoPresumido(chaveAcesso, apropriacao, cpfOuCnpjTomador).toString();
        return new DFAssinaturaDigital(this.config).assinarDocumento(xml);
    }

    CTeEvento gerarDadosApropriacaoCreditoPresumido(final String chaveAcesso, final CTeEnviaEventoApropriacaoCreditoPresumido apropriacao, final String cpfOuCnpjTomador) throws Exception {
        if (cpfOuCnpjTomador == null) {
            throw new IllegalArgumentException("O autor do evento de apropriacao de credito presumido deve ser o tomador do servico (CPF ou CNPJ obrigatorio)");
        }
        apropriacao.setDescricaoEvento(DESCRICAO_EVENTO);

        DFXMLValidador.validaEventoApropriacaoCreditoPresumidoCTe400(apropriacao.toString());

        return super.gerarEvento(chaveAcesso, VERSAO_LEIAUTE, apropriacao, EVENTO_APROPRIACAO_CREDITO_PRESUMIDO, cpfOuCnpjTomador, SEQUENCIAL_EVENTO);
    }
}
