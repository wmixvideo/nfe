package com.fincatto.documentofiscal.cte400.utils;

import com.fincatto.documentofiscal.cte400.classes.nota.CTeNota;
import com.fincatto.documentofiscal.cte400.classes.os.CTeOS;
import org.apache.commons.lang3.StringUtils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CTeGeraChave {
    
    private final CTeNota nota;
    private final CTeOS cteOS;

    public CTeGeraChave(final CTeNota nota) {
        this.nota = nota;
        this.cteOS = null;
    }

    public CTeGeraChave(final CTeOS cteOS) {
        this.nota = null;
        this.cteOS = cteOS;
    }
    
    public String geraCodigoRandomico() {
        long seed;
        if (nota != null) {
            seed = this.nota.getCteNotaInfo().getIdentificacao().getDataEmissao().toInstant().toEpochMilli();
        } else {
            seed = this.cteOS.getInfo().getIdentificacao().getDataEmissao().toInstant().toEpochMilli();
        }
        final Random random = new Random(seed);
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
        String codigoNumerico;
        String codigoUF;
        ZonedDateTime dataEmissao;
        String cnpj;
        String modelo;
        String serie;
        String numero;
        String tipoEmissao;
        if (nota != null) {
            codigoUF = this.nota.getCteNotaInfo().getIdentificacao().getCodigoUF().getCodigoIbge();
            dataEmissao = this.nota.getCteNotaInfo().getIdentificacao().getDataEmissao();
            cnpj = this.nota.getCteNotaInfo().getEmitente().getCnpj();
            modelo = this.nota.getCteNotaInfo().getIdentificacao().getModelo().getCodigo();
            serie = this.nota.getCteNotaInfo().getIdentificacao().getSerie().toString();
            numero = this.nota.getCteNotaInfo().getIdentificacao().getNumero().toString();
            tipoEmissao = this.nota.getCteNotaInfo().getIdentificacao().getTipoEmissao().getCodigo();
            codigoNumerico = this.nota.getCteNotaInfo().getIdentificacao().getCodigoNumerico();
        } else {
            codigoUF = this.cteOS.getInfo().getIdentificacao().getCodigoUF().getCodigoIbge();
            dataEmissao = this.cteOS.getInfo().getIdentificacao().getDataEmissao();
            cnpj = this.cteOS.getInfo().getEmitente().getCnpj();
            modelo = this.cteOS.getInfo().getIdentificacao().getModelo().getCodigo();
            serie = this.cteOS.getInfo().getIdentificacao().getSerie().toString();
            numero = this.cteOS.getInfo().getIdentificacao().getNumero().toString();
            tipoEmissao = this.cteOS.getInfo().getIdentificacao().getTipoEmissao().getCodigo();
            codigoNumerico = this.cteOS.getInfo().getIdentificacao().getCodigoNumerico();
        }
        if (StringUtils.isBlank(codigoNumerico)) {
            throw new IllegalStateException("Codigo numerico deve estar presente para gerar a chave de acesso");
        }
        return StringUtils.leftPad(codigoUF, 2, "0") + StringUtils.leftPad(DateTimeFormatter.ofPattern("yyMM").format(dataEmissao), 4, "0") + StringUtils.leftPad(cnpj, 14, "0") + StringUtils.leftPad(modelo, 2, "0") + StringUtils.leftPad(serie, 3, "0") + StringUtils.leftPad(numero, 9, "0") + StringUtils.leftPad(tipoEmissao, 1, "0") + StringUtils.leftPad(codigoNumerico, 8, "0");
    }
}
