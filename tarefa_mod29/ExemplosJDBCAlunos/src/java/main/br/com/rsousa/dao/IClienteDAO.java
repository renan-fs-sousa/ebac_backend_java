package br.com.rsousa.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.rsousa.domain.Cliente;

/**
 * @author renan.sousa
 *
 */

public interface IClienteDAO {

	public Integer cadastrar(Cliente cliente) throws SQLException;

	public Integer atualizar(Cliente cliente) throws SQLException;

	public Cliente consultar(Cliente cliente) throws SQLException;

	public Integer excluir(Cliente clienteBD) throws SQLException;

	public List<Cliente> buscarTodos() throws SQLException;
}
