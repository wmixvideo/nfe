package com.fincatto.documentofiscal.mdfe3.classes.lote.envio;

import com.fincatto.documentofiscal.DFBase;

/**
 * Created by Eldevan Nery Junior on 14/11/17.
 *
 * Retorno do envio de Lote MDF-e.
 *
 */
public class MDFEnvioLoteRetornoDados extends DFBase {

    private final MDFEnvioLoteRetorno retorno;
    private final MDFEnvioLote loteAssinado;

	public MDFEnvioLoteRetornoDados(MDFEnvioLoteRetorno retorno, MDFEnvioLote loteAssinado) {
		this.retorno = retorno;
		this.loteAssinado = loteAssinado;
	}

	public MDFEnvioLoteRetorno getRetorno() {
		return retorno;
	}

	public MDFEnvioLote getLoteAssinado() {
		return loteAssinado;
	}
}
