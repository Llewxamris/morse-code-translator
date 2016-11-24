package morseCodeTranslator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MorseCodeTranslator
{

	private JFrame frame;
	private MorseCodeTree morse;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MorseCodeTranslator window = new MorseCodeTranslator();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MorseCodeTranslator()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		try
		{
			morse = new MorseCodeTree();
		}
		catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 38, 574, 170);
		frame.getContentPane().add(textArea);
		
		JTextArea textPane = new JTextArea();
		textPane.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textPane.setEditable(false);
		textPane.setBounds(10, 271, 574, 170);
		frame.getContentPane().add(textPane);
		textPane.setLineWrap(true);
		textPane.setWrapStyleWord(true);

		
		JLabel lblEnterT = new JLabel("Enter text to encode or decode:");
		lblEnterT.setBounds(10, 11, 177, 14);
		frame.getContentPane().add(lblEnterT);
		
		JButton btnEncode = new JButton("To Morse Code");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(morse.encode(textArea.getText()));
			}
		});
		btnEncode.setBounds(30, 226, 157, 23);
		frame.getContentPane().add(btnEncode);
		
		JButton btnDecode = new JButton("From Morse Code");
		btnDecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDecode.setBounds(217, 226, 157, 23);
		frame.getContentPane().add(btnDecode);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(404, 226, 157, 23);
		frame.getContentPane().add(btnClear);
	}
}
