package br.com.rsousa.dao.jpa;

import br.com.rsousa.dao.generic.jpa.GenericJpaDB3DAO;
import br.com.rsousa.domain.jpa.ClienteJpa2;

/**
 * @author renan.sousa
 *
 */
public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}

}
