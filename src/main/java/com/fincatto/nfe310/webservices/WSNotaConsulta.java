package com.fincatto.nfe310.webservices;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.fincatto.nfe310.NFeConfig;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.nfe310.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.nfe310.transformers.NFRegistryMatcher;
import com.fincatto.nfe310.webservices.gerado.NfeConsulta2Stub;
import com.fincatto.nfe310.webservices.gerado.NfeConsulta2Stub.NfeConsultaNF2Result;

class WSNotaConsulta {
    private static final String NOME_SERVICO = "CONSULTAR";
    private final NFeConfig config;
    private static final String VERSAO_SERVICO = "3.10";
    private final static Logger LOG = Logger.getLogger(WSNotaConsulta.class);

    public WSNotaConsulta(final NFeConfig config) {
        this.config = config;
    }

    public NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveDeAcesso).toString());
        WSNotaConsulta.LOG.info(omElementConsulta);

        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta, chaveDeAcesso);
        WSNotaConsulta.LOG.info(omElementRetorno);
        return new Persister(new NFRegistryMatcher(), new Format(0)).read(NFNotaConsultaRetorno.class, omElementRetorno.toString());
    }

    private OMElement efetuaConsulta(final OMElement omElementConsulta, final String chaveDeAcesso) throws AxisFault, RemoteException {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);
        final NfeConsulta2Stub.NfeCabecMsg cabec = new NfeConsulta2Stub.NfeCabecMsg();
        cabec.setCUF(notaFiscalChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados(WSNotaConsulta.VERSAO_SERVICO);

        final NfeConsulta2Stub.NfeCabecMsgE cabecE = new NfeConsulta2Stub.NfeCabecMsgE();
        cabecE.setNfeCabecMsg(cabec);

        final NfeConsulta2Stub.NfeDadosMsg dados = new NfeConsulta2Stub.NfeDadosMsg();
        dados.setExtraElement(omElementConsulta);
        
        String endpoint;
        NFAutorizador31 aut = NFAutorizador31.valueOfChaveAcesso(chaveDeAcesso);
        if (NFModelo.NFCE.equals(notaFiscalChaveParser.getModelo())) {
        	endpoint = aut.getNfceConsultaProtocolo(config.getAmbiente());
        }else {
        	endpoint = aut.getNfeConsultaProtocolo(config.getAmbiente());        	
        }
        
        if (endpoint == null) {
        	throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo "+
        			notaFiscalChaveParser.getModelo().name()+", autorizador "+aut.name());
        }
        
        final NfeConsultaNF2Result consultaNF2Result = new NfeConsulta2Stub(endpoint).nfeConsultaNF2(dados, cabecE);
        return consultaNF2Result.getExtraElement();
    }

    private NFNotaConsulta gerarDadosConsulta(final String chaveDeAcesso) {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        notaConsulta.setAmbiente(this.config.getAmbiente());
        notaConsulta.setChave(chaveDeAcesso);
        notaConsulta.setServico(WSNotaConsulta.NOME_SERVICO);
        notaConsulta.setVersao(new BigDecimal(WSNotaConsulta.VERSAO_SERVICO));
        return notaConsulta;
    }
}