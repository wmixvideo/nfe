package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTCodigoSituacaoTributariaICMS;

/**
 * @author Caio
 * @info ICMS Isento, não Tributado ou diferido
 */

@Root(name = "ICMS45")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoInformacoesRelativasImpostosICMS45 extends DFBase {
    private static final long serialVersionUID = 7637372648460225698L;

    @Element(name = "CST", required = true)
    private CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria;

    public CTeNotaInfoInformacoesRelativasImpostosICMS45() {
        this.codigoSituacaoTributaria = null;
    }

    public CTCodigoSituacaoTributariaICMS getCodigoSituacaoTributaria() {
        return this.codigoSituacaoTributaria;
    }

    /**
     * Classificação Tributária do Serviço<br>
     * Preencher com:<br>
     * 40 - ICMS isenção;<br>
     * 41 - ICMS não tributada;<br>
     * 51 - ICMS diferido
     */
    public void setCodigoSituacaoTributaria(final CTCodigoSituacaoTributariaICMS codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }
}
