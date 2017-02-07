package com.fincatto.mdfe300.webservices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.Holder;

import com.fincatto.mdfe300.MDFeConfig;
import com.fincatto.mdfe300.classes.MDFAutorizador;

import br.inf.portalfiscal.mdfe.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.TRetConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsnaoenc.MDFeConsNaoEnc;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsnaoenc.MDFeConsNaoEncSoap12;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsnaoenc.MdfeCabecMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsnaoenc.MdfeConsNaoEncResult;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsnaoenc.MdfeDadosMsg;
import br.inf.portalfiscal.mdfe.wsdl.mdfeconsnaoenc.ObjectFactory;

class WSConsultaNaoEncerradosMDF {

    private static final String VERSAO_LEIAUTE = "3.00";
    private static final String SERVICO_SOLICITADO = "CONSULTAR NÃO ENCERRADOS";
    private final MDFeConfig config;

    WSConsultaNaoEncerradosMDF(final MDFeConfig config) {
        this.config = config;
    }

    TRetConsMDFeNaoEnc consultaNaoEncerrados(final String cnpjEmitente) throws MalformedURLException {
        TConsMDFeNaoEnc consMDFeNaoEnc = new TConsMDFeNaoEnc();
        consMDFeNaoEnc.setTpAmb(this.config.getAmbiente().getCodigo());
        consMDFeNaoEnc.setVersao(VERSAO_LEIAUTE);
        consMDFeNaoEnc.setXServ(SERVICO_SOLICITADO);
        consMDFeNaoEnc.setCNPJ(cnpjEmitente);

        JAXBElement<TConsMDFeNaoEnc> tConsMDFeNaoEnc = new br.inf.portalfiscal.mdfe.ObjectFactory().createConsMDFeNaoEnc(consMDFeNaoEnc);

        MdfeCabecMsg mdfeCabecMsg = new MdfeCabecMsg();
        mdfeCabecMsg.setCUF(this.config.getCUF().getCodigoIbge());
        mdfeCabecMsg.setVersaoDados(VERSAO_LEIAUTE);

        MdfeDadosMsg mdfeDadosMsg = new MdfeDadosMsg();
        mdfeDadosMsg.getContent().add(tConsMDFeNaoEnc);
        Holder<MdfeCabecMsg> holder = new Holder<>(new ObjectFactory().createMdfeCabecMsg(mdfeCabecMsg).getValue());

        MDFeConsNaoEncSoap12 port = new MDFeConsNaoEnc(new URL(MDFAutorizador.MDFe.getMDFeConsNaoEnc(this.config.getAmbiente()))).getMDFeConsNaoEncSoap12();
        MdfeConsNaoEncResult result = port.mdfeConsNaoEnc(mdfeDadosMsg, holder);

        return ((JAXBElement<TRetConsMDFeNaoEnc>) result.getContent().get(0)).getValue();
    }

}
