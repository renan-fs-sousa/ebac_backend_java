package br.com.rsousa.dao;

import br.com.rsousa.domain.Carro;

public interface ICarroDAO {

    public Carro cadastrar(Carro carro);

    public Carro excluir(Carro carro);

}
