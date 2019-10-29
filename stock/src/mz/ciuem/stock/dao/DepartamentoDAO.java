package mz.ciuem.stock.dao;

import java.util.List;
import mz.ciuem.stock.domain.Departamento;
import mz.ciuem.stock.util.HiberneteUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartamentoDAO {
	
	public void gravar(Departamento departamento) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(departamento);
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
	public List<Departamento> listar() {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		List<Departamento> departamento = null;

		try {
			Query consulta = sessao.getNamedQuery("Departamento.listar");
			departamento = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();

		}
		return departamento;

	}

	public Departamento buscarPorCodigo(Long codigo) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Departamento departamento = null;

		try {
			Query consulta = sessao.getNamedQuery("Departamento.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			departamento = (Departamento) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();

		}
		return departamento;

	}

	public void excluir(Departamento departamento){

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(departamento);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}throw ex;

		} finally {
			sessao.close();
		}
	}
	
	public void editar(Departamento departamento) {

		Session sessao = HiberneteUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();			
			sessao.update(departamento);
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
