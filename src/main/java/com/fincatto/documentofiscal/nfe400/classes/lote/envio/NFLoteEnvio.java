package com.fincatto.documentofiscal.nfe400.classes.lote.envio;

import java.util.List;

import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;

@Root(name = "enviNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFLoteEnvio extends DFBase {
    private static final long serialVersionUID = 4208444639749964265L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "idLote", required = true)
    private String idLote;

    @Element(name = "indSinc", required = true)
    private NFLoteIndicadorProcessamento indicadorProcessamento;

    @ElementList(name = "NFe", inline = true, required = true)
    List<NFNota> notas;

    public String getIdLote() {
        return this.idLote;
    }

    public void setIdLote(final String idLote) {
        StringValidador.tamanho15N(idLote, "ID do Lote");
        this.idLote = idLote;
    }

    public void setNotas(final List<NFNota> notas) {
        ListValidador.tamanho50(notas, "Notas");
        this.notas = notas;
    }

    public List<NFNota> getNotas() {
        return this.notas;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public void setIndicadorProcessamento(final NFLoteIndicadorProcessamento indicadorProcessamento) {
        this.indicadorProcessamento = indicadorProcessamento;
    }

    public String getVersao() {
        return this.versao;
    }

    public NFLoteIndicadorProcessamento getIndicadorProcessamento() {
        return this.indicadorProcessamento;
    }
}