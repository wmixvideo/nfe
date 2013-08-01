package com.fincatto.nfe.webservices.lote.consulta;

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
import com.fincatto.nfe.classes.lote.consulta.TConsReciNFe;
import com.fincatto.nfe.classes.lote.consulta.recibo.TRetConsReciNFe;
import com.fincatto.nfe.transformers.NFRegistryMatcher;
import com.fincatto.nfe.webservices.WSNFBase;
import com.fincatto.nfe.webservices.lote.consulta.NfeRetRecepcao2Stub.NfeRetRecepcao2Result;

public class WSNFConsultaLote extends WSNFBase {
	
	private static final Logger log = Logger.getLogger(WSNFConsultaLote.class);
	private static final String VERSAO_LEIAUTE = "2.00";
	
	public WSNFConsultaLote(final NFConfig config) {
		super(config);
	}
	
	public TRetConsReciNFe consultar(final String numeroRecibo, final NFUnidadeFederativa uf) throws Exception {
		final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(numeroRecibo).toString());
		WSNFConsultaLote.log.debug(omElementConsulta);
		
		final OMElement omElementResult = this.efetuaConsulta(omElementConsulta, uf);
		WSNFConsultaLote.log.debug(omElementResult.toString());
		
		return new Persister(new NFRegistryMatcher(), new Format(0)).read(TRetConsReciNFe.class, omElementResult.toString());
	}
	
	private TConsReciNFe gerarDadosConsulta(final String numeroRecibo) {
		final TConsReciNFe consulta = new TConsReciNFe();
		consulta.setRecibo(numeroRecibo);
		consulta.setAmbiente(super.getConfig().getAmbiente());
		consulta.setVersao(WSNFConsultaLote.VERSAO_LEIAUTE);
		return consulta;
	}
	
	private OMElement efetuaConsulta(final OMElement omElement, final NFUnidadeFederativa uf) throws AxisFault, RemoteException {
		final NfeRetRecepcao2Stub.NfeCabecMsg cabec = new NfeRetRecepcao2Stub.NfeCabecMsg();
		cabec.setCUF(uf.getCodigoIbge());
		cabec.setVersaoDados(WSNFConsultaLote.VERSAO_LEIAUTE);
		
		final NfeRetRecepcao2Stub.NfeCabecMsgE cabecE = new NfeRetRecepcao2Stub.NfeCabecMsgE();
		cabecE.setNfeCabecMsg(cabec);
		
		final NfeRetRecepcao2Stub.NfeDadosMsg dados = new NfeRetRecepcao2Stub.NfeDadosMsg();
		dados.setExtraElement(omElement);
		
		final NfeRetRecepcao2Result result = new NfeRetRecepcao2Stub(NFAutorizador.valueOfCodigoUF(uf).getNfeRetRecepcao(super.getConfig().getAmbiente())).nfeRetRecepcao2(dados, cabecE);
		return result.getExtraElement();
	}
}