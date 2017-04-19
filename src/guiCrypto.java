import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import java.io.File;
import java.util.Enumeration;

import javax.swing.JRadioButtonMenuItem; 

public class guiCrypto {

	private JFrame frame;
	private JTextField textFileDEncrypt;
	private JTextField textFileKey;
	private JTextField textResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiCrypto window = new guiCrypto();
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
	public guiCrypto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 522, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("AES Calculator for Encryption and Decryption");
		lblTitle.setBounds(121, 21, 304, 14);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblEncyrptionDecryption = new JLabel("Encyrption / Decryption File");
		lblEncyrptionDecryption.setBounds(26, 58, 207, 14);
		frame.getContentPane().add(lblEncyrptionDecryption);
		
		textFileDEncrypt = new JTextField();
		textFileDEncrypt.setBounds(26, 73, 324, 23);
		frame.getContentPane().add(textFileDEncrypt);
		textFileDEncrypt.setColumns(10);
		
		JButton btnOpenDEncrypt = new JButton("Open File");
		btnOpenDEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("Open file to Encrypt or Decrypt");
				int result = fs.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File fileDEncrypt = fs.getSelectedFile();
				    textFileDEncrypt.setText(fileDEncrypt.getAbsolutePath());
				}
			}
		});
		btnOpenDEncrypt.setBounds(360, 73, 89, 23);
		frame.getContentPane().add(btnOpenDEncrypt);
		
		JLabel lblNewLabel = new JLabel("Key File");
		lblNewLabel.setBounds(26, 107, 157, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textFileKey = new JTextField();
		textFileKey.setBounds(26, 120, 324, 23);
		frame.getContentPane().add(textFileKey);
		textFileKey.setColumns(10);
		
		JButton btnOpenKey = new JButton("Open File");
		btnOpenKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("Open file for key");
				int result = fs.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File fileKey = fs.getSelectedFile();
				    textFileKey.setText(fileKey.getAbsolutePath());
				}
			}
		});
		btnOpenKey.setBounds(360, 120, 89, 23);
		frame.getContentPane().add(btnOpenKey);

		JLabel lblKey = new JLabel("Key :");
		lblKey.setBounds(77, 154, 46, 14);
		frame.getContentPane().add(lblKey);
		
		ButtonGroup keyGroup = new ButtonGroup();
		
		JRadioButton rdbtn128 = new JRadioButton("128 bit");
		rdbtn128.setSelected(true);
		rdbtn128.setBounds(134, 150, 77, 23);
		frame.getContentPane().add(rdbtn128);
		
		JRadioButton rdbtn192 = new JRadioButton("192 bit");
		rdbtn192.setBounds(234, 150, 77, 23);
		frame.getContentPane().add(rdbtn192);
		
		JRadioButton rdbtn256 = new JRadioButton("256 bit");
		rdbtn256.setBounds(331, 150, 77, 23);
		frame.getContentPane().add(rdbtn256);
		
		keyGroup.add(rdbtn128);
		keyGroup.add(rdbtn192);
		keyGroup.add(rdbtn256);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyLength = getSelectedButton(keyGroup);
				String[] length = keyLength.split(" ");
				// gunakan length[0] untuk mendapatkan panjang key
				// To Do masukkan algoritma encrypt
				// textResult.setText(result) ----> berguna untuk memasukkan komen hasil encrypt di result box
			}
		});
		btnEncrypt.setBounds(144, 180, 89, 23);
		frame.getContentPane().add(btnEncrypt);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyLength = getSelectedButton(keyGroup);
				String[] length = keyLength.split(" ");
				// gunakan length[0] untuk mendapatkan panjang key
				// to do masukkan algoritma decrypt
				// textResult.setText(result) ----> berguna untuk memasukkan komen hasil decrypt di result box
			}
		});
		btnDecrypt.setBounds(257, 180, 89, 23);
		frame.getContentPane().add(btnDecrypt);

		JLabel lblResultBox = new JLabel("Result Box");
		lblResultBox.setBounds(10, 210, 173, 14);
		frame.getContentPane().add(lblResultBox);
		
		textResult = new JTextField();
		textResult.setBounds(10, 225, 486, 201);
		frame.getContentPane().add(textResult);
		textResult.setColumns(10);
	
	}
	
	public String getSelectedButton(ButtonGroup bg) {
		Enumeration elements = bg.getElements();
		while(elements.hasMoreElements()) {
			AbstractButton button = (AbstractButton) elements.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}
}
