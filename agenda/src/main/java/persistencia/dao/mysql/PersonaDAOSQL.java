package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(nombre, telefono, idTipoContacto, idLocalidad, Calle, altura, piso , depto, email, cumpleaños, idGrupoMusical, idLugarTuristico) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String edit = "UPDATE PERSONAS SET Nombre = ?, Telefono = ?, idTipoContacto = ?, idLocalidad = ?, Calle = ?, altura = ?, piso = ?, depto = ?, email = ?, cumpleaños = ?, idGrupoMusical = ?, idLugarTuristico = ? WHERE idPersona = ?";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM Personas p INNER JOIN TIPO_CONTACTO t ON p.idTipoContacto = t.idTipoContacto INNER JOIN GRUPO_MUSICAL m ON p.idGrupoMusical = m.idGrupoMusical INNER JOIN LUGAR_TURISTICO q ON p.idLugarTuristico = q.idLugarTuristico INNER JOIN LOCALIDAD l ON p.idLocalidad = l.idLocalidad ORDER BY lugar";
	public boolean insert(PersonaDTO persona)
	{

		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setInt(3, persona.getTipoContactoId());
			statement.setString(4, persona.getIdLocalidad());
			statement.setString(5, persona.getCalle());
			statement.setString(6, persona.getAltura());
			statement.setString(7, persona.getPiso());
			statement.setString(8, persona.getDepto());
			statement.setString(9, persona.getEmail());
			statement.setString(10, persona.getCumpleanios());
			statement.setInt(11, persona.getGrupoId());
			statement.setInt(12, persona.getIdLugarTuristico());
			


			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean edit(PersonaDTO persona_a_editar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(edit);
			
			statement.setString(1, persona_a_editar.getNombre());
			statement.setString(2, persona_a_editar.getTelefono());
			statement.setInt(3, persona_a_editar.getTipoContactoId());
			statement.setString(4, persona_a_editar.getIdLocalidad());
			statement.setString(5, persona_a_editar.getCalle());
			statement.setString(6, persona_a_editar.getAltura());
			statement.setString(7, persona_a_editar.getPiso());
			statement.setString(8, persona_a_editar.getDepto());
			statement.setString(9, persona_a_editar.getEmail());
			statement.setString(10, persona_a_editar.getCumpleanios());
			statement.setInt(11, persona_a_editar.getGrupoId());
            statement.setInt(12, persona_a_editar.getIdLugarTuristico());
            statement.setInt(13, persona_a_editar.getIdPersona());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isEditExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isEditExitoso;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		
		PersonaDTO persona = new PersonaDTO(id, nombre, tel);
		persona.setCalle(resultSet.getString("calle"));
		persona.setAltura(resultSet.getString("altura"));
		persona.setPiso(resultSet.getString("piso"));
		persona.setDepto(resultSet.getString("depto"));
		persona.setEmail(resultSet.getString("email"));
		persona.setIdLocalidad(resultSet.getString("idLocalidad"));
		persona.setTipoContactoId(resultSet.getInt("idTipoContacto"));
		persona.setGrupoMusicalId(resultSet.getInt("idGrupoMusical"));
		persona.setIdLugarTuristico(resultSet.getInt("idLugarTuristico"));
		persona.setCumpleanios(resultSet.getString("cumpleaños"));
		persona.setTipoContacto(resultSet.getString("Tipo"));
		persona.setGrupo(resultSet.getString("grupo"));
		persona.setLugar(resultSet.getString("lugar"));
		persona.setLocalidad(resultSet.getString("localidad"));
		
		return persona; 
	}
	
}
