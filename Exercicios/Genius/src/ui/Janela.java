package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controle.Genius;
import exceptions.SemJogadoresCadastradosException;
import negocio.Jogador;
import negocio.Partida;

public class Janela {

	private JFrame frame;
	private JTextField txtNome;
	private Genius genius = new Genius();
	private boolean clicavel = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
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
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_Cadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel_Cadastro, null);
		panel_Cadastro.setLayout(null);
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setBounds(28, 38, 46, 14);
		panel_Cadastro.add(lbNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(84, 35, 152, 20);
		panel_Cadastro.add(txtNome);
		txtNome.setColumns(10);
		
		
		JPanel panel_Jogo = new JPanel();
		tabbedPane.addTab("Genius", null, panel_Jogo, null);
		panel_Jogo.setLayout(null);
		
		
		
		JComboBox<String> cbJogadoresCadastrados = new JComboBox<String>();
		cbJogadoresCadastrados.setBounds(309, 99, 88, 22);
		panel_Cadastro.add(cbJogadoresCadastrados);
		
		JButton btApagarJogador = new JButton("Deletar");
		btApagarJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partida partidaAtual = genius.getPartidaAtual();
				
				JOptionPane.showMessageDialog(btApagarJogador, "Jogador " + cbJogadoresCadastrados.getSelectedItem()+ " Deletado");
				
				Jogador jogador = partidaAtual.acharJogador(cbJogadoresCadastrados.getSelectedItem().toString());
				partidaAtual.removeJogador(jogador);
				cbJogadoresCadastrados.removeItem(cbJogadoresCadastrados.getSelectedItem());
			}
		});
		btApagarJogador.setBounds(308, 168, 89, 23);
		panel_Cadastro.add(btApagarJogador);
		
		
		
		

		// PANEL JOGO ABAIXO ------------------------------------------------------------------------------------------------------------
		JLabel lb0 = new JLabel("LABEL 0");
		lb0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(clicavel) {
					System.out.println("Clicou Verde");
					Partida partidaAtual = genius.getPartidaAtual();
					partidaAtual.verificaJogada(0, 0);
					
				}
			}
		});
		lb0.setBounds(30, 26, 120, 93);
		panel_Jogo.add(lb0);
		
		JLabel lb1 = new JLabel("LABEL 1");
		lb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(clicavel) {
					System.out.println("Clicou Amarelo");
					Partida partidaAtual = genius.getPartidaAtual();
					partidaAtual.verificaJogada(0, 1);
				}
			}
		});
		lb1.setBounds(217, 26, 120, 93);
		panel_Jogo.add(lb1);
		
		JLabel lb2 = new JLabel("LABEL 2");
		lb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(clicavel) {
					System.out.println("Clicou Vermelho");
					Partida partidaAtual = genius.getPartidaAtual();
					partidaAtual.verificaJogada(0, 2);
				}
			}
		});
		lb2.setBounds(30, 146, 120, 93);
		panel_Jogo.add(lb2);
		
		JLabel lb3 = new JLabel("LABEL 3");
		lb3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(clicavel) {
					System.out.println("Clicou Azul");
					Partida partidaAtual = genius.getPartidaAtual();
					partidaAtual.verificaJogada(0, 3);
				}
			}
		});
		lb3.setBounds(217, 146, 120, 93);
		panel_Jogo.add(lb3);
		
		
		JLabel lbJogadoresDisponiveis = new JLabel("Jogadores: --CADASTRE JOGADORES--");
		lbJogadoresDisponiveis.setBounds(30, 11, 342, 14);
		panel_Jogo.add(lbJogadoresDisponiveis);
		
		try {
			lb0.setIcon( new ImageIcon(ImageIO.read( new File("greenColor.jpg") ) ) );
			lb1.setIcon( new ImageIcon(ImageIO.read( new File("yellowColor.jpg") ) ) );
			lb2.setIcon( new ImageIcon(ImageIO.read( new File("redColor.jpg") ) ) );
			lb3.setIcon( new ImageIcon(ImageIO.read( new File("blueColor.jpg") ) ) );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lbIniciar = new JLabel("INICIAR JOGO");
		lbIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int jogadores = cbJogadoresCadastrados.getItemCount();
				
				if(jogadores == 0) JOptionPane.showMessageDialog(lbIniciar, "Cadastre pelo menos 1 jogador para iniciar");
				
				else {
					if(clicavel) {
						
					}
					else {
						Partida partidaAtual = genius.novaPartida();
						partidaAtual.addJogadaEmJogador(0);
						clicavel = !clicavel;
					}
				}
				
				//Partida partidaAtual = genius.getPartidaAtual();
				//clicavel = !clicavel;
				System.out.println("Clicavel agora é: " + clicavel);
				/*try {
					partidaAtual.iniciarPartida();
					JOptionPane.showMessageDialog(lbIniciar, "JOGO VAI COMEÇAR");
				} catch (SemJogadoresCadastradosException e1) {
					JOptionPane.showMessageDialog(lbIniciar, "Não há jogadores cadastrados");
				}*/
			}
		});
		lbIniciar.setBounds(138, 130, 95, 14);
		panel_Jogo.add(lbIniciar);
		
		// Button cadastrar da panel cadastro
		JButton btCadastrarJogador = new JButton("Cadastrar");
		btCadastrarJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partida partidaAtual = genius.getPartidaAtual();
				
				partidaAtual.addJogador(new Jogador(txtNome.getText()));
				cbJogadoresCadastrados.addItem(txtNome.getText());
				JOptionPane.showMessageDialog(btCadastrarJogador, "Jogador " + txtNome.getText() +  " Cadastrado");
				
				lbJogadoresDisponiveis.setText("Jogadores: ");
				for (Jogador jogador : partidaAtual.getJogadoresCadastrados()) {
					lbJogadoresDisponiveis.setText(lbJogadoresDisponiveis.getText() + jogador.getNome() + "  ");
				}
			}
		});
		btCadastrarJogador.setBounds(54, 168, 124, 23);
		panel_Cadastro.add(btCadastrarJogador);
	}
}
