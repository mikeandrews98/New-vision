package br.com.projeto.bo;

import br.com.projeto.beans.Moderador;
/*
 * @author Nicolas RM82331
 * 
 */
public class ModeradorBO {
	
	public String novoModerador(Moderador mod) throws  Exception{
		if(mod.getCodUsuario()<=0) {
			return "Codigo Invalido";
		}
		
		//validações com login
		if((mod.getLogin().length() > 30) || (mod.getLogin().length() == 0)) {
			return "Nome inálido";
		}
		mod.setLogin(mod.getLogin().toUpperCase());
		
		//validações com senha
		if((mod.getSenha().length() > 50) || (mod.getSenha().length() == 0)) {
			return "senha invalida";
		}
		
		//validações com email
		if((mod.getEmail().length() > 150) || (mod.getEmail().length() == 0)) {
			return "Email invalida";
		}
		
		
		return "Ok";
	}
}