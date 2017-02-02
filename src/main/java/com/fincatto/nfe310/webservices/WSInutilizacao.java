package com.fincatto.nfe310.webservices;

import java.math.BigDecimal;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Element;

import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFEnviaEventoInutilizacao;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFEventoInutilizacaoDados;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFRetornoEventoInutilizacao;
import com.fincatto.nfe310.converters.ElementStringConverter;
import com.fincatto.nfe310.persister.NFPersister;

import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeInutilizacao2;
import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeInutilizacao2Soap;
import br.inf.portalfiscal.nfe.wsdl.nfeinutilizacao2.NfeInutilizacaoNF2Result;

class WSInutilizacao {

    private static final String VERSAO_SERVICO = "3.10";
    private static final String NOME_SERVICO = "INUTILIZAR";
    private final NFeConfig config;

    WSInutilizacao(final NFeConfig config) {
        this.config = config;
    }

    NFRetornoEventoInutilizacao inutilizaNotaAssinada(final String eventoAssinadoXml, final DFModelo modelo) throws Exception {
        return new NFPersister().read(NFRetornoEventoInutilizacao.class, efetuaInutilizacao(eventoAssinadoXml, modelo));
    }

    NFRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) throws Exception {
        final String inutilizacaoXML = this.geraDadosInutilizacao(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, modelo).toString();
        final String inutilizacaoXMLAssinado = new AssinaturaDigital(this.config).assinarDocumento(inutilizacaoXML);
        return new NFPersister().read(NFRetornoEventoInutilizacao.class, efetuaInutilizacao(inutilizacaoXMLAssinado, modelo));
    }

    private NFEnviaEventoInutilizacao geraDadosInutilizacao(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa, final DFModelo modelo) {
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

    private String efetuaInutilizacao(final String xml, final DFModelo modelo) throws Exception {
        final NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();
        nfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        nfeCabecMsg.setVersaoDados(WSInutilizacao.VERSAO_SERVICO);

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(ElementStringConverter.read(xml));

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = DFModelo.NFE.equals(modelo) ? autorizador.getNfeInutilizacao(this.config.getAmbiente()) : autorizador.getNfceInutilizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Inutilizacao, autorizador " + autorizador.name());
        }

        NfeInutilizacao2Soap port = new NfeInutilizacao2(new URL(endpoint)).getNfeInutilizacao2Soap12();
        NfeInutilizacaoNF2Result result = port.nfeInutilizacaoNF2(nfeDadosMsg, nfeCabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

}
