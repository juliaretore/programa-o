package br.ifc.edu.ifcvideira.controllers.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.ifcvideira.DAOs.PagamentoMultaDao;
import br.edu.ifcvideira.beans.Propriedade;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MultaView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPCodigo;
	private JTextField textPNome;
	private JTable table;

	
	
	PagamentoMultaDao pcDao = new PagamentoMultaDao();
	Propriedade p = new Propriedade();
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultaView frame = new MultaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MultaView() {
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
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});

		sair.setBackground(SystemColor.controlHighlight);
		sair.setBounds(367, 616, 92, 23);
		contentPane.add(sair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 315, 420, 266);
		contentPane.add(scrollPane);
		
		
		
	}

	
	public void sair() {
		dispose();
		
	}

	public void atualizarTabela() throws SQLException, Exception {
		List<Object> tabela = new ArrayList<Object>();
		try {
			tabela = pcDao.Buscar();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			model.setNumRows(0);
	
			for (int x = 0; x != tabela.size(); x++) {
				model.addRow((Object[]) tabela.get(x));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}
}
