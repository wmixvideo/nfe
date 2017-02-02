package com.fincatto.nfe310.webservices;

import br.inf.portalfiscal.mdfe.TEnviMDFe;
import br.inf.portalfiscal.mdfe.TRetEnviMDFe;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MDFeRecepcao;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MDFeRecepcaoSoap12;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MdfeCabecMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MdfeDadosMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.MdfeRecepcaoLoteResult;
import br.inf.portalfiscal.mdfe.wsdl.mdferecepcao.ObjectFactory;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.assinatura.AssinaturaDigital;
import com.fincatto.nfe310.classes.MDFAutorizador;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Holder;

class WSRecepcaoMDF {

    private static final String VERSAO_LEIAUTE = "3.00";
    private final NFeConfig config;

    WSRecepcaoMDF(final NFeConfig config) {
        this.config = config;
    }

    TRetEnviMDFe enviaMDFe(TEnviMDFe enviMDFe) throws Exception {
        br.inf.portalfiscal.mdfe.ObjectFactory factoryObject = new br.inf.portalfiscal.mdfe.ObjectFactory();

        JAXBContext context = JAXBContext.newInstance("br.inf.portalfiscal.mdfe");
        Marshaller marshaller = context.createMarshaller();

        JAXBElement<TEnviMDFe> tEnviMDFe = factoryObject.createEnviMDFe(enviMDFe);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(tEnviMDFe, stringWriter);

        //Verificar a melhor forma de remover o namespace da assinatura
        String documentoAssinado = new AssinaturaDigital(this.config).assinarDocumento(stringWriter.toString().replace(" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", ""), "infMDFe");
        StringReader reader = new StringReader(documentoAssinado);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        tEnviMDFe = (JAXBElement<TEnviMDFe>) unmarshaller.unmarshal(new StreamSource(reader));

        MdfeDadosMsg mdfeDadosMsg = new MdfeDadosMsg();
        mdfeDadosMsg.getContent().add(tEnviMDFe);

        MdfeCabecMsg mdfeCabecMsg = new MdfeCabecMsg();
        mdfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        mdfeCabecMsg.setVersaoDados(VERSAO_LEIAUTE);

        Holder<MdfeCabecMsg> holder = new Holder<>(new ObjectFactory().createMdfeCabecMsg(mdfeCabecMsg).getValue());

        MDFeRecepcaoSoap12 port = new MDFeRecepcao(new URL(MDFAutorizador.MDFe.getMDFeRecepcao(this.config.getAmbiente()))).getMDFeRecepcaoSoap12();
        MdfeRecepcaoLoteResult result = port.mdfeRecepcaoLote(mdfeDadosMsg, holder);

        return ((JAXBElement<TRetEnviMDFe>) result.getContent().get(0)).getValue();

    }

}
