package com.fincatto.nfe310.classes;

public enum NFTipoCertificadoA3 {
	
	SMARTCARD("smartCard"),
	TOKEN("token");
	
	private final String codigo;
	
    private NFTipoCertificadoA3(final String codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return this.codigo;
    }

    public static NFTipoCertificadoA3 valueOfCodigo(final String codigo) {
        for (final NFTipoCertificadoA3 tipo : NFTipoCertificadoA3.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
