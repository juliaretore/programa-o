package br.ifc.edu.ifcvideira.controllers.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.ifcvideira.beans.Usuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textusuario;
	private JButton btnCadastrarArvores;
	
	PropriedadeView p = new PropriedadeView();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MenuView frame = new MenuView();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MenuView() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1367, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnUsuraios = new JButton("Cadastrar Usu\u00E1rio");
		btnUsuraios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioView frame = new UsuarioView();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
			}
		});
		btnUsuraios.setBounds(409, 330, 256, 67);
		contentPane.add(btnUsuraios);
		
	
		textusuario = new JTextField();
		textusuario.setText(Usuario.getLoginUsuario());
		textusuario.setEditable(false);
		textusuario.setBounds(1045, 28, 116, 30);
		contentPane.add(textusuario);
		textusuario.setColumns(10);
		
		JButton btnCadastrarPropriedade = new JButton("Cadastrar Propriedade");
		btnCadastrarPropriedade.setBounds(409, 420, 256, 67);
		btnCadastrarPropriedade.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

			
			PropriedadeView frame = new PropriedadeView();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
			}
		});
		contentPane.add(btnCadastrarPropriedade);
		
		btnCadastrarArvores = new JButton("Cadastrar \u00C1rvores");
		btnCadastrarArvores.setBounds(409, 508, 256, 67);
		btnCadastrarArvores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArvoreView frame = new ArvoreView();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
			}
		});		
		contentPane.add(btnCadastrarArvores);
		
    
		

	}
}
