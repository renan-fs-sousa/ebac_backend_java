package br.com.rsousa;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.rsousa.dao.CarroDAO;
import br.com.rsousa.dao.ICarroDAO;
import br.com.rsousa.dao.IMarcaDAO;
import br.com.rsousa.dao.MarcaDAO;
import br.com.rsousa.domain.Carro;
import br.com.rsousa.domain.Marca;

public class CarroTest {

	private ICarroDAO carroDAO;

	private IMarcaDAO marcaDAO;

	public CarroTest() {
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
	}

	@Test
	public void cadastrar() {
		Marca marca = criarMarca("C02");

		Carro carro = new Carro();
		carro.setCodigo("C02");
		carro.setModelo("Civic");
		carro.setMarca(marca);
		carro = carroDAO.cadastrar(carro);

		assertNotNull(carro);
		assertNotNull(carro.getId());

		marca = marcaDAO.excluir(marca);
		carro = carroDAO.excluir(carro);
	}

	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setNome("Honda");
		return marcaDAO.cadastrar(marca);
	}

}
