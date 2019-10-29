package mz.ciuem.stock.teste;

import org.junit.Test;
import mz.ciuem.stock.util.HiberneteUtil;

public class GerarTabelasTeste {

	@Test
	public void gerar() {

		HiberneteUtil.getSessionFactory();
		HiberneteUtil.getSessionFactory().close();

	}

}
