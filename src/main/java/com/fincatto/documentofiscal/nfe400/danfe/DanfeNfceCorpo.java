package com.fincatto.documentofiscal.nfe400.danfe;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe400.classes.NFEndereco;
import com.fincatto.documentofiscal.nfe400.classes.NFProtocoloInfo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoDestinatario;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoEmitente;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoFormaPagamento;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoICMSTotal;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoIdentificacao;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoInformacoesAdicionais;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItem;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoPagamento;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoSuplementar;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;

import java.math.BigDecimal;
import java.util.List;

import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.CENTRO;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.DIREITA;
import static com.fincatto.documentofiscal.nfe400.danfe.DanfeCanvas.Alinhamento.ESQUERDA;

/**
 * Desenho do corpo do cupom DANFE NFC-e, na ordem das divisoes do Manual de Padroes (cabecalho ate a mensagem de interesse do contribuinte).
 *
 * @author Marcos Lombardi de Andrade
 */
final class DanfeNfceCorpo {

    private static final float TAMANHO = 7f;
    private static final float TAMANHO_TOTAL = 8f;
    private static final float ESPACO_SECAO = 4f;
    private static final float FOLGA_COLUNA = 4f;
    /** Espaco entre a quantidade (alinhada a direita) e a unidade. */
    private static final float FOLGA_QUANTIDADE = 8f;
    private static final float ESPESSURA_LINHA_INTEIRA = 1.2f;
    private static final float ESPESSURA_LINHA_FINA = 0.5f;
    private static final float ESPACO_ANTES_DO_CORTE = 12f;
    private static final float ESPACO_DEPOIS_DO_CORTE = 4.5f;
    private static final float ESPACO_LINHA = 1.5f;
    private static final float LADO_QR_CODE = 25 * DanfeCanvas.MM;
    private static final float MARGEM_SEGURA_QR_CODE = 3 * DanfeCanvas.MM;
    /**
     * Espaco que um item ou o inicio de um anexo precisa para nao ficar partido entre duas paginas (so vale quando o cupom e paginado);
     * o item que for mais alto reserva a propria altura.
     */
    private static final float ALTURA_MINIMA_BLOCO = 60f;
    /**
     * Espaco reservado para o trecho de tamanho limitado que vem depois dos itens (totais ate o QR Code), para ele nao ser partido
     * entre duas paginas. As informacoes complementares e os creditos, de tamanho livre, sao paginados linha a linha.
     */
    private static final float RESERVA_FIM_DO_CUPOM = 4000f;

    /**
     * Classe utilitaria, nao deve ser instanciada.
     */
    private DanfeNfceCorpo() {
    }

    /**
     * Desenha o cupom a partir do cursor do canvas, que fica logo abaixo do ultimo elemento desenhado.
     *
     * @param canvas area de desenho, ja com o tamanho de pagina do cupom
     * @param nota nota processada (NFC-e)
     * @param creditos rodape personalizado, ou null
     * @param anexos anexos impressos depois do cupom, cada um depois de uma linha de corte
     */
    static void desenhar(final DanfeCanvas canvas, final NFNotaProcessada nota, final DanfeCreditos creditos, final List<DanfeNfceAnexo> anexos) {
        final NFNotaInfo info = nota.getNota().getInfo();
        cabecalho(canvas, info.getEmitente());
        titulo(canvas);
        itens(canvas, info.getItens());
        final NFNotaInfoICMSTotal total = info.getTotal() == null ? null : info.getTotal().getIcmsTotal();
        final String vNFTot = info.getTotal() == null ? null : info.getTotal().getVNFTot();
        canvas.garantir(RESERVA_FIM_DO_CUPOM);
        totais(canvas, info.getItens() == null ? 0 : info.getItens().size(), total, vNFTot);
        pagamento(canvas, info.getPagamento());
        final NFNotaInfoIdentificacao identificacao = info.getIdentificacao();
        final boolean contingencia = identificacao.getTipoEmissao() == NFTipoEmissao.CONTIGENCIA_OFFLINE;
        final NFNotaInfoInformacoesAdicionais adicionais = info.getInformacoesAdicionais();
        mensagemFiscal(canvas, identificacao, contingencia, adicionais == null ? null : adicionais.getInformacoesAdicionaisInteresseFisco());
        final NFNotaInfoSuplementar suplementar = nota.getNota().getInfoSuplementar();
        consulta(canvas, suplementar, info.getChaveAcesso());
        consumidor(canvas, info.getDestinatario());
        identificacao(canvas, identificacao, contingencia || nota.getProtocolo() == null ? null : nota.getProtocolo().getProtocoloInfo());
        qrCode(canvas, suplementar);
        complementares(canvas, adicionais == null ? null : adicionais.getInformacoesComplementaresInteresseContribuinte());
        creditos(canvas, creditos);
        for (final DanfeNfceAnexo anexo : anexos) {
            anexo(canvas, anexo);
        }
    }

    /**
     * Anexo depois do cupom: linha de corte pontilhada, titulo em negrito (se houver) e texto em fonte monoespacada.
     */
    private static void anexo(final DanfeCanvas canvas, final DanfeNfceAnexo anexo) {
        canvas.garantir(ALTURA_MINIMA_BLOCO);
        canvas.avancar(ESPACO_ANTES_DO_CORTE);
        separador(canvas, ESPESSURA_LINHA_FINA, true);
        canvas.avancar(ESPACO_DEPOIS_DO_CORTE);
        if (anexo.getTitulo() != null && !anexo.getTitulo().isEmpty()) {
            // o titulo tem tamanho livre, como o texto do anexo: num cupom paginado, continua na pagina seguinte em vez de passar do fim
            canvas.textoPaginado(0, canvas.larguraUtil(), anexo.getTitulo(), TAMANHO, CENTRO, true);
            canvas.avancar(ESPACO_LINHA);
        }
        canvas.textoPreformatadoPaginado(0, canvas.larguraUtil(), anexo.getTexto(), TAMANHO);
    }

    /**
     * Divisao V: aviso de homologacao ou de contingencia e a mensagem fiscal (infAdFisco), centralizados.
     */
    private static void mensagemFiscal(final DanfeCanvas canvas, final NFNotaInfoIdentificacao identificacao, final boolean contingencia, final String infAdFisco) {
        boolean desenhou = false;
        if (identificacao.getAmbiente() == DFAmbiente.HOMOLOGACAO) {
            centralizado(canvas, "EMITIDA EM AMBIENTE DE HOMOLOGA\u00c7\u00c3O \u2013 SEM VALOR FISCAL", TAMANHO, true);
            desenhou = true;
        }
        if (contingencia) {
            centralizado(canvas, "EMITIDA EM CONTING\u00caNCIA", TAMANHO, true);
            desenhou = true;
        }
        if (infAdFisco != null && !infAdFisco.isEmpty()) {
            centralizado(canvas, infAdFisco, TAMANHO, false);
            desenhou = true;
        }
        if (desenhou) {
            canvas.avancar(ESPACO_SECAO);
        }
    }

    /**
     * Divisao VI (parte 1): endereco de consulta e chave de acesso em onze blocos de quatro digitos.
     */
    private static void consulta(final DanfeCanvas canvas, final NFNotaInfoSuplementar suplementar, final String chaveAcesso) {
        centralizado(canvas, "Consulte pela Chave de Acesso em", TAMANHO, true);
        if (suplementar != null && suplementar.getUrlConsultaChaveAcesso() != null && !suplementar.getUrlConsultaChaveAcesso().isEmpty()) {
            centralizado(canvas, suplementar.getUrlConsultaChaveAcesso(), TAMANHO, false);
        }
        centralizado(canvas, DanfeFormatador.chaveAcesso(chaveAcesso), TAMANHO, false);
        canvas.avancar(ESPACO_SECAO);
    }

    /**
     * Divisao VII: CNPJ, CPF ou identificacao de estrangeiro do consumidor, com nome e endereco se informados; sem nada disso, nao identificado.
     */
    private static void consumidor(final DanfeCanvas canvas, final NFNotaInfoDestinatario destinatario) {
        final String identificacao = destinatario == null ? null : identificacaoDoConsumidor(destinatario);
        if (identificacao == null) {
            centralizado(canvas, "CONSUMIDOR N\u00c3O IDENTIFICADO", TAMANHO, true);
        } else {
            centralizado(canvas, identificacao, TAMANHO, true);
            if (destinatario.getRazaoSocial() != null && !destinatario.getRazaoSocial().isEmpty()) {
                centralizado(canvas, destinatario.getRazaoSocial(), TAMANHO, false);
            }
            if (destinatario.getEndereco() != null) {
                centralizado(canvas, endereco(destinatario.getEndereco()), TAMANHO, false);
            }
        }
        canvas.avancar(ESPACO_SECAO);
    }

    private static String identificacaoDoConsumidor(final NFNotaInfoDestinatario destinatario) {
        if (destinatario.getCnpj() != null) {
            return "CONSUMIDOR CNPJ: " + DanfeFormatador.cnpjOuCpf(destinatario.getCnpj());
        }
        if (destinatario.getCpf() != null) {
            return "CONSUMIDOR CPF: " + DanfeFormatador.cnpjOuCpf(destinatario.getCpf());
        }
        if (destinatario.getIdEstrangeiro() != null && !destinatario.getIdEstrangeiro().isEmpty()) {
            return "CONSUMIDOR Id. Estrangeiro: " + destinatario.getIdEstrangeiro();
        }
        return null;
    }

    /**
     * Divisao VI (parte 2): numero, serie, emissao e protocolo de autorizacao com data e hora; sem protocolo, nada de protocolo.
     */
    private static void identificacao(final DanfeCanvas canvas, final NFNotaInfoIdentificacao identificacao, final NFProtocoloInfo protocolo) {
        centralizado(canvas, "NFC-e: " + valorOuVazio(identificacao.getNumeroNota()) + " S\u00e9rie: " + valorOuVazio(identificacao.getSerie()), TAMANHO, true);
        centralizado(canvas, "EMISS\u00c3O: " + DanfeFormatador.dataHora(identificacao.getDataHoraEmissao()), TAMANHO, false);
        if (protocolo != null) {
            centralizado(canvas, "PROTOCOLO DE AUTORIZA\u00c7\u00c3O", TAMANHO, true);
            centralizado(canvas, valorOuVazio(protocolo.getNumeroProtocolo()) + " " + DanfeFormatador.dataHoraLocal(protocolo.getDataRecebimento()), TAMANHO, false);
        }
        canvas.avancar(ESPACO_SECAO);
    }

    /**
     * Divisao VIII: QR Code centralizado, 25 mm de conteudo com 3 mm de margem segura, somente se vier no XML.
     */
    private static void qrCode(final DanfeCanvas canvas, final NFNotaInfoSuplementar suplementar) {
        if (suplementar == null || suplementar.getQrCode() == null || suplementar.getQrCode().isEmpty()) {
            return;
        }
        canvas.avancar(MARGEM_SEGURA_QR_CODE);
        canvas.qrCode((canvas.larguraUtil() - LADO_QR_CODE) / 2, LADO_QR_CODE, suplementar.getQrCode());
        canvas.avancar(LADO_QR_CODE + MARGEM_SEGURA_QR_CODE);
    }

    /**
     * Divisao IX: informacoes complementares de interesse do contribuinte (infCpl).
     */
    private static void complementares(final DanfeCanvas canvas, final String infCpl) {
        if (infCpl == null || infCpl.isEmpty()) {
            return;
        }
        canvas.textoPaginado(0, canvas.larguraUtil(), infCpl, TAMANHO, ESQUERDA, false);
        canvas.avancar(ESPACO_SECAO);
    }

    /**
     * Creditos centralizados em negrito, um texto por linha.
     */
    private static void creditos(final DanfeCanvas canvas, final DanfeCreditos creditos) {
        if (creditos == null) {
            return;
        }
        for (final String texto : new String[]{creditos.getEsquerda(), creditos.getDireita()}) {
            if (texto != null && !texto.isEmpty()) {
                canvas.textoPaginado(0, canvas.larguraUtil(), texto, TAMANHO, CENTRO, true);
            }
        }
    }

    /**
     * Divisao I: razao social, CNPJ e IE, e endereco sem o pais.
     */
    private static void cabecalho(final DanfeCanvas canvas, final NFNotaInfoEmitente emitente) {
        centralizado(canvas, emitente.getRazaoSocial(), TAMANHO_TOTAL, true);
        final String ie = emitente.getInscricaoEstadual() == null ? "" : " - IE " + emitente.getInscricaoEstadual();
        final String rotuloDocumento = emitente.getCpf() != null && !emitente.getCpf().isEmpty() ? "CPF " : "CNPJ ";
        centralizado(canvas, rotuloDocumento + DanfeFormatador.cnpjOuCpf(emitente.getCpfj()) + ie, TAMANHO, true);
        centralizado(canvas, endereco(emitente.getEndereco()), TAMANHO, false);
        canvas.avancar(ESPACO_SECAO);
    }

    /**
     * Junta logradouro, numero, complemento, bairro, municipio e UF no formato do cupom, sem o pais.
     */
    private static String endereco(final NFEndereco endereco) {
        if (endereco == null) {
            return "";
        }
        final StringBuilder texto = new StringBuilder(valorOuVazio(endereco.getLogradouro()));
        acrescentar(texto, ", Nº ", endereco.getNumero());
        acrescentar(texto, " - ", endereco.getComplemento());
        acrescentar(texto, " - ", endereco.getBairro());
        acrescentar(texto, " - ", endereco.getDescricaoMunicipio());
        acrescentar(texto, " / ", endereco.getUf());
        return texto.toString();
    }

    private static void acrescentar(final StringBuilder texto, final String separador, final String valor) {
        if (valor != null && !valor.isEmpty()) {
            texto.append(separador).append(valor);
        }
    }

    /**
     * Divisao II: identificacao do documento.
     */
    private static void titulo(final DanfeCanvas canvas) {
        centralizado(canvas, "DANFE NFC-e DOCUMENTO AUXILIAR DA NOTA FISCAL DE CONSUMIDOR ELETRÔNICA", TAMANHO, true);
        canvas.avancar(ESPACO_SECAO);
    }

    /**
     * Divisao III: uma linha com codigo e descricao e outra com quantidade, unidade, valor unitario e valor total de cada item.
     * As colunas tem a largura do maior valor impresso, para nada ser cortado em papel estreito. O codigo ocupa uma coluna propria, para
     * a descricao ficar alinhada com o titulo DESCRICAO, e a quantidade fica a direita, abaixo do titulo QTDE.
     */
    private static void itens(final DanfeCanvas canvas, final List<NFNotaInfoItem> itens) {
        if (itens == null || itens.isEmpty()) {
            return;
        }
        float larguraCodigo = canvas.larguraNegrito("CÓDIGO", TAMANHO);
        float larguraQuantidade = canvas.larguraNegrito("QTDE", TAMANHO);
        float larguraUnidade = canvas.larguraNegrito("UN", TAMANHO);
        float larguraUnitario = canvas.larguraNegrito("VL UNIT", TAMANHO);
        float larguraTotal = canvas.larguraNegrito("VL TOTAL", TAMANHO);
        for (final NFNotaInfoItem item : itens) {
            larguraCodigo = Math.max(larguraCodigo, canvas.largura(valorOuVazio(item.getProduto().getCodigo()), TAMANHO));
            larguraQuantidade = Math.max(larguraQuantidade, canvas.largura(quantidade(item.getProduto().getQuantidadeComercial()), TAMANHO));
            larguraUnidade = Math.max(larguraUnidade, canvas.largura(valorOuVazio(item.getProduto().getUnidadeComercial()), TAMANHO));
            larguraUnitario = Math.max(larguraUnitario, canvas.largura(valorItem(item.getProduto().getValorUnitario()), TAMANHO));
            larguraTotal = Math.max(larguraTotal, canvas.largura(valorItem(item.getProduto().getValorTotalBruto()), TAMANHO));
        }
        // os valores de uma NFC-e (ate R$ 200.000,00) cabem lado a lado; valores fora do comum podem passar da largura util: as colunas sao
        // estreitadas ate caber, sem passar abaixo da largura do titulo, e o valor que nao couber quebra em mais linhas, sem perder digitos
        final float[] colunas = estreitar(new float[]{larguraQuantidade + FOLGA_QUANTIDADE, larguraUnidade + FOLGA_COLUNA, larguraUnitario + FOLGA_COLUNA, larguraTotal + FOLGA_COLUNA},
                new float[]{canvas.larguraNegrito("QTDE", TAMANHO) + FOLGA_QUANTIDADE, canvas.larguraNegrito("UN", TAMANHO) + FOLGA_COLUNA, canvas.larguraNegrito("VL UNIT", TAMANHO) + FOLGA_COLUNA,
                        canvas.larguraNegrito("VL TOTAL", TAMANHO) + FOLGA_COLUNA},
                canvas.larguraUtil());
        larguraQuantidade = colunas[0];
        larguraUnidade = colunas[1];
        larguraUnitario = colunas[2];
        larguraTotal = colunas[3];
        final float larguraTexto = canvas.larguraUtil() - larguraQuantidade - larguraUnidade - larguraUnitario - larguraTotal;
        // o codigo nao pode tomar mais que a metade da linha nem o espaco do titulo DESCRICAO
        final float larguraTituloDescricao = canvas.larguraNegrito("DESCRIÇÃO", TAMANHO) + FOLGA_COLUNA;
        larguraCodigo = Math.min(Math.min(larguraCodigo, canvas.larguraUtil() / 2) + FOLGA_COLUNA, canvas.larguraUtil() - larguraTituloDescricao);
        // codigo e descricao sempre em uma linha so: o que nao couber e cortado
        final float larguraLinhaDescricao = canvas.larguraUtil() - larguraCodigo;
        separador(canvas, ESPESSURA_LINHA_INTEIRA, false);
        canvas.texto(0, larguraCodigo, "CÓDIGO", TAMANHO, ESQUERDA, true);
        final float alturaTituloDescricao = canvas.texto(larguraCodigo, larguraLinhaDescricao, "DESCRIÇÃO", TAMANHO, ESQUERDA, true);
        // QTDE fica alinhada a direita na sua coluna; se o titulo DESCRICAO chegar ate ela, os titulos das colunas vao para a linha de baixo, como nos itens
        if (larguraCodigo + larguraTituloDescricao > larguraTexto + larguraQuantidade - FOLGA_QUANTIDADE - canvas.larguraNegrito("QTDE", TAMANHO)) {
            canvas.avancar(alturaTituloDescricao);
        }
        linhaDeColunas(canvas, larguraTexto, larguraQuantidade, larguraUnidade, larguraUnitario, larguraTotal, "QTDE", "UN", "VL UNIT", "VL TOTAL", true);
        for (final NFNotaInfoItem item : itens) {
            final String codigo = cortar(canvas, valorOuVazio(item.getProduto().getCodigo()), larguraCodigo - FOLGA_COLUNA);
            final String descricao = cortar(canvas, valorOuVazio(item.getProduto().getDescricao()), larguraLinhaDescricao);
            final String quantidade = quantidade(item.getProduto().getQuantidadeComercial());
            final String unidade = valorOuVazio(item.getProduto().getUnidadeComercial());
            final String unitario = valorItem(item.getProduto().getValorUnitario());
            final String total = valorItem(item.getProduto().getValorTotalBruto());
            // a linha das colunas pode ocupar mais de uma linha de texto quando algum valor foi quebrado
            final int linhasColunas = Math.max(Math.max(canvas.quebrar(quantidade, larguraQuantidade - FOLGA_QUANTIDADE, TAMANHO).size(),
                    canvas.quebrar(unidade, larguraUnidade - FOLGA_COLUNA, TAMANHO).size()), Math.max(canvas.quebrar(unitario, larguraUnitario - FOLGA_COLUNA, TAMANHO).size(),
                    canvas.quebrar(total, larguraTotal - FOLGA_COLUNA, TAMANHO).size()));
            canvas.garantir(Math.max(ALTURA_MINIMA_BLOCO, 2 * ESPACO_LINHA + ESPESSURA_LINHA_FINA + (1 + linhasColunas) * canvas.alturaLinha(TAMANHO)));
            separador(canvas, ESPESSURA_LINHA_FINA, false);
            canvas.texto(0, larguraCodigo, codigo, TAMANHO, ESQUERDA, false);
            canvas.avancar(canvas.texto(larguraCodigo, larguraLinhaDescricao, descricao, TAMANHO, ESQUERDA, false));
            linhaDeColunas(canvas, larguraTexto, larguraQuantidade, larguraUnidade, larguraUnitario, larguraTotal, quantidade, unidade, unitario, total, false);
        }
        separador(canvas, ESPESSURA_LINHA_INTEIRA, false);
    }

    /**
     * Corta o texto no fim para ele caber em uma linha da largura informada.
     */
    private static String cortar(final DanfeCanvas canvas, final String texto, final float largura) {
        String cortado = texto;
        while (cortado.length() > 1 && canvas.largura(cortado, TAMANHO) > largura) {
            cortado = cortado.substring(0, cortado.length() - 1);
        }
        return cortado.trim();
    }

    /**
     * Desenha quatro colunas na mesma linha, apos a largura reservada ao texto (codigo e descricao): quantidade, unidade, valor unitario e
     * valor total, todas alinhadas a direita, exceto a unidade. Avanca o cursor.
     */
    private static void linhaDeColunas(final DanfeCanvas canvas, final float larguraTexto, final float larguraQuantidade, final float larguraUnidade,
                                       final float larguraUnitario, final float larguraTotal, final String quantidade, final String unidade,
                                       final String unitario, final String total, final boolean negrito) {
        float altura = canvas.texto(larguraTexto, larguraQuantidade - FOLGA_QUANTIDADE, quantidade, TAMANHO, DIREITA, negrito);
        // a folga fica fora da largura do texto, para um valor quebrado nao encostar no da coluna vizinha
        altura = Math.max(altura, canvas.texto(larguraTexto + larguraQuantidade, larguraUnidade - FOLGA_COLUNA, unidade, TAMANHO, ESQUERDA, negrito));
        altura = Math.max(altura, canvas.texto(larguraTexto + larguraQuantidade + larguraUnidade + FOLGA_COLUNA, larguraUnitario - FOLGA_COLUNA, unitario, TAMANHO, DIREITA, negrito));
        altura = Math.max(altura, canvas.texto(larguraTexto + larguraQuantidade + larguraUnidade + larguraUnitario + FOLGA_COLUNA, larguraTotal - FOLGA_COLUNA, total, TAMANHO, DIREITA,
                negrito));
        canvas.avancar(altura);
    }

    /**
     * Estreita as colunas para que a soma caiba na largura disponivel: cada uma perde a mesma fracao do que tem acima da sua largura
     * minima (a do titulo). Se nem as minimas couberem, todas encolhem na mesma proporcao.
     *
     * @param colunas larguras desejadas
     * @param minimas larguras minimas, na mesma ordem
     * @param disponivel largura total disponivel
     * @return larguras ajustadas, com soma menor ou igual a disponivel
     */
    private static float[] estreitar(final float[] colunas, final float[] minimas, final float disponivel) {
        float soma = 0f;
        float somaMinimas = 0f;
        for (int i = 0; i < colunas.length; i++) {
            soma += colunas[i];
            somaMinimas += minimas[i];
        }
        if (soma <= disponivel) {
            return colunas;
        }
        final float[] ajustadas = new float[colunas.length];
        for (int i = 0; i < colunas.length; i++) {
            ajustadas[i] = somaMinimas <= disponivel
                    ? minimas[i] + (colunas[i] - minimas[i]) * (disponivel - somaMinimas) / (soma - somaMinimas)
                    : minimas[i] * Math.max(0f, disponivel) / somaMinimas;
        }
        return ajustadas;
    }

    /**
     * Divisao IV: quantidade de itens, subtotal, desconto e acrescimo (so se existirem) e valor total (vNFTot, com IBS/CBS/IS, quando informado; senao ICMSTot.vNF).
     */
    private static void totais(final DanfeCanvas canvas, final int quantidadeDeItens, final NFNotaInfoICMSTotal total, final String vNFTot) {
        parLinha(canvas, "QTD. TOTAL DE ITENS", String.valueOf(quantidadeDeItens), TAMANHO, false);
        if (total == null) {
            return;
        }
        parLinha(canvas, "SUB-TOTAL", dinheiro(total.getValorTotalDosProdutosServicos(), 2), TAMANHO, false);
        if (positivo(total.getValorTotalDesconto())) {
            parLinha(canvas, "DESCONTO", "-" + dinheiro(total.getValorTotalDesconto(), 2), TAMANHO, false);
        }
        final BigDecimal acrescimo = soma(total.getOutrasDespesasAcessorias(), total.getValorTotalFrete(), total.getValorTotalSeguro());
        if (acrescimo.signum() > 0) {
            parLinha(canvas, "ACRÉSCIMO", dinheiro(acrescimo.toPlainString(), 2), TAMANHO, false);
        }
        parLinha(canvas, "VALOR TOTAL", dinheiro(vNFTot == null || vNFTot.trim().isEmpty() ? total.getValorTotalNFe() : vNFTot, 2), TAMANHO_TOTAL, true);
    }

    /**
     * Forma de pagamento e valor pago, uma linha por forma, e o troco quando houver.
     */
    private static void pagamento(final DanfeCanvas canvas, final NFNotaInfoPagamento pagamento) {
        if (pagamento == null || pagamento.getDetalhamentoFormasPagamento() == null || pagamento.getDetalhamentoFormasPagamento().isEmpty()) {
            return;
        }
        parLinha(canvas, "FORMA PAGAMENTO", "VALOR PAGO", TAMANHO, false);
        for (final NFNotaInfoFormaPagamento forma : pagamento.getDetalhamentoFormasPagamento()) {
            // xPag (descricao informada pelo emitente) tem prioridade; a descricao do enum e a alternativa
            final String meio = forma.getDescricaoMeioPagamento() != null && !forma.getDescricaoMeioPagamento().isEmpty()
                    ? forma.getDescricaoMeioPagamento()
                    : forma.getMeioPagamento() == null ? "" : forma.getMeioPagamento().getDescricao();
            parLinha(canvas, meio, dinheiro(forma.getValorPagamento(), 2), TAMANHO, false);
        }
        if (positivo(pagamento.getValorTroco())) {
            parLinha(canvas, "TROCO", dinheiro(pagamento.getValorTroco(), 2), TAMANHO, false);
        }
        separador(canvas, ESPESSURA_LINHA_INTEIRA, false);
    }

    /**
     * Linha divisoria na largura util, com um respiro acima e abaixo.
     */
    private static void separador(final DanfeCanvas canvas, final float espessura, final boolean pontilhada) {
        canvas.avancar(ESPACO_LINHA);
        canvas.linhaHorizontal(0, canvas.larguraUtil(), espessura, pontilhada);
        canvas.avancar(espessura + ESPACO_LINHA);
    }

    /**
     * Rotulo a esquerda e valor a direita na mesma linha; o rotulo quebra se nao couber ao lado do valor.
     */
    private static void parLinha(final DanfeCanvas canvas, final String esquerda, final String direita, final float tamanho, final boolean negrito) {
        final float larguraDireita = canvas.largura(direita, tamanho) + FOLGA_COLUNA;
        final float alturaEsquerda = canvas.texto(0, canvas.larguraUtil() - larguraDireita, esquerda, tamanho, ESQUERDA, negrito);
        final float alturaDireita = canvas.texto(canvas.larguraUtil() - larguraDireita, larguraDireita, direita, tamanho, DIREITA, negrito);
        canvas.avancar(Math.max(alturaEsquerda, alturaDireita));
    }

    /**
     * Texto centralizado na largura util; quebra em varias linhas se precisar.
     */
    private static void centralizado(final DanfeCanvas canvas, final String texto, final float tamanho, final boolean negrito) {
        canvas.avancar(canvas.texto(0, canvas.larguraUtil(), texto, tamanho, CENTRO, negrito));
    }

    /**
     * "R$ " mais o valor do XML no formato brasileiro, com ao menos as casas decimais pedidas e sem zeros a mais.
     */
    private static String dinheiro(final String valorXml, final int casasMinimas) {
        if (valorXml == null) {
            return "";
        }
        return "R$ " + DanfeFormatador.valor(semZerosAMais(valorXml, casasMinimas));
    }

    /**
     * Valor do item no formato brasileiro, sem o "R$ " (a coluna ja e de valores em reais), com ao menos duas casas decimais.
     */
    private static String valorItem(final String valorXml) {
        return valorXml == null ? "" : DanfeFormatador.valor(semZerosAMais(valorXml, 2));
    }

    /**
     * Quantidade sem zeros a direita (1.0000 vira 1; 0.5000 vira 0,5).
     */
    private static String quantidade(final String valorXml) {
        return valorXml == null ? "" : DanfeFormatador.valor(semZerosAMais(valorXml, 0));
    }

    private static String semZerosAMais(final String valorXml, final int casasMinimas) {
        final BigDecimal valor = new BigDecimal(valorXml).stripTrailingZeros();
        return valor.setScale(Math.max(valor.scale(), casasMinimas)).toPlainString();
    }

    private static boolean positivo(final String valorXml) {
        return valorXml != null && new BigDecimal(valorXml).signum() > 0;
    }

    private static BigDecimal soma(final String... valoresXml) {
        BigDecimal total = BigDecimal.ZERO;
        for (final String valor : valoresXml) {
            total = valor == null ? total : total.add(new BigDecimal(valor));
        }
        return total;
    }

    private static String valorOuVazio(final String valor) {
        return valor == null ? "" : valor;
    }
}
