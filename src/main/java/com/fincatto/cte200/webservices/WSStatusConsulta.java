package com.fincatto.cte200.webservices;

import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteCabecMsg;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteDadosMsg;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteStatusServico;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteStatusServicoCTResult;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.CteStatusServicoSoap12;
import br.inf.portalfiscal.cte.wsdl.ctestatusservico.ObjectFactory;
import java.rmi.RemoteException;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.cte200.CTeConfig;
import com.fincatto.cte200.classes.CTAutorizador;
import com.fincatto.cte200.classes.statusservico.consulta.CTStatusServicoConsulta;
import com.fincatto.cte200.classes.statusservico.consulta.CTStatusServicoConsultaRetorno;
import com.fincatto.cte200.transformers.CTRegistryMatcher;
import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.nfe310.converters.ElementStringConverter;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.ws.Holder;
import org.w3c.dom.Element;

class WSStatusConsulta {

    private static final String NOME_SERVICO = "STATUS";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSStatusConsulta.class);
    private final CTeConfig config;

    WSStatusConsulta(final CTeConfig config) {
        this.config = config;
    }

    CTStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
        return new Persister(new CTRegistryMatcher(), new Format(0)).read(CTStatusServicoConsultaRetorno.class, efetuaConsultaStatus(gerarDadosConsulta().toString(), uf, modelo));

    }

    private CTStatusServicoConsulta gerarDadosConsulta() {
        final CTStatusServicoConsulta consStatServ = new CTStatusServicoConsulta();
        consStatServ.setAmbiente(this.config.getAmbiente());
        consStatServ.setVersao(CTeConfig.VERSAO_CTE);
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private String efetuaConsultaStatus(final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
        CteDadosMsg dadosMsg = new CteDadosMsg();
        CteCabecMsg cabecMsg = new CteCabecMsg();

        cabecMsg.setCUF(unidadeFederativa.getCodigoIbge());
        cabecMsg.setVersaoDados(CTeConfig.VERSAO_CTE);

        dadosMsg.getContent().add(ElementStringConverter.read(xml));

        final CTAutorizador autorizador = CTAutorizador.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getCteStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        Holder<CteCabecMsg> holder = new Holder<>(new ObjectFactory().createCteCabecMsg(cabecMsg).getValue());

        CteStatusServicoSoap12 port = new CteStatusServico(new URL(endpoint)).getCteStatusServicoSoap12();
        CteStatusServicoCTResult result = port.cteStatusServicoCT(dadosMsg, holder);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }
}
