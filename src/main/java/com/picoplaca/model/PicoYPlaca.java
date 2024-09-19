package com.picoplaca.model;

public class PicoYPlaca {
	
    private String numeroPlaca;

    public PicoYPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    		//obtenemos el String completo, sin embargo 
    		//tomamos el ultimo caracter para revisarlo (-1)
    public int obtenerUltimoDigito() {
        char ultimoCaracter = numeroPlaca.charAt(numeroPlaca.length() - 1);
        return Character.getNumericValue(ultimoCaracter);
    }
}

