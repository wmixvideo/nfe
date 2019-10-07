package com.fincatto.documentofiscal.mdfe3.classes;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Eldevan Nery Junior on 02/10/19.
 */
public enum MDFRetornoStatus {

    //  RESULTADO DO PROCESSAMENTO DA SOLICITAÇÃO
    CODIGO_100(100, "Autorizado o uso do MDF-e"),
    CODIGO_101(101, "Cancelamento de MDF-e homologado"),
    CODIGO_103(103, "Arquivo recebido com sucesso"),
    CODIGO_104(104, "Arquivo processado"),
    CODIGO_105(105, "Arquivo em processamento"),
    CODIGO_106(106, "Arquivo n\u00E3o localizado"),
    CODIGO_107(107, "Servi\u00E7o em Opera\u00E7\u00E3o"),
    CODIGO_108(108, "Servi\u00E7o Paralisado Momentaneamente (curto prazo)"),
    CODIGO_109(109, "Servi\u00E7o Paralisado sem Previs\u00E3o"),
    CODIGO_111(111, "Consulta N\u00E3o Encerrados localizou MDF-e nessa situa\u00E7\u00E3o"),
    CODIGO_112(112, "Consulta N\u00E3o Encerrados n\u00E3o localizou MDF-e nessa situa\u00E7\u00E3o"),
    CODIGO_132(132, "Encerramento de MDF-e homologado"),
    CODIGO_134(134, "Evento registrado com alerta para situa\u00E7\u00E3o"),
    CODIGO_135(135, "Evento registrado e vinculado a MDF-e"),
    CODIGO_136(136, "Evento registrado, mas n\u00E3o vinculado a MDF-e "),
    //MOTIVOS DE NÃO ATENDIMENTO DA SOLICITAÇÃO
    CODIGO_202(202, "Rejei\u00E7\u00E3o: CPF do Emitente difere do CPF do Certificado Digital"),
    CODIGO_203(203, "Rejei\u00E7\u00E3o: Emissor n\u00E3o habilitado para emiss\u00E3o do MDF-e"),
    CODIGO_204(204, "Rejei\u00E7\u00E3o: Duplicidade de MDF-e [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODIGO_207(207, "Rejei\u00E7\u00E3o: CNPJ do emitente inv\u00E1lido"),
    CODIGO_209(209, "Rejei\u00E7\u00E3o: IE do emitente inv\u00E1lida"),
    CODIGO_210(210, "Rejei\u00E7\u00E3o: CPF do emitente inv\u00E1lido"),
    CODIGO_212(212, "Rejei\u00E7\u00E3o: Data/hora de emiss\u00E3o MDF-e posterior a data/hora de recebimento"),
    CODIGO_213(213, "Rejei\u00E7\u00E3o: CNPJ-Base do Emitente difere do CNPJ-Base do Certificado Digital"),
    CODIGO_214(214, "Rejei\u00E7\u00E3o: Tamanho da mensagem excedeu o limite estabelecido"),
    CODIGO_215(215, "Rejei\u00E7\u00E3o: Falha no schema XML"),
    CODIGO_216(216, "Rejei\u00E7\u00E3o: Chave de Acesso difere da cadastrada"),
    CODIGO_217(217, "Rejei\u00E7\u00E3o: MDF-e n\u00E3o consta na base de dados da SEFAZ"),
    CODIGO_218(218, "Rejei\u00E7\u00E3o: MDF-e j\u00E1 est\u00E1 cancelado na base de dados da SEFAZ. [nProt:999999999999999][dhCanc: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODIGO_219(219, "Rejei\u00E7\u00E3o: Circula\u00E7\u00E3o do MDF-e verificada"),
    CODIGO_220(220, "Rejei\u00E7\u00E3o: MDF-e autorizado h\u00E1 mais de 24 horas"),
    CODIGO_222(222, "Rejei\u00E7\u00E3o: Protocolo de Autoriza\u00E7\u00E3o de Uso difere do cadastrado"),
    CODIGO_223(223, "Rejei\u00E7\u00E3o: CNPJ / CPF do transmissor do arquivo difere do CNPJ / CPF do transmissor da consulta"),
    CODIGO_225(225, "Rejei\u00E7\u00E3o: Falha no Schema XML do MDF-e"),
    CODIGO_226(226, "Rejei\u00E7\u00E3o: C\u00F3digo da UF do Emitente diverge da UF autorizadora"),
    CODIGO_227(227, "Rejei\u00E7\u00E3o: Erro na composi\u00E7\u00E3o do Campo ID"),
    CODIGO_228(228, "Rejei\u00E7\u00E3o: Data de emiss\u00E3o muito atrasada"),
    CODIGO_229(229, "Rejei\u00E7\u00E3o: IE do emitente n\u00E3o informada"),
    CODIGO_230(230, "Rejei\u00E7\u00E3o: IE do emitente n\u00E3o cadastrada"),
    CODIGO_231(231, "Rejei\u00E7\u00E3o: IE do emitente n\u00E3o vinculada ao CNPJ / CPF"),
    CODIGO_232(232, "Rejei\u00E7\u00E3o: CNPJ do emitente com s\u00E9rie incompat\u00EDvel"),
    CODIGO_233(233, "Rejei\u00E7\u00E3o: CPF do emitente com s\u00E9rie incompat\u00EDvel"),
    CODIGO_234(234, "Rejei\u00E7\u00E3o: Tipo de emitente inv\u00E1lido para emitente pessoa f\u00EDsica"),
    CODIGO_236(236, "Rejei\u00E7\u00E3o: Chave de Acesso inv\u00E1lida [Motivo: XXXXXXXXXXXX]"),
    CODIGO_238(238, "Rejei\u00E7\u00E3o: Cabe\u00E7alho - Vers\u00E3o do arquivo XML superior a Vers\u00E3o vigente"),
    CODIGO_239(239, "Rejei\u00E7\u00E3o: Vers\u00E3o do arquivo XML n\u00E3o suportada"),
    CODIGO_242(242, "Rejei\u00E7\u00E3o: Elemento mdfeCabecMsg inexistente no SOAP Header"),
    CODIGO_243(243, "Rejei\u00E7\u00E3o: XML Mal Formado"),
    CODIGO_244(244, "Rejei\u00E7\u00E3o: Falha na descompacta\u00E7\u00E3o da \u00E1rea de dados"),
    CODIGO_247(247, "Rejei\u00E7\u00E3o: Sigla da UF do Emitente diverge da UF autorizadora"),
    CODIGO_248(248, "Rejei\u00E7\u00E3o: UF do Recibo diverge da UF autorizadora"),
    CODIGO_249(249, "Rejei\u00E7\u00E3o: UF da Chave de Acesso diverge da UF autorizadora"),
    CODIGO_252(252, "Rejei\u00E7\u00E3o: Ambiente informado diverge do Ambiente de recebimento"),
    CODIGO_253(253, "Rejei\u00E7\u00E3o: Digito Verificador da chave de acesso composta inv\u00E1lido"),
    CODIGO_280(280, "Rejei\u00E7\u00E3o: Certificado Transmissor inv\u00E1lido"),
    CODIGO_281(281, "Rejei\u00E7\u00E3o: Certificado Transmissor Data Validade"),
    CODIGO_282(282, "Rejei\u00E7\u00E3o: Certificado Transmissor sem CNPJ / CPF"),
    CODIGO_283(283, "Rejei\u00E7\u00E3o: Certificado Transmissor - erro Cadeia de Certifica\u00E7\u00E3o"),
    CODIGO_284(284, "Rejei\u00E7\u00E3o: Certificado Transmissor revogado"),
    CODIGO_285(285, "Rejei\u00E7\u00E3o: Certificado Transmissor difere ICP-Brasil"),
    CODIGO_286(286, "Rejei\u00E7\u00E3o: Certificado Transmissor erro no acesso a LCR"),
    CODIGO_290(290, "Rejei\u00E7\u00E3o: Certificado Assinatura inv\u00E1lido"),
    CODIGO_291(291, "Rejei\u00E7\u00E3o: Certificado Assinatura Data Validade"),
    CODIGO_292(292, "Rejei\u00E7\u00E3o: Certificado Assinatura sem CNPJ / CPF"),
    CODIGO_293(293, "Rejei\u00E7\u00E3o: Certificado Assinatura - erro Cadeia de Certifica\u00E7\u00E3o"),
    CODIGO_294(294, "Rejei\u00E7\u00E3o: Certificado Assinatura revogado"),
    CODIGO_295(295, "Rejei\u00E7\u00E3o: Certificado Assinatura difere ICP-Brasil"),
    CODIGO_296(296, "Rejei\u00E7\u00E3o: Certificado Assinatura erro no acesso a LCR"),
    CODIGO_297(297, "Rejei\u00E7\u00E3o: Assinatura difere do calculado"),
    CODIGO_298(298, "Rejei\u00E7\u00E3o: Assinatura difere do padr\u00E3o do Projeto"),
    CODIGO_402(402, "Rejei\u00E7\u00E3o: XML da \u00E1rea de dados com codifica\u00E7\u00E3o diferente de UTF-8"),
    CODIGO_404(404, "Rejei\u00E7\u00E3o: Uso de prefixo de namespace n\u00E3o permitido"),
    CODIGO_405(405, "Rejei\u00E7\u00E3o: Munic\u00EDpio de Carregamento inexistente"),
    CODIGO_406(406, "Rejei\u00E7\u00E3o: Munic\u00EDpio de Descarregamento inexistente"),
    CODIGO_407(407, "Rejei\u00E7\u00E3o: C\u00F3digo de Munic\u00EDpio diverge da UF do Emitente do MDF-e"),
    CODIGO_408(408, "Rejei\u00E7\u00E3o: Munic\u00EDpio do Emitente inexistente"),
    CODIGO_409(409, "Rejei\u00E7\u00E3o: Campo cUF inexistente no elemento mdfeCabecMsg do SOAP Header"),
    CODIGO_410(410, "Rejei\u00E7\u00E3o: UF informada no campo cUF n\u00E3o \u00E9 atendida pelo WebService"),
    CODIGO_411(411, "Rejei\u00E7\u00E3o: Campo versaoDados inexistente no elemento mdfeCabecMsg do SOAP Header"),
    CODIGO_454(454, "Rejei\u00E7\u00E3o: Tipo de Transportador para Carga Pr\u00F3pria e Propriet\u00E1rio do ve\u00EDculo diferente do emitente deve ser TAC"),
    CODIGO_456(456, "Rejei\u00E7\u00E3o: C\u00F3digo de Munic\u00EDpio diverge da UF de Carregamento do MDF-e"),
    CODIGO_457(457, "Rejei\u00E7\u00E3o: Tipo de Transportador deve ser diferente de TAC"),
    CODIGO_458(458, "Rejei\u00E7\u00E3o: Tipo de Transportador n\u00E3o deve ser informado para Emitente de Carga Pr\u00F3pria propriet\u00E1rio do ve\u00EDculo"),
    CODIGO_459(459, "Rejei\u00E7\u00E3o: Documento autorizado ao XML duplicado no MDF-e"),
    CODIGO_460(460, "Rejei\u00E7\u00E3o: Consulta a uma Chave de Acesso muito antiga"),
    CODIGO_462(462, "Rejei\u00E7\u00E3o: Existe MDF-e n\u00E3o encerrado h\u00E1 mais de 5 dias para placa com at\u00E9 2 UF de percurso informadas [chMDFe: 99999999999999999999999999999999999999999999][nProt:999999999999999]"),
    CODIGO_473(473, "Rejei\u00E7\u00E3o: Tipo Autorizador do Recibo diverge do \u00D3rg\u00E3o Autorizador"),
    CODIGO_479(479, "Rejei\u00E7\u00E3o: Endere\u00E7o do site da UF da Consulta via QR Code diverge do previsto"),
    CODIGO_480(480, "Rejei\u00E7\u00E3o: O QR Code do MDF-e deve ser informado"),
    CODIGO_481(481, "Rejei\u00E7\u00E3o: Par\u00E2metro chave de acesso do QR Code divergente do MDF-e"),
    CODIGO_482(482, "Rejei\u00E7\u00E3o: Par\u00E2metro sign n\u00E3o informado no QR Code para emiss\u00E3o em conting\u00EAncia"),
    CODIGO_488(488, "Rejei\u00E7\u00E3o: Par\u00E2metro sign n\u00E3o deve ser informado no QR Code para emiss\u00E3o Normal"),
    CODIGO_496(496, "Rejei\u00E7\u00E3o: Assinatura do QR-Code difere do calculado"),
    CODIGO_539(539, "Rejei\u00E7\u00E3o: Duplicidade de MDF-e, com diferen\u00E7a na Chave de Acesso [chMDFe: 99999999999999999999999999999999999999999999] [nProt:999999999999999] [dhAut: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODIGO_540(540, "Rejei\u00E7\u00E3o: N\u00E3o deve ser informado Conhecimento de Transporte para tipo de emitente Prestador Servi\u00E7o de Transporte que emitir\u00E1 CT-e Globalizado"),
    CODIGO_541(541, "Rejei\u00E7\u00E3o: Tipo de emitente inv\u00E1lido para opera\u00E7\u00F5es interestaduais ou com exterior"),
    CODIGO_542(542, "Rejei\u00E7\u00E3o: CNPJ/CPF do respons\u00E1vel pelo seguro deve ser informado para o tipo de respons\u00E1vel informado"),
    CODIGO_577(577, "Rejei\u00E7\u00E3o: Duplicidade de condutor"),
    CODIGO_578(578, "Rejei\u00E7\u00E3o: Informa\u00E7\u00F5es dos tomadores \u00E9 obrigat\u00F3ria para esta opera\u00E7\u00E3o"),
    CODIGO_579(579, "Rejei\u00E7\u00E3o: Vers\u00E3o informada para o modal n\u00E3o suportada"),
    CODIGO_580(580, "Rejei\u00E7\u00E3o: Falha no Schema XML espec\u00EDfico para o modal"),
    CODIGO_598(598, "Rejei\u00E7\u00E3o: Usar somente o namespace padr\u00E3o do MDF-e"),
    CODIGO_599(599, "Rejei\u00E7\u00E3o: N\u00E3o \u00E9 permitida a presen\u00E7a de caracteres de edi\u00E7\u00E3o no in\u00EDcio/fim da mensagem ou entre as tags da mensagem"),
    CODIGO_600(600, "Rejei\u00E7\u00E3o: Chave de Acesso difere da existente em BD"),
    CODIGO_601(601, "Rejei\u00E7\u00E3o: Chave de acesso do CT-e informado inv\u00E1lida [chCTe: 99999999999999999999999999999999999999999999] [Motivo: XXXXXXXXXXXX]"),
    CODIGO_602(602, "Rejei\u00E7\u00E3o: Segundo C\u00F3digo de Barras deve ser informado para CT-e em conting\u00EAncia FS-DA"),
    CODIGO_603(603, "Rejei\u00E7\u00E3o: Segundo C\u00F3digo de Barras n\u00E3o deve ser informado para CT-e com este tipo de emiss\u00E3o"),
    CODIGO_604(604, "Rejei\u00E7\u00E3o: Chave de acesso da NF-e informada inv\u00E1lida [chNFe: 99999999999999999999999999999999999999999999] [Motivo: XXXXXXXXXXXX]"),
    CODIGO_606(606, "Rejei\u00E7\u00E3o: Segundo C\u00F3digo de Barras deve ser informado para NF-e em conting\u00EAncia (FS-DA e FS-IA)"),
    CODIGO_607(607, "Rejei\u00E7\u00E3o: Segundo C\u00F3digo de Barras n\u00E3o deve ser informado para NF-e com este tipo de emiss\u00E3o"),
    CODIGO_609(609, "Rejei\u00E7\u00E3o: MDF-e j\u00E1 est\u00E1 encerrado na base de dados da SEFAZ [nProt:999999999999999][dhEnc: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODIGO_611(611, "Rejei\u00E7\u00E3o: Existe MDF-e n\u00E3o encerrado para esta placa, tipo de emitente e UF descarregamento [chMDFe: 99999999999999999999999999999999999999999999][nProt:999999999999999]"),
    CODIGO_612(612, "Rejei\u00E7\u00E3o: C\u00F3digo de Munic\u00EDpio diverge da UF de descarregamento do MDF-e"),
    CODIGO_614(614, "Rejei\u00E7\u00E3o: C\u00F3digo de Munic\u00EDpio diverge da UF de encerramento do MDF-e"),
    CODIGO_615(615, "Rejei\u00E7\u00E3o: Data de encerramento anterior \u00E0 data de autoriza\u00E7\u00E3o do MDF-e"),
    CODIGO_616(616, "Rejei\u00E7\u00E3o: Nenhum grupo de documentos foi informado (CT-e, CT, NF-e, MDF-e) Retornar Munic\u00EDpio de Descarregamento sem DF-e vinculado"),
    CODIGO_627(627, "Rejei\u00E7\u00E3o: CNPJ do autor do evento inv\u00E1lido"),
    CODIGO_628(628, "Rejei\u00E7\u00E3o: Erro Atributo ID do evento n\u00E3o corresponde \u00E0 concatena\u00E7\u00E3o dos campos (\u201CID\u201D + tpEvento + chMDFe + nSeqEvento)"),
    CODIGO_629(629, "Rejei\u00E7\u00E3o: O tpEvento informado inv\u00E1lido"),
    CODIGO_630(630, "Rejei\u00E7\u00E3o: Falha no Schema XML espec\u00EDfico para o evento"),
    CODIGO_631(631, "Rejei\u00E7\u00E3o: Duplicidade de evento [nProt:999999999999999][dhRegEvento: AAAA-MM-DDTHH:MM:SS TZD]"),
    CODIGO_632(632, "Rejei\u00E7\u00E3o: O autor do evento diverge do emissor do MDF-e"),
    CODIGO_633(633, "Rejei\u00E7\u00E3o: O autor do evento n\u00E3o \u00E9 um \u00F3rg\u00E3o autorizado a gerar o evento"),
    CODIGO_634(634, "Rejei\u00E7\u00E3o: A data do evento n\u00E3o pode ser menor que a data de emiss\u00E3o do MDF-e"),
    CODIGO_635(635, "Rejei\u00E7\u00E3o: A data do evento n\u00E3o pode ser maior que a data do processamento"),
    CODIGO_636(636, "Rejei\u00E7\u00E3o: O n\u00FAmero sequencial do evento \u00E9 maior que o permitido"),
    CODIGO_637(637, "Rejei\u00E7\u00E3o: A data do evento n\u00E3o pode ser menor que a data de autoriza\u00E7\u00E3o do MDF-e"),
    CODIGO_638(638, "Rejei\u00E7\u00E3o: N\u00E3o deve ser informada Nota Fiscal para tipo de emitente Prestador Servi\u00E7o de Transporte"),
    CODIGO_639(639, "Rejei\u00E7\u00E3o: N\u00E3o deve ser informado Conhecimento de Transporte Eletr\u00F4nico para tipo de emitente Transporte de Carga Pr\u00F3pria."),
    CODIGO_644(644, "Rejei\u00E7\u00E3o: Evento de inclus\u00E3o de condutor s\u00F3 pode ser registrado para o modal rodovi\u00E1rio"),
    CODIGO_645(645, "Rejei\u00E7\u00E3o: CPF do condutor inv\u00E1lido"),
    CODIGO_646(646, "Rejei\u00E7\u00E3o: Placa de ve\u00EDculo formato inv\u00E1lido (UF Carregamento e Descarregamento <> \u2018EX\u2019)"),
    CODIGO_647(647, "Rejei\u00E7\u00E3o: MDF-e s\u00F3 pode ser referenciado por manifesto do modal aquavi\u00E1rio"),
    CODIGO_648(648, "Rejei\u00E7\u00E3o: MDF-e s\u00F3 pode ser referenciado quando UF de Carregamento/Descarregamento for igual a AM ou AP "),
    CODIGO_649(649, "Rejei\u00E7\u00E3o: Chave de acesso de MDF-e informada inv\u00E1lida [chMDFe: 99999999999999999999999999999999999999999999] [Motivo: XXXXXXXXXXXX]"),
    CODIGO_655(655, "Rejei\u00E7\u00E3o: MDF-e referenciado n\u00E3o existe na base de dados da SEFAZ"),
    CODIGO_656(656, "Rejei\u00E7\u00E3o: Chave de Acesso do MDF-e referenciado difere da existente em BD"),
    CODIGO_657(657, "Rejei\u00E7\u00E3o: MDF-e referenciado j\u00E1 est\u00E1 cancelado na base de dados da SEFAZ"),
    CODIGO_658(658, "Rejei\u00E7\u00E3o: Modal do MDF-e referenciado diferente de Rodovi\u00E1rio"),
    CODIGO_659(659, "Rejei\u00E7\u00E3o: Tipo do Emitente do MDF-e referenciado difere de Transportador de Carga Pr\u00F3pria"),
    CODIGO_660(660, "Rejei\u00E7\u00E3o: CNPJ autorizado para download inv\u00E1lido"),
    CODIGO_661(661, "Rejei\u00E7\u00E3o: CPF autorizado para download inv\u00E1lido"),
    CODIGO_662(662, "Rejei\u00E7\u00E3o: Existe MDF-e n\u00E3o encerrado para esta placa, tipo de emitente no sentido oposto da viagem"),
    CODIGO_663(663, "Rejei\u00E7\u00E3o: Percurso informado inv\u00E1lido"),
    CODIGO_666(666, "Rejei\u00E7\u00E3o: Ano do MDF-e informado na chave de acesso inv\u00E1lido"),
    CODIGO_667(667, "Rejei\u00E7\u00E3o: Quantidade informada no grupo de totalizadores n\u00E3o confere com a quantidade de documentos relacionada"),
    CODIGO_668(668, "Rejei\u00E7\u00E3o: Chave de Acesso de CT-e duplicada [chCTe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODIGO_669(669, "Rejei\u00E7\u00E3o: Chave de Acesso de NF-e duplicada [chNFe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODIGO_671(671, "Rejei\u00E7\u00E3o: CT-e informado n\u00E3o existe na base de dados da SEFAZ [chCTe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODIGO_672(672, "Rejei\u00E7\u00E3o: CT-e informado com diferen\u00E7a de chave de acesso [chCTe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODIGO_673(673, "Rejei\u00E7\u00E3o: CT-e informado n\u00E3o pode estar cancelado/denegado na base da SEFAZ [chCTe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODIGO_675(675, "Rejei\u00E7\u00E3o: NF-e informada n\u00E3o existe na base de dados da SEFAZ [chNFe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODIGO_676(676, "Rejei\u00E7\u00E3o: NF-e informada com diferen\u00E7a de chave de acesso [chNFe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODIGO_677(677, "Rejei\u00E7\u00E3o: NF-e informada n\u00E3o pode estar cancelada/denegada na base da SEFAZ [chNFe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODIGO_678(678, "Rejei\u00E7\u00E3o: Uso Indevido"),
    CODIGO_680(680, "Rejei\u00E7\u00E3o: Munic\u00EDpio de descarregamento duplicado no MDF-e"),
    CODIGO_681(681, "Rejei\u00E7\u00E3o: RNTRC informado inexistente."),
    CODIGO_682(682, "Rejei\u00E7\u00E3o: RNTRC situa\u00E7\u00E3o inv\u00E1lida."),
    CODIGO_683(683, "Rejei\u00E7\u00E3o: Placa do ve\u00EDculo de tra\u00E7\u00E3o n\u00E3o vinculada ao RNTRC informado."),
    CODIGO_684(684, "Rejei\u00E7\u00E3o: CIOT obrigat\u00F3rio para RNTRC informado."),
    CODIGO_685(685, "Rejei\u00E7\u00E3o: Munic\u00EDpio de carregamento duplicado no MDF-e"),
    CODIGO_686(686, "Rejei\u00E7\u00E3o: Existe MDF-e n\u00E3o encerrado h\u00E1 mais de 30 dias para o emitente [chMDFe: 99999999999999999999999999999999999999999999][nProt:999999999999999]"),
    CODIGO_687(687, "Rejei\u00E7\u00E3o: RNTRC deve estar associado ao transportador indicado"),
    CODIGO_688(688, "Rejei\u00E7\u00E3o: RNTRC deve ser informado para Prestador de Servi\u00E7o de Transporte"),
    CODIGO_689(689, "Rejei\u00E7\u00E3o: Munic\u00EDpio de encerramento deve ser 9999999 para encerramento no exterior"),
    CODIGO_698(698, "Rejei\u00E7\u00E3o: Seguro da carga \u00E9 obrigat\u00F3rio para modal Prestador de Servi\u00E7o de Transporte no modal rodovi\u00E1rio"),
    CODIGO_699(699, "Rejei\u00E7\u00E3o: Dados do seguro de carga incompletos para o modal rodovi\u00E1rio"),
    CODIGO_700(700, "Rejei\u00E7\u00E3o: CPF do autor do evento inv\u00E1lido"),
    CODIGO_701(701, "Rejei\u00E7\u00E3o: Tipo de evento incompat\u00EDvel com emitente pessoa f\u00EDsica"),
    CODIGO_702(702, "Rejei\u00E7\u00E3o: Modal inv\u00E1lido para entrega parcial (apenas modal a\u00E9reo)"),
    CODIGO_703(703, "Rejei\u00E7\u00E3o: Carregamento e Descarregamento inv\u00E1lidos para MDF-e com indica\u00E7\u00E3o de carregamento posterior"),
    CODIGO_704(704, "Rejei\u00E7\u00E3o: MDF-e com indica\u00E7\u00E3o de carregamento posterior n\u00E3o permitido para opera\u00E7\u00F5es interestaduais ou com o exterior"),
    CODIGO_705(705, "Rejei\u00E7\u00E3o: Modal inv\u00E1lido para MDF-e com indica\u00E7\u00E3o de carregamento posterior (apenas modal rodovi\u00E1rio)"),
    CODIGO_706(706, "Rejei\u00E7\u00E3o: N\u00E3o informar documentos transportados para MDF-e com indica\u00E7\u00E3o de carregamento posterior (usar evento inclus\u00E3o de DF-e)"),
    CODIGO_707(707, "Rejei\u00E7\u00E3o: MDF-e com indica\u00E7\u00E3o de carregamento posterior com tipo de emitente diferente de transporte pr\u00F3priO"),
    CODIGO_708(708, "Rejei\u00E7\u00E3o: MDF-e deve possui indica\u00E7\u00E3o de carregamento posterior para inclus\u00E3o de DF-e"),
    CODIGO_709(709, "Rejei\u00E7\u00E3o: Chave de acesso de NF-e inv\u00E1lida no evento de inclus\u00E3o [Motivo: CNPJ/CPF inv\u00E1lido / Modelo diferente de 55  / Ano inv\u00E1lido (< 2006) / M\u00EAs inv\u00E1lido (0 ou > 12) / Tipo de emiss\u00E3o inv\u00E1lido / UF inv\u00E1lida / N\u00FAmero zerado / DV inv\u00E1lido]"),
    CODIGO_710(710, "Rejei\u00E7\u00E3o: Cancelamento n\u00E3o \u00E9 permitido para MDF-e com indica\u00E7\u00E3o de carregamento posterior que j\u00E1 realizou inser\u00E7\u00E3o de DF-e"),
    CODIGO_711(711, "Rejei\u00E7\u00E3o: NF-e j\u00E1 est\u00E1 vinculada ao MDF-e por outro evento"),
    CODIGO_712(712, "Rejei\u00E7\u00E3o: Existe MDF-e com indica\u00E7\u00E3o de carregamento posterior sem inclus\u00E3o de DF-e para o emitente h\u00E1 mais de 168 horas"),
    CODIGO_713(713, "Rejei\u00E7\u00E3o: CNPJ do desenvolvedor do sistema inv\u00E1lido (zerado ou d\u00EDgito inv\u00E1lido)"),
    CODIGO_714(714, "Rejei\u00E7\u00E3o: Munic\u00EDpio de encerramento inexistente"),
    CODIGO_715(715, "Rejei\u00E7\u00E3o: N\u00E3o \u00E9 permitido encerrar MDF-e com indica\u00E7\u00E3o de carregamento posterior sem inclus\u00E3o de DF-e associada"),
    CODIGO_716(716, "Rejei\u00E7\u00E3o: CNPJ / CPF do respons\u00E1vel pela gera\u00E7\u00E3o do CIOT inv\u00E1lido"),
    CODIGO_717(717, "Rejei\u00E7\u00E3o: CNPJ / CPF do contratante do transporte inv\u00E1lido"),
    CODIGO_718(718, "Rejei\u00E7\u00E3o: CNPJ / CPF do propriet\u00E1rio do ve\u00EDculo de tra\u00E7\u00E3o inv\u00E1lido"),
    CODIGO_719(719, "Rejei\u00E7\u00E3o: CNPJ / CPF do propriet\u00E1rio do ve\u00EDculo reboque inv\u00E1lido"),
    CODIGO_720(720, "Rejei\u00E7\u00E3o: Obrigat\u00F3ria as informa\u00E7\u00F5es do respons\u00E1vel t\u00E9cnico"),
    CODIGO_721(721, "Rejei\u00E7\u00E3o: Obrigat\u00F3ria a informa\u00E7\u00E3o do identificador do CSRT e do Hash do CSRT"),
    CODIGO_997(997, "Rejei\u00E7\u00E3o: XML do MDF-e referenciado indispon\u00EDvel no momento da valida\u00E7\u00E3o (Existem situa\u00E7\u00F5es em que o ambiente de autoriza\u00E7\u00E3o trabalha com um banco de dados separado para o arquivo XML)"),
    CODIGO_999(999, "Rejei\u00E7\u00E3o: Erro n\u00E3o catalogado");

    private static final List<MDFRetornoStatus> AUTORIZADOS = Arrays.asList(CODIGO_100, CODIGO_104);

    private final int codigo;
    private final String motivo;

    MDFRetornoStatus(final int codigo, final String motivo) {
        this.codigo = codigo;
        this.motivo = motivo;
    }

    public static MDFRetornoStatus valueOfCodigo(final String codigo) {
        return MDFRetornoStatus.valueOfCodigo(Integer.parseInt(codigo));
    }

    public static MDFRetornoStatus valueOfCodigo(final int codigo) {
        for (final MDFRetornoStatus statusRetorno : MDFRetornoStatus.values()) {
            if (statusRetorno.getCodigo() == codigo) {
                return statusRetorno;
            }
        }
        throw new IllegalArgumentException(String.format("Status retorno %s n\u00e3o mapeado", codigo));
    }

    public boolean isAutorizado() {
        return MDFRetornoStatus.AUTORIZADOS.contains(this);
    }


    public boolean isRejeitado() {
        return (this.codigo > 200) && !MDFRetornoStatus.AUTORIZADOS.contains(this) && !this.isDuplicado();
    }

    public boolean isDuplicado() {
        return CODIGO_539.getCodigo() == this.codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getMotivo() {
        return this.motivo;
    }
}