package projetoPesquisa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Ui {

	private JFrame frame;
	private JTextField textNome;

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
		frame.setBounds(100, 100, 851, 530);
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
		lblTipo.setBounds(60, 142, 146, 15);
		panel.add(lblTipo);
		
		JLabel lblNomePesquisador_1_1 = new JLabel("Coordenador");
		lblNomePesquisador_1_1.setBounds(60, 250, 146, 15);
		panel.add(lblNomePesquisador_1_1);
		
		textNome = new JTextField();
		textNome.setBounds(272, 43, 230, 19);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Professor", "Coordenador"}));
		comboBox.setBounds(285, 137, 217, 24);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Mara Andrade"}));
		comboBox_1.setBounds(285, 245, 217, 24);
		panel.add(comboBox_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(667, 395, 117, 25);
		panel.add(btnCadastrar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consultas", null, panel_1, null);
		panel_1.setLayout(null);
	}
}
