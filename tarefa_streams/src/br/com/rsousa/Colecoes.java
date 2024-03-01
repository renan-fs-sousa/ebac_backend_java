package br.com.rsousa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Colecoes {

    public static void main(String[] args) {

        Tarefa();
    }

    public static void Tarefa() {
        Scanner scanner = new Scanner(System.in);
        List<String> listaDadosPessoas = new ArrayList<>();

        System.out.println(
                "Digite nomes e sexo separado por hifen e virgula (Ex: Aline - F, Marcos - M, Jorge - M, Maria - F):");
        String grupos = scanner.nextLine();

        String[] gruposArray = grupos.split(",");

        Arrays.stream(gruposArray)
                .map(String::trim)
                .forEach(listaDadosPessoas::add);

        List<String> filtrados = new ArrayList<>();

        listaDadosPessoas.forEach(elemento -> {
            String[] dados = elemento.split(" - ");
            for (String dado : dados) {

                if (dado.equalsIgnoreCase("F")) {
                    filtrados.add(dados[0]);
                }
            }
        });

        System.out.println("\nLista de mulheres:");
        filtrados.forEach(System.out::println);

    }
}
