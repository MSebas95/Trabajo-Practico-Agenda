package persistencia.dao.interfaz;
import java.util.HashMap;

import dto.GrupoMusicalDTO;

public interface GrupoMusicalDAO 
{	
	public HashMap<String, GrupoMusicalDTO> readAll();
}