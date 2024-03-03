package br.com.rsousa;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rsousa.dao.ClienteDAO;
import br.com.rsousa.dao.IClienteDAO;
import br.com.rsousa.domain.Cliente;
import br.com.rsousa.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

	private IClienteDAO clienteDao;

	private Cliente cliente;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}

	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		cliente = new Cliente();
		cliente.setCpf(12345678901L);
		cliente.setNome("Renan");
		cliente.setCidade("Três Lagoas");
		cliente.setEnd("End");
		cliente.setEstado("MS");
		cliente.setNumero(15);
		cliente.setTel(1231231321L);
		clienteDao.cadastrar(cliente);
	}

	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setCpf(56565656565L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
	}

	@Test
	public void excluirCliente() {
		clienteDao.excluir(cliente.getCpf());
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Renan Sousa");
		clienteDao.alterar(cliente);
		Assert.assertEquals("Renan Sousa", cliente.getNome());
	}

	@Test
	public void buscarTodos() {
		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
}
