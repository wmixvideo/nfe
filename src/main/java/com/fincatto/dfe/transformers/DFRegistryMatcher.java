package com.fincatto.dfe.transformers;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.simpleframework.xml.transform.RegistryMatcher;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFModelo;
import com.fincatto.dfe.classes.DFTipoEmissao;
import com.fincatto.dfe.classes.DFUnidadeFederativa;

public class DFRegistryMatcher extends RegistryMatcher {

    public DFRegistryMatcher() {
        super.bind(Date.class, new DFDateFormatTransformer());
        super.bind(LocalDate.class, new DFLocalDateTransformer());
        super.bind(LocalTime.class, new DFLocalTimeTransformer());
        super.bind(DateTime.class, new DFDateTimeTransformer());
        super.bind(LocalDateTime.class, new DFLocalDateTimeTransformer());
        super.bind(DFAmbiente.class, new DFAmbienteTransformer());
        super.bind(DFModelo.class, new DFModeloTransformer());
        super.bind(DFTipoEmissao.class, new DFTipoEmissaoTransformer());
        super.bind(DFUnidadeFederativa.class, new DFUnidadeFederativaTransformer());
    }
}