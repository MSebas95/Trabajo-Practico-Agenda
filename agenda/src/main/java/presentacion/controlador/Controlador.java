package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.reportes.ReporteLugares;
import presentacion.reportes.ReporteMusical;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.GrupoMusicalDTO;
import dto.LocalidadDTO;
import dto.LugarTuristicoDTO;
import dto.PaisDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
import dto.TipoContactoDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private HashMap<String, TipoContactoDTO> tipoDeContactoByName;
		private HashMap<String, GrupoMusicalDTO> grupoMusicalByName;
		private HashMap<String, LugarTuristicoDTO> lugarTuristicoByName;
		private HashMap<String, LocalidadDTO> localidadByName;
		private HashMap<String, ProvinciaDTO> provinciaById;
		private HashMap<String, PaisDTO> paisById;
		private VentanaPersona ventanaPersona;
		private VentanaPersona ventanaPersonaEditar;
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getbtnEditar().addActionListener(s->editarPersona(s));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.vista.getBtnReporteLugares().addActionListener(r->mostrarReporteLugares(r));
			this.agenda = agenda;
			this.ventanaPersona = VentanaPersona.getInstance(this.agenda.obtenerTipoContacto(), this.agenda.obtenerLugarTuristico(), this.agenda.obtenerGrupoMusical());		
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
		}
		
		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
		}

		private void guardarPersona(ActionEvent p) {
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String tipoContacto = this.ventanaPersona.getContactTypeName();
			String localidadPersona = this.ventanaPersona.getLocalidadName();
			String callePersona = this.ventanaPersona.getCalle().getText();
			String alturaCalle = this.ventanaPersona.getAltura().getText();
			String piso = this.ventanaPersona.getPiso().getText();
			String depto = this.ventanaPersona.getDepto().getText();
			String email = this.ventanaPersona.getEmail().getText();
			String cumpleaños = ventanaPersona.getTxtCumpleaños().getText();
			String lugarTuristico = ventanaPersona.getPlaceTypeName();
			String grupoMusical = ventanaPersona.getBandTypeName();
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel);
			nuevaPersona.setTipoContactoId(tipoDeContactoByName.get(tipoContacto).getIdTipoContacto());
			nuevaPersona.setLocalidad(localidadByName.get(localidadPersona).getLocalidad());
			nuevaPersona.setIdLocalidad(localidadByName.get(localidadPersona).getIdLocalidad());
			nuevaPersona.setCalle(callePersona);
			nuevaPersona.setAltura(alturaCalle);
			nuevaPersona.setPiso(piso);
			nuevaPersona.setDepto(depto);
			nuevaPersona.setEmail(email);
			nuevaPersona.setCumpleanios(cumpleaños);
			nuevaPersona.setLugarTuristicoId(lugarTuristicoByName.get(lugarTuristico).getIdLugarTuristico());
			nuevaPersona.setGrupoMusicalId(grupoMusicalByName.get(grupoMusical).getIdGrupoMusical());
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
			
		}

		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}
		
		private void mostrarReporteLugares(ActionEvent r) {
			ReporteLugares reporte = new ReporteLugares(agenda.obtenerPersonas());
			reporte.mostrar();	
		}
		
		private void mostrarReporteMusical(ActionEvent r) {
			ReporteMusical reporte = new ReporteMusical(agenda.obtenerPersonas());
			reporte.mostrar();	
		}
		
		public void editarPersona(ActionEvent s)
		{
			if (this.vista.getTablaPersonas().getSelectedRow() >= 0 ) {
				PersonaDTO persona = this.personasEnTabla.get(this.vista.getTablaPersonas().getSelectedRow());
				this.ventanaPersonaEditar = VentanaPersona.getInstance(this.agenda.obtenerTipoContacto(), this.agenda.obtenerLugarTuristico(), this.agenda.obtenerGrupoMusical() ,persona);		
				this.ventanaPersonaEditar.getBtnEditarPersona().addActionListener(e->editarPersona(e, persona.getIdPersona()));
				
				this.ventanaPersonaEditar.mostrarVentana();
			} else {
				this.vista.showError();
			}
		}
		
		private void editarPersona(ActionEvent p, int idPersona) {
			String nombre = this.ventanaPersonaEditar.getTxtNombre().getText();
			String tel = ventanaPersonaEditar.getTxtTelefono().getText();
			String tipoContacto = this.ventanaPersonaEditar.getContactTypeName();
			String localidadPersona = this.ventanaPersonaEditar.getLocalidadName();
			String callePersona = this.ventanaPersonaEditar.getCalle().getText();
			String alturaCalle = this.ventanaPersonaEditar.getAltura().getText();
			String piso = this.ventanaPersonaEditar.getPiso().getText();
			String depto = this.ventanaPersonaEditar.getDepto().getText();
			String email = this.ventanaPersonaEditar.getEmail().getText();
			String cumpleaños = this.ventanaPersonaEditar.getTxtCumpleaños().getText();
			//String lugarTuristico = this.ventanaPersonaEditar
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel);
			nuevaPersona.setTipoContactoId(tipoDeContactoByName.get(tipoContacto).getIdTipoContacto());
			nuevaPersona.setLocalidad(localidadByName.get(localidadPersona).getLocalidad());
			nuevaPersona.setIdLocalidad(localidadByName.get(localidadPersona).getIdLocalidad());
			nuevaPersona.setCalle(callePersona);
			nuevaPersona.setAltura(alturaCalle);
			nuevaPersona.setPiso(piso);
			nuevaPersona.setDepto(depto);
			nuevaPersona.setEmail(email);
			nuevaPersona.setCumpleanios(cumpleaños);
			nuevaPersona.setIdPersona(idPersona);
			this.agenda.editarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersonaEditar.cerrar();
		}

		public void borrarPersona(ActionEvent s)
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}
			
			this.refrescarTabla();
		}
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonas();
			this.tipoDeContactoByName = agenda.obtenerTipoContacto();
			this.lugarTuristicoByName = agenda.obtenerLugarTuristico();
			this.localidadByName = agenda.obtenerLocalidades();
			this.provinciaById = agenda.obtenerProvincias();
			this.paisById = agenda.obtenerPaises();
			this.ventanaPersona.llenarTipoContacto(this.tipoDeContactoByName);
		
			
			this.vista.llenarTabla(this.personasEnTabla);
		}
		

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
