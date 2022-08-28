package dto;

public class GrupoMusicalDTO {
	
	private int idGrupoMusical;
	private String grupo;
	private Integer cantidadGrupo;
	
	public GrupoMusicalDTO(int idGrupoMusical, String grupo)
	{
		this.idGrupoMusical = idGrupoMusical;
		this.grupo = grupo;
	}
	


	public int getIdGrupoMusical() {
		return idGrupoMusical;
	}

	public void setIdGrupoMusical(int idGrupoMusical) {
		this.idGrupoMusical = idGrupoMusical;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public int getCantidadGrupo() {
		return cantidadGrupo;
	}



	public void setCantidadGrupo(Integer cantidadGrupo) {
		this.cantidadGrupo = cantidadGrupo;
	}

}
