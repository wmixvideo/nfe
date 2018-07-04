package com.fincatto.documentofiscal;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Eldevan Nery Junior on 04/05/18.
 * Define os países e suas descrições conforme tabela da receita:
 * http://www.nfe.fazenda.gov.br/ em Documentos > Diversos >
 *
 * Tabela de País - Relacionada a NT 2018.003. v1.00 (atualizada em 04/05/2018):
 * http://www.nfe.fazenda.gov.br/portal/exibirArquivo.aspx?conteudo=hdos6Z3A8Xc=
 *
 */
public enum DFPais {

    AFEGANISTAO(132, "AFEGANISTAO", LocalDate.of(2006,1,1)),
    ALAND_ILHAS(153, "ALAND, ILHAS", LocalDate.of(2017,1,1)),
    ALBANIA_REPUBLICA_DA(175, "ALBANIA, REPUBLICA  DA", LocalDate.of(2006,1,1)),
    ALEMANHA(230, "ALEMANHA", LocalDate.of(2006,1,1)),
    BURKINA_FASO(310, "BURKINA FASO", LocalDate.of(2006,1,1)),
    ANDORRA(370, "ANDORRA", LocalDate.of(2006,1,1)),
    ANGOLA(400, "ANGOLA", LocalDate.of(2006,1,1)),
    ANGUILLA(418, "ANGUILLA", LocalDate.of(2006,1,1)),
    ANTARTICA(420, "ANTARTICA", LocalDate.of(2017,1,1)),
    ANTIGUA_E_BARBUDA(434, "ANTIGUA E BARBUDA", LocalDate.of(2006,1,1)),
    ANTILHAS_HOLANDESAS(477, "ANTILHAS HOLANDESAS", LocalDate.of(2006,1,1)),
    ARABIA_SAUDITA(531, "ARABIA SAUDITA", LocalDate.of(2006,1,1)),
    ARGELIA(590, "ARGELIA", LocalDate.of(2006,1,1)),
    ARGENTINA(639, "ARGENTINA", LocalDate.of(2006,1,1)),
    ARMENIA_REPUBLICA_DA(647, "ARMENIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    ARUBA(655, "ARUBA", LocalDate.of(2006,1,1)),
    AUSTRALIA(698, "AUSTRALIA", LocalDate.of(2006,1,1)),
    AUSTRIA(728, "AUSTRIA", LocalDate.of(2006,1,1)),
    AZERBAIJAO_REPUBLICA_DO(736, "AZERBAIJAO, REPUBLICA DO", LocalDate.of(2006,1,1)),
    BAHAMAS_ILHAS(779, "BAHAMAS, ILHAS", LocalDate.of(2006,1,1)),
    BAHREIN_ILHAS(809, "BAHREIN, ILHAS", LocalDate.of(2006,1,1)),
    BANGLADESH(817, "BANGLADESH", LocalDate.of(2006,1,1)),
    BARBADOS(833, "BARBADOS", LocalDate.of(2006,1,1)),
    BELARUS_REPUBLICA_DA(850, "BELARUS, REPUBLICA DA", LocalDate.of(2006,1,1)),
    BELGICA(876, "BELGICA", LocalDate.of(2006,1,1)),
    BELIZE(884, "BELIZE", LocalDate.of(2006,1,1)),
    BERMUDAS(906, "BERMUDAS", LocalDate.of(2006,1,1)),
    MIANMAR_BIRMANIA(930, "MIANMAR (BIRMANIA)", LocalDate.of(2006,1,1)),
    BOLIVIA_ESTADO_PLURINACIONAL_DA(973, "BOLIVIA, ESTADO PLURINACIONAL DA", LocalDate.of(2006,1,1)),
    BOSNIA_HERZEGOVINA_REPUBLICA_DA(981, "BOSNIA-HERZEGOVINA (REPUBLICA DA)", LocalDate.of(2006,1,1)),
    BONAIRE(990, "BONAIRE", LocalDate.of(2017,1,1)),
    BOTSUANA(1015, "BOTSUANA", LocalDate.of(2006,1,1)),
    BOUVET_ILHA(1023, "BOUVET, ILHA", LocalDate.of(2017,1,1)),
    BRASIL(1058, "BRASIL", LocalDate.of(2006,1,1)),
    BRUNEI(1082, "BRUNEI", LocalDate.of(2006,1,1)),
    BULGARIA_REPUBLICA_DA(1112, "BULGARIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    BURUNDI(1155, "BURUNDI", LocalDate.of(2006,1,1)),
    BUTAO(1198, "BUTAO", LocalDate.of(2006,1,1)),
    CABO_VERDE_REPUBLICA_DE(1279, "CABO VERDE, REPUBLICA DE", LocalDate.of(2006,1,1)),
    CAYMAN_ILHAS(1376, "CAYMAN, ILHAS", LocalDate.of(2006,1,1)),
    CAMBOJA(1414, "CAMBOJA", LocalDate.of(2006,1,1)),
    CAMAROES(1457, "CAMAROES", LocalDate.of(2006,1,1)),
    CANADA(1490, "CANADA", LocalDate.of(2006,1,1)),
    CAZAQUISTAO_REPUBLICA_DO(1538, "CAZAQUISTAO, REPUBLICA DO", LocalDate.of(2006,1,1)),
    CATAR(1546, "CATAR", LocalDate.of(2006,1,1)),
    CHILE(1589, "CHILE", LocalDate.of(2006,1,1)),
    CHINA_REPUBLICA_POPULAR(1600, "CHINA, REPUBLICA POPULAR", LocalDate.of(2006,1,1)),
    FORMOSA_TAIWAN(1619, "FORMOSA (TAIWAN)", LocalDate.of(2006,1,1)),
    CHIPRE(1635, "CHIPRE", LocalDate.of(2006,1,1)),
    COCOS_KEELING_ILHAS(1651, "COCOS(KEELING),ILHAS", LocalDate.of(2006,1,1)),
    COLOMBIA(1694, "COLOMBIA", LocalDate.of(2006,1,1)),
    COMORES_ILHAS(1732, "COMORES, ILHAS", LocalDate.of(2006,1,1)),
    CONGO(1775, "CONGO", LocalDate.of(2006,1,1)),
    COOK_ILHAS(1830, "COOK, ILHAS", LocalDate.of(2006,1,1)),
    COREIA_DO_NORTE__REP_POP_DEMOCRATICA(1872, "COREIA (DO NORTE), REP.POP.DEMOCRATICA", LocalDate.of(2006,1,1)),
    COREIA_DO_SUL__REPUBLICA_DA(1902, "COREIA (DO SUL), REPUBLICA DA", LocalDate.of(2006,1,1)),
    COSTA_DO_MARFIM(1937, "COSTA DO MARFIM", LocalDate.of(2006,1,1)),
    CROACIA_REPUBLICA_DA(1953, "CROACIA (REPUBLICA DA)", LocalDate.of(2006,1,1)),
    COSTA_RICA(1961, "COSTA RICA", LocalDate.of(2006,1,1)),
    KUWAIT(1988, "KUWAIT", LocalDate.of(2006,1,1)),
    CUBA(1996, "CUBA", LocalDate.of(2006,1,1)),
    CURACAO(2003, "CURACAO", LocalDate.of(2017,1,1)),
    BENIN(2291, "BENIN", LocalDate.of(2006,1,1)),
    DINAMARCA(2321, "DINAMARCA", LocalDate.of(2006,1,1)),
    DOMINICA_ILHA(2356, "DOMINICA,ILHA", LocalDate.of(2006,1,1)),
    EQUADOR(2399, "EQUADOR", LocalDate.of(2006,1,1)),
    EGITO(2402, "EGITO", LocalDate.of(2006,1,1)),
    ERITREIA(2437, "ERITREIA", LocalDate.of(2006,1,1)),
    EMIRADOS_ARABES_UNIDOS(2445, "EMIRADOS ARABES UNIDOS", LocalDate.of(2006,1,1)),
    ESPANHA(2453, "ESPANHA", LocalDate.of(2006,1,1)),
    ESLOVENIA_REPUBLICA_DA(2461, "ESLOVENIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    ESLOVACA_REPUBLICA(2470, "ESLOVACA, REPUBLICA", LocalDate.of(2006,1,1)),
    ESTADOS_UNIDOS(2496, "ESTADOS UNIDOS", LocalDate.of(2006,1,1)),
    ESTONIA_REPUBLICA_DA(2518, "ESTONIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    ETIOPIA(2534, "ETIOPIA", LocalDate.of(2006,1,1)),
    FALKLAND_ILHAS_MALVINAS(2550, "FALKLAND (ILHAS MALVINAS)", LocalDate.of(2006,1,1)),
    FEROE_ILHAS(2593, "FEROE, ILHAS", LocalDate.of(2006,1,1)),
    FILIPINAS(2674, "FILIPINAS", LocalDate.of(2006,1,1)),
    FINLANDIA(2712, "FINLANDIA", LocalDate.of(2006,1,1)),
    FRANCA(2755, "FRANCA", LocalDate.of(2006,1,1)),
    GABAO(2810, "GABAO", LocalDate.of(2006,1,1)),
    GAMBIA(2852, "GAMBIA", LocalDate.of(2006,1,1)),
    GANA(2895, "GANA", LocalDate.of(2006,1,1)),
    GEORGIA_REPUBLICA_DA(2917, "GEORGIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    ILHAS_GEORGIA_DO_SUL_E_SANDWICH_DO_SUL(2925, "ILHAS GEORGIA DO SUL E SANDWICH DO SUL", LocalDate.of(2017,1,1)),
    GIBRALTAR(2933, "GIBRALTAR", LocalDate.of(2006,1,1)),
    GRANADA(2976, "GRANADA", LocalDate.of(2006,1,1)),
    GRECIA(3018, "GRECIA", LocalDate.of(2006,1,1)),
    GROENLANDIA(3050, "GROENLANDIA", LocalDate.of(2006,1,1)),
    GUADALUPE(3093, "GUADALUPE", LocalDate.of(2006,1,1)),
    GUAM(3131, "GUAM", LocalDate.of(2006,1,1)),
    GUATEMALA(3174, "GUATEMALA", LocalDate.of(2006,1,1)),
    GUERNSEY_ILHA_DO_CANAL_INCLUI_ALDERNEY_E_SARK(3212, "GUERNSEY, ILHA DO CANAL (INCLUI ALDERNEY E SARK)", LocalDate.of(2017,1,1)),
    GUIANA_FRANCESA(3255, "GUIANA FRANCESA", LocalDate.of(2006,1,1)),
    GUINE(3298, "GUINE", LocalDate.of(2006,1,1)),
    GUINE_EQUATORIAL(3310, "GUINE-EQUATORIAL", LocalDate.of(2006,1,1)),
    GUINE_BISSAU(3344, "GUINE-BISSAU", LocalDate.of(2006,1,1)),
    GUIANA(3379, "GUIANA", LocalDate.of(2006,1,1)),
    HAITI(3417, "HAITI", LocalDate.of(2006,1,1)),
    ILHA_HEARD_E_ILHAS_MCDONALD(3433, "ILHA HEARD E ILHAS MCDONALD", LocalDate.of(2017,1,1)),
    HONDURAS(3450, "HONDURAS", LocalDate.of(2006,1,1)),
    HONG_KONG(3514, "HONG KONG", LocalDate.of(2006,1,1)),
    HUNGRIA_REPUBLICA_DA(3557, "HUNGRIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    IEMEN(3573, "IEMEN", LocalDate.of(2006,1,1)),
    MAN_ILHA_DE(3595, "MAN, ILHA DE", LocalDate.of(2006,1,1)),
    INDIA(3611, "INDIA", LocalDate.of(2006,1,1)),
    INDONESIA(3654, "INDONESIA", LocalDate.of(2006,1,1)),
    IRAQUE(3697, "IRAQUE", LocalDate.of(2006,1,1)),
    IRA_REPUBLICA_ISLAMICA_DO(3727, "IRA, REPUBLICA ISLAMICA DO", LocalDate.of(2006,1,1)),
    IRLANDA(3751, "IRLANDA", LocalDate.of(2006,1,1)),
    ISLANDIA(3794, "ISLANDIA", LocalDate.of(2006,1,1)),
    ISRAEL(3832, "ISRAEL", LocalDate.of(2006,1,1)),
    ITALIA(3867, "ITALIA", LocalDate.of(2006,1,1)),
    JAMAICA(3913, "JAMAICA", LocalDate.of(2006,1,1)),
    JERSEY_ILHA_DO_CANAL(3930, "JERSEY, ILHA DO CANAL", LocalDate.of(2017,1,1)),
    JOHNSTON_ILHAS(3964, "JOHNSTON, ILHAS", LocalDate.of(2006,1,1)),
    JAPAO(3999, "JAPAO", LocalDate.of(2006,1,1)),
    JORDANIA(4030, "JORDANIA", LocalDate.of(2006,1,1)),
    KIRIBATI(4111, "KIRIBATI", LocalDate.of(2006,1,1)),
    LAOS_REP_POP_DEMOCR_DO(4200, "LAOS, REP.POP.DEMOCR.DO", LocalDate.of(2006,1,1)),
    LEBUAN_ILHAS(4235, "LEBUAN,ILHAS", LocalDate.of(2006,1,1)),
    LESOTO(4260, "LESOTO", LocalDate.of(2006,1,1)),
    LETONIA_REPUBLICA_DA(4278, "LETONIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    LIBANO(4316, "LIBANO", LocalDate.of(2006,1,1)),
    LIBERIA(4340, "LIBERIA", LocalDate.of(2006,1,1)),
    LIBIA(4383, "LIBIA", LocalDate.of(2006,1,1)),
    LIECHTENSTEIN(4405, "LIECHTENSTEIN", LocalDate.of(2006,1,1)),
    LITUANIA_REPUBLICA_DA(4421, "LITUANIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    LUXEMBURGO(4456, "LUXEMBURGO", LocalDate.of(2006,1,1)),
    MACAU(4472, "MACAU", LocalDate.of(2006,1,1)),
    MACEDONIA_ANT_REP_IUGOSLAVA(4499, "MACEDONIA, ANT.REP.IUGOSLAVA", LocalDate.of(2006,1,1)),
    MADAGASCAR(4502, "MADAGASCAR", LocalDate.of(2006,1,1)),
    MADEIRA_ILHA_DA(4525, "MADEIRA, ILHA DA", LocalDate.of(2006,1,1)),
    MALASIA(4553, "MALASIA", LocalDate.of(2006,1,1)),
    MALAVI(4588, "MALAVI", LocalDate.of(2006,1,1)),
    MALDIVAS(4618, "MALDIVAS", LocalDate.of(2006,1,1)),
    MALI(4642, "MALI", LocalDate.of(2006,1,1)),
    MALTA(4677, "MALTA", LocalDate.of(2006,1,1)),
    MARIANAS_DO_NORTE(4723, "MARIANAS DO NORTE", LocalDate.of(2006,1,1)),
    MARROCOS(4740, "MARROCOS", LocalDate.of(2006,1,1)),
    MARSHALL_ILHAS(4766, "MARSHALL,ILHAS", LocalDate.of(2006,1,1)),
    MARTINICA(4774, "MARTINICA", LocalDate.of(2006,1,1)),
    MAURICIO(4855, "MAURICIO", LocalDate.of(2006,1,1)),
    MAURITANIA(4880, "MAURITANIA", LocalDate.of(2006,1,1)),
    MAYOTTE_ILHAS_FRANCESAS(4898, "MAYOTTE (ILHAS FRANCESAS)", LocalDate.of(2017,1,1)),
    MIDWAY_ILHAS(4901, "MIDWAY, ILHAS", LocalDate.of(2006,1,1)),
    MEXICO(4936, "MEXICO", LocalDate.of(2006,1,1)),
    MOLDAVIA_REPUBLICA_DA(4944, "MOLDAVIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    MONACO(4952, "MONACO", LocalDate.of(2006,1,1)),
    MONGOLIA(4979, "MONGOLIA", LocalDate.of(2006,1,1)),
    MONTENEGRO(4985, "MONTENEGRO", LocalDate.of(2006,1,1)),
    MICRONESIA(4995, "MICRONESIA", LocalDate.of(2006,1,1)),
    MONTSERRAT_ILHAS(5010, "MONTSERRAT,ILHAS", LocalDate.of(2006,1,1)),
    MOCAMBIQUE(5053, "MOCAMBIQUE", LocalDate.of(2006,1,1)),
    NAMIBIA(5070, "NAMIBIA", LocalDate.of(2006,1,1)),
    NAURU(5088, "NAURU", LocalDate.of(2006,1,1)),
    CHRISTMAS_ILHA_NAVIDAD(5118, "CHRISTMAS,ILHA (NAVIDAD)", LocalDate.of(2006,1,1)),
    NEPAL(5177, "NEPAL", LocalDate.of(2006,1,1)),
    NICARAGUA(5215, "NICARAGUA", LocalDate.of(2006,1,1)),
    NIGER(5258, "NIGER", LocalDate.of(2006,1,1)),
    NIGERIA(5282, "NIGERIA", LocalDate.of(2006,1,1)),
    NIUE_ILHA(5312, "NIUE,ILHA", LocalDate.of(2006,1,1)),
    NORFOLK_ILHA(5355, "NORFOLK,ILHA", LocalDate.of(2006,1,1)),
    NORUEGA(5380, "NORUEGA", LocalDate.of(2006,1,1)),
    NOVA_CALEDONIA(5428, "NOVA CALEDONIA", LocalDate.of(2006,1,1)),
    PAPUA_NOVA_GUINE(5452, "PAPUA NOVA GUINE", LocalDate.of(2006,1,1)),
    NOVA_ZELANDIA(5487, "NOVA ZELANDIA", LocalDate.of(2006,1,1)),
    VANUATU(5517, "VANUATU", LocalDate.of(2006,1,1)),
    OMA(5568, "OMA", LocalDate.of(2006,1,1)),
    PACIFICO_ILHAS_DO_POSSESSAO_DOS_EUA(5665, "PACIFICO,ILHAS DO (POSSESSAO DOS EUA)", LocalDate.of(2006,1,1)),
    PAISES_BAIXOS_HOLANDA(5738, "PAISES BAIXOS (HOLANDA)", LocalDate.of(2006,1,1)),
    PALAU(5754, "PALAU", LocalDate.of(2006,1,1)),
    PAQUISTAO(5762, "PAQUISTAO", LocalDate.of(2006,1,1)),
    PALESTINA(5780, "PALESTINA", LocalDate.of(2012,11,29)),
    PANAMA(5800, "PANAMA", LocalDate.of(2006,1,1)),
    PARAGUAI(5860, "PARAGUAI", LocalDate.of(2006,1,1)),
    PERU(5894, "PERU", LocalDate.of(2006,1,1)),
    PITCAIRN_ILHA(5932, "PITCAIRN,ILHA", LocalDate.of(2006,1,1)),
    POLINESIA_FRANCESA(5991, "POLINESIA FRANCESA", LocalDate.of(2006,1,1)),
    POLONIA_REPUBLICA_DA(6033, "POLONIA, REPUBLICA DA", LocalDate.of(2006,1,1)),
    PORTUGAL(6076, "PORTUGAL", LocalDate.of(2006,1,1)),
    PORTO_RICO(6114, "PORTO RICO", LocalDate.of(2006,1,1)),
    QUENIA(6238, "QUENIA", LocalDate.of(2006,1,1)),
    QUIRGUIZ_REPUBLICA(6254, "QUIRGUIZ, REPUBLICA", LocalDate.of(2006,1,1)),
    REINO_UNIDO(6289, "REINO UNIDO", LocalDate.of(2006,1,1)),
    REPUBLICA_CENTRO_AFRICANA(6408, "REPUBLICA CENTRO-AFRICANA", LocalDate.of(2006,1,1)),
    REPUBLICA_DOMINICANA(6475, "REPUBLICA DOMINICANA", LocalDate.of(2006,1,1)),
    REUNIAO_ILHA(6602, "REUNIAO, ILHA", LocalDate.of(2006,1,1)),
    ZIMBABUE(6653, "ZIMBABUE", LocalDate.of(2006,1,1)),
    ROMENIA(6700, "ROMENIA", LocalDate.of(2006,1,1)),
    RUANDA(6750, "RUANDA", LocalDate.of(2006,1,1)),
    RUSSIA_FEDERACAO_DA(6769, "RUSSIA, FEDERACAO DA", LocalDate.of(2006,1,1)),
    SALOMAO_ILHAS(6777, "SALOMAO, ILHAS", LocalDate.of(2006,1,1)),
    SAARA_OCIDENTAL(6858, "SAARA OCIDENTAL", LocalDate.of(2006,1,1)),
    EL_SALVADOR(6874, "EL SALVADOR", LocalDate.of(2006,1,1)),
    SAMOA(6904, "SAMOA", LocalDate.of(2006,1,1)),
    SAMOA_AMERICANA(6912, "SAMOA AMERICANA", LocalDate.of(2006,1,1)),
    SAO_CRISTOVAO_E_NEVES_ILHAS(6955, "SAO CRISTOVAO E NEVES,ILHAS", LocalDate.of(2006,1,1)),
    SAO_BARTOLOMEU(6939, "SAO BARTOLOMEU", LocalDate.of(2017,1,1)),
    SAN_MARINO(6971, "SAN MARINO", LocalDate.of(2006,1,1)),
    ILHAS_DE_SAO_MARTINHO_PARTE_FRANCESA(6980, "ILHAS DE SAO MARTINHO (PARTE FRANCESA)", LocalDate.of(2017,1,1)),
    SAO_MARTINHO_ILHA_DE_PARTE_FRANCESA(6998, "SAO MARTINHO, ILHA DE (PARTE FRANCESA)", LocalDate.of(2017,1,1)),
    SAO_PEDRO_E_MIQUELON(7005, "SAO PEDRO E MIQUELON", LocalDate.of(2006,1,1)),
    SAO_VICENTE_E_GRANADINAS(7056, "SAO VICENTE E GRANADINAS", LocalDate.of(2006,1,1)),
    SANTA_HELENA(7102, "SANTA HELENA", LocalDate.of(2006,1,1)),
    SANTA_LUCIA(7153, "SANTA LUCIA", LocalDate.of(2006,1,1)),
    SAO_TOME_E_PRINCIPE_ILHAS(7200, "SAO TOME E PRINCIPE, ILHAS", LocalDate.of(2006,1,1)),
    SENEGAL(7285, "SENEGAL", LocalDate.of(2006,1,1)),
    SEYCHELLES(7315, "SEYCHELLES", LocalDate.of(2006,1,1)),
    SERRA_LEOA(7358, "SERRA LEOA", LocalDate.of(2006,1,1)),
    SERVIA(7370, "SERVIA", LocalDate.of(2006,1,1)),
    CINGAPURA(7412, "CINGAPURA", LocalDate.of(2006,1,1)),
    SIRIA_REPUBLICA_ARABE_DA(7447, "SIRIA, REPUBLICA ARABE DA", LocalDate.of(2006,1,1)),
    SOMALIA(7480, "SOMALIA", LocalDate.of(2006,1,1)),
    SRI_LANKA(7501, "SRI LANKA", LocalDate.of(2006,1,1)),
    SUAZILANDIA(7544, "SUAZILANDIA", LocalDate.of(2006,1,1)),
    SVALBARD_E_JAN_MAYERN(7552, "SVALBARD E JAN MAYERN", LocalDate.of(2017,1,1)),
    AFRICA_DO_SUL(7560, "AFRICA DO SUL", LocalDate.of(2006,1,1)),
    SUDAO(7595, "SUDAO", LocalDate.of(2011,7,1)),
    SUD_O_DO_SUL(7600, "SUDÃO DO SUL", LocalDate.of(2006,1,1)),
    SUECIA(7641, "SUECIA", LocalDate.of(2006,1,1)),
    SUICA(7676, "SUICA", LocalDate.of(2006,1,1)),
    SURINAME(7706, "SURINAME", LocalDate.of(2006,1,1)),
    TADJIQUISTAO_REPUBLICA_DO(7722, "TADJIQUISTAO, REPUBLICA DO", LocalDate.of(2006,1,1)),
    TAILANDIA(7765, "TAILANDIA", LocalDate.of(2006,1,1)),
    TANZANIA_REP_UNIDA_DA(7803, "TANZANIA, REP.UNIDA DA", LocalDate.of(2006,1,1)),
    TERRAS_AUSTRAIS_E_ANTARTICAS_FRANCESAS(7811, "TERRAS AUSTRAIS E ANTARTICAS FRANCESAS", LocalDate.of(2017,1,1)),
    TERRITORIO_BRIT_OC_INDICO(7820, "TERRITORIO BRIT.OC.INDICO", LocalDate.of(2006,1,1)),
    DJIBUTI(7838, "DJIBUTI", LocalDate.of(2006,1,1)),
    CHADE(7889, "CHADE", LocalDate.of(2006,1,1)),
    TCHECA_REPUBLICA(7919, "TCHECA, REPUBLICA", LocalDate.of(2006,1,1)),
    TIMOR_LESTE(7951, "TIMOR LESTE", LocalDate.of(2006,1,1)),
    TOGO(8001, "TOGO", LocalDate.of(2006,1,1)),
    TOQUELAU_ILHAS(8052, "TOQUELAU,ILHAS", LocalDate.of(2006,1,1)),
    TONGA(8109, "TONGA", LocalDate.of(2006,1,1)),
    TRINIDAD_E_TOBAGO(8150, "TRINIDAD E TOBAGO", LocalDate.of(2006,1,1)),
    TUNISIA(8206, "TUNISIA", LocalDate.of(2006,1,1)),
    TURCAS_E_CAICOS_ILHAS(8230, "TURCAS E CAICOS,ILHAS", LocalDate.of(2006,1,1)),
    TURCOMENISTAO_REPUBLICA_DO(8249, "TURCOMENISTAO, REPUBLICA DO", LocalDate.of(2006,1,1)),
    TURQUIA(8273, "TURQUIA", LocalDate.of(2006,1,1)),
    TUVALU(8281, "TUVALU", LocalDate.of(2006,1,1)),
    UCRANIA(8311, "UCRANIA", LocalDate.of(2006,1,1)),
    UGANDA(8338, "UGANDA", LocalDate.of(2006,1,1)),
    URUGUAI(8451, "URUGUAI", LocalDate.of(2006,1,1)),
    UZBEQUISTAO_REPUBLICA_DO(8478, "UZBEQUISTAO, REPUBLICA DO", LocalDate.of(2006,1,1)),
    VATICANO_EST_DA_CIDADE_DO(8486, "VATICANO, EST.DA CIDADE DO", LocalDate.of(2006,1,1)),
    VENEZUELA(8508, "VENEZUELA", LocalDate.of(2006,1,1)),
    VIETNA(8583, "VIETNA", LocalDate.of(2006,1,1)),
    VIRGENS_ILHAS_BRITANICAS(8630, "VIRGENS,ILHAS (BRITANICAS)", LocalDate.of(2006,1,1)),
    VIRGENS_ILHAS_E_U_A(8664, "VIRGENS,ILHAS (E.U.A.)", LocalDate.of(2006,1,1)),
    FIJI(8702, "FIJI", LocalDate.of(2006,1,1)),
    WALLIS_E_FUTUNA_ILHAS(8753, "WALLIS E FUTUNA, ILHAS", LocalDate.of(2017,1,1)),
    WAKE_ILHA(8737, "WAKE, ILHA", LocalDate.of(2006,1,1)),
    CONGO_REPUBLICA_DEMOCRATICA_DO(8885, "CONGO, REPUBLICA DEMOCRATICA DO", LocalDate.of(2006,1,1)),
    ZAMBIA(8907, "ZAMBIA", LocalDate.of(2006,1,1));

    private Integer codigo;
    private String descricao;
    private LocalDate dataInicio;

    DFPais(Integer codigo, String descricao, LocalDate dataInicio) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

    public static DFPais valueOfCodigo(Integer codigo){
        return Arrays.stream(DFPais.values())
                .filter(dfPais -> dfPais.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public static DFPais valueOfCodigo(String codigo){
        return Arrays.stream(DFPais.values())
                .filter(dfPais -> dfPais.getCodigo().toString().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public static List<DFPais> getListByDesc(String codigo){
        return Arrays.stream(DFPais.values())
                .filter(dfPais -> StringUtils.containsIgnoreCase(dfPais.getDescricao(),codigo))
                .collect(Collectors.toList());
    }
}
