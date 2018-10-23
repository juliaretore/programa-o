package br.ifc.edu.ifcvideira.controllers.views;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
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
import javax.swing.text.MaskFormatter;

import br.edu.ifcvideira.DAOs.ArvoreDao;
import br.edu.ifcvideira.beans.Arvore;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ArvoreView extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textPNome;
	private JTextField textPCodigo;
	private JTable table;

	private List<Object> fornecedor = new ArrayList<Object>();
	
	Arvore a = new Arvore();	
	ArvoreDao ad = new ArvoreDao();
	
	java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
	
	
	public JTextField textCodigo;
	private JTextField textFieldDescricao;
	private JTextField textFieldNecessidades;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArvoreView frame = new ArvoreView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	public ArvoreView() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				atualizarTabela();
				limpar();
				try {
					textCodigo.setText(String.valueOf(ad.RetornarProximoCodigoArvore()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
        


		setTitle("Cadastro Fornecedores");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,  500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(69, 93, 59, 20);
		contentPane.add(label_1);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(138, 96, 276, 20);
		contentPane.add(textNome);
		
		JLabel Celular = new JLabel("Status:");
		Celular.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		Celular.setHorizontalAlignment(SwingConstants.RIGHT);
		Celular.setBounds(29, 155, 99, 20);
		contentPane.add(Celular);
		
					try {
						MaskFormatter mascara = new MaskFormatter("##.###.###/####-##");

					} catch (ParseException e2) {
						JOptionPane.showMessageDialog(null, "b");	
						}
		
		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1){
					try {
						a.setId(Integer.parseInt(textCodigo.getText()));
						a.setNecessidades(textFieldNecessidades.getText());
						a.setNome(textNome.getText());
						a.setDescricao(textFieldDescricao.getText());
						ad.AlterarArvore(a);
		
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					atualizarTabela();
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada");
				}
			}
		});
		alterar.setBackground(SystemColor.controlHighlight);
		alterar.setBounds(322, 237, 118, 21);
		contentPane.add(alterar);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					a.setId(Integer.parseInt(textCodigo.getText()));
					a.setNecessidades(textFieldNecessidades.getText());
					a.setNome(textNome.getText());
					a.setDescricao(textFieldDescricao.getText());
					ad.CadastrarArvore(a);
				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				atualizarTabela();
				limpar();
			}
		});
		cadastrar.setBackground(SystemColor.controlHighlight);
		cadastrar.setBounds(182, 237, 118, 21);
		contentPane.add(cadastrar);
		
		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		limpar.setBackground(SystemColor.controlHighlight);
		limpar.setBounds(31, 237, 118, 21);
		contentPane.add(limpar);
		
		JButton excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1){
					Object[] options3 = {"Excluir", "Cancelar"};
					if(JOptionPane.showOptionDialog(null, "Tem certeza que deseja excluir o registro:\n>   " 
							+ table.getValueAt(table.getSelectedRow(), 0) + "   -   "
							+ table.getValueAt(table.getSelectedRow(), 1), null,
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options3, options3[0]) == 0){
						try {
						
							a.setId(Integer.parseInt(textCodigo.getText()));
							ad.DeletarArvore(a);
							atualizarTabela();
							limpar();
							
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada");
				}
			}
		});
		excluir.setBackground(SystemColor.controlHighlight);
		excluir.setBounds(182, 269, 118, 21);
		contentPane.add(excluir);
		
		JLabel label_5 = new JLabel("Busca:");
		label_5.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(229, 324, 71, 20);
		contentPane.add(label_5);
		
		JLabel lblFornecedoresCadastrados = new JLabel("Fornecedores Cadastrados:");
		lblFornecedoresCadastrados.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblFornecedoresCadastrados.setBounds(22, 427, 203, 20);
		contentPane.add(lblFornecedoresCadastrados);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		sair.setBackground(SystemColor.controlHighlight);
		sair.setBounds(187, 628, 118, 21);
		contentPane.add(sair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 458, 474, 159);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				setCamposFromTabela();
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"iD", "Nome", "Descricao", "Status", "Necessidades"
				
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(69, 62, 59, 20);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		textCodigo.setBounds(138, 65, 59, 20);
		contentPane.add(textCodigo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(24, 324, 448, 2);
		contentPane.add(separator_1);
		
		JLabel label_6 = new JLabel("C\u00F3digo:");
		label_6.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		label_6.setBounds(30, 352, 79, 20);
		contentPane.add(label_6);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textPCodigo = new JTextField();
		textPCodigo.setBounds(119, 355, 349, 20);
		contentPane.add(textPCodigo);
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
		
		textPNome = new JTextField();
		textPNome.setBounds(119, 386, 349, 20);
		contentPane.add(textPNome);
		textPNome.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				
				TableRowSorter<TableModel> filtro = null;  
				DefaultTableModel model = (DefaultTableModel) table.getModel();  
				filtro = new TableRowSorter<TableModel>(model);  
				table.setRowSorter(filtro); 
				
				if (textPNome.getText().length() == 0) {
					filtro.setRowFilter(null);
				} else {  
					filtro.setRowFilter(RowFilter.regexFilter("(?i)" + textPNome.getText(), 1));  
				}  
				
			}
		});
		textPNome.setColumns(10);
		
		JLabel label_7 = new JLabel("Nome:");
		label_7.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		label_7.setBounds(20, 383, 91, 20);
		contentPane.add(label_7);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(24, 414, 448, 2);
		contentPane.add(separator);
		
		JLabel lblCadastrorvore = new JLabel("Cadastro \u00C1rvore");
		lblCadastrorvore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCadastrorvore.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
		lblCadastrorvore.setBounds(100, 11, 249, 40);
		contentPane.add(lblCadastrorvore);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(138, 124, 276, 20);
		contentPane.add(textFieldDescricao);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblDescrio.setBounds(29, 124, 99, 20);
		contentPane.add(lblDescrio);
		
		JLabel lblNecessidades = new JLabel("Necessidades:");
		lblNecessidades.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNecessidades.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNecessidades.setBounds(10, 186, 118, 20);
		contentPane.add(lblNecessidades);
		
		textFieldNecessidades = new JTextField();
		textFieldNecessidades.setColumns(10);
		textFieldNecessidades.setBounds(138, 189, 276, 20);
		contentPane.add(textFieldNecessidades);
		
		JComboBox<String> comboBoxStatus = new JComboBox<String>();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Adequada", "Inadequada"}));
		comboBoxStatus.setBounds(138, 158, 117, 20);
		comboBoxStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a.setStatus((String)comboBoxStatus.getSelectedItem());
				
			}
		});
		contentPane.add(comboBoxStatus);
	}

	public void sair() {
			dispose();
		
	}

	public void setCamposFromTabela() {
		textCodigo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
		textNome.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));	
		textFieldDescricao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)));
		textFieldNecessidades.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 4)));
	}

	public void limpar() {
		textNome.setText(null);
		textFieldNecessidades.setText(null);
		textFieldDescricao.setText(null);

		try {
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}



public void atualizarTabela() {
	try {
		List<Object> arvore = ad.BuscarTodos();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		for (int x = 0; x != arvore.size(); x++) {
			model.addRow((Object[]) arvore.get(x));
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
}

}
