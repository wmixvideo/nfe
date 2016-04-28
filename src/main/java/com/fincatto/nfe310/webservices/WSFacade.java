package com.fincatto.nfe310.webservices;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.nfe310.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.nfe310.classes.evento.inutilizacao.NFRetornoEventoInutilizacao;
import com.fincatto.nfe310.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvioRetorno;
import com.fincatto.nfe310.classes.lote.envio.NFLoteIndicadorProcessamento;
import com.fincatto.nfe310.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.nfe310.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.nfe310.validadores.xsd.XMLValidador;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class WSFacade {

    private final WSLoteEnvio wsLoteEnvio;
    private final WSLoteConsulta wsLoteConsulta;
    private final WSStatusConsulta wsStatusConsulta;
    private final WSNotaConsulta wsNotaConsulta;
    private final WSCartaCorrecao wsCartaCorrecao;
    private final WSCancelamento wsCancelamento;
    private final WSConsultaCadastro wsConsultaCadastro;
    private final WSInutilizacao wsInutilizacao;

    public WSFacade(final NFeConfig config) throws IOException {
        // Alterado para setar diretamente no protocolo
//      System.setProperty("jdk.tls.client.protocols", "SSLv3,TLSv1");
//      //System.setProperty("jdk.tls.client.protocols", "TLSv1,TLSv1.1,TLSv1.2");
//      //System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
//      System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
//      System.setProperty("javax.net.ssl.trustStoreType", "JKS");
//      System.setProperty("javax.net.ssl.trustStore", config.getCadeiaCertificados().getAbsolutePath());
//      System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
//      System.setProperty("javax.net.ssl.keyStore", config.getCertificado().getAbsolutePath());
//      System.setProperty("javax.net.ssl.keyStorePassword", config.getCertificadoSenha());

        carregarProtocolo(config);

        this.wsLoteEnvio = new WSLoteEnvio(config);
        this.wsLoteConsulta = new WSLoteConsulta(config);
        this.wsStatusConsulta = new WSStatusConsulta(config);
        this.wsNotaConsulta = new WSNotaConsulta(config);
        this.wsCartaCorrecao = new WSCartaCorrecao(config);
        this.wsCancelamento = new WSCancelamento(config);
        this.wsConsultaCadastro = new WSConsultaCadastro(config);
        this.wsInutilizacao = new WSInutilizacao(config);
    }

    /**
     * Carrega as configurações do certificado e seta o protocolo.
     * Assim não é nessário setar no System.setProperty
     *
     * @param config Configuração do sefaz
     * @throws IOException Se houver problemas com o certificado
     */
    private void carregarProtocolo(final NFeConfig config) throws IOException {
        InputStream entrada;
        // Verifico se existe o certificado em bytearray ou no caminho especificado
        if (config.getCertificadoByteArray() == null) {
            entrada = new FileInputStream(config.getCertificado());
        } else {
            entrada = new ByteArrayInputStream(config.getCertificadoByteArray());
        }

        KeyStore ks;
        try {
            ks = KeyStore.getInstance("pkcs12");
            ks.load(entrada, config.getCertificadoSenha().toCharArray());

            String alias = "";

            Enumeration<String> aliasesEnum = ks.aliases();
            while (aliasesEnum.hasMoreElements()) {
                alias = aliasesEnum.nextElement();
                if (ks.isKeyEntry(alias)) {
                    break;
                }
            }

            X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);
            PrivateKey privateKey = (PrivateKey) ks.getKey(alias, config.getCertificadoSenha().toCharArray());
            SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey);
            socketFactoryDinamico.setFileCacerts(config.getCadeiaCertificados().getAbsolutePath());

            Protocol protocol = new Protocol("https", socketFactoryDinamico, 443);
            Protocol.registerProtocol("https", protocol);
        } catch (Exception e) {
            throw new IOException("Senha do Certificado Digital esta incorreta ou Certificado inválido.");
        }
    }

    public NFLoteEnvioRetorno enviaLote(final NFLoteEnvio lote) throws Exception {
        XMLValidador.validaLote(lote.toString());
        if (lote.getIndicadorProcessamento().equals(NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO)) {
            throw new IllegalStateException("Nao existe ainda a forma de envio sincrona, faca o envio de forma assincrona");
        }
        return this.wsLoteEnvio.enviaLote(lote);
    }

    public NFLoteConsultaRetorno consultaLote(final String numeroRecibo) throws Exception {
        return this.wsLoteConsulta.consultaLote(numeroRecibo);
    }

    public NFStatusServicoConsultaRetorno consultaStatus(final NFUnidadeFederativa uf) throws Exception {
        return this.wsStatusConsulta.consultaStatus(uf);
    }

    public NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        return this.wsNotaConsulta.consultaNota(chaveDeAcesso);
    }

    public NFEnviaEventoRetorno corrigeNota(final String chaveDeAcesso, final String textoCorrecao, final int numeroSequencialEvento) throws Exception {
        return this.wsCartaCorrecao.corrigeNota(chaveDeAcesso, textoCorrecao, numeroSequencialEvento);
    }

    public NFEnviaEventoRetorno cancelaNota(final String chaveAcesso, final String numeroProtocolo, final String motivo) throws Exception {
        return this.wsCancelamento.cancelaNota(chaveAcesso, numeroProtocolo, motivo);
    }

    public NFRetornoEventoInutilizacao inutilizaNota(final int anoInutilizacaoNumeracao, final String cnpjEmitente, final String serie, final String numeroInicial, final String numeroFinal, final String justificativa) throws Exception {
        return this.wsInutilizacao.inutilizaNota(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa);
    }

    public NFRetornoConsultaCadastro consultaCadastro(final String cnpj, final NFUnidadeFederativa uf) throws Exception {
        return this.wsConsultaCadastro.consultaCadastro(cnpj, uf);
    }
}