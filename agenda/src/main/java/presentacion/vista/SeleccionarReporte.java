package presentacion.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SeleccionarReporte extends JFrame {

	private static SeleccionarReporte INSTANCE;
	private JPanel contentPane;
	private JButton BtnLugarTuristico;
	private JButton BtnGrupoMusical;
	
	public static SeleccionarReporte getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new SeleccionarReporte(); 	
			return new SeleccionarReporte();
		}
		else
			return new SeleccionarReporte();
	}
	
	private SeleccionarReporte() {
		
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 526, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPregunta = new JLabel("Seleccione el reporte");
		lblPregunta.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPregunta.setBounds(160, 35, 220, 35);
		panel.add(lblPregunta);
		
		BtnLugarTuristico = new JButton("Lugar Turistico");
		BtnLugarTuristico.setBounds(130, 70, 220, 35);
		panel.add(BtnLugarTuristico);
		
		BtnGrupoMusical = new JButton("Grupo Musical");
		BtnGrupoMusical.setBounds(130, 130, 220, 35);
		panel.add(BtnGrupoMusical);
		
		this.setVisible(false);
	}

	public JButton getBtnLugarTuristico() {
		return BtnLugarTuristico;
	}

	public void setBtnLugarTuristico(JButton BtnLugarTuristico) {
		this.BtnLugarTuristico = BtnLugarTuristico;
	}

	public JButton getBtnGrupoMusical() {
		return BtnGrupoMusical;
	}

	public void setBtnGrupoMusical(JButton BtnGrupoMusical) {
		this.BtnGrupoMusical = BtnGrupoMusical;
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public void ocultarVentana()
	{
		this.setVisible(false);
	}
}
