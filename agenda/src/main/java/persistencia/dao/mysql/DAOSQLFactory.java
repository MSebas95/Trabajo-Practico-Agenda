/**
 * 
 */
package persistencia.dao.mysql;

import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;


public class DAOSQLFactory implements DAOAbstractFactory 
{
	/* (non-Javadoc)
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	public PersonaDAO createPersonaDAO() 
	{
				return new PersonaDAOSQL();
	}
	
	public TipoContactoDAO crearTipoContactoDAO()      
	{        
				return new TipoContactoDAOSQL();     
	}

	@Override
	public TipoContactoDAO createTipoContactoDAO() {
		// TODO Auto-generated method stub
		return new TipoContactoDAOSQL();
	}

}
