package mz.ciuem.stock.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_produto")
@NamedQueries({ 
	@NamedQuery(name = "Produto.listar", query = "SELECT produto FROM Produto produto"),
	@NamedQuery(name= "Produto.buscarPorCodigo", query = "SELECT produto FROM Produto produto WHERE produto.codigo=:codigo")
	
}) 

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto")
	private Long codigo;

	@Column(name = "designacao", length = 50, nullable = false)
	private String designacao;

	@Column(name = "unidade_medida", length = 10, nullable = false)
	private String unidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_categoria_id_categoria", referencedColumnName = "id_categoria", nullable = false)
	private Categoria categoria;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", designacao=" + designacao
				+ ", unidade=" + unidade + ", categoria=" + categoria + "]";
	}
	
}