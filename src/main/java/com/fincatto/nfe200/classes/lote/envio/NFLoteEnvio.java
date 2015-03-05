package com.fincatto.nfe200.classes.lote.envio;

import java.math.BigDecimal;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.classes.nota.NFNota;
import com.fincatto.nfe200.validadores.BigDecimalParser;
import com.fincatto.nfe200.validadores.ListValidador;
import com.fincatto.nfe200.validadores.StringValidador;

@Root(name = "enviNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFLoteEnvio extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "idLote", required = true)
    private String idLote;

    @ElementList(name = "NFe", inline = true, required = true)
    List<NFNota> notas;

    public String getIdLote() {
        return this.idLote;
    }

    public void setIdLote(final String idLote) {
        StringValidador.tamanho15N(idLote);
        this.idLote = idLote;
    }

    public void setNotas(final List<NFNota> notas) {
        ListValidador.tamanho50(notas);
        this.notas = notas;
    }

    public List<NFNota> getNotas() {
        return this.notas;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho4Com2CasasDecimais(versao);
    }

    public String getVersao() {
        return this.versao;
    }
}