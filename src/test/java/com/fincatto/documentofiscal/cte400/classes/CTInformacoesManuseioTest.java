package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTInformacoesManuseioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTInformacoesManuseio.valueOfCodigo(null));
        Assert.assertEquals("01", CTInformacoesManuseio.CERTIFICADO_DO_EXPEDIDOR_PARA_EMBARQUE_DE_ANIMAL_VIVO.getCodigo());
        Assert.assertEquals("02", CTInformacoesManuseio.ARTIGO_PERIGOSO_CONFORME_DECLARACAO_DO_EXPEDIDOR_ANEXA.getCodigo());
        Assert.assertEquals("03", CTInformacoesManuseio.SOMENTE_EM_AERONAVE_CARGUEIRA.getCodigo());
        Assert.assertEquals("04", CTInformacoesManuseio.ARTIGO_PERIGOSO_DECLARACAO_DO_EXPEDIDOR_NAO_REQUERIDA.getCodigo());
        Assert.assertEquals("05", CTInformacoesManuseio.ARTIGO_PERIGOSO_EM_QUANTIDADE_ISENTA.getCodigo());
        Assert.assertEquals("06", CTInformacoesManuseio.GELO_SECO_PARA_REFRIGERACAO.getCodigo());
        Assert.assertEquals("07", CTInformacoesManuseio.NAO_RESTRITO.getCodigo());
        Assert.assertEquals("08", CTInformacoesManuseio.ARTIGO_PERIGOSO_EM_CARGA_CONSOLIDADA.getCodigo());
        Assert.assertEquals("09", CTInformacoesManuseio.AUTORIZACAO_DA_AUTORIDADE_GOVERNAMENTAL_ANEXA.getCodigo());
        Assert.assertEquals("10", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI965.getCodigo());
        Assert.assertEquals("11", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI966.getCodigo());
        Assert.assertEquals("12", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI967.getCodigo());
        Assert.assertEquals("13", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO.getCodigo());
        Assert.assertEquals("14", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI969.getCodigo());
        Assert.assertEquals("15", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI970.getCodigo());
        Assert.assertEquals("99", CTInformacoesManuseio.OUTRO.getCodigo());
    }

}
