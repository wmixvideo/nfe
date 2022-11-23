package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.documentofiscal.nfe310.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.documentofiscal.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe310.webservices.gerado.NfeConsulta2Stub;
import com.fincatto.documentofiscal.nfe310.webservices.gerado.NfeConsulta2Stub.NfeConsultaNF2Result;
import com.fincatto.documentofiscal.nfe310.webservices.nota.consulta.NfeConsultaStub;
import com.fincatto.documentofiscal.nfe310.webservices.nota.consulta.NfeConsultaStub.NfeConsultaNFResult;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;
import java.rmi.RemoteException;

class WSNotaConsulta implements DFLog {
    
    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "3.10";
    private final NFeConfig config;
    
    WSNotaConsulta(final NFeConfig config) {
        this.config = config;
    }
    
    NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveDeAcesso).toString());
        this.getLogger().debug(omElementConsulta.toString());
        
        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta, chaveDeAcesso);
        this.getLogger().debug(omElementRetorno.toString());
        
        return this.config.getPersister().read(NFNotaConsultaRetorno.class, omElementRetorno.toString());
    }
    
    private OMElement efetuaConsulta(final OMElement omElementConsulta, final String chaveDeAcesso) throws Exception {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);
        
        final boolean consultaNFeBahia = DFUnidadeFederativa.BA.equals(notaFiscalChaveParser.getNFUnidadeFederativa()) && DFModelo.NFE.equals(notaFiscalChaveParser.getModelo());
        if (consultaNFeBahia) {
            return this.efetuaConsultaBA(omElementConsulta, chaveDeAcesso);
        } else {
            return this.efetuaConsultaSVRS(omElementConsulta, chaveDeAcesso);
        }
    }
    
    private OMElement efetuaConsultaSVRS(final OMElement omElementConsulta, final String chaveDeAcesso) throws RemoteException {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);
        final NfeConsulta2Stub.NfeCabecMsg cabec = new NfeConsulta2Stub.NfeCabecMsg();
        cabec.setCUF(notaFiscalChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados(WSNotaConsulta.VERSAO_SERVICO);
        
        final NfeConsulta2Stub.NfeCabecMsgE cabecE = new NfeConsulta2Stub.NfeCabecMsgE();
        cabecE.setNfeCabecMsg(cabec);
        
        final NfeConsulta2Stub.NfeDadosMsg dados = new NfeConsulta2Stub.NfeDadosMsg();
        dados.setExtraElement(omElementConsulta);
        
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = DFModelo.NFCE.equals(notaFiscalChaveParser.getModelo()) ? autorizador.getNfceConsultaProtocolo(this.config.getAmbiente()) : autorizador.getNfeConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo " + notaFiscalChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }
        
        final NfeConsultaNF2Result consultaNF2Result = new NfeConsulta2Stub(endpoint, config).nfeConsultaNF2(dados, cabecE);
        return consultaNF2Result.getExtraElement();
    }
    
    private OMElement efetuaConsultaBA(final OMElement omElementConsulta, final String chaveDeAcesso) throws RemoteException {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);
        final NfeConsultaStub.NfeCabecMsg cabec = new NfeConsultaStub.NfeCabecMsg();
        cabec.setCUF(notaFiscalChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados(WSNotaConsulta.VERSAO_SERVICO);
        
        final NfeConsultaStub.NfeCabecMsgE cabecE = new NfeConsultaStub.NfeCabecMsgE();
        cabecE.setNfeCabecMsg(cabec);
        
        final NfeConsultaStub.NfeDadosMsg dados = new NfeConsultaStub.NfeDadosMsg();
        dados.setExtraElement(omElementConsulta);
        
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = DFModelo.NFCE.equals(notaFiscalChaveParser.getModelo()) ? autorizador.getNfceConsultaProtocolo(this.config.getAmbiente()) : autorizador.getNfeConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo " + notaFiscalChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }
        
        final NfeConsultaNFResult consultaNFResult = new NfeConsultaStub(endpoint, config).nfeConsultaNF(dados, cabecE);
        return consultaNFResult.getExtraElement();
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
