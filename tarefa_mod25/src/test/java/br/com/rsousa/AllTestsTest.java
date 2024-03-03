package br.com.rsousa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
        ProdutoServiceTest.class,
        VendaDAOTest.class, ProdutoDAOTest.class })
public class AllTestsTest {
}