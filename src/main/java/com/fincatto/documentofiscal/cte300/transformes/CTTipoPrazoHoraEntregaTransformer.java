package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoHoraEntrega;

public class CTTipoPrazoHoraEntregaTransformer implements Transform<CTTipoPrazoHoraEntrega> {

    @Override
    public CTTipoPrazoHoraEntrega read(final String arg0) throws Exception {
        return CTTipoPrazoHoraEntrega.valueOfCodigo(arg0);
    }

    @Override
    public String write(final CTTipoPrazoHoraEntrega arg0) throws Exception {
        return arg0.getCodigo();
    }

}
