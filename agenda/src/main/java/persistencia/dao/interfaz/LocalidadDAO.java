package persistencia.dao.interfaz;

import java.util.List;

import dto.LocalidadDTO;

public interface LocalidadDAO 
{
	public List<LocalidadDTO> readAll();
}
