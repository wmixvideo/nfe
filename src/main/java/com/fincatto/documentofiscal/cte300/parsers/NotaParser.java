package com.fincatto.documentofiscal.cte300.parsers;

import org.simpleframework.xml.core.Persister;

import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLote;
import com.fincatto.documentofiscal.cte300.persister.CTPersister;


public class NotaParser {

	private final Persister persister;
		 
	public NotaParser() {
	    this.persister = new CTPersister();
	}
	
	public CTeEnvioLote cteRecepcaoParaObjeto(final String xml) {
        try {
            return this.persister.read(CTeEnvioLote.class, xml);
        } catch (final Exception e) {
            throw new IllegalArgumentException(String.format("Nao foi possivel parsear o xml: %s", e.getMessage()));
        }
	}
}
