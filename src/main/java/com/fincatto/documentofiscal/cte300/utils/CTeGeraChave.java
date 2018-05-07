package com.fincatto.documentofiscal.cte300.utils;

import com.fincatto.documentofiscal.cte300.classes.nota.CTeNota;
import org.apache.commons.lang3.StringUtils;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CTeGeraChave {

    private final CTeNota nota;

    public CTeGeraChave(final CTeNota nota) {
        this.nota = nota;
    }
    
    public String geraCodigoRandomico() {
        final Random random = new Random(this.nota.getCteNotaInfo().getIdentificacao().getDataEmissao().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        return StringUtils.leftPad(String.valueOf(random.nextInt(100000000)), 8, "0");
    }

    public String getChaveAcesso() {
        return String.format("%s%s", this.geraChaveAcessoSemDV(), this.getDV());
    }

    public Integer getDV() {
        final char[] valores = this.geraChaveAcessoSemDV().toCharArray();
        final int[] valoresInt = {2, 3, 4, 5, 6, 7, 8, 9};
        int indice = 0;
        int soma = 0;
        int valorTemp;
        int multTemp;
        for (int i = valores.length; i > 0; i--) {
            if (indice >= valoresInt.length) {
                indice = 0;
            }

            valorTemp = Integer.parseInt(String.valueOf(valores[i - 1]));
            multTemp = valoresInt[indice++];
            soma += valorTemp * multTemp;
        }
        final int dv = 11 - (soma % 11);
        return ((dv == 11) || (dv == 10)) ? 0 : dv;
    }

    private String geraChaveAcessoSemDV() {
    	if (StringUtils.isBlank(this.nota.getCteNotaInfo().getIdentificacao().getCodigoNumerico())) {
            throw new IllegalStateException("Codigo numerico deve estar presente para gerar a chave de acesso");
        }
        return StringUtils.leftPad(this.nota.getCteNotaInfo().getIdentificacao().getCodigoUF().getCodigoIbge(), 2, "0") +
                StringUtils.leftPad(DateTimeFormatter.ofPattern("yyMM").format(this.nota.getCteNotaInfo().getIdentificacao().getDataEmissao()), 4, "0") +
                StringUtils.leftPad(this.nota.getCteNotaInfo().getEmitente().getCnpj(), 14, "0") +
                StringUtils.leftPad(this.nota.getCteNotaInfo().getIdentificacao().getModelo().getCodigo(), 2, "0") +
                StringUtils.leftPad(this.nota.getCteNotaInfo().getIdentificacao().getSerie()+"", 3, "0") +
                StringUtils.leftPad(this.nota.getCteNotaInfo().getIdentificacao().getNumero()+"", 9, "0") +
                StringUtils.leftPad(this.nota.getCteNotaInfo().getIdentificacao().getTipoEmissao().getCodigo(), 1, "0") +
                StringUtils.leftPad(this.nota.getCteNotaInfo().getIdentificacao().getCodigoNumerico(), 8, "0");
    }
}
