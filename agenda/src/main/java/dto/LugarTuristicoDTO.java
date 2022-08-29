package dto;

public class LugarTuristicoDTO {
	
	private int idLugarTuristico;
	private String lugar;
	//private Integer cantLugar;
	
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

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/*public Integer getCantLugar() {
		return cantLugar;
	}

	public void setCantLugar(Integer cantLugar) {
		this.cantLugar = cantLugar;
	}*/

}
