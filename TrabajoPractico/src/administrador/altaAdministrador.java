package administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Administrador;
import clases.Administrativo;
import clases.Articulo;
import clases.Controlador;
import clases.Tecnico;
import clases.TipoArticulo;
import clases.TipoTecnico;
import clases.TipoTurno;
import interfaz.popUp;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPasswordField;

public class altaAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private static altaAdministrador altaAdministrador;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtFechaNacimiento;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaAdministrador = new altaAdministrador();
					altaAdministrador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public altaAdministrador() {
		setTitle("ALTA ADMINISTRADOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelAltaTecnico = new JPanel();
		panelAltaTecnico.setLayout(null);
		panelAltaTecnico.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelAltaTecnico, BorderLayout.CENTER);

		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1.setBounds(10, 22, 92, 18);
		panelAltaTecnico.add(lblNewLabel_1_1);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(112, 21, 86, 20);
		panelAltaTecnico.add(txtNombre);

		JComboBox dropSexo = new JComboBox();
		dropSexo.setModel(new DefaultComboBoxModel(new String[] { "M", "F" }));
		dropSexo.setBounds(271, 53, 86, 22);
		panelAltaTecnico.add(dropSexo);

		JButton btnAltaTecnico = new JButton("ALTA");
		btnAltaTecnico.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				char sexo;

				sexo = (Character) dropSexo.getSelectedItem().toString().charAt(0);

				Administrador administrador = new Administrador();

				administrador = Controlador.crearAdministrador(txtNombre.getText().toString(),
						txtApellido.getText().toString(), Integer.parseInt(txtDNI.getText().toString()), sexo,
						Integer.parseInt(txtFechaNacimiento.getText().toString()), txtDireccion.getText().toString(),
						txtTelefono.getText().toString(), txtUsuario.getText().toString(),
						txtContrasena.getText().toString());

				popUp p;

				if (administrador.getDni() != -1 && administrador.getUsuario() != "-1") {
					p = new popUp("ADMINISTRADOR CON DNI: " + administrador.getDni() + " Y USUARIO: "
							+ administrador.getUsuario() + " CREADO CON EXITO");
					txtNombre.setText("");
					txtApellido.setText("");
					txtDNI.setText("");
					txtFechaNacimiento.setText("");
					txtDireccion.setText("");
					txtTelefono.setText("");
					txtUsuario.setText("");
					txtContrasena.setText("");
					dropSexo.setSelectedIndex(0);
				} else if (administrador.getDni() == -1 && administrador.getUsuario() == "-1")
					p = new popUp("YA EXISTE UN ADMINISTRADOR CON EL DNI: " + txtDNI.getText().toString()
							+ " Y USUARIO: " + txtUsuario.getText().toString());
				else if (administrador.getDni() == -1)
					p = new popUp("YA EXISTE UN ADMINISTRADOR CON EL DNI: " + txtDNI.getText().toString());
				else
					p = new popUp("YA EXISTE EL USUARIO: " + txtUsuario.getText().toString());

				p.setLocationRelativeTo(altaAdministrador);
				p.setVisible(true);

				Controlador.listarAdministradores();

			}
		});
		btnAltaTecnico.setBounds(149, 183, 142, 23);
		panelAltaTecnico.add(btnAltaTecnico);

		JLabel lblNewLabel_1_1_2 = new JLabel("APELLIDO:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_2.setBounds(169, 23, 92, 18);
		panelAltaTecnico.add(lblNewLabel_1_1_2);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(271, 22, 86, 20);
		panelAltaTecnico.add(txtApellido);

		JLabel lblNewLabel_1_1_3 = new JLabel("DNI:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_3.setBounds(10, 52, 92, 18);
		panelAltaTecnico.add(lblNewLabel_1_1_3);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(112, 51, 86, 20);
		panelAltaTecnico.add(txtDNI);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("SEXO:");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_2_1.setBounds(169, 53, 92, 18);
		panelAltaTecnico.add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_1_1_4 = new JLabel("FECHA NACIMIENTO: (YYYYMMDD):");
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_4.setBounds(20, 82, 241, 29);
		panelAltaTecnico.add(lblNewLabel_1_1_4);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(271, 86, 86, 20);
		panelAltaTecnico.add(txtFechaNacimiento);

		JLabel lblNewLabel_1_1_5 = new JLabel("DIRECCION:");
		lblNewLabel_1_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_5.setBounds(10, 117, 92, 18);
		panelAltaTecnico.add(lblNewLabel_1_1_5);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(112, 116, 86, 20);
		panelAltaTecnico.add(txtDireccion);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("TELEFONO:");
		lblNewLabel_1_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_2_2.setBounds(169, 118, 92, 18);
		panelAltaTecnico.add(lblNewLabel_1_1_2_2);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(271, 117, 86, 20);
		panelAltaTecnico.add(txtTelefono);

		JLabel lblNewLabel_1_1_5_1 = new JLabel("USUARIO:");
		lblNewLabel_1_1_5_1.setForeground(Color.RED);
		lblNewLabel_1_1_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_5_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_5_1.setBounds(10, 147, 92, 18);
		panelAltaTecnico.add(lblNewLabel_1_1_5_1);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(112, 146, 86, 20);
		panelAltaTecnico.add(txtUsuario);

		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("PASSWD:");
		lblNewLabel_1_1_2_2_1.setForeground(Color.RED);
		lblNewLabel_1_1_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_2_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_2_2_1.setBounds(169, 148, 92, 18);
		panelAltaTecnico.add(lblNewLabel_1_1_2_2_1);

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(271, 146, 86, 18);
		panelAltaTecnico.add(txtContrasena);

	}
}
