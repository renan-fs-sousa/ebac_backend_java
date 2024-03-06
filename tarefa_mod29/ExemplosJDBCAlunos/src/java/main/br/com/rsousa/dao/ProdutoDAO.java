package br.com.rsousa.dao;

import br.com.rsousa.dao.jdbc.ConnectionFactory;
import br.com.rsousa.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "insert into tb_produto (id, nome_produto, valor_produto, codigo) values (nextval('sq_produto'), ?, ?, ?)";
            stm = connection.prepareStatement(sql);

            stm.setString(1, produto.getNome());
            stm.setDouble(2, produto.getValor());
            stm.setInt(3, produto.getCodigo());
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
    public Produto consultar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produtoRetorno = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "select * from tb_produto where codigo = ?";
            stm = connection.prepareStatement(sql);

            stm.setLong(1, produto.getCodigo());
            rs = stm.executeQuery();

            if (rs.next()) {
                produtoRetorno = new Produto();
                produtoRetorno.setId(rs.getInt("id"));
                produtoRetorno.setNome(rs.getString("nome_produto"));
                // produtoRetorno.setDescricao(rs.getString("DESCRICAO"));
                produtoRetorno.setValor(rs.getDouble("valor_produto"));
                produtoRetorno.setCodigo(rs.getInt("codigo"));
            }
            return produtoRetorno;

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
    public Integer excluir(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "delete from tb_produto where id = ?";
            stm = connection.prepareStatement(sql);

            stm.setInt(1, produto.getId());
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
    public Integer atualizar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "update tb_produto set  nome_produto = ? , valor_produto = ?, codigo = ? where id = ?";
            stm = connection.prepareStatement(sql);

            stm.setString(1, produto.getNome());
            stm.setDouble(2, produto.getValor());
            stm.setInt(3, produto.getCodigo());
            stm.setInt(4, produto.getId());
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
    public List<Produto> buscarTodos() throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produtoRetorno = null;
        List<Produto> listaProdutos = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "select * from tb_produto";
            stm = connection.prepareStatement(sql);

            rs = stm.executeQuery();

            while (rs.next()) {
                produtoRetorno = new Produto();
                produtoRetorno.setId(rs.getInt("id"));
                produtoRetorno.setNome(rs.getString("nome_produto"));
                produtoRetorno.setValor(rs.getDouble("valor_produto"));
                produtoRetorno.setCodigo(rs.getInt("codigo"));
                listaProdutos.add(produtoRetorno);
            }
            return listaProdutos;

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
