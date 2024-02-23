package br.com.rsousa;

public class CalculaMedia {
    public static void main(String[] args) {
        calcularMedia();
    }
    public static void calcularMedia() {
        int nota1 = 5;
        int nota2 = 3;
        int nota3 = 6;
        int nota4 = 7;
        int notas = nota1 + nota2 + nota3 + nota4;
        float media = notas / 4f;
        System.out.println(media);
    }
}
