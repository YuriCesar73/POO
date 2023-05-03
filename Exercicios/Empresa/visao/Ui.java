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
		frmEmpregaOGestor.setBounds(100, 100, 567, 430);
		frmEmpregaOGestor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmEmpregaOGestor.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel CadastramentoFuncionario = new JPanel();
		tabbedPane.addTab("Cadastramento Funcionário", null, CadastramentoFuncionario, null);
		CadastramentoFuncionario.setLayout(null);
		
		JLabel lbNomeFuncionario = new JLabel("Nome Funcion\u00E1rio:");
		lbNomeFuncionario.setBounds(37, 42, 105, 14);
		CadastramentoFuncionario.add(lbNomeFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(190, 39, 196, 20);
		CadastramentoFuncionario.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JLabel lbChefe = new JLabel("Chefe:");
		lbChefe.setBounds(37, 92, 105, 14);
		CadastramentoFuncionario.add(lbChefe);
		
		JComboBox comboBoxListaChefes = new JComboBox();
		comboBoxListaChefes.setModel(new DefaultComboBoxModel(new String[] {"", "Antonio"}));
		comboBoxListaChefes.setBounds(190, 88, 196, 22);
		CadastramentoFuncionario.add(comboBoxListaChefes);
		
		JLabel lbGrau = new JLabel("Grau de Instru\u00E7\u00E3o: ");
		lbGrau.setBounds(37, 189, 130, 14);
		CadastramentoFuncionario.add(lbGrau);
		
		JRadioButton radioButtonSegundoGrau = new JRadioButton("Segundo Grau");
		radioButtonSegundoGrau.setBounds(190, 185, 109, 23);
		CadastramentoFuncionario.add(radioButtonSegundoGrau);
		
		JRadioButton radioButtonSuperior = new JRadioButton("Superior");
		radioButtonSuperior.setBounds(351, 185, 109, 23);
		CadastramentoFuncionario.add(radioButtonSuperior);
		
		ButtonGroup tipoEnsino = new ButtonGroup();
		tipoEnsino.add(radioButtonSegundoGrau);
		tipoEnsino.add(radioButtonSuperior);
		
		
		JLabel lbTipo = new JLabel("Tipo: ");
		lbTipo.setBounds(37, 247, 105, 14);
		CadastramentoFuncionario.add(lbTipo);
		
		JComboBox comboBoxTipoFuncionario = new JComboBox();
		comboBoxTipoFuncionario.setModel(new DefaultComboBoxModel(new String[] {"", "Chefe", "Empregado"}));
		comboBoxTipoFuncionario.setBounds(190, 243, 109, 22);
		CadastramentoFuncionario.add(comboBoxTipoFuncionario);
		
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
				
			}
		});
		btCadastrar.setBounds(371, 304, 123, 23);
		CadastramentoFuncionario.add(btCadastrar);
		
		JPanel Consulta = new JPanel();
		tabbedPane.addTab("Consulta", null, Consulta, null);
		Consulta.setLayout(null);
		
		JLabel lbNomeFuncionarioConsulta = new JLabel("Nome do funcion\u00E1rio: ");
		lbNomeFuncionarioConsulta.setBounds(33, 55, 127, 14);
		Consulta.add(lbNomeFuncionarioConsulta);
		
		JComboBox comboBoxListaFuncionarios = new JComboBox();
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
		textPane.setBounds(33, 180, 440, 138);
		Consulta.add(textPane);
		
		JButton btConsultar = new JButton("Consultar");
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Chefe sergio = new Chefe("Sergio");
					antonio.addSubordinado(sergio);
					sergio.addSubordinado(new Chefe("Nicolas"));
					sergio.addSubordinado(new Empregado("Marcos"));
					textPane.setText(antonio.listarSubordinados());
				} catch (EmpregadoNaoTemSubordinadoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(antonio.listarSubordinados());
			}
		});
		btConsultar.setBounds(384, 329, 89, 23);
		Consulta.add(btConsultar);
	}
}
