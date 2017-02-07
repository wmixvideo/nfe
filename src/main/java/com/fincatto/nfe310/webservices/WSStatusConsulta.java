package com.fincatto.nfe310.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.w3c.dom.Element;

import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.statusservico.consulta.NFStatusServicoConsulta;
import com.fincatto.nfe310.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.nfe310.converters.ElementStringConverter;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;

import br.inf.portalfiscal.nfe.wsdl.nfestatusservico.NfeStatusServico;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico.NfeStatusServicoNFResult;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico.NfeStatusServicoSoap;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2Soap;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServicoNF2Result;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico3.NfeStatusServico3;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico3.NfeStatusServicoSoap12;

class WSStatusConsulta {

    private static final String NOME_SERVICO = "STATUS";
    private final NFeConfig config;

    WSStatusConsulta(final NFeConfig config) {
        this.config = config;
    }

    NFStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFStatusServicoConsultaRetorno.class, efetuaConsultaStatus(gerarDadosConsulta(uf).toString(), uf, modelo));
    }

    private NFStatusServicoConsulta gerarDadosConsulta(final DFUnidadeFederativa unidadeFederativa) {
        final NFStatusServicoConsulta consStatServ = new NFStatusServicoConsulta();
        consStatServ.setUf(unidadeFederativa);
        consStatServ.setAmbiente(this.config.getAmbiente());
        consStatServ.setVersao(NFeConfig.VERSAO_NFE);
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private String efetuaConsultaStatus(final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException, Exception {
    	if (DFUnidadeFederativa.BA.equals(unidadeFederativa)) {
    		return efetuaConsultaStatusBA(xml, modelo);
    	} else if (DFUnidadeFederativa.PR.equals(unidadeFederativa)) {
    		return efetuaConsultaStatusPR(xml, modelo);
    	}

        NfeDadosMsg dadosMsg = new NfeDadosMsg();
        NfeCabecMsg cabecMsg = new NfeCabecMsg();

        cabecMsg.setCUF(unidadeFederativa.getCodigoIbge());
        cabecMsg.setVersaoDados(NFeConfig.VERSAO_NFE);

        dadosMsg.getContent().add(ElementStringConverter.read(xml));

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = DFModelo.NFCE.equals(modelo) ? autorizador.getNfceStatusServico(this.config.getAmbiente()) : autorizador.getNfeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        NfeStatusServico2Soap port = getPortaStatusServico(endpoint, unidadeFederativa);
        NfeStatusServicoNF2Result result = port.nfeStatusServicoNF2(dadosMsg, cabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

    private String efetuaConsultaStatusBA(final String xml, final DFModelo modelo) throws RemoteException, MalformedURLException, Exception {
        br.inf.portalfiscal.nfe.wsdl.nfestatusservico.NfeDadosMsg dadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfestatusservico.NfeDadosMsg();
        br.inf.portalfiscal.nfe.wsdl.nfestatusservico.NfeCabecMsg cabecMsg = new br.inf.portalfiscal.nfe.wsdl.nfestatusservico.NfeCabecMsg();

        cabecMsg.setCUF(DFUnidadeFederativa.BA.getCodigoIbge());
        cabecMsg.setVersaoDados(NFeConfig.VERSAO_NFE);

        dadosMsg.getContent().add(ElementStringConverter.read(xml));

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(DFUnidadeFederativa.BA);
        final String endpoint = DFModelo.NFCE.equals(modelo) ? autorizador.getNfceStatusServico(this.config.getAmbiente()) : autorizador.getNfeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + DFUnidadeFederativa.BA.name());
        }

        NfeStatusServicoSoap port = new NfeStatusServico(new URL(endpoint)).getNfeStatusServicoSoap();
        NfeStatusServicoNFResult result = port.nfeStatusServicoNF(dadosMsg, cabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

    private String efetuaConsultaStatusPR(final String xml, final DFModelo modelo) throws RemoteException, MalformedURLException, Exception {
        br.inf.portalfiscal.nfe.wsdl.nfestatusservico3.NfeDadosMsg dadosMsg = new br.inf.portalfiscal.nfe.wsdl.nfestatusservico3.NfeDadosMsg();
        br.inf.portalfiscal.nfe.wsdl.nfestatusservico3.NfeCabecMsg cabecMsg = new br.inf.portalfiscal.nfe.wsdl.nfestatusservico3.NfeCabecMsg();

        cabecMsg.setCUF(DFUnidadeFederativa.PR.getCodigoIbge());
        cabecMsg.setVersaoDados(NFeConfig.VERSAO_NFE);

        dadosMsg.getContent().add(ElementStringConverter.read(xml));

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(DFUnidadeFederativa.PR);
        final String endpoint = DFModelo.NFCE.equals(modelo) ? autorizador.getNfceStatusServico(this.config.getAmbiente()) : autorizador.getNfeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + DFUnidadeFederativa.PR.name());
        }

        NfeStatusServicoSoap12 port = new NfeStatusServico3(new URL(endpoint)).getNfeStatusServicoServicePort();
        br.inf.portalfiscal.nfe.wsdl.nfestatusservico3.NfeStatusServicoNFResult result = port.nfeStatusServicoNF(dadosMsg, cabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

    private NfeStatusServico2Soap getPortaStatusServico(String endpoint,
    		DFUnidadeFederativa unidadeFederativa) throws MalformedURLException {
    	NfeStatusServico2Soap port = null;
        switch (unidadeFederativa) {
		case GO:
			port = new NfeStatusServico2(new URL(endpoint)).getNfeStatusServicoServicePort();
			break;
		case MS:
			port = new NfeStatusServico2(new URL(endpoint)).getNfeStatusServico2Soap12MS();
			break;
		case PE:
			port = new NfeStatusServico2(new URL(endpoint)).getNfeStatusServico2();
			break;
		default:
			port = new NfeStatusServico2(new URL(endpoint)).getNfeStatusServico2Soap12();
			break;
		}
        return port;
    }

}
