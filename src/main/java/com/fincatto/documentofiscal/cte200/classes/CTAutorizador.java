package com.fincatto.documentofiscal.cte200.classes;

import com.fincatto.documentofiscal.DFAmbiente;

/**
 * <h1>URLs dos serviços</h1><br>
 * <a href="http://hom.nfe.fazenda.gov.br/portal/webServices.aspx?tipoConteudo=Wak0FwB7dKs=">NFE Homologação</a><br>
 * <a href="http://www.nfe.fazenda.gov.br/portal/webServices.aspx?tipoConteudo=Wak0FwB7dKs=">NFE Produção</a><br>
 * <br>
 * <a href="http://nfce.encat.org/desenvolvedor/webservices-h">NFCE Homologação</a><br>
 * <a href="http://nfce.encat.org/desenvolvedor/webservices-p">NFCE Produção</a>
 */
public enum CTAutorizador {

    AN {
        @Override
        public String getDistribuicaoDFe(final DFAmbiente ambiente) {
            return DFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx" : "https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx";
        }
    };

    public abstract String getDistribuicaoDFe(final DFAmbiente ambiente);

}