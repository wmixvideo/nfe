package com.fincatto.documentofiscal.cte300.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTInformacoesManuseioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTInformacoesManuseio.valueOfCodigo(null));
    	Assert.assertEquals("01", CTInformacoesManuseio.Certificado_do_Expedidor_para_Embarque_de_Animal_Vivo.getCodigo());
    	Assert.assertEquals("02", CTInformacoesManuseio.Artigo_Perigoso_Conforme_Declaracao_do_Expedidor_Anexa.getCodigo());
    	Assert.assertEquals("03", CTInformacoesManuseio.Somente_em_Aeronave_Cargueira.getCodigo());
    	Assert.assertEquals("04", CTInformacoesManuseio.Artigo_Perigoso_Declaracao_do_Expedidor_nao_requerida.getCodigo());
    	Assert.assertEquals("05", CTInformacoesManuseio.Artigo_Perigoso_em_Quantidade_Isenta.getCodigo());
    	Assert.assertEquals("06", CTInformacoesManuseio.Gelo_Seco_para_Refrigeracao.getCodigo());
    	Assert.assertEquals("07", CTInformacoesManuseio.Nao_Restrito.getCodigo());
    	Assert.assertEquals("08", CTInformacoesManuseio.Artigo_Perigoso_em_Carga_Consolidada.getCodigo());
    	Assert.assertEquals("09", CTInformacoesManuseio.Autorizacao_da_Autoridade_Governamental_Anexa.getCodigo());
    	Assert.assertEquals("10", CTInformacoesManuseio.Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI965.getCodigo());
    	Assert.assertEquals("11", CTInformacoesManuseio.Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI966.getCodigo());
    	Assert.assertEquals("12", CTInformacoesManuseio.Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI967.getCodigo());
    	Assert.assertEquals("13", CTInformacoesManuseio.Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI968.getCodigo());
    	Assert.assertEquals("14", CTInformacoesManuseio.Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI969.getCodigo());
    	Assert.assertEquals("15", CTInformacoesManuseio.Baterias_de_Ions_de_Litio_em_Conformidade_com_a_Seção_II_da_PI970.getCodigo());
    	Assert.assertEquals("99", CTInformacoesManuseio.Outro.getCodigo());
    }

}
