package br.com.rsousa.dao;

import br.com.rsousa.domain.Acessorio;

public interface IAcessorioDAO {

    Acessorio cadastrar(Acessorio acessorio);

    Acessorio excluir(Acessorio acessorio);

}
