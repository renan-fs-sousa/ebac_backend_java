package br.com.rsousa.dao;

import java.util.List;

import br.com.rsousa.domain.Curso;
import br.com.rsousa.domain.Matricula;

/**
 * @author renan.sousa
 *
 */

public interface IMatriculaDao {

	Matricula cadastrar(Matricula mat);

	Matricula buscarPorCodigoCurso(String codigoCurso);

	Matricula buscarPorCurso(Curso curso);

	Matricula buscarPorCodigoCursoCriteria(String codigoCurso);

	Matricula buscarPorCursoCriteria(Curso curso);

	List<Matricula> buscarTodos();

	void excluir(Matricula matricula);
}
