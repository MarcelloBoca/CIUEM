package mz.ciuem.stock.main;

import mz.ciuem.stock.util.HiberneteUtil;

public class GeraTabela {

	public static void main(String[] args) {
		
		HiberneteUtil.getSessionFactory();
		HiberneteUtil.getSessionFactory().close();

	}

}
