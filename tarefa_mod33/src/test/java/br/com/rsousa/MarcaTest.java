package br.com.rsousa;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.rsousa.dao.IMarcaDAO;
import br.com.rsousa.dao.MarcaDAO;
import br.com.rsousa.domain.Marca;

public class MarcaTest {

	private IMarcaDAO marcaDAO;

	public MarcaTest() {
		marcaDAO = new MarcaDAO();
	}

	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setCodigo("C03");
		marca.setNome("Ford");
		marca = marcaDAO.cadastrar(marca);

		assertNotNull(marca);
		assertNotNull(marca.getId());

		marca = marcaDAO.excluir(marca);

	}
}
