package br.com.rsousa.dao.jpa;

import br.com.rsousa.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.rsousa.domain.jpa.ProdutoJpa;

/**
 * @author renan.sousa
 *
 */
public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
