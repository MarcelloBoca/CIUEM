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
@Table(name = "tbl_entradaProdtuto")
@NamedQueries({ 
	@NamedQuery(name = "EntradaProdutos.listar", query = "SELECT entradaProdutos FROM EntradaProdutos entradaProdutos"),
	@NamedQuery(name= "EntradaProdutos.buscarPorCodigo", query = "SELECT entradaProdutos FROM EntradaProdutos entradaProdutos WHERE entradaProdutos.codigo=:codigo")
	
}) 

public class EntradaProdutos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_entradaProduto")
	private Long codigo;

	@Column(name = "quant", length = 10, nullable = false)
	private Integer quant;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_entrada", nullable = false)
	private Date dataEntrada;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_produto_id_produto", referencedColumnName = "id_produto", nullable = false)
	private Produto produto;

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

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "EntradaProdutos [codigo=" + codigo + ", quant=" + quant
				+ ", dataEntrada=" + dataEntrada + ", produto=" + produto + "]";
	}
}