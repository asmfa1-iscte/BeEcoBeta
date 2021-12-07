package com.example.beecobeta;

public class DadosPerfil {

    public static String nome = "David Ramires";
    public static String pontos = "200";
    public static String nivel = "2";
    public static int progresso = 30;

    public static String getNome() {
        return nome;
    }

    public static String getPontos() {
        return pontos;
    }

    public static String getNivel() {
        return nivel;
    }

    public static int getProgresso() {
        return progresso;
    }

    public static void setNome(String nome) {
        DadosPerfil.nome = nome;
    }

    public static void setPontos(String pontos) {
        DadosPerfil.pontos = pontos;
    }

    public static void setNivel(String nivel) {
        DadosPerfil.nivel = nivel;
    }

    public static void setProgresso(int progresso) {
        DadosPerfil.progresso = progresso;
    }
}
