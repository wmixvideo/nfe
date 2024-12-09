package com.fincatto.documentofiscal.mdfe.webservices.distribuicao;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang3.StringUtils;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe.classes.distribuicao.MDFeDistribuicaoConsultaNSU;
import com.fincatto.documentofiscal.mdfe.classes.distribuicao.MDFeDistribuicaoInt;
import com.fincatto.documentofiscal.mdfe.classes.distribuicao.MDFeDistribuicaoIntRetorno;
import com.fincatto.documentofiscal.mdfe.classes.distribuicao.MDFeDistribuicaoNSU;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

public class WSDistribuicaoMDFe {

	private final MDFeConfig config;

	public WSDistribuicaoMDFe(final MDFeConfig config) {
		this.config = config;
	}

	public MDFeDistribuicaoIntRetorno consultar(final String cpfOuCnpj, final DFUnidadeFederativa uf, final String nsu, final String ultNsu) throws Exception {
		try {
			String xmlEnvio = this.gerarMDFeDistribuicaoInt(cpfOuCnpj, nsu, ultNsu).toString();

			DFXMLValidador.validaDistribuicaoMDFe(xmlEnvio);

			final OMElement ome = AXIOMUtil.stringToOM(xmlEnvio);

			final MDFeDistribuicaoDFeStub.MdfeDadosMsg mdfeDadosMsg = new MDFeDistribuicaoDFeStub.MdfeDadosMsg();
			mdfeDadosMsg.setExtraElement(ome);

			final MDFeDistribuicaoDFeStub.MdfeCabecMsg mdfeCabecMsg = new MDFeDistribuicaoDFeStub.MdfeCabecMsg();
			mdfeCabecMsg.setCUF(uf.getCodigo());
			mdfeCabecMsg.setVersaoDados("1.00");

			final MDFeDistribuicaoDFeStub.MdfeCabecMsgE mdfeCabecMsgE = new MDFeDistribuicaoDFeStub.MdfeCabecMsgE();
			mdfeCabecMsgE.setMdfeCabecMsg(mdfeCabecMsg);
			
			final MDFeDistribuicaoDFeStub stub = new MDFeDistribuicaoDFeStub(MDFAutorizador3.RS.getMDFeDistribuicao(config.getAmbiente()));
			final MDFeDistribuicaoDFeStub.MdfeDistDFeInteresseResult result = stub.mdfeDistDFeInteresse(mdfeDadosMsg, mdfeCabecMsgE);

			return this.config.getPersister().read(MDFeDistribuicaoIntRetorno.class, result.getExtraElement().toString());
		} catch (RemoteException | XMLStreamException e) {
			throw new Exception(e.getMessage());
		}
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
