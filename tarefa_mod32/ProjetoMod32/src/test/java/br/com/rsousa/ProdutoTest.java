package br.com.rsousa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.rsousa.dao.IProdutoDao;
import br.com.rsousa.dao.ProdutoDao;
import br.com.rsousa.domain.Produto;

/**
 * @author renan.sousa
 *
 */

public class ProdutoTest {

    private IProdutoDao produtoDao;
    private EntityManagerFactory emf;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("ExemploJPA");
        produtoDao = new ProdutoDao();
    }

    @After
    public void tearDown() {
        emf.close();
    }

    public ProdutoTest() {
        produtoDao = new ProdutoDao();
    }

    @Test
    public void cadastrarProdutoTest() {
        Produto produtoTest = new Produto();
        produtoTest.setNome("Galaxy S21");
        produtoTest.setDescricao("Smartphone Samsung Galaxy");
        produtoTest.setValor(1234d);
        Produto produtoCadastrado = produtoDao.cadastrar(produtoTest);

        assertNotNull(produtoCadastrado);
        assertNotNull(produtoCadastrado.getId());

        Long idParaExclusao = produtoCadastrado.getId();
        produtoDao.excluirProduto(idParaExclusao);

        Produto produtoExcluido = produtoDao.consultarProdutoId(idParaExclusao);
        assertNull(produtoExcluido);
    }

    @Test
    public void consultarProdutoIdTest() {
        Produto produtoTest = new Produto();
        produtoTest.setNome("Galaxy S22");
        produtoTest.setDescricao("Smartphone Samsung Galaxy");
        produtoTest.setValor(6789d);
        Produto produtoCadastrado = produtoDao.cadastrar(produtoTest);

        Long idConsulta = produtoCadastrado.getId();
        Produto produtoConsultado = produtoDao.consultarProdutoId(idConsulta);

        assertEquals(produtoTest.getDescricao(), produtoConsultado.getDescricao());
        assertEquals(produtoTest.getNome(), produtoConsultado.getNome());
        assertEquals(produtoTest.getValor(), produtoConsultado.getValor());

        produtoDao.excluirProduto(idConsulta);

        Produto produtoExcluido = produtoDao.consultarProdutoId(idConsulta);
        assertNull(produtoExcluido);
    }

    @Test
    public void atualizarProdutoTest() {
        Produto produtoTest = new Produto();

        produtoTest.setNome("Galaxy S21");
        produtoTest.setDescricao("Smartphone Samsung Galaxy");
        produtoTest.setValor(1234d);
        Produto produtoCadastrado = produtoDao.cadastrar(produtoTest);

        produtoCadastrado.setNome("Galaxy S22");
        produtoTest.setDescricao("Smartphone Samsung Galaxy S22");
        produtoCadastrado.setValor(6789d);

        Produto produtoAtualizado = produtoDao.atualizar(produtoCadastrado);

        assertEquals("Galaxy S22", produtoAtualizado.getNome());
        assertEquals("Smartphone Samsung Galaxy S22",
                produtoAtualizado.getDescricao());
        assertEquals(6789d, produtoAtualizado.getValor(), 0.001);

        produtoDao.excluirProduto(produtoAtualizado.getId());

        Produto produtoExcluido = produtoDao.consultarProdutoId(produtoAtualizado.getId());
        assertNull(produtoExcluido);
    }

    @Test
    public void excluirProdutoTest() {
        Produto produtoTest = new Produto();
        produtoTest.setNome("Galaxy S23");
        produtoTest.setDescricao("Smartphone Samsung Galaxy");
        produtoTest.setValor(1234d);
        Produto produtoCadastrado = produtoDao.cadastrar(produtoTest);

        Long idParaExclusao = produtoCadastrado.getId();
        produtoDao.excluirProduto(idParaExclusao);

        Produto produtoExcluido = produtoDao.consultarProdutoId(idParaExclusao);
        assertNull(produtoExcluido);
    }

}
