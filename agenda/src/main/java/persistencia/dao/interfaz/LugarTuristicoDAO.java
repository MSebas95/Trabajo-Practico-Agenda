package persistencia.dao.interfaz;
import java.util.HashMap;

import dto.LugarTuristicoDTO;

public interface LugarTuristicoDAO 
{
	
	public HashMap<String, LugarTuristicoDTO> readAll();
}