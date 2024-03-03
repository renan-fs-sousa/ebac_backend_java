package br.com.rsousa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import br.com.rsousa.dao.ClienteDAO;
import br.com.rsousa.dao.IClienteDAO;
import br.com.rsousa.dao.IProdutoDAO;
import br.com.rsousa.dao.IVendaDAO;
import br.com.rsousa.dao.ProdutoDAO;
import br.com.rsousa.dao.VendaDAO;
import br.com.rsousa.domain.Cliente;
import br.com.rsousa.domain.Produto;
import br.com.rsousa.domain.Venda;
import br.com.rsousa.domain.Venda.Status;
import br.com.rsousa.exceptions.TipoChaveNaoEncontradaException;

public class VendaDAOTest {

	private IVendaDAO vendaDao;

	private IClienteDAO clienteDao;

	private IProdutoDAO produtoDao;

	// private Venda venda;

	private Cliente cliente;

	private Produto produto;

	public VendaDAOTest() {
		vendaDao = new VendaDAO();
		clienteDao = new ClienteDAO();
		produtoDao = new ProdutoDAO();
	}

	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		this.cliente = cadastrarCliente();
		this.produto = cadastrarProduto("A1", BigDecimal.TEN);
	}

	@Test
	public void pesquisar() throws TipoChaveNaoEncontradaException {
		Venda venda = criarVenda("A1");
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
		assertNotNull(vendaConsultada);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}

	@Test
	public void salvar() throws TipoChaveNaoEncontradaException {
		Venda venda = criarVenda("A2");
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void cancelarVenda() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A3";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		venda.setStatus(Status.CANCELADA);
		vendaDao.alterar(venda);

		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		assertEquals(codigoVenda, vendaConsultada.getCodigo());
		assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
	}

	@Test
	public void adicionarMaisProdutosDoMesmo() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A4";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(produto, 1);

		assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(30)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void adicionarMaisProdutosDiferentes() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A5";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());

		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);

		assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void salvarProdutoExistente() throws TipoChaveNaoEncontradaException {
		Venda venda = criarVenda("A6");
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);

		Boolean retorno1 = vendaDao.cadastrar(venda);
		assertFalse(retorno1);
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void removerProduto() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A7";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());

		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));

		vendaConsultada.removerProduto(prod, 1);
		assertTrue(venda.getQuantidadeTotalProdutos() == 2);
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void removerApenasUmProduto() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A8";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());

		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));

		vendaConsultada.removerProduto(prod, 1);
		assertTrue(venda.getQuantidadeTotalProdutos() == 2);
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void removerTodosProdutos() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A9";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());

		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));

		vendaConsultada.removerTodosProdutos();
		assertTrue(venda.getQuantidadeTotalProdutos() == 0);
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(0)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void finalizarVenda() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A10";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		vendaDao.finalizarVenda(venda);

		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(venda.getStatus(), vendaConsultada.getStatus());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void tentarAdicionarProdutosVendaFinalizada() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A11";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		vendaDao.finalizarVenda(venda);
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(venda.getStatus(), vendaConsultada.getStatus());

		vendaConsultada.adicionarProduto(this.produto, 1);

	}

	private Produto cadastrarProduto(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(valor);
		produtoDao.cadastrar(produto);
		return produto;
	}

	private Cliente cadastrarCliente() throws TipoChaveNaoEncontradaException {
		Cliente cliente = new Cliente();
		cliente.setCpf(12345678901L);
		cliente.setNome("Renan");
		cliente.setCidade("Três Lagoas");
		cliente.setEnd("End");
		cliente.setEstado("MS");
		cliente.setNumero(15);
		cliente.setTel(1231231321L);
		clienteDao.cadastrar(cliente);
		return cliente;
	}

	private Venda criarVenda(String codigo) {
		Venda venda = new Venda();
		venda.setCodigo(codigo);
		venda.setDataVenda(Instant.now());
		venda.setCliente(this.cliente);
		venda.setStatus(Status.INICIADA);
		venda.adicionarProduto(this.produto, 2);
		return venda;
	}

}
