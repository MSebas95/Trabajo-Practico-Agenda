package persistencia.dao.interfaz;


public interface DAOAbstractFactory 
{
	public PersonaDAO createPersonaDAO();
	
	public TipoContactoDAO createTipoContactoDAO();
	
	public LocalidadDAO createLocalidadDAO();
	
	public ProvinciaDAO createProvinciaDAO();
	
	public PaisDAO createPaisDAO();
	
	public LugarTuristicoDAO createLugarTuristicoDAO();
	
	public GrupoMusicalDAO createGrupoMusicalDAO();
	
	public UbicacionDAO createUbicacionDAO();
}

