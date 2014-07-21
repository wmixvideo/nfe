package com.fincatto.nfe.classes.nota;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import com.ctc.wstx.io.CharsetNames;
import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFEndereco;
import com.fincatto.nfe.classes.NFFinalidade;
import com.fincatto.nfe.classes.NFFormaPagamento;
import com.fincatto.nfe.classes.NFOrigem;
import com.fincatto.nfe.classes.NFProgramaEmissor;
import com.fincatto.nfe.classes.NFRegimeTributario;
import com.fincatto.nfe.classes.NFTipo;
import com.fincatto.nfe.classes.NFTipoEmissao;
import com.fincatto.nfe.classes.NFTipoImpressao;
import com.fincatto.nfe.transformers.NFRegistryMatcher;

public class NFNotaTest {

    @Test
    public void deveGerarNFSemItem() throws Exception {
        final NFNota nota = new NFNota();
        nota.setInfo(new NFNotaInfo());
        final NFNotaInfoItem notaInfoItem = new NFNotaInfoItem();
        notaInfoItem.setInformacoesAdicionais("blablabla");
        notaInfoItem.setNumeroItem("5849954100");

        notaInfoItem.setImposto(new NFNotaInfoItemImposto());
        notaInfoItem.getImposto().setValorTotal("20455,05");
        notaInfoItem.getImposto().setCofins(new NFNotaInfoItemImpostoCOFINS());
        notaInfoItem.getImposto().getCofins().setAliquota(new NFNotaInfoItemImpostoCOFINSAliquota());
        notaInfoItem.getImposto().getCofins().getAliquota().setAliquota(new BigDecimal("200.00"));
        // notaInfoItem.getImposto().getCofins().getAliquota().setSituacaoTributaria("924");
        notaInfoItem.getImposto().getCofins().getAliquota().setValor(new BigDecimal("100.15"));
        notaInfoItem.getImposto().getCofins().getAliquota().setValorBaseCalulo(new BigDecimal("84.98"));
        notaInfoItem.getImposto().getCofins().setNaoTributavel(new NFNotaInfoItemImpostoCOFINSNaoTributavel());
        notaInfoItem.getImposto().getCofins().setOutrasOperacoes(new NFNotaInfoItemImpostoCOFINSOutrasOperacoes());
        notaInfoItem.getImposto().getCofins().setQuantidade(new NFNotaInfoItemImpostoCOFINSQuantidade());

        notaInfoItem.getImposto().setCofinsst(new NFNotaInfoItemImpostoCOFINSST());
        notaInfoItem.getImposto().getCofinsst().setAliquota(new BigDecimal("0.25"));
        notaInfoItem.getImposto().getCofinsst().setQuantidadeVendida(new BigDecimal("11.55"));
        notaInfoItem.getImposto().getCofinsst().setValorAliquota(new BigDecimal("941.49"));
        notaInfoItem.getImposto().getCofinsst().setValorBaseCalculo(new BigDecimal("1100.99"));
        notaInfoItem.getImposto().getCofinsst().setValorTributo(new BigDecimal("55.04"));

        notaInfoItem.getImposto().setIcms(new NFNotaInfoItemImpostoICMS());
        notaInfoItem.getImposto().getIcms().setIcms00(new NFNotaInfoItemImpostoICMS00());
        notaInfoItem.getImposto().getIcms().getIcms00().setAliquota(new BigDecimal("90"));
        notaInfoItem.getImposto().getIcms().getIcms00().setCodigoSituacaoTributaria("0298950");
        notaInfoItem.getImposto().getIcms().getIcms00().setModalidadeBaseCalculo(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.VALOR_OPERACAO);
        notaInfoItem.getImposto().getIcms().getIcms00().setOrigem(NFOrigem.NACIONAL);
        notaInfoItem.getImposto().getIcms().getIcms00().setValorBaseCalculo(new BigDecimal("851.45"));

        notaInfoItem.getImposto().getIcms().setIcms10(new NFNotaInfoItemImpostoICMS10());
        notaInfoItem.getImposto().getIcms().getIcms10();

        notaInfoItem.getImposto().getIcms().setIcms20(new NFNotaInfoItemImpostoICMS20());
        notaInfoItem.getImposto().getIcms().setIcms30(new NFNotaInfoItemImpostoICMS30());
        notaInfoItem.getImposto().getIcms().setIcms40(new NFNotaInfoItemImpostoICMS40());
        notaInfoItem.getImposto().getIcms().setIcms51(new NFNotaInfoItemImpostoICMS51());
        notaInfoItem.getImposto().getIcms().setIcms60(new NFNotaInfoItemImpostoICMS60());
        notaInfoItem.getImposto().getIcms().setIcms70(new NFNotaInfoItemImpostoICMS70());
        notaInfoItem.getImposto().getIcms().setIcms90(new NFNotaInfoItemImpostoICMS90());
        notaInfoItem.getImposto().getIcms().setIcmsPartilhado(new NFNotaInfoItemImpostoICMSPartilhado());
        notaInfoItem.getImposto().getIcms().setIcmssn101(new NFNotaInfoItemImpostoICMSSN101());
        notaInfoItem.getImposto().getIcms().setIcmssn102(new NFNotaInfoItemImpostoICMSSN102());
        notaInfoItem.getImposto().getIcms().setIcmssn201(new NFNotaInfoItemImpostoICMSSN201());
        notaInfoItem.getImposto().getIcms().setIcmssn202(new NFNotaInfoItemImpostoICMSSN202());
        notaInfoItem.getImposto().getIcms().setIcmssn500(new NFNotaInfoItemImpostoICMSSN500());
        notaInfoItem.getImposto().getIcms().setIcmssn900(new NFNotaInfoItemImpostoICMSSN900());
        notaInfoItem.getImposto().getIcms().setIcmsst(new NFNotaInfoItemImpostoICMSST());

        notaInfoItem.getImposto().setImpostoImportacao(new NFNotaInfoItemImpostoImportacao());
        notaInfoItem.getImposto().setIpi(new NFNotaInfoItemImpostoIPI());
        notaInfoItem.getImposto().setIssqn(new NFNotaInfoItemImpostoISSQN());
        notaInfoItem.getImposto().setPis(new NFNotaInfoItemImpostoPIS());
        notaInfoItem.getImposto().setPisst(new NFNotaInfoItemImpostoPISST());

        notaInfoItem.setProduto(new NFNotaInfoItemProduto());

        final ArrayList<NFNotaInfoItem> items = new ArrayList<NFNotaInfoItem>();
        items.add(notaInfoItem);
        nota.getInfo().setItens(items);
        nota.getInfo().setVersao("2.0.0");

        nota.getInfo().setDestinatario(new NFNotaInfoDestinatario());
        nota.getInfo().getDestinatario().setCnpj("61922241000182");
        nota.getInfo().getDestinatario().setEmail("teste@teste.com");
        nota.getInfo().getDestinatario().setEndereco(new NFEndereco());
        nota.getInfo().getDestinatario().getEndereco().setBairro("Campinas");
        nota.getInfo().getDestinatario().getEndereco().setCep("88813000");
        nota.getInfo().getDestinatario().getEndereco().setCodigoMunicipio("145");
        nota.getInfo().getDestinatario().getEndereco().setCodigoPais("55");
        nota.getInfo().getDestinatario().getEndereco().setComplemento("compl.");
        nota.getInfo().getDestinatario().getEndereco().setDescricaoMunicipio("Sao Jose");
        nota.getInfo().getDestinatario().getEndereco().setDescricaoPais("Brasil");
        nota.getInfo().getDestinatario().getEndereco().setLogradouro("Brigadeiro da Silva Paes");
        nota.getInfo().getDestinatario().getEndereco().setNumero("225");
        nota.getInfo().getDestinatario().getEndereco().setTelefone("34551000");
        nota.getInfo().getDestinatario().getEndereco().setUf(NFUnidadeFederativa.SC);
        nota.getInfo().getDestinatario().setInscricaoEstadual("30459");
        nota.getInfo().getDestinatario().setInscricaoSuframa("032149");
        nota.getInfo().getDestinatario().setRazaoSocial("Wmix ltda");

        nota.getInfo().setEmitente(new NFNotaInfoEmitente());
        nota.getInfo().getEmitente().setClassificacaoNacionalAtividadesEconomicas("LOLLLL");
        nota.getInfo().getEmitente().setCnpj("61922241000182");
        nota.getInfo().getEmitente().setEndereco(new NFEndereco());
        nota.getInfo().getEmitente().getEndereco().setBairro("Campinas");
        nota.getInfo().getEmitente().getEndereco().setCep("88813000");
        nota.getInfo().getEmitente().getEndereco().setCodigoMunicipio("145");
        nota.getInfo().getEmitente().getEndereco().setCodigoPais("55");
        nota.getInfo().getEmitente().getEndereco().setComplemento("compl.");
        nota.getInfo().getEmitente().getEndereco().setDescricaoMunicipio("Sao Jose");
        nota.getInfo().getEmitente().getEndereco().setDescricaoPais("Brasil");
        nota.getInfo().getEmitente().getEndereco().setLogradouro("Brigadeiro da Silva Paes");
        nota.getInfo().getEmitente().getEndereco().setNumero("225");
        nota.getInfo().getEmitente().getEndereco().setTelefone("34551000");
        nota.getInfo().getEmitente().getEndereco().setUf(NFUnidadeFederativa.SC);
        nota.getInfo().getEmitente().setInscricaoEstadual("395604");
        nota.getInfo().getEmitente().setInscricaoEstadualSubstituicaoTributaria("256787654");
        nota.getInfo().getEmitente().setInscricaoMunicipal("010101001");
        nota.getInfo().getEmitente().setNomeFantasia("Videolocadora do Zezinho");
        nota.getInfo().getEmitente().setRazaoSocial("Videolocadora do Zezinho ltda");
        nota.getInfo().getEmitente().setRegimeTributario(NFRegimeTributario.NORMAL);

        nota.getInfo().setIdentificacao(new NFNotaInfoIdentificacao());
        nota.getInfo().getIdentificacao().setAmbiente(NFAmbiente.HOMOLOGACAO);
        nota.getInfo().getIdentificacao().setCodigoMunicipio("123");
        nota.getInfo().getIdentificacao().setCodigoRandomico("123654");
        nota.getInfo().getIdentificacao().setDataEmissao(new LocalDate(2014, 1, 1));
        nota.getInfo().getIdentificacao().setDataSaida(new LocalDate(2014, 1, 2));
        nota.getInfo().getIdentificacao().setDigitoVerificador("0");
        nota.getInfo().getIdentificacao().setFinalidade(NFFinalidade.NORMAL);
        nota.getInfo().getIdentificacao().setFormaPagamento(NFFormaPagamento.A_VISTA);
        nota.getInfo().getIdentificacao().setModelo("ModeloPadrao");
        nota.getInfo().getIdentificacao().setNaturezaOperacao("OperNat");
        nota.getInfo().getIdentificacao().setNumeroNota("12345678");
        nota.getInfo().getIdentificacao().setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        nota.getInfo().getIdentificacao().setSerie("1234SS56");
        nota.getInfo().getIdentificacao().setTipo(NFTipo.ENTRADA);
        nota.getInfo().getIdentificacao().setTipoEmissao(NFTipoEmissao.CONTINGENCIA_FS);
        nota.getInfo().getIdentificacao().setTipoImpressao(NFTipoImpressao.PAISAGEM);
        nota.getInfo().getIdentificacao().setUf(NFUnidadeFederativa.SC);
        nota.getInfo().getIdentificacao().setVersaoEmissor("2.0.0");
        nota.getInfo().setIdentificador("myIdentif");

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            final Serializer serializer = new Persister(new NFRegistryMatcher(), new Format("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"));
            serializer.write(nota, baos);
            System.out.println(new String(baos.toByteArray(), CharsetNames.CS_UTF8));
        }
    }
}