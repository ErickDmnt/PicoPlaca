package com.picoplaca.model;

public class PicoYPlaca {
	
    private String numeroPlaca;

    public PicoYPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public int obtenerUltimoDigito() {
        char ultimoCaracter = numeroPlaca.charAt(numeroPlaca.length() - 1);
        return Character.getNumericValue(ultimoCaracter);
    }
}

