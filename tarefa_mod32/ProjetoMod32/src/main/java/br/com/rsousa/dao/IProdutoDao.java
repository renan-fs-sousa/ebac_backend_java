package br.com.rsousa.dao;

import br.com.rsousa.domain.Produto;

/**
 * @author renan.sousa
 *
 */

public interface IProdutoDao {

	Produto cadastrar(Produto produtoTest);

	Produto consultarProdutoId(Long idConsulta);

	Produto atualizar(Produto produtoCadastrado);

	void excluirProduto(Long idParaExclusao);
}
