package com.fincatto.nfe310.webservices;

import java.net.URL;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.Holder;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.MDFAutorizador;

import br.inf.portalfiscal.mdfe.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.TRetConsReciMDFe;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MDFeRetRecepcao;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MDFeRetRecepcaoSoap12;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MdfeCabecMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MdfeDadosMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.MdfeRetRecepcaoResult;
import br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao.ObjectFactory;

class WSRetornoRecepcaoMDF {

    private static final String VERSAO_LEIAUTE = "3.00";
    private final NFeConfig config;

    WSRetornoRecepcaoMDF(final NFeConfig config) {
        this.config = config;
    }

    TRetConsReciMDFe consultaMDFe(String numeroRecibo) throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        TConsReciMDFe consReciMDFe = new TConsReciMDFe();
        consReciMDFe.setNRec(numeroRecibo);
        consReciMDFe.setTpAmb(this.config.getAmbiente().getCodigo());
        consReciMDFe.setVersao(VERSAO_LEIAUTE);
        JAXBElement<TConsReciMDFe> tConsReciMDFe = new br.inf.portalfiscal.mdfe.ObjectFactory().createConsReciMDFe(consReciMDFe);

        MdfeCabecMsg mdfeCabecMsg = new MdfeCabecMsg();
        mdfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        mdfeCabecMsg.setVersaoDados(VERSAO_LEIAUTE);

        MdfeDadosMsg mdfeDadosMsg = objectFactory.createMdfeDadosMsg();
        mdfeDadosMsg.getContent().add(tConsReciMDFe);
        Holder<MdfeCabecMsg> holder = new Holder<>(objectFactory.createMdfeCabecMsg(mdfeCabecMsg).getValue());

        MDFeRetRecepcaoSoap12 port = new MDFeRetRecepcao(new URL(MDFAutorizador.MDFe.getMDFeRetRecepcao(this.config.getAmbiente()))).getMDFeRetRecepcaoSoap12();
        MdfeRetRecepcaoResult result = port.mdfeRetRecepcao(mdfeDadosMsg, holder);

        return ((JAXBElement<TRetConsReciMDFe>) result.getContent().get(0)).getValue();
    }

}
