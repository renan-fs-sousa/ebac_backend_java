/**
 * 
 */
package br.com.rsousa.dao.jpa;

import br.com.rsousa.dao.generic.jpa.GenericJpaDAO;
import br.com.rsousa.domain.jpa.ProdutoJpa;

/**
 * @author renan.sousa
 *
 */
public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
