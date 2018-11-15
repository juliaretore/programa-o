package br.ifc.edu.ifcvideira.controllers.views;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
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
import br.edu.ifcvideira.DAOs.PagamentoMultaDao;
import br.edu.ifcvideira.beans.Propriedade;
import java.awt.Font;

public class PagamentoMultaView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPPropriedade;
	private JTextField textPUsuario;
	private JTable table;

	
	PagamentoMultaDao pcDao = new PagamentoMultaDao();
	Propriedade p = new Propriedade();
		

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						PagamentoMultaView frame = new PagamentoMultaView();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "slkd");
					}
				}
			});
		}

	 public PagamentoMultaView() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				try {
					atualizarTabela();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			}
		});

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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID propriedade", "Usuario", "Multa"
							}
		));
		
		JLabel lblCdigoDaCompra = new JLabel("Propriedade:");
		lblCdigoDaCompra.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblCdigoDaCompra.setBounds(23, 198, 131, 20);
		contentPane.add(lblCdigoDaCompra);
		lblCdigoDaCompra.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textPUsuario = new JTextField();
		textPUsuario.setBounds(164, 232, 262, 20);
		contentPane.add(textPUsuario);
		textPUsuario.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {			
				TableRowSorter<TableModel> filtro = null;  
				DefaultTableModel model = (DefaultTableModel) table.getModel();  
				filtro = new TableRowSorter<TableModel>(model);  
				table.setRowSorter(filtro);
				
				if (textPUsuario.getText().length() == 0) {
					filtro.setRowFilter(null);
				} else {  
					filtro.setRowFilter(RowFilter.regexFilter(textPUsuario.getText(), 1));  
				}  
			}
		});
		textPUsuario.setColumns(10);
		
		textPPropriedade = new JTextField();
		textPPropriedade.setBounds(164, 198, 262, 20);
		contentPane.add(textPPropriedade);
		textPPropriedade.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				
				TableRowSorter<TableModel> filtro = null;  
				DefaultTableModel model = (DefaultTableModel) table.getModel();  
				filtro = new TableRowSorter<TableModel>(model);  
				table.setRowSorter(filtro); 
				
				if (textPPropriedade.getText().length() == 0) {
					filtro.setRowFilter(null);
				} else {  
					filtro.setRowFilter(RowFilter.regexFilter("(?i)" + textPPropriedade.getText(), 0));  
				}  
				
			}
		});
		textPPropriedade.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblUsuario.setBounds(23, 229, 131, 20);
		contentPane.add(lblUsuario);
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(29, 271, 430, 2);
		contentPane.add(separator);
		
		JButton Pagar = new JButton("Pagar");
		Pagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1){
					
						try {
							p.setId(Integer.parseInt(String.valueOf(table.getValueAt(table.getSelectedRow(), 0))));
							pcDao.Pagamento(p);
							JOptionPane.showMessageDialog(null, "Conta paga com sucesso!");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());

						}
					
				
					try {
						atualizarTabela();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		Pagar.setBackground(SystemColor.controlHighlight);
		Pagar.setBounds(24, 616, 99, 23);
		contentPane.add(Pagar);

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