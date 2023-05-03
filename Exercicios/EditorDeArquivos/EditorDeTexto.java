package editorDeTexto;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditorDeTexto {

	private JFrame frmEditorDeTexto;
	private JFileChooser escolherArquivo;
	private File arquivo;
	private FileReader reader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorDeTexto window = new EditorDeTexto();
					window.frmEditorDeTexto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditorDeTexto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditorDeTexto = new JFrame();
		frmEditorDeTexto.setTitle("Editor de Texto");
		frmEditorDeTexto.setBounds(100, 100, 637, 435);
		frmEditorDeTexto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditorDeTexto.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 12, 613, 282);
		frmEditorDeTexto.getContentPane().add(textPane);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escolherArquivo = new JFileChooser();
				escolherArquivo.showOpenDialog(null);
				arquivo = escolherArquivo.getSelectedFile();
				try {
					reader = new FileReader(arquivo.getAbsoluteFile());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					textPane.read(reader, null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLoad.setBounds(97, 328, 117, 25);
		frmEditorDeTexto.getContentPane().add(btnLoad);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(382, 328, 117, 25);
		frmEditorDeTexto.getContentPane().add(btnSave);
	}
}
