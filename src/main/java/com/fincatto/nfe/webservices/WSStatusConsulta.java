package com.fincatto.nfe.webservices;

import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe.NFeConfig;
import com.fincatto.nfe.classes.NFAutorizador31;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.classes.statusservico.consulta.NFStatusServicoConsulta;
import com.fincatto.nfe.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.nfe.transformers.NFRegistryMatcher;
import com.fincatto.nfe.webservices.statusservico.consulta.NfeStatusServico2Stub;

class WSStatusConsulta {

    private static final String NOME_SERVICO = "STATUS";
    private static final Logger log = Logger.getLogger(WSStatusConsulta.class);
    private final NFeConfig config;

    public WSStatusConsulta(final NFeConfig config) {
        this.config = config;
    }

    public NFStatusServicoConsultaRetorno consultaStatus(final NFUnidadeFederativa uf) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(uf).toString());
        WSStatusConsulta.log.info(omElementConsulta);

        final OMElement omElementResult = this.efetuaConsultaStatus(omElementConsulta, uf);
        WSStatusConsulta.log.info(omElementResult.toString());

        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFStatusServicoConsultaRetorno.class, omElementResult.toString());
    }

    private NFStatusServicoConsulta gerarDadosConsulta(final NFUnidadeFederativa unidadeFederativa) {
        final NFStatusServicoConsulta consStatServ = new NFStatusServicoConsulta();
        consStatServ.setUf(unidadeFederativa);
        consStatServ.setAmbiente(this.config.getAmbiente());
        consStatServ.setVersao(NFeConfig.VERSAO_NFE);
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private OMElement efetuaConsultaStatus(final OMElement omElement, final NFUnidadeFederativa unidadeFederativa) throws AxisFault, RemoteException {
        final NfeStatusServico2Stub.NfeCabecMsg cabec = new NfeStatusServico2Stub.NfeCabecMsg();
        cabec.setCUF(unidadeFederativa.getCodigoIbge());
        cabec.setVersaoDados(NFeConfig.VERSAO_NFE);

        final NfeStatusServico2Stub.NfeCabecMsgE cabecEnv = new NfeStatusServico2Stub.NfeCabecMsgE();
        cabecEnv.setNfeCabecMsg(cabec);

        final NfeStatusServico2Stub.NfeDadosMsg dados = new NfeStatusServico2Stub.NfeDadosMsg();
        dados.setExtraElement(omElement);

        final NfeStatusServico2Stub.NfeStatusServicoNF2Result result = new NfeStatusServico2Stub(NFAutorizador31.valueOfCodigoUF(unidadeFederativa).getNfeStatusServico(this.config.getAmbiente())).nfeStatusServicoNF2(dados, cabecEnv);
        return result.getExtraElement();
    }
}