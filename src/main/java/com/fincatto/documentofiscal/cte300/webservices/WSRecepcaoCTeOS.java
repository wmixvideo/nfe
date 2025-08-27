package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.envio.CTeOSEnvioRetorno;
import com.fincatto.documentofiscal.cte300.classes.envio.CTeOSEnvioRetornoDados;
import com.fincatto.documentofiscal.cte300.classes.os.CTeOS;
import com.fincatto.documentofiscal.cte300.webservices.recepcaoOS.CteRecepcaoOSStub;
import com.fincatto.documentofiscal.cte300.webservices.recepcaoOS.CteRecepcaoOSStub.CteCabecMsg;
import com.fincatto.documentofiscal.cte300.webservices.recepcaoOS.CteRecepcaoOSStub.CteCabecMsgE;
import com.fincatto.documentofiscal.cte300.webservices.recepcaoOS.CteRecepcaoOSStub.CteDadosMsg;
import com.fincatto.documentofiscal.cte300.webservices.recepcaoOS.CteRecepcaoOSStub.CteRecepcaoOSResult;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

class WSRecepcaoCTeOS implements DFLog {

    private final CTeConfig config;

    WSRecepcaoCTeOS(final CTeConfig config) {
        this.config = config;
    }
    
    public CTeOSEnvioRetornoDados envioRecepcao(CTeOS cteOS) throws Exception {
        //assina o lote
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cteOS.toString(), "infCte");
        final CTeOS loteAssinado = this.config.getPersister().read(CTeOS.class, documentoAssinado);
        
        //comunica o lote
        final CTeOSEnvioRetorno retorno = comunicaLote(documentoAssinado);
        return new CTeOSEnvioRetornoDados(retorno, loteAssinado);
    }
    
    private CTeOSEnvioRetorno comunicaLote(final String loteAssinadoXml) throws Exception {
        DFXMLValidador.validaCTeOS300(loteAssinadoXml);

        final OMElement omElement = AXIOMUtil.stringToOM(loteAssinadoXml);
        
        final CteDadosMsg dados = new CteDadosMsg();
        dados.setExtraElement(omElement);
        
        final CteCabecMsgE cabecalhoSOAP = this.getCabecalhoSOAP();
        this.getLogger().debug(omElement.toString());
        
        final CTAutorizador31 autorizador = CTAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = autorizador.getCteRecepcaoOS(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao OS, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        final CteRecepcaoOSResult autorizacaoLoteResult = new CteRecepcaoOSStub(endpoint, config).cteRecepcaoOS(dados, cabecalhoSOAP);
        final CTeOSEnvioRetorno retorno = this.config.getPersister().read(CTeOSEnvioRetorno.class, autorizacaoLoteResult.getExtraElement().toString());
        this.getLogger().debug(retorno.toString());
        return retorno;
    }
    
    private CteCabecMsgE getCabecalhoSOAP() {
        final CteCabecMsg cabecalho = new CteCabecMsg();
        cabecalho.setCUF(this.config.getCUF().getCodigoIbge());
        cabecalho.setVersaoDados("3.00");
        final CteCabecMsgE cabecalhoSOAP = new CteCabecMsgE();
        cabecalhoSOAP.setCteCabecMsg(cabecalho);
        return cabecalhoSOAP;
    }
}
