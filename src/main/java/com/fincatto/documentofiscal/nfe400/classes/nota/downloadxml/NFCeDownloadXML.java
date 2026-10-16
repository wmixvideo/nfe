package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Servico exclusivo da SEFAZ-SP para download do XML de uma NFC-e (e seus eventos associados) a partir da sua chave de acesso.
 */
@Root(name = "nfceDownloadXML")
@Namespace(reference = NFeConfig.NAMESPACE)
public class NFCeDownloadXML extends DFBase {
    private static final long serialVersionUID = 1L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "chNFCe")
    private String chave;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho4Com2CasasDecimais(versao, "Versao Download XML NFCe");
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getChave() {
        return this.chave;
    }

    public void setChave(final String chave) {
        DFStringValidador.exatamente44(chave, "Chave de Acesso Download XML NFCe");
        this.chave = chave;
    }
}
