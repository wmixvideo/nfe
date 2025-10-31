package com.fincatto.documentofiscal.nfse.utils;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalDPS;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfDPS;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfDPSTipoEmitente;
import com.fincatto.documentofiscal.utils.DFUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Classe utilitária para operações relacionadas à DPS (Documento de Prestação de Serviços) na NFSe.
 */
public abstract class NFSeDPSUtils {

    /**
     * Gera o ID da DPS conforme o layout definido na especificação técnica
     * "DPS" + Cód.Mun (7) + Tipo de Inscrição Federal (1) + Inscrição Federal (14 - CPF completar com 000 à esquerda) + Série DPS (5)+ Núm. DPS (15)
     *
     * @param dps DPS para geração do ID
     * @return ID da DPS conforme o layout definido
     */
    public static String gerarId(final NFSeSefinNacionalDPS dps) {
        // Valido as informações necessárias para montar o ID
        assert dps != null : "DPS deve estar preenchido para gerar o ID";
        final NFSeSefinNacionalInfDPS infDps = dps.getInfDPS();
        assert infDps != null : "InfDPS deve estar preenchido para gerar o ID";
        final String codigoMunicipioEmissao = infDps.getCodigoMunicipioEmissao();
        assert codigoMunicipioEmissao != null : "Código do município de emissão não pode ser nulo para geração do ID da DPS";
        final String serie = infDps.getSerie();
        assert serie != null : "Série do DPS não pode ser nula para geração do ID da DPS";
        final String numeroDPS = infDps.getNumeroDPS();
        assert numeroDPS != null : "Número do DPS não pode ser nulo para geração do ID da DPS";

        // Monto a inscrição federal de acordo com o emitente
        final var inscricaoFederalEmitente = getInscricaoFederalEmitente(infDps);
        assert inscricaoFederalEmitente != null : "Inscrição Federal do emitente não pode ser nula para geração do ID da DPS";

        final var tipoInscricaoFederal = DFUtils.isCpfValido(inscricaoFederalEmitente) ? 1 : (DFUtils.isCnpjValido(inscricaoFederalEmitente) ? 2 : 0);
        assert tipoInscricaoFederal != 0 : "Inscrição Federal do emitente inválida para geração do ID da DPS";

        // Formata os campos conforme o layout do ID
        final var codigoMunicipioEmissaoFormatado = StringUtils.leftPad(codigoMunicipioEmissao, 7, '0');
        final var inscricaoFederalFormatada = StringUtils.leftPad(inscricaoFederalEmitente, 14, '0');
        final var serieFormatada = StringUtils.leftPad(serie, 5, '0');
        final var numeroDPSFormatado = StringUtils.leftPad(numeroDPS, 15, '0');
        return String.format("DPS%s%s%s%s%s", codigoMunicipioEmissaoFormatado, tipoInscricaoFederal, inscricaoFederalFormatada, serieFormatada, numeroDPSFormatado);
    }

    /**
     * Obtém a inscrição federal do emitente (prestador, tomador ou intermediário) conforme o tipo de emitente
     *
     * @param infDps Informações do DPS.
     * @return Inscrição federal do emitente.
     */
    private static String getInscricaoFederalEmitente(NFSeSefinNacionalInfDPS infDps) {
        NFSeSefinNacionalInfDPSTipoEmitente tipoEmitente = infDps.getTipoEmitente();
        assert tipoEmitente != null : "Tipo do emitente deve estar preenchido para obter a inscricao federal";
        switch (tipoEmitente) {
            case PRESTADOR:
                final var prestador = infDps.getPrestador();
                assert prestador != null : "Prestador deve estar preenchido para obter a inscricao federal";
                return StringUtils.firstNonBlank(prestador.getCNPJ(), prestador.getCPF());
            case TOMADOR:
                final var tomador = infDps.getTomador();
                assert tomador != null : "Tomador deve estar preenchido para obter a inscricao federal";
                return StringUtils.firstNonBlank(tomador.getCNPJ(), tomador.getCPF());
            case INTERMEDIARIO:
                final var intermediario = infDps.getIntermediario();
                assert intermediario != null : "Intermediario deve estar preenchido para obter a inscricao federal";
                return StringUtils.firstNonBlank(intermediario.getCNPJ(), intermediario.getCPF());
        }
        return null;
    }
}
