package com.fincatto.documentofiscal.nfe400.classes.nota.listagemchaves;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "retNfceListagemChaves", strict = false)
@Namespace(reference = NFeConfig.NAMESPACE)
public class NFCeListagemChavesRetorno extends DFBase {
    private static final long serialVersionUID = 1L;

    @Attribute(name = "versao", required = false)
    private String versao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "verAplic")
    private String versaoAplicacao;

    @Element(name = "dhReq")
    private String dataHoraRequisicao;

    @Element(name = "cStat")
    private String status;

    @Element(name = "xMotivo")
    private String motivo;

    @ElementList(entry = "chNFCe", inline = true, required = false)
    private List<String> chaves;

    @Element(name = "dhEmisUltNfce", required = false)
    private String dataHoraEmissaoUltimaNFCe;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getDataHoraRequisicao() {
        return this.dataHoraRequisicao;
    }

    public void setDataHoraRequisicao(final String dataHoraRequisicao) {
        this.dataHoraRequisicao = dataHoraRequisicao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public List<String> getChaves() {
        return this.chaves;
    }

    public void setChaves(final List<String> chaves) {
        this.chaves = chaves;
    }

    public String getDataHoraEmissaoUltimaNFCe() {
        return this.dataHoraEmissaoUltimaNFCe;
    }

    public void setDataHoraEmissaoUltimaNFCe(final String dataHoraEmissaoUltimaNFCe) {
        this.dataHoraEmissaoUltimaNFCe = dataHoraEmissaoUltimaNFCe;
    }
}
