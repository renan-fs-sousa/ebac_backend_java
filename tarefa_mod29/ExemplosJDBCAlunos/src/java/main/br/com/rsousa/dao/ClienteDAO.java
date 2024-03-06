package br.com.rsousa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rsousa.dao.jdbc.ConnectionFactory;
import br.com.rsousa.domain.Cliente;

/**
 * @author renan.sousa
 *
 */

public class ClienteDAO implements IClienteDAO {

	@Override
	public Integer cadastrar(Cliente cliente) throws SQLException {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_CLIENTE (ID, CODIGO, NOME) VALUES (nextval('SQ_CLIENTE'),?,?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Cliente consultar(Cliente cliente) throws SQLException {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente clienteRetorno = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from tb_cliente where codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			rs = stm.executeQuery();
			if (rs.next()) {
				clienteRetorno = new Cliente();
				clienteRetorno.setId(rs.getLong("id"));
				clienteRetorno.setCodigo(rs.getString("codigo"));
				clienteRetorno.setNome(rs.getString("nome"));
			}
			return clienteRetorno;
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Integer atualizar(Cliente cliente) throws SQLException {
		Connection connection = null;
		PreparedStatement stm = null;

		try {
			connection = ConnectionFactory.getConnection();

			String sql = "update tb_cliente set  nome = ? , codigo = ? where id = ?";
			stm = connection.prepareStatement(sql);

			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCodigo());
			stm.setLong(3, cliente.getId());
			return stm.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Integer excluir(Cliente cliente) throws SQLException {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM tb_cliente WHERE CODIGO = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public List<Cliente> buscarTodos() throws SQLException {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente clienteRetorno = null;
		List<Cliente> listaClientes = new ArrayList<>();

		try {
			connection = ConnectionFactory.getConnection();

			String sql = "select * from tb_cliente";
			stm = connection.prepareStatement(sql);

			rs = stm.executeQuery();

			while (rs.next()) {
				clienteRetorno = new Cliente();
				clienteRetorno.setId(rs.getLong("id"));
				clienteRetorno.setNome(rs.getString("nome"));
				clienteRetorno.setCodigo(rs.getString("codigo"));
				listaClientes.add(clienteRetorno);
			}
			return listaClientes;

		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

}
