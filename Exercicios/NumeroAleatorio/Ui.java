package numeroAleatorio;
import java.util.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ui {

	private JFrame frmGerarNumeroAleatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui window = new Ui();
					window.frmGerarNumeroAleatorio.setVisible(true);
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
		frmGerarNumeroAleatorio = new JFrame();
		frmGerarNumeroAleatorio.setTitle("Gerar Numero Aleatorio");
		frmGerarNumeroAleatorio.setBounds(100, 100, 450, 300);
		frmGerarNumeroAleatorio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerarNumeroAleatorio.getContentPane().setLayout(null);
		
		JLabel lbNumAleatorio = new JLabel("Numero Aleatorio");
		lbNumAleatorio.setBounds(12, 32, 131, 20);
		frmGerarNumeroAleatorio.getContentPane().add(lbNumAleatorio);
		
		final JTextArea textNumero = new JTextArea();
		textNumero.setEditable(false);
		textNumero.setBounds(161, 35, 277, 20);
		frmGerarNumeroAleatorio.getContentPane().add(textNumero);
		
		JButton btnGerarNumero = new JButton("Gerar");
		btnGerarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				textNumero.setText(Double.toString(rand.nextDouble() * 10));
			}
		});
		btnGerarNumero.setBounds(56, 153, 117, 25);
		frmGerarNumeroAleatorio.getContentPane().add(btnGerarNumero);
		
		JButton btnApagarNumero = new JButton("Apagar");
		btnApagarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNumero.setText(null);
			}
		});
		btnApagarNumero.setBounds(248, 153, 117, 25);
		frmGerarNumeroAleatorio.getContentPane().add(btnApagarNumero);
	}
}
