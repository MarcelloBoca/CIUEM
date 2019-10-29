package mz.ciuem.stock.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_categoria")
@NamedQueries({ 
	@NamedQuery(name = "Categoria.listar", query = "SELECT categoria FROM Categoria categoria"),
	@NamedQuery(name= "Categoria.buscarPorCodigo", query = "SELECT categoria FROM Categoria categoria WHERE categoria.codigo=:codigo")
	
})
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_categoria")
	private Long codigo;

	@Column(name = "designacao", length = 50, nullable = false)
	private String designacao;

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

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", designacao=" + designacao
				+ "]";
	}
}