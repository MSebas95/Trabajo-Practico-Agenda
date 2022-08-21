package presentacion.vista;



import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import dto.TipoContactoDTO;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepto;
	private JTextField txtEmail;
	private JTextField txtCumpleaños;
	private JComboBox<String> txtTipoContacto;
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
	private List<TipoContactoDTO> tiposContactoLista;  
	
	public static VentanaPersona getInstance(List<TipoContactoDTO> lista)
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(lista); 	
			return new VentanaPersona(lista);
		}
		else
			return INSTANCE;
	}

	public List<TipoContactoDTO> getTiposContactoLista() {
		return tiposContactoLista;
	}

	public void setTiposContactoLista(List<TipoContactoDTO> tiposContactoLista) {
		this.tiposContactoLista = tiposContactoLista;
	}

	private VentanaPersona(List<TipoContactoDTO> lista) 
	{
		super();
		this.tiposContactoLista = lista;
		ArrayList<String> r = new ArrayList<String>();
		for (TipoContactoDTO t : this.tiposContactoLista) {
			r.add(t.getTipo());
		}
		String[] optionsToChoose = r.toArray(new String[this.tiposContactoLista.size()]);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 364, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 10, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 50, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 90, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 130, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 170, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblDepto = new JLabel("Departamento");
		lblDepto.setBounds(10, 210, 113, 14);
		panel.add(lblDepto);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 250, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblCumpleaños = new JLabel("Cumpleaños");
		lblCumpleaños.setBounds(10, 290, 113, 14);
		panel.add(lblCumpleaños);
		
		JLabel lblTipoContacto = new JLabel("Tipo de Contacto");
		lblTipoContacto.setBounds(10, 330, 113, 14);
		panel.add(lblTipoContacto);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 10, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 50, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(133, 90, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(133, 130, 164, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(133, 170, 164, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(133, 210, 164, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(133, 250, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCumpleaños = new JTextField();
		txtCumpleaños.setBounds(133, 290, 164, 20);
		panel.add(txtCumpleaños);
		txtCumpleaños.setColumns(10);
		
		txtTipoContacto = new JComboBox<>(optionsToChoose);
		txtTipoContacto.setBounds(133, 330, 164, 20);
		panel.add(txtTipoContacto);
		
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(210, 490, 89, 23);
		panel.add(btnAgregarPersona);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}
	
	public JTextField getTxtCalle() 
	{
		return txtCalle;
	}
	
	public JTextField getTxtAltura() 
	{
		return txtAltura;
	}
	
	public JTextField getTxtPiso() 
	{
		return txtPiso;
	}
	
	public JTextField getTxtDepto() 
	{
		return txtDepto;
	}
	
	public JTextField getTxtEmail() 
	{
		return txtEmail;
	}
	
	public JTextField getTxtCumpleaños() 
	{
		return txtCumpleaños;
	}
	
	public String getTxtTipoContacto() 
	{
		return (String) txtTipoContacto.getSelectedItem();
	}
	
	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtCalle.setText(null);
		this.txtAltura.setText(null);
		this.txtPiso.setText(null);
		this.txtDepto.setText(null);
		this.txtEmail.setText(null);
		this.txtCumpleaños.setText(null);
		this.txtTipoContacto.setSelectedItem(null);
		this.dispose();
	}
	
}

