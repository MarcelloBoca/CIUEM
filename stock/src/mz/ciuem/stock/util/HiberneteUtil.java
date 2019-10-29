package mz.ciuem.stock.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HiberneteUtil {
	
	
	private static SessionFactory sessionFactory = buildSessionFctory();
	
	private static SessionFactory buildSessionFctory() {
		
		try {
			
			//Cria um sessionfactory a partir de um hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure();
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
										.applySettings(configuration.getProperties()).build();
			
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
			
		} catch (Throwable ex) {
			
			//Falha ao tentar seesionFactory
			System.err.println("A sessionfactory nao pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
