package com.fincatto.documentofiscal.mdfe.webservices.distribuicao;

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

import org.apache.commons.lang3.StringUtils;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe.classes.distribuicao.MDFeDistribuicaoConsultaNSU;
import com.fincatto.documentofiscal.mdfe.classes.distribuicao.MDFeDistribuicaoInt;
import com.fincatto.documentofiscal.mdfe.classes.distribuicao.MDFeDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.mdfe.classes.distribuicao.MDFeDistribuicaoNSU;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;
import com.fincatto.documentofiscal.utils.DFSocketFactory;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

public class WSDistribuicaoMDFe implements Closeable {

	private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeDistribuicaoDFe";
	private static final String SOAP_ACTION = WSDistribuicaoMDFe.NAMESPACE_WSDL + "/mdfeDistDFeInteresse";

	private final MDFeConfig config;
	// Criado sob demanda (lazy), na primeira chamada de rede - nao no construtor.
	// WSDistribuicaoMDFe e classe publica com construtor publico de 1 argumento; manter a
	// criacao preguicosa evita que problemas de certificado/SSL passem a aparecer na construcao
	// (quebra de compatibilidade), quando antes so apareciam ao efetivamente chamar a SEFAZ.
	private DFHttpClient httpClient;

	public WSDistribuicaoMDFe(final MDFeConfig config) {
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
	 * criado (isto e, se ja foi feita alguma chamada de rede). Quem a constroi diretamente e
	 * responsavel por chamar {@link #close()} quando nao for mais usa-la.
	 */
	@Override
	public synchronized void close() throws IOException {
		if (this.httpClient != null) {
			this.httpClient.close();
		}
	}

	public MDFeDistribuicaoIntRetorno consultar(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String nsu, final String ultNsu) throws Exception {
		String xmlEnvio = this.gerarMDFeDistribuicaoInt(cpfOuCnpj, nsu, ultNsu).toString();

		DFXMLValidador.validaDistribuicaoMDFe(xmlEnvio);

		final String xmlResultado = this.efetuaConsulta(xmlEnvio, uf);
		return this.config.getPersister().read(MDFeDistribuicaoIntRetorno.class, xmlResultado);
	}

	/**
	 * Envia a consulta de distribuicao para a SEFAZ via {@link DFHttpClient} e devolve o XML de
	 * negocio ja desempacotado do envelope SOAP 1.2 de resposta. Diferente de
	 * {@code WSDistribuicaoNFe}/{@code WSDistribuicaoCTe}, esta operacao NAO aninha o corpo em
	 * um wrapper com o nome da operacao - confirmado no stub gerado
	 * ({@code MDFeDistribuicaoDFeStub}): o pedido poe {@code mdfeDadosMsg} como filho direto do
	 * {@code soap:Body}, e a resposta tem apenas 1 nivel de wrapper (o primeiro filho do Body ja
	 * e o elemento de resultado). Usa o padrao simples de 5 argumentos, igual ao resto do
	 * modulo, sem caso especial.
	 */
	private String efetuaConsulta(final String xmlEnvio, final DFUnidadeFederativa uf)
			throws IOException, DFSoapFaultException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
		final String endpoint = MDFAutorizador3.RS.getMDFeDistribuicao(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para DistribuicaoDFe, autorizador RS");
		}

		final String cabecalho = "<cUF>" + uf.getCodigo() + "</cUF><versaoDados>1.00</versaoDados>";
		final String envelope = DFSoapEnvelope.envelopar(WSDistribuicaoMDFe.NAMESPACE_WSDL, "mdfeCabecMsg", cabecalho, "mdfeDadosMsg", xmlEnvio);
		final String resposta = this.getHttpClient().postSoap(endpoint, WSDistribuicaoMDFe.SOAP_ACTION, envelope);
		return DFSoapEnvelope.desempacotar(resposta);
	}

	private MDFeDistribuicaoInt gerarMDFeDistribuicaoInt(final String cpfOuCnpj, final String nsu,
			final String ultNsu) {
		final MDFeDistribuicaoInt distDFeInt = new MDFeDistribuicaoInt();
		distDFeInt.setVersao("1.00");
		distDFeInt.setAmbiente(this.config.getAmbiente());

		if (cpfOuCnpj.length() == 11) {
			distDFeInt.setCpf(cpfOuCnpj);
		} else {
			distDFeInt.setCnpj(cpfOuCnpj);
		}

		if (StringUtils.isNotBlank(ultNsu)) {
			distDFeInt.setDistribuicao(new MDFeDistribuicaoNSU().setUltimoNSU(ultNsu));
		} else {
			distDFeInt.setConsulta(new MDFeDistribuicaoConsultaNSU().setNsu(nsu));
		}
		return distDFeInt;
	}

	public static String decodeGZipToXml(final String conteudoEncode) throws Exception {
		if (conteudoEncode == null || conteudoEncode.length() == 0) {
			return "";
		}
		final byte[] conteudo = Base64.getDecoder().decode(conteudoEncode);// java 8
		// final byte[] conteudo =
		// DatatypeConverter.parseBase64Binary(conteudoEncode);//java 7
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
