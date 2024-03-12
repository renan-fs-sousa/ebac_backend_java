/**
 * 
 */
package br.com.rsousa.dao.jpa;

import br.com.rsousa.dao.generic.jpa.GenericJpaDAO;
import br.com.rsousa.domain.jpa.ClienteJpa;

/**
 * @author renan.sousa
 *
 */
public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
