package br.com.rsousa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rsousa.dao.ClienteDaoMock;
import br.com.rsousa.dao.IClienteDAO;
import br.com.rsousa.domain.Cliente;
import br.com.rsousa.exceptions.TipoChaveNaoEncontradaException;
import br.com.rsousa.services.ClienteService;
import br.com.rsousa.services.IClienteService;

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
		cliente.setCpf(12345678901L);
		cliente.setNome("Renan");
		cliente.setCidade("Três Lagoas");
		cliente.setEnd("End");
		cliente.setEstado("MS");
		cliente.setNumero(15);
		cliente.setTel(1231231321L);

	}

	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);

		Assert.assertTrue(retorno);
	}

	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Renan Sousa");
		clienteService.alterar(cliente);

		Assert.assertEquals("Renan Sousa", cliente.getNome());
	}
}
