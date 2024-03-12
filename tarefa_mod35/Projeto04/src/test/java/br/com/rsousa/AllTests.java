/**
 * 
 */
package br.com.rsousa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author renan.sousa
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
		ProdutoServiceTest.class, ProdutoDAOTest.class,
		VendaDAOTest.class })
public class AllTests {

}
