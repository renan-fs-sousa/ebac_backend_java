package br.com.rsousa.dao;

import br.com.rsousa.domain.Produto;

import java.sql.SQLException;
import java.util.List;

/**
 * @author renan.sousa
 *
 */

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws SQLException;

    public Produto consultar(Produto produto) throws SQLException;

    public Integer excluir(Produto produto) throws SQLException;

    public Integer atualizar(Produto produto) throws SQLException;

    public List<Produto> buscarTodos() throws SQLException;

}
