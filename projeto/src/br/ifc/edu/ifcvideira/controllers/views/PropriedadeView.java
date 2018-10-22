package br.ifc.edu.ifcvideira.controllers.views;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PropriedadeView extends JFrame {

	private JPanel contentPane;
    public static JTextField textFieldIdUsuario;
	private static final long serialVersionUID = 1L;
	private JTextField textPCodigo;
	
    List<Object> aquisicao = new ArrayList<Object>();
 
	
	java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
	private JTextField textCodigo;
	public static JTextField textFieldNomeUsuario;
	private JTextField textFieldEndereco;
	private JTable table;
	private JTable table_1;
	private List<Object> produto = new ArrayList<Object>();
	double valortotal =0;
	private JTextField textFieldMetragem;
	private JTextField textFieldCodigoPropriedade;
	private JTextField textFieldTamanhoP;
	private JTextField textFieldTamanhoR;
	private JTextField textFieldQntPlantas;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropriedadeView frame = new PropriedadeView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PropriedadeView() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {

			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				atualizarTabela();
				limpar();
			}
			
		});

		setTitle("Vendas:");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 10, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblFornecedor = new JLabel("Usu\u00E1rio:");
		lblFornecedor.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblFornecedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFornecedor.setBounds(16, 40, 94, 20);
		contentPane.add(lblFornecedor);

		JLabel lblTipo = new JLabel("Zona:");
		lblTipo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(19, 164, 91, 20);
		contentPane.add(lblTipo);

		JLabel lblInserirProdutos = new JLabel("\u00C1rea Reflorestada");
		lblInserirProdutos.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
		lblInserirProdutos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInserirProdutos.setBounds(111, 223, 249, 40);
		contentPane.add(lblInserirProdutos);

		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		sair.setBackground(SystemColor.controlHighlight);
		sair.setBounds(195, 640, 117, 20);
		contentPane.add(sair);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(47, 71, 59, 20);
		contentPane.add(lblCodigo);

		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		textCodigo.setBounds(116, 74, 36, 20);
		contentPane.add(textCodigo);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(20, 223, 464, 2);
		contentPane.add(separator_1);

		JLabel lblPropriedade_1 = new JLabel("Propriedade:");
		lblPropriedade_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblPropriedade_1.setBounds(10, 261, 116, 20);
		contentPane.add(lblPropriedade_1);
		lblPropriedade_1.setHorizontalAlignment(SwingConstants.RIGHT);

		textPCodigo = new JTextField();
		textPCodigo.setBounds(121, 328, 139, 20);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 410, 218, 157);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Valor Unit\u00E1rio"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(41);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
			
			textFieldIdUsuario = new JTextField();
			textFieldIdUsuario.setEditable(false);
			textFieldIdUsuario.setBounds(120, 43, 25, 20);
			contentPane.add(textFieldIdUsuario);
			textFieldIdUsuario.setColumns(10);
			
			JLabel lblDescrio = new JLabel("Endere\u00E7o:");
			lblDescrio.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			lblDescrio.setBounds(31, 102, 79, 14);
			contentPane.add(lblDescrio);
			
			JComboBox<String> comboBoxTipo = new JComboBox<String>();
			comboBoxTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (comboBoxTipo.getSelectedItem().equals("Ą vista")){
						textFieldEndereco.setText("Pago");
						textFieldIdUsuario.setText("0");
						textFieldNomeUsuario.setText("Compra ą vista");
						
					}else{
						textFieldEndereco.setText("Em aberto");
						textFieldIdUsuario.setText("");
						textFieldNomeUsuario.setText("");
					}
					
				}
			});
			comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Rural", "Urbana"}));
			comboBoxTipo.setBounds(120, 167, 183, 20);
			contentPane.add(comboBoxTipo);
			
			JButton buttonIncluirĮrvores = new JButton("Inlcuir \u00C1rvores");
			buttonIncluirĮrvores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {					
					if (table.getSelectedRow() != -1){ 
								List<Object> produtosv = new ArrayList<Object>();

								Object[]linha = { table.getValueAt(table.getSelectedRow(), 0), table.getValueAt(table.getSelectedRow(), 1),  table.getValueAt(table.getSelectedRow(), 2)};
								produtosv.add(linha);
								valortotal+=(Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2)));
		
								DefaultTableModel model = (DefaultTableModel) table_1.getModel();
								for (int x=0; x!=produtosv.size(); x++){
									model.addRow((Object[]) produtosv.get(x));
								}
							} 
				
				}
			});
			buttonIncluirĮrvores.setBackground(SystemColor.controlHighlight);
			buttonIncluirĮrvores.setBounds(20, 593, 128, 21);
			contentPane.add(buttonIncluirĮrvores);
			
			textFieldNomeUsuario = new JTextField();
			textFieldNomeUsuario.setEditable(false);
			textFieldNomeUsuario.setText("");

			textFieldNomeUsuario.setColumns(10);
			textFieldNomeUsuario.setBounds(152, 43, 108, 20);
			contentPane.add(textFieldNomeUsuario);
			
			textFieldEndereco = new JTextField();
			textFieldEndereco.setText("");
			textFieldEndereco.setBounds(116, 105, 183, 20);
			contentPane.add(textFieldEndereco);
			textFieldEndereco.setColumns(10);
			table.getColumnModel().getColumn(0).setPreferredWidth(41);
			table.getColumnModel().getColumn(1).setPreferredWidth(95);
			table.getColumnModel().getColumn(2).setPreferredWidth(60);
					
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(259, 410, 225, 157);
			contentPane.add(scrollPane_1);
			
			table_1 = new JTable();
			table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"C\u00F3digo", "Nome", "Valor Unit\u00E1rio"
				}
			));
			scrollPane_1.setViewportView(table_1);
			
			JButton button = new JButton("Cadastrar");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					// cadastrar venda
																		
					try {
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
	
				}
			});
			button.setBounds(265, 592, 99, 23);
			contentPane.add(button);
			
			JButton button_1 = new JButton("Remover");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (table_1.getSelectedRow() != -1){
						((DefaultTableModel) table_1.getModel()).removeRow(table_1.getSelectedRow()); 
	
				}}
			});
			button_1.setBounds(395, 592, 89, 23);
			contentPane.add(button_1);
			
			textFieldMetragem = new JTextField();
			textFieldMetragem.setText("");
			textFieldMetragem.setColumns(10);
			textFieldMetragem.setBounds(116, 136, 183, 20);
			contentPane.add(textFieldMetragem);
			
			JLabel lblMetragem = new JLabel("Metragem:");
			lblMetragem.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMetragem.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			lblMetragem.setBounds(19, 133, 91, 20);
			contentPane.add(lblMetragem);
			
			JLabel lblPropriedade = new JLabel("Propriedade");
			lblPropriedade.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPropriedade.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
			lblPropriedade.setBounds(113, 0, 199, 40);
			contentPane.add(lblPropriedade);
			
			textFieldCodigoPropriedade = new JTextField();
			textFieldCodigoPropriedade.setEditable(false);
			textFieldCodigoPropriedade.setColumns(10);
			textFieldCodigoPropriedade.setBounds(132, 264, 36, 20);
			contentPane.add(textFieldCodigoPropriedade);
			
			JLabel lblTamanhoPropriedade = new JLabel("Tamanho Propriedade:");
			lblTamanhoPropriedade.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTamanhoPropriedade.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			lblTamanhoPropriedade.setBounds(16, 199, 171, 20);
			contentPane.add(lblTamanhoPropriedade);
			
			JLabel lblTamanhoReflorestamento = new JLabel("Tamanho Reflorestamento:");
			lblTamanhoReflorestamento.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTamanhoReflorestamento.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			lblTamanhoReflorestamento.setBounds(178, 264, 222, 20);
			contentPane.add(lblTamanhoReflorestamento);
			
			textFieldTamanhoP = new JTextField();
			textFieldTamanhoP.setText("");
			textFieldTamanhoP.setEditable(false);
			textFieldTamanhoP.setColumns(10);
			textFieldTamanhoP.setBounds(196, 199, 79, 20);
			contentPane.add(textFieldTamanhoP);
			
			textFieldTamanhoR = new JTextField();
			textFieldTamanhoR.setText("");
			textFieldTamanhoR.setColumns(10);
			textFieldTamanhoR.setBounds(404, 264, 79, 20);
			contentPane.add(textFieldTamanhoR);
			
			JLabel lblQntPlantas = new JLabel("Qnt plantas:");
			lblQntPlantas.setHorizontalAlignment(SwingConstants.RIGHT);
			lblQntPlantas.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			lblQntPlantas.setBounds(10, 297, 116, 20);
			contentPane.add(lblQntPlantas);
			
			textFieldQntPlantas = new JTextField();
			textFieldQntPlantas.setText("");
			textFieldQntPlantas.setColumns(10);
			textFieldQntPlantas.setBounds(132, 300, 79, 20);
			contentPane.add(textFieldQntPlantas);
			
			JComboBox<String> comboBoxTipoR = new JComboBox<String>();
			comboBoxTipoR.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Florestamento", "Reflorestamento"}));
			comboBoxTipoR.setBounds(367, 295, 117, 20);
			contentPane.add(comboBoxTipoR);
			
			JLabel lblTipo_1 = new JLabel("Tipo:");
			lblTipo_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTipo_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			lblTipo_1.setBounds(142, 295, 222, 20);
			contentPane.add(lblTipo_1);
			
			JComboBox<String> comboBoxObjetivo = new JComboBox<String>();
			comboBoxObjetivo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Fins comerciais", "Fins ecol\u00F3gicos"}));
			comboBoxObjetivo.setBounds(367, 331, 117, 20);
			contentPane.add(comboBoxObjetivo);
			
			JLabel lblObjetivo = new JLabel("Objetivo:");
			lblObjetivo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblObjetivo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			lblObjetivo.setBounds(138, 328, 222, 20);
			contentPane.add(lblObjetivo);
			
			JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
			lblObservaes.setHorizontalAlignment(SwingConstants.RIGHT);
			lblObservaes.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			lblObservaes.setBounds(-6, 325, 116, 20);
			contentPane.add(lblObservaes);
			
			JLabel lblrvoresPlantadas = new JLabel("\u00C1rvores Plantadas:");
			lblrvoresPlantadas.setHorizontalAlignment(SwingConstants.RIGHT);
			lblrvoresPlantadas.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
			lblrvoresPlantadas.setBounds(92, 369, 249, 40);
			contentPane.add(lblrvoresPlantadas);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.LIGHT_GRAY);
			separator.setBounds(10, 362, 464, 2);
			contentPane.add(separator);
		
		
	}

public void sair() {

	dispose();

}

public void limpar() {
	((DefaultTableModel) table_1.getModel()).setNumRows(0); 
	table_1.updateUI();
	textFieldNomeUsuario.setText(null);
	textFieldIdUsuario.setText(null);
	textFieldEndereco.setText(null);
	try {
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
}

public void atualizarTabela() {
	try {
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	model.setNumRows(0);
for (int x=0; x!=produto.size(); x++)
	{
		model.addRow((Object[]) produto.get(x));
	}
} catch (Exception e) {
	JOptionPane.showMessageDialog(null, e.getMessage());
}}
}


		
		
		
		
		
		


		