package com.fincatto.nfe.webservices.statusservico.consulta;

import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe.NFAutorizador;
import com.fincatto.nfe.NFConfig;
import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.statusservico.consulta.TConsStatServ;
import com.fincatto.nfe.classes.statusservico.consulta.TRetConsStatServ;
import com.fincatto.nfe.transformers.NFRegistryMatcher;
import com.fincatto.nfe.webservices.WSNFBase;

public class WSNFStatusServico extends WSNFBase {
	
	private static final Logger log = Logger.getLogger(WSNFStatusServico.class);
	private static final String VERSAO_LEIAUTE = "2.00";
	
	public WSNFStatusServico(final NFConfig config) {
		super(config);
	}
	
	public TRetConsStatServ consultar(final NFUnidadeFederativa uf) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(uf).toString());
		WSNFStatusServico.log.debug(omElementConsulta);
		
		final OMElement omElementResult = this.efetuaConsulta(omElementConsulta, uf);
		WSNFStatusServico.log.debug(omElementResult.toString());
		
		return new Persister(new NFRegistryMatcher(), new Format(0)).read(TRetConsStatServ.class, omElementResult.toString());
	}
	
	private TConsStatServ gerarDadosConsulta(final NFUnidadeFederativa unidadeFederativa) {
		final TConsStatServ consStatServ = new TConsStatServ();
		consStatServ.setUf(unidadeFederativa);
		consStatServ.setAmbiente(super.getConfig().getAmbiente());
		consStatServ.setVersao(WSNFStatusServico.VERSAO_LEIAUTE);
		consStatServ.setServico("STATUS");
		return consStatServ;
	}
	
	private OMElement efetuaConsulta(final OMElement omElement, final NFUnidadeFederativa unidadeFederativa) throws AxisFault, RemoteException {
		final NfeStatusServico2Stub.NfeCabecMsg cabec = new NfeStatusServico2Stub.NfeCabecMsg();
		cabec.setCUF(unidadeFederativa.getCodigoIbge());
		cabec.setVersaoDados(WSNFStatusServico.VERSAO_LEIAUTE);
		
		final NfeStatusServico2Stub.NfeCabecMsgE cabecEnv = new NfeStatusServico2Stub.NfeCabecMsgE();
		cabecEnv.setNfeCabecMsg(cabec);
		
		final NfeStatusServico2Stub.NfeDadosMsg dados = new NfeStatusServico2Stub.NfeDadosMsg();
		dados.setExtraElement(omElement);
		
		final NfeStatusServico2Stub.NfeStatusServicoNF2Result result = new NfeStatusServico2Stub(NFAutorizador.valueOfCodigoUF(unidadeFederativa).getNfeStatusServico(super.getConfig().getAmbiente())).nfeStatusServicoNF2(dados, cabecEnv);
		return result.getExtraElement();
	}
	
}