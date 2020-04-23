package ps2.aula9.carros.dao;

public class Carro {
	
		private long id;
		private String marca;
		private String modelo;
		private int velMax;
		private String estado;
		private int carga;
		
		public Carro() {
			this.id = 0;
			this.marca = "";
			this.modelo = "";
			this.velMax = 0;
			this.estado = "";
			this.carga = 0;
		}
		public Carro(long id, String n, String o,  int m, String a, int z) {
			this.id = id;
			this.marca = n;
			this.modelo = o;
			this.velMax = m;
			this.estado = a;
			this.carga = z;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public int getVelMax() {
			return velMax;
		}
		public void setVelMax(int velMax) {
			this.velMax = velMax;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public int getCarga() {
			return carga;
		}
		public void setCarga(int carga) {
			this.carga = carga;
		}
		
	
}


