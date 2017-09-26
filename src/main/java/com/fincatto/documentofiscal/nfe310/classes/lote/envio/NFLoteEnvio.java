package com.fincatto.documentofiscal.nfe310.classes.lote.envio;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe310.validadores.ListValidador;
import com.fincatto.documentofiscal.nfe310.validadores.StringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "enviNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFLoteEnvio extends DFBase {

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