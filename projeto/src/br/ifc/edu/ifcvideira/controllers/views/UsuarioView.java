package br.ifc.edu.ifcvideira.controllers.views;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import br.edu.ifcvideira.DAOs.UsuarioDao;
import br.edu.ifcvideira.beans.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class UsuarioView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfCelular;
	private JTextField tfTelefone; 
	private JTextField textPNome;
	private JTextField textPCodigo;
	private JTable table;

	private List<Object> usuario = new ArrayList<Object>();
	
	Usuario u = new Usuario();
	UsuarioDao uDao = new UsuarioDao();
	
	java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
	
	
	private JTextField tfCodigo;
	private JTextField tfrg;
	private JTextField tflogin;
	private JTextField tfsenha;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioView frame = new UsuarioView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	public UsuarioView() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				atualizarTabela();
				limpar();
			}
		});
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\WIN\\Desktop\\oi\\oioi\\src\\br\\edu\\ifcvideira\\img\\base.png"));
		
		ImageIcon img = new ImageIcon (lblNewLabel.getIcon().toString());  
		lblNewLabel.setIcon(img);
        img.setImage(img.getImage().getScaledInstance(500, 680, 100));
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

		setTitle("Cadastro Usuario");
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
		label_1.setBounds(33, 119, 59, 20);
		contentPane.add(label_1);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(106, 122, 288, 20);
		contentPane.add(tfNome);
		
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			tfCpf = new JFormattedTextField(mascara);

		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "b");	
			}
		tfCpf.setColumns(10);
		tfCpf.setBounds(106, 246, 147, 20);
		contentPane.add(tfCpf);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(16, 243, 59, 20);
		contentPane.add(label_2);
		
		JLabel Celular = new JLabel("Celular:");
		Celular.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		Celular.setHorizontalAlignment(SwingConstants.RIGHT);
		Celular.setBounds(33, 185, 59, 20);
		contentPane.add(Celular);
		
		try {
			MaskFormatter mascara = new MaskFormatter("(##)#####-####");
			tfCelular = new JFormattedTextField(mascara);

		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "b");	
			}
		tfCelular.setColumns(10);
		tfCelular.setBounds(106, 184, 147, 20);
		contentPane.add(tfCelular);
		
		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1){
					try {
						u.setNome(tfNome.getText());
						u.setrgUsuario(tfrg.getText());
						u.setCpf(tfCpf.getText());
						u.setTelefone(tfTelefone.getText());
						u.setCelular(tfCelular.getText());
						u.setloginUsuario(tflogin.getText());
						u.setsenhaUsuario(tfsenha.getText());
						u.setDataCadastro(time);
						u.setId(Integer.parseInt(tfCodigo.getText()));						
						
						uDao.AlterarUsuario(u);
						
		
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
		alterar.setBounds(276, 215, 118, 21);
		contentPane.add(alterar);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					u.setNome(tfNome.getText());
					u.setrgUsuario(tfrg.getText());
					u.setCpf(tfCpf.getText());
					u.setTelefone(tfTelefone.getText());
					u.setCelular(tfCelular.getText());
					u.setloginUsuario(tflogin.getText());
					u.setsenhaUsuario(tfsenha.getText());
					u.setDataCadastro(time);
					u.setId(Integer.parseInt(tfCodigo.getText()));
					
					
					uDao.CadastrarUsuario(u);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				atualizarTabela();
				limpar();
			}
		});
		cadastrar.setBackground(SystemColor.controlHighlight);
		cadastrar.setBounds(276, 184, 118, 21);
		contentPane.add(cadastrar);
		
		JLabel label_4 = new JLabel("Telefone:");
		label_4.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(12, 216, 80, 20);
		contentPane.add(label_4);
		
		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		limpar.setBackground(SystemColor.controlHighlight);
		limpar.setBounds(276, 152, 118, 21);
		contentPane.add(limpar);
		
		try {
			MaskFormatter mascara = new MaskFormatter("####-####");
			tfTelefone = new JFormattedTextField(mascara);

		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "b");	
			}
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(106, 215, 147, 20);
		contentPane.add(tfTelefone);
		
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
							u.setId(Integer.parseInt(tfCodigo.getText()));

							uDao.DeletarUsuario(u);
							
						
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
		excluir.setBounds(276, 246, 118, 21);
		contentPane.add(excluir);
		
		JLabel label_5 = new JLabel("Busca:");
		label_5.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(196, 370, 90, 20);
		contentPane.add(label_5);
		
		JLabel lblUsuriosCadastrados = new JLabel("Usu\u00E1rios Cadastrados:");
		lblUsuriosCadastrados.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblUsuriosCadastrados.setBounds(33, 453, 232, 20);
		contentPane.add(lblUsuriosCadastrados);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		sair.setBackground(SystemColor.controlHighlight);
		sair.setBounds(161, 632, 173, 20);
		contentPane.add(sair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 482, 434, 139);
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
				"Nome", "C\u00F3digo", "Celular", "Telefone", "CPF", "RG", "Login", "Senha", "Data"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(51);
		table.getColumnModel().getColumn(3).setPreferredWidth(59);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(33, 154, 59, 20);
		contentPane.add(lblCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(106, 153, 46, 20);
		contentPane.add(tfCodigo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(33, 370, 434, 2);
		contentPane.add(separator_1);
		
		JLabel label_6 = new JLabel("C\u00F3digo:");
		label_6.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		label_6.setBounds(22, 388, 70, 20);
		contentPane.add(label_6);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textPCodigo = new JTextField();
		textPCodigo.setBounds(112, 391, 315, 20);
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
		textPNome.setBounds(112, 419, 315, 20);
		contentPane.add(textPNome);
		textPNome.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				
				//atualizar a tabela apenas com valores correspondentes aos digitados no campo de busca por nome
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
		label_7.setBounds(22, 419, 70, 20);
		contentPane.add(label_7);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(22, 453, 445, 2);
		contentPane.add(separator);
		
		JLabel edrfsd = new JLabel("RG:");
		edrfsd.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		edrfsd.setBounds(47, 277, 59, 20);
		contentPane.add(edrfsd);
		
		try {
			MaskFormatter mascara = new MaskFormatter("#.###.###");
			tfrg = new JFormattedTextField(mascara);

		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "b");	
			}
		tfrg.setColumns(10);
		tfrg.setBounds(106, 277, 147, 20);
		contentPane.add(tfrg);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblLogin.setBounds(33, 308, 59, 20);
		contentPane.add(lblLogin);
		
		tflogin = new JTextField();
		tflogin.setColumns(10);
		tflogin.setBounds(106, 308, 147, 20);
		contentPane.add(tflogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblSenha.setBounds(33, 339, 73, 23);
		contentPane.add(lblSenha);
		
		tfsenha = new JTextField();
		tfsenha.setColumns(10);
		tfsenha.setBounds(106, 339, 147, 20);
		contentPane.add(tfsenha);
		
		
		lblNewLabel.setBounds(0, 0, 494, 671);
		contentPane.add(lblNewLabel);
	}

	public void sair() {
		dispose();
		
	}

	public void setCamposFromTabela() {
		tfCodigo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
		tfNome.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
		tfCpf.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)));
		tfrg.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 3)));
		tfTelefone.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 4)));
		tfCelular.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 5)));
		tflogin.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 6)));		
		tfsenha.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 7)));
	
	}

	public void limpar() {
		tfCpf.setText(null);
		tfNome.setText(null);
		tfCelular.setText(null);
		tfTelefone.setText(null);
		tflogin.setText(null);
		tfsenha.setText(null);
		tfrg.setText(null);
		
		try {
			tfCodigo.setText(String.valueOf(uDao.RetornarProximoCodigoUsuario()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void atualizarTabela() {
		try {
			usuario = uDao.BuscarTodos();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
		for (int x=0; x!=usuario.size(); x++)
			{
				model.addRow((Object[]) usuario.get(x));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
