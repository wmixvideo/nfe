package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.nota.CTeNotaInfoCTeNormalInfoModalAereo;
import com.fincatto.documentofiscal.cte300.classes.nota.CTeNotaInfoCTeNormalInfoModalAquaviario;
import com.fincatto.documentofiscal.cte300.classes.nota.CTeNotaInfoCTeNormalInfoModalFerroviario;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Eldevan Nery Junior on 01/11/17.
 */
@Root(name = "infModal")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfoModal extends DFBase {

    @Attribute(name = "versaoModal")
    private String versao;

    @Element(name = "rodo", required = false)
    private MDFInfoModalRodoviario rodoviario;

    @Element(name = "aereo", required = false)
    private CTeNotaInfoCTeNormalInfoModalAereo aereo;

    @Element(name = "aquav", required = false)
    private CTeNotaInfoCTeNormalInfoModalAquaviario aquaviario;

    @Element(name = "ferrov", required = false)
    private CTeNotaInfoCTeNormalInfoModalFerroviario ferroviario;


}
