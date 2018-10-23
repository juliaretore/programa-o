package br.edu.ifcvideira.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import br.edu.ifcvideira.beans.Arvore;
import br.edu.ifcvideira.utils.Conexao;

public class ArvoreDao {

	public void CadastrarArvore(Arvore a) throws SQLException, Exception{
		try{
			String sql = "INSERT INTO arvore (id_arvore, nome_arvore, descricao_arvore, status_arvore, necessidades_arvore) VALUES (?,?,?,?,?)";
			
			java.sql.PreparedStatement sqlPrep = Conexao.getInstance().prepareStatement(sql);
			int contador = 1;
			
			sqlPrep.setInt(contador++, a.getId());
			sqlPrep.setString(contador++, a.getNome());
			sqlPrep.setString(contador++, a.getDescricao());
			sqlPrep.setString(contador++, a.getStatus());
			sqlPrep.setString(contador++, a.getNecessidades());
			sqlPrep.execute();
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	
	
	public void AlterarArvore(Arvore a) throws Exception {
		try{
			String sql = "UPDATE arvore SET nome_arvore=?, descricao_arvore=?, status_arvore=?, necessidades_arvore=? WHERE id_arvore=?";
			PreparedStatement sqlPrep = Conexao.getInstance().prepareStatement(sql);
			int contador = 1;
			
			sqlPrep.setString(contador++, a.getNome());
			sqlPrep.setString(contador++, a.getDescricao());
			sqlPrep.setString(contador++, a.getStatus());
			sqlPrep.setString(contador++, a.getNecessidades());
			sqlPrep.setInt(contador++, a.getId());
			sqlPrep.execute();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	
	
	public void DeletarArvore(Arvore a) throws Exception{
		try{
			String sql = "DELETE FROM arvore WHERE id_arvore=? ";
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.getInstance().prepareStatement(sql);
			sqlPrep.setInt(1, a.getId());
			sqlPrep.execute();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	
	
	public List<Object> BuscarTodos() throws SQLException, Exception{
		List<Object> arvore = new ArrayList<Object>();
		try {
			String sql = "SELECT id_arvore, nome_arvore, descricao_arvore, status_arvore, necessidades_arvore FROM arvore";
			java.sql.Statement state = Conexao.getInstance().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				Object[] linha = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
				arvore.add(linha);
			}
			state.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return arvore;
	}
	
	
	public int RetornarProximoCodigoArvore() throws Exception {
		try{
			String sql ="SELECT COALESCE(MAX(id_arvore), 0)+1 AS codigo FROM arvore";
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
