package com.fincatto.mdfe300.webservices;

import br.inf.portalfiscal.mdfe.TEnviMDFe;
import br.inf.portalfiscal.mdfe.TEvento;
import br.inf.portalfiscal.mdfe.TRetConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.TRetConsReciMDFe;
import br.inf.portalfiscal.mdfe.TRetConsSitMDFe;
import br.inf.portalfiscal.mdfe.TRetConsStatServ;
import br.inf.portalfiscal.mdfe.TRetEnviMDFe;
import br.inf.portalfiscal.mdfe.TRetEvento;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;

import com.fincatto.dfe.webservices.DFSocketFactory;
import com.fincatto.mdfe300.MDFeConfig;
import java.net.MalformedURLException;

public class MDFFacade {

    private final WSRecepcaoMDF wsRecepcaoMDF;
    private final WSRetornoRecepcaoMDF wsRetornoRecepcaoMDF;
    private final WSConsultaMDF wsConsultaMDF;
    private final WSConsultaStatusServicoMDF wsConsultaStatusServicoMDF;
    private final WSConsultaNaoEncerradosMDF wsConsultaNaoEncerradosMDF;
    private final WSRecepcaoEventoMDF wsRecepcaoEventoMDF;

    public MDFFacade(final MDFeConfig config) throws IOException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
    	HttpsURLConnection.setDefaultSSLSocketFactory(new DFSocketFactory(config).createSSLContext().getSocketFactory());

        // inicia os servicos disponíveis
        this.wsRecepcaoMDF = new WSRecepcaoMDF(config);
        this.wsRetornoRecepcaoMDF = new WSRetornoRecepcaoMDF(config);
        this.wsConsultaMDF = new WSConsultaMDF(config);
        this.wsConsultaStatusServicoMDF = new WSConsultaStatusServicoMDF(config);
        this.wsConsultaNaoEncerradosMDF = new WSConsultaNaoEncerradosMDF(config);
        this.wsRecepcaoEventoMDF = new WSRecepcaoEventoMDF(config);
    }

    /**
     * O Serviço de Recepção do MDF-e é o serviço oferecido pelo WS do Ambiente Autorizador
     * para atualização do repositório dos MDF-e emitidos por usuários autorizados a emitir CT-e ou NF-e.
     * OBS: Embora no primeiro momento ocorra apenas um MDF-e por lote, esta especificação prevê futuras alterações nessa composição
     * @param enviMDFe Estrutura XML com o MDF-e
     * @return Estrutura XML com a mensagem do resultado do envio do MDF-e.
     * @throws Exception
     */
    public TRetEnviMDFe recepcaoMDFe(final TEnviMDFe enviMDFe) throws Exception {
        return this.wsRecepcaoMDF.enviaMDFe(enviMDFe);
    }

    /**
     * Serviço destinado a devolver o resultado do processamento do MDF-e.
     * @param numeroRecibo
     * @return Estrutura XML com o resultado do processamento da mensagem de envio de MDF-e.
     * @throws Exception
     */
    public TRetConsReciMDFe retornoRecepcaoMDFe(final String numeroRecibo) throws Exception {
        return this.wsRetornoRecepcaoMDF.consultaMDFe(numeroRecibo);
    }

    /**
     * Serviço destinado ao atendimento de solicitações de consulta da situação
     * atual do MDF-e na Base de Dados do Ambiente Autorizador.
     * @param chaveMDFe
     * @return Estrutura XML contendo a mensagem do resultado da consulta de protocolo.
     * @throws java.net.MalformedURLException
     */
    public TRetConsSitMDFe consultaMDFe(final String chaveMDFe) throws MalformedURLException {
        return this.wsConsultaMDF.consultaMDFe(chaveMDFe);
    }

    /**
     * Serviço destinado à consulta do status do serviço prestado pelo Ambiente Autorizador.
     * @return  Estrutura XML contendo a mensagem do resultado da consulta do status do serviço.
     * @throws java.net.MalformedURLException
     */
    public TRetConsStatServ consultaStatusServicoMDFe() throws MalformedURLException {
        return this.wsConsultaStatusServicoMDF.consultaStatus();
    }

    /**
     * Serviço destinado ao atendimento de solicitações de consulta MDF-e não
     * encerrados na Base de Dados do Ambiente Autorizador.
     * @param cnpjEmitente
     * @return Estrutura XML contendo a mensagem do resultado da consulta não encerrados.
     * @throws java.net.MalformedURLException
     */
    public TRetConsMDFeNaoEnc consultaNaoEncerradosMDFe(final String cnpjEmitente) throws MalformedURLException {
        return this.wsConsultaNaoEncerradosMDF.consultaNaoEncerrados(cnpjEmitente);
    }

    /**
     * Serviço destinado à recepção de mensagem de Evento do MDF-e
     * @param evento
     * @return Estrutura XML contendo a mensagem do resultado do evento.
     * @throws java.lang.Exception
     */
    public TRetEvento recepcaoEventoMDFe(TEvento evento) throws Exception {
        return this.wsRecepcaoEventoMDF.recepcaoEventoMDFe(evento);
    }
}