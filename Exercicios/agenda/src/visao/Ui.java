package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dao.DAOAgendaSqlite;
import model.Contato;

public class Ui {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textTelefone;
	private Contato contato;
	private DAOAgendaSqlite bd = new DAOAgendaSqlite();

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
		frame.setBounds(100, 100, 825, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Agenda", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(53, 33, 70, 15);
		panel.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(150, 31, 228, 19);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(53, 100, 92, 15);
		panel.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(150, 98, 228, 19);
		panel.add(textTelefone);
		
		JButton btAddContato = new JButton("Adicionar");
		btAddContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				String telefone = textTelefone.getText();
				contato = new Contato(nome, telefone);
				
				try {
					bd.addContato(contato);
					JOptionPane.showMessageDialog(btAddContato, "Contato adicionado");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btAddContato.setBounds(150, 338, 117, 25);
		panel.add(btAddContato);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(406, 338, 117, 25);
		panel.add(btnBuscar);
	}
}
