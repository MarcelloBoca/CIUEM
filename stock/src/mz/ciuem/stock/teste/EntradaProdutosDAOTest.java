package mz.ciuem.stock.teste;

import java.util.Date;
import mz.ciuem.stock.dao.EntradaProdutosDAO;
import mz.ciuem.stock.dao.ProdutoDAO;
import mz.ciuem.stock.domain.EntradaProdutos;
import mz.ciuem.stock.domain.Produto;
import org.junit.Ignore;
import org.junit.Test;

public class EntradaProdutosDAOTest {
	
	@Test
    @Ignore
	public void salvar() {

		ProdutoDAO produtoDao = new ProdutoDAO();
		Produto produto = produtoDao.buscarPorCodigo(2L);
		
		EntradaProdutos entrada = new EntradaProdutos();
		entrada.setDataEntrada(new Date());
		entrada.setProduto(produto);
		entrada.setQuant(new Integer(300));
		
		EntradaProdutosDAO entradaDao = new EntradaProdutosDAO();
		entradaDao.gravar(entrada);
		
	    }
	
		@Test
		@Ignore
		public void buscarPorCaodigo(){
			
			EntradaProdutosDAO entradaDao = new EntradaProdutosDAO();
			EntradaProdutos entrada = entradaDao.buscarPorCodigo(1L);
			
			System.out.println(entrada);
					
		}
		
		@Test
		@Ignore
		public void remover(){
			
			EntradaProdutosDAO entradaDao = new EntradaProdutosDAO();
			EntradaProdutos entrada = entradaDao.buscarPorCodigo(3L);
			entradaDao.excluir(entrada);			
		}
		
		@Test
		@Ignore
		public void editar(){
			
			EntradaProdutosDAO entradaDao = new EntradaProdutosDAO();
			EntradaProdutos entrada = entradaDao.buscarPorCodigo(1L);
			entrada.setQuant(new Integer(300));
			entradaDao.editar(entrada);	
			
		}	

}
