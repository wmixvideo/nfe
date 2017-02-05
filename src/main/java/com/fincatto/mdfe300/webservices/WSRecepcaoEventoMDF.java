package com.fincatto.mdfe300.webservices;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Holder;

import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.mdfe300.classes.MDFAutorizador;

import br.inf.portalfiscal.mdfe.TEvento;
import br.inf.portalfiscal.mdfe.TRetEvento;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcaoevento.MDFeRecepcaoEvento;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcaoevento.MDFeRecepcaoEventoSoap12;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcaoevento.MdfeCabecMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcaoevento.MdfeDadosMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcaoevento.MdfeRecepcaoEventoResult;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcaoevento.ObjectFactory;
import com.fincatto.mdfe300.MDFeConfig;

class WSRecepcaoEventoMDF {

    private static final String VERSAO_LEIAUTE = "3.00";
    private final MDFeConfig config;

    WSRecepcaoEventoMDF(final MDFeConfig config) {
        this.config = config;
    }

    TRetEvento recepcaoEventoMDFe(TEvento evento) throws Exception {
        br.inf.portalfiscal.mdfe.ObjectFactory factoryObject = new br.inf.portalfiscal.mdfe.ObjectFactory();

        JAXBContext context = JAXBContext.newInstance("br.inf.portalfiscal.mdfe");
        Marshaller marshaller = context.createMarshaller();

        JAXBElement<TEvento> tEvento = factoryObject.createEventoMDFe(evento);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(tEvento, stringWriter);

        //Verificar a melhor forma de remover o namespace da assinatura
        String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(stringWriter.toString().replace(" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", ""));
        StringReader reader = new StringReader(documentoAssinado);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        tEvento = (JAXBElement<TEvento>) unmarshaller.unmarshal(new StreamSource(reader));

        MdfeCabecMsg mdfeCabecMsg = new MdfeCabecMsg();
        mdfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        mdfeCabecMsg.setVersaoDados(VERSAO_LEIAUTE);

        MdfeDadosMsg mdfeDadosMsg = new MdfeDadosMsg();
        mdfeDadosMsg.getContent().add(tEvento);
        Holder<MdfeCabecMsg> holder = new Holder<>(new ObjectFactory().createMdfeCabecMsg(mdfeCabecMsg).getValue());

        MDFeRecepcaoEventoSoap12 port = new MDFeRecepcaoEvento(new URL(MDFAutorizador.MDFe.getMDFeRecepcaoEvento(this.config.getAmbiente()))).getMDFeRecepcaoEventoSoap12();
        MdfeRecepcaoEventoResult result = port.mdfeRecepcaoEvento(mdfeDadosMsg, holder);

        return ((JAXBElement<TRetEvento>) result.getContent().get(0)).getValue();
    }

}
