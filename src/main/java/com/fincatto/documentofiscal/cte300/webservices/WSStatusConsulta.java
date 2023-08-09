package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.consultastatusservico.CTeConsStatServ;
import com.fincatto.documentofiscal.cte300.classes.consultastatusservico.CTeConsStatServRet;
import com.fincatto.documentofiscal.cte300.webservices.statusservico.CteStatusServicoStub;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.rmi.RemoteException;

class WSStatusConsulta implements DFLog {
    
    private static final String NOME_SERVICO = "STATUS";
    private final CTeConfig config;
    
    WSStatusConsulta(final CTeConfig config) {
        this.config = config;
    }
    
    CTeConsStatServRet consultaStatus(final DFUnidadeFederativa uf) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(gerarDadosConsulta(this.config).toString());
        this.getLogger().debug(omElementConsulta.toString());
        
        final OMElement omElementResult = this.efetuaConsultaStatus(omElementConsulta, uf);
        this.getLogger().debug(omElementResult.toString());
        
        return this.config.getPersister().read(CTeConsStatServRet.class, omElementResult.toString());
    }
    
    private static CTeConsStatServ gerarDadosConsulta(final CTeConfig config) {
        final CTeConsStatServ consStatServ = new CTeConsStatServ();
        consStatServ.setAmbiente(config.getAmbiente());
        consStatServ.setVersao("3.00");
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }
    
    private OMElement efetuaConsultaStatus(final OMElement omElement, final DFUnidadeFederativa unidadeFederativa) throws RemoteException {
        final CteStatusServicoStub.CteCabecMsg cabec = new CteStatusServicoStub.CteCabecMsg();
        cabec.setCUF(unidadeFederativa.getCodigoIbge());
        cabec.setVersaoDados("3.00");
        
        final CteStatusServicoStub.CteCabecMsgE cabecEnv = new CteStatusServicoStub.CteCabecMsgE();
        cabecEnv.setCteCabecMsg(cabec);
        
        final CteStatusServicoStub.CteDadosMsg dados = new CteStatusServicoStub.CteDadosMsg();
        dados.setExtraElement(omElement);
        
        final CTAutorizador31 autorizador = CTAutorizador31.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getCteStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico, autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }
        return new CteStatusServicoStub(endpoint, config).cteStatusServicoCT(dados, cabecEnv).getExtraElement();
    }
}
