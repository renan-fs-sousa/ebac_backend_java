package br.com.rsousa.dao.jpa;

import br.com.rsousa.dao.generic.jpa.IGenericJapDAO;
import br.com.rsousa.domain.jpa.Persistente;

/**
 * @author renan.sousa
 *
 */
public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long> {

}
