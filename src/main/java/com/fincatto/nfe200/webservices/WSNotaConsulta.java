package com.fincatto.nfe200.webservices;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe200.NFEConfig;
import com.fincatto.nfe200.classes.NFAutorizador;
import com.fincatto.nfe200.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.nfe200.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.nfe200.parsers.NotaFiscalChaveParser;
import com.fincatto.nfe200.transformers.NFRegistryMatcher;
import com.fincatto.nfe200.webservices.gerado.NfeConsulta2Stub;
import com.fincatto.nfe200.webservices.gerado.NfeConsulta2Stub.NfeConsultaNF2Result;

class WSNotaConsulta {
    private final NFEConfig config;
    private static final Logger LOG = Logger.getLogger(WSNotaConsulta.class);

    public WSNotaConsulta(final NFEConfig config) {
        this.config = config;
    }

    public NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveDeAcesso).toString());
        WSNotaConsulta.LOG.info(omElementConsulta);

        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta, new NotaFiscalChaveParser(chaveDeAcesso));
        WSNotaConsulta.LOG.info(omElementRetorno);
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFNotaConsultaRetorno.class, omElementRetorno.toString());
    }

    private OMElement efetuaConsulta(final OMElement omElementConsulta, final NotaFiscalChaveParser notaFiscalChaveParser) throws AxisFault, RemoteException {
        final NfeConsulta2Stub.NfeCabecMsg cabec = new NfeConsulta2Stub.NfeCabecMsg();
        cabec.setCUF(notaFiscalChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados("2.01");

        final NfeConsulta2Stub.NfeCabecMsgE cabecE = new NfeConsulta2Stub.NfeCabecMsgE();
        cabecE.setNfeCabecMsg(cabec);

        final NfeConsulta2Stub.NfeDadosMsg dados = new NfeConsulta2Stub.NfeDadosMsg();
        dados.setExtraElement(omElementConsulta);
        final NfeConsultaNF2Result consultaNF2Result = new NfeConsulta2Stub(NFAutorizador.valueOfCodigoUF(notaFiscalChaveParser.getNFUnidadeFederativa()).getNfeConsultaProtocolo(this.config.getAmbiente())).nfeConsultaNF2(dados, cabecE);
        return consultaNF2Result.getExtraElement();
    }

    private NFNotaConsulta gerarDadosConsulta(final String chaveDeAcesso) {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        notaConsulta.setAmbiente(this.config.getAmbiente());
        notaConsulta.setChave(chaveDeAcesso);
        notaConsulta.setServico("CONSULTAR");
        notaConsulta.setVersao(new BigDecimal("2.01"));
        return notaConsulta;
    }
}