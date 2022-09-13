package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.PersonaDTO;


import javax.swing.JButton;

import persistencia.conexion.Conexion;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;

public class Vista
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private JButton btnReporteLugares;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"Nombre y apellido","Telefono", "Calle", "Localidad", "Altura", "Piso", "Depto", "Email", "Cumpleaños", "Tipo de contacto", "Grupo preferido", "Lugar preferido"};

	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1090, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 1070, 410);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setViewportBorder(new CompoundBorder());
		spPersonas.setBounds(22, 10, 1032, 282);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		tablaPersonas.setBackground(Color.WHITE);
		tablaPersonas.setForeground(new Color(0, 0, 0));
		tablaPersonas.setBorder(new LineBorder(new Color(51, 153, 255)));
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(new Color(0, 0, 0));
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setBounds(10, 370, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(0, 0, 0));
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(109, 370, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(0, 0, 0));
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setBounds(208, 370, 89, 23);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reportes");
		btnReporte.setForeground(new Color(0, 0, 0));
		btnReporte.setBackground(Color.WHITE);
		btnReporte.setBounds(307, 370, 89, 23);
		panel.add(btnReporte);
	}
	
	public void show()
	{
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "¿Estás seguro que quieres salir de la Agenda?", 
		             "Confirmación", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frame.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}
	
	public JButton getbtnEditar() 
	{
		return btnEditar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}


	public void llenarTabla(List<PersonaDTO> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (PersonaDTO p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String tel = p.getTelefono();
			String calle = p.getCalle();
			String localidad = p.getLocalidad();
			String altura = p.getAltura();
			String piso = p.getPiso();
			String depto = p.getDepto();
			String email = p.getEmail();
			String cumpleanios = p.getCumpleanios();
			String tipoContacto = p.getTipoContacto();
			String lugarTuristico = p.getLugar();
			String grupoMusical = p.getGrupo();
			System.out.println(grupoMusical);

			
			Object[] fila = {nombre, tel, calle, localidad, altura, piso, depto, email, cumpleanios, tipoContacto, grupoMusical,  lugarTuristico};
			this.getModelPersonas().addRow(fila);
		}
		
	}
	
	public void showError() {
		JOptionPane.showMessageDialog(this.frame, "Debe seleccionar una fila a modificar");
	}
	

}