package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTTipoFretamento;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.time.ZonedDateTime;

@Root(name = "infFretamento")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoModalRodoviarioFretamento extends DFBase {
    private static final long serialVersionUID = 8999239864502092146L;

    @Element(name = "tpFretamento")
    private CTTipoFretamento tipoFretamento;

    @Element(name = "dhViagem", required = false)
    private ZonedDateTime dataHoraViagem;

    public CTTipoFretamento getTipoFretamento() {
        return tipoFretamento;
    }

    public void setTipoFretamento(final CTTipoFretamento tipoFretamento) {
        this.tipoFretamento = tipoFretamento;
    }

    public ZonedDateTime getDataHoraViagem() {
        return dataHoraViagem;
    }

    public void setDataHoraViagem(final ZonedDateTime dataHoraViagem) {
        this.dataHoraViagem = dataHoraViagem;
    }
}
