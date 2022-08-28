package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.GrupoMusicalDAO;
import dto.GrupoMusicalDTO;



public class GrupoMusicalDAOSQL implements GrupoMusicalDAO{
	private static final String readall = "SELECT * FROM GRUPO_MUSICAL";
	private static final String readReporte = "SELECT m.idGrupoMusical, m.grupo, count(p.idGrupoMusical) as cantidadGrupo FROM Personas p INNER JOIN GRUPO_MUSICAL m ON p.idGrupoMusical = m.idGrupoMusical group by m.grupo";

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
				grupoMusicalByName.put(grupo.getGrupo(), grupo);
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
		String grupo = resultSet.getString("grupo");
		GrupoMusicalDTO grupoMusical = new GrupoMusicalDTO(id, grupo);
				
		return grupoMusical; 
	}
	
	public List<GrupoMusicalDTO> readReporte() 
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<GrupoMusicalDTO> grupo = new ArrayList<GrupoMusicalDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readReporte);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				grupo.add(getGrupoMusicalDTOReporte(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return grupo;
	}
		
	private GrupoMusicalDTO getGrupoMusicalDTOReporte(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idGrupoMusical");
		String grupo = resultSet.getString("grupo");
		int cantGrupo = resultSet.getInt("cantidadGrupo");
		GrupoMusicalDTO grupoMusical = new GrupoMusicalDTO(id, grupo);
		grupoMusical.setCantidadGrupo(cantGrupo);		
		return grupoMusical; 
	}
	
	

}
