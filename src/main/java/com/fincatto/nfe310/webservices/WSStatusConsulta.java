package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServico2Soap;
import br.inf.portalfiscal.nfe.wsdl.nfestatusservico2.NfeStatusServicoNF2Result;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.statusservico.consulta.NFStatusServicoConsulta;
import com.fincatto.nfe310.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.nfe310.converters.ElementNSImplStringConverter;
import com.fincatto.nfe310.parsers.StringElementParser;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

class WSStatusConsulta {

    private static final String NOME_SERVICO = "STATUS";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSStatusConsulta.class);
    private final NFeConfig config;

    WSStatusConsulta(final NFeConfig config) {
        this.config = config;
    }

    NFStatusServicoConsultaRetorno consultaStatus(final NFUnidadeFederativa uf, final NFModelo modelo) throws Exception {
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFStatusServicoConsultaRetorno.class, efetuaConsultaStatus(gerarDadosConsulta(uf).toString(), uf, modelo));
    }

    private NFStatusServicoConsulta gerarDadosConsulta(final NFUnidadeFederativa unidadeFederativa) {
        final NFStatusServicoConsulta consStatServ = new NFStatusServicoConsulta();
        consStatServ.setUf(unidadeFederativa);
        consStatServ.setAmbiente(this.config.getAmbiente());
        consStatServ.setVersao(NFeConfig.VERSAO_NFE);
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private String efetuaConsultaStatus(final String xml, final NFUnidadeFederativa unidadeFederativa, final NFModelo modelo) throws RemoteException, MalformedURLException, Exception {
        NfeDadosMsg dadosMsg = new NfeDadosMsg();
        NfeCabecMsg cabecMsg = new NfeCabecMsg();

        cabecMsg.setCUF(unidadeFederativa.getCodigoIbge());
        cabecMsg.setVersaoDados(NFeConfig.VERSAO_NFE);

        dadosMsg.getContent().add(StringElementParser.read(xml));

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = NFModelo.NFCE.equals(modelo) ? autorizador.getNfceStatusServico(this.config.getAmbiente()) : autorizador.getNfeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }
        
        NfeStatusServico2Soap port = new NfeStatusServico2(new URL(endpoint)).getNfeStatusServico2Soap12();
        NfeStatusServicoNF2Result result = port.nfeStatusServicoNF2(dadosMsg, cabecMsg);
        
        return ElementNSImplStringConverter.read((ElementNSImpl) result.getContent().get(0));
    }
    
}
