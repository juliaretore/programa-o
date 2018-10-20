package br.edu.ifcvideira.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {	
 
	
	private final static String driver = "org.postgresql.Driver";
	private final static String usuario = "postgres";
	private final static String senha = "k94z2tt1";
	private final static String host = "localhost";
	private final static String porta = "5432";
	private final static String banco = "pi";
	private final static String url = "jdbc:postgresql://" + host + ":" + porta + "/" + banco;
	public static Connection conexao = null;
	
	public static Connection getInstance() {
		if (conexao == null) {
			conectar();
			return conexao;
		} else {
			return conexao;
		}
	}
	
	private static Connection conectar(){
		 try {
			 Class.forName(driver);
			 conexao = DriverManager.getConnection(url, usuario, senha);
			 
			 System.out.println("Conex�o efetuada com sucesso");
	       
		 } catch (Exception ex) {
			 ex.printStackTrace();
		 }
		return conexao; 
	}

	public void fechar() {
		try {
			conexao.close();
			System.out.println("Conex�o encerrada");
		} 
	        
		catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}