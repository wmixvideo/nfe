package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeInutilizacao2;
import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeInutilizacao2Soap;
import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeInutilizacaoNF2Result;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFEnviaEventoInutilizacao;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFEventoInutilizacaoDados;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFRetornoEventoInutilizacao;
import com.fincatto.nfe310.converters.ElementNSImplStringConverter;
import com.fincatto.nfe310.parsers.StringElementParser;
import com.fincatto.nfe310.persister.NFPersister;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import java.net.URL;

class WSInutilizacao {

    private static final String VERSAO_SERVICO = "3.10";
    private static final String NOME_SERVICO = "INUTILIZAR";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSInutilizacao.class);
    private final NFeConfig config;

    WSInutilizacao(final NFeConfig config) {
        this.config = config;
    }

    NFRetornoEventoInutilizacao inutilizaNotaAssinada(final String eventoAssinadoXml, final NFModelo modelo) throws Exception {
        return new NFPersister().read(NFRetornoEventoInutilizacao.class, eventoAssinadoXml);
    }

    NFRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final NFModelo modelo) throws Exception {
        final String inutilizacaoXML = this.geraDadosInutilizacao(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, modelo).toString();
        final String inutilizacaoXMLAssinado = new AssinaturaDigital(this.config).assinarDocumento(inutilizacaoXML);
        return new NFPersister().read(NFRetornoEventoInutilizacao.class, efetuaInutilizacao(inutilizacaoXMLAssinado, modelo));
    }

    private NFEnviaEventoInutilizacao geraDadosInutilizacao(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final NFModelo modelo) {
        final NFEnviaEventoInutilizacao inutilizacao = new NFEnviaEventoInutilizacao();
        final NFEventoInutilizacaoDados dados = new NFEventoInutilizacaoDados();
        dados.setAmbiente(this.config.getAmbiente());
        dados.setAno(anoInutilizacaoNumeracao);
        dados.setCnpj(cnpjEmitente);
        dados.setJustificativa(justificativa);
        dados.setModeloDocumentoFiscal(modelo.getCodigo());
        dados.setNomeServico(WSInutilizacao.NOME_SERVICO);
        dados.setNumeroNFInicial(numeroInicial);
        dados.setNumeroNFFinal(numeroFinal);
        dados.setSerie(serie);
        dados.setUf(this.config.getCUF());
        final String numeroInicialTamanhoMaximo = StringUtils.leftPad(numeroInicial, 9, "0");
        final String numeroFinalTamanhoMaximo = StringUtils.leftPad(numeroFinal, 9, "0");
        final String serieTamanhoMaximo = StringUtils.leftPad(serie, 3, "0");
        dados.setIdentificador("ID" + this.config.getCUF().getCodigoIbge() + String.valueOf(anoInutilizacaoNumeracao) + cnpjEmitente + modelo.getCodigo() + serieTamanhoMaximo + numeroInicialTamanhoMaximo + numeroFinalTamanhoMaximo);

        inutilizacao.setVersao(new BigDecimal(WSInutilizacao.VERSAO_SERVICO));
        inutilizacao.setDados(dados);
        return inutilizacao;
    }

    private String efetuaInutilizacao(final String xml, final NFModelo modelo) throws Exception {
        final NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();
        nfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        nfeCabecMsg.setVersaoDados(WSInutilizacao.VERSAO_SERVICO);

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(StringElementParser.read(xml));

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = NFModelo.NFE.equals(modelo) ? autorizador.getNfeInutilizacao(this.config.getAmbiente()) : autorizador.getNfceInutilizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Inutilizacao, autorizador " + autorizador.name());
        }

        NfeInutilizacao2Soap port = new NfeInutilizacao2(new URL(endpoint)).getNfeInutilizacao2Soap12();
        NfeInutilizacaoNF2Result result = port.nfeInutilizacaoNF2(nfeDadosMsg, nfeCabecMsg);

        return ElementNSImplStringConverter.read((ElementNSImpl) result.getContent().get(0));
    }

}
