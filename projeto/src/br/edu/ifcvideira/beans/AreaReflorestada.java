package br.edu.ifcvideira.beans;

public class AreaReflorestada {

	
	private Propriedade propriedade;
	private float tamanhoP;
	private float tamanhoR;
	private int quantidade;
	private String tipo;
	private String objetivo;
	private String observacao;
	private Arvore arvore;
	
	public Propriedade getPropriedade() {
		return propriedade;
	}
	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}
	public float getTamanhoP() {
		return tamanhoP;
	}
	public void setTamanhoP(float tamanhoP) {
		this.tamanhoP = tamanhoP;
	}
	public float getTamanhoR() {
		return tamanhoR;
	}
	public void setTamanhoR(float tamanhoR) {
		this.tamanhoR = tamanhoR;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Arvore getArvore() {
		return arvore;
	}
	public void setArvore(Arvore arvore) {
		this.arvore = arvore;
	}
	
	
	
	
}
