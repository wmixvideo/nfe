package com.fincatto.nfe310.classes;

public interface NFAutorizador31 {

    public String getNfeAutorizacao(final NFAmbiente ambiente);

    public String getNfeRetAutorizacao(final NFAmbiente ambiente);

    public String getNfeConsultaProtocolo(final NFAmbiente ambiente);

    public String getNfeStatusServico(final NFAmbiente ambiente);

    public String getRecepcaoEvento(final NFAmbiente ambiente);

    public String getConsultaCadastro(final NFAmbiente ambiente);

    public String getNfeInutilizacao(final NFAmbiente ambiente);
    
    public String getQRCode(final NFAmbiente ambiente);

    public NFUnidadeFederativa[] getUFs();
}
