package ps2.aula9.carros.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface CarrosDao {
	
	@SqlUpdate("CREATE TABLE carros (" +
			   " id BIGINT NOT NULL " +
			   " GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
			   " marca VARCHAR(255) NOT NULL," +
			   " modelo VARCHAR(255), " +
			   " velMax INT, " +
			   " estado VARCHAR(255)," +
			   " carga INT," + 
			   " PRIMARY kEY (id)" + 
	")")
	void createTable();
	
	@SqlUpdate("DROP TABLE carros")
	void dropTable();
	
	@SqlUpdate("INSERT INTO carros (marca, modelo, velMax, estado, carga) VALUES (?,?,?,?,?)")
	@GetGeneratedKeys("id")
	long create(String marca, String modelo, double velMax, String estado, double carga);
	
	@SqlQuery("SELECT * FROM carros")
	@RegisterBeanMapper(Carro.class)
	List<Carro> read();
	
	@SqlQuery("SELECT * FROM carros WHERE id=?")
	@RegisterBeanMapper(Carro.class)
	Carro readById(long id);
	
	@SqlUpdate("UPDATE carros SET marca=:marca, modelo=:modelo, velMax=:velMax, estado=:estado, carga=:carga WHERE id=:id")
	void update(@BindBean Carro c);
	
	@SqlUpdate("UPDATE carros WHERE id=?")
	void delete(long id);
	
}
