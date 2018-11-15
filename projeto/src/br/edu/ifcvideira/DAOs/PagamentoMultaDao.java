package br.edu.ifcvideira.DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Propriedade;
import br.edu.ifcvideira.utils.Conexao;

public class PagamentoMultaDao {
	
			public void Pagamento(Propriedade p) throws Exception {
			String sql = "UPDATE propriedade SET multa_propriedade='0' WHERE id_propriedade=?";
			java.sql.PreparedStatement sqlPrep = Conexao.getInstance().prepareStatement(sql);
			
			int contador=1;
			sqlPrep.setInt(contador++, p.getId());
			sqlPrep.execute();

		}
			
			
			public 	List <Object> Buscar() throws SQLException, Exception {
				List<Object> tabela = new ArrayList<Object>();
				try {
					String sql = "SELECT id_propriedade, id_usuario_propriedade, multa_propriedade FROM propriedade WHERE multa_propriedade>0";
					java.sql.Statement state = Conexao.getInstance().createStatement();
					ResultSet rs = state.executeQuery(sql);
					


					while (rs.next()) {
						Object[] linha = {rs.getInt(1), rs.getInt(2), rs.getFloat(3)};
						tabela.add(linha);
					}
					state.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				return tabela;
			}
			
			
}
