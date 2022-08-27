package dto;

public class LugarTuristicoDTO {
	
	private int idLugarTuristico;
	private String lugar;
	
	public LugarTuristicoDTO(int idLugarTuristico, String lugar)
	{
		this.idLugarTuristico = idLugarTuristico;
		this.lugar = lugar;
	}

	public int getIdLugarTuristico() {
		return idLugarTuristico;
	}

	public void setIdLugarTuristico(int idLugarTuristico) {
		this.idLugarTuristico = idLugarTuristico;
	}

	public String getLugarTuristico() {
		return lugar;
	}

	public void setLugarTuristico(String lugar) {
		this.lugar = lugar;
	}

}
