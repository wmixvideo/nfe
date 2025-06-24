package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTeModalDutoClassDuto;
import com.fincatto.documentofiscal.cte400.classes.CTeModalDutoTpContratacao;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Informações do modal Dutoviário
 */

@Root(name = "duto")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalDutoviario extends DFBase {
    private static final long serialVersionUID = 5249378125159119749L;

    @Element(name = "vTar", required = false)
    private String valorTarifa;
    
    @Element(name = "dIni")
    private LocalDate dataInicioServico;
    
    @Element(name = "dFim")
    private LocalDate dataFimServico;

    @Element(name = "classDuto", required = false)
    private CTeModalDutoClassDuto classDuto;
  
    @Element(name = "tpContratacao", required = false)
    private CTeModalDutoTpContratacao tpContratacao;
    
    @Element(name = "codPontoEntrada", required = false)
    private String codPontoEntrada;
    
    @Element(name = "codPontoSaida", required = false)
    private String codPontoSaida;
    
    @Element(name = "nContrato", required = false)
    private String nContrato;

    public String getValorTarifa() {
        return this.valorTarifa;
    }

    /**
     * Valor da tarifa
     */
    public void setValorTarifa(final BigDecimal valorTarifa) {
        this.valorTarifa = DFBigDecimalValidador.tamanho15comAte6CasasDecimais(valorTarifa, "Valor da tarifa");
    }

    public LocalDate getDataInicioServico() {
        return this.dataInicioServico;
    }

    /**
     * Data de Início da prestação do serviço
     */
    public void setDataInicioServico(final LocalDate dataInicioServico) {
        this.dataInicioServico = dataInicioServico;
    }

    public LocalDate getDataFimServico() {
        return this.dataFimServico;
    }

    /**
     * Data de Fim da prestação do serviço
     */
    public void setDataFimServico(final LocalDate dataFimServico) {
        this.dataFimServico = dataFimServico;
    }

    public CTeModalDutoClassDuto getClassDuto() {
        return classDuto;
    }

    public void setClassDuto(CTeModalDutoClassDuto classDuto) {
        this.classDuto = classDuto;
    }

    public CTeModalDutoTpContratacao getTpContratacao() {
        return tpContratacao;
    }

    public void setTpContratacao(CTeModalDutoTpContratacao tpContratacao) {
       this.tpContratacao = tpContratacao;
    }

    public String getCodPontoEntrada() {
        return codPontoEntrada;
    }

    public void setCodPontoEntrada(String codPontoEntrada) {
        this.codPontoEntrada = codPontoEntrada;
    }

    public String getCodPontoSaida() {
        return codPontoSaida;
    }

    public void setCodPontoSaida(String codPontoSaida) {
       this.codPontoSaida = codPontoSaida;
    }

    public String getNContrato() {
        return nContrato;
    }

    public void setNContrato(String nContrato) {
        this.nContrato = nContrato;
    }
    
}
