package br.com.rsousa;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.rsousa.dao.AcessorioDAO;
import br.com.rsousa.dao.CarroDAO;
import br.com.rsousa.dao.IAcessorioDAO;
import br.com.rsousa.dao.ICarroDAO;
import br.com.rsousa.dao.IMarcaDAO;
import br.com.rsousa.dao.MarcaDAO;
import br.com.rsousa.domain.Acessorio;
import br.com.rsousa.domain.Carro;
import br.com.rsousa.domain.Marca;

public class AcessorioTest {
	private IAcessorioDAO acessorioDAO;

	private ICarroDAO carroDAO;

	private IMarcaDAO marcaDAO;

	public AcessorioTest() {
		acessorioDAO = new AcessorioDAO();
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
	}

	@Test
	public void cadastrar() {
		Carro carro = criarCarro("C01");

		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo("C01");
		acessorio.setNome("Aparelho de Som");
		acessorio.setValor(500d);
		acessorio.setCarro(carro);
		acessorio = acessorioDAO.cadastrar(acessorio);

		assertNotNull(acessorio);
		assertNotNull(acessorio.getId());

		carro = carroDAO.excluir(carro);
		acessorio = acessorioDAO.excluir(acessorio);
	}

	private Carro criarCarro(String codigo) {
		Marca marca = criarMarca("C01");

		Carro carro = new Carro();
		carro.setCodigo("C01");
		carro.setModelo("Corolla");
		carro.setMarca(marca);
		return carroDAO.cadastrar(carro);
	}

	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setNome("Toyota");
		return marcaDAO.cadastrar(marca);
	}
}
