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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import negocio.BBB;
import negocio.Participante;

public class Ui {

	private JFrame frmBbb;
	private JTextField textNomeParticipante;
	private JTextField textCodigoGerado;
	private JTextField textNomeParticipanteVoto;
	private JTextField textPerdedor;
	private JTextField textPercentualGanhador;
	private JTextField textPercentualDerrotado;
	private BBB bbb = new BBB();
	private Participante participante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui window = new Ui();
					window.frmBbb.setVisible(true);
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
		frmBbb = new JFrame();
		frmBbb.setTitle("BBB");
		frmBbb.setBounds(100, 100, 686, 460);
		frmBbb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmBbb.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel CadastrarParticipante = new JPanel();
		tabbedPane.addTab("Cadastrar", null, CadastrarParticipante, null);
		CadastrarParticipante.setLayout(null);
		
		JLabel lbDesc = new JLabel("Adicione as informa\u00E7\u00F5es do participante");
		lbDesc.setBounds(229, 11, 327, 24);
		CadastrarParticipante.add(lbDesc);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(42, 55, 86, 14);
		CadastrarParticipante.add(lbNome);
		
		textNomeParticipante = new JTextField();
		textNomeParticipante.setBounds(109, 52, 178, 20);
		CadastrarParticipante.add(textNomeParticipante);
		textNomeParticipante.setColumns(10);
		
		JComboBox comboBoxTipoDeVoto = new JComboBox();
		
		JButton btCadastrarParticipante = new JButton("Cadastrar");
		btCadastrarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNomeParticipante.getText();
				participante = new Participante(nome);
				bbb.addParticipante(participante);
				JOptionPane.showMessageDialog(btCadastrarParticipante, "Participante Cadastrado");
				textCodigoGerado.setText(""+participante.getCod());
			}
		});
		btCadastrarParticipante.setBounds(161, 140, 126, 23);
		CadastrarParticipante.add(btCadastrarParticipante);
		
		JLabel lbCodigoGerado = new JLabel("Codigo:");
		lbCodigoGerado.setBounds(42, 219, 46, 14);
		CadastrarParticipante.add(lbCodigoGerado);
		
		textCodigoGerado = new JTextField();
		textCodigoGerado.setEditable(false);
		textCodigoGerado.setColumns(10);
		textCodigoGerado.setBounds(109, 216, 178, 20);
		CadastrarParticipante.add(textCodigoGerado);
		
		JPanel Votar = new JPanel();
		tabbedPane.addTab("Votar", null, Votar, null);
		Votar.setLayout(null);
		
		JLabel lbDescricao = new JLabel("Vote pelo nome ou pelo c\u00F3digo do participante");
		lbDescricao.setBounds(192, 11, 292, 14);
		Votar.add(lbDescricao);
		
		JLabel lblNomeParticipante = new JLabel("Participante:");
		lblNomeParticipante.setBounds(254, 53, 86, 14);
		Votar.add(lblNomeParticipante);
		
		textNomeParticipanteVoto = new JTextField();
		textNomeParticipanteVoto.setColumns(10);
		textNomeParticipanteVoto.setBounds(350, 50, 178, 20);
		Votar.add(textNomeParticipanteVoto);
		
		
		comboBoxTipoDeVoto.setModel(new DefaultComboBoxModel(new String[] {"", "Nome", "Codigo"}));
		comboBoxTipoDeVoto.setBounds(105, 49, 99, 22);
		Votar.add(comboBoxTipoDeVoto);
		
		JButton btVotar = new JButton("Votar");
		btVotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() != btVotar) {
					return;
				}
				String tipo = (String) comboBoxTipoDeVoto.getSelectedItem();
				
				if(tipo.equalsIgnoreCase("Nome")) {
					String nome = textNomeParticipanteVoto.getText();
					bbb.armazenarVotosPorNome(nome);
					JOptionPane.showMessageDialog(btVotar, "Voto cadastrado!");
				}
				else if(tipo.equalsIgnoreCase("Codigo")) {
					int codigo = Integer.parseInt((String )textNomeParticipanteVoto.getText());
					bbb.armazenarVotosPorCodigo(codigo);
					JOptionPane.showMessageDialog(btVotar, "Voto cadastrado!");
				}
				else {
					JOptionPane.showMessageDialog(btVotar, "Selecione uma opção de voto");
				}
			}
		});
		btVotar.setBounds(192, 101, 124, 23);
		Votar.add(btVotar);
		
		JButton btResultado = new JButton("Resultado");
		btResultado.setBounds(192, 135, 124, 23);
		Votar.add(btResultado);
		
		JLabel lblPerdedor = new JLabel("Perdedor: ");
		lblPerdedor.setBounds(33, 220, 86, 14);
		Votar.add(lblPerdedor);
		
		textPerdedor = new JTextField();
		textPerdedor.setEditable(false);
		textPerdedor.setColumns(10);
		textPerdedor.setBounds(244, 217, 178, 20);
		Votar.add(textPerdedor);
		
		JLabel lblPercentual = new JLabel("Percentual Vencedor:");
		lblPercentual.setBounds(33, 268, 112, 14);
		Votar.add(lblPercentual);
		
		JLabel lblPercentualDerrotado = new JLabel("Percentual Derrotado:");
		lblPercentualDerrotado.setBounds(33, 324, 112, 14);
		Votar.add(lblPercentualDerrotado);
		
		textPercentualGanhador = new JTextField();
		textPercentualGanhador.setEditable(false);
		textPercentualGanhador.setColumns(10);
		textPercentualGanhador.setBounds(244, 265, 178, 20);
		Votar.add(textPercentualGanhador);
		
		textPercentualDerrotado = new JTextField();
		textPercentualDerrotado.setEditable(false);
		textPercentualDerrotado.setColumns(10);
		textPercentualDerrotado.setBounds(244, 321, 178, 20);
		Votar.add(textPercentualDerrotado);
		
		JLabel lblVotarPor = new JLabel("Votar por:");
		lblVotarPor.setBounds(33, 53, 86, 14);
		Votar.add(lblVotarPor);
	}
}
