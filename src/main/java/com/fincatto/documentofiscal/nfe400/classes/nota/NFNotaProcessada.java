package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFProtocolo;
import com.fincatto.documentofiscal.nfe400.classes.NFProtocoloInfo;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "nfeProc")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaProcessada extends DFBase {
    private static final long serialVersionUID = 6979476565566044621L;
    private static final String VERSAO = "4.00";

    @Attribute(name = "versao")
    private String versao;

    @Attribute(name = "schemaLocation", required = false)
    private String schemaLocation;

    @Element(name = "NFe")
    private NFNota nota;

    @Element(name = "protNFe")
    private NFProtocolo protocolo;

    /**
     * Gera o XML da nota autorizada (nfeProc, versao 4.00) a partir da nota assinada e do protocolo de autorizacao.
     *
     * @param notaAssinada nota assinada, como devolvida em {@code getLoteAssinado()}; nao pode ser alterada apos a assinatura
     * @param protocoloInfo protocolo de autorizacao devolvido pela SEFAZ
     * @return nota processada pronta para ser guardada com {@link #toString()}
     */
    public static NFNotaProcessada gera(final NFNota notaAssinada, final NFProtocoloInfo protocoloInfo) {
        final NFProtocolo protocolo = new NFProtocolo();
        protocolo.setVersao(VERSAO);
        protocolo.setProtocoloInfo(protocoloInfo);

        final NFNotaProcessada notaProcessada = new NFNotaProcessada();
        notaProcessada.setVersao(new BigDecimal(VERSAO));
        notaProcessada.setNota(notaAssinada);
        notaProcessada.setProtocolo(protocolo);
        return notaProcessada;
    }

    public NFNota getNota() {
        return this.nota;
    }

    public String getVersao() {
        return this.versao;
    }

    public NFProtocolo getProtocolo() {
        return this.protocolo;
    }

    public void setNota(final NFNota nota) {
        this.nota = nota;
    }

    public void setProtocolo(final NFProtocolo protocolo) {
        this.protocolo = protocolo;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho4Com2CasasDecimais(versao, "Versao Nota Processada");
    }

    public String getSchemaLocation() {
        return this.schemaLocation;
    }

    public void setSchemaLocation(final String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }
}