package presentacion.vista;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import dto.TipoContactoDTO;
import dto.UbicacionDTO;
import dto.GrupoMusicalDTO;
import dto.LocalidadDTO;
import dto.LugarTuristicoDTO;
import dto.PaisDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
import java.awt.Color;


public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField Email;
	private JTextField calle;
	private JTextField altura;
	private JTextField piso;
	private JTextField depto;
	private JTextField txtCumpleaños;
	private JButton btnAgregarPersona;
	private JButton btnEditarPersona;
	private JComboBox tipoContactoComboBox;
	private JComboBox lugarTuristicoComboBox;
	private JComboBox grupoMusicalComboBox;
	private static VentanaPersona INSTANCE;
	private static VentanaPersona INSTANCE_EDITAR;
	private JComboBox pais;
	private JComboBox provincia;
	private JComboBox localidad;
	private HashMap<String, TipoContactoDTO> tipoContactoByName;
	private HashMap<String, LugarTuristicoDTO> lugarTuristicoByName;
	private HashMap<String, GrupoMusicalDTO> grupoMusicalByName;
	List<LocalidadDTO> localidades;
	UbicacionDTO ubicacion;


	
	public static VentanaPersona getInstance(HashMap<String, TipoContactoDTO> tipoContactoByName, HashMap<String, LugarTuristicoDTO> lugarTuristicoByName,  HashMap<String, GrupoMusicalDTO> grupoMusicalByName, UbicacionDTO ubicacion)
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(tipoContactoByName, lugarTuristicoByName, grupoMusicalByName, ubicacion); 	
			return new VentanaPersona(tipoContactoByName, lugarTuristicoByName, grupoMusicalByName, ubicacion);
		}
		else
			return INSTANCE;
	}
	
	public static VentanaPersona getInstance(HashMap<String, TipoContactoDTO> tipoContactoByName,HashMap<String, LugarTuristicoDTO> lugarTuristicoByName, HashMap<String, GrupoMusicalDTO> grupoMusicalByName , PersonaDTO persona, ArrayList<String> datosUbicacion, UbicacionDTO ubicacion)
	{
		INSTANCE_EDITAR = new VentanaPersona(tipoContactoByName ,lugarTuristicoByName, grupoMusicalByName , persona, datosUbicacion, ubicacion); 	
		return new VentanaPersona(tipoContactoByName ,lugarTuristicoByName, grupoMusicalByName , persona, datosUbicacion, ubicacion);
	}

	/**
	 * @wbp.parser.constructor
	 */
	private VentanaPersona(HashMap<String, TipoContactoDTO> tipoContactoByName, HashMap<String, LugarTuristicoDTO> lugarTuristicoByName, HashMap<String, GrupoMusicalDTO> grupoMusicalByName, UbicacionDTO ubicacion) 
	{
		super();
		
		this.tipoContactoByName = tipoContactoByName;
		this.lugarTuristicoByName = lugarTuristicoByName;
		this.grupoMusicalByName = grupoMusicalByName;
		this.ubicacion = ubicacion;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 500, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 10, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 50, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblCumpleanios = new JLabel("Cumpleaños");
		lblCumpleanios.setBounds(10, 90, 113, 14);
		panel.add(lblCumpleanios);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 130, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 170, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 210, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 250, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(10, 290, 113, 14);
		panel.add(lblDepto);
		
		String[] tipoContacto = this.tipoContactoByName.keySet().toArray(new String[this.tipoContactoByName.keySet().size()]);
		JLabel lblTipoContacto = new JLabel("Tipo de contacto");
		lblTipoContacto.setBounds(10,330,113,14);
		panel.add(lblTipoContacto);
		
		this.tipoContactoComboBox  = new JComboBox(tipoContacto);
		tipoContactoComboBox.setBounds(133, 330, 113, 23);
		panel.add(tipoContactoComboBox);
		
		String[] lugares = this.lugarTuristicoByName.keySet().toArray(new String[this.lugarTuristicoByName.keySet().size()]);
		JLabel lblLugares = new JLabel("Lugar preferido");
		lblLugares.setBounds(10,490,113,14);
		panel.add(lblLugares);
		
		this.lugarTuristicoComboBox  = new JComboBox(lugares);
		lugarTuristicoComboBox.setBounds(133, 490, 113, 23);
		panel.add(lugarTuristicoComboBox);
		
		String[] grupos = this.grupoMusicalByName.keySet().toArray(new String[this.grupoMusicalByName.keySet().size()]);
		JLabel lblGrupos = new JLabel("Grupo musical");
		lblGrupos.setBounds(10,530,113,14);
		panel.add(lblGrupos);
		
		this.grupoMusicalComboBox  = new JComboBox(grupos);
		grupoMusicalComboBox.setBounds(133, 530, 113, 23);
		panel.add(grupoMusicalComboBox);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 10, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 50, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCumpleaños = new JTextField();
		txtCumpleaños.setBounds(133, 90, 164, 20);
		panel.add(txtCumpleaños);
		txtCumpleaños.setColumns(10);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(133, 130, 164, 20);
		panel.add(Email);
		
		
		calle = new JTextField();
		calle.setColumns(10);
		calle.setBounds(133, 170, 164, 20);
		panel.add(calle);
		
		altura = new JTextField();
		altura.setColumns(10);
		altura.setBounds(133, 210, 64, 20);
		panel.add(altura);
		
		piso = new JTextField();
		piso.setColumns(10);
		piso.setBounds(133, 250, 64, 20);
		panel.add(piso);
		
		depto = new JTextField();
		depto.setColumns(10);
		depto.setBounds(133, 290, 64, 20);
		panel.add(depto);
		
	
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBackground(new Color(255, 255, 255));
		btnAgregarPersona.setBounds(326, 567, 89, 23);
		panel.add(btnAgregarPersona);
		
		pais = new JComboBox();
		pais.setBounds(133, 370, 258, 23);
		panel.add(pais);
		
		provincia = new JComboBox();
		provincia.setBounds(133, 410, 258, 23);
		panel.add(provincia);
		
		localidad = new JComboBox();
		localidad.setBounds(133, 450, 258, 23);
		panel.add(localidad);
		
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(10, 370, 113, 14);
		panel.add(lblPais);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 410, 113, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 450, 113, 14);
		panel.add(lblLocalidad);
		
		
		cargarPaises();
		cargarProvincias();
		cargarLocalidades();
		this.pais.addActionListener(e -> cargarProvincias());
		this.provincia.addActionListener(x -> cargarLocalidades());
		
		this.setVisible(false);
	}
	
	private VentanaPersona(HashMap<String, TipoContactoDTO> tipoContactoByName,HashMap<String, LugarTuristicoDTO> lugarTuristicoByName, HashMap<String, GrupoMusicalDTO> grupoMusicalByName , PersonaDTO persona, ArrayList<String> datosUbicacion, UbicacionDTO ubicacion){
		super();
		
		this.tipoContactoByName = tipoContactoByName;
		this.tipoContactoByName = tipoContactoByName;
        this.lugarTuristicoByName = lugarTuristicoByName;
        this.grupoMusicalByName = grupoMusicalByName;
        this.ubicacion = ubicacion;
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 500, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 10, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 50, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblCumpleanios = new JLabel("Cumpleaños");
		lblCumpleanios.setBounds(10, 90, 113, 14);
		panel.add(lblCumpleanios);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 130, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 170, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 210, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 250, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(10, 290, 113, 14);
		panel.add(lblDepto);
		//-----------------------------------
		String[] tipoContacto = this.tipoContactoByName.keySet().toArray(new String[this.tipoContactoByName.keySet().size()]);
		JLabel lblTipoContacto = new JLabel("Tipo de contacto");
		lblTipoContacto.setBounds(10,330,113,14);
		panel.add(lblTipoContacto);
		
		this.tipoContactoComboBox  = new JComboBox(tipoContacto);
		tipoContactoComboBox.setBounds(133, 330, 113, 23);
		panel.add(tipoContactoComboBox);
		
		String[] lugares = this.lugarTuristicoByName.keySet().toArray(new String[this.lugarTuristicoByName.keySet().size()]);
		JLabel lblLugares = new JLabel("Lugar preferido");
		lblLugares.setBounds(10,490,113,14);
		panel.add(lblLugares);
		
		this.lugarTuristicoComboBox  = new JComboBox(lugares);
		lugarTuristicoComboBox.setBounds(133, 490, 113, 23);
		panel.add(lugarTuristicoComboBox);
		
		String[] grupos = this.grupoMusicalByName.keySet().toArray(new String[this.grupoMusicalByName.keySet().size()]);
		JLabel lblGrupos = new JLabel("Grupo musical");
		lblGrupos.setBounds(10,530,113,14);
		panel.add(lblGrupos);
		
		this.grupoMusicalComboBox  = new JComboBox(grupos);
		grupoMusicalComboBox.setBounds(133, 530, 113, 23);
		panel.add(grupoMusicalComboBox);
		//-----------------------------------
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 10, 164, 20);
		txtNombre.setText(persona.getNombre());
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 50, 164, 20);
		txtTelefono.setText(persona.getTelefono());
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCumpleaños = new JTextField();
		txtCumpleaños.setBounds(133, 90, 164, 20);
		txtCumpleaños.setText(persona.getCumpleanios());
		panel.add(txtCumpleaños);
		txtCumpleaños.setColumns(10);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(133, 130, 164, 20);
		Email.setText(persona.getEmail());
		panel.add(Email);
		
		
		calle = new JTextField();
		calle.setColumns(10);
		calle.setBounds(133, 170, 164, 20);
		calle.setText(persona.getCalle());
		panel.add(calle);
		
		altura = new JTextField();
		altura.setColumns(10);
		altura.setBounds(133, 210, 64, 20);
		altura.setText(persona.getAltura());
		panel.add(altura);
		
		piso = new JTextField();
		piso.setColumns(10);
		piso.setBounds(133, 250, 64, 20);
		piso.setText(persona.getPiso());
		panel.add(piso);
		
		depto = new JTextField();
		depto.setColumns(10);
		depto.setBounds(133, 290, 64, 20);
		depto.setText(persona.getDepto());
		panel.add(depto);
		
		
	
		btnEditarPersona = new JButton("Editar");
		btnEditarPersona.setBackground(new Color(255, 255, 255));
		btnEditarPersona.setBounds(322, 567, 89, 23);
		panel.add(btnEditarPersona);
		
		pais = new JComboBox();
		pais.setBounds(133, 370, 258, 23);
		panel.add(pais);
		
		provincia = new JComboBox();
		provincia.setBounds(133, 410, 258, 23);
		panel.add(provincia);
		
		localidad = new JComboBox();
		localidad.setBounds(133, 450, 258, 23);
		panel.add(localidad);
		
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(10, 370, 113, 14);
		panel.add(lblPais);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 410, 113, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 450, 113, 14);
		panel.add(lblLocalidad);
		
		
		cargarPaises();
		cargarProvincias();
		cargarLocalidades();
		this.pais.addActionListener(e -> cargarProvincias());
		this.provincia.addActionListener(x -> cargarLocalidades());


		this.setVisible(false);
	}
	
	public JTextField getPiso() {
		return piso;
	}

	public void setPiso(JTextField piso) {
		this.piso = piso;
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
	
	public String getContactTypeName() {
		return tipoContactoComboBox.getSelectedItem().toString();

	}
	
	public String getPlaceTypeName() {
		return lugarTuristicoComboBox.getSelectedItem().toString();

	}
	
	public String getBandTypeName() {
		return grupoMusicalComboBox.getSelectedItem().toString();

	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}
	
	public JButton getBtnEditarPersona() 
	{
		return btnEditarPersona;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtCumpleaños.setText(null);
		this.Email.setText(null);
		this.calle.setText(null);
		this.altura.setText(null);
		this.piso.setText(null);
		this.depto.setText(null);
		this.Email.setText(null);
		this.dispose();
	}
	
	public void llenarTipoContacto(HashMap<String, TipoContactoDTO> tipoContactoByName) {
		this.tipoContactoByName = tipoContactoByName;
	}
	
	public void llenarLugarTuristico(HashMap<String, LugarTuristicoDTO> lugarTuristicoByName) {
		System.out.println("----Lugar-----");
		this.lugarTuristicoByName = lugarTuristicoByName;
	}
	
	public void llenarGrupoMusical(HashMap<String, GrupoMusicalDTO> grupoMusicalByName) {
		System.out.println("----Grupo-----");
		this.grupoMusicalByName = grupoMusicalByName;
	}
	
	
	private void cargarPaises() {
		this.pais.removeAllItems();
		for(PaisDTO pais: ubicacion.getPaises()) {
			//this.pais.add(p.getValor(), p.getId());
			String item = pais.getIdPais()+"-"+pais.getPais();
			this.pais.addItem(item);
		}
	}
	
	private void cargarProvincias() {
		this.provincia.removeAllItems();
		if(this.pais.getSelectedItem() != null) {
			String foreingKey = getPrimaryKeyPais(this.pais.getSelectedItem().toString());
			List<ProvinciaDTO> todasProvincias = ubicacion.getProvincias(foreingKey);
			if(!todasProvincias.isEmpty()) {
				for(ProvinciaDTO provincia : todasProvincias) {
					this.provincia.addItem(provincia.getIdPais()+"-"+provincia.getIdProvincia()+"-"+provincia.getProvincia());
				}
			}
		}
	}
	
	private void cargarLocalidades() {
		this.localidad.removeAllItems();
		if(this.provincia.getSelectedItem() != null) {
			String foreingKey = getPrimaryKeyLocalidadOrProvince(this.provincia.getSelectedItem().toString());
			List<LocalidadDTO> todasLocalidades = ubicacion.getLocalidades(foreingKey);
			if(!todasLocalidades.isEmpty()) {
				for(LocalidadDTO localidad : todasLocalidades) {
					this.localidad.addItem(localidad.getIdProvincia()+"-"+localidad.getIdLocalidad()+"-"+localidad.getLocalidad());	
				}
			}
		}
	}
	
	public String getPrimaryKeyPais(String S) {
		String[] parts = S.split("-");
		return parts[0];
	}
	
	public String getPrimaryKeyLocalidadOrProvince(String S) {
		String[] parts = S.split("-");
		return parts[1];
	}

	public String getLocalidadName() {
		return localidad.getSelectedItem().toString().split("-")[2];
	}
	
	
	public JTextField getEmail() {
		return Email;
	}

	public void setEmail(JTextField email) {
		Email = email;
	}

	public JTextField getCalle() {
		return calle;
	}
	
	public JTextField getTxtCumpleaños() 
	{
		return txtCumpleaños;
	}

	public void setCalle(JTextField calle) {
		this.calle = calle;
	}

	public JTextField getAltura() {
		return altura;
	}

	public void setAltura(JTextField altura) {
		this.altura = altura;
	}

	public JTextField getDepto() {
		return depto;
	}

	public void setDepto(JTextField depto) {
		this.depto = depto;
	}

	public JComboBox getLocalidad() {
		return localidad;
	}

	public void setLocalidad(JComboBox localidad) {
		this.localidad = localidad;
	}
	

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
	
	public void llenaUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}

	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}

