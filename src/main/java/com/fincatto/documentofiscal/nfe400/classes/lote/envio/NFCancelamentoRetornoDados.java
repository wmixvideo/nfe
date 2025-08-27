package com.fincatto.documentofiscal.nfe400.classes.lote.envio;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento.NFProtocoloEventoCancelamento;

/**
 * @author Aguinaldo Fryder <aguinaldo@publitechsistemas.com.br>
 * @since 30/06/23
 */
public class NFCancelamentoRetornoDados {

    private NFEnviaEventoRetorno retorno;

    private NFProtocoloEventoCancelamento protocolo;

    public NFCancelamentoRetornoDados(NFEnviaEventoRetorno retorno,
        NFProtocoloEventoCancelamento protocolo) {
        this.retorno = retorno;
        this.protocolo = protocolo;
    }

    public NFEnviaEventoRetorno getRetorno() {
        return retorno;
    }

    public void setRetorno(NFEnviaEventoRetorno retorno) {
        this.retorno = retorno;
    }

    public NFProtocoloEventoCancelamento getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(NFProtocoloEventoCancelamento protocolo) {
        this.protocolo = protocolo;
    }
}
