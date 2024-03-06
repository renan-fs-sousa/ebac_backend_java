package br.com.rsousa;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rsousa.dao.ClienteDAO;
import br.com.rsousa.dao.IClienteDAO;
import br.com.rsousa.dao.IProdutoDAO;
import br.com.rsousa.dao.ProdutoDAO;
import br.com.rsousa.domain.Cliente;
import br.com.rsousa.domain.Produto;

/**
 * @author renan.sousa
 *
 */

public class ClienteTest {

	@Test
	public void cadastrarCliente() throws SQLException {

		IClienteDAO clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("91");
		cliente.setNome("Cliente 01");

		Integer qtd = clienteDAO.cadastrar(cliente);
		assertTrue(qtd == 1);

		Cliente clienteBD = clienteDAO.consultar(cliente);
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());

		Integer qtdDel = clienteDAO.excluir(clienteBD);
		assertNotNull(qtdDel);
	}

	@Test
	public void atualizarCliente() throws SQLException {

		IClienteDAO clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setNome("cliente 02");
		cliente.setCodigo("92");

		Integer qtdCadastrado = clienteDAO.cadastrar(cliente);
		assertTrue(qtdCadastrado == 1);

		Cliente clienteBD = clienteDAO.consultar(cliente);
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());

		clienteBD.setNome("Cliente 02 NOVO");
		cliente.setCodigo("100");
		Integer countUpdate = clienteDAO.atualizar(clienteBD);
		assertTrue(countUpdate == 1);

		Cliente clienteBD1 = clienteDAO.consultar(cliente);
		assertNull(clienteBD1);

		Cliente clienteBD2 = clienteDAO.consultar(clienteBD);
		assertNotNull(clienteBD2);
		assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
		assertEquals(clienteBD.getNome(), clienteBD2.getNome());

		Integer countDel = clienteDAO.excluir(clienteBD2);
		assertTrue(countDel == 1);
	}

	@Test
	public void consultarCliente() throws SQLException {
		IClienteDAO clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setNome("Cliente 03");
		cliente.setCodigo("93");

		Integer qtdCadastrado = clienteDAO.cadastrar(cliente);
		assertTrue(qtdCadastrado == 1);

		Cliente clienteConsultado = clienteDAO.consultar(cliente);
		assertNotNull(clienteConsultado);

		Integer countDel = clienteDAO.excluir(clienteConsultado);
		assertTrue(countDel == 1);

	}

	@Test
	public void consultarTodos() throws SQLException {
		IClienteDAO clienteDAO = new ClienteDAO();

		List<Cliente> listaClientes = new ArrayList<>();

		List<Cliente> listaClientesBD = new ArrayList<>();

		Cliente cliente1 = new Cliente();
		cliente1.setCodigo("201");
		cliente1.setNome("Cliente 201");

		Cliente cliente2 = new Cliente();
		cliente2.setCodigo("202");
		cliente2.setNome("Cliente 202");

		listaClientes.add(cliente1);
		listaClientes.add(cliente2);

		for (Cliente cli : listaClientes) {
			Integer countCad = clienteDAO.cadastrar(cli);
			assertTrue(countCad == 1);
		}

		listaClientesBD = clienteDAO.buscarTodos();

		assertEquals(2, listaClientesBD.size());

		List<Cliente> list = clienteDAO.buscarTodos();
		for (Cliente cli : list) {
			Integer countDel = clienteDAO.excluir(cli);
			assertTrue(countDel == 1);
		}
	}

	@Test
	public void excluirCliente() throws Exception {
		IClienteDAO clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("95");
		cliente.setNome("Cliente 05");
		Integer countCad = clienteDAO.cadastrar(cliente);
		assertTrue(countCad == 1);

		Cliente clienteBD = clienteDAO.consultar(cliente);
		assertNotNull(clienteBD);
		assertEquals(cliente.getNome(), clienteBD.getNome());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());

		Integer countDel = clienteDAO.excluir(clienteBD);
		assertTrue(countDel == 1);
	}

}