package com.fincatto.nfe310.webservices;

import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.cadastro.NFConsultaCadastro;
import com.fincatto.nfe310.classes.cadastro.NFInfoConsultaCadastro;
import com.fincatto.nfe310.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.fincatto.nfe310.webservices.gerado.CadConsultaCadastro2Stub;
import com.fincatto.nfe310.webservices.gerado.CadConsultaCadastro2Stub.NfeCabecMsg;
import com.fincatto.nfe310.webservices.gerado.CadConsultaCadastro2Stub.NfeCabecMsgE;
import com.fincatto.nfe310.webservices.gerado.CadConsultaCadastro2Stub.NfeDadosMsg;

class WSConsultaCadastro {
    private static final Logger LOG = Logger.getLogger(WSConsultaCadastro.class);
    private static final String NOME_SERVICO = "CONS-CAD";
    private static final String VERSAO_SERVICO = "2.00";
    private final NFeConfig config;

    public WSConsultaCadastro(final NFeConfig config) {
        this.config = config;
    }

    public NFRetornoConsultaCadastro consultaCadastro(final String cnpj, final NFUnidadeFederativa uf) throws Exception {
        final NFConsultaCadastro dadosConsulta = this.getDadosConsulta(cnpj, uf);
        final String xmlConsulta = dadosConsulta.toString();
        WSConsultaCadastro.LOG.debug(xmlConsulta);

        final OMElement omElementConsulta = AXIOMUtil.stringToOM(xmlConsulta);
        final OMElement resultado = this.efetuaConsulta(uf, omElementConsulta);

        final String retornoConsulta = resultado.toString();
        WSConsultaCadastro.LOG.debug(retornoConsulta);
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFRetornoConsultaCadastro.class, retornoConsulta);
    }

    private OMElement efetuaConsulta(final NFUnidadeFederativa uf, final OMElement omElementConsulta) throws RemoteException, AxisFault {
        final CadConsultaCadastro2Stub.NfeCabecMsg cabec = new NfeCabecMsg();
        cabec.setCUF(uf.getCodigoIbge());
        cabec.setVersaoDados(WSConsultaCadastro.VERSAO_SERVICO);

        final NfeCabecMsgE cabecE = new NfeCabecMsgE();
        cabecE.setNfeCabecMsg(cabec);

        final NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.setExtraElement(omElementConsulta);
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(uf);
        if (autorizador == null) {
            throw new IllegalStateException(String.format("UF %s nao possui autorizador para este servico", uf.getDescricao()));
        }
        final String url = autorizador.getConsultaCadastro(this.config.getAmbiente());
        WSConsultaCadastro.LOG.debug(String.format("Endpoint: %s", url));
        return new CadConsultaCadastro2Stub(url).consultaCadastro2(nfeDadosMsg, cabecE).getExtraElement();
    }

    private NFConsultaCadastro getDadosConsulta(final String cnpj, final NFUnidadeFederativa uf) {
        final NFConsultaCadastro consulta = new NFConsultaCadastro();
        consulta.setVersao(WSConsultaCadastro.VERSAO_SERVICO);
        consulta.setConsultaCadastro(new NFInfoConsultaCadastro());
        consulta.getConsultaCadastro().setCnpj(cnpj);
        consulta.getConsultaCadastro().setServico(WSConsultaCadastro.NOME_SERVICO);
        consulta.getConsultaCadastro().setUf(uf.getCodigo());
        return consulta;
    }
}