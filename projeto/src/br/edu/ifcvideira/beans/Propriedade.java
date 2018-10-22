package br.edu.ifcvideira.beans;


public class Propriedade {
	private int id;
	private String endereco;
	private float metragem;
	private String zona;
	private float multa;
	private Usuario idCodigoUsuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public float getMetragem() {
		return metragem;
	}
	public void setMetragem(float metragem) {
		this.metragem = metragem;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public float getMulta() {
		return multa;
	}
	public void setMulta(float multa) {
		this.multa = multa;
	}
	public Usuario getIdCodigoUsuario() {
		return idCodigoUsuario;
	}
	public void setIdCodigoUsuario(Usuario idCodigoUsuario) {
		this.idCodigoUsuario = idCodigoUsuario;
	}


	



}
