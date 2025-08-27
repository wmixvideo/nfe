package com.fincatto.documentofiscal.nfe400.utils.qrcode30;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import org.apache.commons.lang3.StringUtils;

/**
 * Classe abstrata para a implementação da geração do QRCode 3.0.
 * Deve ser feita a implementação para emissão normal (1) e para contingência offline (9).
 */
public abstract class NFGeraQRCode30 {

    public static final String VERSAO_QRCODE = "3";

    protected final NFNota nota;
    protected final NFeConfig config;

    public NFGeraQRCode30(final NFNota nota, final NFeConfig config) {
        this.nota = nota;
        this.config = config;
    }

    /**
     * Método responsável pela geração do qrcode.
     *
     * @return URL para consulta da nota via qrcode30.
     * @throws Exception
     */
    public abstract String getQRCode() throws Exception;

    public String getUrlQRCode() {
        String url = this.config.getAmbiente().equals(DFAmbiente.PRODUCAO) ? this.nota.getInfo().getIdentificacao().getUf().getQrCodeProducao() : this.nota.getInfo().getIdentificacao().getUf().getQrCodeHomologacao();

        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("URL para consulta do QRCode nao informada para uf " + this.nota.getInfo().getIdentificacao().getUf() + "!");
        }

        return url;
    }

    public String assinar(final String parametros) throws Exception {
        return new DFAssinaturaDigital(config).assinarString(parametros);
    }

    public String urlConsultaChaveAcesso() {
        return this.config.getAmbiente().equals(DFAmbiente.PRODUCAO) ? this.nota.getInfo().getIdentificacao().getUf().getConsultaChaveAcessoProducao() : this.nota.getInfo().getIdentificacao().getUf().getConsultaChaveAcessoHomologacao();
    }
}