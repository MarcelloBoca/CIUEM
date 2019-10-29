package mz.ciuem.stock.teste;

import java.util.List;
import mz.ciuem.stock.dao.DepartamentoDAO;
import mz.ciuem.stock.domain.Departamento;

import org.junit.Ignore;
import org.junit.Test;

public class DepartamentoDAOTest {
	
	@Test
	@Ignore
	public void Salvar(){
		
		Departamento dep1 = new Departamento();
		dep1.setDesignacao("Designacao 3");
		
		Departamento dep2= new Departamento();
		dep2.setDesignacao("Designacao 4");
		
		DepartamentoDAO depDao = new DepartamentoDAO();
		depDao.gravar(dep1);
		depDao.gravar(dep2);	
		
	}
	@Test
	@Ignore
	public void listar(){
		
		DepartamentoDAO depDao = new DepartamentoDAO();
		List<Departamento> departamento = depDao.listar(); 
		for (Departamento departamento2 : departamento) {
			
			System.out.println(departamento2);	
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCaodigo(){
		
		DepartamentoDAO depDao = new DepartamentoDAO();
		Departamento departa = depDao.buscarPorCodigo(4L);
		
		System.out.println(departa);
				
	}
	
	@Test
	@Ignore
	public void remover(){
		
		DepartamentoDAO depDao = new DepartamentoDAO();
		Departamento departamento = depDao.buscarPorCodigo(4L);
		depDao.excluir(departamento);			
	}
	
	@Test
	@Ignore
	public void editar(){
		
		DepartamentoDAO depDao = new DepartamentoDAO();
		Departamento departamento = depDao.buscarPorCodigo(3L);
		departamento.setDesignacao("Descricao Y");
		depDao.editar(departamento);	
		
	}	
}