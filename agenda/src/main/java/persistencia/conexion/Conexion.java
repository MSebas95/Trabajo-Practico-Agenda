package persistencia.conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;



public class Conexion 
{
	private String user;
	private String pass;
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);	
	
	private Conexion()
	{
		try
		{
			cargarUsuario();
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda",user,pass);
			this.connection.setAutoCommit(false);
			log.info("Conexión exitosa");
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
	
	public void cargarUsuario() 
	{
		File file = new File("config_login.txt");
		try 
		{
			try (BufferedReader br = new BufferedReader(new FileReader(file)))
			{
				String line;
				while ((line = br.readLine()) != null) 
				{
					if(user == null) {
						user = line;
					}
					else {
						pass = line;
					}
					System.out.println(user+"/"+pass);
				}
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
