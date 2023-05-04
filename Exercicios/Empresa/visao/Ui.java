package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import exceptions.EmpregadoNaoTemSubordinadoException;
import negocio.Chefe;
import negocio.Empregado;
import negocio.Pessoa;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class Ui {

	private JFrame frmEmpregaOGestor;
	private JTextField textNomeFuncionario;
	private Chefe antonio = new Chefe ("Antonio");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui window = new Ui();
					window.frmEmpregaOGestor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmpregaOGestor = new JFrame();
		frmEmpregaOGestor.setTitle("O Gestor");
		frmEmpregaOGestor.setBounds(100, 100, 787, 489);
		frmEmpregaOGestor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmEmpregaOGestor.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel CadastramentoFuncionario = new JPanel();
		tabbedPane.addTab("Cadastramento Funcionário", null, CadastramentoFuncionario, null);
		CadastramentoFuncionario.setLayout(null);
		
		JLabel lbNomeFuncionario = new JLabel("Nome Funcion\u00E1rio:");
		lbNomeFuncionario.setBounds(37, 42, 183, 14);
		CadastramentoFuncionario.add(lbNomeFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(277, 40, 196, 23);
		CadastramentoFuncionario.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JLabel lbChefe = new JLabel("Chefe:");
		lbChefe.setBounds(37, 92, 105, 14);
		CadastramentoFuncionario.add(lbChefe);
		
		JComboBox comboBoxListaChefes = new JComboBox();
		comboBoxListaChefes.setModel(new DefaultComboBoxModel(new String[] {"", "Antonio"}));
		comboBoxListaChefes.setBounds(277, 88, 196, 22);
		CadastramentoFuncionario.add(comboBoxListaChefes);
		
		JLabel lbGrau = new JLabel("Grau de Instru\u00E7\u00E3o: ");
		lbGrau.setBounds(37, 189, 183, 14);
		CadastramentoFuncionario.add(lbGrau);
		
		JRadioButton radioButtonSegundoGrau = new JRadioButton("Segundo Grau");
		radioButtonSegundoGrau.setBounds(277, 185, 148, 23);
		CadastramentoFuncionario.add(radioButtonSegundoGrau);
		
		JRadioButton radioButtonSuperior = new JRadioButton("Superior");
		radioButtonSuperior.setBounds(486, 185, 109, 23);
		CadastramentoFuncionario.add(radioButtonSuperior);
		
		ButtonGroup tipoEnsino = new ButtonGroup();
		tipoEnsino.add(radioButtonSegundoGrau);
		tipoEnsino.add(radioButtonSuperior);
		
		
		JLabel lbTipo = new JLabel("Tipo: ");
		lbTipo.setBounds(37, 247, 105, 14);
		CadastramentoFuncionario.add(lbTipo);
		
		JComboBox comboBoxTipoFuncionario = new JComboBox();
		comboBoxTipoFuncionario.setModel(new DefaultComboBoxModel(new String[] {"", "Chefe", "Empregado"}));
		comboBoxTipoFuncionario.setBounds(277, 239, 109, 22);
		CadastramentoFuncionario.add(comboBoxTipoFuncionario);
		
		
		JComboBox comboBoxListaFuncionarios = new JComboBox();
		
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNomeFuncionario.getText();
				String tipoDeFuncionario = (String) comboBoxTipoFuncionario.getSelectedItem();
				Pessoa superior = antonio.acharPessoa((String) comboBoxListaChefes.getSelectedItem());
				
				if(tipoDeFuncionario.equalsIgnoreCase("Chefe")) {
					Pessoa funcionario = new Chefe(nome);
					try {
						superior.addSubordinado(funcionario);
					} catch (EmpregadoNaoTemSubordinadoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					comboBoxListaChefes.addItem(nome);
					
				}
				
				else {
					Pessoa funcionario = new Empregado(nome);
					try {
						superior.addSubordinado(funcionario);
					} catch (EmpregadoNaoTemSubordinadoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				comboBoxListaFuncionarios.addItem(nome);
			}
		});
		
		btCadastrar.setBounds(613, 364, 123, 23);
		CadastramentoFuncionario.add(btCadastrar);
		
		JPanel Consulta = new JPanel();
		tabbedPane.addTab("Consulta", null, Consulta, null);
		Consulta.setLayout(null);
		
		JLabel lbNomeFuncionarioConsulta = new JLabel("Nome do funcion\u00E1rio: ");
		lbNomeFuncionarioConsulta.setBounds(33, 55, 170, 14);
		Consulta.add(lbNomeFuncionarioConsulta);
	
		comboBoxListaFuncionarios.setModel(new DefaultComboBoxModel(new String[] {"", "Antonio"}));
		comboBoxListaFuncionarios.setBounds(263, 51, 153, 22);
		Consulta.add(comboBoxListaFuncionarios);
		
		JLabel lbTipoDeConsulta = new JLabel("Tipo de consulta: ");
		lbTipoDeConsulta.setBounds(33, 119, 127, 14);
		Consulta.add(lbTipoDeConsulta);
		
		JComboBox comboBoxTipoDeConsulta = new JComboBox();
		comboBoxTipoDeConsulta.setModel(new DefaultComboBoxModel(new String[] {"", "Chefes", "Subordinados"}));
		comboBoxTipoDeConsulta.setBounds(263, 115, 153, 22);
		Consulta.add(comboBoxTipoDeConsulta);
		
		JLabel lbListagem = new JLabel("Lista:");
		lbListagem.setBounds(32, 161, 46, 14);
		Consulta.add(lbListagem);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(33, 180, 699, 173);
		Consulta.add(textPane);
		
		JButton btConsultar = new JButton("Consultar");
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = (String) comboBoxTipoDeConsulta.getSelectedItem();
				String nome = (String) comboBoxListaFuncionarios.getSelectedItem();
				Pessoa pessoa = antonio.acharPessoa(nome);
				String lista;
				if(tipo.equalsIgnoreCase("Chefes")) {
					//lista = pessoa.listarSuperiores();
					lista = "Falta a função";
				}
				else {
					lista = pessoa.listarSubordinados();
//					System.out.println(lista);
				}
				textPane.setText(lista);
			}
		});
		btConsultar.setBounds(590, 381, 142, 23);
		Consulta.add(btConsultar);
	}
}