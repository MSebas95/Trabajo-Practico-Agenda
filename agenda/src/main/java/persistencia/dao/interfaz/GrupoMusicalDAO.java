package persistencia.dao.interfaz;
import java.util.HashMap;
import java.util.List;

import dto.GrupoMusicalDTO;

public interface GrupoMusicalDAO 
{	
	public HashMap<String, GrupoMusicalDTO> readAll();
	
	public List<GrupoMusicalDTO> readReporte();
}