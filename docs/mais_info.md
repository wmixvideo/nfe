O foco da biblioteca é tornar a integração com a Sefaz a mais fácil e objetiva possível, porém, pode causar confusão na sua utilização. O objetivo desse manual é sanar algumas dúvidas que são presentes em muitos iniciantes no mundo da nota fiscal eletrônica.
Dúvidas relacionadas na concepção das notas devem ser tiradas com profissional da área.
Lembrando que o documento oficial é a melhor fonte de informação disponível.

# Certificados digitais

Os certificados digitais são necessários para identificação entre servidores da Sefaz e o cliente, é indispensável a aquisição dos certificados para transmitir e obter dados através dos webservices (Incluindo ambiente de homologação).
Os certificados são utilizados na assinatura dos documentos xmls e na transmissão dos mesmos. 

No caso de certificados *A1* a assinatura é feita de forma automática, porém, em certificados *A3*, como a forma de assinar tem suas particularidades, não foi possĩvel criar uma maneira que atendesse todos os casos, portanto, terá que ser assinada antes de ser passada para a lib. 
*Observação*: no Façade há métodos específicos para documentos já assinados.

# Fluxos

## Envio de lote (Envio Assíncrono)

<Diagrama exemplificando o processo>

## Consulta de lote

No envio (se tudo ocorrer bem), A sefaz retorna o número de protocolo de consulta do status do processamento do lote, com essa informação, pode ser verificado o estado atual do lote.
Ao receber o status "lote processado" (status 104), no mesmo xml contém o protocolo da nota e seu status de processionamento. Em uma situação que satisfaça todos os requisitos minimos da Sefaz, a nota receberá um status de "Autorizado uso NF-e" (status 100), caso tenha um status diferente o desse, ela foi denegada/recusada pela Sefaz.

## Principais problemas

# Rejeicao: Assinatura difere do calculado
O XML assinado não pode sofrer alteração após ser assinado.