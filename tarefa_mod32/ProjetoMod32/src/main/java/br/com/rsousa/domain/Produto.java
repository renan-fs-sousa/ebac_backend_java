package br.com.rsousa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author renan.sousa
 *
 */

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
	@SequenceGenerator(name = "prod_seq", sequenceName = "sq_prod", initialValue = 1, allocationSize = 10)
	private Long id;

	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;

	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;

	@Column(name = "VALOR", nullable = false)
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
