package com.example.beecobeta;

public class PointsManager {

    private int MAX_PROGRESSO_NIVEL = 100;

    private String pontosIniciais;
    private int pontosGanhos;
    private String nivelInicial;
    private int progressoInicial;

    public PointsManager(String pontosIniciais, int pontosGanhos, String nivelInicial, int progressoInicial) {
        this.pontosIniciais = pontosIniciais;
        this.pontosGanhos = pontosGanhos;
        this.nivelInicial = nivelInicial;
        this.progressoInicial = progressoInicial;
    }


    public String getPontosFinais() {
        return String.valueOf(Integer.parseInt(pontosIniciais)+pontosGanhos);
    }

    public String getNivelFinal() {
        int nivelFinal;
        if((progressoInicial+pontosGanhos) >= MAX_PROGRESSO_NIVEL) {
            nivelFinal = Integer.parseInt(nivelInicial)+1;
            return String.valueOf(nivelFinal);
        }
        return nivelInicial;
    }

    public int getProgressoFinal() {
        int progressoFinal = (progressoInicial+pontosGanhos);
        int dif = progressoFinal-progressoInicial-pontosGanhos;
        if( progressoFinal >= MAX_PROGRESSO_NIVEL) {
            return dif;
        }
        return progressoFinal;
    }

}
