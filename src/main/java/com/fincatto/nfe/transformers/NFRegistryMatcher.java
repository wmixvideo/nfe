package com.fincatto.nfe.transformers;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.simpleframework.xml.transform.RegistryMatcher;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFFinalidade;
import com.fincatto.nfe.classes.NFFormaPagamento;
import com.fincatto.nfe.classes.NFProgramaEmissor;
import com.fincatto.nfe.classes.NFTipo;
import com.fincatto.nfe.classes.NFTipoEmissao;
import com.fincatto.nfe.classes.NFTipoImpressao;

public class NFRegistryMatcher extends RegistryMatcher {
	
	public NFRegistryMatcher() {
		super.bind(NFTipo.class, new NFTipoTransformer());
		super.bind(NFAmbiente.class, new NFAmbienteTransformer());
		super.bind(LocalDate.class, new NFLocalDateTransformer());
		super.bind(NFFinalidade.class, new NFFinalidadeTransformer());
		super.bind(NFTipoEmissao.class, new NFTipoEmissaoTransformer());
		super.bind(LocalDateTime.class, new NFLocalDateTimeTransformer());
		super.bind(NFTipoImpressao.class, new NFTipoImpressaoTransformer());
		super.bind(NFFormaPagamento.class, new NFFormaPagamentoTransformer());
		super.bind(NFProgramaEmissor.class, new NFProgramaEmissorTransformer());
		super.bind(NFUnidadeFederativa.class, new NFUnidadeFederativaTransformer());
	}
}