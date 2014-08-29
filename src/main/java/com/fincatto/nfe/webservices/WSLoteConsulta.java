package com.fincatto.nfe.webservices;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import br.inf.portalfiscal.www.nfe.wsdl.nferetrecepcao2.NfeRetRecepcao2Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nferetrecepcao2.NfeRetRecepcao2Stub.NfeRetRecepcao2Result;

import com.fincatto.nfe.NFEConfig;
import com.fincatto.nfe.classes.NFAutorizador;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.classes.lote.consulta.NFLoteConsulta;
import com.fincatto.nfe.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe.transformers.NFRegistryMatcher;

class WSLoteConsulta {

    final private static Logger log = Logger.getLogger(WSLoteConsulta.class);
    private final NFEConfig config;

    public WSLoteConsulta(final NFEConfig config) {
        this.config = config;
    }

    public NFLoteConsultaRetorno consultaLote(final String numeroRecibo, final NFUnidadeFederativa uf) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(numeroRecibo).toString());
        WSLoteConsulta.log.debug(omElementConsulta);

        final OMElement omElementResult = this.efetuaConsulta(omElementConsulta, uf);
        WSLoteConsulta.log.debug(omElementResult.toString());

        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFLoteConsultaRetorno.class, omElementResult.toString());
    }

    private OMElement efetuaConsulta(final OMElement omElement, final NFUnidadeFederativa uf) throws AxisFault, RemoteException {
        final NfeRetRecepcao2Stub.NfeCabecMsg cabec = new NfeRetRecepcao2Stub.NfeCabecMsg();
        cabec.setCUF(uf.getCodigoIbge());
        cabec.setVersaoDados(NFEConfig.VERSAO_NFE);

        final NfeRetRecepcao2Stub.NfeCabecMsgE cabecE = new NfeRetRecepcao2Stub.NfeCabecMsgE();
        cabecE.setNfeCabecMsg(cabec);

        final NfeRetRecepcao2Stub.NfeDadosMsg dados = new NfeRetRecepcao2Stub.NfeDadosMsg();
        dados.setExtraElement(omElement);

        final NfeRetRecepcao2Result result = new NfeRetRecepcao2Stub(NFAutorizador.valueOfCodigoUF(uf).getNfeRetRecepcao(this.config.getAmbiente())).nfeRetRecepcao2(dados, cabecE);
        return result.getExtraElement();
    }

    private NFLoteConsulta gerarDadosConsulta(final String numeroRecibo) {
        final NFLoteConsulta consulta = new NFLoteConsulta();
        consulta.setRecibo(numeroRecibo);
        consulta.setAmbiente(this.config.getAmbiente());
        consulta.setVersao(new BigDecimal(NFEConfig.VERSAO_NFE));
        return consulta;
    }
}