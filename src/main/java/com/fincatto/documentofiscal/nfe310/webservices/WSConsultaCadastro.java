package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFConsultaCadastro;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFInfoConsultaCadastro;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.documentofiscal.nfe310.webservices.gerado.CadConsultaCadastro2Stub;
import com.fincatto.documentofiscal.nfe310.webservices.gerado.CadConsultaCadastro2Stub.NfeCabecMsg;
import com.fincatto.documentofiscal.nfe310.webservices.gerado.CadConsultaCadastro2Stub.NfeCabecMsgE;
import com.fincatto.documentofiscal.nfe310.webservices.gerado.CadConsultaCadastro2Stub.NfeDadosMsg;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.rmi.RemoteException;

class WSConsultaCadastro implements DFLog {
    
    private static final String NOME_SERVICO = "CONS-CAD";
    private static final String VERSAO_SERVICO = "2.00";
    private final NFeConfig config;
    
    WSConsultaCadastro(final NFeConfig config) {
        this.config = config;
    }
    
    NFRetornoConsultaCadastro consultaCadastro(final String cnpj, final DFUnidadeFederativa uf) throws Exception {
        final NFConsultaCadastro dadosConsulta = this.getDadosConsulta(cnpj, uf);
        final String xmlConsulta = dadosConsulta.toString();
        this.getLogger().debug(xmlConsulta);
        
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(xmlConsulta);
        final OMElement resultado = this.efetuaConsulta(uf, omElementConsulta);
        this.getLogger().debug(resultado.toString());
        
        return this.config.getPersister().read(NFRetornoConsultaCadastro.class, resultado.toString());
    }
    
    private OMElement efetuaConsulta(final DFUnidadeFederativa uf, final OMElement omElementConsulta) throws RemoteException {
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
        return new CadConsultaCadastro2Stub(autorizador.getConsultaCadastro(this.config.getAmbiente()), config).consultaCadastro2(nfeDadosMsg, cabecE).getExtraElement();
    }
    
    private NFConsultaCadastro getDadosConsulta(final String cnpj, final DFUnidadeFederativa uf) {
        final NFConsultaCadastro consulta = new NFConsultaCadastro();
        consulta.setVersao(WSConsultaCadastro.VERSAO_SERVICO);
        consulta.setConsultaCadastro(new NFInfoConsultaCadastro());
        consulta.getConsultaCadastro().setCnpj(cnpj);
        consulta.getConsultaCadastro().setServico(WSConsultaCadastro.NOME_SERVICO);
        consulta.getConsultaCadastro().setUf(uf.getCodigo());
        return consulta;
    }
}
