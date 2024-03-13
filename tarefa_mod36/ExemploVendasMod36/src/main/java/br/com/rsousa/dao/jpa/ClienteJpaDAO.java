package br.com.rsousa.dao.jpa;

import br.com.rsousa.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.rsousa.domain.jpa.ClienteJpa;

/**
 * @author renan.sousa
 *
 */
public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
