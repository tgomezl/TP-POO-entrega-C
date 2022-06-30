package administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Articulo;
import clases.Controlador;
import clases.TipoArticulo;
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

public class altaArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField txtStock;
	private JTextField txtMetros;
	private JTextField txtCosto;
	private DefaultComboBoxModel<String> listaTipoArticulo=new DefaultComboBoxModel<>();
	private static altaArticulo altaArticulo; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaArticulo = new altaArticulo();
					altaArticulo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public altaArticulo() {
		setTitle("ALTA ARTICULO");
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
		
		txtMetros = new JTextField();
		txtMetros.setColumns(10);
		txtMetros.setBounds(196, 100, 86, 20);
		panelAltaArticulo.add(txtMetros);
		
		JComboBox comboTipoArticulo = new JComboBox();
		comboTipoArticulo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().toString().equals("CABLE")) {
					txtMetros.setEnabled(true);
				}else {
					txtMetros.setEnabled(false);
					txtMetros.setText("0");
				}
				
			}
		});
		comboTipoArticulo.setBounds(196, 31, 86, 22);
		panelAltaArticulo.add(comboTipoArticulo);
		
		comboTipoArticulo.setModel(listaTipoArticulo);
		
		for(TipoArticulo c : TipoArticulo.values()) {
			listaTipoArticulo.addElement(c.toString());
		}
		
		
		JLabel lblNewLabel_1 = new JLabel("TIPO ARTICULO:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1.setBounds(94, 35, 92, 18);
		panelAltaArticulo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("STOCK:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1.setBounds(94, 71, 92, 18);
		panelAltaArticulo.add(lblNewLabel_1_1);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(196, 70, 86, 20);
		panelAltaArticulo.add(txtStock);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("METROS:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_1.setBounds(94, 101, 92, 18);
		panelAltaArticulo.add(lblNewLabel_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("COSTO:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_1_1_1_1.setBounds(94, 131, 92, 18);
		panelAltaArticulo.add(lblNewLabel_1_1_1_1);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(10);
		txtCosto.setBounds(196, 130, 86, 20);
		panelAltaArticulo.add(txtCosto);
		
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
					
				TipoArticulo tipo = null;
				
				for(TipoArticulo t: TipoArticulo.values()) {
					if(t.toString().equals(comboTipoArticulo.getSelectedItem().toString()))
						tipo = t;
				}
				
				
				
				Articulo art = Controlador.crearArticulo(tipo, (int) Long.parseLong(txtStock.getText().toString()), 
						Double.parseDouble(txtMetros.getText().toString()));	
				
				txtStock.setText("");
				txtMetros.setText("");
				txtCosto.setText("");
				comboTipoArticulo.setSelectedIndex(0);
				txtEstado.setSelectedIndex(0);
				
				popUp p = new popUp("ARTICULO CON ID: " + art.getIdArticulo() + " REGISTRADO");
				p.setLocationRelativeTo(altaArticulo);
				p.setVisible(true);
				
				
				
			}
		});
		btnAltaArticulo.setBounds(152, 206, 142, 23);
		panelAltaArticulo.add(btnAltaArticulo);
	}

}
