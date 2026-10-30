package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.nfe400.classes.NFEndereco;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoCobranca;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoICMSTotal;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoIBSCBSTot;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoIdentificacao;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoParcela;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoTotal;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoTransportador;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoTransporte;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoVolume;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.DIREITA;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.ESQUERDA;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.LARGURA_UTIL;

/**
 * Destinatario, fatura, totais (produtos, ICMS/IPI, IBS/CBS/IS), ISSQN e transporte.
 *
 * @author Marcos Lombardi de Andrade
 */
final class DanfeTotais {

    private static final float ALTURA_QUADRO = 22f;
    /** Inicio de cada grupo da fatura (e o fim do ultimo); o terceiro grupo comeca na coluna da chave de acesso. */
    private static final float[] GRUPOS_FATURA = {0f, 0.3f, 0.6f, 1f};
    private static final DateTimeFormatter VENCIMENTO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Classe utilitaria, nao deve ser instanciada.
     */
    private DanfeTotais() {
    }

    /**
     * Quadro com rotulo e valor ja formatado.
     */
    private static final class Campo {
        private final String rotulo;
        private final String valor;
        private final DanfeCanvas.Alinhamento alinhamento;

        /**
         * @param rotulo rotulo do quadro
         * @param valor valor do quadro, ou null
         * @param alinhamento alinhamento do valor
         */
        private Campo(final String rotulo, final String valor, final DanfeCanvas.Alinhamento alinhamento) {
            this.rotulo = rotulo;
            this.valor = valor == null ? "" : valor;
            this.alinhamento = alinhamento;
        }
    }

    /**
     * Campo de texto, alinhado a esquerda.
     */
    private static Campo texto(final String rotulo, final String valor) {
        return new Campo(rotulo, valor, ESQUERDA);
    }

    /**
     * Campo numerico, alinhado a direita, com o valor do XML formatado.
     */
    private static Campo numero(final String rotulo, final String valorXml) {
        return new Campo(rotulo, DanfeFormatador.valor(valorXml), DIREITA);
    }

    /**
     * Desenha destinatario, fatura, totais, ISSQN e transporte.
     *
     * @param canvas area de desenho
     * @param info informacoes da nota
     */
    static void desenhar(final DanfeCanvas canvas, final NFNotaInfo info) {
        destinatario(canvas, info);
        fatura(canvas, info.getCobranca());
        totalProdutos(canvas, info.getTotal() == null ? null : info.getTotal().getIcmsTotal());
        totalIcms(canvas, info.getTotal() == null ? null : info.getTotal().getIcmsTotal());
        totalIbsCbsIs(canvas, info.getTotal());
        issqn(canvas, info);
        transporte(canvas, info.getTransporte());
    }

    /**
     * Desenha o titulo do bloco, abrindo nova pagina se nao couber o titulo e uma linha.
     */
    private static void titulo(final DanfeCanvas canvas, final String texto) {
        canvas.garantir(DanfeCanvas.ALTURA_TITULO + ALTURA_QUADRO);
        canvas.titulo(texto);
        canvas.avancar(DanfeCanvas.ALTURA_TITULO);
    }

    /**
     * Desenha uma linha de quadros com larguras proporcionais aos pesos.
     */
    private static void linha(final DanfeCanvas canvas, final float[] pesos, final Campo... campos) {
        canvas.garantir(ALTURA_QUADRO);
        float soma = 0;
        for (final float peso : pesos) {
            soma += peso;
        }
        float x = 0;
        for (int i = 0; i < campos.length; i++) {
            final float largura = LARGURA_UTIL * pesos[i] / soma;
            canvas.caixa(x, largura, ALTURA_QUADRO, campos[i].rotulo, campos[i].valor, campos[i].alinhamento);
            x += largura;
        }
        canvas.avancar(ALTURA_QUADRO);
    }

    /**
     * Desenha linhas de ate quatro quadros de largura igual; recebe apenas os campos que existem.
     */
    private static void linhasIguais(final DanfeCanvas canvas, final List<Campo> campos) {
        for (int i = 0; i < campos.size(); i += 4) {
            final Campo[] linha = campos.subList(i, Math.min(i + 4, campos.size())).toArray(new Campo[0]);
            final float[] pesos = new float[linha.length];
            java.util.Arrays.fill(pesos, 1f);
            linha(canvas, pesos, linha);
        }
    }

    /**
     * Acrescenta o campo somente se o valor existir no XML.
     */
    private static void adicionarSePresente(final List<Campo> campos, final String rotulo, final String valorXml) {
        if (valorXml != null) {
            campos.add(numero(rotulo, valorXml));
        }
    }

    /**
     * Desenha o bloco do destinatario/remetente.
     */
    private static void destinatario(final DanfeCanvas canvas, final NFNotaInfo info) {
        final NFNotaInfoDestinatario destinatario = info.getDestinatario();
        final NFNotaInfoIdentificacao identificacao = info.getIdentificacao();
        final NFEndereco endereco = destinatario == null ? null : destinatario.getEndereco();
        titulo(canvas, "DESTINAT\u00c1RIO / REMETENTE");
        linha(canvas, new float[]{60, 22, 18},
                texto("NOME / RAZ\u00c3O SOCIAL", destinatario == null ? "" : destinatario.getRazaoSocial()),
                texto("CNPJ / CPF", destinatario == null ? "" : DanfeFormatador.cnpjOuCpf(destinatario.getCpfj())),
                texto("DATA DE EMISS\u00c3O", identificacao == null ? "" : DanfeFormatador.data(identificacao.getDataHoraEmissao())));
        linha(canvas, new float[]{46, 24.5f, 11.5f, 18},
                texto("ENDERE\u00c7O", endereco == null ? "" : junta(endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento())),
                texto("BAIRRO / DISTRITO", endereco == null ? "" : endereco.getBairro()),
                texto("CEP", endereco == null ? "" : endereco.getCep()),
                texto("DATA DE ENTRADA / SA\u00cdDA", identificacao == null ? "" : DanfeFormatador.data(identificacao.getDataHoraSaidaOuEntrada())));
        linha(canvas, new float[]{30, 18, 12, 22, 18},
                texto("MUNIC\u00cdPIO", endereco == null ? "" : endereco.getDescricaoMunicipio()),
                texto("FONE / FAX", endereco == null ? "" : endereco.getTelefone()),
                texto("UF", endereco == null ? "" : endereco.getUf()),
                texto("INSCRI\u00c7\u00c3O ESTADUAL", destinatario == null ? "" : destinatario.getInscricaoEstadual()),
                texto("HORA DE SA\u00cdDA", identificacao == null ? "" : DanfeFormatador.hora(identificacao.getDataHoraSaidaOuEntrada())));
    }

    /**
     * Junta as partes nao vazias com virgula.
     */
    private static String junta(final String... partes) {
        final StringBuilder resultado = new StringBuilder();
        for (final String parte : partes) {
            if (parte != null && !parte.isEmpty()) {
                resultado.append(resultado.length() == 0 ? "" : ", ").append(parte);
            }
        }
        return resultado.toString();
    }

    /**
     * Desenha a fatura e as duplicatas, somente se houver parcelas.
     */
    private static void fatura(final DanfeCanvas canvas, final NFNotaInfoCobranca cobranca) {
        if (cobranca == null || cobranca.getParcelas() == null || cobranca.getParcelas().isEmpty()) {
            return;
        }
        titulo(canvas, "FATURA / DUPLICATAS");
        final List<NFNotaInfoParcela> parcelas = cobranca.getParcelas();
        for (int i = 0; i < parcelas.size(); i += 3) {
            canvas.garantir(ALTURA_QUADRO);
            for (int j = 0; j < 3 && i + j < parcelas.size(); j++) {
                final NFNotaInfoParcela parcela = parcelas.get(i + j);
                final float x = LARGURA_UTIL * GRUPOS_FATURA[j];
                final float grupo = LARGURA_UTIL * (GRUPOS_FATURA[j + 1] - GRUPOS_FATURA[j]);
                canvas.caixa(x, grupo * 0.3f, ALTURA_QUADRO, "FATURA/DUPLICATA", parcela.getNumeroParcela(), ESQUERDA);
                canvas.caixa(x + grupo * 0.3f, grupo * 0.35f, ALTURA_QUADRO, "VENCIMENTO",
                        parcela.getDataVencimento() == null ? "" : VENCIMENTO.format(parcela.getDataVencimento()), ESQUERDA);
                canvas.caixa(x + grupo * 0.65f, grupo * 0.35f, ALTURA_QUADRO, "VALOR", DanfeFormatador.valor(parcela.getValorParcela()), DIREITA);
            }
            canvas.avancar(ALTURA_QUADRO);
        }
    }

    /**
     * Desenha os totais dos produtos e o total da nota.
     */
    private static void totalProdutos(final DanfeCanvas canvas, final NFNotaInfoICMSTotal icms) {
        titulo(canvas, "TOTAL DOS PRODUTOS E TOTAL DA NOTA");
        linha(canvas, new float[]{1, 1, 1, 1, 1},
                numero("VALOR TOTAL DOS PRODUTOS", icms == null ? null : icms.getValorTotalDosProdutosServicos()),
                numero("VALOR DO FRETE", icms == null ? null : icms.getValorTotalFrete()),
                numero("VALOR DO SEGURO", icms == null ? null : icms.getValorTotalSeguro()),
                numero("DESCONTO", icms == null ? null : icms.getValorTotalDesconto()),
                numero("OUTRAS DESPESAS", icms == null ? null : icms.getOutrasDespesasAcessorias()));
        linha(canvas, new float[]{1, 4}, numero("VALOR TOTAL DA NOTA", icms == null ? null : icms.getValorTotalNFe()), texto("", ""));
    }

    /**
     * Desenha o total do ICMS/IPI e, quando existirem no XML, os campos facultativos (FCP, DIFAL e monofasicos).
     */
    private static void totalIcms(final DanfeCanvas canvas, final NFNotaInfoICMSTotal icms) {
        titulo(canvas, "TOTAL DO ICMS / IPI");
        linha(canvas, new float[]{1, 1, 1, 1, 1},
                numero("BASE DE C\u00c1LCULO DO ICMS", icms == null ? null : icms.getBaseCalculoICMS()),
                numero("VALOR DO ICMS", icms == null ? null : icms.getValorTotalICMS()),
                numero("BASE DE C\u00c1LCULO DO ICMS ST", icms == null ? null : icms.getBaseCalculoICMSST()),
                numero("VALOR DO ICMS ST", icms == null ? null : icms.getValorTotalICMSST()),
                numero("VALOR DO IPI", icms == null ? null : icms.getValorTotalIPI()));
        if (icms == null) {
            return;
        }
        final List<Campo> facultativos = new ArrayList<>();
        adicionarSePresente(facultativos, "VALOR DO FCP", icms.getValorTotalFundoCombatePobreza());
        adicionarSePresente(facultativos, "VALOR DO FCP RETIDO POR ST", icms.getValorTotalFundoCombatePobrezaST());
        adicionarSePresente(facultativos, "VALOR DO DIFAL NA UF DE DESTINO", icms.getValorICMSPartilhaDestinatario());
        adicionarSePresente(facultativos, "VALOR DO FCP NA UF DE DESTINO", icms.getValorICMSFundoCombatePobreza());
        adicionarSePresente(facultativos, "BC (QUANTIDADE) DO ICMS MONOF\u00c1SICO", icms.getQuantidadeTributadaIcmsMonofasico());
        adicionarSePresente(facultativos, "VALOR DO ICMS MONOF\u00c1SICO", icms.getValorTotalIcmsMonofasico());
        adicionarSePresente(facultativos, "BC (QUANTIDADE) DO ICMS MONOF\u00c1SICO POR RETEN\u00c7\u00c3O", icms.getQuantidadeTributadaMonofasicoSujeitoRetencao());
        adicionarSePresente(facultativos, "VALOR DO ICMS MONOF\u00c1SICO POR RETEN\u00c7\u00c3O", icms.getValorTotalIcmsSujeitoRetencao());
        linhasIguais(canvas, facultativos);
    }

    /** Bloco da NT 2026.010 (4.1): os quatro quadros fixos sempre aparecem; os monofasicos so com o grupo gMono. */
    private static void totalIbsCbsIs(final DanfeCanvas canvas, final NFNotaInfoTotal total) {
        final NFNotaInfoIBSCBSTot ibscbs = total == null ? null : total.getIbscbsTot();
        final NFNotaInfoIBSCBSTot.GIBS gibs = ibscbs == null ? null : ibscbs.getGIBS();
        titulo(canvas, "TOTAL DO IBS / CBS / IS");
        linha(canvas, new float[]{1, 1, 1, 1},
                numero("VALOR DA CBS", ibscbs == null || ibscbs.getGCBS() == null ? null : ibscbs.getGCBS().getVCBS()),
                numero("VALOR DO IBS UF", gibs == null || gibs.getGIBSUF() == null ? null : gibs.getGIBSUF().getVIBSUF()),
                numero("VALOR DO IBS MUNIC\u00cdPIO", gibs == null || gibs.getGIBSMun() == null ? null : gibs.getGIBSMun().getVIBSMun()),
                numero("VALOR DO IMPOSTO SELETIVO", total == null || total.getIsTot() == null ? null : total.getIsTot().getVIS()));
        if (ibscbs != null && ibscbs.getGMono() != null) {
            final NFNotaInfoIBSCBSTot.GMono mono = ibscbs.getGMono();
            linha(canvas, new float[]{1, 1, 1, 1},
                    numero("VALOR DO IBS MONOF\u00c1SICO", mono.getVIBSMono()),
                    numero("VALOR DA CBS MONOF\u00c1SICA", mono.getVCBSMono()),
                    numero("VALOR DO IBS MONOF\u00c1SICO POR RETEN\u00c7\u00c3O", mono.getVIBSMonoReten()),
                    numero("VALOR DA CBS MONOF\u00c1SICA POR RETEN\u00c7\u00c3O", mono.getVCBSMonoReten()));
        }
    }

    /**
     * Desenha o calculo do ISSQN, somente se o total do ISSQN existir.
     */
    private static void issqn(final DanfeCanvas canvas, final NFNotaInfo info) {
        final NFNotaInfoTotal total = info.getTotal();
        if (total == null || total.getIssqnTotal() == null) {
            return;
        }
        titulo(canvas, "C\u00c1LCULO DO ISSQN");
        linha(canvas, new float[]{1, 1, 1, 1},
                texto("INSCRI\u00c7\u00c3O MUNICIPAL", info.getEmitente() == null ? "" : info.getEmitente().getInscricaoMunicipal()),
                numero("VALOR TOTAL DOS SERVI\u00c7OS", total.getIssqnTotal().getValorTotalServicosSobNaoIncidenciaNaoTributadosICMS()),
                numero("BASE DE C\u00c1LCULO DO ISSQN", total.getIssqnTotal().getBaseCalculoISS()),
                numero("VALOR DO ISSQN", total.getIssqnTotal().getValorTotalISS()));
    }

    /**
     * Desenha transportador e volumes, somente se o grupo de transporte existir.
     */
    private static void transporte(final DanfeCanvas canvas, final NFNotaInfoTransporte transporte) {
        if (transporte == null) {
            return;
        }
        final NFNotaInfoTransportador transportador = transporte.getTransportador();
        titulo(canvas, "TRANSPORTADOR / VOLUMES TRANSPORTADOS");
        linha(canvas, new float[]{30, 20, 12, 13, 6, 19},
                texto("RAZ\u00c3O SOCIAL", transportador == null ? "" : transportador.getRazaoSocial()),
                texto("FRETE POR CONTA", transporte.getModalidadeFrete() == null ? "" : transporte.getModalidadeFrete().getCodigo() + " - " + transporte.getModalidadeFrete().getDescricao()),
                texto("C\u00d3DIGO ANTT", transporte.getVeiculo() == null ? "" : transporte.getVeiculo().getRegistroNacionalTransportadorCarga()),
                texto("PLACA DO VE\u00cdCULO", transporte.getVeiculo() == null ? "" : transporte.getVeiculo().getPlacaVeiculo()),
                texto("UF", transporte.getVeiculo() == null ? "" : transporte.getVeiculo().getUf()),
                texto("CNPJ / CPF", transportador == null ? "" : DanfeFormatador.cnpjOuCpf(transportador.getCnpj() != null ? transportador.getCnpj() : transportador.getCpf())));
        linha(canvas, new float[]{45, 30, 6, 19},
                texto("ENDERE\u00c7O", transportador == null ? "" : transportador.getEnderecoComplemento()),
                texto("MUNIC\u00cdPIO", transportador == null ? "" : transportador.getNomeMunicipio()),
                texto("UF", transportador == null ? "" : transportador.getUf()),
                texto("INSCRI\u00c7\u00c3O ESTADUAL", transportador == null ? "" : transportador.getInscricaoEstadual()));
        volumes(canvas, transporte.getVolumes());
    }

    /**
     * Desenha uma linha para todos os volumes: quantidades e pesos somados; especie, marca e numeracao do primeiro.
     */
    private static void volumes(final DanfeCanvas canvas, final List<NFNotaInfoVolume> volumes) {
        if (volumes == null || volumes.isEmpty()) {
            return;
        }
        BigInteger quantidade = BigInteger.ZERO;
        BigDecimal bruto = BigDecimal.ZERO;
        BigDecimal liquido = BigDecimal.ZERO;
        for (final NFNotaInfoVolume volume : volumes) {
            quantidade = volume.getQuantidadeVolumesTransportados() == null ? quantidade : quantidade.add(volume.getQuantidadeVolumesTransportados());
            bruto = volume.getPesoBruto() == null ? bruto : bruto.add(new BigDecimal(volume.getPesoBruto()));
            liquido = volume.getPesoLiquido() == null ? liquido : liquido.add(new BigDecimal(volume.getPesoLiquido()));
        }
        final NFNotaInfoVolume primeiro = volumes.get(0);
        // numeracao, peso bruto e peso liquido alinhados com as colunas BASES DE CALCULO, ALIQUOTAS e VALOR DOS TRIBUTOS dos itens
        final float inicioBases = DanfeItens.inicioDaColuna(5);
        linha(canvas, new float[]{inicioBases * 0.2f, inicioBases * 0.4f, inicioBases * 0.4f,
                        DanfeItens.inicioDaColuna(6) - inicioBases, DanfeItens.inicioDaColuna(7) - DanfeItens.inicioDaColuna(6),
                        LARGURA_UTIL - DanfeItens.inicioDaColuna(7)},
                texto("QUANTIDADE", quantidade.toString()),
                texto("ESP\u00c9CIE", primeiro.getEspecieVolumesTransportados()),
                texto("MARCA", primeiro.getMarca()),
                texto("NUMERA\u00c7\u00c3O", primeiro.getNumeracaoVolumesTransportados()),
                numero("PESO BRUTO", bruto.toPlainString()),
                numero("PESO L\u00cdQUIDO", liquido.toPlainString()));
    }
}
