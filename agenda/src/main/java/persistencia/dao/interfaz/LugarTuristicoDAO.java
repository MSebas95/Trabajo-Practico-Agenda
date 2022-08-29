package persistencia.dao.interfaz;
import java.util.HashMap;
import java.util.List;

import dto.LugarTuristicoDTO;

public interface LugarTuristicoDAO 
{
	
	public HashMap<String, LugarTuristicoDTO> readAll();
	
	//public List<LugarTuristicoDTO> readReporte(); 
}