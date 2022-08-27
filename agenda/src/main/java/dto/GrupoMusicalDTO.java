package dto;

public class GrupoMusicalDTO {
	
	private int idGrupoMusical;
	private String grupo;
	
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

	public String getGrupoMusical() {
		return grupo;
	}

	public void setGrupoMusical(String grupo) {
		this.grupo = grupo;
	}

}
