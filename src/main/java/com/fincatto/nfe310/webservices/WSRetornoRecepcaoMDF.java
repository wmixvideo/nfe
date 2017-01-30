package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.mdfe.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.TRetConsReciMDFe;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MDFeRetRecepcao;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MDFeRetRecepcaoSoap12;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MdfeCabecMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MdfeDadosMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MdfeRetRecepcaoResult;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.ObjectFactory;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.converters.ElementStringConverter;
import java.io.StringReader;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMResult;
import javax.xml.ws.Holder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

class WSRetornoRecepcaoMDF {

    private final NFeConfig config;

    WSRetornoRecepcaoMDF(final NFeConfig config) {
        this.config = config;
    }

    TRetConsReciMDFe consultaMDFe(String numeroRecibo) throws Exception {
        br.inf.portalfiscal.mdfe.ObjectFactory factoryObject = new br.inf.portalfiscal.mdfe.ObjectFactory();
        ObjectFactory factoryStub = new ObjectFactory();
        TConsReciMDFe consReciMDFe = new TConsReciMDFe();
        consReciMDFe.setNRec(numeroRecibo);
        consReciMDFe.setTpAmb("1");
        consReciMDFe.setVersao("1.00");
        JAXBElement<TConsReciMDFe> jAXBElement = factoryObject.createConsReciMDFe(consReciMDFe);
        
        DOMResult dOMResult = new DOMResult();
        
        JAXBContext contextMarshaller = JAXBContext.newInstance(TConsReciMDFe.class);
        Marshaller marshaller = contextMarshaller.createMarshaller();
        marshaller.marshal(jAXBElement, dOMResult);
        
        Element element = ((Document) dOMResult.getNode()).getDocumentElement();
        
        MdfeCabecMsg mdfeCabecMsg = new MdfeCabecMsg();
        mdfeCabecMsg.setCUF("22");
        mdfeCabecMsg.setVersaoDados("1.00");
        
        MdfeDadosMsg mdfeDadosMsg = factoryStub.createMdfeDadosMsg();
        mdfeDadosMsg.getContent().add(element);
        Holder<MdfeCabecMsg> holder = new Holder<>(factoryStub.createMdfeCabecMsg(mdfeCabecMsg).getValue());
        
        MDFeRetRecepcaoSoap12 port = new MDFeRetRecepcao(new URL("https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx")).getMDFeRetRecepcaoSoap12();
        MdfeRetRecepcaoResult result = port.mdfeRetRecepcao(mdfeDadosMsg, holder);
        
        JAXBContext contextUnmarshaller = JAXBContext.newInstance("br.inf.portalfiscal.mdfe");
        Unmarshaller unmarshaller = contextUnmarshaller.createUnmarshaller();
        JAXBElement<TRetConsReciMDFe> jAXBElement2 = (JAXBElement<TRetConsReciMDFe>) unmarshaller.unmarshal(new StringReader(ElementStringConverter.write((Element) result.getContent().get(0))));
        
        return jAXBElement2.getValue();
    }

}
