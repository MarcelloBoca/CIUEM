package mz.ciuem.stock.dao;

import java.util.List;
import mz.ciuem.stock.domain.Categoria;
import mz.ciuem.stock.util.HiberneteUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoriaDAO {

	public void gravar(Categoria categoria) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(categoria);
			transacao.commit();

		} catch (RuntimeException ex) {

			if (transacao != null) {
				transacao.rollback();
			}

		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> listar() {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		List<Categoria> categoria = null;

		try {
			Query consulta = sessao.getNamedQuery("Categoria.listar");
			categoria = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();

		}
		return categoria;

	}

	public Categoria buscarPorCodigo(Long codigo) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Categoria categoria = null;

		try {
			Query consulta = sessao.getNamedQuery("Categoria.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			categoria = (Categoria) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();

		}
		return categoria;

	}

	public void excluir(Categoria categoria){

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(categoria);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}throw ex;

		} finally {
			sessao.close();
		}
	}
	
	public void editar(Categoria categoria) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();			
			sessao.update(categoria);
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
