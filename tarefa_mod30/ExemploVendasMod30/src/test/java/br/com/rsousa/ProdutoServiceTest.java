/**
 * 
 */
package br.com.rsousa;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rsousa.dao.IProdutoDAO;
import br.com.rsousa.dao.ProdutoDaoMock;
import br.com.rsousa.domain.Produto;
import br.com.rsousa.exceptions.DAOException;
import br.com.rsousa.exceptions.TipoChaveNaoEncontradaException;
import br.com.rsousa.services.IProdutoService;
import br.com.rsousa.services.ProdutoService;

/**
 * @author renan.sousa
 *
 */
public class ProdutoServiceTest {

	private IProdutoService produtoService;

	private Produto produto;

	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}

	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produto.setPeso(BigDecimal.valueOf(5.05));
	}

	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}

	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}

	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Renan Sousa");
		produtoService.alterar(produto);

		Assert.assertEquals("Renan Sousa", produto.getNome());
	}
}
