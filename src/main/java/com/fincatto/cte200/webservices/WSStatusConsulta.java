package com.fincatto.cte200.webservices;

import java.rmi.RemoteException;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.cte200.CTeConfig;
import com.fincatto.cte200.classes.CTAutorizador;
import com.fincatto.cte200.classes.statusservico.consulta.CTStatusServicoConsulta;
import com.fincatto.cte200.classes.statusservico.consulta.CTStatusServicoConsultaRetorno;
import com.fincatto.cte200.transformers.CTRegistryMatcher;
import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import java.net.MalformedURLException;

class WSStatusConsulta {

    private static final String NOME_SERVICO = "STATUS";
    private static final Logger LOGGER = LoggerFactory.getLogger(WSStatusConsulta.class);
    private final CTeConfig config;

    WSStatusConsulta(final CTeConfig config) {
        this.config = config;
    }

    CTStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
        return new Persister(new CTRegistryMatcher(), new Format(0)).read(CTStatusServicoConsultaRetorno.class, efetuaConsultaStatus(this.config.getAmbiente(), gerarDadosConsulta().toString(), uf, modelo));

    }

    private CTStatusServicoConsulta gerarDadosConsulta() {
        final CTStatusServicoConsulta consStatServ = new CTStatusServicoConsulta();
        consStatServ.setAmbiente(this.config.getAmbiente());
        consStatServ.setVersao(CTeConfig.VERSAO_CTE);
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private String efetuaConsultaStatus(final DFAmbiente ambiente, final String xml, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws RemoteException, MalformedURLException {
        final CTAutorizador autorizador = CTAutorizador.valueOfCodigoUF(unidadeFederativa);
        return autorizador.efetuaConsultaStatus(ambiente, xml, unidadeFederativa, modelo);
    }

}