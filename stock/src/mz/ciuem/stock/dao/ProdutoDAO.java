package mz.ciuem.stock.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import mz.ciuem.stock.domain.Produto;
import mz.ciuem.stock.util.HiberneteUtil;

public class ProdutoDAO {
	
	public void gravar (Produto produto){
		
		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(produto);
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
	public List<Produto> listar() {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		List<Produto> produtos = null;

		try {
			Query consulta = sessao.getNamedQuery("Produto.listar");
			produtos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();

		}
		return produtos;

	}
	
	public Produto buscarPorCodigo(Long codigo) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Produto produto = null;

		try {
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			produto = (Produto) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();

		}
		return produto;

	}
	
	public void excluir(Produto produto){

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}throw ex;

		} finally {
			sessao.close();
		}
	}
	
	public void editar(Produto produto) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();			
			sessao.update(produto);
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
