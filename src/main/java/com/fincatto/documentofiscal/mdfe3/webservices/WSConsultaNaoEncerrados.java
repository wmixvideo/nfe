package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados.MDFeConsultaNaoEncerrados;
import com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados.MDFeConsultaNaoEncerradosRetorno;
import com.fincatto.documentofiscal.mdfe3.webservices.consultanaoencerrado.MDFeConsNaoEncStub;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.rmi.RemoteException;

/**
 * Created by Eldevan Nery Junior on 22/11/17.
 * Classe para envio do pedido de Consulta  do Servico de  MDF-e's nao encerrados.
 */
class WSConsultaNaoEncerrados implements DFLog {
    
    private static final String NOME_SERVICO = "CONSULTAR NÃO ENCERRADOS";
    private final MDFeConfig config;
    
    WSConsultaNaoEncerrados(final MDFeConfig config) {
        this.config = config;
    }
    
    MDFeConsultaNaoEncerradosRetorno consultaNaoEncerrados(final String cnpj) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(cnpj).toString());
        this.getLogger().debug(omElementConsulta.toString());
        
        final OMElement omElementResult = this.efetuaConsultaStatus(omElementConsulta);
        this.getLogger().debug(omElementResult.toString());
        
        return this.config.getPersister().read(MDFeConsultaNaoEncerradosRetorno.class, omElementResult.toString());
    }
    
    private MDFeConsultaNaoEncerrados gerarDadosConsulta(final String cnpj) {
        final MDFeConsultaNaoEncerrados encerrados = new MDFeConsultaNaoEncerrados();
        encerrados.setAmbiente(this.config.getAmbiente());
        encerrados.setVersao(MDFeConfig.VERSAO);
        encerrados.setCnpj(cnpj);
        encerrados.setServico(WSConsultaNaoEncerrados.NOME_SERVICO);
        return encerrados;
    }
    
    private OMElement efetuaConsultaStatus(final OMElement omElement) throws RemoteException {
        final MDFeConsNaoEncStub.MdfeCabecMsg cabec = new MDFeConsNaoEncStub.MdfeCabecMsg();
        cabec.setCUF(this.config.getCUF().getCodigoIbge());
        cabec.setVersaoDados(MDFeConfig.VERSAO);
        
        final MDFeConsNaoEncStub.MdfeCabecMsgE cabecEnv = new MDFeConsNaoEncStub.MdfeCabecMsgE();
        cabecEnv.setMdfeCabecMsg(cabec);
        
        final MDFeConsNaoEncStub.MdfeDadosMsg dados = new MDFeConsNaoEncStub.MdfeDadosMsg();
        dados.setExtraElement(omElement);
        
        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeConsNaoEnc(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para CONSULTAR NAO ENCERRADOS, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        this.getLogger().debug(endpoint);
        final MDFeConsNaoEncStub.MdfeConsNaoEncResult result = new MDFeConsNaoEncStub(endpoint, config).mdfeConsNaoEnc(dados, cabecEnv);
        return result.getExtraElement();
    }
}
