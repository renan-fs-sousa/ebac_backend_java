package br.com.rsousa.dao;

import br.com.rsousa.dao.generic.IGenericDAO;
import br.com.rsousa.domain.Venda;
import br.com.rsousa.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
