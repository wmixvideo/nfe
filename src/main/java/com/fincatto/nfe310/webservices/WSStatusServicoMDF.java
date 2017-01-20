package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.mdfe.TConsStatServ;
import br.inf.portalfiscal.mdfe.TRetConsStatServ;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MDFeStatusServico;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MDFeStatusServicoSoap12;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MdfeCabecMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MdfeDadosMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MdfeStatusServicoMDFResult;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.ObjectFactory;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.converters.ElementStringConverter;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMResult;
import javax.xml.ws.Holder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

class WSStatusServicoMDF {

    private final NFeConfig config;

    WSStatusServicoMDF(final NFeConfig config) {
        this.config = config;
    }

    TRetConsStatServ consultaStatus() throws Exception {
        br.inf.portalfiscal.mdfe.ObjectFactory factoryObject = new br.inf.portalfiscal.mdfe.ObjectFactory();
        TConsStatServ consStatServ = new TConsStatServ();
        consStatServ.setTpAmb("1");
        consStatServ.setVersao("1.00");
        consStatServ.setXServ("STATUS");
        JAXBElement<TConsStatServ> jAXBElement = factoryObject.createConsStatServMDFe(consStatServ);
        DOMResult dOMResult = new DOMResult();
        
        JAXBContext contextMarshaller = JAXBContext.newInstance(TConsStatServ.class);
        Marshaller marshaller = contextMarshaller.createMarshaller();
        marshaller.marshal(jAXBElement, dOMResult);
        
        Element element = ((Document) dOMResult.getNode()).getDocumentElement();
        
        MdfeCabecMsg mdfeCabecMsg = new MdfeCabecMsg();
        mdfeCabecMsg.setCUF("22");
        mdfeCabecMsg.setVersaoDados("1.00");
        
        MdfeDadosMsg mdfeDadosMsg = new MdfeDadosMsg();
        mdfeDadosMsg.getContent().add(element);
        Holder<MdfeCabecMsg> holder = new Holder<>(new ObjectFactory().createMdfeCabecMsg(mdfeCabecMsg).getValue());
        
        MDFeStatusServicoSoap12 port = new MDFeStatusServico().getMDFeStatusServicoSoap12();
        MdfeStatusServicoMDFResult result = port.mdfeStatusServicoMDF(mdfeDadosMsg, holder);
        
        JAXBContext contextUnmarshaller = JAXBContext.newInstance("br.inf.portalfiscal.mdfe");
        Unmarshaller unmarshaller = contextUnmarshaller.createUnmarshaller();
        JAXBElement<TRetConsStatServ> jAXBElement2 = (JAXBElement<TRetConsStatServ>) unmarshaller.unmarshal(new StringReader(ElementStringConverter.write((Element) result.getContent().get(0))));
        
        return jAXBElement2.getValue();
    }

}
