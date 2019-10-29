package mz.ciuem.stock.domain;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tbl_requisicao")
@NamedQueries({
	@NamedQuery(name = "Requisicao.listar", query = "SELECT requisicao FROM Requisicao requisicao"),
	@NamedQuery(name = "Requisicao.buscarPorCodigo", query = "SELECT requisicao From Requisicao requisicao WHERE requisicao.codigo=:codigo")
})
public class Requisicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_requisicao")
	private Long codigo;

	@Column(name = "quant", length = 10, nullable = false)
	private Integer quant;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_requisicao", nullable = false)
	private Date dataRequisicao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_produto_id_produto", referencedColumnName = "id_produto", nullable = false)
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_departamento_id_departamento", referencedColumnName = "id_departamento", nullable = false)
	private Departamento departamento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public Date getDataRequisicao() {
		return dataRequisicao;
	}

	public void setDataRequisicao(Date dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Requisicao [codigo=" + codigo + ", quant=" + quant
				+ ", dataRequisicao=" + dataRequisicao + ", produto=" + produto
				+ ", departamento=" + departamento + "]";
	}
	
}