package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LugarTuristicoDAO;
import persistencia.dao.interfaz.TipoContactoDAO;
import dto.LugarTuristicoDTO;
import dto.TipoContactoDTO;

public class LugarTuristicoDAOSQL implements LugarTuristicoDAO{
	private static final String readall = "SELECT * FROM LUGAR_TURISTICO";

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
				lugarTuristicoByName.put(lugar.getLugarTuristico(), lugar);
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
		String lugar = resultSet.getString("Lugares");
		LugarTuristicoDTO lugarTuristico = new LugarTuristicoDTO(id, lugar);
				
		return lugarTuristico; 
	}

}