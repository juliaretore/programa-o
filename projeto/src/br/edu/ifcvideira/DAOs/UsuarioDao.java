package br.edu.ifcvideira.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import br.edu.ifcvideira.beans.Usuario;
import br.edu.ifcvideira.utils.Conexao;

public class UsuarioDao {

	public void CadastrarUsuario(Usuario u) throws SQLException, Exception{
		try{
			String sql = "INSERT INTO usuario (id_usuario, nome_usuario, cpf_usuario, rg_usuario, telefone_usuario, celular_usuario, login_usuario, senha_usuario, data_cadastro_usuario) VALUES (?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement sqlPrep = Conexao.getInstance().prepareStatement(sql);
			int contador = 1;
			sqlPrep.setInt(contador++, u.getId());
			sqlPrep.setString(contador++, u.getNome());
			sqlPrep.setString(contador++, u.getCpf());
			sqlPrep.setString(contador++, u.getrgUsuario());
			sqlPrep.setString(contador++, u.getTelefone());
			sqlPrep.setString(contador++, u.getCelular());
			sqlPrep.setString(contador++, u.getloginUsuario());
			sqlPrep.setString(contador++, u.getsenhaUsuario());
			sqlPrep.setTimestamp(contador++, u.getDataCadastro());
			sqlPrep.execute();
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	
	
	public void AlterarUsuario(Usuario u) throws Exception {
		try{
			String sql = "UPDATE usuario SET nome_usuario=?, cpf_usuario=?, rg_usuario=?, telefone_usuario=?, celular_usuario=?, login_usuario=?, senha_usuario=?, data_cadastro_usuario=? WHERE id_usuario=?";
			PreparedStatement sqlPrep = Conexao.getInstance().prepareStatement(sql);
			int contador = 1;
			
			sqlPrep.setString(contador++, u.getNome());
			sqlPrep.setString(contador++, u.getCpf());
			sqlPrep.setString(contador++, u.getrgUsuario());
			sqlPrep.setString(contador++, u.getTelefone());
			sqlPrep.setString(contador++, u.getCelular());
			sqlPrep.setString(contador++, u.getloginUsuario());
			sqlPrep.setString(contador++, u.getsenhaUsuario());
			sqlPrep.setTimestamp(contador++, u.getDataCadastro());
			sqlPrep.setInt(contador++, u.getId());
			sqlPrep.execute();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	
	
	public void DeletarUsuario(Usuario u) throws Exception{
		try{
			String sql = "DELETE FROM usuario WHERE id_usuario=? ";
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.getInstance().prepareStatement(sql);
			sqlPrep.setInt(1, u.getId());
			sqlPrep.execute();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	
	
	public List<Object> BuscarTodos() throws SQLException, Exception{
		List<Object> usuario = new ArrayList<Object>();
		try {
			String sql = "SELECT id_usuario, nome_usuario, cpf_usuario, rg_usuario, telefone_usuario, celular_usuario, login_usuario, senha_usuario, TO_CHAR(data_cadastro_usuario, 'DD/MM/YYYY') FROM usuario";
			java.sql.Statement state = Conexao.getInstance().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				Object[] linha = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
				usuario.add(linha);
			}
			state.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return usuario;
	}
	
	
	public int RetornarProximoCodigoUsuario() throws Exception {
		try{
			String sql ="SELECT COALESCE(MAX(id_usuario), 0)+1 AS codigo FROM usuario";
			PreparedStatement sqlPrep = Conexao.getInstance().prepareStatement(sql);
			ResultSet rs = sqlPrep.executeQuery();
			if (rs.next()){
				return rs.getInt("codigo");
			}else{
				return 1;
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return 1;
		}
	}
	
	
	
	
	
	
}
