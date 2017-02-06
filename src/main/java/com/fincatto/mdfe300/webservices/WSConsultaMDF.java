package com.fincatto.mdfe300.webservices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.Holder;

import com.fincatto.mdfe300.classes.MDFAutorizador;

import br.inf.portalfiscal.mdfe.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.TRetConsSitMDFe;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsulta.MDFeConsulta;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsulta.MDFeConsultaSoap12;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsulta.MdfeCabecMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsulta.MdfeConsultaMDFResult;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsulta.MdfeDadosMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsulta.ObjectFactory;
import com.fincatto.mdfe300.MDFeConfig;

class WSConsultaMDF {

    private static final String VERSAO_LEIAUTE = "3.00";
    private static final String SERVICO_SOLICITADO = "CONSULTAR";
    private final MDFeConfig config;

    WSConsultaMDF(final MDFeConfig config) {
        this.config = config;
    }

    TRetConsSitMDFe consultaMDFe(final String chaveMDFe) throws MalformedURLException {
        TConsSitMDFe consSitMDFe = new TConsSitMDFe();
        consSitMDFe.setTpAmb(this.config.getAmbiente().getCodigo());
        consSitMDFe.setVersao(VERSAO_LEIAUTE);
        consSitMDFe.setXServ(SERVICO_SOLICITADO);
        consSitMDFe.setChMDFe(chaveMDFe);
        JAXBElement<TConsSitMDFe> tConsSitMDFe = new br.inf.portalfiscal.mdfe.ObjectFactory().createConsSitMDFe(consSitMDFe);

        MdfeCabecMsg mdfeCabecMsg = new MdfeCabecMsg();
        mdfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        mdfeCabecMsg.setVersaoDados(VERSAO_LEIAUTE);

        MdfeDadosMsg mdfeDadosMsg = new MdfeDadosMsg();
        mdfeDadosMsg.getContent().add(tConsSitMDFe);
        Holder<MdfeCabecMsg> holder = new Holder<>(new ObjectFactory().createMdfeCabecMsg(mdfeCabecMsg).getValue());

        MDFeConsultaSoap12 port = new MDFeConsulta(new URL(MDFAutorizador.MDFe.getMDFeConsulta(this.config.getAmbiente()))).getMDFeConsultaSoap12();
        MdfeConsultaMDFResult result = port.mdfeConsultaMDF(mdfeDadosMsg, holder);

        return ((JAXBElement<TRetConsSitMDFe>) result.getContent().get(0)).getValue();
    }

}
