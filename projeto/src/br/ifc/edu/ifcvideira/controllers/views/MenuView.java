package br.ifc.edu.ifcvideira.controllers.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.ifcvideira.beans.Usuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textusuario;

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
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\WIN\\Desktop\\oi\\oioi\\src\\br\\edu\\ifcvideira\\img\\menu.png"));
			
		ImageIcon img = new ImageIcon (lblNewLabel.getIcon().toString());  
        img.setImage(img.getImage().getScaledInstance(1365, 700, 120));
        lblNewLabel.setIcon(img);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1367, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnUsuraios = new JButton("Usu\u00E1rios");
		btnUsuraios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioView frame = new UsuarioView();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
			}
		});
		btnUsuraios.setBounds(31, 534, 256, 67);
		contentPane.add(btnUsuraios);
		
		
		textusuario = new JTextField();
		textusuario.setText(Usuario.getLoginUsuario());
		textusuario.setEditable(false);
		textusuario.setBounds(1045, 28, 116, 30);
		contentPane.add(textusuario);
		textusuario.setColumns(10);
		
		lblNewLabel.setBounds(-10, 0, 1360, 691);
		contentPane.add(lblNewLabel);
		
    
		

	}
	
	
}
