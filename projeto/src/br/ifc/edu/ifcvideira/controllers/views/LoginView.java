 package br.ifc.edu.ifcvideira.controllers.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.ifcvideira.DAOs.LoginDao;
import br.edu.ifcvideira.beans.Usuario;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class LoginView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tflogin;
		
	LoginDao ld = new LoginDao ();
	Usuario u = new Usuario();

	private JPasswordField tfsenha;
	private JButton btnSair;
	private JLabel lblNewLabel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\WIN\\Desktop\\oi\\oioi\\src\\br\\edu\\ifcvideira\\img\\login.png"));

		ImageIcon img = new ImageIcon (lblNewLabel.getIcon().toString());  
		lblNewLabel.setIcon(img);
        img.setImage(img.getImage().getScaledInstance(445, 250, 100));
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		tflogin = new JTextField();
		tflogin.setBounds(100, 40, 101, 23);
		contentPane.add(tflogin);
		tflogin.setColumns(10);
		
		JButton btlogin = new JButton("logar");
		btlogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
						
							
								try {
									if(ld.ValidarUsuario().contains(tflogin.getText())) {

		 								if(ld.ValidarSenha(tflogin.getText()).contains(tfsenha.getText())) {
		 							Usuario.setLoginUsuario(tflogin.getText());
		 							ld.RetornarIdUsuario(tflogin.getText());
		 							
		 							JOptionPane meuJOPane = new JOptionPane("Bem vindo " +Usuario.getLoginUsuario()+ "!");
		 		
		 							final JDialog dialog = meuJOPane.createDialog( "Carregando...");
							        dialog.setModal(true);
							        Timer timer = new Timer(600, new ActionListener() {  
							            public void actionPerformed(ActionEvent ev) {  
							                dialog.dispose();  
							            }  
							        });  
							        timer.start();
							        dialog.setVisible(true);
							        timer.stop();
									MenuView frame = new MenuView();
									frame.setVisible(true);
								dispose ();
										}else {
											JOptionPane.showMessageDialog(null, "Login incorreto");
										}
									}else {
										JOptionPane.showMessageDialog(null, "Login incorreto");
									}
								} catch (SQLException e) {					
								JOptionPane.showMessageDialog(null, "Login incorreto");
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e.getMessage());
								}
							
			}			
		
		});
		btlogin.setBounds(148, 131, 89, 23);
		contentPane.add(btlogin);
		
		JButton btnReset = new JButton("limpar");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tflogin.setText(null);
				tfsenha.setText(null);

				
			}
		});
		btnReset.setBounds(39, 131, 89, 23);
		contentPane.add(btnReset);
		
		tfsenha = new JPasswordField();
		tfsenha.setBounds(100, 83, 101, 23);
		contentPane.add(tfsenha);
		
		btnSair = new JButton("sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
		
			}
		});
		btnSair.setBounds(97, 165, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblLogin.setBounds(26, 38, 80, 23);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblSenha.setBounds(26, 84, 77, 17);
		contentPane.add(lblSenha);
		

		lblNewLabel.setBounds(-11, 0, 456, 217);
		contentPane.add(lblNewLabel);
	}

	
}
