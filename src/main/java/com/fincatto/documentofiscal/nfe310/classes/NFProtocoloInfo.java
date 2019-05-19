package com.fincatto.documentofiscal.nfe310.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.time.ZonedDateTime;

public class NFProtocoloInfo extends DFBase {
    private static final long serialVersionUID = -7256753142051587115L;
    
    @Attribute(name = "Id", required = false)
    private String identificador;
    
    @Element(name = "tpAmb")
    private DFAmbiente ambiente;
    
    @Element(name = "verAplic")
    private String versaoAplicacao;
    
    @Element(name = "chNFe")
    private String chave;
    
    @Element(name = "dhRecbto")
    private ZonedDateTime dataRecebimento;
    
    @Element(name = "nProt", required = false)
    private String numeroProtocolo;
    
    @Element(name = "digVal", required = false)
    private String validador;
    
    @Element(name = "cStat")
    private String status;
    
    @Element(name = "xMotivo")
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
    
    public void setDataRecebimento(final ZonedDateTime dataRecebimento) {
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
    
    public ZonedDateTime getDataRecebimento() {
        return this.dataRecebimento;
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