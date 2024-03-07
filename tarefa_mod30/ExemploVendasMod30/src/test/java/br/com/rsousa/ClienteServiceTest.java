/**
 * 
 */
package br.com.rsousa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rsousa.dao.ClienteDaoMock;
import br.com.rsousa.dao.IClienteDAO;
import br.com.rsousa.domain.Cliente;
import br.com.rsousa.exceptions.DAOException;
import br.com.rsousa.exceptions.TipoChaveNaoEncontradaException;
import br.com.rsousa.services.ClienteService;
import br.com.rsousa.services.IClienteService;

/**
 * @author renan.sousa
 *
 */
public class ClienteServiceTest {

	private IClienteService clienteService;

	private Cliente cliente;

	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}

	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Renan");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setSexo("M");

	}

	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);

		Assert.assertTrue(retorno);
	}

	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Renan Sousa");
		clienteService.alterar(cliente);

		Assert.assertEquals("Renan Sousa", cliente.getNome());
	}
}
