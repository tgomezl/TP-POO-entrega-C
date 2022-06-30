package administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Articulo;
import clases.Controlador;
import clases.TipoArticulo;
import clases.TipoTecnico;
import clases.TipoTecnicoEnum;
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

public class altaTipoTecnico extends JFrame {

	private JPanel contentPane;
	private JTextField txtValorHora;
	private JTextField txtValorCombustible;
	private JTextField txtCostoViaje;
	private DefaultComboBoxModel<String> listaTipoTecnico=new DefaultComboBoxModel<>();
	private static altaTipoTecnico altaTipoTecnico; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaTipoTecnico = new altaTipoTecnico();
					altaTipoTecnico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public altaTipoTecnico() {
		setTitle("ALTA TECNICO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelAltaArticulo = new JPanel();
		panelAltaArticulo.setLayout(null);
		panelAltaArticulo.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelAltaArticulo, BorderLayout.CENTER);
		
		txtValorCombustible = new JTextField();
		txtValorCombustible.setColumns(10);
		txtValorCombustible.setBounds(196, 100, 86, 20);
		panelAltaArticulo.add(txtValorCombustible);
		
		JComboBox comboTipoTecnico = new JComboBox();
		comboTipoTecnico.setBounds(196, 31, 86, 22);
		panelAltaArticulo.add(comboTipoTecnico);
		
		comboTipoTecnico.setModel(listaTipoTecnico);
		
		for(TipoTecnicoEnum t : TipoTecnicoEnum.values()) {
			listaTipoTecnico.addElement(t.toString());
		}
		
		
		JLabel lblNewLabel_1 = new JLabel("TIPO TECNICO:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1.setBounds(94, 35, 92, 18);
		panelAltaArticulo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("VALOR HORA:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1.setBounds(94, 71, 92, 18);
		panelAltaArticulo.add(lblNewLabel_1_1);
		
		txtValorHora = new JTextField();
		txtValorHora.setColumns(10);
		txtValorHora.setBounds(196, 70, 86, 20);
		panelAltaArticulo.add(txtValorHora);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("VALOR COMBUSTIBLE:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_1.setBounds(78, 101, 108, 18);
		panelAltaArticulo.add(lblNewLabel_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("COSTO VIAJE:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_1_1.setBounds(94, 131, 92, 18);
		panelAltaArticulo.add(lblNewLabel_1_1_1_1);
		
		txtCostoViaje = new JTextField();
		txtCostoViaje.setColumns(10);
		txtCostoViaje.setBounds(196, 130, 86, 20);
		panelAltaArticulo.add(txtCostoViaje);
		
		JLabel lblNewLabel_1_2 = new JLabel("ESTADO:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_2.setBounds(94, 164, 92, 18);
		panelAltaArticulo.add(lblNewLabel_1_2);
		
		JComboBox txtEstado = new JComboBox();
		txtEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Desactivado"}));
		txtEstado.setBounds(196, 160, 86, 22);
		panelAltaArticulo.add(txtEstado);
		
		JButton btnAltaArticulo = new JButton("ALTA");
		btnAltaArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean estado = false;
				
				if(txtEstado.getSelectedItem().toString().equals("Activo"))
					estado = true;
					
				TipoTecnicoEnum tipo = null;
				
				for(TipoTecnicoEnum t: TipoTecnicoEnum.values()) {
					if(t.toString().equals(comboTipoTecnico.getSelectedItem().toString()))
						tipo = t;
				}
				
				TipoTecnico tec = new TipoTecnico();
				
				tec = Controlador.crearTipoTecnico(tipo, Long.parseLong(txtValorHora.getText().toString()), 
						Double.parseDouble(txtValorCombustible.getText().toString()),Double.parseDouble(txtCostoViaje.getText().toString()),
						estado);	
				
				txtValorHora.setText("");
				txtValorCombustible.setText("");
				txtCostoViaje.setText("");
				comboTipoTecnico.setSelectedIndex(0);
				txtEstado.setSelectedIndex(0);
				
				popUp p = new popUp("TIPO TECNICO CON ID: " + tec.getIdTipo() + " REGISTRADO");
				p.setLocationRelativeTo(altaTipoTecnico);
				p.setVisible(true);
				
				Controlador.listarTiposTecnicos();
				
				
			}
		});
		btnAltaArticulo.setBounds(152, 206, 142, 23);
		panelAltaArticulo.add(btnAltaArticulo);
	}

}
