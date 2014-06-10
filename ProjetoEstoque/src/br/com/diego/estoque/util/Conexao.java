package br.com.diego.estoque.util;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexao {

	final private String driver = "com.mysql.jdbc.Driver";
	final private String url = "jdbc:mysql://localhost/estoque";
	final private String usuario = "root";
	final private String senha = "admin";

	private Connection conexao;// respons�vel por criar a conex�o com BD
	public Statement statemente;// respons�vel por abrir caminha at� o caminho
								// pra a BD
	public ResultSet resultSet;// respons�vel por executar os resulados da
								// consulta sql

	public Conexao() {

	}

	// m�todo de que efetua a conex�o com o banco de dados.
	public Connection conecta() {

		Connection conn = this.conexao;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, senha);
			JOptionPane.showMessageDialog(null, "Conectou!");
		} catch (ClassNotFoundException driver) {

			JOptionPane.showMessageDialog(null, "Driver n�o localizado: "
					+ driver);

		} catch (SQLException fonteBD) {

			JOptionPane.showMessageDialog(null,
					"Erro na conex�o com a fonte de dados: " + fonteBD);

		}

		return conn;
	}// fim do m�todo conecta

	public void desconecta() {

		if (this.conexao != null) {

			try {

				conexao.close();
				JOptionPane.showMessageDialog(null, "Banco de Dados fechado.");
			} catch (SQLException e) {

				JOptionPane.showMessageDialog(
						null,
						"N�o foi poss�vel fechar o banco de dados "
								+ e.getMessage());

			}

		}// fim do if

	}// fim do m�todo desconecta

	public void executaSql(String sql) throws SQLException {

		this.statemente = conexao.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		this.resultSet = statemente.executeQuery(sql);
		/**
		 * ResultSet.TYPE_SCROLL_SENSITIVE: Especifica que um cursor de um
		 * ResultSet pode rolar em qualquer dire��o e que as altera��es feitas
		 * no ResultSet durante o processamento de ResultSet s�o refletidas
		 * imediatamente no ResultSet.
		 * 
		 * ResultSet.CONCUR_READ_ONLY: Especifica que ResultSet n�o pode ser
		 * atualizado(isto �, altera��es no cote�do do ResultSet n�o podem ser
		 * refletidas no banco de dados com oss m�todos atualizados do
		 * ResultSet).
		 * */
	}// fim do m�todo executaSql

	public static void main(String[] args) {

		// main para testar a conx�o com o banco de dado access
		Conexao conecta = new Conexao();
		conecta.conecta();

	}

}
