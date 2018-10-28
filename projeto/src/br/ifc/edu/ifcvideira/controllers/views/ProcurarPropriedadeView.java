package br.ifc.edu.ifcvideira.controllers.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

import br.edu.ifcvideira.DAOs.AreaReflorestadaDao;
import br.edu.ifcvideira.DAOs.PropriedadeDao;
import br.edu.ifcvideira.beans.Propriedade;
import javax.swing.ImageIcon;
import java.awt.Font;


public class ProcurarPropriedadeView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel Busca;
	private JTextField textPCodigo;
	private static JTable table;
	private static JTable table_1;
	public static int aberto = 0;


	public static  List<Object> cliente = new ArrayList<Object>();
	
	public static AreaReflorestadaDao ad = new AreaReflorestadaDao();
	public static  PropriedadeDao pDao = new PropriedadeDao();
	
	java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
	private JTextField textPCodigo2;
	private JTextField textPNome2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcurarPropriedadeView frame = new ProcurarPropriedadeView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	public ProcurarPropriedadeView() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				atualizarTabela();
		
			}
		});        
		setTitle("Pesquisa Propriedade");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 10, 500, 700);
		Busca = new JPanel();
		Busca.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Busca);
		Busca.setLayout(null);
		
		JLabel lblPropriedadesCadastrados = new JLabel("Propriedades Cadastradas");
		lblPropriedadesCadastrados.setFont(new Font("Segoe UI Symbol", Font.BOLD, 19));
		lblPropriedadesCadastrados.setBounds(116, 60, 255, 20);
		Busca.add(lblPropriedadesCadastrados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 447, 474, 159);
		Busca.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Propriedade", "Tam. Prop.", "Tam. Reflor.", "Qnt plantas", "Tipo", "Objetivo", "Obs", "Arvore"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(5).setPreferredWidth(110);

		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(39, 49, 423, 2);
		Busca.add(separator_1);
		
		JLabel label_6 = new JLabel("C\u00F3digo:");
		label_6.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		label_6.setBounds(46, 91, 59, 20);
		Busca.add(label_6);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textPCodigo = new JTextField();
		textPCodigo.setBounds(185, 407, 263, 20);
		Busca.add(textPCodigo);
		textPCodigo.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				
				TableRowSorter<TableModel> filtro = null;  
				DefaultTableModel model = (DefaultTableModel) table.getModel();  
				filtro = new TableRowSorter<TableModel>(model);  
				table.setRowSorter(filtro);
				
				if (textPCodigo.getText().length() == 0) {
					filtro.setRowFilter(null);
				} else {  
					filtro.setRowFilter(RowFilter.regexFilter(textPCodigo.getText(), 0));  
				}  
			}
		});
		textPCodigo.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblUsurio.setBounds(39, 122, 67, 20);
		Busca.add(lblUsurio);
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		sair.setBackground(SystemColor.controlHighlight);
		sair.setBounds(194, 640, 112, 20);
		Busca.add(sair);
		
		JLabel lblreasReflorestadasCadastradas = new JLabel("\u00C1reas Reflorestadas Cadastradas");
		lblreasReflorestadasCadastradas.setFont(new Font("Segoe UI Symbol", Font.BOLD, 19));
		lblreasReflorestadasCadastradas.setBounds(101, 349, 327, 20);
		Busca.add(lblreasReflorestadasCadastradas);
		
		JLabel lblBusca = new JLabel("BUSCA:");
		lblBusca.setFont(new Font("Segoe UI Symbol", Font.BOLD, 26));
		lblBusca.setBounds(189, 11, 150, 38);
		Busca.add(lblBusca);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(39, 336, 423, 2);
		Busca.add(separator);
		
		textPCodigo2 = new JTextField();
		textPCodigo2.setColumns(10);
		textPCodigo2.setBounds(116, 91, 307, 20);
		Busca.add(textPCodigo2);
		textPCodigo2.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				
				TableRowSorter<TableModel> filtro = null;  
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();  
				filtro = new TableRowSorter<TableModel>(model);  
				table_1.setRowSorter(filtro);
				
				if (textPCodigo2.getText().length() == 0) {
					filtro.setRowFilter(null);
				} else {  
					filtro.setRowFilter(RowFilter.regexFilter(textPCodigo2.getText(), 0));  
				}  
			}
		});
		
		textPNome2 = new JTextField();
		textPNome2.setColumns(10);
		textPNome2.setBounds(116, 122, 307, 20);
		Busca.add(textPNome2);
		textPNome2.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				
				TableRowSorter<TableModel> filtro = null;  
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();  
				filtro = new TableRowSorter<TableModel>(model);  
				table_1.setRowSorter(filtro);
				
				if (textPNome2.getText().length() == 0) {
					filtro.setRowFilter(null);
				} else {  
					filtro.setRowFilter(RowFilter.regexFilter(textPNome2.getText(), 1));  
				}  
			}
		});
		
		JLabel lblCdigoPropriedade = new JLabel("C\u00F3digo Propriedade:");
		lblCdigoPropriedade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigoPropriedade.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblCdigoPropriedade.setBounds(10, 404, 167, 20);
		Busca.add(lblCdigoPropriedade);
	
		
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 153, 474, 159);
		Busca.add(scrollPane2);
		
		table_1 = new JTable();
		scrollPane2.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Usuario", "Endereco", "Metragem", "Zona", "Multa"
			}
		));
	}

	
	
	
	

	public static void atualizarTabela() {
		try {
			List<Object> propriedade = pDao.BuscarTodos();
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			model.setNumRows(0);
		for (int x=0; x!=propriedade.size(); x++)
			{
				model.addRow((Object[]) propriedade.get(x));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		try {
			List<Object> area = ad.BuscarTodos();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
		for (int x=0; x!=area.size(); x++)
			{
				model.addRow((Object[]) area.get(x));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		
}
}
