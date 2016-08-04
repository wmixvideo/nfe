package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import com.fincatto.nfe.core.validadores.BigIntegerValidador;
import com.fincatto.nfe.core.validadores.StringValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NFNotaInfoItemExportacaoIndireta extends NFBase {

    @Element(name = "nRE", required = true)
    private BigInteger numeroRegistroExportacao;

    @Element(name = "chNFe", required = true)
    private String chaveAcessoNFe;

    @Element(name = "qExport", required = true)
    private String quantidadeItemEfetivamenteExportado;

    public void setChaveAcessoNFe(final String chaveAcessoNFe) {
        StringValidador.exatamente44N(chaveAcessoNFe, "Chave de Acesso NFe");
        this.chaveAcessoNFe = chaveAcessoNFe;
    }

    public void setNumeroRegistroExportacao(final BigInteger numeroRegistroExportacao) {
        BigIntegerValidador.tamanho12(numeroRegistroExportacao, "Numero Registro Exportacao");
        this.numeroRegistroExportacao = numeroRegistroExportacao;
    }

    public void setQuantidadeItemEfetivamenteExportado(final BigDecimal quantidadeItemEfetivamenteExportado) {
        this.quantidadeItemEfetivamenteExportado = BigDecimalParser.tamanho15comAte4CasasDecimais(quantidadeItemEfetivamenteExportado, "Quantidade Item Evetivamente Exportado");
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