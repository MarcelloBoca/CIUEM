package mz.ciuem.stock.dao;

import java.util.List;
import mz.ciuem.stock.domain.Requisicao;
import mz.ciuem.stock.util.HiberneteUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RequisicaoDAO {
			
		public void gravar (Requisicao requisicao){
				
			Session sessao = HiberneteUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			try {
				transacao = sessao.beginTransaction();
				sessao.save(requisicao);
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
		public List<Requisicao> listar() {
		
			Session sessao = HiberneteUtil.getSessionFactory().openSession();
			List<Requisicao> requisicao = null;
		
			try {
				Query consulta = sessao.getNamedQuery("Requisicao.listar");
				requisicao = consulta.list();
			} catch (RuntimeException ex) {
				throw ex;
			} finally {
				sessao.close();
		
			}
			return requisicao;
		
		}
		
		public Requisicao buscarPorCodigo(Long codigo) {
		
			Session sessao = HiberneteUtil.getSessionFactory().openSession();
			Requisicao requisicao = null;
		
			try {
				Query consulta = sessao.getNamedQuery("Requisicao.buscarPorCodigo");
				consulta.setLong("codigo", codigo);
				requisicao = (Requisicao) consulta.uniqueResult();
			} catch (RuntimeException ex) {
				throw ex;
			} finally {
				sessao.close();
		
			}
			return requisicao;
		
		}
		
		public void excluir(Requisicao requisicao){
		
			Session sessao = HiberneteUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			try {
				transacao = sessao.beginTransaction();
				sessao.delete(requisicao);
				transacao.commit();
		
			} catch (RuntimeException ex) {
				if (transacao != null) {
					transacao.rollback();
				}throw ex;
		
			} finally {
				sessao.close();
			}
		}
		
		public void editar(Requisicao requisicao) {
		
			Session sessao = HiberneteUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			try {
				transacao = sessao.beginTransaction();			
				sessao.update(requisicao);
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