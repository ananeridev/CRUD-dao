package ps2.aula9.carros.ui;


import java.util.List;


import ps2.aula9.carros.dao.Carro;
import ps2.aula9.carros.dao.CarrosDao;
import ps2.utils.DialogoGui;



public class CarrosUI {
	private CarrosDao dao;

	public CarrosUI(CarrosDao dao) {
		this.dao = dao;
	}

	private void opcaoCriarTabela() {
		try {
			dao.createTable();
			DialogoGui.mostrar("Tabela criada!");
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na tentativa de criar uma tabela, erro: " + ex.getMessage());
		}
	}

	private void opcaoApagarTabela() {
		try {
			dao.dropTable();
			DialogoGui.mostrar("Tabela apagada!");
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na tentativa de apagar uma tabela, erro: " + ex.getMessage());
		}
	}

	private void opcaoCadastrar() {
		try {
			String marca = DialogoGui.lerString("Marca:");
			validarParametrosDaQuery(marca);
			
			String modelo = DialogoGui.lerString("Modelo:");
			validarParametrosDaQuery(modelo);
			
			int velMax = DialogoGui.lerInteiro("Velocidade Maxima");
			String estado = DialogoGui.lerString("Estado:");
			validarParametrosDaQuery(estado);
			
			int carga = DialogoGui.lerInteiro("Carga");
			
			long id = dao.create(marca, modelo, velMax, estado, carga);
			DialogoGui.mostrar("Carro criado com id " + id);
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha ao tentar cadastrar o carro, erro: " + ex.getMessage());
		}
	}

	private void validarParametrosDaQuery(String valorInformadoPeloUsuario) {
     if(valorInformadoPeloUsuario.toUpperCase().contains("DELETE")) {
       throw new RuntimeException
         ("SQL INJECTION DETECTED, voce nao tem permissao para deletar um carro neste momento!");
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
			DialogoGui.mostrar("Falha ao tentar consultar, erro: " + ex.getMessage());
		}
	}

	private void opcaoAlterar() {
		try {
			long id = DialogoGui.lerInteiroLongo("ID do Carro a ser alterado:");
			Carro c = dao.readById(id);
			if (c != null) {
				String marca = DialogoGui.lerString("Novo valor para a marca: ");
				validarParametrosDaQuery(marca);
				
				String modelo = DialogoGui.lerString("Novo valor para modelo");
				validarParametrosDaQuery(modelo);
				
				int velMax = DialogoGui.lerInteiro("Novo valor para Velocidade M�xima");
				String estado = DialogoGui.lerString("Novo valor para estado");
				validarParametrosDaQuery(estado);
				
				int carga = DialogoGui.lerInteiro("Novo valor para a carga");

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
			DialogoGui.mostrar("Falha ao tentar alterar os dados do Carro, erro: " + ex.getMessage());
		}
	}

	private void opcaoApagar() {
		try {
			long id = DialogoGui.lerInteiroLongo("ID do Carro a ser apagado:");
			dao.delete(id);
			DialogoGui.mostrar("Carro removido com sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha ao tentar remover o carro, erro: " + ex.getMessage());
		}
	}

	public void dialogar() {
		boolean sair = false;
		while (!sair) {
		  int op = DialogoGui.menu("Cadastrar", "Consultar", "Alterar", "Apagar",
              "Criar tabela", "Apagar tabela", "Sair");
		  switch (op) {
            case 1:
              opcaoCadastrar();
              break;
            case 2: 
              opcaoConsultar();
              break;
            case 3:
              opcaoAlterar();
              break;
            case 4:
              opcaoApagar();
              break;
            case 5:
              opcaoCriarTabela();
            case 6: 
              opcaoApagarTabela();
              break;
            case 7:
              sair = true;
            default:
            sair = true;
              break;
          }
		}
		DialogoGui.mostrar("Fim do programa!");
	}
}