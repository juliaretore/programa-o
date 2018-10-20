
package br.edu.ifcvideira.DAOs;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Usuario;
import br.edu.ifcvideira.utils.Conexao;


public class LoginDao {

	
	public List<String> ValidarUsuario() throws SQLException{
		List<String> login = new ArrayList<String>();
		try {
			String sql = "SELECT login_usuario FROM usuarios";
			java.sql.Statement state = Conexao.getInstance().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next()){
				login.add(rs.getString(1));
			}
			state.close();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro no sistema");
		}
		return login;
	}
	
	
	public List<String> ValidarSenha(String usuario) throws SQLException{
		List<String> senha = new ArrayList<String>();
		try {
			String sql = "SELECT  senha_usuario FROM usuarios WHERE login_usuario='"+usuario+"'";
			java.sql.Statement state = Conexao.getInstance().createStatement();
			ResultSet rs = state.executeQuery(sql);		
			while (rs.next()){
				senha.add(rs.getString(1));
				
			}
			state.close();	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro");
		}
		return senha;
	}
	
	public void RetornarIdUsuario(String login) throws SQLException, Exception {
		try {
		String sql = "SELECT id_usuario FROM usuarios WHERE login_usuario='"+login+"'";
		java.sql.Statement state = Conexao.getInstance().createStatement();
		ResultSet rs = state.executeQuery(sql);
		while (rs.next()) {
			Usuario.setIdusuario(rs.getInt(1));
			
		}
		state.close();
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}


}
	
	
	
	
	
	
	
	



	

}
