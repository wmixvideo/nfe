Objetivo desse manual é sanar algumas dúvidas que são presentes em muitos iniciantes no mundo da nota fiscal eletrônica.
Lembrando que o documento oficial é a melhor fonte de informação disponível.

# Certificados digitais

Os certificados digitais são necessários para identificação entre servidores da Sefaz e o cliente, é indispensável a aquisição dos certificados para transmitir e obter dados através dos webservices (Incluindo ambiente de homologação).
Os certificados são utilizados na assinatura dos documentos xmls e na transmissão dos mesmos. Você *não* precisa se preocupar em assinar os documentos na comunicação, o Facade implementado na biblioteca já assina os documentos que é necessário a presença.

# Fluxos

## Envio de lote (Envio Assíncrono)

<Diagrama exemplificando o processo>

## Consulta de lote

No envio (se tudo ocorrer bem), A sefaz retorna o número de protocolo de consulta do status do processamento do lote, com essa informação, pode ser verificado o estado atual do lote.
Ao receber o status "lote processado" (status 104), no mesmo xml contém o protocolo da nota e seu status de processionamento. Em uma situação que satisfaça todos os requisitos minimos da Sefaz, a nota receberá um status de "Autorizado uso NF-e" (status 100), caso tenha um status diferente o desse, ela foi denegada/recusada pela Sefaz.
