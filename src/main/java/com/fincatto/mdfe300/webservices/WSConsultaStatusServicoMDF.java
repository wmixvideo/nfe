package com.fincatto.mdfe300.webservices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.Holder;

import com.fincatto.mdfe300.classes.MDFAutorizador;

import br.inf.portalfiscal.mdfe.TConsStatServ;
import br.inf.portalfiscal.mdfe.TRetConsStatServ;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MDFeStatusServico;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MDFeStatusServicoSoap12;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MdfeCabecMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MdfeDadosMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.MdfeStatusServicoMDFResult;
import br.inf.portalfiscal.mdfe.wsdl.mdfestatusservico.ObjectFactory;
import com.fincatto.mdfe300.MDFeConfig;

class WSConsultaStatusServicoMDF {

    private static final String VERSAO_LEIAUTE = "3.00";
    private static final String SERVICO_SOLICITADO = "STATUS";
    private final MDFeConfig config;

    WSConsultaStatusServicoMDF(final MDFeConfig config) {
        this.config = config;
    }

    TRetConsStatServ consultaStatus() throws MalformedURLException {
        TConsStatServ consStatServ = new TConsStatServ();
        consStatServ.setTpAmb(this.config.getAmbiente().getCodigo());
        consStatServ.setVersao(VERSAO_LEIAUTE);
        consStatServ.setXServ(SERVICO_SOLICITADO);
        JAXBElement<TConsStatServ> tConsStatServ = new br.inf.portalfiscal.mdfe.ObjectFactory().createConsStatServMDFe(consStatServ);

        MdfeCabecMsg mdfeCabecMsg = new MdfeCabecMsg();
        mdfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        mdfeCabecMsg.setVersaoDados(VERSAO_LEIAUTE);

        MdfeDadosMsg mdfeDadosMsg = new MdfeDadosMsg();
        mdfeDadosMsg.getContent().add(tConsStatServ);
        Holder<MdfeCabecMsg> holder = new Holder<>(new ObjectFactory().createMdfeCabecMsg(mdfeCabecMsg).getValue());

        MDFeStatusServicoSoap12 port = new MDFeStatusServico(new URL(MDFAutorizador.MDFe.getMDFeStatusServico(this.config.getAmbiente()))).getMDFeStatusServicoSoap12();
        MdfeStatusServicoMDFResult result = port.mdfeStatusServicoMDF(mdfeDadosMsg, holder);

        return ((JAXBElement<TRetConsStatServ>) result.getContent().get(0)).getValue();
    }

}
