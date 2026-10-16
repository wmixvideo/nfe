package com.fincatto.documentofiscal.nfe400.classes.nota.listagemchaves;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servico exclusivo da SEFAZ-SP para consulta da relacao de chaves das NFC-e recebidas pela Sefaz
 * num determinado periodo, para um determinado contribuinte (identificado pelo CNPJ do certificado digital
 * utilizado na chamada do webservice).
 */
@Root(name = "nfceListagemChaves")
@Namespace(reference = NFeConfig.NAMESPACE)
public class NFCeListagemChaves extends DFBase {
    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "dataHoraInicial")
    private String dataHoraInicial;

    @Element(name = "dataHoraFinal", required = false)
    private String dataHoraFinal;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = DFBigDecimalValidador.tamanho4Com2CasasDecimais(versao, "Versao Listagem Chaves NFCe");
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getDataHoraInicial() {
        return this.dataHoraInicial;
    }

    public void setDataHoraInicial(final LocalDateTime dataHoraInicial) {
        this.dataHoraInicial = dataHoraInicial == null ? null : NFCeListagemChaves.FORMATO_DATA_HORA.format(dataHoraInicial);
    }

    public String getDataHoraFinal() {
        return this.dataHoraFinal;
    }

    public void setDataHoraFinal(final LocalDateTime dataHoraFinal) {
        this.dataHoraFinal = dataHoraFinal == null ? null : NFCeListagemChaves.FORMATO_DATA_HORA.format(dataHoraFinal);
    }
}
