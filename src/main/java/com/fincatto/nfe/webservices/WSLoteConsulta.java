package com.fincatto.nfe.webservices;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe.NFEConfig;
import com.fincatto.nfe.classes.NFAutorizador;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.classes.lote.consulta.NFLoteConsulta;
import com.fincatto.nfe.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.nfe.transformers.NFRegistryMatcher;
import com.fincatto.nfe.webservices.gerado.NfeRetAutorizacaoStub;
import com.fincatto.nfe.webservices.gerado.NfeRetAutorizacaoStub.NfeRetAutorizacaoLoteResult;

class WSLoteConsulta {

    final private static Logger log = Logger.getLogger(WSLoteConsulta.class);
    private final NFEConfig config;

    public WSLoteConsulta(final NFEConfig config) {
        this.config = config;
    }

    public NFLoteConsultaRetorno consultaLote(final String numeroRecibo, final NFUnidadeFederativa uf) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(numeroRecibo).toString());
        WSLoteConsulta.log.info(omElementConsulta);

        final OMElement omElementResult = this.efetuaConsulta(omElementConsulta, uf);
        WSLoteConsulta.log.info(omElementResult);

        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFLoteConsultaRetorno.class, omElementResult.toString());
    }

    private OMElement efetuaConsulta(final OMElement omElement, final NFUnidadeFederativa uf) throws AxisFault, RemoteException {
        final NfeRetAutorizacaoStub.NfeCabecMsg cabec = new NfeRetAutorizacaoStub.NfeCabecMsg();
        cabec.setCUF(uf.getCodigoIbge());
        cabec.setVersaoDados(NFEConfig.VERSAO_NFE);

        final NfeRetAutorizacaoStub.NfeCabecMsgE cabecE = new NfeRetAutorizacaoStub.NfeCabecMsgE();
        cabecE.setNfeCabecMsg(cabec);

        final NfeRetAutorizacaoStub.NfeDadosMsg dados = new NfeRetAutorizacaoStub.NfeDadosMsg();
        dados.setExtraElement(omElement);
        final NfeRetAutorizacaoLoteResult autorizacaoLoteResult = new NfeRetAutorizacaoStub(NFAutorizador.valueOfCodigoUF(uf).getNfeRetAutorizacao(this.config.getAmbiente())).nfeRetAutorizacaoLote(dados, cabecE);
        return autorizacaoLoteResult.getExtraElement();
    }

    private NFLoteConsulta gerarDadosConsulta(final String numeroRecibo) {
        final NFLoteConsulta consulta = new NFLoteConsulta();
        consulta.setRecibo(numeroRecibo);
        consulta.setAmbiente(this.config.getAmbiente());
        consulta.setVersao(new BigDecimal(NFEConfig.VERSAO_NFE));
        return consulta;
    }
}