package com.fincatto.documentofiscal.cte400.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;


@Root(name = "infPercurso")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoIdentificacaoUfPercurso extends DFBase {
    private static final long serialVersionUID = -8756073376187638453L;

    @Element(name = "UFPer")
    private String ufPercurso;

    public CTeOSInfoIdentificacaoUfPercurso() {
    }

    public CTeOSInfoIdentificacaoUfPercurso(final DFUnidadeFederativa ufPercurso) {
        this.ufPercurso = ufPercurso.getCodigo();
    }

    public String getUfPercurso() {
        return this.ufPercurso;
    }

    public void setUfPercurso(final String ufPercurso) {
        this.ufPercurso = ufPercurso;
    }

    public void setUfPercurso(final DFUnidadeFederativa ufPercurso) {
        this.ufPercurso = ufPercurso.getCodigo();
    }
}
