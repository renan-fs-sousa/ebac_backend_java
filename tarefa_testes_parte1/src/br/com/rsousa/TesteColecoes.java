package br.com.rsousa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class TesteColecoes {

    @Test
    public void Teste() {

        List<String> listaDadosPessoas = new ArrayList<>();

        String grupos = "Aline - F, Marcos - M, Jorge - M, Maria - F";

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

        // lista de dados esperados para comparar
        List<String> expectativa = new ArrayList<>();
        expectativa.add("Aline");
        expectativa.add("Maria");

        Assert.assertEquals(expectativa, filtrados);

    }

}
