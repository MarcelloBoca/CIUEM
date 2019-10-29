package mz.ciuem.stock.teste;

import java.util.List;
import mz.ciuem.stock.dao.CategoriaDAO;
import mz.ciuem.stock.domain.Categoria;
import org.junit.Ignore;
import org.junit.Test;

public class CategoriaDAOTest {
	
	@Test
	@Ignore
	public void Salvar(){
		
		Categoria cat1= new Categoria();
		cat1.setDesignacao("Designacao 1");
		
		Categoria cat2= new Categoria();
		cat2.setDesignacao("Designacao 2");
		
		CategoriaDAO catDao = new CategoriaDAO();
		catDao.gravar(cat1);
		catDao.gravar(cat2);	
		
	}
	@Test
	@Ignore
	public void listar(){
		
		CategoriaDAO catDao = new CategoriaDAO();
		List<Categoria> categoria = catDao.listar(); 
		for (Categoria categoria2 : categoria) {
			System.out.println(categoria2);
			
		}
	}
	@Test
	@Ignore
	public void buscarPorCaodigo(){
		
		CategoriaDAO catDao = new CategoriaDAO();
		Categoria categ = catDao.buscarPorCodigo(1L);
		
		System.out.println(categ);
				
	}
	
	@Test
	@Ignore
	public void remover(){
		
		CategoriaDAO catDao = new CategoriaDAO();
		Categoria categoria = catDao.buscarPorCodigo(4L);
		catDao.excluir(categoria);			
	}
	
	@Test
	@Ignore
	public void editar(){
		
		CategoriaDAO catDao = new CategoriaDAO();
		Categoria categoria = catDao.buscarPorCodigo(3L);
		categoria.setDesignacao("Descricao Y");
		catDao.editar(categoria);	
		
	}	
}