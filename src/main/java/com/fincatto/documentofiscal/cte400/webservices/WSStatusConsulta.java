package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.consultastatusservico.CTeConsStatServ;
import com.fincatto.documentofiscal.cte400.classes.consultastatusservico.CTeConsStatServRet;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.cte400.webservices.gerado.CTeStatusServicoV4Stub;
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
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(gerarDadosConsulta(this.config, uf).toString());
        this.getLogger().debug(omElementConsulta.toString());
        
        final OMElement omElementResult = this.efetuaConsultaStatus(omElementConsulta, uf);
        this.getLogger().debug(omElementResult.toString());
        
        return this.config.getPersister().read(CTeConsStatServRet.class, omElementResult.toString());
    }
    
    private static CTeConsStatServ gerarDadosConsulta(final CTeConfig config, final DFUnidadeFederativa uf) {
        final CTeConsStatServ consStatServ = new CTeConsStatServ();
        consStatServ.setVersao("4.00");
        consStatServ.setAmbiente(config.getAmbiente());
        consStatServ.setUf(uf.getCodigoIbge());
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }
    
    private OMElement efetuaConsultaStatus(final OMElement omElement, final DFUnidadeFederativa unidadeFederativa) throws RemoteException {
        final CTeStatusServicoV4Stub.CteDadosMsg dados = new CTeStatusServicoV4Stub.CteDadosMsg();
        dados.setExtraElement(omElement);
        
        final CTAutorizador400 autorizador = CTAutorizador400.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getCteStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico, autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }
        return new CTeStatusServicoV4Stub(endpoint, config).cteStatusServicoCT(dados).getExtraElement();
    }
}
