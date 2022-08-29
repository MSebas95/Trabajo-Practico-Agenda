package persistencia.dao.interfaz;

import java.util.List;

import dto.PersonaDTO;

public interface PersonaDAO 
{
	
	public boolean insert(PersonaDTO persona);
	
	public boolean edit(PersonaDTO persona_a_editar);

	public boolean delete(PersonaDTO persona_a_eliminar);
	
	public List<PersonaDTO> readAll();
	
	public List<PersonaDTO> readReporteLugar();
	
	public List<PersonaDTO> readReporteGrupo();
}