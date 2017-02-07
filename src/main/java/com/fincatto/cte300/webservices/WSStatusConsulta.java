package com.fincatto.cte300.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.ws.Holder;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.w3c.dom.Element;

import com.fincatto.cte300.CTeConfig;
import com.fincatto.cte300.classes.CTAutorizador;
import com.fincatto.cte300.classes.statusservico.consulta.CTStatusServicoConsulta;
import com.fincatto.cte300.classes.statusservico.consulta.CTStatusServicoConsultaRetorno;
import com.fincatto.cte300.transformers.CTRegistryMatcher;
import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.nfe310.converters.ElementStringConverter;

import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteCabecMsg;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteDadosMsg;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteStatusServico;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteStatusServicoCTResult;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteStatusServicoSoap12;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.ObjectFactory;

class WSStatusConsulta {

    private static final String NOME_SERVICO = "STATUS";
    private final CTeConfig config;

    WSStatusConsulta(final CTeConfig config) {
        this.config = config;
    }

    CTStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf) throws Exception {
        return new Persister(new CTRegistryMatcher(), new Format(0)).read(CTStatusServicoConsultaRetorno.class, efetuaConsultaStatus(gerarDadosConsulta().toString(), uf));

    }

    private CTStatusServicoConsulta gerarDadosConsulta() {
        final CTStatusServicoConsulta consStatServ = new CTStatusServicoConsulta();
        consStatServ.setAmbiente(this.config.getAmbiente());
        consStatServ.setVersao(CTeConfig.VERSAO_CTE);
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private String efetuaConsultaStatus(final String xml, final DFUnidadeFederativa unidadeFederativa) throws RemoteException, MalformedURLException {
        CteDadosMsg dadosMsg = new CteDadosMsg();
        CteCabecMsg cabecMsg = new CteCabecMsg();

        cabecMsg.setCUF(unidadeFederativa.getCodigoIbge());
        cabecMsg.setVersaoDados(CTeConfig.VERSAO_CTE);

        dadosMsg.getContent().add(ElementStringConverter.read(xml));

        final CTAutorizador autorizador = CTAutorizador.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getCteStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + DFModelo.CTE.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        Holder<CteCabecMsg> holder = new Holder<>(new ObjectFactory().createCteCabecMsg(cabecMsg).getValue());

        CteStatusServicoSoap12 port = null;
        if (DFUnidadeFederativa.PR.equals(unidadeFederativa)) {
        	port = new CteStatusServico(new URL(endpoint)).getCteStatusServicoServicePort();
    	} else {
        	port = new CteStatusServico(new URL(endpoint)).getCteStatusServicoSoap12();
        }
        CteStatusServicoCTResult result = port.cteStatusServicoCT(dadosMsg, holder);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

}
