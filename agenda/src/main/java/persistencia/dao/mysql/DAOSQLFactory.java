/**
 * 
 */
package persistencia.dao.mysql;

import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.GrupoMusicalDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.LugarTuristicoDAO;
import persistencia.dao.interfaz.PaisDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.ProvinciaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;
import persistencia.dao.interfaz.UbicacionDAO;

public class DAOSQLFactory implements DAOAbstractFactory 
{
	/* (non-Javadoc)
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	public PersonaDAO createPersonaDAO() 
	{
		return new PersonaDAOSQL();
	}
	
	public TipoContactoDAO createTipoContactoDAO() 
	{
		return new TipoContactoDAOSQL();
	}
	
	public LocalidadDAO createLocalidadDAO() 
	{
		return new LocalidadDAOSQL();
	}
	
	public ProvinciaDAO createProvinciaDAO() 
	{
		return new ProvinciaDAOSQL();
	}
	
	public PaisDAO createPaisDAO() 
	{
		return new PaisDAOSQL();
	}
	
	public LugarTuristicoDAO createLugarTuristicoDAO() 
	{
		return new LugarTuristicoDAOSQL();
	}
	
	public GrupoMusicalDAO createGrupoMusicalDAO() 
	{
		return new GrupoMusicalDAOSQL();
	}
	
	public UbicacionDAO createUbicacionDAO() 
	{
		return new UbicacionDAOSQL();
	}

}