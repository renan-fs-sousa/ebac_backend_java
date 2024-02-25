package br.com.rsousa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Colecoes {

    public static void main(String[] args) {

        Tarefa1();
        System.out.println("=========================");
        Tarefa2();
    }

    public static void Tarefa1() {
        Scanner scanner = new Scanner(System.in);
        List<String> listaNomes = new ArrayList<String>();
        System.out.println("Tarefa 1");
        System.out.println("Digite nomes separados por virgula (Ex: Aline, Marcos, Jorge):");
        String nomes = scanner.nextLine();

        String[] nomesArray = nomes.split(",");

        for (int i = 0; i < nomesArray.length; i++) {
            nomesArray[i] = nomesArray[i].trim();
            listaNomes.add(nomesArray[i]);
        }
        Collections.sort(listaNomes);

        System.out.println("Resutaldo tarefa 1: \n" + listaNomes);
    }

    public static void Tarefa2() {
        Scanner scanner = new Scanner(System.in);
        List<String> listaDadosPessoas = new ArrayList<>();
        System.out.println("Tarefa 2");
        System.out.println("Digite nomes e sexo separado por hifen e virgula (Ex: Aline - F, Marcos - M, Jorge - M):");
        String grupos = scanner.nextLine();

        String[] gruposArray = grupos.split(",");

        for (int i = 0; i < gruposArray.length; i++) {

            gruposArray[i] = gruposArray[i].trim();
            listaDadosPessoas.add(gruposArray[i]);

        }

        List<String> listaF = new ArrayList<>();
        List<String> listaM = new ArrayList<>();

        for (String grupoPessoas : listaDadosPessoas) {

            String[] dadosPessoas = grupoPessoas.split("-");

            for (String dados : dadosPessoas) {

                dados = dados.trim();

                if (dados.equalsIgnoreCase("f")) {
                    listaF.add(dadosPessoas[0].trim());
                } else if (dados.equalsIgnoreCase("m")) {
                    listaM.add(dadosPessoas[0].trim());
                }
            }

        }
        Collections.sort(listaF);
        Collections.sort(listaM);
        System.out.println("Resutaldo tarefa 2:");
        System.out.println("Grupo Feminino: " + listaF);
        System.out.println("Grupo Masculino: " + listaM);

    }
}
