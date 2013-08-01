package com.fincatto.nfe.webservices.nota.consulta;

import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe.NFAutorizador;
import com.fincatto.nfe.NFChaveInterpretador;
import com.fincatto.nfe.NFConfig;
import com.fincatto.nfe.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.nfe.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.nfe.transformers.NFRegistryMatcher;
import com.fincatto.nfe.webservices.WSNFBase;

public class WSNFConsultaNota extends WSNFBase {
	
	private static final Logger log = Logger.getLogger(WSNFConsultaNota.class);
	private static final String VERSAO_LEIAUTE = "2.01";
	
	public WSNFConsultaNota(final NFConfig config) {
		super(config);
	}
	
	public NFNotaConsultaRetorno consultar(final String chaveAcesso) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveAcesso).toString());
		WSNFConsultaNota.log.debug(omElementConsulta);
		
		final OMElement omElementResult = this.efetuaConsulta(omElementConsulta, chaveAcesso);
		WSNFConsultaNota.log.debug(omElementResult.toString());
		
		return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFNotaConsultaRetorno.class, omElementResult.toString());
	}
	
	private NFNotaConsulta gerarDadosConsulta(final String chaveAcesso) {
		final NFNotaConsulta consulta = new NFNotaConsulta();
		consulta.setChave(chaveAcesso);
		consulta.setAmbiente(super.getConfig().getAmbiente());
		consulta.setVersao(WSNFConsultaNota.VERSAO_LEIAUTE);
		consulta.setServico("CONSULTAR");
		return consulta;
	}
	
	private OMElement efetuaConsulta(final OMElement omElement, final String chaveAcesso) throws AxisFault, RemoteException {
		final NFChaveInterpretador chaveInterpretador = new NFChaveInterpretador(chaveAcesso);
		
		final NfeConsulta2Stub.NfeCabecMsg cabec = new NfeConsulta2Stub.NfeCabecMsg();
		cabec.setCUF(chaveInterpretador.getUnidadeFederativa().getCodigoIbge());
		cabec.setVersaoDados(WSNFConsultaNota.VERSAO_LEIAUTE);
		
		final NfeConsulta2Stub.NfeCabecMsgE cabecE = new NfeConsulta2Stub.NfeCabecMsgE();
		cabecE.setNfeCabecMsg(cabec);
		
		final NfeConsulta2Stub.NfeDadosMsg dados = new NfeConsulta2Stub.NfeDadosMsg();
		dados.setExtraElement(omElement);
		
		final NfeConsulta2Stub.NfeConsultaNF2Result result = new NfeConsulta2Stub(NFAutorizador.valueOfChaveAcesso(chaveAcesso).getNfeConsultaProtocolo(this.getConfig().getAmbiente())).nfeConsultaNF2(dados, cabecE);
		return result.getExtraElement();
	}
}
