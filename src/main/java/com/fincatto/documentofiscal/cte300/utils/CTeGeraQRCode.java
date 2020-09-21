package com.fincatto.documentofiscal.cte300.utils;

import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.CTTipoEmissao;
import com.fincatto.documentofiscal.cte300.classes.nota.CTeNota;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;

public class CTeGeraQRCode {

    private final CTeConfig config;

    public CTeGeraQRCode(CTeConfig config) {
        this.config = config;
    }

    public String getQRCode(CTeNota cTeNota) throws Exception {
        String chaveAcesso = cTeNota.getCteNotaInfo().getChaveAcesso();
        String url = CTAutorizador31.valueOfChaveAcesso(chaveAcesso).getCteQrCode(this.config.getAmbiente());
        final StringBuilder parametros = new StringBuilder();
        parametros.append("chCTe=").append(chaveAcesso).append("&");
        parametros.append("tpAmb=").append(this.config.getAmbiente().getCodigo());
        if(this.config.getTipoEmissao().equals(CTTipoEmissao.CONTINGENCIA_EPEC)){
            parametros.append("&sign=").append(new DFAssinaturaDigital(this.config).assinarString(chaveAcesso));
        }
        // retorna a url do qrcode
        return url + "?" + parametros.toString();
    }
    
}
