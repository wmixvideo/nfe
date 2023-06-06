package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTTomadorServico;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Indicador do "papel" do tomador do serviço no CT-e
 */

@Root(name = "toma3")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoIdentificacaoTomadorServico3 extends DFBase {
    private static final long serialVersionUID = -9149467113415654808L;

    @Element(name = "toma", required = false)
    private CTTomadorServico tomadorServico;

    public CTTomadorServico getTomadorServico() {
        return this.tomadorServico;
    }

    /**
     * Tomador do Serviço 0-Remetente; 1-Expedidor; 2-Recebedor; 3-Destinatário Serão utilizadas as informações contidas no respectivo grupo, conforme indicado pelo conteúdo deste campo
     */
    public void setTomadorServico(final CTTomadorServico tomadorServico) {
        if (!CTTomadorServico.TOMADOR_3.contains(tomadorServico)) {
            throw new IllegalArgumentException("O tomador do servico não é válido para este papel");
        }
        this.tomadorServico = tomadorServico;
    }
}
