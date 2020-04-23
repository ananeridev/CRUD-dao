package ps2.aula9.carros.dao;

import java.util.List;

public interface CarrosDao {
	
	void createTable();
	
	void dropTable();
	
	long create(String marca, String modelo, double velMax, String estado, double carga);
	
	List<Carro> read();
	
	Carro readById(long id)
}
