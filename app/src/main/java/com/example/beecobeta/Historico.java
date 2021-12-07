package com.example.beecobeta;

import java.util.ArrayList;

public class Historico {

    private static ArrayList<String> historico = new ArrayList<>();
    // falta verificar o codigo do ecoponto
    // falta encriptação

    public Historico() {    }

    private void addCode(String codigo) {
        historico.add(codigo);
    }

    private boolean isCodeValid(String codigo) {
        if(historico.contains(codigo))
            return false;
        return true;
    }

    public boolean tryNewQRCode(String codigo) {
        if(isCodeValid(codigo) == true) {
            addCode(codigo);
            return true;
        }
        return false;
    }

}
