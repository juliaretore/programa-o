package br.ifc.edu.ifcvideira.controllers.views;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.ImageIcon;
import java.awt.Font;

public class PagamentoContaView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPCodigo;
	private JTextField textPNome;
	private JTable table;

	

	
	java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagamentoContaView frame = new PagamentoContaView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	 public PagamentoContaView() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
			

			}
		});
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\WIN\\Desktop\\oi\\oioi\\src\\br\\edu\\ifcvideira\\img\\base.png"));
		
		ImageIcon img = new ImageIcon (lblNewLabel.getIcon().toString());  
		lblNewLabel.setIcon(img);
        img.setImage(img.getImage().getScaledInstance(500, 680, 100));
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

		setTitle("Pagamento Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,  500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_5 = new JLabel("Busca:");
		label_5.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(203, 154, 92, 20);
		contentPane.add(label_5);
		
		JLabel lblContasEmAberto = new JLabel("Contas em Aberto:");
		lblContasEmAberto.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblContasEmAberto.setBounds(23, 284, 156, 20);
		contentPane.add(lblContasEmAberto);
		
		JButton sair = new JButton("Sair");

		sair.setBackground(SystemColor.controlHighlight);
		sair.setBounds(367, 616, 92, 23);
		contentPane.add(sair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 315, 420, 266);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IDvenda", "Situa\u00E7\u00E3o", "Cliente", "Valor"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		
		JLabel lblCdigoDaCompra = new JLabel("Nome Cliente:");
		lblCdigoDaCompra.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblCdigoDaCompra.setBounds(23, 198, 131, 20);
		contentPane.add(lblCdigoDaCompra);
		lblCdigoDaCompra.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textPNome = new JTextField();
		textPNome.setBounds(164, 232, 262, 20);
		contentPane.add(textPNome);
	
		textPNome.setColumns(10);
		
		textPCodigo = new JTextField();
		textPCodigo.setBounds(164, 198, 262, 20);
		contentPane.add(textPCodigo);
		textPCodigo.setColumns(10);
		
		JLabel lblNomeDoCliente = new JLabel("C\u00F3digo Compra:");
		lblNomeDoCliente.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNomeDoCliente.setBounds(23, 229, 131, 20);
		contentPane.add(lblNomeDoCliente);
		lblNomeDoCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(29, 271, 430, 2);
		contentPane.add(separator);
		
		JButton Pagar = new JButton("Pagar");

		Pagar.setBackground(SystemColor.controlHighlight);
		Pagar.setBounds(24, 616, 99, 23);
		contentPane.add(Pagar);
		
		lblNewLabel.setBounds(0, 0, 494, 671);
		contentPane.add(lblNewLabel);

	}

}