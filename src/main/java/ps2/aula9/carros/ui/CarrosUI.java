package ps2.aula9.carros.ui;


import java.util.List;


import ps2.aula9.carros.dao.Carro;
import ps2.aula9.carros.dao.CarrosDao;
import ps2.utils.DialogoGui;



public class CarrosUI {
	private CarrosDao dao;

	public CarrosUI(CarrosDao dao) {
		super();
		this.dao = dao;
	}

	private void opcaoCriarTabela() {
		try {
			dao.createTable();
			DialogoGui.mostrar("Tabela criada!");
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Deu falha, veja a mensagem que esta no console!!!");
		}
	}

	private void opcaoApagarTabela() {
		try {
			dao.dropTable();
			DialogoGui.mostrar("Tabela apagada!");
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Deu fala, veja a mensagem que esta no console!!!");
		}
	}

	private void opcaoCadastrar() {
		try {
			String marca = DialogoGui.lerString("Marca:");
			String modelo = DialogoGui.lerString("Modelo:");
			Double velMax = DialogoGui.lerDouble("Velocidade Maxima");
			String estado = DialogoGui.lerString("Estado:");
			Double carga = DialogoGui.lerDouble("Carga");

			long id = dao.create(marca, modelo, velMax, estado, carga);
			DialogoGui.mostrar("Carro criado com id " + id);
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	private void opcaoConsultar() {
		try {
			String msg = "Carros:\n";
			List<Carro> Carros = dao.read();
			for (Carro c : Carros) {
				msg += "ID: " + c.getId() + " - ";
				msg += "MARCA: " + c.getMarca() + " - ";
				msg += "MODELO: " +c.getModelo() + " - ";
				msg += "VELMAX: " + c.getVelMax() + " - ";
				msg += "ESTADO: " + c.getEstado() + " - ";
				msg += "CARGA: " + c.getCarga() + "\n";

			}
			DialogoGui.mostrar(msg);
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	private void opcaoAlterar() {
		try {
			long id = DialogoGui.lerInteiroLongo("ID do Carro a ser alterado:");
			Carro c = dao.readById(id);
			if (c != null) {
				String marca = DialogoGui.lerString("Novo valor para a marca: ");
				String modelo = DialogoGui.lerString("Novo valor para modelo");
				double velMax = DialogoGui.lerDouble("Novo valor para Velocidade Máxima");
				String estado = DialogoGui.lerString("Novo valor para estado");
				double carga = DialogoGui.lerDouble("Novo valor para a carga");


				c.setMarca(marca);
				c.setModelo(modelo);
				c.setVelMax(velMax);
				c.setEstado(estado);
				c.setCarga(carga);
				dao.update(c);
				DialogoGui.mostrar("Carro atualizado com sucesso!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	private void opcaoApagar() {
		try {
			long id = DialogoGui.lerInteiroLongo("ID do Carro a ser apagado:");
			dao.delete(id);
			DialogoGui.mostrar("Carro removido com sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	public void dialogar() {
		boolean sair = false;
		while (!sair) {
			int op = DialogoGui.menu("Cadastrar", "Consultar", "Alterar", "Apagar",
					"Criar tabela", "Apagar tabela", "Sair");
			if (op == 1) {
				opcaoCadastrar();
			} else if (op == 2) {
				opcaoConsultar();
			} else if (op == 3) {
				opcaoAlterar();
			} else if (op == 4) {
				opcaoApagar();
			} else if (op == 5) {
				opcaoCriarTabela();
			} else if (op == 6) {
				opcaoApagarTabela();
			} else  if (op == 7) {
				sair = true;
			}
		}
		DialogoGui.mostrar("Fim do programa!");
	}
}