package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.statusservico.consulta.NFStatusServicoConsulta;
import com.fincatto.documentofiscal.nfe310.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.documentofiscal.nfe310.webservices.statusservico.consulta.NfeStatusServico2Stub;
import com.fincatto.documentofiscal.nfe310.webservices.statusservico.consulta.NfeStatusServicoStub;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;

class WSStatusConsulta {

    private static final String NOME_SERVICO = "STATUS";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSStatusConsulta.class);
    private final NFeConfig config;

    WSStatusConsulta(final NFeConfig config) {
        this.config = config;
    }

    NFStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(uf).toString());
        WSStatusConsulta.LOGGER.debug(omElementConsulta.toString());

        final boolean consultaNotaBahiaWorkaround = DFUnidadeFederativa.BA.equals(uf) && DFModelo.NFE.equals(modelo);
        final OMElement omElementResult = consultaNotaBahiaWorkaround ? this.efetuaConsultaStatusBahia(omElementConsulta) : this.efetuaConsultaStatus(omElementConsulta, uf, modelo);
        WSStatusConsulta.LOGGER.debug(omElementResult.toString());

        return new Persister(new DFRegistryMatcher(), new Format(0)).read(NFStatusServicoConsultaRetorno.class, omElementResult.toString());
    }

    private NFStatusServicoConsulta gerarDadosConsulta(final DFUnidadeFederativa unidadeFederativa) {
        final NFStatusServicoConsulta consStatServ = new NFStatusServicoConsulta();
        consStatServ.setUf(unidadeFederativa);
        consStatServ.setAmbiente(this.config.getAmbiente());
        consStatServ.setVersao(this.config.getVersao());
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private OMElement efetuaConsultaStatus(final OMElement omElement, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException {
        final NfeStatusServico2Stub.NfeCabecMsg cabec = new NfeStatusServico2Stub.NfeCabecMsg();
        cabec.setCUF(unidadeFederativa.getCodigoIbge());
        cabec.setVersaoDados(this.config.getVersao());

        final NfeStatusServico2Stub.NfeCabecMsgE cabecEnv = new NfeStatusServico2Stub.NfeCabecMsgE();
        cabecEnv.setNfeCabecMsg(cabec);

        final NfeStatusServico2Stub.NfeDadosMsg dados = new NfeStatusServico2Stub.NfeDadosMsg();
        dados.setExtraElement(omElement);

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = DFModelo.NFCE.equals(modelo) ? autorizador.getNfceStatusServico(this.config.getAmbiente()) : autorizador.getNfeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }
        return new NfeStatusServico2Stub(endpoint).nfeStatusServicoNF2(dados, cabecEnv).getExtraElement();
    }

    // este metodo teve que ser implementado pois a Bahia trata de forma diferente
    private OMElement efetuaConsultaStatusBahia(final OMElement omElement) throws RemoteException {
        final NfeStatusServicoStub.NfeCabecMsg cabec = new NfeStatusServicoStub.NfeCabecMsg();
        cabec.setCUF(DFUnidadeFederativa.BA.getCodigoIbge());
        cabec.setVersaoDados(this.config.getVersao());

        final NfeStatusServicoStub.NfeCabecMsgE cabecEnv = new NfeStatusServicoStub.NfeCabecMsgE();
        cabecEnv.setNfeCabecMsg(cabec);

        final NfeStatusServicoStub.NfeDadosMsg dados = new NfeStatusServicoStub.NfeDadosMsg();
        dados.setExtraElement(omElement);

        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(DFUnidadeFederativa.BA);
        final String endpoint = autorizador.getNfeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + DFModelo.NFE.name() + ", autorizador " + autorizador.name() + ", UF " + DFUnidadeFederativa.BA.name());
        }

        return new NfeStatusServicoStub(endpoint).nfeStatusServicoNF(dados, cabecEnv).getExtraElement();
    }
}
