package br.com.projeto.teste;

import javax.swing.JOptionPane;

import br.com.projeto.beans.Moderador;
import br.com.projeto.dao.ModeradorDAO;
import br.com.projeto.dao.UsuarioDAO;
/*
 * @author Nicolas RM82331
 * 
 */
public class CadastroModeradorDAO {

	public static void main(String[] args) {
		ModeradorDAO dao = null;
		Moderador moderador = null;
		
		try {
			dao = new ModeradorDAO();
			moderador = new Moderador();
			
			UsuarioDAO usuDAO = new UsuarioDAO();
			
			moderador.setNomeModerador(JOptionPane.showInputDialog("Nome"));
			moderador.setCpfModerador(JOptionPane.showInputDialog("CPF"));
			moderador.setUnidade(JOptionPane.showInputDialog("Unidade"));
			moderador.setUsuario(usuDAO.getUsuario(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do usuario"))));
			
			dao.addModerador(moderador);
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