package br.com.projeto.teste;

import javax.swing.JOptionPane;

import br.com.projeto.beans.Candidato;

import br.com.projeto.dao.CandidatoDAO;

import br.com.projeto.dao.UsuarioDAO;
/*
 * @author Cyntia RM82273
 * 
 */
public class CadastroCandidatoDAO {
	public static void main(String[] args) {
		CandidatoDAO dao = null;
		Candidato candidato = null;
		
		try {
			dao = new CandidatoDAO();
			candidato = new Candidato();
			
			UsuarioDAO usuDAO = new UsuarioDAO();
			
			candidato.setNome(JOptionPane.showInputDialog("Nome"));
			candidato.setCpf(JOptionPane.showInputDialog("CPF"));
			candidato.setRg(JOptionPane.showInputDialog("RG"));
			candidato.setDataNasc(JOptionPane.showInputDialog("Data de Nascimento"));
			candidato.setDescricao(JOptionPane.showInputDialog("Breve descrição"));
			candidato.setUsuario(usuDAO.getUsuario(Integer.parseInt(JOptionPane.showInputDialog("Digite o código do usuario"))));
			
			dao.addCandidato(candidato);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}