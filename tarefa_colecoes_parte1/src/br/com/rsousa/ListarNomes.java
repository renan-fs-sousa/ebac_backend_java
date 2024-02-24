package br.com.rsousa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListarNomes {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        List<String> lista = new ArrayList<>();

        int contador = 1;

        while (contador <= 3){

            if (lista.size() < 0){
                System.out.println("Digite um nome:");
            }
            else {
                System.out.println("Digite outro nome:");
            }

            lista.add(s.next());
            Collections.sort(lista);
            System.out.println("Lista de nomes em ordem alfabética:\n" + lista);
            contador++;
        }

    }

}
