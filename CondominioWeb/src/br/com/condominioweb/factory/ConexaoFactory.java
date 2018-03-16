package br.com.condominioweb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "Nelinho10!";
	private static final String URL = "jdbc:mysql://localhost:3306/condominio";
	
	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conex�o Realizada com Sucesso");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Deu erro");
		}
	}
}
