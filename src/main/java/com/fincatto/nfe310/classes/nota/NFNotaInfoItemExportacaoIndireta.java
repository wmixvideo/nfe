package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;
import com.fincatto.nfe310.validadores.BigIntegerValidador;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoItemExportacaoIndireta extends NFBase {

    @Element(name = "nRE", required = true)
    private BigInteger numeroRegistroExportacao;

    @Element(name = "chNFe", required = true)
    private String chaveAcessoNFe;

    @Element(name = "qExport", required = true)
    private String quantidadeItemEfetivamenteExportado;

    public void setChaveAcessoNFe(final String chaveAcessoNFe) {
        StringValidador.exatamente44N(chaveAcessoNFe);
        this.chaveAcessoNFe = chaveAcessoNFe;
    }

    public void setNumeroRegistroExportacao(final BigInteger numeroRegistroExportacao) {
        BigIntegerValidador.tamanho12(numeroRegistroExportacao);
        this.numeroRegistroExportacao = numeroRegistroExportacao;
    }

    public void setQuantidadeItemEfetivamenteExportado(final BigDecimal quantidadeItemEfetivamenteExportado) {
        this.quantidadeItemEfetivamenteExportado = BigDecimalParser.tamanho15comAte4CasasDecimais(quantidadeItemEfetivamenteExportado);
    }

    public String getChaveAcessoNFe() {
        return this.chaveAcessoNFe;
    }

    public BigInteger getNumeroRegistroExportacao() {
        return this.numeroRegistroExportacao;
    }

    public String getQuantidadeItemEfetivamenteExportado() {
        return this.quantidadeItemEfetivamenteExportado;
    }
}