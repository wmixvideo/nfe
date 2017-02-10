package com.fincatto.nfe310.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.ws.Holder;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.w3c.dom.Element;

import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.cadastro.NFConsultaCadastro;
import com.fincatto.nfe310.classes.cadastro.NFInfoConsultaCadastro;
import com.fincatto.nfe310.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.nfe310.converters.ElementStringConverter;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;

import br.inf.portalfiscal.nfe.wsdl.cadconsultacadastro2.svrs.CadConsultaCadastro2;
import br.inf.portalfiscal.nfe.wsdl.cadconsultacadastro2.svrs.CadConsultaCadastro2Soap;
import br.inf.portalfiscal.nfe.wsdl.cadconsultacadastro2.svrs.ConsultaCadastro2Result;
import br.inf.portalfiscal.nfe.wsdl.cadconsultacadastro2.svrs.NfeCabecMsg;
import br.inf.portalfiscal.nfe.wsdl.cadconsultacadastro2.svrs.NfeDadosMsg;
import br.inf.portalfiscal.nfe.wsdl.cadconsultacadastro2.svrs.ObjectFactory;

class WSConsultaCadastro {

    private static final String NOME_SERVICO = "CONS-CAD";
    private static final String VERSAO_SERVICO = "2.00";
    private final NFeConfig config;

    WSConsultaCadastro(final NFeConfig config) {
        this.config = config;
    }

    NFRetornoConsultaCadastro consultaCadastro(final String cnpj, final DFUnidadeFederativa uf) throws Exception {
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFRetornoConsultaCadastro.class, efetuaConsulta(gerarDadosConsulta(cnpj, uf).toString(), uf));
    }

    private NFConsultaCadastro gerarDadosConsulta(final String cnpj, final DFUnidadeFederativa uf) {
        final NFConsultaCadastro consulta = new NFConsultaCadastro();
        consulta.setVersao(WSConsultaCadastro.VERSAO_SERVICO);
        consulta.setConsultaCadastro(new NFInfoConsultaCadastro());
        consulta.getConsultaCadastro().setCnpj(cnpj);
        consulta.getConsultaCadastro().setServico(WSConsultaCadastro.NOME_SERVICO);
        consulta.getConsultaCadastro().setUf(uf.getCodigo());
        return consulta;
    }

    private String efetuaConsulta(final String xml, final DFUnidadeFederativa uf) throws RemoteException, MalformedURLException {
        final NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();
        nfeCabecMsg.setCUF(uf.getCodigoIbge());
        nfeCabecMsg.setVersaoDados(WSConsultaCadastro.VERSAO_SERVICO);

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(ElementStringConverter.read(xml));

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(uf);
        if (autorizador == null) {
            throw new IllegalStateException(String.format("UF %s nao possui autorizador para este servico", uf.getDescricao()));
        }
        final String endpoint = autorizador.getConsultaCadastro(this.config.getAmbiente());

        CadConsultaCadastro2Soap port = new CadConsultaCadastro2(new URL(endpoint)).getCadConsultaCadastro2Soap12();
        Holder<NfeCabecMsg> holderNfeCabecMsg = new Holder<>(new ObjectFactory().createNfeCabecMsg());
        ConsultaCadastro2Result result = port.consultaCadastro2(nfeDadosMsg, holderNfeCabecMsg);

        return ElementStringConverter.write((Element) result.getContent().get(0));
    }

}
