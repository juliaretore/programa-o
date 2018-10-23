package br.edu.ifcvideira.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Propriedade;
import br.edu.ifcvideira.utils.Conexao;

public class PropriedadeDao {

	
	public void CadastrarPropriedade(Propriedade p) throws SQLException, Exception{
		try{
			String sql = "INSERT INTO propriedade (id_propriedade, id_usuario_propriedade, endereco_propriedade, metragem_propiedade, zona_propriedade, multa_propriedade) VALUES (?,?,?,?,?,?)";
			java.sql.PreparedStatement sqlPrep = Conexao.getInstance().prepareStatement(sql);
			int contador = 1;
			sqlPrep.setInt(contador++, p.getId());
			sqlPrep.setInt(contador++, p.getIdCodigoUsuario().getIdusuario());
			sqlPrep.setString(contador++, p.getEndereco());
			sqlPrep.setFloat(contador++, p.getMetragem());
			sqlPrep.setString(contador++, p.getZona());
			sqlPrep.setFloat(contador++, p.getMulta());

			sqlPrep.execute();
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	
	
	
	public void AlterarPropriedade(Propriedade p) throws Exception {
		try{
			String sql = "UPDATE propriedade SET id_usuario_propriedade=?, endereco_propriedade=?, metragem_propiedade=?, zona_propriedade=?, multa_propriedade=? WHERE id_propriedade=?";
			PreparedStatement sqlPrep = Conexao.getInstance().prepareStatement(sql);
			int contador = 1;
			sqlPrep.setInt(contador++, p.getIdCodigoUsuario().getIdusuario());
			sqlPrep.setString(contador++, p.getEndereco());
			sqlPrep.setFloat(contador++, p.getMetragem());
			sqlPrep.setString(contador++, p.getZona());
			sqlPrep.setFloat(contador++, p.getMulta());
			sqlPrep.setInt(contador++, p.getId());

			sqlPrep.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	
	
	public void DeletarPropriedade(Propriedade p) throws Exception{
		try{
			String sql = "DELETE FROM propriedade WHERE id_propriedade=? ";
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.getInstance().prepareStatement(sql);
			sqlPrep.setInt(1, p.getId());
			sqlPrep.execute();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	
	public List<Object> BuscarTodos() throws SQLException, Exception{
		List<Object> propriedade = new ArrayList<Object>();
		try {
			String sql = "SELECT * FROM propriedade";
			java.sql.Statement state = Conexao.getInstance().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				Object[] linha = {rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getFloat(6)};
				propriedade.add(linha);
			}
			state.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return propriedade;
	}
	



public int RetornarProximoCodigoPropriedade() throws Exception {
	try{
		String sql ="SELECT COALESCE(MAX(id_propriedade), 0)+1 AS codigo FROM propriedade";
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
