package com.fincatto.documentofiscal.mdfe3.utils;

import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;

public class MDFGeraQRCode {

    private final MDFe mdf;
    private final MDFeConfig config;

    private static String qrCodeUrl = "https://dfe-portal.svrs.rs.gov.br/mdfe/qrCode";

    public MDFGeraQRCode(final MDFe nota, final MDFeConfig config) {
        this.mdf = nota;
        this.config = config;
    }

    public String getQRCode() throws Exception {
        final StringBuilder parametros = new StringBuilder();
//        1a parte - URL para acessar o MDF-e, seguido do caractere “?”
        String url = qrCodeUrl;

//        2a parte - parâmetros chMDFe e tpAmb da mesma forma como na forma de emissão normal
//        separados pelo caractere “&”;
        String chaveAcesso = this.mdf.getInfo().getChaveAcesso();
        parametros.append("chMDFe=").append(chaveAcesso).append("&"); // Chave de Acesso do MDFE
        parametros.append("tpAmb=").append(this.config.getAmbiente().getCodigo());

//        3a parte – sign assinatura digital no padrão RSA SHA-1 (Base64) do valor do parâmetro chMDFe
//        (chave de acesso com 44 caracteres) a partir do certificado digital que assina o MDF-e, este
//        parâmetro deve ser adicionado aos demais usando um caractere “&” como separador.
        if(this.config.getTipoEmissao().equals(MDFTipoEmissao.CONTINGENCIA)){
            parametros.append("&sign=").append(new DFAssinaturaDigital(this.config).assinarString(chaveAcesso));
        }

        // retorna a url do qrcode
        return url + "?" + parametros.toString();
    }
    
    public String urlConsultaChaveAcesso() {
        return "https://dfe-portal.svrs.rs.gov.br/MDFe/consulta";
    }
}
