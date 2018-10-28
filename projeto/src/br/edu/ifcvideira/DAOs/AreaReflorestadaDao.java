package br.edu.ifcvideira.DAOs;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.edu.ifcvideira.beans.AreaReflorestada;
import br.edu.ifcvideira.utils.Conexao;

public class AreaReflorestadaDao {
	public void CadastrarArea(AreaReflorestada a) throws SQLException, Exception {
		try {
			String sql = "INSERT INTO areareflorestada (propriedade_area, tamanho_propriedade_area, tamanho_refloresta_area, quantidade_plantas_area, tipo_area, objetivo_area, observacao_area, arvore_plantada_area ) VALUES (?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement sqlPrep = Conexao.getInstance().prepareStatement(sql);
			int contador = 1;

			sqlPrep.setInt(contador++, a.getPropriedade().getId());
			sqlPrep.setFloat(contador++, a.getTamanhoP());
			sqlPrep.setFloat(contador++, a.getTamanhoR());
			sqlPrep.setInt(contador++, a.getQuantidade());
			sqlPrep.setString(contador++, a.getTipo());
			sqlPrep.setString(contador++, a.getObjetivo());
			sqlPrep.setString(contador++, a.getObservacao());
			sqlPrep.setInt(contador++, a.getArvore().getId());


			sqlPrep.execute();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public List<Object> BuscarTodosArvore() throws SQLException, Exception{
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
		
	
	public List<Object> BuscarTodos() throws SQLException, Exception{
		List<Object> area = new ArrayList<Object>();
		try {
			String sql = "SELECT * FROM areareflorestada";
			java.sql.Statement state = Conexao.getInstance().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				Object[] linha = {rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)};
				area.add(linha);
				
				
				
			}
			state.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return area;
	}
		
}
