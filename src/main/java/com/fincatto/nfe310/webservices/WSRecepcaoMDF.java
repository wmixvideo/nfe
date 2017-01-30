package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.mdfe.TEnviMDFe;
import br.inf.portalfiscal.mdfe.TMDFe;
import br.inf.portalfiscal.mdfe.TRetEnviMDFe;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MDFeRecepcao;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MDFeRecepcaoSoap12;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MdfeCabecMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MdfeDadosMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MdfeRecepcaoLoteResult;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.ObjectFactory;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.converters.ElementStringConverter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Holder;
import org.w3c.dom.Element;

class WSRecepcaoMDF {

    private final NFeConfig config;

    WSRecepcaoMDF(final NFeConfig config) {
        this.config = config;
    }

    TRetEnviMDFe enviaMDFe(TMDFe mdfe) throws Exception {
        br.inf.portalfiscal.mdfe.ObjectFactory factoryObject = new br.inf.portalfiscal.mdfe.ObjectFactory();
        TEnviMDFe enviMDFe = new TEnviMDFe();
        enviMDFe.setIdLote("1");
        enviMDFe.setVersao("3.00");
        enviMDFe.setMDFe(mdfe);
        
        DOMResult dOMResult2 = new DOMResult();
        
        JAXBContext contextMarshaller = JAXBContext.newInstance(TEnviMDFe.class);
        Marshaller marshaller = contextMarshaller.createMarshaller();

//        Assinar documento
        JAXBElement<TMDFe> TMDFe = factoryObject.createMDFe(mdfe);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(TMDFe, stringWriter);
        
        StringWriter stringWriter2 = new StringWriter();
        stringWriter2.write(stringWriter.toString().replace(" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", ""));

        String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(stringWriter2.toString());
        StringReader reader = new StringReader(documentoAssinado);
        
        // Re-marshaller
        JAXBContext contextUnmarshaller = JAXBContext.newInstance("br.inf.portalfiscal.mdfe");
        Unmarshaller unmarshaller = contextUnmarshaller.createUnmarshaller();
        TMDFe = (JAXBElement<TMDFe>) unmarshaller.unmarshal(new StreamSource(reader));
        enviMDFe.setMDFe(TMDFe.getValue());
        JAXBElement<TEnviMDFe> TEnviMDFe = factoryObject.createEnviMDFe(enviMDFe);
        
        MdfeDadosMsg mdfeDadosMsg = new MdfeDadosMsg();

        mdfeDadosMsg.getContent().add(TEnviMDFe);

        MdfeCabecMsg mdfeCabecMsg = new MdfeCabecMsg();
        mdfeCabecMsg.setCUF("22");
        mdfeCabecMsg.setVersaoDados("3.00");
        
        Holder<MdfeCabecMsg> holder = new Holder<>(new ObjectFactory().createMdfeCabecMsg(mdfeCabecMsg).getValue());
        
        MDFeRecepcaoSoap12 port = new MDFeRecepcao(new URL("https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFerecepcao/MDFeRecepcao.asmx")).getMDFeRecepcaoSoap12();

        MdfeRecepcaoLoteResult result = port.mdfeRecepcaoLote(mdfeDadosMsg, holder);
        
        contextUnmarshaller = JAXBContext.newInstance("br.inf.portalfiscal.mdfe");
        unmarshaller = contextUnmarshaller.createUnmarshaller();
        JAXBElement<TRetEnviMDFe> jAXBElement2 = (JAXBElement<TRetEnviMDFe>) unmarshaller.unmarshal(new StringReader(ElementStringConverter.write((Element) result.getContent().get(0))));
        
        return jAXBElement2.getValue();
       
    }

}
