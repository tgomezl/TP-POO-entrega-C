package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import administrador.altaAdministrador;
import administrador.altaAdministrativo;
import administrador.altaArticulo;
import administrador.altaOperador;
import administrador.altaTecnico;
import administrador.altaTipoTecnico;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class principal extends JFrame {

	private JPanel contentPane;
	private static principal principal;
	private String rol;
	private String nombre;
	
	

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String getRol() {
		return rol;
	}

	private void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal = new principal("PRUEBA","PRUEBA");
					principal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principal(String rol,String nombre) {
		
		this.rol = rol;
		this.nombre = nombre;		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("USUARIO: Alejandro Salgado");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNombre.setBounds(133, 11, 178, 14);
		lblNombre.setText("USUARIO: " + nombre);
		contentPane.add(lblNombre);
		
		JLabel lblResponsabilidad = new JLabel("Responsabilidad: Tecnico");
		lblResponsabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsabilidad.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblResponsabilidad.setBounds(121, 30, 177, 14);
		lblResponsabilidad.setText("Responsabilidad: " + rol);
		contentPane.add(lblResponsabilidad);
		
		JMenuBar menuAdministrativo = new JMenuBar();
		menuAdministrativo.setBounds(0, 0, 101, 22);
		contentPane.add(menuAdministrativo);
		
		JMenu mnNewMenu = new JMenu("Servicios");
		menuAdministrativo.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar servicios");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Facturar servicio");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuBar menuOperador = new JMenuBar();
		menuOperador.setBounds(0, 0, 101, 22);
		contentPane.add(menuOperador);
		
		JMenu mnNewMenu_1 = new JMenu("Clientes");
		menuOperador.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Tomar visita");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Articulos");
		menuOperador.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Modificar stock");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuBar menuTecnico = new JMenuBar();
		menuTecnico.setBounds(0, 0, 101, 22);
		contentPane.add(menuTecnico);
		
		JMenu mnNewMenu_3 = new JMenu("Servicios");
		menuTecnico.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Trabajos pendientes");
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Terminar trabajo");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuBar menuAdministrador = new JMenuBar();
		menuAdministrador.setBounds(0, 0, 101, 22);
		contentPane.add(menuAdministrador);
		
		JMenu mnNewMenu_4 = new JMenu("Operaciones");
		menuAdministrador.add(mnNewMenu_4);
		
		JMenu mnNewMenu_9 = new JMenu("Alta");
		mnNewMenu_4.add(mnNewMenu_9);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Articulo");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaArticulo a = new altaArticulo();
				a.setLocationRelativeTo(principal);
				a.setVisible(true);
			}
		});
		mnNewMenu_9.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Tecnico");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaTecnico a = new altaTecnico();
				a.setLocationRelativeTo(principal);
				a.setVisible(true);
			}
		});
		mnNewMenu_9.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Administrativo");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaAdministrativo a = new altaAdministrativo();
				a.setLocationRelativeTo(principal);
				a.setVisible(true);
			}
		});
		mnNewMenu_9.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Operador");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaOperador a = new altaOperador();
				a.setLocationRelativeTo(principal);
				a.setVisible(true);
			}
		});
		mnNewMenu_9.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Administrador");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaAdministrador a = new altaAdministrador();
				a.setLocationRelativeTo(principal);
				a.setVisible(true);
			}
		});
		mnNewMenu_9.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Tipo tecnico");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaTipoTecnico a = new altaTipoTecnico();
				a.setLocationRelativeTo(principal);
				a.setVisible(true);
			}
			
		});
		mnNewMenu_9.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_5 = new JMenu("Modificacion");
		mnNewMenu_4.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Articulo");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Tecnico");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Administrativo");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Operador");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Administrador");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Tipo tecnico");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_17);
		
		JMenu mnNewMenu_6 = new JMenu("Baja");
		mnNewMenu_4.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Articulo");
		mnNewMenu_6.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Tecnico");
		mnNewMenu_6.add(mntmNewMenuItem_20);
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Administrativo");
		mnNewMenu_6.add(mntmNewMenuItem_21);
		
		JMenuItem mntmNewMenuItem_22 = new JMenuItem("Operador");
		mnNewMenu_6.add(mntmNewMenuItem_22);
		
		JMenuItem mntmNewMenuItem_24 = new JMenuItem("Administrador");
		mnNewMenu_6.add(mntmNewMenuItem_24);
		
		JMenuItem mntmNewMenuItem_26 = new JMenuItem("Tipo tecnico");
		mnNewMenu_6.add(mntmNewMenuItem_26);
		
		JButton btnCerrarSesion = new JButton("X");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loguin l = new loguin();
				l.setLocationRelativeTo(principal);
				l.setVisible(true);
			}
		});
		btnCerrarSesion.setBounds(395, 0, 39, 23);
		contentPane.add(btnCerrarSesion);
		
		switch(this.rol) {
		
		case "Tecnico":
			menuTecnico.setVisible(true); 
			menuOperador.setVisible(false); 
			menuAdministrador.setVisible(false); 
			menuAdministrativo.setVisible(false);
			break;
			
		case "Operador":
			menuTecnico.setVisible(false); 
			menuOperador.setVisible(true); 
			menuAdministrador.setVisible(false); 
			menuAdministrativo.setVisible(false);
			break;
			
			
		case "Administrador":
			menuTecnico.setVisible(false); 
			menuOperador.setVisible(false); 
			menuAdministrador.setVisible(true); 
			menuAdministrativo.setVisible(false); 
			break;
			
			
		case "Administrativo":
			menuTecnico.setVisible(false); 
			menuOperador.setVisible(false); 
			menuAdministrador.setVisible(false); 
			menuAdministrativo.setVisible(true);
			break;
		
		
		}
		
	}
}
