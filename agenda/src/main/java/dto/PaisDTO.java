package dto;

public class PaisDTO {
	
	private int idPais;
	private String pais;
	
	public PaisDTO(int idPais, String pais)
	{
		this.idPais = idPais;
		this.pais = pais;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getPais() {
		return pais;
	}

	public void setProvincia(String pais) {
		this.pais = pais;
	}

}
