package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTomadorServico;

/**
 * @author Caio
 * @info Indicador do "papel" do tomador do serviço no CT-e
 * */

@Root(name = "toma3")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoIdentificacaoTomadorServico3 extends DFBase {
	
	@Element(name = "toma", required = false)
	private CTTomadorServico tomadorServico;

	public CTeNotaInfoIdentificacaoTomadorServico3() {
		this.tomadorServico = null;
	}

	public CTTomadorServico getTomadorServico() {
		return tomadorServico;
	}

	/**
	 * Tomador do Serviço 
	 * 0-Remetente;
	 * 1-Expedidor;
	 * 2-Recebedor;
	 * 3-Destinatário 
	 * Serão utilizadas as informações contidas no respectivo grupo, conforme indicado pelo conteúdo deste campo
	 * */
	public void setTomadorServico(CTTomadorServico tomadorServico) {
		this.tomadorServico = tomadorServico;
	}
}
