package modelo;

import java.util.HashMap;
import java.util.List;

import dto.GrupoMusicalDTO;
import dto.LocalidadDTO;
import dto.LugarTuristicoDTO;
import dto.PaisDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
import dto.TipoContactoDTO;
import dto.UbicacionDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.GrupoMusicalDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.LugarTuristicoDAO;
import persistencia.dao.interfaz.PaisDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.ProvinciaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;
import persistencia.dao.interfaz.UbicacionDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	private TipoContactoDAO tipoContacto;
	private LugarTuristicoDAO lugarTuristico;
	private GrupoMusicalDAO grupoMusical;
	private LocalidadDAO localidad;
	private ProvinciaDAO provincia;
	private PaisDAO pais;
	private UbicacionDAO ubicacion;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.tipoContacto = metodo_persistencia.createTipoContactoDAO();
		this.lugarTuristico = metodo_persistencia.createLugarTuristicoDAO();
		this.grupoMusical = metodo_persistencia.createGrupoMusicalDAO();
		this.localidad = metodo_persistencia.createLocalidadDAO();
		this.provincia = metodo_persistencia.createProvinciaDAO();
		this.pais = metodo_persistencia.createPaisDAO();
		this.ubicacion = metodo_persistencia.createUbicacionDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}
	
	public void editarPersona(PersonaDTO persona_a_editar) 
	{
		this.persona.edit(persona_a_editar);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	
	public HashMap<String, TipoContactoDTO> obtenerTipoContacto()
	{
		return this.tipoContacto.readAll();	
	}
	
	
	public HashMap<String, LugarTuristicoDTO> obtenerLugarTuristico()
	{
		return this.lugarTuristico.readAll();	
	}
	
	public HashMap<String, GrupoMusicalDTO> obtenerGrupoMusical()
	{
		return this.grupoMusical.readAll();	
	}
	
	
	public HashMap<String, LocalidadDTO> obtenerLocalidades()
	{
		return this.localidad.readAll();	
	}
	
	public HashMap<String, ProvinciaDTO> obtenerProvincias()
	{
		return this.provincia.readAll();	
	}
	
	public HashMap<String, PaisDTO> obtenerPaises()
	{
		return this.pais.readAll();	
	}
	
	public UbicacionDTO obtenerUbicaciones()
	{
		return this.ubicacion.readAll();	
	}
	
}
