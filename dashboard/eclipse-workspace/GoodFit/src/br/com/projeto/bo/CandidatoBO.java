package br.com.projeto.bo;

import br.com.projeto.beans.Candidato;

/*
 * @author Cyntia RM82273
 * 
 */
public class CandidatoBO {
	
	public String novoCandidato(Candidato cand) throws  Exception{
		if(cand.getCodUsuario()<=0) {
			return "Codigo Invalido";
		}
		
		//validações com login
		if((cand.getLogin().length() > 30) || (cand.getLogin().length() == 0)) {
			return "Nome inálido";
		}
		cand.setLogin(cand.getLogin().toUpperCase());
		
		//validações com senha
		if((cand.getSenha().length() > 50) || (cand.getSenha().length() == 0)) {
			return "senha invalida";
		}
		
		//validações com email
		if((cand.getEmail().length() > 150) || (cand.getEmail().length() == 0)) {
			return "Email invalida";
		}
		
		
		return "Ok";
	}
}