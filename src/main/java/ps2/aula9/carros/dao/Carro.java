package ps2.aula9.carros.dao;

public class Carro {
	
		private long id;
		private String marca;
		private String modelo;
		private double velMax;
		private String estado;
		private double carga;
		
		public Carro() {
			this.id = 0;
			this.marca = "";
			this.modelo = "";
			this.velMax = 0.0;
			this.estado = "";
			this.carga = 0.0;
		}
		public Carro(long id, String n, String o,  double m, String a, double z) {
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
		public Double getVelMax() {
			return velMax;
		}
		public void setVelMax(double velMax) {
			this.velMax = velMax;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public Double getCarga() {
			return carga;
		}
		public void setCarga(double carga) {
			this.carga = carga;
		}
		
	
}


