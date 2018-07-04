package com.fincatto.documentofiscal.mdfe3.classes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;

/**
 * @Author Eldevan Nery Junior on 26/05/17.
 */
public class MDFProtocoloInfo extends DFBase {
    private static final long serialVersionUID = 256148266644230771L;

    @Attribute(name = "Id", required = false)
    private String identificador;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "chMDFe", required = true)
    private String chave;

    @Element(name = "dhRecbto", required = true)
    private String dataRecebimento;

    @Element(name = "nProt", required = false)
    private String numeroProtocolo;

    @Element(name = "digVal", required = false)
    private String validador;

    @Element(name = "cStat", required = true)
    private String status;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public void setChave(final String chave) {
        this.chave = chave;
    }

    public void setDataRecebimento(final String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public void setNumeroProtocolo(final String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public void setValidador(final String validador) {
        this.validador = validador;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public String getChave() {
        return this.chave;
    }

    public LocalDateTime getDataRecebimento() {
        try {
            return LocalDateTime.parse(this.dataRecebimento, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        } catch (final Exception e) {
            return LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX").parse(this.dataRecebimento)).atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
    }

    public String getNumeroProtocolo() {
        return this.numeroProtocolo;
    }

    public String getValidador() {
        return this.validador;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(final String identificador) {
        this.identificador = identificador;
    }
}