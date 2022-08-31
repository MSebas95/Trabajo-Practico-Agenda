package dto;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String calle;
	private String altura;
	private String piso;
	private String depto;
	private String email;
	private String cumpleanios;
	private int tipoContactoId;
    private String tipoContacto;
    private String idLocalidad;
    private String Localidad;
    private String provincia;
	private String pais;
    private Integer idLugarTuristico;
    private String lugar;
    private int grupoId;
    private String grupo;
    

	public PersonaDTO(int idPersona, String nombre, String telefono, String calle, String altura, String piso, String depto, String email, String cumpleanios, int tipoContactoId, String tipoContacto, String idLocalidad, String Localidad, int lugarId, String lugarPreferido, int grupoId, String grupoPreferido)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.depto = depto;
		this.email = email;
		this.cumpleanios = cumpleanios;
		this.tipoContactoId = tipoContactoId;
		this.tipoContacto = tipoContacto;
		this.idLocalidad = idLocalidad;
		this.Localidad = Localidad;
		this.idLugarTuristico = lugarId;
		this.grupoId = grupoId;
		this.lugar = lugarPreferido;
		this.grupo = grupoPreferido;
	}
	
	public PersonaDTO(int idPersona, String nombre, String telefono)
    {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.telefono = telefono;
    }
	
	
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCumpleanios() {
		return cumpleanios;
	}

	public void setCumpleanios(String cumpleanios) {
		this.cumpleanios = cumpleanios;
	}

	public int getTipoContactoId() {
		return tipoContactoId;
	}

	public void setTipoContactoId(int tipoContactoId) {
		this.tipoContactoId = tipoContactoId;
	}
	
	
	public void setGrupoMusicalId(int grupoId) {
		this.grupoId = grupoId;
	}

	public String getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(String idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	
	

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}



	public int getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupoPreferido) {
		this.grupo = grupoPreferido;
	}


	public Integer getIdLugarTuristico() {
		return idLugarTuristico;
	}

	public void setIdLugarTuristico(Integer idLugarTuristico) {
		this.idLugarTuristico = idLugarTuristico;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}



	

}
