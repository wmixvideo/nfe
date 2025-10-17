package com.fincatto.documentofiscal.nfse;

import com.fincatto.documentofiscal.nfse.webservices.WSDANFSe;
import com.fincatto.documentofiscal.nfse.webservices.WSParametrosMunicipais;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;

public class NFSeTest {

    NFSEConfigFake config;

    @Before
    public void prepara() {
        this.config = new NFSEConfigFake(System.getenv("CERTIFICADO_PATH"), System.getenv("CERTIFICADO_SENHA"), System.getenv("CADEIA_CERTIFICADOS_PATH"), System.getenv("CADEIA_CERTIFICADOS_SENHA"));
    }

//    @Ignore
    @Test
    public void consultaConvenioMunicipioTest() throws Exception {
        System.out.println("Teste de consulta de convênio do município na API de Parâmetros Municipais do Governo Federal");
        final var codigoDoMunicipio = "4216602";
        final var consulta = new WSParametrosMunicipais(config).consultaConvenioMunicipio(codigoDoMunicipio);
        System.out.println(consulta);
    }

//    @Ignore
    @Test
    public void consultaAliquotaMunicipioServicoCompetenciaTest() throws Exception {
        System.out.println("Teste de consulta de alíquota do município para um serviço e competência na API de Parâmetros Municipais do Governo Federal");
        final var codigoDoMunicipio = "4216602";
        final var codigoDoServico = "31.01.04.000";
        final var dataCompetencia = LocalDate.now();
        final var consulta = new WSParametrosMunicipais(config).consultaAliquotaMunicipioServicoCompetencia(codigoDoMunicipio, codigoDoServico, dataCompetencia);
        System.out.println(consulta);
    }

//    @Ignore
    @Test
    public void consultaHistoricoAliquotaMunicipioServicoTest() throws Exception {
        final var codigoDoMunicipio = "4216602";
        final var codigoDoServico = "01.01.01.000";
        final var consulta = new WSParametrosMunicipais(config).consultaHistoricoAliquotaMunicipioServico(codigoDoMunicipio, codigoDoServico);
        System.out.println(consulta);
    }

    @Ignore
    @Test
    public void consultaBeneficioMunicipioBeneficioCompetencia() throws Exception {
        // Esse método está desativado por enquanto, pois não foi possível localizar o formato de código de benefício aceito pela API.
        // Assim que essa informação estiver disponível, o teste poderá ser reativado e ajustado
        //final var codigoDoMunicipio = "4216602";
        //final var codigoDoBeneficio = "00.00.00.000";
        //final var consulta = new WSParametrosMunicipais(config).consultaBeneficioMunicipioBeneficioCompetencia(codigoDoMunicipio, codigoDoBeneficio, LocalDate.now());;
        //System.out.println(consulta);
    }

//    @Ignore
    @Test
    public void consultaRegimesEspeciaisMunicipioServicoCompetenciaTest() throws Exception {
        final var codigoDoMunicipio = "4216602";
        final var codigoDoServico = "17.01.01.000";
        final var consulta = new WSParametrosMunicipais(config).consultaRegimesEspeciaisMunicipioServicoCompetencia(codigoDoMunicipio, codigoDoServico, LocalDate.now());
        System.out.println(consulta);
    }

//    @Ignore
    @Test
    public void consultaRetencoesMunicipioCompetenciaTest() throws Exception {
        final var codigoDoMunicipio = "4216602";
        final var consulta = new WSParametrosMunicipais(config).consultaRetencoesMunicipioCompetencia(codigoDoMunicipio, LocalDate.now().minusMonths(12));
        System.out.println(consulta);
    }

//    @Ignore
    @Test
    public void downloadDANFSePdfChaveAcessoTest() throws Exception {
        System.out.println("Teste de download do DANFSe em PDF utilizando a chave de acesso da NFSe");
        final var nfseChaveAcesso = "";
        final var pathToSave = "";
        final var danfsePDF = new WSDANFSe(config).downloadDANFSePdfChaveAcesso(nfseChaveAcesso);
        FileUtils.writeByteArrayToFile(new File(String.format("%s/%s.pdf",pathToSave, nfseChaveAcesso)), danfsePDF);
    }
}
