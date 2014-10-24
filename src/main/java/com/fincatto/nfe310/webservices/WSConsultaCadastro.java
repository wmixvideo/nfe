package com.fincatto.nfe310.webservices;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.cadastro.NFConsultaCadastro;
import com.fincatto.nfe310.classes.cadastro.NFInfoConsultaCadastro;
import com.fincatto.nfe310.webservices.gerado.CadConsultaCadastro2Stub;
import com.fincatto.nfe310.webservices.gerado.CadConsultaCadastro2Stub.ConsultaCadastro2Result;
import com.fincatto.nfe310.webservices.gerado.CadConsultaCadastro2Stub.NfeCabecMsg;
import com.fincatto.nfe310.webservices.gerado.CadConsultaCadastro2Stub.NfeCabecMsgE;
import com.fincatto.nfe310.webservices.gerado.CadConsultaCadastro2Stub.NfeDadosMsg;

public class WSConsultaCadastro {

    private final NFeConfig config;

    public WSConsultaCadastro(final NFeConfig config) {
        this.config = config;
    }

    public void consultaCadastro(final String cnpj) throws Exception {
        final NFConsultaCadastro dadosConsulta = this.getDadosConsulta(cnpj);
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(dadosConsulta.toString());
        System.out.println(omElementConsulta.toString());
        // final XMLStreamReader dadosXML = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(dadosMsg.toString()));
        // final CadConsultaCadastro2Stub.NfeDadosMsg nfeDadosMsg = CadConsultaCadastro2Stub.NfeDadosMsg.Factory.parse(dadosXML);

        final CadConsultaCadastro2Stub.NfeCabecMsg cabec = new NfeCabecMsg();
        cabec.setCUF(this.config.getCUF().getCodigo());
        cabec.setVersaoDados("2.00");

        final NfeCabecMsgE cabecE = new NfeCabecMsgE();
        cabecE.setNfeCabecMsg(cabec);

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.setExtraElement(omElementConsulta);

        final String url = NFAutorizador31.valueOfCodigoUF(this.config.getCUF()).getConsultaCadastro(this.config.getAmbiente());
        final ConsultaCadastro2Result consultaCadastroResult = new CadConsultaCadastro2Stub(url).consultaCadastro2(nfeDadosMsg, cabecE);
        System.out.println(consultaCadastroResult.getExtraElement().toString());
    }

    private NFConsultaCadastro getDadosConsulta(final String cnpj) {
        final NFConsultaCadastro consulta = new NFConsultaCadastro();
        consulta.setVersao("2.00");
        consulta.setConsultaCadastro(new NFInfoConsultaCadastro());
        consulta.getConsultaCadastro().setCnpj(cnpj);
        consulta.getConsultaCadastro().setServico("CONS-CAD");
        consulta.getConsultaCadastro().setUf(this.config.getCUF().getCodigo());
        return consulta;
    }
}