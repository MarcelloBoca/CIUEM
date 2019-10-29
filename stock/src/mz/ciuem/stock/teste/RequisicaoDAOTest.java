package mz.ciuem.stock.teste;

import java.util.Date;
import mz.ciuem.stock.dao.DepartamentoDAO;
import mz.ciuem.stock.dao.ProdutoDAO;
import mz.ciuem.stock.dao.RequisicaoDAO;
import mz.ciuem.stock.domain.Departamento;
import mz.ciuem.stock.domain.Produto;
import mz.ciuem.stock.domain.Requisicao;

import org.junit.Ignore;
import org.junit.Test;

public class RequisicaoDAOTest {
	
	@Test
    @Ignore
	public void salvar() {

		DepartamentoDAO departamentoDao = new DepartamentoDAO();
		Departamento departamento = departamentoDao.buscarPorCodigo(3L);
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		Produto produto= produtoDao.buscarPorCodigo(1L);
		
		RequisicaoDAO requisicaoDao = new RequisicaoDAO();
		Requisicao requisicao = new Requisicao();
		requisicao.setDataRequisicao(new Date());
		requisicao.setDepartamento(departamento);
		requisicao.setProduto(produto);
		requisicao.setQuant(new Integer(40));
		
		requisicaoDao.gravar(requisicao);

	    }
	
		@Test
		@Ignore
		public void buscarPorCaodigo(){
			
			RequisicaoDAO requisicaoDAO = new RequisicaoDAO();
			Requisicao requisicao = requisicaoDAO.buscarPorCodigo(1L);
			
			System.out.println(requisicao);
					
		}
		
		@Test
		@Ignore
		public void remover(){
			
			RequisicaoDAO requisicaoDAO = new RequisicaoDAO();
			Requisicao requisicao = requisicaoDAO.buscarPorCodigo(5L);
			requisicaoDAO.excluir(requisicao);
			
		}
	
	
	@Test
	@Ignore
	public void editar(){
		
		DepartamentoDAO departamentoDao = new DepartamentoDAO();
		Departamento departamento = departamentoDao.buscarPorCodigo(1L);
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		Produto produto= produtoDao.buscarPorCodigo(2L);
		
		RequisicaoDAO requisicaoDao = new RequisicaoDAO();
		Requisicao requisicao = requisicaoDao.buscarPorCodigo(3L);
		requisicao.setDataRequisicao(new Date());
		requisicao.setDepartamento(departamento);
		requisicao.setProduto(produto);
		requisicao.setQuant(new Integer(10));	
		
		requisicaoDao.editar(requisicao);
	}	
	
}
