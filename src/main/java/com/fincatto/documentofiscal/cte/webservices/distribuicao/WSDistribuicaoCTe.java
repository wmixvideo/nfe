package com.fincatto.documentofiscal.cte.webservices.distribuicao;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoConsultaNSU;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoInt;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.cte.classes.distribuicao.CTDistribuicaoNSU;
import com.fincatto.documentofiscal.cte200.classes.CTAutorizador;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.fincatto.documentofiscal.utils.DFSocketFactory;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

/**
 * Cliente do webservice de Distribuicao de DF-e do CT-e (consulta de documentos por NSU/interesse).
 * Servico compartilhado por CT-e 3.00 e 4.00 (usado tanto pelo {@code WSFacade} do {@code cte300}
 * quanto do {@code cte400}), por isso vive no pacote legado {@code com.fincatto.documentofiscal.cte}
 * em vez de dentro de um dos dois modulos versionados.
 */
public class WSDistribuicaoCTe implements Closeable {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe";
    private static final String SOAP_ACTION = WSDistribuicaoCTe.NAMESPACE_WSDL + "/cteDistDFeInteresse";
    // o corpo SOAP desta operacao aninha o XML de negocio dois niveis abaixo do soap:Body:
    // cteDistDFeInteresseResponse > CteDistDFeInteresseResult > XML de negocio (mesmo padrao
    // de com.fincatto.documentofiscal.nfe.webservices.distribuicao.WSDistribuicaoNFe, ja
    // migrada na leva do nfe400 - ver o Javadoc la).
    private static final int NIVEIS_DE_WRAPPER_NA_RESPOSTA = 2;

    private final CTeConfig config;
    // Criado sob demanda (lazy), na primeira chamada de rede - nao no construtor.
    // WSDistribuicaoCTe e classe publica com construtor publico de 1 argumento, usada tanto
    // pelo WSFacade do cte400 quanto pelo do cte300; manter a criacao preguicosa evita que
    // problemas de certificado/SSL passem a aparecer na construcao (quebra de compatibilidade),
    // quando antes so apareciam ao efetivamente chamar a SEFAZ.
    private DFHttpClient httpClient;

    public WSDistribuicaoCTe(final CTeConfig config) {
        this.config = config;
    }

    private synchronized DFHttpClient getHttpClient() throws KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        if (this.httpClient == null) {
            final DFSocketFactory socketFactory = new DFSocketFactory(this.config);
            this.httpClient = new DFHttpClient(socketFactory.getSslContext(), this.config);
        }
        return this.httpClient;
    }

    /**
     * Libera o pool de conexoes do {@link DFHttpClient} desta instancia, se algum tiver sido
     * criado (isto e, se ja foi feita alguma chamada de rede). Nao e gerenciada por um unico
     * {@code WSFacade} (usada por cte300 e cte400) - quem a constroi diretamente e responsavel
     * por chamar {@link #close()} quando nao for mais usa-la.
     */
    @Override
    public synchronized void close() throws IOException {
        if (this.httpClient != null) {
            this.httpClient.close();
        }
    }

    /**
     * Metodo para consultar os conhecimentos de transporte e retorna uma String<br>
     * E importante salvar esta String para nao perder nenhuma informacao<br>
     * A receita nao disponibiliza o conhecimento varias vezes para consultar, retorna rejeicao: Consumo indevido
     *
     * @deprecated ficou para tras na migracao Axis2 -&gt; HttpClient5 (ainda chamava o stub Axis2
     * real via {@code Protocol.registerProtocol}, mutando registro estatico global do
     * Commons-HttpClient 3 - o mesmo efeito colateral que foi removido de todos os outros
     * facades). Migrado aqui para HttpClient5 mantendo a assinatura publica; use
     * {@link #consultar(String, DFUnidadeFederativa, String, String)} quando possivel.
     */
    @Deprecated
    public static String consultar(final CTDistribuicaoInt distDFeInt, final NFeConfig config)
            throws IOException, DFSoapFaultException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        final String endpoint = CTAutorizador.AN.getDistribuicaoDFe(config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para DistribuicaoDFe, autorizador " + CTAutorizador.AN.name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSDistribuicaoCTe.NAMESPACE_WSDL, "cteDistDFeInteresse", "<cteDadosMsg>" + distDFeInt + "</cteDadosMsg>");
        try (DFHttpClient httpClient = new DFHttpClient(new DFSocketFactory(config).getSslContext(), config)) {
            final String resposta = httpClient.postSoap(endpoint, WSDistribuicaoCTe.SOAP_ACTION, envelope);
            return DFSoapEnvelope.desempacotar(resposta, WSDistribuicaoCTe.NIVEIS_DE_WRAPPER_NA_RESPOSTA);
        }
    }

    public CTDistribuicaoIntRetorno consultar(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String nsu, final String ultNsu) throws Exception {
        final String xmlEnvio = this.gerarCTeDistribuicaoInt(cpfOuCnpj, uf, nsu, ultNsu).toString();

        DFXMLValidador.validaDistribuicaoCTe(xmlEnvio);

        final String xmlResultado = this.efetuaConsulta(xmlEnvio);
        return this.config.getPersister().read(CTDistribuicaoIntRetorno.class, xmlResultado);
    }

    /**
     * Envia a consulta de distribuicao para a SEFAZ via {@link DFHttpClient} e devolve o XML de
     * negocio ja desempacotado do envelope SOAP 1.2 de resposta - mesmo padrao aninhado de
     * {@code WSDistribuicaoNFe#efetuaConsulta}: o wrapper e {@code cteDistDFeInteresse} (nao
     * {@code cteDadosMsg} direto), com {@code cteDadosMsg} dentro dele.
     */
    private String efetuaConsulta(final String xmlEnvio)
            throws IOException, DFSoapFaultException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        final String endpoint = CTAutorizador.AN.getDistribuicaoDFe(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para DistribuicaoDFe, autorizador " + CTAutorizador.AN.name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSDistribuicaoCTe.NAMESPACE_WSDL, "cteDistDFeInteresse", "<cteDadosMsg>" + xmlEnvio + "</cteDadosMsg>");
        final String resposta = this.getHttpClient().postSoap(endpoint, WSDistribuicaoCTe.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta, WSDistribuicaoCTe.NIVEIS_DE_WRAPPER_NA_RESPOSTA);
    }

    private CTDistribuicaoInt gerarCTeDistribuicaoInt(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String nsu, final String ultNsu) {
        final CTDistribuicaoInt distDFeInt = new CTDistribuicaoInt();
        distDFeInt.setVersao("1.00");
        distDFeInt.setAmbiente(this.config.getAmbiente());
        distDFeInt.setUnidadeFederativaAutor(uf);

        if (cpfOuCnpj.length() == 11) {
            distDFeInt.setCpf(cpfOuCnpj);
        } else {
            distDFeInt.setCnpj(cpfOuCnpj);
        }

        if (StringUtils.isNotBlank(ultNsu)) {
            distDFeInt.setDistribuicao(new CTDistribuicaoNSU().setUltimoNSU(ultNsu));
        } else {
            distDFeInt.setConsulta(new CTDistribuicaoConsultaNSU().setNsu(nsu));
        }
        return distDFeInt;
    }

    public static String decodeGZipToXml(final String conteudoEncode) throws Exception {
        if (conteudoEncode == null || conteudoEncode.length() == 0) {
            return "";
        }
        final byte[] conteudo = Base64.getDecoder().decode(conteudoEncode);//java 8
        //final byte[] conteudo = DatatypeConverter.parseBase64Binary(conteudoEncode);//java 7
        try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8))) {
                StringBuilder outStr = new StringBuilder();
                String line;
                while ((line = bf.readLine()) != null) {
                    outStr.append(line);
                }
                return outStr.toString();
            }
        }
    }
}
