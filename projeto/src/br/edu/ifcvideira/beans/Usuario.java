package br.edu.ifcvideira.beans;

public class Usuario extends Pessoa {
	
	private String rgUsuario;
	private String senhaUsuario;
	private String loginUsuario;
	public static String loginUsuarioStatic;
	public static int IdUsuario;
	
	public Usuario(){
		
	}
	
	


	public String getrgUsuario() {
		return rgUsuario;
	}



	public void setrgUsuario(String rgUsuario) {
		this.rgUsuario = rgUsuario;
	}


	public String getsenhaUsuario() {
		return senhaUsuario;
	}



	public void setsenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}



	public String getloginUsuario() {
		return loginUsuario;
	}



	public void setloginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public static String getLoginUsuario() {
		return loginUsuarioStatic;
	}



	public static void setLoginUsuario(String loginUsuario) {
		Usuario.loginUsuarioStatic = loginUsuario;
	}



	public static int getIdusuario() {
		return IdUsuario;
	}



	public static void setIdusuario(int idUsuario) {
		Usuario.IdUsuario = idUsuario;
	}






	
	

}
