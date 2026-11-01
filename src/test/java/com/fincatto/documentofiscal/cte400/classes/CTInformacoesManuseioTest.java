package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTInformacoesManuseioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTInformacoesManuseio.valueOfCodigo(null));
        Assertions.assertEquals("01", CTInformacoesManuseio.CERTIFICADO_DO_EXPEDIDOR_PARA_EMBARQUE_DE_ANIMAL_VIVO.getCodigo());
        Assertions.assertEquals("02", CTInformacoesManuseio.ARTIGO_PERIGOSO_CONFORME_DECLARACAO_DO_EXPEDIDOR_ANEXA.getCodigo());
        Assertions.assertEquals("03", CTInformacoesManuseio.SOMENTE_EM_AERONAVE_CARGUEIRA.getCodigo());
        Assertions.assertEquals("04", CTInformacoesManuseio.ARTIGO_PERIGOSO_DECLARACAO_DO_EXPEDIDOR_NAO_REQUERIDA.getCodigo());
        Assertions.assertEquals("05", CTInformacoesManuseio.ARTIGO_PERIGOSO_EM_QUANTIDADE_ISENTA.getCodigo());
        Assertions.assertEquals("06", CTInformacoesManuseio.GELO_SECO_PARA_REFRIGERACAO.getCodigo());
        Assertions.assertEquals("07", CTInformacoesManuseio.NAO_RESTRITO.getCodigo());
        Assertions.assertEquals("08", CTInformacoesManuseio.ARTIGO_PERIGOSO_EM_CARGA_CONSOLIDADA.getCodigo());
        Assertions.assertEquals("09", CTInformacoesManuseio.AUTORIZACAO_DA_AUTORIDADE_GOVERNAMENTAL_ANEXA.getCodigo());
        Assertions.assertEquals("10", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI965.getCodigo());
        Assertions.assertEquals("11", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI966.getCodigo());
        Assertions.assertEquals("12", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI967.getCodigo());
        Assertions.assertEquals("13", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO.getCodigo());
        Assertions.assertEquals("14", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI969.getCodigo());
        Assertions.assertEquals("15", CTInformacoesManuseio.BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI970.getCodigo());
        Assertions.assertEquals("99", CTInformacoesManuseio.OUTRO.getCodigo());
    }

}
