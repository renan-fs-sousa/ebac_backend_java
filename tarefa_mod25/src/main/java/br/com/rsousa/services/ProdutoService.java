package br.com.rsousa.services;

import br.com.rsousa.dao.IProdutoDAO;
import br.com.rsousa.domain.Produto;
import br.com.rsousa.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}
}
