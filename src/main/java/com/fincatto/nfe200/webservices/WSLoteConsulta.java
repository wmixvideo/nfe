package com.fincatto.nfe200.webservices;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe200.NFEConfig;
import com.fincatto.nfe200.classes.NFAutorizador;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;
import com.fincatto.nfe200.classes.lote.consulta.NFLoteConsulta;
import com.fincatto.nfe200.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe200.transformers.NFRegistryMatcher;
import com.fincatto.nfe200.webservices.lote.consulta.NfeRetRecepcao2Stub;
import com.fincatto.nfe200.webservices.lote.consulta.NfeRetRecepcao2Stub.NfeRetRecepcao2Result;

class WSLoteConsulta {

    private static final Logger LOG = Logger.getLogger(WSLoteConsulta.class);
    private final NFEConfig config;

    public WSLoteConsulta(final NFEConfig config) {
        this.config = config;
    }

    public NFLoteConsultaRetorno consultaLote(final String numeroRecibo) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(numeroRecibo).toString());
        WSLoteConsulta.LOG.info(omElementConsulta);

        final OMElement omElementResult = this.efetuaConsulta(omElementConsulta);
        WSLoteConsulta.LOG.info(omElementResult);

        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFLoteConsultaRetorno.class, omElementResult.toString());
    }

    private OMElement efetuaConsulta(final OMElement omElement) throws AxisFault, RemoteException {
        final NfeRetRecepcao2Stub.NfeCabecMsg cabec = new NfeRetRecepcao2Stub.NfeCabecMsg();
        final NFUnidadeFederativa cuf = this.config.getCUF();
        cabec.setCUF(cuf.getCodigoIbge());
        cabec.setVersaoDados(NFEConfig.VERSAO_NFE);

        final NfeRetRecepcao2Stub.NfeCabecMsgE cabecE = new NfeRetRecepcao2Stub.NfeCabecMsgE();
        cabecE.setNfeCabecMsg(cabec);

        final NfeRetRecepcao2Stub.NfeDadosMsg dados = new NfeRetRecepcao2Stub.NfeDadosMsg();
        dados.setExtraElement(omElement);
        final NfeRetRecepcao2Result result = new NfeRetRecepcao2Stub(NFAutorizador.valueOfCodigoUF(cuf).getNfeRetRecepcao(this.config.getAmbiente())).nfeRetRecepcao2(dados, cabecE);
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