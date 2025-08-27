package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoHoraEntrega;
import org.simpleframework.xml.transform.Transform;

public class CTTipoPrazoHoraEntregaTransformer implements Transform<CTTipoPrazoHoraEntrega> {

    @Override
    public CTTipoPrazoHoraEntrega read(final String arg0) {
        return CTTipoPrazoHoraEntrega.valueOfCodigo(arg0);
    }

    @Override
    public String write(final CTTipoPrazoHoraEntrega arg0) {
        return arg0.getCodigo();
    }

}
