
package br.com.rsousa.vendas.online.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.rsousa.vendas.online.domain.Cliente;

/**
 * @author renan.sousa
 *
 */
@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String> {

	Optional<Cliente> findByCpf(Long cpf);
}
