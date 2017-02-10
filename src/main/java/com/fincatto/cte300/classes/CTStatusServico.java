package com.fincatto.cte300.classes;

import com.fincatto.cte300.CTeConfig;
import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.nfe310.converters.ElementStringConverter;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import org.w3c.dom.Element;

/**
 * Classe com métodos específicos por autorizador para consulta do status do
 * serviço do CT-e
 */
public class CTStatusServico {

    public String efetuaConsultaStatusSVRS(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
        br.inf.portalfiscal.cte.wsdl.ctestatusservico.svrs.CteDadosMsg dadosMsg = new br.inf.portalfiscal.cte.wsdl.ctestatusservico.svrs.CteDadosMsg();
        br.inf.portalfiscal.cte.wsdl.ctestatusservico.svrs.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.ctestatusservico.svrs.CteCabecMsg();

        cabecMsg.setCUF(unidadeFederativa.getCodigoIbge());
        cabecMsg.setVersaoDados(CTeConfig.VERSAO_CTE);

        dadosMsg.getContent().add(ElementStringConverter.read(xml));

        final CTAutorizador autorizador = CTAutorizador.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getCteStatusServico(ambiente);
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        Holder<br.inf.portalfiscal.cte.wsdl.ctestatusservico.svrs.CteCabecMsg> holder = new Holder<>(new br.inf.portalfiscal.cte.wsdl.ctestatusservico.svrs.ObjectFactory().createCteCabecMsg(cabecMsg).getValue());

        br.inf.portalfiscal.cte.wsdl.ctestatusservico.svrs.CteStatusServicoSoap12 port = new br.inf.portalfiscal.cte.wsdl.ctestatusservico.svrs.CteStatusServico(new URL(endpoint)).getCteStatusServicoSoap12();
        br.inf.portalfiscal.cte.wsdl.ctestatusservico.svrs.CteStatusServicoCTResult result = port.cteStatusServicoCT(dadosMsg, holder);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

    public String efetuaConsultaStatusPR(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
        br.inf.portalfiscal.cte.wsdl.ctestatusservico.pr.CteDadosMsg dadosMsg = new br.inf.portalfiscal.cte.wsdl.ctestatusservico.pr.CteDadosMsg();
        br.inf.portalfiscal.cte.wsdl.ctestatusservico.pr.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.ctestatusservico.pr.CteCabecMsg();

        cabecMsg.setCUF(unidadeFederativa.getCodigoIbge());
        cabecMsg.setVersaoDados(CTeConfig.VERSAO_CTE);

        dadosMsg.getContent().add(ElementStringConverter.read(xml));

        final CTAutorizador autorizador = CTAutorizador.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getCteStatusServico(ambiente);
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        Holder<br.inf.portalfiscal.cte.wsdl.ctestatusservico.pr.CteCabecMsg> holder = new Holder<>(new br.inf.portalfiscal.cte.wsdl.ctestatusservico.pr.ObjectFactory().createCteCabecMsg(cabecMsg).getValue());

        br.inf.portalfiscal.cte.wsdl.ctestatusservico.pr.CteStatusServicoSoap12 port = new br.inf.portalfiscal.cte.wsdl.ctestatusservico.pr.CteStatusServico(new URL(endpoint)).getCteStatusServicoServicePort();
        br.inf.portalfiscal.cte.wsdl.ctestatusservico.pr.CteStatusServicoCTResult result = port.cteStatusServicoCT(dadosMsg, holder);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

    public String efetuaConsultaStatusMT(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
        br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt.CteDadosMsg dadosMsg = new br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt.CteDadosMsg();
        br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt.CteCabecMsg();

        cabecMsg.setCUF(unidadeFederativa.getCodigoIbge());
        cabecMsg.setVersaoDados(CTeConfig.VERSAO_CTE);

        dadosMsg.getContent().add(ElementStringConverter.read(xml));

        final CTAutorizador autorizador = CTAutorizador.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getCteStatusServico(ambiente);
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        Holder<br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt.CteCabecMsg> holder = new Holder<>(new br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt.ObjectFactory().createCteCabecMsg(cabecMsg).getValue());

        br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt.CteStatusServicoSoap12 port = new br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt.CteStatusServico(new URL(endpoint)).getCteStatusServico();

        //Fonte: http://stackoverflow.com/questions/13702022/calling-web-service-that-sits-on-a-load-balancer-with-jax-ws-returns-at-http-sta
        BindingProvider bindingProvider = (BindingProvider) port;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://cte.sefaz.mt.gov.br/ctews/services/CteStatusServico");
        br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt.CteStatusServicoCTResult result = port.cteStatusServicoCT(dadosMsg, holder);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

}