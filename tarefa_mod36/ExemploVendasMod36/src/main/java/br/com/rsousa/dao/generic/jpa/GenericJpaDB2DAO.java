package br.com.rsousa.dao.generic.jpa;

import java.io.Serializable;

import br.com.rsousa.domain.jpa.Persistente;

/**
 * @author renan.sousa
 *
 */
public abstract class GenericJpaDB2DAO<T extends Persistente, E extends Serializable>
		extends GenericJpaDAO<T, E> {

	public GenericJpaDB2DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Postgre2");
	}

}
