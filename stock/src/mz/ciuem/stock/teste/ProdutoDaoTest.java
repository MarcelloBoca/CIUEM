package mz.ciuem.stock.teste;

import mz.ciuem.stock.dao.CategoriaDAO;
import mz.ciuem.stock.dao.ProdutoDAO;
import mz.ciuem.stock.domain.Categoria;
import mz.ciuem.stock.domain.Produto;
import org.junit.Ignore;
import org.junit.Test;

public class ProdutoDaoTest {
	
	@Test
    @Ignore
	public void salvar() {

		CategoriaDAO categoriaDao = new CategoriaDAO();
		Categoria categoria = categoriaDao.buscarPorCodigo(3L);
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		Produto produto = new Produto();
		produto.setCategoria(categoria);
		produto.setDesignacao("Designacao 3");
		produto.setUnidade("Kg");
		
		produtoDao.gravar(produto);

	    }
	
		@Test
		@Ignore
		public void buscarPorCaodigo(){
			
			ProdutoDAO prodDao = new ProdutoDAO();
			Produto produto = prodDao.buscarPorCodigo(1L);
			
			System.out.println(produto);
					
		}
		
		@Test
		@Ignore
		public void remover(){
			
			ProdutoDAO prodDao = new ProdutoDAO();
			Produto produto = prodDao.buscarPorCodigo(3L);
			prodDao.excluir(produto);			
		}
		
		@Test
		@Ignore
		public void editar(){
			
			CategoriaDAO categoriaDao = new CategoriaDAO();
			Categoria categoria = categoriaDao.buscarPorCodigo(6L);
			
			ProdutoDAO prodDao = new ProdutoDAO();
			Produto produto = prodDao.buscarPorCodigo(2L);
			produto.setDesignacao("Designacao 2");
			produto.setUnidade("Gramas");
			produto.setCategoria(categoria);
			prodDao.editar(produto);	
			
		}	
}	