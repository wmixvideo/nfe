package com.fincatto.documentofiscal.mdfe.webservices.distribuicao;

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
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class WSDistribuicaoMDFe {

	private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeDistribuicaoDFe";
	private static final String SOAP_ACTION = WSDistribuicaoMDFe.NAMESPACE_WSDL + "/mdfeDistDFeInteresse";

	private final MDFeConfig config;
	private final DFHttpClient httpClient;

	public WSDistribuicaoMDFe(final MDFeConfig config, final DFHttpClient httpClient) {
		this.config = config;
		this.httpClient = httpClient;
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
	 * um wrapper com o nome da operacao.
	 */
	private String efetuaConsulta(final String xmlEnvio, final DFUnidadeFederativa uf) throws IOException, DFSoapFaultException {
		final String endpoint = MDFAutorizador3.RS.getMDFeDistribuicao(this.config.getAmbiente());
		if (endpoint == null) {
			throw new IllegalArgumentException("Nao foi possivel encontrar URL para DistribuicaoDFe, autorizador RS");
		}

		final String cabecalho = "<cUF>" + uf.getCodigo() + "</cUF><versaoDados>1.00</versaoDados>";
		final String envelope = DFSoapEnvelope.envelopar(WSDistribuicaoMDFe.NAMESPACE_WSDL, "mdfeCabecMsg", cabecalho, "mdfeDadosMsg", xmlEnvio);
		final String resposta = this.httpClient.postSoap(endpoint, WSDistribuicaoMDFe.SOAP_ACTION, envelope);
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
		final byte[] conteudo = Base64.getDecoder().decode(conteudoEncode);
		// le os bytes crus (sem readLine), preservando quebras de linha dentro de campos texto do XML
		try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
			return new String(gis.readAllBytes(), StandardCharsets.UTF_8);
		}
	}
}
