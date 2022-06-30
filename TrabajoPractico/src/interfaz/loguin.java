package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import clases.Controlador;
import principal.Principal;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loguin extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private static loguin loguin;
	private JPasswordField textContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Controlador.script();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loguin = new loguin();
					loguin.setLocationRelativeTo(null);
					loguin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loguin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(113, 42, 218, 122);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		textUsuario = new JTextField();
		textUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
				
						JLabel lblNewLabel_1 = new JLabel("CONTRASE\u00D1A");
						lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
						panel.add(lblNewLabel_1);
				
				textContrasena = new JPasswordField();
				textContrasena.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(textContrasena);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (textContrasena.getText().isEmpty() || textUsuario.getText().isEmpty()) {
					popUp p = new popUp("COMPLETE TODOS LOS CAMPOS");
					p.setLocationRelativeTo(loguin);
					p.setVisible(true);
				} else {
					 String user = Controlador.loguin(textUsuario.getText().toString(),textContrasena.getText().toString());
					 String nombre = Controlador.nombreUsuario(textUsuario.getText().toString());

					if (user != "") {
						
						principal principal = new principal(user,nombre);
						principal.setLocationRelativeTo(loguin);
						principal.setVisible(true);
						dispose();

					} else {
						popUp p = new popUp("USUARIO O CONTRASE�A INCORRECTA");
						p.setLocationRelativeTo(loguin);
						p.setVisible(true);
					}

				}
			}
		});
		btnEntrar.setBounds(175, 185, 89, 23);
		contentPane.add(btnEntrar);
	}
}
