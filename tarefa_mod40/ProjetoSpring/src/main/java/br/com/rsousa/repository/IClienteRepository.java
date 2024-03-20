package br.com.rsousa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rsousa.domain.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}