package br.com.projeto.teste;

import javax.swing.JOptionPane;

import br.com.projeto.beans.Usuario;
import br.com.projeto.dao.EnderecoDAO;
import br.com.projeto.dao.NivelUsuarioDAO;
import br.com.projeto.dao.UsuarioDAO;
/*
 * @author Vanessa RM83690
 * 
 */
public class CadastroUsuarioDAO {

	public static void main(String[] args) {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario();
			EnderecoDAO endDAO = new EnderecoDAO();
			NivelUsuarioDAO nuDAO = new NivelUsuarioDAO();
			
			
			usuario.setEmail(JOptionPane.showInputDialog("Email"));
			usuario.setLogin(JOptionPane.showInputDialog("Usuario"));
			usuario.setSenha(JOptionPane.showInputDialog("Senha"));
			usuario.setEndereco(endDAO.getEndereco(Integer.parseInt(JOptionPane.showInputDialog("Codigo do endereco"))));
			usuario.setNivel(nuDAO.getNivelUsuario(Integer.parseInt(JOptionPane.showInputDialog("Codigo do Nivel de Usuario"))));
			dao.addUsuario(usuario);
			
					
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