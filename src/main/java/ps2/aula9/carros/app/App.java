package ps2.aula9.carros.app;

import org.apache.derby.jdbc.ClientDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import ps2.aula9.carros.dao.CarrosDao;
import ps2.aula9.carros.ui.CarrosUI;

public class App {
	
	
		public static void main(String[] args) {
			ClientDataSource ds;
			ds = new ClientDataSource();
			ds.setServerName("localhost");
			ds.setPortNumber(1527);
			ds.setDatabaseName("faculdadeV2;create=true");
			ds.setUser("app");
			ds.setPassword("app");
			Jdbi jdbi = Jdbi.create(ds);
			jdbi.installPlugin(new SqlObjectPlugin());
			CarrosDao dao = jdbi.onDemand(CarrosDao.class);		
			CarrosUI ui = new CarrosUI(dao);
			ui.dialogar();
		}
	}


