class Mensaje {
	String mensajeId;
	String asunto;
	String cuerpo;
	String emisor;
	UsuarioEmpresa receptor;

	public Mensaje(String asunto, String cuerpo, String emisor, UsuarioEmpresa receptor) {
		mensajeId = UUID.randomUUID().toString().replace("-", "").substring(0,6);
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.emisor = emisor;
		this.receptor = receptor;
	}
	
	public String toString() {
		return "Asunto: " + asunto + "\nCuerpa: " + cuerpo;
	}

	public String getMensajeId() {
		return mensajeId;
	}
	public String getAsunto() {
		return asunto;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public String getEmisor() {
		return emisor;
	}
	public String getReceptor() {
		return receptor;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public void setReceptor(UsuarioEmpresa receptor) {
		this.receptor = receptor;
	}
}
