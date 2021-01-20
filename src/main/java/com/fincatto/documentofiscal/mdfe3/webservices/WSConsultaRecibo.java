package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.consultaRecibo.MDFeConsultaRecibo;
import com.fincatto.documentofiscal.mdfe3.classes.consultaRecibo.MDFeConsultaReciboRetorno;
import com.fincatto.documentofiscal.mdfe3.webservices.retornorecepcao.MDFeRetRecepcaoStub;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.rmi.RemoteException;

/**
 * Created by Eldevan Nery Junior on 30/11/17.
 * Classe para envio do pedido de Consulta do recibo MDF-e.
 */
class WSConsultaRecibo implements DFLog {
    
    private final MDFeConfig config;
    
    WSConsultaRecibo(final MDFeConfig config) {
        this.config = config;
    }
    
    MDFeConsultaReciboRetorno consultaRecibo(final String numeroRecibo) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(numeroRecibo).toString());
        this.getLogger().debug(omElementConsulta.toString());
        
        final OMElement omElementResult = this.efetuaConsultaRecibo(omElementConsulta);
        this.getLogger().debug(omElementResult.toString());
        
        return this.config.getPersister().read(MDFeConsultaReciboRetorno.class, omElementResult.toString());
    }
    
    private MDFeConsultaRecibo gerarDadosConsulta(final String numeroRecibo) {
        final MDFeConsultaRecibo consultaRecibo = new MDFeConsultaRecibo();
        consultaRecibo.setNumeroRecibo(numeroRecibo);
        consultaRecibo.setAmbiente(this.config.getAmbiente());
        consultaRecibo.setVersao(MDFeConfig.VERSAO);
        return consultaRecibo;
    }
    
    private OMElement efetuaConsultaRecibo(final OMElement omElement) throws RemoteException {
        final MDFeRetRecepcaoStub.MdfeCabecMsg cabec = new MDFeRetRecepcaoStub.MdfeCabecMsg();
        cabec.setCUF(this.config.getCUF().getCodigoIbge());
        cabec.setVersaoDados(MDFeConfig.VERSAO);
        
        final MDFeRetRecepcaoStub.MdfeCabecMsgE cabecEnv = new MDFeRetRecepcaoStub.MdfeCabecMsgE();
        cabecEnv.setMdfeCabecMsg(cabec);
        
        final MDFeRetRecepcaoStub.MdfeDadosMsg dados = new MDFeRetRecepcaoStub.MdfeDadosMsg();
        dados.setExtraElement(omElement);
        
        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeRetornoRecepcao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta Recibo, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        return new MDFeRetRecepcaoStub(endpoint, config).mdfeRetRecepcao(dados, cabecEnv).getExtraElement();
    }
}
