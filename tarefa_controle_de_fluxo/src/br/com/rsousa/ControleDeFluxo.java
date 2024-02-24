package br.com.rsousa;

import java.util.Scanner;

public class ControleDeFluxo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int notas = 0;
        for (int i = 1; i<=4; i++){
            System.out.println("Digite a nota número "+i);
            notas += s.nextInt();
        }
        float notasFloat = (float) notas / 4;
        System.out.println("Sua média é: "+ notasFloat);

        if (notasFloat >= 7){
            System.out.println("Você foi aprovado");
        }
        else if (notasFloat >= 5){
            System.out.println("Você está de recuperação");
        }
        else {
            System.out.println("Você foi reprovado");
        }

    }
}
