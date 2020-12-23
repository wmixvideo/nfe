package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.consultastatusservico.MDFeConsStatServ;
import com.fincatto.documentofiscal.mdfe3.classes.consultastatusservico.MDFeConsStatServRet;
import com.fincatto.documentofiscal.mdfe3.webservices.statusservico.MDFeStatusServicoStub;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.rmi.RemoteException;

/**
 * Created by Eldevan Nery Junior on 10/11/17.
 * Classe para envio do pedido de Consulta do Status do Servico MDF-e.
 */
class WSStatusConsulta implements DFLog {
    
    private static final String NOME_SERVICO = "STATUS";
    private final MDFeConfig config;
    
    WSStatusConsulta(final MDFeConfig config) {
        this.config = config;
    }
    
    MDFeConsStatServRet consultaStatus(final DFUnidadeFederativa uf) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(gerarDadosConsulta(this.config).toString());
        this.getLogger().debug(omElementConsulta.toString());
        
        final OMElement omElementResult = this.efetuaConsultaStatus(omElementConsulta, uf);
        this.getLogger().debug(omElementResult.toString());
        
        return this.config.getPersister().read(MDFeConsStatServRet.class, omElementResult.toString());
    }
    
    private static MDFeConsStatServ gerarDadosConsulta(final MDFeConfig config) {
        final MDFeConsStatServ consStatServ = new MDFeConsStatServ();
        consStatServ.setAmbiente(config.getAmbiente());
        consStatServ.setVersao(MDFeConfig.VERSAO);
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }
    
    private OMElement efetuaConsultaStatus(final OMElement omElement, final DFUnidadeFederativa unidadeFederativa) throws RemoteException {
        final MDFeStatusServicoStub.MdfeCabecMsg cabec = new MDFeStatusServicoStub.MdfeCabecMsg();
        cabec.setCUF(unidadeFederativa.getCodigoIbge());
        cabec.setVersaoDados(MDFeConfig.VERSAO);
        
        final MDFeStatusServicoStub.MdfeCabecMsgE cabecEnv = new MDFeStatusServicoStub.MdfeCabecMsgE();
        cabecEnv.setMdfeCabecMsg(cabec);
        
        final MDFeStatusServicoStub.MdfeDadosMsg dados = new MDFeStatusServicoStub.MdfeDadosMsg();
        dados.setExtraElement(omElement);
        
        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getMDFeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico, autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }
        final MDFeStatusServicoStub.MdfeStatusServicoMDFResult result = new MDFeStatusServicoStub(endpoint, config).mdfeStatusServicoMDF(dados, cabecEnv);
        return result.getExtraElement();
    }
}
