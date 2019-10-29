package mz.ciuem.stock.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mz.ciuem.stock.domain.Categoria;
import mz.ciuem.stock.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CategoriaBean {
	
	private Categoria categoria;
	
	public Categoria getCategoria() {
		if(categoria ==null){
			
			categoria = new Categoria();
		}
		
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void salvar(){
		
		FacesUtil.adicionarMsgInfo(categoria.toString());
		FacesUtil.adicionarMsgInfo("Categoria salva com sucesso");
	}

}