package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import excecoes.ProfessorNaoTemSubordinadosException;
import projetopesquisa.Coordenador;
import projetopesquisa.Pesquisador;
import projetopesquisa.Professor;

public class Ui {

	private JFrame frame;
	private JTextField textNome;
	private Coordenador mara = new Coordenador("Mara Andrade", null);
	private JTextField textQtdPesquisadores;
	private JTextField textValorPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui window = new Ui();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastramento Funcionário", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNomePesquisador = new JLabel("Nome Pesquisador");
		lblNomePesquisador.setBounds(60, 45, 146, 15);
		panel.add(lblNomePesquisador);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(60, 114, 146, 15);
		panel.add(lblTipo);
		
		JLabel lblNomePesquisador_1_1 = new JLabel("Coordenador");
		lblNomePesquisador_1_1.setBounds(60, 196, 146, 15);
		panel.add(lblNomePesquisador_1_1);
		
		textNome = new JTextField();
		textNome.setBounds(272, 43, 230, 19);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"", "Professor", "Coordenador"}));
		comboBoxTipo.setBounds(285, 109, 217, 24);
		panel.add(comboBoxTipo);
		
		JComboBox comboBoxListaCoordenadores = new JComboBox();
		comboBoxListaCoordenadores.setModel(new DefaultComboBoxModel(new String[] {"", "Mara Andrade"}));
		comboBoxListaCoordenadores.setBounds(285, 191, 217, 24);
		panel.add(comboBoxListaCoordenadores);
		
		JComboBox comboBoxListaPesquisadores = new JComboBox();
		comboBoxListaPesquisadores.setModel(new DefaultComboBoxModel(new String[] {"", "Mara Andrade"}));
		comboBoxListaPesquisadores.setBounds(234, 47, 172, 22);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(667, 395, 117, 25);
		panel.add(btnCadastrar);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				String tipoPesquisador = (String) comboBoxTipo.getSelectedItem();
				Pesquisador chefe = mara.acharPesquisador((String) comboBoxListaCoordenadores.getSelectedItem());
				
				comboBoxListaPesquisadores.addItem(nome);
				
				if(tipoPesquisador.equalsIgnoreCase("Coordenador")) {
					try {
						chefe.addSubordinado(new Coordenador(nome, chefe));
					} catch (ProfessorNaoTemSubordinadosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					comboBoxListaCoordenadores.addItem(nome);
				}
				
				else {
					try {
						chefe.addSubordinado(new Professor(nome, chefe));
					} catch (ProfessorNaoTemSubordinadosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnNewButton.setBounds(60, 291, 117, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consultas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lbNomePesquisador = new JLabel("Nome Pesquisador");
		lbNomePesquisador.setBounds(50, 51, 129, 14);
		panel_1.add(lbNomePesquisador);
		
		JButton btnConsulta = new JButton("Consulta");
		
		btnConsulta.setBounds(50, 128, 89, 23);
		panel_1.add(btnConsulta);
		
		
		panel_1.add(comboBoxListaPesquisadores);
		
		JLabel lbQtdPesquisadores = new JLabel("Qtd de Pesquisadores:");
		lbQtdPesquisadores.setBounds(50, 222, 116, 14);
		panel_1.add(lbQtdPesquisadores);
		
		textQtdPesquisadores = new JTextField();
		textQtdPesquisadores.setEditable(false);
		textQtdPesquisadores.setBounds(239, 219, 142, 20);
		panel_1.add(textQtdPesquisadores);
		textQtdPesquisadores.setColumns(10);
		
		JLabel lblValorPago = new JLabel("Valor pago:");
		lblValorPago.setBounds(50, 314, 116, 14);
		panel_1.add(lblValorPago);
		
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomePesquisador = (String) comboBoxListaPesquisadores.getSelectedItem();
				Pesquisador pesquisador = mara.acharPesquisador(nomePesquisador);
				int qtdPesquisadores = pesquisador.getQtdSubordinados();
				Double valorPago = pesquisador.getValor();
			
				textQtdPesquisadores.setText(""+qtdPesquisadores);
				textValorPago.setText(valorPago.toString());
			}
		});
		
		textValorPago = new JTextField();
		textValorPago.setEditable(false);
		textValorPago.setColumns(10);
		textValorPago.setBounds(234, 311, 142, 20);
		panel_1.add(textValorPago);
	}
}