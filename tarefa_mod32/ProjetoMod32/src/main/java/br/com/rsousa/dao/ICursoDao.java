package br.com.rsousa.dao;

import java.util.List;

import br.com.rsousa.domain.Curso;

/**
 * @author renan.sousa
 *
 */

public interface ICursoDao {

	public Curso cadastrar(Curso curso);

	public void excluir(Curso cur);

	public List<Curso> buscarTodos();
}
