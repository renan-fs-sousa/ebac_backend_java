package br.com.rsousa.dao;

import br.com.rsousa.domain.Marca;

public interface IMarcaDAO {

    Marca cadastrar(Marca marca);

    Marca excluir(Marca marca);

}
