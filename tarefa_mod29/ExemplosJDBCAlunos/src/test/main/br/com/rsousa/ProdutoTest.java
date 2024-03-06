package br.com.rsousa;

import br.com.rsousa.dao.IProdutoDAO;
import br.com.rsousa.dao.ProdutoDAO;
import br.com.rsousa.domain.Produto;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoTest {

    @Test
    public void cadastrarProduto() throws SQLException {

        IProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setCodigo(91);
        produto.setValor(11.00);

        Integer qtdCadastrado = produtoDAO.cadastrar(produto);
        assertTrue(qtdCadastrado == 1);

        Produto produtoBD = produtoDAO.consultar(produto);
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getValor(), produtoBD.getValor());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void atualizarProduto() throws SQLException {

        IProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Produto 02");
        produto.setCodigo(92);
        produto.setValor(12.00);

        Integer qtdCadastrado = produtoDAO.cadastrar(produto);
        assertTrue(qtdCadastrado == 1);

        Produto produtoBD = produtoDAO.consultar(produto);
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getValor(), produtoBD.getValor());

        produtoBD.setNome("Produto 02 NOVO");
        produto.setCodigo(100);
        produtoBD.setValor(12.12);
        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoBD1 = produtoDAO.consultar(produto);
        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.consultar(produtoBD);
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());
        assertEquals(produtoBD.getValor(), produtoBD2.getValor());

        Integer countDel = produtoDAO.excluir(produtoBD2);
        assertTrue(countDel == 1);
    }

    @Test
    public void consultarProduto() throws SQLException {
        IProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Produto 03");
        produto.setCodigo(93);
        produto.setValor(13.00);

        Integer qtdCadastrado = produtoDAO.cadastrar(produto);
        assertTrue(qtdCadastrado == 1);

        Produto produtoConsultado = produtoDAO.consultar(produto);
        assertNotNull(produtoConsultado);

        Integer countDel = produtoDAO.excluir(produtoConsultado);
        assertTrue(countDel == 1);

    }

    @Test
    public void consultarTodos() throws SQLException {
        IProdutoDAO produtoDAO = new ProdutoDAO();

        List<Produto> listaProdutos = new ArrayList<>();

        List<Produto> listaProdutosBD = new ArrayList<>();

        Produto produto1 = new Produto();
        produto1.setCodigo(201);
        produto1.setNome("Produto 201");
        produto1.setValor(201.00);

        Produto produto2 = new Produto();
        produto2.setCodigo(202);
        produto2.setNome("Produto 202");
        produto2.setValor(202.00);

        listaProdutos.add(produto1);
        listaProdutos.add(produto2);

        for (Produto prod : listaProdutos) {
            Integer countCad = produtoDAO.cadastrar(prod);
            assertTrue(countCad == 1);
        }

        listaProdutosBD = produtoDAO.buscarTodos();

        assertEquals(2, listaProdutosBD.size());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto prod : list) {
            Integer countDel = produtoDAO.excluir(prod);
            assertTrue(countDel == 1);
        }
    }

    @Test
    public void excluirProduto() throws Exception {
        IProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo(95);
        produto.setNome("Produto 05");
        produto.setValor(15.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.consultar(produto);
        assertNotNull(produtoBD);
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getValor(), produtoBD.getValor());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

}
