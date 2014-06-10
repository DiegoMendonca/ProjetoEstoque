package br.com.diego.estoque.util;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexao {

	final private String driver = "com.mysql.jdbc.Driver";
	final private String url = "jdbc:mysql://localhost/estoque";
	final private String usuario = "root";
	final private String senha = "admin";

	private Connection conexao;// responsável por criar a conexão com BD
	public Statement statemente;// responsável por abrir caminha até o caminho
								// pra a BD
	public ResultSet resultSet;// responsável por executar os resulados da
								// consulta sql

	public Conexao() {

	}

	// método de que efetua a conexão com o banco de dados.
	public Connection conecta() {

		Connection conn = this.conexao;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, senha);
			JOptionPane.showMessageDialog(null, "Conectou!");
		} catch (ClassNotFoundException driver) {

			JOptionPane.showMessageDialog(null, "Driver não localizado: "
					+ driver);

		} catch (SQLException fonteBD) {

			JOptionPane.showMessageDialog(null,
					"Erro na conexão com a fonte de dados: " + fonteBD);

		}

		return conn;
	}// fim do método conecta

	public void desconecta() {

		if (this.conexao != null) {

			try {

				conexao.close();
				JOptionPane.showMessageDialog(null, "Banco de Dados fechado.");
			} catch (SQLException e) {

				JOptionPane.showMessageDialog(
						null,
						"Não foi possível fechar o banco de dados "
								+ e.getMessage());

			}

		}// fim do if

	}// fim do método desconecta

	public void executaSql(String sql) throws SQLException {

		this.statemente = conexao.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		this.resultSet = statemente.executeQuery(sql);
		/**
		 * ResultSet.TYPE_SCROLL_SENSITIVE: Especifica que um cursor de um
		 * ResultSet pode rolar em qualquer direção e que as alterações feitas
		 * no ResultSet durante o processamento de ResultSet são refletidas
		 * imediatamente no ResultSet.
		 * 
		 * ResultSet.CONCUR_READ_ONLY: Especifica que ResultSet não pode ser
		 * atualizado(isto é, alterações no coteúdo do ResultSet não podem ser
		 * refletidas no banco de dados com oss métodos atualizados do
		 * ResultSet).
		 * */
	}// fim do método executaSql

	public static void main(String[] args) {

		// main para testar a conxão com o banco de dado access
		Conexao conecta = new Conexao();
		conecta.conecta();

	}

}
