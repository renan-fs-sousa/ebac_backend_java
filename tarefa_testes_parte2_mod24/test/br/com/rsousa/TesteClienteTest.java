package br.com.rsousa;

import org.junit.Assert;
import org.junit.Test;

public class TesteClienteTest {

    @Test
    public void testeClasseCliente() {
        TesteCliente cli = new TesteCliente();
        cli.adicionarNome("Renan");
        cli.adicionarNome1("Renan");

        Assert.assertEquals("Renan", cli.getNome());
    }
}