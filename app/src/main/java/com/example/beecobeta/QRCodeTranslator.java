package com.example.beecobeta;

public class QRCodeTranslator {

    /*
    Estrutura codigo QRCode:
        1-6 ->  codigo ecoponto
        7-20 -> data
            7-8 -> dia , 9-10 -> mês , 11-14 -> ano
            15-16 -> hora , 17-18 -> minuto , 19-20 -> segundo
        21-24 -> numero de pontos
        ex: 000001251120212337050005
    */

    public QRCodeTranslator() {    }

    public static String getEcoponto(String codigo) {
        return codigo.substring(1, 6);
    }

    public static String getDia(String codigo) {
        return codigo.substring(7,8);
    }

    public static String getMes(String codigo) {
        return codigo.substring(9,10);
    }

    public static String getAno(String codigo) {
        return codigo.substring(11,14);
    }

    public static String getHora(String codigo) {
        return codigo.substring(15,16);
    }

    public static String getMin(String codigo) {
        return codigo.substring(17, 18);
    }

    public static String getSeg(String codigo) {
        return codigo.substring(19,20);
    }

    public static int getPontos(String codigo) {
        return Integer.parseInt(codigo.substring(21, 24));
    }

    public static String toString(String codigo) {
        return "Ganhou "+QRCodeTranslator.getPontos(codigo)+" pontos, na data "
                +QRCodeTranslator.getDia(codigo)+"/"+QRCodeTranslator.getMes(codigo)+"/"
                +QRCodeTranslator.getAno(codigo)+" às "+QRCodeTranslator.getHora(codigo)+":"
                +QRCodeTranslator.getMin(codigo)+":"+QRCodeTranslator.getSeg(codigo)+".";
    }
}
