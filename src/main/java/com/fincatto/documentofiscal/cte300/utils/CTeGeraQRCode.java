package com.fincatto.documentofiscal.cte300.utils;

import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.nota.CTeNota;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;

public class CTeGeraQRCode {

    private final CTeNota cTeNota;
    private final CTeConfig config;

    public CTeGeraQRCode(final CTeNota nota, final CTeConfig config) {
        this.cTeNota = nota;
        this.config = config;
    }

    public String getQRCode() throws Exception {
        String chaveAcesso = this.cTeNota.getCteNotaInfo().getChaveAcesso();
        String url = CTAutorizador31.valueOfChaveAcesso(chaveAcesso).getCteQrCode(this.config.getAmbiente());
        final StringBuilder parametros = new StringBuilder();
        parametros.append("chCTe=").append(chaveAcesso).append("&");
        parametros.append("tpAmb=").append(this.config.getAmbiente().getCodigo());
        if(this.config.getTipoEmissao().equals(MDFTipoEmissao.CONTINGENCIA)){
            parametros.append("&sign=").append(new DFAssinaturaDigital(this.config).assinarString(chaveAcesso));
        }
        // retorna a url do qrcode
        return url + "?" + parametros.toString();
    }
    
}
