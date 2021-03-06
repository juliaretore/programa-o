package br.ifc.edu.ifcvideira.controllers.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.ifcvideira.beans.Usuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MenuView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCadastrarArvores;
	
	PropriedadeView p = new PropriedadeView();
	private JTextField textusuario;
	Usuario u = new Usuario();
	private JButton deslogar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	
			public void run() {
				try {
					MenuView frame = new MenuView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MenuView() {
		setTitle("Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,  500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnUsuraios = new JButton("Cadastrar Usu\u00E1rio");
		btnUsuraios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				if(textusuario.getText().contains("admin")) {
					UsuarioView frame = new UsuarioView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "�rea Restrita");
				}
				
				
			}
		});
		btnUsuraios.setBounds(121, 302, 256, 67);
		contentPane.add(btnUsuraios);
		
		JButton btnCadastrarPropriedade = new JButton("Cadastrar Propriedade");
		btnCadastrarPropriedade.setBounds(121, 190, 256, 67);
		btnCadastrarPropriedade.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

			
			PropriedadeView frame = new PropriedadeView();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
			}
		});
		contentPane.add(btnCadastrarPropriedade);
		
		btnCadastrarArvores = new JButton("Cadastrar \u00C1rvores");
		btnCadastrarArvores.setBounds(121, 408, 256, 67);
		btnCadastrarArvores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				if(textusuario.getText().contains("admin")) {
					ArvoreView frame = new ArvoreView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "�rea Restrita");
				}

				
			}
		});		
		contentPane.add(btnCadastrarArvores);
		
		
		textusuario = new JTextField();
		textusuario.setText(Usuario.getLoginUsuario());
		textusuario.setEditable(false);
		textusuario.setBounds(1045, 28, 116, 30);
		contentPane.add(textusuario);
		textusuario.setColumns(10);
		
		
		textusuario.setBounds(334, 34, 116, 30);
		contentPane.add(textusuario);
		
		deslogar = new JButton("Deslogar");
		deslogar.setBounds(344, 67, 89, 23);
		contentPane.add(deslogar);
		
		JButton multa = new JButton("Pagar Multa");
		multa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textusuario.getText().contains("admin")) {
					PagamentoMultaView frame = new PagamentoMultaView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "�rea Restrita");
				}

				
			}
		});	
				
				
		multa.setBounds(121, 506, 256, 67);
		contentPane.add(multa);
		deslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView frame = new LoginView();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			
			}
		});
		
    
		

	}
}
