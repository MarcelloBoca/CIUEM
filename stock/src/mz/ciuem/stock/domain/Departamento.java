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
@Table(name = "tbl_departamento")
@NamedQueries({ 
	@NamedQuery(name = "Departamento.listar", query = "SELECT departamento FROM Departamento departamento"),
	@NamedQuery(name= "Departamento.buscarPorCodigo", query = "SELECT departamento FROM Departamento departamento WHERE departamento.codigo=:codigo")
	
})
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_departamento")
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
		return "Departamento [codigo=" + codigo + ", designacao=" + designacao
				+ "]";
	}

}
