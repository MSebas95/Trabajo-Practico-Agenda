package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LugarTuristicoDAO;
import dto.LugarTuristicoDTO;


public class LugarTuristicoDAOSQL implements LugarTuristicoDAO{
	private static final String readall = "SELECT * FROM LUGAR_TURISTICO";
	//private static final String readReporte = "SELECT l.idLugarTuristico, l.lugar, count(p.idLugarTuristico) as cantLugar FROM LUGAR_TURISTICO l INNER JOIN personas p ON p.idLugarTuristico = l.idLugarTuristico group by l.lugar";

	public HashMap<String, LugarTuristicoDTO> readAll() 
	{
		PreparedStatement statement;
		ResultSet resultSet;
		HashMap<String, LugarTuristicoDTO> lugarTuristicoByName = new HashMap<String, LugarTuristicoDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				LugarTuristicoDTO lugar = getLugarTuristicoDTO(resultSet);
				lugarTuristicoByName.put(lugar.getLugar(), lugar);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return lugarTuristicoByName;
	}
		
	private LugarTuristicoDTO getLugarTuristicoDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idLugarTuristico");
		String lugar = resultSet.getString("lugar");
		LugarTuristicoDTO lugarTuristico = new LugarTuristicoDTO(id, lugar);
				
		return lugarTuristico; 
	}
	
	/*public List<LugarTuristicoDTO> readReporte() 
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LugarTuristicoDTO> lugar = new ArrayList<LugarTuristicoDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readReporte);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				lugar.add(getLugarTuristicoDTOReporte(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return lugar;
	}
		
	private LugarTuristicoDTO getLugarTuristicoDTOReporte(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idLugarTuristico");
		String lugar = resultSet.getString("lugar");
		Integer cantLugar = resultSet.getInt("cantLugar");
		LugarTuristicoDTO lugarTuristico = new LugarTuristicoDTO(id, lugar);
		lugarTuristico.setCantLugar(cantLugar);		
		return lugarTuristico; 
	}*/

}