/**
 * 
 */
package br.com.rsousa.services;

import br.com.rsousa.domain.Cliente;
import br.com.rsousa.exceptions.DAOException;
import br.com.rsousa.services.generic.IGenericService;

/**
 * @author renan.sousa
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	// Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
	//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
	//
	// void excluir(Long cpf);
	//
	// void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
