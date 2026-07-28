package com.fincatto.documentofiscal.nfe.webservices.distribuicao;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe.classes.distribuicao.*;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSocketFactory;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
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

public class WSDistribuicaoNFe implements Closeable {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe";
    private static final String SOAP_ACTION = WSDistribuicaoNFe.NAMESPACE_WSDL + "/nfeDistDFeInteresse";
    // o corpo SOAP desta operacao aninha o XML de negocio dois niveis abaixo do soap:Body:
    // nfeDistDFeInteresseResponse > NFeDistDFeInteresseResult > XML de negocio.
    private static final int NIVEIS_DE_WRAPPER_NA_RESPOSTA = 2;

    private final NFeConfig config;
    // Criado sob demanda (lazy), na primeira chamada de rede - nao no construtor. WSDistribuicaoNFe
    // e classe publica com construtor publico de 1 argumento; manter a criacao preguicosa evita
    // que problemas de certificado/SSL passem a aparecer na construcao (quebra de compatibilidade),
    // quando antes so apareciam ao efetivamente chamar a SEFAZ.
    private DFHttpClient httpClient;

    public WSDistribuicaoNFe(final NFeConfig config) {
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
     * criado (isto e, se ja foi feita alguma chamada de rede). {@code WSDistribuicaoNFe} nao e
     * gerenciada pelo {@link com.fincatto.documentofiscal.nfe400.webservices.WSFacade} - quem a
     * constroi diretamente e responsavel por chamar {@link #close()} quando nao for mais usa-la.
     */
    @Override
    public synchronized void close() throws IOException {
        if (this.httpClient != null) {
            this.httpClient.close();
        }
    }

    /**
     * Metodo para consultar os dados das notas fiscais por chave de acesso ou NSU e retorna o objeto de retorno de distribuicao<br>
     */
    public NFDistribuicaoIntRetorno consultar(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu) throws Exception {
        return consultar(cpfOuCnpj, uf, chaveAcesso, nsu, null);
    }

    /**
     * Metodo para consultar os dados das notas fiscais por chave de acesso ou NSU e retorna o objeto de retorno de distribuicao<br>
     */
    public NFDistribuicaoIntRetorno consultar(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu, final String ultNsu) throws Exception {
        final String xmlEnvio = this.gerarNFDistribuicaoInt(cpfOuCnpj, uf, chaveAcesso, nsu, ultNsu).toString();

        // valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaConsultaDfe(xmlEnvio);

        final String xmlResultado = this.efetuaConsulta(xmlEnvio);
        return this.config.getPersister().read(NFDistribuicaoIntRetorno.class, xmlResultado);
    }

    /**
     * Envia a consulta de distribuicao para a SEFAZ via {@link DFHttpClient} e devolve o XML de
     * negocio ja desempacotado do envelope SOAP 1.2 de resposta. Assim como o Mato Grosso na
     * consulta de cadastro, a operacao nfeDistDFeInteresse tambem tem um nivel extra de
     * aninhamento no pedido - o wrapper e {@code nfeDistDFeInteresse} (nao {@code nfeDadosMsg}
     * direto), com {@code nfeDadosMsg} dentro dele - por isso o {@code <nfeDadosMsg>} extra e
     * montado manualmente antes de {@link DFSoapEnvelope#envelopar}.
     */
    private String efetuaConsulta(final String xmlEnvio)
            throws IOException, DFSoapFaultException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        final String endpoint = NFAutorizador400.AN.getNFeDistribuicaoDFe(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para DistribuicaoDFe, autorizador " + NFAutorizador400.AN.name());
        }

        final String envelope = WSDistribuicaoNFe.construirEnvelope(xmlEnvio);
        final String resposta = this.getHttpClient().postSoap(endpoint, WSDistribuicaoNFe.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta, WSDistribuicaoNFe.NIVEIS_DE_WRAPPER_NA_RESPOSTA);
    }

    /**
     * Monta o envelope SOAP 1.2 do pedido, isolado do envio em si para poder ser testado sem
     * depender de rede (ver {@code WSDistribuicaoNFeTest}).
     */
    static String construirEnvelope(final String xmlEnvio) {
        return DFSoapEnvelope.envelopar(WSDistribuicaoNFe.NAMESPACE_WSDL, "nfeDistDFeInteresse", "<nfeDadosMsg>" + xmlEnvio + "</nfeDadosMsg>");
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

    private NFDistribuicaoInt gerarNFDistribuicaoInt(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String chaveAcesso, final String nsu, final String ultNsu) {
        final NFDistribuicaoInt distDFeInt = new NFDistribuicaoInt();
        distDFeInt.setVersao("1.01");
        distDFeInt.setAmbiente(this.config.getAmbiente());
        distDFeInt.setUnidadeFederativaAutor(uf);

        if (cpfOuCnpj.length() == 11) {
            distDFeInt.setCpf(cpfOuCnpj);
        } else {
            distDFeInt.setCnpj(cpfOuCnpj);
        }

        if (StringUtils.isNotBlank(chaveAcesso)) {
            distDFeInt.setConsultaChaveAcesso(new NFDistribuicaoConsultaChaveAcesso().setChaveAcesso(chaveAcesso));
        } else if (StringUtils.isNotBlank(ultNsu)) {
            distDFeInt.setDistribuicaoNSU(new NFDistribuicaoNSU().setUltimoNSU(ultNsu));
        } else {
            distDFeInt.setConsultaNSU(new NFDistribuicaoConsultaNSU().setNsu(nsu));
        }
        return distDFeInt;
    }
}
