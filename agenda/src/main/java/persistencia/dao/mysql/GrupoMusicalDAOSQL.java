package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.GrupoMusicalDAO;
import persistencia.dao.interfaz.TipoContactoDAO;
import dto.GrupoMusicalDTO;
import dto.TipoContactoDTO;

public class GrupoMusicalDAOSQL implements GrupoMusicalDAO{
	private static final String readall = "SELECT * FROM GRUPO_MUSICAL";

	public HashMap<String, GrupoMusicalDTO> readAll() 
	{
		PreparedStatement statement;
		ResultSet resultSet;
		HashMap<String, GrupoMusicalDTO> grupoMusicalByName = new HashMap<String, GrupoMusicalDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				GrupoMusicalDTO grupo = getGrupoMusicalDTO(resultSet);
				grupoMusicalByName.put(grupo.getGrupoMusical(), grupo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return grupoMusicalByName;
	}
		
	private GrupoMusicalDTO getGrupoMusicalDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idGrupoMusical");
		String grupo = resultSet.getString("Grupo");
		GrupoMusicalDTO grupoMusical = new GrupoMusicalDTO(id, grupo);
				
		return grupoMusical; 
	}

}
