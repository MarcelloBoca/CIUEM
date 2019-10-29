package mz.ciuem.stock.dao;

import java.util.List;
import mz.ciuem.stock.domain.EntradaProdutos;
import mz.ciuem.stock.util.HiberneteUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EntradaProdutosDAO {
	
	  public void gravar (EntradaProdutos entradaProdutos){
			
			Session sessao = HiberneteUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			try {
				transacao = sessao.beginTransaction();
				sessao.save(entradaProdutos);
				transacao.commit();
	
			} catch (RuntimeException ex) {
				if (transacao != null) {
					transacao.rollback();
				}
				throw ex;
			} finally {
				sessao.close();
			}	
		}
	
	@SuppressWarnings("unchecked")
	public List<EntradaProdutos> listar() {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		List<EntradaProdutos> entradaProdutos = null;

		try {
			Query consulta = sessao.getNamedQuery("EntradaProdutos.listar");
			entradaProdutos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();

		}
		return entradaProdutos;

	}
	
	public EntradaProdutos buscarPorCodigo(Long codigo) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		EntradaProdutos entradaProdutos = null;

		try {
			Query consulta = sessao.getNamedQuery("EntradaProdutos.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			entradaProdutos = (EntradaProdutos) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();

		}
		return entradaProdutos;

	}
	
	public void excluir(EntradaProdutos entradaProdutos){

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entradaProdutos);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}throw ex;

		} finally {
			sessao.close();
		}
	}
	
	public void editar(EntradaProdutos entradaProdutos) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();			
			sessao.update(entradaProdutos);
			transacao.commit();

		} catch (RuntimeException ex) {

			if (transacao != null) {
				transacao.rollback();
			}

		} finally {
			sessao.close();
		}
	}

}
